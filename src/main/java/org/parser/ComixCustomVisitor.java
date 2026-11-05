package org.parser;

import java.util.*;

/**
 * Intérprete y evaluador para Comix utilizando el patrón Visitor.
 * Implementa la evaluación de expresiones aritméticas (+, -, *, /),
 * operadores lógicos, asignaciones y control de flujo.
 */
public class ComixCustomVisitor extends ComixBaseVisitor<Object> {

    // Tabla de símbolos / memoria de variables en tiempo de ejecución
    private final Map<String, Object> memoria = new LinkedHashMap<>();

    public Map<String, Object> getMemoria() {
        return memoria;
    }

    // ============================================================
    // 1. ESTRUCTURA PRINCIPAL Y BLOQUES
    // ============================================================

    @Override
    public Object visitPrograma(ComixParser.ProgramaContext ctx) {
        System.out.println("\n[VISITOR] === Iniciando ejecución de la arquitectura: " + ctx.ID().getText() + " ===");
        Object result = visit(ctx.bloque());
        System.out.println("[VISITOR] === Ejecución finalizada con éxito ===\n");
        return result;
    }

    @Override
    public Object visitBloque(ComixParser.BloqueContext ctx) {
        Object ultimoResultado = null;
        for (ComixParser.InstruccionContext inst : ctx.instruccion()) {
            ultimoResultado = visit(inst);
        }
        return ultimoResultado;
    }

    @Override
    public Object visitInstruccion(ComixParser.InstruccionContext ctx) {
        return visitChildren(ctx);
    }

    // ============================================================
    // 2. DECLARACIÓN Y AJUSTE DE SINAPSIS (VARIABLES)
    // ============================================================

    @Override
    public Object visitDeclaracionSinapsis(ComixParser.DeclaracionSinapsisContext ctx) {
        String nombreVar = ctx.ID().getText();
        Object valor = visit(ctx.expresion());
        memoria.put(nombreVar, valor);
        return valor;
    }

    @Override
    public Object visitAjusteSinapsis(ComixParser.AjusteSinapsisContext ctx) {
        String nombreVar = ctx.ID().getText();
        Object valor = visit(ctx.expresion());
        memoria.put(nombreVar, valor);
        return valor;
    }

    // ============================================================
    // 3. ENTRADA Y SALIDA
    // ============================================================

