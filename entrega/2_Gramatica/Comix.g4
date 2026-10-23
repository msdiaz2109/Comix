grammar Comix;

@header {
    package org.parser;
}

// ============================================================
// 1. REGLAS SINTÁCTICAS (PARSER)
// ============================================================

// PROGRAMA PRINCIPAL (Punto de entrada)
// Todo archivo .cmx inicia obligatoriamente con la palabra 'arquitectura',
// seguida del identificador del programa, su bloque y el fin de archivo (EOF).
// Ejemplo: arquitectura ClasificadorCacomixtle : ... ;
programa
    : ARQUITECTURA ID bloque EOF
    ;

// DELIMITACIÓN DE BLOQUES (Simetría limpia con ':' y ';')
// Todo bloque (de la arquitectura, del ciclo o de las condiciones)
// se abre con ':' y se cierra exclusivamente con ';'.
// Regla clave: Las instrucciones simples de una línea NO llevan ';' al final.
bloque
    : DOS_PUNTOS instruccion* PUNTO_Y_COMA
    ;

// CATÁLOGO DE INSTRUCCIONES DISPONIBLES
// Define todo lo que se puede escribir dentro de un bloque en Comix:
instruccion
    : declaracionSinapsis
    | ajusteSinapsis
    | ingestaDatos
    | proyeccionSalida
    | decisionEvaluar
    | cicloEntrenar
    ;

// DECLARACIÓN DE VARIABLES (Sinapsis)
// Equivale a crear una variable tipada en memoria.
// Sintaxis: sinapsis <tipo> <nombre> <- <expresion>
// Ejemplo:  sinapsis peso tasa_alfa <- 0.05
declaracionSinapsis
    : SINAPSIS tipoDato ID ENLACE_SINAPTICO expresion
    ;

// RECALIBRACIÓN / ACTUALIZACIÓN (Ajuste)
// Equivale a reasignar o modificar una variable ya existente.
// Sintaxis: ajustar <nombre> <- <expresion>
// Ejemplo:  ajustar tasa_alfa <- tasa_alfa * 0.90
ajusteSinapsis
    : AJUSTAR ID ENLACE_SINAPTICO expresion
    ;

// TIPOS DE DATOS PROPIOS (5 tipos nativos de Machine Learning)
// - indice: Entero discreto para épocas, lotes y conteos.
// - peso:   Decimal de punto flotante para sesgos, tasas y pérdidas.
// - tensor: Vectores y matrices (ej. [0.5, 0.8] o [[1.0, 0.0], [0.0, 1.0]]).
// - corpus: Secuencia de texto inmutable (rutas, etiquetas).
// - pulso:  Estado binario sináptico (solo admite 'activo' o 'inactivo').
tipoDato
    : INDICE
    | PESO
    | TENSOR
    | CORPUS
    | PULSO
    ;

// ENTRADA DE DATOS (Ingesta)
// Permite recibir datos desde consola o canalizar archivos hacia una sinapsis.
// Ejemplo 1 (Consola): ingestar muestras_lote
// Ejemplo 2 (Archivo): ingestar "dataset.csv" -> muestras_lote
ingestaDatos
    : INGESTAR ID
    | INGESTAR LIT_CORPUS CANAL_INGESTA ID
    ;

// SALIDA DE DATOS (Proyección a pantalla / telemetría)
// Equivale a imprimir resultados en consola, separados por comas.
// Ejemplo: proyectar "Epoca:", epoca_actual, "Error:", error_perdida
proyeccionSalida
    : PROYECTAR expresion (COMA expresion)*
    ;

// ESTRUCTURA DE DECISIÓN OBLIGATORIA DE 3 CAMINOS (Evaluación)
// Diseñada para clasificaciones de Machine Learning con tres regímenes:
// 1. activar:    La métrica supera el umbral alto (confianza óptima).
// 2. recalibrar: La métrica cae en zona intermedia (reajustar parámetros).
// 3. descartar:  Camino por defecto ante subajuste, anomalía o error crítico.
decisionEvaluar
    : EVALUAR expresion
      ACTIVAR bloque
      RECALIBRAR expresion bloque
      DESCARTAR bloque
    ;

