package org.parser;

import java.util.*;

/**
 * ============================================================================
 * CLASE: ComixCustomVisitor (Intérprete Completo de Comix con ANTLR4)
 * ============================================================================
 * Esta clase implementa el patrón Visitor extendiendo de ComixBaseVisitor<Object>.
 * Funciona como el intérprete en tiempo de ejecución del lenguaje Comix,
 * cumpliendo con todos los requerimientos de la especificación:
 * 
 * 1. Tabla de Símbolos / Memoria (Map<String, Object> memoria con GET y PUT).
 * 2. Valores por defecto en declaraciones no inicializadas (int=0, float=0.0, bool=false, str="").
 * 3. Asignaciones con actualización en memoria.
 * 4. Lectura de factores/identificadores con memoria.get(id).
 * 5. Evaluación aritmética (+, -, *, /) con precedencia y división protegida contra 0.
 * 6. Soporte para enteros, flotantes (double) y concatenación de cadenas.
 * 7. Comparaciones relacionales (>, <, >=, <=, ==, !=) devolviendo booleanos.
 * 8. Sentencias de impresión ([PRINT] <valor>).
 * 9. Control de flujo condicional (if / elseIf / else).
 * 10. Control de flujo repetitivo (ciclos / bucles).
 * 11. Formato exacto de trazado en consola línea por línea y estado final de variables.
 */
public class ComixCustomVisitor extends ComixBaseVisitor<Object> {

    // ============================================================
    // 1. TABLA DE SÍMBOLOS / MEMORIA DEL PROGRAMA
    // ============================================================
    private final Map<String, Object> memoria = new LinkedHashMap<>();

    public Map<String, Object> getMemoria() {
        return memoria;
    }

    // ============================================================
    // 2. RECORRIDO DEL PROGRAMA PRINCIPAL Y BLOQUES
    // ============================================================

    @Override
    public Object visitPrograma(ComixParser.ProgramaContext ctx) {
        int totalInstrucciones = (ctx.bloque() != null && ctx.bloque().instruccion() != null)
                ? ctx.bloque().instruccion().size()
                : 0;

        // Formato exacto de inicio requerido
        System.out.println("=== INICIANDO RECORRIDO CON CUSTOM VISITOR ===");
        System.out.println("-> Visitando programa con " + totalInstrucciones + " instruccion(es).");

        // Ejecutar las instrucciones del bloque principal
        Object resultado = visit(ctx.bloque());

        // Formato exacto de cierre requerido con el estado final de las variables
        System.out.println("=== ESTADO FINAL DE VARIABLES: " + memoria + " ===");

        return resultado;
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
    // 3. DECLARACIONES Y ASIGNACIONES (PUT EN MEMORIA)
    // ============================================================

    /**
     * DECLARACIÓN DE VARIABLES:
     * Si no tiene valor inicial asignado, se le da un valor por defecto:
     * - indice / int   -> 0
     * - peso / float   -> 0.0
     * - corpus / str   -> ""
     * - pulso / bool   -> false
     * - tensor / lista -> []
     * Si tiene expresión inicial, se evalúa y se guarda con memoria.put(id, valor).
     */
    @Override
    public Object visitDeclaracionSinapsis(ComixParser.DeclaracionSinapsisContext ctx) {
        int linea = ctx.getStart().getLine();
        String tipo = ctx.tipoDato().getText();
        String id = ctx.ID().getText();

        Object valor;
        if (ctx.expresion() != null) {
            valor = visit(ctx.expresion());
        } else {
            valor = obtenerValorPorDefecto(tipo);
        }

        // PUT a nivel de declaración
        memoria.put(id, valor);

        // Formato exacto requerido: Linea X: [Declaración] <tipo> <id> = <valor>
        System.out.printf("Linea %d: [Declaración] %s %s = %s%n", linea, tipo, id, formatearValor(valor));
        return valor;
    }

    /**
     * ASIGNACIÓN DE VARIABLES:
     * Evalúa la expresión a la derecha de <- y actualiza el valor en memoria con memoria.put(id, valor).
     */
    @Override
    public Object visitAjusteSinapsis(ComixParser.AjusteSinapsisContext ctx) {
        int linea = ctx.getStart().getLine();
        String id = ctx.ID().getText();

        // Evalúa la expresión
        Object valor = visit(ctx.expresion());

        // PUT a nivel de asignación
        memoria.put(id, valor);

        // Formato exacto requerido: Linea X: [Asignación] <id> = <valor>
        System.out.printf("Linea %d: [Asignación] %s = %s%n", linea, id, formatearValor(valor));
        return valor;
    }

    // ============================================================
    // 4. SENTENCIA DE IMPRESIÓN (PRINT)
    // ============================================================

    /**
     * IMPRESIÓN (proyectar en Comix / print):
     * Evalúa las expresiones a imprimir y las muestra en consola.
     */
    @Override
    public Object visitProyeccionSalida(ComixParser.ProyeccionSalidaContext ctx) {
        int linea = ctx.getStart().getLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ctx.expresion().size(); i++) {
            Object val = visit(ctx.expresion(i));
            sb.append(formatearValor(val));
            if (i < ctx.expresion().size() - 1) {
                sb.append(" ");
            }
        }

        // Formato exacto requerido: Linea X: [PRINT] <valor>
        System.out.printf("Linea %d: [PRINT] %s%n", linea, sb.toString());
        return null;
    }