    @Override
    public Object visitProyeccionSalida(ComixParser.ProyeccionSalidaContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append("[PROYECCIÓN] ");
        for (int i = 0; i < ctx.expresion().size(); i++) {
            Object val = visit(ctx.expresion(i));
            sb.append(formatearValor(val));
            if (i < ctx.expresion().size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
        return null;
    }

    @Override
    public Object visitIngestaDatos(ComixParser.IngestaDatosContext ctx) {
        String destino = (ctx.ID() != null) ? ctx.ID().getText() : "desconocido";
        if (ctx.CANAL_INGESTA() != null) {
            System.out.println("[INGESTA] Datos cargados desde " + ctx.LIT_CORPUS().getText() + " hacia '" + destino + "'");
        } else {
            System.out.println("[INGESTA] Ingestando datos hacia '" + destino + "'");
        }
        return null;
    }

    // ============================================================
    // 4. CONTROL DE FLUJO (EVALUAR Y ENTRENAR)
    // ============================================================

    @Override
    public Object visitDecisionEvaluar(ComixParser.DecisionEvaluarContext ctx) {
        // evalua la primera rama: activar
        boolean condActivar = aBooleano(visit(ctx.expresion(0)));
        if (condActivar) {
            return visit(ctx.bloque(0));
        }

        // evalua la segunda rama: recalibrar
        boolean condRecalibrar = aBooleano(visit(ctx.expresion(1)));
        if (condRecalibrar) {
            return visit(ctx.bloque(1));
        }

        // si ninguna se cumple, ejecuta la rama por defecto: descartar
        return visit(ctx.bloque(2));
    }

    @Override
    public Object visitCicloEntrenar(ComixParser.CicloEntrenarContext ctx) {
        int limiteSeguridad = 1000;
        int iteracion = 0;
        while (aBooleano(visit(ctx.expresion())) && iteracion < limiteSeguridad) {
            visit(ctx.bloque());
            iteracion++;
        }
        return null;
    }

    // ============================================================
    // 5. EXPRESIONES ARITMÉTICAS Y OPERADORES (PATRÓN DE CLASE)
    // ============================================================

    @Override
    public Object visitExpresion(ComixParser.ExpresionContext ctx) {
        return visit(ctx.exprDisyuncion());
    }

    @Override
    public Object visitExprDisyuncion(ComixParser.ExprDisyuncionContext ctx) {
        Object result = visit(ctx.exprConjuncion(0));
        for (int i = 1; i < ctx.exprConjuncion().size(); i++) {
            boolean b1 = aBooleano(result);
            boolean b2 = aBooleano(visit(ctx.exprConjuncion(i)));
            result = b1 || b2;
        }
        return result;
    }

    @Override
    public Object visitExprConjuncion(ComixParser.ExprConjuncionContext ctx) {
        Object result = visit(ctx.exprIgualdad(0));
        for (int i = 1; i < ctx.exprIgualdad().size(); i++) {
            boolean b1 = aBooleano(result);
            boolean b2 = aBooleano(visit(ctx.exprIgualdad(i)));
            result = b1 && b2;
        }
        return result;
    }

    @Override
    public Object visitExprIgualdad(ComixParser.ExprIgualdadContext ctx) {
        Object result = visit(ctx.exprRelacional(0));
        for (int i = 1; i < ctx.exprRelacional().size(); i++) {
            String operador = ctx.getChild(i * 2 - 1).getText();
            Object sig = visit(ctx.exprRelacional(i));
            if (operador.equals("==")) {
                result = Objects.equals(result, sig);
            } else if (operador.equals("!=")) {
                result = !Objects.equals(result, sig);
            }
        }
        return result;
    }

    @Override
    public Object visitExprRelacional(ComixParser.ExprRelacionalContext ctx) {
        Object result = visit(ctx.exprTuberia(0));
        for (int i = 1; i < ctx.exprTuberia().size(); i++) {
            String operador = ctx.getChild(i * 2 - 1).getText();
            Object sig = visit(ctx.exprTuberia(i));
            double v1 = aNumero(result);
            double v2 = aNumero(sig);

            switch (operador) {
                case ">":
                    result = v1 > v2;
                    break;
                case "<":
                    result = v1 < v2;
                    break;
                case ">=":
                    result = v1 >= v2;
                    break;
                case "<=":
                    result = v1 <= v2;
                    break;
            }
        }
        return result;
    }

    @Override
    public Object visitExprTuberia(ComixParser.ExprTuberiaContext ctx) {
        // En Comix, ~> propaga el valor de la izquierda hacia la capa derecha
        Object result = visit(ctx.exprAditiva(0));
        for (int i = 1; i < ctx.exprAditiva().size(); i++) {
            result = visit(ctx.exprAditiva(i));
        }
        return result;
    }

    /**
     * ============================================================
     * NIVEL ADITIVO: SUMA (+) Y RESTA (-)
     * ============================================================
     * Este método recorre las expresiones aditivas.
     * Es el equivalente al "visitExpresion" que explicó la maestra en clase.
     */
    @Override
    public Object visitExprAditiva(ComixParser.ExprAditivaContext ctx) {
        // 1. Toma el primer operando (término inicial)
        Object result = visit(ctx.exprMultiplicativa(0));

        // 2. Itera sobre los siguientes operandos intercalados con '+' o '-'
        for (int i = 1; i < ctx.exprMultiplicativa().size(); i++) {
            // Se obtiene el operador que está en la posición impar (1, 3, 5...)
            String operador = ctx.getChild(i * 2 - 1).getText();
            Object sig = visit(ctx.exprMultiplicativa(i));

            // >>> OPERACIÓN: SUMA (+) <<<
            if (operador.equals("+")) {
                result = sumar(result, sig);
            }
            // >>> OPERACIÓN: RESTA (-) <<<
            else if (operador.equals("-")) {
                result = restar(result, sig);
            }
        }
        return result;
    }

    /**
     * ============================================================
     * NIVEL MULTIPLICATIVO: MULTIPLICACIÓN (*) Y DIAGONAL (/)
     * ============================================================
     * [TAREA DE CLASE]: Aquí se agregaron los términos de multiplicación
     * y diagonal (división), además del residuo (%).
     * Es el equivalente al "visitTermino" dejado de tarea.
     */
    @Override
    public Object visitExprMultiplicativa(ComixParser.ExprMultiplicativaContext ctx) {
        // 1. Toma el primer factor
        Object result = visit(ctx.exprMatricial(0));

        // 2. Itera sobre los siguientes factores intercalados con '*', '/' o '%'
        for (int i = 1; i < ctx.exprMatricial().size(); i++) {
            // Se obtiene el operador (* o /) en la posición impar
            String operador = ctx.getChild(i * 2 - 1).getText();
            Object sig = visit(ctx.exprMatricial(i));

            // >>> TAREA: OPERACIÓN MULTIPLICACIÓN (*) <<<
            if (operador.equals("*")) {
                result = multiplicar(result, sig);
            }
            // >>> TAREA: OPERACIÓN DIAGONAL / DIVISIÓN (/) <<<
            else if (operador.equals("/")) {
                result = dividir(result, sig);
            }
            // >>> OPERACIÓN ADICIONAL: MÓDULO / RESIDUO (%) <<<
            else if (operador.equals("%")) {
                result = modulo(result, sig);
            }
        }
        return result;
    }

    @Override
    public Object visitExprMatricial(ComixParser.ExprMatricialContext ctx) {
        Object result = visit(ctx.exprPotencia(0));
        for (int i = 1; i < ctx.exprPotencia().size(); i++) {
            // Producto matricial o ponderación simbólica @
            result = multiplicar(result, visit(ctx.exprPotencia(i)));
        }
        return result;
    }

    @Override
    public Object visitExprPotencia(ComixParser.ExprPotenciaContext ctx) {
        Object base = visit(ctx.exprUnaria());
        if (ctx.POTENCIA() != null) {
            Object exponente = visit(ctx.exprPotencia());
            double b = aNumero(base);
            double exp = aNumero(exponente);
            double res = Math.pow(b, exp);
            if (base instanceof Integer && exponente instanceof Integer && exp >= 0) {
                return (int) res;
            }
            return res;
        }
        return base;
    }

    @Override
    public Object visitExprUnaria(ComixParser.ExprUnariaContext ctx) {
        if (ctx.exprPrimaria() != null) {
            return visit(ctx.exprPrimaria());
        }
        // Operadores unarios: - o !
        Object val = visit(ctx.exprUnaria());
        if (ctx.RESTA() != null) {
            if (val instanceof Integer) return -((Integer) val);
            return -aNumero(val);
        } else if (ctx.INHIBICION() != null) {
            return !aBooleano(val);
        }
        return val;
    }

    @Override
    public Object visitExprPrimaria(ComixParser.ExprPrimariaContext ctx) {
        if (ctx.expresion() != null) {
            // Agrupación de monitos 🐒 expresion 🐵 o ( expresion )
            return visit(ctx.expresion());
        } else if (ctx.LIT_INDICE() != null) {
            return Integer.parseInt(ctx.LIT_INDICE().getText());
        } else if (ctx.LIT_PESO() != null) {
            return Double.parseDouble(ctx.LIT_PESO().getText());
        } else if (ctx.LIT_CORPUS() != null) {
            String texto = ctx.LIT_CORPUS().getText();
            // Quitar comillas dobles
            if (texto.startsWith("\"") && texto.endsWith("\"") && texto.length() >= 2) {
                texto = texto.substring(1, texto.length() - 1);
            }
            return texto;
        } else if (ctx.literalPulso() != null) {
            return visit(ctx.literalPulso());
        } else if (ctx.tensorLiteral() != null) {
            return visit(ctx.tensorLiteral());
        } else if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            if (memoria.containsKey(id)) {
                return memoria.get(id);
            } else {
                System.err.println("Advertencia: Variable no inicializada '" + id + "', usando 0.");
                return 0;
            }
        }
        return 0;
    }

    @Override
    public Object visitLiteralPulso(ComixParser.LiteralPulsoContext ctx) {
        return ctx.ACTIVO() != null;
    }

    @Override
    public Object visitTensorLiteral(ComixParser.TensorLiteralContext ctx) {
        List<Object> elementos = new ArrayList<>();
        for (ComixParser.ExpresionContext expr : ctx.expresion()) {
            elementos.add(visit(expr));
        }
        return elementos;
    }

    // ============================================================
    // 6. MÉTODOS AUXILIARES PARA CÁLCULOS ARITMÉTICOS
    // ============================================================

    // --- OPERACIÓN: SUMA (+) ---
    // Soporta suma entre enteros, decimales y concatenación de texto
    private Object sumar(Object a, Object b) {
        if (a instanceof String || b instanceof String) {
            return formatearValor(a) + formatearValor(b);
        }
        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a + (Integer) b;
        }
        return aNumero(a) + aNumero(b);
    }