// CICLO DE REPETICIÓN POR ÉPOCAS (Entrenamiento y convergencia)
// Repite el bloque de instrucciones iterativamente mientras se busque convergencia.
// La condición se agrupa entre monitos 🐒 ... 🐵.
// Ejemplo: entrenar converger 🐒epoca <= 50 && error > 0.01🐵 : ... ;
cicloEntrenar
    : ENTRENAR CONVERGER expresion bloque
    ;

// ============================================================
// 2. EXPRESIONES Y PRECEDENCIA DE OPERADORES (12 NIVELES)
// En ANTLR4, la precedencia se define de menor a mayor prioridad:
// Al evaluar una expresión matemática, se desciende desde el operador
// con menor precedencia (||) hasta los de mayor precedencia (monitos 🐒 🐵).
// ============================================================

expresion
    : exprDisyuncion
    ;

// Nivel 11 (Menor precedencia lógica): Disyunción lógica (||)
// Ejemplo: condicion_a || condicion_b
exprDisyuncion
    : exprConjuncion (DISYUNCION exprConjuncion)*
    ;

// Nivel 10: Conjunción lógica (&&)
// Se evalúa antes que el OR: epoca <= 50 && error > 0.01
exprConjuncion
    : exprIgualdad (CONJUNCION exprIgualdad)*
    ;

// Nivel 9: Comparaciones de igualdad y divergencia (==, !=)
// Ejemplo: estado == activo
exprIgualdad
    : exprRelacional ((IGUALDAD | DIVERGENCIA) exprRelacional)*
    ;

// Nivel 8: Comparadores de umbral (>=, <=, >, <)
// Ejemplo: confianza >= 0.85
exprRelacional
    : exprTuberia ((MAYOR_IGUAL | MENOR_IGUAL | MAYOR | MENOR) exprTuberia)*
    ;

// Nivel 7: Tubería de propagación de capas (~>)
// Propaga el cálculo de una capa hacia la siguiente (forward pass).
// Ejemplo: (muestras @ pesos + sesgo) ~> capa_activacion
exprTuberia
    : exprAditiva (TUBERIA_CAPA exprAditiva)*
    ;

// Nivel 6: Suma y resta binaria (+, -)
// Se ejecutan después de multiplicaciones: X @ W + b
exprAditiva
    : exprMultiplicativa ((SUMA | RESTA) exprMultiplicativa)*
    ;

// Nivel 5: Multiplicación escalar, división y residuo (*, /, %)
// Ejemplo: factor * 0.50
exprMultiplicativa
    : exprMatricial ((MULT | DIV | MOD) exprMatricial)*
    ;

// Nivel 4: Producto matricial nativo (@)
// Multiplica matrices y vectores algebraicos antes de sumar sesgos: A @ B
exprMatricial
    : exprPotencia (PROD_MATRICIAL exprPotencia)*
    ;

// Nivel 3: Potenciación (^)
// Asociativa por la DERECHA: base ^ exponente (ej. alfa ^ 2)
exprPotencia
    : exprUnaria (POTENCIA exprPotencia)?
    ;

// Nivel 2: Operadores unarios prefijos (-, !)
// Inversión aritmética (-valor) e inhibición lógica (!activo).
exprUnaria
    : (RESTA | INHIBICION) exprUnaria
    | exprPrimaria
    ;

// Nivel 1 (Máxima precedencia): Átomos, literales y agrupación
// Los paréntesis de monitos 🐒 🐵 fuerzan el orden prioritario de evaluación.
exprPrimaria
    : PAREN_IZQ expresion PAREN_DER
    | tensorLiteral
    | LIT_PESO
    | LIT_INDICE
    | LIT_CORPUS
    | literalPulso
    | ID
    ;

// Literales booleanos propios del dominio sináptico
literalPulso
    : ACTIVO
    | INACTIVO
    ;

