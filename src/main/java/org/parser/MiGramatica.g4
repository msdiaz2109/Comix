grammar MiGramatica;

@header {
    package org.parser;
}

// ============================================================
// 1. REGLAS SINTÁCTICAS
// ============================================================

// Todo programa comienza con arquitectura, seguido del nombre
// del programa, su bloque de instrucciones y el fin del archivo.
// Ejemplo: arquitectura ClasificadorCacomixtle : ... ;
programa
    : ARQUITECTURA ID bloque EOF
    ;

// Los bloques comienzan con : y terminan con ;.
// Las instrucciones dentro del bloque no llevan ; individualmente.
bloque
    : DOS_PUNTOS instruccion* PUNTO_Y_COMA
    ;

// Instrucciones que se pueden utilizar en Comix.
instruccion
    : declaracionSinapsis
    | ajusteSinapsis
    | ingestaDatos
    | proyeccionSalida
    | decisionEvaluar
    | cicloEntrenar
    ;

// Declara una variable indicando su tipo, nombre y valor inicial.
// Ejemplo: sinapsis peso tasa_alfa <- 0.05
declaracionSinapsis
    : SINAPSIS tipoDato ID ENLACE_SINAPTICO expresion
    ;

// Permite cambiar el valor de una variable existente.
// Ejemplo: ajustar tasa_alfa <- tasa_alfa * 0.90
ajusteSinapsis
    : AJUSTAR ID ENLACE_SINAPTICO expresion
    ;

// Tipos de datos disponibles en Comix:
// indice: números enteros.
// peso: números decimales.
// tensor: vectores y matrices.
// corpus: cadenas de texto.
// pulso: valores activo o inactivo.
tipoDato
    : INDICE
    | PESO
    | TENSOR
    | CORPUS
    | PULSO
    ;

// Permite recibir datos desde una variable o desde un archivo.
// Ejemplos:
// ingestar muestras_lote
// ingestar "dataset.csv" -> muestras_lote
ingestaDatos
    : INGESTAR ID
    | INGESTAR LIT_CORPUS CANAL_INGESTA ID
    ;

// Muestra una o varias expresiones separadas por comas.
// Ejemplo: proyectar "Epoca:", epoca_actual, "Error:", error_perdida
proyeccionSalida
    : PROYECTAR expresion (COMA expresion)*
    ;

// La evaluación debe incluir tres ramas: activar, recalibrar y descartar.
decisionEvaluar
    : EVALUAR expresion
      ACTIVAR bloque
      RECALIBRAR expresion bloque
      DESCARTAR bloque
    ;

// Define el ciclo utilizado para las instrucciones de entrenamiento.
// Ejemplo: entrenar converger 🐒epoca <= 50 && error > 0.01🐵 : ... ;
cicloEntrenar
    : ENTRENAR CONVERGER expresion bloque
    ;

// ============================================================
// 2. EXPRESIONES Y PRECEDENCIA DE OPERADORES
// ============================================================

// La precedencia determina el orden en que se evalúan los operadores.
// Estas reglas van desde la menor precedencia hasta la mayor.

expresion
    : exprDisyuncion
    ;

// Disyunción lógica (||).
// Ejemplo: condicion_a || condicion_b
exprDisyuncion
    : exprConjuncion (DISYUNCION exprConjuncion)*
    ;

// Conjunción lógica (&&), que tiene mayor precedencia que ||.
// Ejemplo: epoca <= 50 && error > 0.01
exprConjuncion
    : exprIgualdad (CONJUNCION exprIgualdad)*
    ;

// Comparaciones de igualdad y diferencia (==, !=).
// Ejemplo: estado == activo
exprIgualdad
    : exprRelacional ((IGUALDAD | DIVERGENCIA) exprRelacional)*
    ;

// Comparaciones relacionales (>=, <=, >, <).
// Ejemplo: confianza >= 0.85
exprRelacional
    : exprTuberia ((MAYOR_IGUAL | MENOR_IGUAL | MAYOR | MENOR) exprTuberia)*
    ;

// Operador de propagación entre capas (~>).
// Ejemplo: (muestras @ pesos + sesgo) ~> capa_activacion
exprTuberia
    : exprAditiva (TUBERIA_CAPA exprAditiva)*
    ;

// Suma y resta (+, -).
// Tienen menor precedencia que la multiplicación.
// Ejemplo: X @ W + b
exprAditiva
    : exprMultiplicativa ((SUMA | RESTA) exprMultiplicativa)*
    ;