    // --- OPERACIÓN: RESTA (-) ---
    // Resta numérica para enteros y decimales
    private Object restar(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a - (Integer) b;
        }
        return aNumero(a) - aNumero(b);
    }

    // --- [TAREA] OPERACIÓN: MULTIPLICACIÓN (*) ---
    // Multiplica dos factores (enteros o flotantes)
    private Object multiplicar(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a * (Integer) b;
        }
        return aNumero(a) * aNumero(b);
    }

    // --- [TAREA] OPERACIÓN: DIAGONAL / DIVISIÓN (/) ---
    // Divide dos factores y previene error de división entre cero
    private Object dividir(Object a, Object b) {
        double divisor = aNumero(b);
        if (divisor == 0.0) {
            System.err.println("Error en ejecución: División entre cero (diagonal /). Se retorna 0.");
            return (a instanceof Integer && b instanceof Integer) ? 0 : 0.0;
        }
        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a / (Integer) b;
        }
        return aNumero(a) / divisor;
    }

    // --- OPERACIÓN: MÓDULO O RESIDUO (%) ---
    private Object modulo(Object a, Object b) {
        int div = (int) aNumero(b);
        if (div == 0) return 0;
        return ((int) aNumero(a)) % div;
    }

    private double aNumero(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj) ? 1.0 : 0.0;
        }
        return 0.0;
    }

    private boolean aBooleano(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        } else if (obj instanceof Number) {
            return ((Number) obj).doubleValue() != 0.0;
        }
        return obj != null;
    }

    private String formatearValor(Object val) {
        if (val == null) {
            return "nulo";
        }
        if (val instanceof Boolean) {
            return ((Boolean) val) ? "activo" : "inactivo";
        }
        return String.valueOf(val);
    }
}