// Construcción literal de tensores (vectores [x, y] y matrices [[a, b], [c, d]])
tensorLiteral
    : CORCHETE_IZQ (expresion (COMA expresion)*)? CORCHETE_DER
    ;

// ============================================================
// 3. REGLAS LÉXICAS (LEXER / TOKENS)
// ============================================================

// Palabras reservadas: Control de flujo y estructura
ARQUITECTURA : 'arquitectura' ;
SINAPSIS     : 'sinapsis' ;
AJUSTAR      : 'ajustar' ;
EVALUAR      : 'evaluar' ;
ACTIVAR      : 'activar' ;
RECALIBRAR   : 'recalibrar' ;
DESCARTAR    : 'descartar' ;
ENTRENAR     : 'entrenar' ;
CONVERGER    : 'converger' ;
INGESTAR     : 'ingestar' ;
PROYECTAR    : 'proyectar' ;

// Palabras reservadas: Tipos de datos
INDICE       : 'indice' ;
PESO         : 'peso' ;
TENSOR       : 'tensor' ;
CORPUS       : 'corpus' ;
PULSO        : 'pulso' ;

// Literales del tipo pulso
ACTIVO       : 'activo' ;
INACTIVO     : 'inactivo' ;

// Símbolos de agrupación propios: Emojis de Monitos
// 🐒 abre paréntesis (U+1F412) y 🐵 cierra paréntesis (U+1F435).
PAREN_IZQ    : '🐒' ;
PAREN_DER    : '🐵' ;

// Operadores de enlace y flujo de Machine Learning
ENLACE_SINAPTICO : '<-' ; // Vincula un valor a una sinapsis
CANAL_INGESTA    : '->' ; // Canaliza archivo hacia variable en ingestar
TUBERIA_CAPA     : '~>' ; // Propaga un tensor a la siguiente capa
PROD_MATRICIAL   : '@'  ; // Multiplicación o producto matricial

// Operadores relacionales y de igualdad
MAYOR_IGUAL  : '>=' ;
MENOR_IGUAL  : '<=' ;
IGUALDAD     : '==' ;
DIVERGENCIA  : '!=' ;
MAYOR        : '>'  ;
MENOR        : '<'  ;

// Operadores lógicos
CONJUNCION   : '&&' ;
DISYUNCION   : '||' ;
INHIBICION   : '!'  ;

// Operadores aritméticos
POTENCIA     : '^' ;
MULT         : '*' ;
DIV          : '/' ;
MOD          : '%' ;
SUMA         : '+' ;
RESTA        : '-' ;

// Delimitadores de sintaxis
DOS_PUNTOS   : ':' ;
PUNTO_Y_COMA : ';' ;
CORCHETE_IZQ : '[' ;
CORCHETE_DER : ']' ;
COMA         : ',' ;

// Literales e Identificadores
// - LIT_PESO: Requiere parte entera, punto y decimales (ej. 0.05, 1.2e-4).
// - LIT_INDICE: Uno o más dígitos enteros (ej. 1, 50).
// - LIT_CORPUS: Cadenas de texto entre comillas dobles.
// - ID: Letra o guión bajo seguido de alfanuméricos.
LIT_PESO     : [0-9]+ '.' [0-9]+ ([eE] [+-]? [0-9]+)? ;
LIT_INDICE   : [0-9]+ ;
LIT_CORPUS   : '"' (~["\r\n\\] | '\\' .)* '"' ;
ID           : [a-zA-Z_] [a-zA-Z0-9_]* ;

// Comentarios con Emoji de Banana 🍌
// Si la banana está al final de línea (seguida de salto de línea), abre bloque multilínea.
// Si tiene texto en la misma línea, es comentario de una sola línea hasta el salto.
COMENTARIO_BLOQUE : '🍌' [ \t]* [\r\n] .*? '🍌' -> skip ;
COMENTARIO_LINEA  : '🍌' ~[\r\n]* -> skip ;

// Espacios en blanco, tabulaciones y saltos de línea (se descartan)
ESPACIO_BLANCO    : [ \t\r\n\f]+ -> skip ;