// Multiplicación, división y residuo (*, /, %).
// Ejemplo: factor * 0.50
exprMultiplicativa
    : exprMatricial ((MULT | DIV | MOD) exprMatricial)*
    ;

// Producto matricial (@).
// Ejemplo: A @ B
exprMatricial
    : exprPotencia (PROD_MATRICIAL exprPotencia)*
    ;

// Potenciación (^).
// La recursión por la derecha permite expresiones como alfa ^ 2.
exprPotencia
    : exprUnaria (POTENCIA exprPotencia)?
    ;

// Operadores unarios: signo negativo (-) e inhibición (!).
// Ejemplos: -valor, !activo
exprUnaria
    : (RESTA | INHIBICION) exprUnaria
    | exprPrimaria
    ;

// Elementos básicos de una expresión: paréntesis, literales,
// tensores, valores pulso o identificadores.
// Los emojis 🐒 y 🐵 se utilizan para agrupar expresiones.
exprPrimaria
    : PAREN_IZQ expresion PAREN_DER
    | tensorLiteral
    | LIT_PESO
    | LIT_INDICE
    | LIT_CORPUS
    | literalPulso
    | ID
    ;

// Valores permitidos para el tipo pulso.
literalPulso
    : ACTIVO
    | INACTIVO
    ;

// Permite escribir vectores y matrices usando corchetes.
// Ejemplos: [0.5, 0.8] o [[1.0, 0.0], [0.0, 1.0]]
tensorLiteral
    : CORCHETE_IZQ (expresion (COMA expresion)*)? CORCHETE_DER
    ;

// ============================================================
// 3. REGLAS LÉXICAS
// ============================================================

// Palabras reservadas para la estructura y las instrucciones.
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

// Tipos de datos.
INDICE       : 'indice' ;
PESO         : 'peso' ;
TENSOR       : 'tensor' ;
CORPUS       : 'corpus' ;
PULSO        : 'pulso' ;

// Valores del tipo pulso.
ACTIVO       : 'activo' ;
INACTIVO     : 'inactivo' ;

// Emojis utilizados para agrupar expresiones.
PAREN_IZQ    : '🐒' ;
PAREN_DER    : '🐵' ;

// Operadores utilizados en asignaciones y operaciones entre capas.
ENLACE_SINAPTICO : '<-' ;
CANAL_INGESTA    : '->' ;
TUBERIA_CAPA     : '~>' ;
PROD_MATRICIAL   : '@' ;

// Operadores relacionales y de igualdad.
MAYOR_IGUAL  : '>=' ;
MENOR_IGUAL  : '<=' ;
IGUALDAD     : '==' ;
DIVERGENCIA  : '!=' ;
MAYOR        : '>'  ;
MENOR        : '<' ;

// Operadores lógicos.
CONJUNCION   : '&&' ;
DISYUNCION   : '||' ;
INHIBICION   : '!' ;

// Operadores aritméticos.
POTENCIA     : '^' ;
MULT         : '*' ;
DIV          : '/' ;
MOD          : '%' ;
SUMA         : '+' ;
RESTA        : '-' ;

// Símbolos para delimitar bloques, listas y expresiones.
DOS_PUNTOS   : ':' ;
PUNTO_Y_COMA : ';' ;
CORCHETE_IZQ : '[' ;
CORCHETE_DER : ']' ;
COMA         : ',' ;

// Literales e identificadores.
// LIT_PESO admite números decimales con exponente opcional.
// LIT_INDICE admite números enteros.
// LIT_CORPUS admite texto entre comillas dobles.
// ID comienza con una letra o guion bajo.
LIT_PESO
    : [0-9]+ '.' [0-9]+ ([eE] [+-]? [0-9]+)?
    ;

LIT_INDICE
    : [0-9]+
    ;

LIT_CORPUS
    : '"' (~["\r\n\\] | '\\' .)* '"'
    ;

ID
    : [a-zA-Z_] [a-zA-Z0-9_]*
    ;

// Los comentarios comienzan con 🍌.
// Si después de la banana hay un salto de línea, se reconoce
// un comentario de bloque que termina con otra banana.
// Si hay texto en la misma línea, se ignora hasta el salto de línea.
COMENTARIO_BLOQUE
    : '🍌' [ \t]* [\r\n] .*? '🍌' -> skip
    ;

COMENTARIO_LINEA
    : '🍌' ~[\r\n]* -> skip
    ;

// Se ignoran los espacios, tabulaciones y saltos de línea.
ESPACIO_BLANCO
    : [ \t\r\n\f]+ -> skip
    ;