    @Override
    public Object visitIngestaDatos(ComixParser.IngestaDatosContext ctx) {
        int linea = ctx.getStart().getLine();
        String destino = (ctx.ID() != null) ? ctx.ID().getText() : "desconocido";
        if (ctx.CANAL_INGESTA() != null) {
            System.out.printf("Linea %d: [Ingesta] %s -> %s%n", linea, ctx.LIT_CORPUS().getText(), destino);
        } else {
            System.out.printf("Linea %d: [Ingesta] %s%n", linea, destino);
        }
        return null;
    }

    // ============================================================
    // 5. CONTROL DE FLUJO: IF / ELSE IF / ELSE Y BUCLES
    // ============================================================

    /**
     * ESTRUCTURA CONDICIONAL (IF / ELSE IF / ELSE):
     * En Comix:
     * - evaluar <exp1> activar <bloque1>          -> if (cond1) { bloque1 }
     * - recalibrar <exp2> <bloque2>               -> else if (cond2) { bloque2 }
     * - descartar <bloque3>                       -> else { bloque3 }
     */
    @Override
    public Object visitDecisionEvaluar(ComixParser.DecisionEvaluarContext ctx) {
        int linea = ctx.getStart().getLine();

        // 1. Evalúa la condición principal del IF (evaluar)
        Object condIf = visit(ctx.expresion(0));
        if (aBooleano(condIf)) {
            System.out.printf("Linea %d: [IF] Condición verdadera -> ejecutando rama principal%n", linea);
            return visit(ctx.bloque(0));
        }

        // 2. Si es falsa, evalúa los elseIf en orden (recalibrar)
        if (ctx.expresion().size() > 1 && ctx.bloque().size() > 1) {
            Object condElseIf = visit(ctx.expresion(1));
            if (aBooleano(condElseIf)) {
                System.out.printf("Linea %d: [ELSE IF] Condición verdadera -> ejecutando rama alterna%n", linea);
                return visit(ctx.bloque(1));
            }
        }

        // 3. Si ninguno se cumple, ejecuta el bloque ELSE (descartar)
        if (ctx.bloque().size() > 2) {
            System.out.printf("Linea %d: [ELSE] Ninguna condición previa se cumplió -> ejecutando rama por defecto%n", linea);
            return visit(ctx.bloque(2));
        }

        return null;
    }

    /**
     * BUCLE REPETITIVO (for / while / entrenar converger):
     * Evalúa la condición antes de cada iteración y ejecuta el bloque mientras sea verdadera.
     */
    @Override
    public Object visitCicloEntrenar(ComixParser.CicloEntrenarContext ctx) {
        int linea = ctx.getStart().getLine();
        int limiteSeguridad = 1000;
        int iteracion = 0;

        System.out.printf("Linea %d: [Bucle] Iniciando ejecución del ciclo%n", linea);
        while (aBooleano(visit(ctx.expresion())) && iteracion < limiteSeguridad) {
            visit(ctx.bloque());
            iteracion++;
        }
        return null;
    }

    // ============================================================
    // 6. EVALUACIÓN DE EXPRESIONES ARITMÉTICAS Y LÓGICAS
    // ============================================================

    @Override
    public Object visitExpresion(ComixParser.ExpresionContext ctx) {
        return visit(ctx.exprDisyuncion());
    }

    // Disyunción lógica (||)
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

    // Conjunción lógica (&&)
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

    // Comparaciones de igualdad y diferencia (==, !=)
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

