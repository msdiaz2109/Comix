# Bitácora de Desarrollo y Depuración — Lenguaje Comix (.cmx)

| Campo | Detalle |
| --- | --- |
| **Materia** | Lenguajes y Autómatas II |
| **Docente** | M.S.C. Alma Lilia Núñez González |
| **Equipo diseñador** | ComixTech |
| **Lenguaje** | Comix |
| **Extensión** | `.cmx` |
| **Fase** | Fase 4: Bitácora de Desarrollo (Evidencias de Diseño y Depuración) |

---

## Incidencia 1: Ambigüedad léxica entre comentarios de bloque y de línea con Emoji Banana (🍌)

- **Fecha y hora:** 22/10/2026 — 15:45
- **Problema detectado:** Al analizar archivos de prueba con comentarios de una línea y comentarios multilínea, el lexer de ANTLR4 absorbía bloques completos de código fuente válido ubicados entre comentarios de una línea distintos. Por ejemplo, en los casos de prueba, el código entre un comentario de línea y otro comentario posterior era ignorado por completo, lo que provocaba errores sintácticos inesperados como instrucciones faltantes o fallas al reconocer ramas condicionales.
- **Mensaje emitido por ANTLR:**
  ```text
  [SINTÁCTICO] Línea 8:41 -> mismatched input 'ERROR' expecting <EOF>
  [LÉXICO] Línea 8:64 -> token recognition error at: '\''
  ```
- **Interpretación del problema:** Ambos tipos de comentarios iniciaban con el mismo lexema (`🍌`). La regla de bloque utilizaba `'🍌' .*? '🍌' -> skip`, permitiendo que el operador no codicioso `.*?` cruzara saltos de línea y capturara desde el `🍌` de un comentario de una línea hasta el `🍌` del siguiente comentario en una línea muy posterior, tragándose todo el código fuente intermedio.
- **Solución propuesta y justificación:** Condicionar la regla `COMENTARIO_BLOQUE` para que requiera estrictamente que el emoji `🍌` de apertura esté inmediatamente seguido de un salto de línea (`[ \t]* [\r\n]`). De este modo, si la banana tiene texto en la misma línea, coincide de forma determinista con `COMENTARIO_LINEA`, preservando la identidad del emoji sin ambigüedad en el Lexer.
- **Fragmento de gramática anterior:**
  ```antlr
  COMENTARIO_BLOQUE : '🍌' .*? '🍌' -> skip ;
  COMENTARIO_LINEA  : '🍌' ~[\r\n]* -> skip ;
  ```
- **Fragmento corregido:**
  ```antlr
  COMENTARIO_BLOQUE : '🍌' [ \t]* [\r\n] .*? '🍌' -> skip ;
  COMENTARIO_LINEA  : '🍌' ~[\r\n]* -> skip ;
  ```
- **Resultado obtenido:** Se eliminó por completo la ambigüedad. Los comentarios de bloque y de una sola línea se reconocen y descartan limpiamente sin afectar ninguna instrucción del programa.
- **Herramientas de apoyo utilizadas:** ANTLR4 Tool 4.13.1, Maven 3.9.9, JDK 27, consulta de expresiones regulares en ChatGPT.

---

## Incidencia 2: Desbalanceo y reconocimiento de delimitadores suplementarios Unicode (Emojis Monitos `🐒 🐵`)

- **Fecha y hora:** 22/10/2026 — 15:52
- **Problema detectado:** Al procesar la expresión de precedencia de operadores y el ciclo de entrenamiento por épocas, el parser rechazaba el inicio de la siguiente instrucción (`proyectar`), deteniendo el análisis.
- **Mensaje emitido por ANTLR:**
  ```text
  [SINTÁCTICO] Línea 11:4 -> missing '\uD83D?' at 'proyectar'
  ```
- **Interpretación del problema:** En la regla sintáctica de `exprPrimaria`, los paréntesis de agrupación están definidos formalmente como `PAREN_IZQ expresion PAREN_DER` (`🐒` y `🐵`). En la expresión compleja se habían abierto 4 monitos (`🐒`), pero solo se habían colocado 3 cierres (`🐵`). ANTLR4 reportó `\uD83D...` porque los emojis son caracteres suplementarios UTF-16 (surrogate pairs) y el parser detectó que la expresión no había sido cerrada antes del token de la siguiente instrucción.
- **Solución propuesta y justificación:** Revisar el anidamiento algebraico de la expresión y cerrar explícitamente cada monito `🐒` con su respectivo `🐵`:
  - `🐒 🐒 entrada @ pesos + sesgo * 🐒factor ^ 2🐵 ~> capa_norm >= 0.75 🐵 && 🐒!inhibidor_activo🐵 🐵`
