# Lenguajes y Autómatas II
## T2 Proyecto 1 — Parte 1: Análisis Léxico y Sintáctico
### Diseño de un Lenguaje de Programación Propio: Comix (.cmx)

| Campo | Detalle |
| --- | --- |
| **Docente** | M.S.C. Alma Lilia Núñez González |
| **Equipo** | ComixTech |
| **Nombre del lenguaje** | Comix |
| **Extensión oficial** | `.cmx` |
| **Contexto de aplicación** | Redes Neuronales Artificiales y flujos de Machine Learning |
| **Repositorio oficial** | [https://github.com/msdiaz2109/Comix](https://github.com/msdiaz2109/Comix) |
| **Rama principal** | `main` |

---

## Introducción

Comix es un lenguaje de programación diseñado para representar algunas de las operaciones que se realizan al trabajar con modelos de Machine Learning, especialmente redes neuronales. Su diseño toma como referencia el funcionamiento del sistema nervioso de un cacomixtle, utilizando esta idea para organizar conceptos como el almacenamiento de datos, la conexión entre capas, el entrenamiento y la generación de predicciones.

Una de las características de Comix es que utiliza palabras reservadas relacionadas con estos procesos, en lugar de recurrir directamente a las instrucciones comunes de otros lenguajes. Por ejemplo, `sinapsis` se utiliza para declarar variables, `ajustar` permite modificar sus valores y `entrenar converger` representa un ciclo de entrenamiento. También incluye una estructura de decisión de tres caminos: `activar`, `recalibrar` y `descartar`, con la que se pueden representar distintas respuestas según los resultados obtenidos por el modelo.

El lenguaje incorpora tipos de datos propios, operadores aritméticos y matriciales, instrucciones de entrada y salida, y reglas específicas para organizar las expresiones y los bloques de código. Además, utiliza los emojis 🍌, 🐒 y 🐵 como parte de su sintaxis para los comentarios y la agrupación de expresiones, lo que le da una identidad visual diferente a la de los lenguajes tradicionales.

En este documento se describe la especificación técnica de Comix, desde los caracteres y tokens que reconoce hasta sus tipos de datos, operadores, estructuras de control y reglas gramaticales. También se presentan ejemplos de programas válidos e inválidos y la gramática desarrollada en ANTLR4, con el propósito de definir cómo se escribe el código y qué reglas debe cumplir para ser reconocido por el analizador.

---

## 1. Índice de entregables y evidencias

Los archivos y las evidencias del proyecto están organizados en el repositorio oficial de GitHub, donde se puede consultar el trabajo realizado en cada fase.

### Entregable 1. Documentación y especificación del lenguaje
**Fase 1: Propuesta y especificación del lenguaje**

Este documento presenta el diseño del lenguaje Comix y explica cómo está organizado, para qué se utiliza y cuáles son las reglas que se deben seguir al escribir código. Incluye la definición del alfabeto, los tokens, los tipos de datos, los operadores y las estructuras sintácticas que forman parte del lenguaje.

La especificación incluye los siguientes elementos:
- Justificación del diseño y contexto de aplicación del lenguaje.
- Alfabeto y reglas para los identificadores, literales y símbolos permitidos.
- Tabla de tokens con sus nombres, descripciones y ejemplos.
- Tabla de tipos de datos propios de Comix y sus valores válidos.
- Reglas para declarar variables y asignarles valores.
- Expresiones y niveles de precedencia de los operadores.
- Estructura condicional de tres caminos.
- Ciclo de repetición relacionado con el entrenamiento por épocas.
- Instrucciones para la entrada y salida de datos.
- Reglas para delimitar instrucciones y bloques de código.
- Uso de comentarios y espacios en blanco.
- Ejemplos de instrucciones y un programa completo escrito en Comix.

* **Archivo oficial:** [https://github.com/msdiaz2109/Comix/blob/main/entrega/1_Documentacion/Especificacion_Tecnica_Comix.md](https://github.com/msdiaz2109/Comix/blob/main/entrega/1_Documentacion/Especificacion_Tecnica_Comix.md)

---

### Entregable 2. Gramática formal en ANTLR4
**Fase 2: Implementación de la gramática**

En esta fase se desarrolló la gramática de Comix utilizando ANTLR4. El archivo define las reglas léxicas y sintácticas que permiten reconocer los programas escritos en este lenguaje. También incluye comentarios en las principales reglas para explicar qué función cumplen y cómo se relacionan con la sintaxis de Comix.

La gramática contempla los tipos de datos, las declaraciones de variables, las asignaciones, las expresiones y la precedencia de los operadores. También define las estructuras de control, las instrucciones de entrada y salida, los delimitadores y las reglas para reconocer los comentarios y los espacios en blanco.

* **Gramática de Comix:** [https://github.com/msdiaz2109/Comix/blob/main/entrega/2_Gramatica/Comix.g4](https://github.com/msdiaz2109/Comix/blob/main/entrega/2_Gramatica/Comix.g4)
* **Instrucciones para reproducir la generación:** [https://github.com/msdiaz2109/Comix/blob/main/entrega/2_Gramatica/Instrucciones_Generacion.md](https://github.com/msdiaz2109/Comix/blob/main/entrega/2_Gramatica/Instrucciones_Generacion.md)

---

### Entregable 3. Pruebas del lenguaje
**Fase 3: Validación de casos**

En esta fase se prepararon varios archivos con extensión `.cmx` para comprobar que Comix reconoce las instrucciones que cumplen con su gramática y detecta errores en las que no la cumplen.

Las pruebas incluyen un programa completo válido, un ejemplo para revisar la precedencia de los operadores y dos programas con errores intencionales. Estos últimos permiten comprobar cómo responde el analizador cuando encuentra delimitadores incorrectos, ramas incompletas, palabras reservadas no permitidas o un literal mal formado.

* **Directorio de pruebas:** [https://github.com/msdiaz2109/Comix/tree/main/entrega/3_Pruebas](https://github.com/msdiaz2109/Comix/tree/main/entrega/3_Pruebas)
* **Programa válido de una red neuronal bioacústica:** [https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/clasificador_cacomixtle.cmx](https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/clasificador_cacomixtle.cmx)
* **Prueba de precedencia de operadores:** [https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/precedencia_expresion.cmx](https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/precedencia_expresion.cmx)  
  *El parser de ANTLR4 construye el árbol sintáctico anidando las reglas de menor precedencia (`exprDisyuncion`, `exprConjuncion`) en la raíz y colocando las de mayor precedencia (`exprUnaria`, `exprPotencia`, `exprMatricial`) en las hojas más profundas. La ejecución sin errores de `precedencia_expresion.cmx` demuestra que los operadores se agrupan y evalúan en el orden formal establecido en la especificación.*
* **Caso inválido 1: delimitación incorrecta y ramas incompletas:** [https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/invalido1_tres_caminos.cmx](https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/invalido1_tres_caminos.cmx)  
  *Este archivo contiene errores intencionales para comprobar si el analizador detecta instrucciones que no siguen las reglas de Comix. El primer error se encuentra en la declaración de la variable `precision`, donde se agrega un punto y coma al final de la instrucción, aunque las instrucciones simples no deben llevarlo. El segundo error está en la estructura `evaluar`, ya que solo incluye las ramas `activar` y `descartar`, pero falta `recalibrar`, que es obligatoria en este tipo de condición. Con esta prueba se busca verificar que el analizador rechace el programa cuando no se respetan los delimitadores y la estructura requerida para las decisiones.*
* **Caso inválido 2: palabras reservadas prohibidas y literal malformado:** [https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/invalido2_palabras_prohibidas.cmx](https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/invalido2_palabras_prohibidas.cmx)  
  *En la primera línea se utiliza `flotante` como tipo de dato, pero Comix utiliza `peso` para representar números decimales y requiere la palabra `sinapsis` para declarar una variable. Después se utiliza `mientras` para intentar crear un ciclo, aunque en Comix esta estructura se escribe con `entrenar converger`. Como `flotante` y `mientras` no están definidas como palabras reservadas, el Lexer las reconoce como identificadores (`ID`). Sin embargo, cuando el Parser intenta interpretar el programa, no puede utilizarlas al inicio de esas instrucciones, porque la regla `instruccion` solo admite las construcciones permitidas. Por esta razón, el Parser detecta que la estructura del programa no corresponde con ninguna de las instrucciones permitidas. El segundo error se encuentra en el valor `.05`, ya que el número no tiene una parte entera antes del punto decimal. La regla léxica de Comix exige al menos un dígito antes y después del punto, por lo tanto, `.05` no cumple con el formato establecido y el Lexer no puede reconocerlo como un literal de tipo peso. Para escribir ese valor correctamente, debe utilizarse `0.05`. En conjunto, esta prueba permite comprobar que el Lexer detecta los valores que no cumplen con las reglas léxicas y que el Parser rechaza las instrucciones que no siguen la estructura definida para Comix.*
* **Evidencias de salida en consola:** [https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/Evidencias_Salida_Pruebas.txt](https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/Evidencias_Salida_Pruebas.txt)

---

### Entregable 4. Árbol sintáctico
**Fase 3: Visualización y exportación**

Representación gráfica del árbol sintáctico generado a partir del programa `clasificador_cacomixtle.cmx`. Este elemento permite visualizar la estructura jerárquica que construye el analizador sintáctico al reconocer las instrucciones del lenguaje. Se incluyen las representaciones vectorial y rasterizada.

* **Árbol sintáctico en SVG:** [https://github.com/msdiaz2109/Comix/blob/main/entrega/4_Arbol_Sintactico/arbol_sintactico.svg](https://github.com/msdiaz2109/Comix/blob/main/entrega/4_Arbol_Sintactico/arbol_sintactico.svg)
* **Árbol sintáctico en PNG:** [https://github.com/msdiaz2109/Comix/blob/main/entrega/4_Arbol_Sintactico/arbol_sintactico.png](https://github.com/msdiaz2109/Comix/blob/main/entrega/4_Arbol_Sintactico/arbol_sintactico.png)

---

### Entregable 5. Bitácora de desarrollo
**Fase 4: Registro de incidencias y depuración**

En esta sección se registran los problemas encontrados durante el desarrollo y las pruebas de la gramática de Comix en ANTLR4. Para cada incidencia se describe qué ocurrió, cuál fue su causa, qué cambios se realizaron y qué resultado se obtuvo después de aplicar la corrección.

Los casos documentados incluyen problemas con los comentarios que utilizan el emoji 🍌 y con los emojis 🐒 y 🐵, que se emplean para agrupar expresiones. Estos ejemplos permiten mostrar cómo se identificaron los errores y qué ajustes fueron necesarios para que el analizador reconociera correctamente el código.

#### Incidencia 1. Problema con los comentarios multilínea y el reconocimiento del código
- **Fecha y hora:** 22 de octubre de 2026, 15:45 h.
- **Componente afectado:** Analizador léxico (`Comix.g4`).
- **Descripción del problema:** Durante las pruebas se detectó que algunos comentarios delimitados con el emoji 🍌 podían provocar que el analizador léxico ignorara parte del código fuente. Como consecuencia, el parser no encontraba la palabra reservada `arquitectura` al inicio del programa y generaba errores al intentar analizar el archivo.
- **Causa del problema:** El problema se encontraba en la forma en que se reconocían los comentarios. La versión anterior de la regla para comentarios de bloque utilizaba el emoji 🍌 como delimitador inicial y final, junto con la expresión `.*?` para reconocer el contenido intermedio. Como esta expresión podía abarcar varias líneas, el analizador podía continuar leyendo hasta encontrar otra banana más adelante en el archivo. Esto provocaba que algunas instrucciones válidas quedaran dentro del comentario y fueran descartadas.
- **Solución aplicada:** Se modificó la regla `COMENTARIO_BLOQUE` para que, después de la banana inicial, se permita únicamente espacio horizontal antes de exigir un salto de línea. De esta manera, se distingue este formato del comentario de una sola línea. Las reglas quedaron de la siguiente forma en `Comix.g4`:
  ```antlr
  COMENTARIO_BLOQUE : '🍌' [ \t]* [\r\n] .*? '🍌' -> skip ;
  COMENTARIO_LINEA  : '🍌' ~[\r\n]* -> skip ;
  ```
- **Resultado después de la corrección:** Con este cambio, los comentarios se reconocen según el formato establecido en las reglas léxicas. El objetivo de la corrección es evitar que el contenido de un comentario absorba instrucciones que deben analizarse como parte del programa. La corrección debe comprobarse ejecutando nuevamente las pruebas con comentarios de una línea y de bloque, verificando que las instrucciones posteriores se sigan reconociendo correctamente.

#### Incidencia 2. Falta de cierre en una expresión agrupada con emojis
- **Fecha y hora:** 22 de octubre de 2026, 15:52 h.
- **Componente afectado:** Analizador sintáctico, durante la prueba `precedencia_expresion.cmx`.
- **Descripción del problema:** Durante las pruebas de expresiones y del ciclo de entrenamiento, el parser detectó que faltaba un delimitador de cierre antes de la instrucción `proyectar`. Esto provocaba que la expresión no pudiera completarse de acuerdo con las reglas de la gramática.
- **Causa del problema:** La gramática utiliza los emojis 🐒 y 🐵 como delimitadores de apertura y cierre de expresiones, respectivamente. En este caso, la expresión de prueba tenía un desbalance en el uso de estos símbolos, por lo que el parser interpretaba que un grupo seguía abierto cuando encontraba la instrucción `proyectar`. La regla que establece este agrupamiento es:
  ```antlr
  exprPrimaria : PAREN_IZQ expresion PAREN_DER | ... ;
  ```
  Por ello, cada expresión que comienza con 🐒 debe tener su correspondiente 🐵 en la posición adecuada.
- **Solución aplicada:** Se revisó la expresión para identificar los grupos abiertos y cerrar cada uno en el lugar correspondiente. La expresión corregida quedó de la siguiente manera:
  ```cmx
  sinapsis pulso decision_capa <- 🐒🐒entrada @ pesos + sesgo * 🐒factor ^ 2🐵 ~> capa_norm >= 0.75🐵 && 🐒!inhibidor_activo🐵🐵
  ```
  Con esta estructura se agrupan las operaciones matriciales, aritméticas y lógicas sin dejar delimitadores pendientes.
- **Resultado después de la corrección:** Una vez corregidos los delimitadores, la expresión puede analizarse respetando los grupos definidos por los emojis y la precedencia establecida en la gramática. Para documentar el resultado final, se debe conservar la salida de la ejecución en la que se compruebe que el archivo se procesa correctamente y que el árbol sintáctico se genera sin errores.

---

### Entregable 6. Presentación en video
- **Guion y estructura del video:** [https://github.com/msdiaz2109/Comix/blob/main/entrega/6_Presentacion/Guion_Video_Presentacion.md](https://github.com/msdiaz2109/Comix/blob/main/entrega/6_Presentacion/Guion_Video_Presentacion.md)

---

## 2. Código fuente del compilador y configuración

Además de los documentos anteriores, el repositorio contiene los archivos necesarios para generar la gramática y ejecutar el programa de pruebas.

| Archivo | Función |
| --- | --- |
| `Comix.g4` | Define las reglas léxicas y sintácticas del lenguaje. |
| `Main.java` | Ejecuta el análisis, procesa los archivos de prueba y gestiona la exportación del árbol sintáctico. |
| `pom.xml` | Define la configuración del proyecto y sus dependencias de Maven. |
| `Instrucciones_Generacion.md` | Describe el procedimiento para reproducir la generación de la gramática. |

**Enlaces oficiales:**
* Clase principal: [https://github.com/msdiaz2109/Comix/blob/main/src/main/java/org/example/Main.java](https://github.com/msdiaz2109/Comix/blob/main/src/main/java/org/example/Main.java)
* Configuración de Maven: [https://github.com/msdiaz2109/Comix/blob/main/pom.xml](https://github.com/msdiaz2109/Comix/blob/main/pom.xml)

---

## 3. Matriz de cumplimiento de los requerimientos técnicos

La siguiente matriz relaciona los requerimientos mínimos solicitados en la actividad con los elementos definidos en el diseño de Comix.

| Requerimiento | Implementación propuesta en Comix | Archivo o regla de referencia |
| --- | --- | --- |
| **Tipos de datos propios: mínimo tres** | Cinco tipos: `indice`, `peso`, `tensor`, `corpus` y `pulso`. | `Comix.g4`, regla `tipoDato`. |
| **Declaración y asignación** | Declaración mediante `sinapsis` y asignación mediante `ajustar`. | `declaracionSinapsis` y `ajusteSinapsis`. |
| **Expresiones aritméticas** | Jerarquía de precedencia y asociatividad de operadores. | Reglas de expresiones de `Comix.g4`. |
| **Decisión de tres caminos** | Estructura `evaluar`, `recalibrar` y `descartar`. | `decisionEvaluar`. |
| **Repetición** | Ciclo `entrenar converger` para representar iteraciones del proceso de entrenamiento. | `cicloEntrenar`. |
| **Entrada y salida** | Instrucciones `ingestar` y `proyectar`. | `ingestaDatos` y `proyeccionSalida`. |
| **Delimitación** | Convenciones de apertura y cierre de bloques mediante `:` y `;`, según la construcción. | `bloque` y reglas relacionadas. |
| **Comentarios y espacios en blanco** | Comentarios de línea y bloque mediante la convención de banana (🍌), además de espacios ignorados por el analizador. | `COMENTARIO_BLOQUE` y `COMENTARIO_LINEA`. |

La especificación también contempla 12 niveles de precedencia, una convención propia para las operaciones matriciales y el rechazo de palabras reservadas y literales malformados conforme a las reglas definidas.

La correspondencia definitiva de cada elemento deberá verificarse contra la versión entregada de `Comix.g4` y sus pruebas, de modo que la documentación, la gramática y las evidencias representen el mismo diseño.

---

## 4. Instrucciones de clonación, compilación y ejecución

Para reproducir el proyecto en un entorno local, se requiere Git, Java compatible con la configuración del proyecto y Maven.

### 4.1 Clonar el repositorio
Abrir una terminal y ejecutar:
```bash
git clone https://github.com/msdiaz2109/Comix.git
cd Comix
```

### 4.2 Compilar el proyecto
```bash
mvn compile
```
Este comando compila el código fuente y permite identificar errores de compilación.

### 4.3 Ejecutar el programa principal
```bash
mvn exec:java -Dexec.mainClass=org.example.Main
```
La ejecución depende de que el proyecto tenga configurado el complemento de Maven correspondiente y de que se encuentren disponibles las dependencias necesarias.

De acuerdo con la configuración descrita para el proyecto, el ejecutor procesa los archivos `.cmx` y genera los resultados de las pruebas en consola. También se contempla la exportación del árbol sintáctico en los siguientes archivos:
* `entrega/4_Arbol_Sintactico/arbol_sintactico.svg`
* `entrega/4_Arbol_Sintactico/arbol_sintactico.png`

La regeneración de estos archivos debe confirmarse mediante una ejecución local satisfactoria.

---

## 5. Resultados esperados

Con el desarrollo de Comix se busca demostrar que es posible definir un lenguaje de programación original y establecer sus reglas de reconocimiento mediante una gramática formal.

Los resultados previstos son:
1. Una especificación que describa de manera consistente la identidad y las convenciones del lenguaje.
2. Una gramática ANTLR4 capaz de reconocer las estructuras definidas en la especificación.
3. Un programa válido que integre las principales construcciones del lenguaje.
4. Casos de prueba que permitan comprobar la precedencia de operadores y detectar construcciones inválidas.
5. Un árbol sintáctico exportado a SVG a partir de un programa válido.
6. Una bitácora que documente las incidencias y correcciones reales del desarrollo.
7. Una presentación en video que explique el contexto y las decisiones de diseño más relevantes.

Estos resultados corresponden al alcance léxico y sintáctico de la primera parte del proyecto; no implican que las instrucciones del lenguaje ejecuten operaciones reales de entrenamiento de redes neuronales.

---

## 6. Conclusión

El proyecto Comix propone un lenguaje de programación especializado en la representación de procesos relacionados con redes neuronales artificiales y flujos de Machine Learning. Su diseño integra convenciones léxicas propias, tipos de datos especializados, estructuras de decisión y repetición, operadores y reglas de delimitación orientadas a su contexto de aplicación.

La utilización de ANTLR4 permite expresar formalmente estas convenciones y construir analizadores capaces de reconocer programas escritos con la extensión `.cmx`. Las pruebas válidas e inválidas, junto con la generación del árbol sintáctico, constituyen los mecanismos para comprobar el comportamiento del análisis léxico y sintáctico.

Finalmente, la documentación, el código fuente y la bitácora permiten organizar las decisiones de diseño, reproducir el procedimiento de generación y respaldar el desarrollo del lenguaje. El cumplimiento definitivo de cada requerimiento depende de que las evidencias entregadas correspondan con los archivos y resultados obtenidos durante las pruebas reales del equipo.