    // Comparaciones relacionales (>, <, >=, <=)
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
        Object result = visit(ctx.exprAditiva(0));
        for (int i = 1; i < ctx.exprAditiva().size(); i++) {
            result = visit(ctx.exprAditiva(i));
        }
        return result;
    }

    /**
     * NIVEL ADITIVO (SUMA '+' Y RESTA '-'):
     * - Suma aritmética si ambos son números.
     * - Concatenación de cadenas si alguno de los operandos es String (str).
     * - Resta aritmética numérica.
     */
    @Override
    public Object visitExprAditiva(ComixParser.ExprAditivaContext ctx) {
        Object result = visit(ctx.exprMultiplicativa(0));
        for (int i = 1; i < ctx.exprMultiplicativa().size(); i++) {
            String operador = ctx.getChild(i * 2 - 1).getText();
            Object sig = visit(ctx.exprMultiplicativa(i));

            if (operador.equals("+")) {
                result = sumar(result, sig);
            } else if (operador.equals("-")) {
                result = restar(result, sig);
            }
        }
        return result;
    }

    /**
     * NIVEL MULTIPLICATIVO (MULTIPLICACIÓN '*' Y DIVISIÓN '/'):
     * - Multiplicación y división respetando precedencia.
     * - Validación de división entre cero para evitar caídas.
     */
    @Override
    public Object visitExprMultiplicativa(ComixParser.ExprMultiplicativaContext ctx) {
        Object result = visit(ctx.exprMatricial(0));
        for (int i = 1; i < ctx.exprMatricial().size(); i++) {
            String operador = ctx.getChild(i * 2 - 1).getText();
            Object sig = visit(ctx.exprMatricial(i));

            if (operador.equals("*")) {
                result = multiplicar(result, sig);
            } else if (operador.equals("/")) {
                result = dividir(result, sig);
            } else if (operador.equals("%")) {
                result = modulo(result, sig);
            }
        }
        return result;
    }

    @Override
    public Object visitExprMatricial(ComixParser.ExprMatricialContext ctx) {
        Object result = visit(ctx.exprPotencia(0));
        for (int i = 1; i < ctx.exprPotencia().size(); i++) {
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
        Object val = visit(ctx.exprUnaria());
        if (ctx.RESTA() != null) {
            if (val instanceof Integer) return -((Integer) val);
            return -aNumero(val);
        } else if (ctx.INHIBICION() != null) {
            return !aBooleano(val);
        }
        return val;
    }

    /**
     * FACTORES E IDENTIFICADORES (GET EN MEMORIA):
     * Cuando se encuentra un ID en una expresión, se recupera con memoria.get(id).
     */
    @Override
    public Object visitExprPrimaria(ComixParser.ExprPrimariaContext ctx) {
        if (ctx.expresion() != null) {
            return visit(ctx.expresion());
        } else if (ctx.LIT_INDICE() != null) {
            return Integer.parseInt(ctx.LIT_INDICE().getText());
        } else if (ctx.LIT_PESO() != null) {
            return Double.parseDouble(ctx.LIT_PESO().getText());
        } else if (ctx.LIT_CORPUS() != null) {
            String texto = ctx.LIT_CORPUS().getText();
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

            // >>> GET A NIVEL DE FACTOR (RECUPERACIÓN DESDE MEMORIA) <<<
            if (memoria.containsKey(id)) {
                return memoria.get(id);
            } else {
                System.err.printf("Advertencia: Variable '%s' no encontrada en memoria. Usando valor 0.%n", id);
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
    // 7. MÉTODOS AUXILIARES ARITMÉTICOS Y TIPOS
    // ============================================================

    // Valor por defecto según el tipo solicitado
    private Object obtenerValorPorDefecto(String tipo) {
        String t = tipo.toLowerCase();
        if (t.contains("indice") || t.contains("int")) {
            return 0;
        } else if (t.contains("peso") || t.contains("float") || t.contains("double")) {
            return 0.0;
        } else if (t.contains("pulso") || t.contains("bool")) {
            return false;
        } else if (t.contains("corpus") || t.contains("str")) {
            return "";
        } else if (t.contains("tensor")) {
            return new ArrayList<>();
        }
        return 0;
    }

    // Suma con soporte de concatenación si alguno es String
    private Object sumar(Object a, Object b) {
        if (a instanceof String || b instanceof String) {
            return formatearValor(a) + formatearValor(b);
        }
        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a + (Integer) b;
        }
        return aNumero(a) + aNumero(b);
    }

    // Resta numérica (entero o flotante double)
    private Object restar(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a - (Integer) b;
        }
        return aNumero(a) - aNumero(b);
    }

    // Multiplicación (entero o flotante double)
    private Object multiplicar(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (Integer) a * (Integer) b;
        }
        return aNumero(a) * aNumero(b);
    }

    // División con validación de división entre cero
    private Object dividir(Object a, Object b) {
        double divisor = aNumero(b);
        if (divisor == 0.0) {
            System.err.println("Error en ejecución: División entre cero (/ detectado). Se retorna 0.");
            return (a instanceof Integer && b instanceof Integer) ? 0 : 0.0;
        }
        if (a instanceof Integer && b instanceof Integer && ((Integer) a) % ((Integer) b) == 0) {
            return ((Integer) a) / ((Integer) b);
        }
        return aNumero(a) / divisor;
    }

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
        if (val == null) return "nulo";
        if (val instanceof Boolean) {
            return ((Boolean) val) ? "true" : "false";
        }
        return String.valueOf(val);
    }
}