- **Fragmento anterior (en `precedencia_expresion.cmx`):**
  ```cmx
  sinapsis pulso decision_capa <- 🐒🐒entrada @ pesos + sesgo * 🐒factor ^ 2🐵 ~> capa_norm >= 0.75🐵 && 🐒!inhibidor_activo🐵
  ```
- **Fragmento corregido:**
  ```cmx
  sinapsis pulso decision_capa <- 🐒🐒entrada @ pesos + sesgo * 🐒factor ^ 2🐵 ~> capa_norm >= 0.75🐵 && 🐒!inhibidor_activo🐵🐵
  ```
- **Resultado obtenido:** Validación sintáctica exitosa con 0 errores. Se generó el subárbol sintáctico de la expresión respetando los 12 niveles de precedencia definidos en la especificación técnica.
- **Herramientas de apoyo utilizadas:** ANTLR4 Parser, consola de depuración en Java, conteo e inspección de tokens.

---

## Incidencia 3: Validación del rechazo sintáctico por uso de `;` en instrucciones simples

- **Fecha y hora:** 22/10/2026 — 15:53
- **Problema detectado:** En el archivo de prueba `invalido1_tres_caminos.cmx`, se colocó intencionalmente un punto y coma al final de una instrucción de asignación (`sinapsis peso precision <- 0.91 ;`).
- **Mensaje emitido por ANTLR:**
  ```text
  [SINTÁCTICO] Línea 4:4 -> mismatched input 'evaluar' expecting <EOF>
  ```
- **Interpretación del problema:** En Comix, las instrucciones simples no terminan con `;`. El punto y coma `;` está reservado exclusivamente para cerrar bloques que abrieron con `:`. Al colocar `;` tras la sinapsis, el parser cerró prematuramente el bloque de la `arquitectura` y esperó el fin de archivo (`<EOF>`), rechazando de forma correcta la instrucción siguiente.
- **Solución propuesta y justificación:** Se mantuvo como caso de prueba negativo para verificar que el analizador sintáctico rechaza programas que violen la convención de delimitación simétrica.
- **Resultado obtenido:** Evidencia verificada de rechazo sintáctico conforme a la especificación técnica.
- **Herramientas de apoyo:** ErrorListener de ANTLR4 en `Main.java`.

---

## Incidencia 4: Rechazo léxico y sintáctico de palabras reservadas convencionales prohibidas

- **Fecha y hora:** 22/10/2026 — 15:54
- **Problema detectado:** En el archivo de prueba `invalido2_palabras_prohibidas.cmx`, se probaron palabras reservadas tradicionales (`flotante`, `mientras`) y un número con punto decimal sin parte entera (`.05`).
- **Mensaje emitido por ANTLR:**
  ```text
  [LÉXICO] Línea 2:21 -> token recognition error at: '.'
  [SINTÁCTICO] Línea 2:4 -> mismatched input 'flotante' expecting {'sinapsis', 'ajustar', 'evaluar', 'entrenar', 'ingestar', 'proyectar', ';'}
  ```
- **Interpretación del problema:**
  1. En Comix, el tipo de dato de punto flotante se denomina exclusivamente `peso`. La palabra `flotante` es clasificada por el lexer como un identificador genérico (`ID`), provocando un error sintáctico porque una instrucción no puede iniciar con un `ID` suelto.
  2. La regla léxica `LIT_PESO : [0-9]+ '.' [0-9]+` exige obligatoriamente dígitos antes del punto, rechazando `.05`.
  3. `mientras` no es palabra reservada válida en Comix (debe usarse `entrenar converger`).
- **Solución propuesta y justificación:** Mantener el caso de prueba como evidencia de cumplimiento estricto del lineamiento 1.2 de la docente (prohibición de palabras reservadas habituales).
- **Resultado obtenido:** Verificación de robustez del compilador ante código no conforme.
- **Herramientas de apoyo:** Suite de pruebas automatizadas en `Main.java`.

---

## Resumen de Herramientas Utilizadas
- **ANTLR 4.13.1:** Generación del Lexer, Parser, Listener y Visitor.
- **Java JDK 27:** Entorno de ejecución y compilación.
- **Apache Maven 3.9.9:** Gestión de dependencias y ciclo de compilación.
- **IntelliJ IDEA 2025.2.2:** Entorno de desarrollo integrado.
- **Herramientas de apoyo y consulta:** Documentación oficial de ANTLR4 (The Definitive ANTLR 4 Reference) y consultas a ChatGPT sobre comportamiento de reglas no codiciosas (non-greedy) en lexers.
