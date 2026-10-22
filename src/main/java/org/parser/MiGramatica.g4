grammar MiGramatica;

@header {
    package org.parser;
}

// ==========================================
// 1. REGLAS SINTÁCTICAS (PARSER) - COMIX
// ==========================================

// Regla raíz: una arquitectura nombrada seguida del fin de archivo.
programa
    : ARQUITECTURA ID bloque EOF
    ;

// Bloque compuesto: delimitado simétricamente con ':' de inicio y ';' de fin.
bloque
    : DOS_PUNTOS instruccion* PUNTO_Y_COMA
    ;

// Instrucciones soportadas en el lenguaje Comix.
instruccion
    : declaracionSinapsis
    | ajusteSinapsis
    | ingestaDatos
    | proyeccionSalida
    | decisionEvaluar
    | cicloEntrenar
    ;

// Declaración de una sinapsis: sinapsis <tipo> <id> <- <expresion>
declaracionSinapsis
    : SINAPSIS tipoDato ID ENLACE_SINAPTICO expresion
    ;

// Ajuste o recalibración de una sinapsis existente: ajustar <id> <- <expresion>
ajusteSinapsis
    : AJUSTAR ID ENLACE_SINAPTICO expresion
    ;

// Tipos de datos propios del dominio de Machine Learning
tipoDato
    : INDICE
    | PESO
    | TENSOR
    | CORPUS
    | PULSO
    ;

// Ingesta de datos (desde consola o archivo hacia una sinapsis)
ingestaDatos
    : INGESTAR ID
    | INGESTAR LIT_CORPUS CANAL_INGESTA ID
    ;

// Proyección de resultados (salida a consola o telemetría)
proyeccionSalida
    : PROYECTAR expresion (COMA expresion)*
    ;

// Estructura de decisión obligatoria de tres caminos: activar / recalibrar / descartar
decisionEvaluar
    : EVALUAR expresion
      ACTIVAR bloque
      RECALIBRAR expresion bloque
      DESCARTAR bloque
    ;

// Ciclo de repetición iterativo por épocas hasta converger
cicloEntrenar
    : ENTRENAR CONVERGER expresion bloque
    ;

// ==========================================
// 2. EXPRESIONES Y PRECEDENCIA (12 NIVELES)
// ==========================================

expresion
    : exprDisyuncion
    ;

// Nivel 11: Disyunción lógica (||)
exprDisyuncion
    : exprConjuncion (DISYUNCION exprConjuncion)*
    ;

// Nivel 10: Conjunción lógica (&&)
exprConjuncion
    : exprIgualdad (CONJUNCION exprIgualdad)*
    ;

// Nivel 9: Igualdad y divergencia (==, !=)
exprIgualdad
    : exprRelacional ((IGUALDAD | DIVERGENCIA) exprRelacional)*
    ;

// Nivel 8: Operaciones relacionales (>=, <=, >, <)
exprRelacional
    : exprTuberia ((MAYOR_IGUAL | MENOR_IGUAL | MAYOR | MENOR) exprTuberia)*
    ;

// Nivel 7: Tubería de propagación de capas de red (~>)
exprTuberia
    : exprAditiva (TUBERIA_CAPA exprAditiva)*
    ;

// Nivel 6: Suma y resta binaria (+, -)
exprAditiva
    : exprMultiplicativa ((SUMA | RESTA) exprMultiplicativa)*
    ;

// Nivel 5: Multiplicación, división y módulo (*, /, %)
exprMultiplicativa
    : exprMatricial ((MULT | DIV | MOD) exprMatricial)*
    ;

// Nivel 4: Producto matricial (@)
exprMatricial
    : exprPotencia (PROD_MATRICIAL exprPotencia)*
    ;

// Nivel 3: Potenciación (^), asociativa por la derecha
exprPotencia
    : exprUnaria (POTENCIA exprPotencia)?
    ;

// Nivel 2: Operadores unarios prefijos (-, !)
exprUnaria
    : (RESTA | INHIBICION) exprUnaria
    | exprPrimaria
    ;

// Nivel 1: Elementos primarios, literales y agrupación con monitos
exprPrimaria
    : PAREN_IZQ expresion PAREN_DER
    | tensorLiteral
    | LIT_PESO
    | LIT_INDICE
    | LIT_CORPUS
    | literalPulso
    | ID
    ;

// Literal booleano sináptico
literalPulso
    : ACTIVO
    | INACTIVO
    ;

// Literales tensoriales (vectores y matrices)
tensorLiteral
    : CORCHETE_IZQ (expresion (COMA expresion)*)? CORCHETE_DER
    ;

// ==========================================
// 3. REGLAS LÉXICAS (LEXER)
// ==========================================

// Palabras reservadas de estructura y flujo
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

// Palabras reservadas de tipos de datos
INDICE       : 'indice' ;
PESO         : 'peso' ;
TENSOR       : 'tensor' ;
CORPUS       : 'corpus' ;
PULSO        : 'pulso' ;

// Literales de pulso
ACTIVO       : 'activo' ;
INACTIVO     : 'inactivo' ;

// Delimitadores de agrupación con Emojis de Monitos
PAREN_IZQ    : '🐒' ;
PAREN_DER    : '🐵' ;

// Operadores de enlace, canalización y propagación de ML
ENLACE_SINAPTICO : '<-' ;
CANAL_INGESTA    : '->' ;
TUBERIA_CAPA     : '~>' ;
PROD_MATRICIAL   : '@' ;

// Operadores relacionales y de igualdad
MAYOR_IGUAL  : '>=' ;
MENOR_IGUAL  : '<=' ;
IGUALDAD     : '==' ;
DIVERGENCIA  : '!=' ;
MAYOR        : '>' ;
MENOR        : '<' ;

// Operadores lógicos
CONJUNCION   : '&&' ;
DISYUNCION   : '||' ;
INHIBICION   : '!' ;

// Operadores aritméticos
POTENCIA     : '^' ;
MULT         : '*' ;
DIV          : '/' ;
MOD          : '%' ;
SUMA         : '+' ;
RESTA        : '-' ;

// Delimitadores sintácticos
DOS_PUNTOS   : ':' ;
PUNTO_Y_COMA : ';' ;
CORCHETE_IZQ : '[' ;
CORCHETE_DER : ']' ;
COMA         : ',' ;

// Literales e identificadores
LIT_PESO     : [0-9]+ '.' [0-9]+ ([eE] [+-]? [0-9]+)? ;
LIT_INDICE   : [0-9]+ ;
LIT_CORPUS   : '"' (~["\r\n\\] | '\\' .)* '"' ;
ID           : [a-zA-Z_] [a-zA-Z0-9_]* ;

// Comentarios con Emoji de Banana 🍌 y Espacios en blanco
COMENTARIO_BLOQUE : '🍌' [ \t]* [\r\n] .*? '🍌' -> skip ;
COMENTARIO_LINEA  : '🍌' ~[\r\n]* -> skip ;
ESPACIO_BLANCO    : [ \t\r\n\f]+ -> skip ;