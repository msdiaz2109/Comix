# Lenguaje Comix (.cmx) — Especificación Técnica del Lenguaje

## Fase 1 y Fase 2: Gramática en ANTLR4

## 1. Nombre del lenguaje y justificación de su diseño

Comix es un lenguaje pensado para representar las etapas de un modelo de Machine Learning tomando como referencia el sistema nervioso de un cacomixtle. El proceso comienza al recibir muestras, continúa con su propagación por conexiones ponderadas (sinapsis y tensores), permite ajustar el comportamiento durante el entrenamiento por épocas y termina al generar predicciones.

Los comentarios de una línea y de bloque se escriben con el símbolo Unicode 🍌. Para agrupar expresiones se utilizan los emojis 🐒 y 🐵. Estas decisiones le dan a Comix una identidad visual propia y permiten reconocerlo fácilmente frente a otros lenguajes.

### 1.2 Cómo funciona Comix: Conceptos clave explicados de forma sencilla

Comix no utiliza palabras habituales de otros lenguajes, como if, while o int. En su lugar, emplea términos relacionados con las redes neuronales, de modo que las instrucciones se relacionen con las tareas que realiza el modelo:

**Vocabulario y uso de las instrucciones:**
- `arquitectura` (programa principal): contiene la definición del modelo o de la red neuronal.
- `sinapsis` (declarar variables): crea una variable y le asigna un valor inicial. Puede utilizarse para guardar tasas de aprendizaje, contadores o tensores de pesos.
- `ajustar` (modificar un valor): permite cambiar el valor de una sinapsis que ya existe. Por ejemplo, se puede actualizar una tasa de aprendizaje con `ajustar tasa <- tasa * 0.95`.
- `entrenar converger` (repetición o ciclo): repite un bloque de instrucciones por épocas mientras se cumpla la condición establecida para el entrenamiento.
- `evaluar` (decisión de tres caminos): permite responder de tres maneras a una métrica, en lugar de limitarse a las dos opciones habituales de un condicional (sí o no):
  - `activar`: se utiliza cuando la confianza es alta y el modelo puede aceptar y emitir el resultado.
  - `recalibrar`: se utiliza cuando el resultado genera dudas y hace falta modificar parámetros para mejorar.
  - `descartar`: se utiliza cuando el resultado no alcanza los valores mínimos y la muestra debe rechazarse.
- `ingestar` y `proyectar` (entrada y salida): `ingestar` permite recibir datos o muestras desde un archivo o la consola; `proyectar` muestra predicciones y métricas.

**Operaciones matemáticas directas:**
Para las operaciones de álgebra lineal, Comix incluye el operador `@` para el producto matricial y `~>` para pasar los datos a la siguiente capa. Por ejemplo: `muestras @ pesos ~> salida`.

**Reglas para escribir el código (Delimitación):**
- **Bloques:** los bloques de arquitectura, ciclo o condición comienzan con `:` y terminan únicamente con `;`.
- **Líneas simples:** las instrucciones que no abren un bloque no llevan punto y coma al final.

---

## 2. Contexto de aplicación y problemas que resuelve

Comix está pensado para crear, entrenar y evaluar modelos de Machine Learning, en particular redes neuronales. Su vocabulario y sus instrucciones se organizan alrededor de cinco etapas del trabajo con un modelo:

| Etapa del modelo | ¿Qué problema resuelve? | ¿Cómo se hace en Comix? |
| --- | --- | --- |
| **1. Configuración inicial** | Definir parámetros como número de épocas, tasas de aprendizaje y pesos sin confundir números enteros con decimales. | `sinapsis` con tipos propios (`indice`, `peso`, `tensor`, etc.) y asignación `<-`. |
| **2. Carga y cálculo de datos** | Leer archivos de datos y multiplicar matrices entre capas sin código enredado. | `ingestar ... -> variable`, matrices `[...]`, multiplicación `@` y tubería `~>`. |
| **3. Entrenamiento por épocas** | Repetir el aprendizaje paso a paso hasta que el margen de error sea aceptable. | Ciclo `entrenar converger 🐒condicion🐵 :` y `ajustar` para actualizar valores. |
| **4. Evaluación de resultados** | Decidir qué hacer con el resultado: aceptar si es bueno, reajustar si hay dudas o descartar si falló. | `evaluar` con sus 3 caminos obligatorios: `activar`, `recalibrar` y `descartar`. |
| **5. Salida de predicciones** | Mostrar en pantalla los resultados finales, métricas de precisión o mensajes. | `proyectar <datos>`. |

---

## 3. Alfabeto del lenguaje

El alfabeto formal $\Sigma$ de Comix es el conjunto finito de símbolos que el Lexer de ANTLR4 acepta en un archivo `.cmx` codificado en UTF-8.

### 3.1 Conjuntos de caracteres permitidos

| Conjunto | Símbolos |
| --- | --- |
| **Letras ($\Sigma_{letra}$)** | `a-z` ($U+0061$ a $U+007A$), `A-Z` ($U+0041$ a $U+005A$) y el guion bajo `_` ($U+005F$). |
| **Dígitos ($\Sigma_{digito}$)** | `0` a `9` ($U+0030$ a $U+0039$). |
| **Operadores aritméticos y algebraicos** | `+`, `-`, `*`, `/`, `%`, `^`, `@`, `~>` |
| **Flujo, enlace y relación** | `<`, `>`, `=`, `!`, `&`, `|`, `->`, `<-` |
| **Delimitadores y puntuación** | `:`, `;`, `[`, `]`, `,` |
| **Emojis de monitos ($\Sigma_{agrupacion}$)** | 🐒 ($U+1F412$, abre agrupación) y 🐵 ($U+1F435$, cierra agrupación). Atajo en Windows: combinación de teclas `Win + .` (escribir "mono"). |
| **Emoji de comentarios ($\Sigma_{emoji}$)** | 🍌 (Banana, $U+1F34C$): inicia comentario de una línea y abre/cierra comentario multilínea. Atajo en Windows: combinación de teclas `Win + .` (escribir "banana"). |
| **Espaciado ($\Sigma_{espacio}$)** | Espacio ($U+0020$), tabulador `\t` ($U+0009$), retorno de carro `\r` ($U+000D$) y salto de línea `\n` ($U+000A$). |

### 3.2 Reglas léxicas formales

| Categoría | Descripción | Expresión regular | Ejemplos válidos |
| --- | --- | --- | --- |
| **Identificador (`ID`)** | Inicia con letra o `_`, seguido de letras, dígitos o `_`. No puede coincidir con palabras reservadas. | `[a-zA-Z_][a-zA-Z0-9_]*` | `tasa_aprendizaje`, `pesos_capa1`, `_sesgo_inicial` |
| **Literal discreto (`LIT_INDICE`)** | Uno o más dígitos, sin punto decimal. Los negativos se forman con el unario prefijo. | `[0-9]+` | `0`, `1`, `64`, `1000` |
| **Literal de precisión decimal (`LIT_PESO`)** | Dígitos, punto decimal obligatorio, dígitos fraccionarios y notación científica opcional. | `[0-9]+'.'[0-9]+([eE][+]?[0-9]+)?` | `0.001`, `0.95`, `3.14159`, `1.0e-5` |
| **Literal textual (`LIT_CORPUS`)** | Cualquier carácter UTF-8 entre comillas dobles, excepto comillas sin escapar y saltos de línea. | `"~["\r\n]*"` | `"relu"`, `"dataset_michoacan_2026.csv"` |
| **Literal de estado (`literalPulso`)** | Exclusivamente los tokens reservados `activo` (disparo) e `inactivo` (inhibición). | `activo` \| `inactivo` | `activo`, `inactivo` |
| **Literal matricial (`tensorLiteral`)** | Expresiones o sub-tensores entre `[` y `]`, separados por comas. | `'[' expresion (',' expresion)* ']'` | `[0.2, 0.5, 0.8]`, `[[1.0, 0.0], [0.0, 1.0]]` |

---

## 4. Tabla de tokens

### 4.1 Palabras reservadas: estructura y flujo

| Token (ANTLR4) | Lexema | Función en el contexto de ML |
| --- | --- | --- |
| **`ARQUITECTURA`** | `arquitectura` | Contenedor raíz de un modelo o flujo completo en un archivo `.cmx`. |
| **`SINAPSIS`** | `sinapsis` | Declara e inicializa una conexión de memoria (variable o hiperparámetro). |
| **`AJUSTAR`** | `ajustar` | Recalibra el valor de una sinapsis existente (ej. actualización de pesos). |
| **`EVALUAR`** | `evaluar` | Inicia el condicional obligatorio de 3 caminos. |
| **`ACTIVAR`** | `activar` | Rama 1: la métrica supera el umbral principal. |
| **`RECALIBRAR`** | `recalibrar` | Rama 2: umbral intermedio; ajustar hiperparámetros o reentrenar. |
| **`DESCARTAR`** | `descartar` | Rama 3: camino por defecto ante subajuste o falla. |
| **`ENTRENAR`** | `entrenar` | Inicia el ciclo iterativo de entrenamiento por épocas. |
| **`CONVERGER`** | `converger` | Condición de permanencia del ciclo mientras se busca convergencia. |
| **`INGESTAR`** | `ingestar` | Captura muestras, tensores o parámetros desde la entrada estándar o un origen de datos. |
| **`PROYECTAR`** | `proyectar` | Emite predicciones, métricas o tensores hacia la consola o telemetría. |

### 4.2 Palabras reservadas: tipos y literales de pulso

| Token | Lexema | Función |
| --- | --- | --- |
| **`INDICE`** | `indice` | Tipo entero discreto (épocas, tamaño de lote, dimensiones). |
| **`PESO`** | `peso` | Tipo real de precisión decimal (pesos, sesgos, tasa de aprendizaje, pérdida). |
| **`TENSOR`** | `tensor` | Tipo para vectores de características y matrices multidimensionales. |
| **`CORPUS`** | `corpus` | Tipo textual (etiquetas, rutas de datasets, nombres de activaciones). |
| **`PULSO`** | `pulso` | Tipo binario de activación o inhibición neuronal. |
| **`ACTIVO`** | `activo` | Disparo de una neurona o cumplimiento de convergencia. |
| **`INACTIVO`** | `inactivo` | Inhibición neuronal o ausencia de convergencia. |

### 4.3 Operadores y Delimitadores

| Token | Lexema | Categoría | Función |
| --- | --- | --- | --- |
| **`PAREN_IZQ`** | `🐒` | Agrupación | Abre la agrupación explícita para alterar o clarificar la precedencia. |
| **`PAREN_DER`** | `🐵` | Agrupación | Cierra la agrupación explícita de expresiones. |
| **`DOS_PUNTOS`** | `:` | Delimitador | Abre cualquier bloque compuesto (`arquitectura`, `evaluar`, `entrenar`). |
| **`PUNTO_Y_COMA`** | `;` | Delimitador | Cierra exclusivamente un bloque abierto con `:`. Prohibido al final de instrucciones simples. |
| **`ENLACE_SINAPTICO`** | `<-` | Asignación | Vincula el resultado de una expresión a una sinapsis. |
| **`CANAL_INGESTA`** | `->` | Flujo de entrada | Dirige una fuente etiquetada hacia la sinapsis destino en `ingestar`. |
| **`TUBERIA_CAPA`** | `~>` | Dominio ML | Propaga un tensor hacia la siguiente capa o transformación (*forward pass*). |
| **`PROD_MATRICIAL`** | `@` | Dominio ML | Producto punto o multiplicación matricial ($A \cdot B$). |
| **`POTENCIA`** | `^` | Aritmético | Eleva una base a un exponente ($e^2$). |
| **`MULT` / `DIV` / `MOD`** | `*`, `/`, `%` | Aritmético | Multiplicación escalar, división y residuo entero. |
| **`SUMA` / `RESTA`** | `+`, `-` | Aritmético | Adición y sustracción / inversión de signo. |
| **`RELACIONALES`** | `>=`, `<=`, `>`, `<` | Relacional | Comparaciones de umbrales y cotas ($\ge, \le, >, <$). |
| **`IGUALDAD` / `DIVERGENCIA`** | `==`, `!=` | Igualdad | Equivalencia o diferencia exacta entre expresiones. |
| **`CONJUNCION` / `DISYUNCION`** | `&&`, `||` | Lógico | Operadores booleanos AND y OR. |
| **`INHIBICION`** | `!` | Lógico unario | Invierte un pulso (`!activo` $\rightarrow$ `inactivo`). |
| **`COMENTARIO_BLOQUE`** | `🍌...🍌` | Comentario | Comentario multilínea ignorado por el parser. |
| **`COMENTARIO_LINEA`** | `🍌...` | Comentario | Comentario de una línea ignorado por el parser. |

---

## 5. Tabla de tipos de datos

Comix cuenta con cinco tipos de datos relacionados con Machine Learning. Para mantener el vocabulario propio del lenguaje, no se permiten los nombres convencionales `int`, `float`, `string`, `boolean`, `entero`, `flotante` ni `cadena`.

| Tipo | Representación y propósito en ML | Ejemplos de valores |
| --- | --- | --- |
| **`indice`** | Magnitud discreta de indexación y conteo. Enteros exactos: épocas, tamaño de lote, neuronas por capa, semillas, pasos de iteración. | `0`, `1`, `32`, `128`, `1000`, `-5` |
| **`peso`** | Magnitud continua de punto flotante (IEEE 754). Pesos sinápticos, sesgos, tasas de aprendizaje, pérdida, gradientes y probabilidades. | `0.001`, `0.925`, `-0.34`, `0.0`, `1.5e-4` |
| **`tensor`** | Estructura algebraica multidimensional. Vectores 1D y matrices 2D/ND sobre las que operan `@` y `~>`. | `[0.5, 0.8, 0.1]`, `[[0.2, -0.4], [0.7, 0.1]]` |
| **`corpus`** | Secuencia textual y etiquetado semántico. Cadenas inmutables: etiquetas, rutas de datasets, funciones de activación, telemetría. | `"cacomixtle michoacano"`, `"sigmoide"` |
| **`pulso`** | Estado sináptico binario. Estado de una unidad neuronal o condición de parada temprana. Solo admite `activo` e `inactivo`. | `activo`, `inactivo` |

---

## 6. Estructuras de control

Las estructuras de control de Comix representan partes del entrenamiento y de la inferencia. Todas siguen la misma regla: cada bloque se abre con `:` y se cierra únicamente con `;`.

### 6.1 Condicional de tres caminos obligatorios: `evaluar` / `activar` / `recalibrar` / `descartar`

**Justificación semántica:** al revisar una métrica, como la precisión de validación o una probabilidad softmax, el clasificador puede encontrarse en tres situaciones:

1. **`activar`:** Inferencia confiable. Se cumple la condición principal (ej. confianza $\ge 0.85$). El modelo se activa, consolida sus pesos y emite la predicción como válida.
2. **`recalibrar`:** Zona de incertidumbre. No se alcanzó la condición principal, pero sí un umbral intermedio (ej. confianza $\ge 0.60$). El modelo entra en recalibración: reduce la tasa de aprendizaje, ajusta el sesgo o solicita más épocas.
3. **`descartar`:** Rechazo de la hipótesis. Ninguno de los dos umbrales se cumplió. Se descarta la muestra o el estado por baja confianza o divergencia del error, ejecutando las acciones de contingencia.

**Regla gramatical (EBNF):**

```
decisionEvaluar
    : 'evaluar' expresion
      'activar' ':' instruccion* ';'
      'recalibrar' expresion ':' instruccion* ';'
      'descartar' ':' instruccion* ';'
    ;
```

**Diagrama de flujo:**

```
evaluar <condicion_principal>
    |---> activo    --> activar: <instrucciones> ;
    |---> inactivo  --> recalibrar <condicion_secundaria>
                            |---> activo   --> recalibrar: <instrucciones> ;
                            |---> inactivo --> descartar:  <instrucciones> ;
```

### 6.2 Repetición por épocas y convergencia: `entrenar converger`

**Justificación semántica:** una red aprende mediante varias épocas de optimización, con el objetivo de reducir la función de pérdida. Por esa razón, Comix utiliza un ciclo pensado para el entrenamiento en lugar de un bucle genérico. Antes de cada época se evalúa la expresión de convergencia delimitada por monitos: `🐒epoca_actual <= limite_epocas && 🐒error_perdida > umbral_minimo🐵🐵`

Si la expresión produce `activo`, se ejecuta el bloque delimitado por `:` y `;`. Dentro de él se pueden propagar tensores con `@` y `~>` y actualizar pesos mediante `ajustar`. Cuando la condición pasa a `inactivo`, el ciclo termina y el programa continúa después del `;` de cierre.

**Regla gramatical (EBNF):**

```
cicloEntrenar
    : 'entrenar' 'converger' expresion bloque
    ;
```

---

## 7. Reglas preliminares del lenguaje

### 7.1 Declaración de sinapsis y ajuste de valores

A diferencia de una declaración como `int x = 10;` en C o Java, Comix separa la creación de una sinapsis de la modificación de su valor. Para declarar se usa `sinapsis` y para actualizar se usa `ajustar`; ambas instrucciones utilizan `<-` y no llevan `;` al final.

| Instrucción | Estructura | Semántica | Ejemplo |
| --- | --- | --- | --- |
| **Declaración** | `sinapsis <tipoDato> <ID> <- <expresion>` | Reserva una conexión tipada en la arquitectura y le enlaza su estado inicial. | `sinapsis peso tasa_alfa <- 0.005` |
| **Actualización** | `ajustar <ID> <- <expresion>` | Modifica una sinapsis ya declarada (recalibración de parámetros). | `ajustar tasa_alfa <- tasa_alfa * 0.95` |

### 7.2 Precedencia y asociatividad de operadores

En las expresiones se pueden combinar valores escalares (`indice` y `peso`), estructuras matriciales (`tensor`), texto (`corpus`) y estados lógicos (`pulso`). La tabla siguiente organiza los operadores en 12 niveles, desde el de mayor precedencia (1) hasta el de menor (12):

| Nivel | Operadores | Categoría | Asociatividad | Justificación |
| --- | --- | --- | --- | --- |
| **1 (máxima)** | **`🐒 🐵`**, `[ ]` | Agrupación con monitos y construcción tensor | No aplica | Los paréntesis con monitos `🐒 🐵` fuerzan la evaluación prioritaria; los corchetes encapsulan tensores. |
| **2** | `-` (unario), `!` | Inversión de polaridad e inhibición | Derecha a izquierda | Prefijos aplicados de inmediato al operando derecho (`!!activo` evalúa primero el `!` interno). |
| **3** | `^` | Potenciación | Derecha a izquierda | Convención algebraica estándar: `a^(b^c)`. |
| **4** | `@` | Producto matricial | Izquierda a derecha | `X @ W1 @ W2` se evalúa como `((X · W1) · W2)` antes de sumar sesgos. |
| **5** | `*`, `/`, `%` | Escalamiento, normalización y loteo | Izquierda a derecha | Escala resultados antes de las sumas. |
| **6** | `+`, `-` (binario) | Sesgo y error residual | Izquierda a derecha | En `X @ W + b`, la suma del sesgo ocurre después del producto matricial. |
| **7** | `~>` | Tubería de propagación de capas | Izquierda a derecha | Envía la pre-activación a la siguiente capa: `(X @ W + b) ~> capa_salida`. |
| **8** | `>`, `<`, `>=`, `<=` | Comparación de umbrales | Izquierda a derecha | Compara una expresión o tubería contra un umbral y produce un pulso. |
| **9** | `==`, `!=` | Equivalencia y divergencia | Izquierda a derecha | Compara etiquetas, pulsos o métricas tras resolver las relacionales. |
| **10** | `&&` | Conjunción sináptica | Izquierda a derecha | Mayor precedencia que `||`: `epoca <= 100 && error > 0.01`. |
| **11** | `||` | Disyunción sináptica | Izquierda a derecha | Une cláusulas conjuntivas completas como última etapa booleana. |
| **12 (mínima)** | `<-`, `->` | Enlace sináptico y canal de ingesta | Derecha a izquierda | Primero evalúa toda la expresión derecha (niveles 1 a 11) y deposita el resultado. |

### 7.3 Sintaxis de entrada y salida

**Entrada (`ingestar`):**
- Directa desde consola: `ingestar muestras_entrada`
- Desde fuente etiquetada: `ingestar "dataset_michoacan_2026.csv" -> matriz_caracteristicas`

**Salida (`proyectar`):**
- Sintaxis: `proyectar <expresion> (, <expresion>)*`
- Ejemplo: `proyectar "Pérdida en época:", epoca_actual, perdida_actual`

### 7.4 Delimitación, espacios en blanco y comentarios

- **Bloques con `:` y `;`:** los dos puntos marcan el inicio del bloque y el punto y coma marca su cierre. Las instrucciones simples no llevan `;` al final.
- **Espacios en blanco:** los espacios, tabulaciones y saltos de línea sirven para separar tokens. El lexer los descarta mediante `skip`.
- **Comentarios con Emoji de Banana 🍌:**
  - Una línea: comienza con 🍌 y continúa hasta el final de esa línea.
  - Multilínea: comienza con 🍌 y termina cuando aparece otra 🍌.

---

## 8. Ejemplos de código en Comix (.cmx)

### 8.1 Tres instrucciones individuales válidas

**a) Declaración de sinapsis y ajuste de parámetros:**
```
🍌 Declaración de tensores e hiperparámetros 🍌
sinapsis tensor pesos_ocultos <- [[0.45, -0.12], [0.80, 0.33]]
sinapsis peso tasa_aprendizaje <- 0.01
ajustar tasa_aprendizaje <- tasa_aprendizaje * 0.90
```

**b) Expresión con precedencia de operadores de ML (`@`, `^`, `*`, `+`, `~>`):**
```
sinapsis tensor salida_capa <- 🐒muestras_lote @ pesos_ocultos + sesgo_capa * 0.52 ~> mapa_activacion🐵
```

**c) Entrada (`ingestar`) y salida (`proyectar`):**
```
ingestar "sensores_bosque_michoacan.csv" -> muestras_lote
proyectar "Inferencia completada para lote:", muestras_lote, activo
```

### 8.2 Programa completo válido: `clasificador_cacomixtle.cmx`

```
🍌
Archivo: clasificador_cacomixtle.cmx
Equipo: ComixTech - Lenguajes y Autómatas II
Descripción: Red neuronal para clasificar señales bioacústicas
y térmicas del cacomixtle en la sierra de Michoacán.
🍌

arquitectura ClasificadorCacomixtle :

    🍌 1. Hiperparámetros y estado inicial (los 5 tipos de datos)
    sinapsis corpus nombre_modelo <- "Red-BioAcustica-Cacomixtle-v1"
    sinapsis indice epoca_actual <- 1
    sinapsis indice max_epocas <- 50
    sinapsis peso tasa_alfa <- 0.05
    sinapsis peso error_perdida <- 0.85
    sinapsis peso umbral_convergencia <- 0.10
    sinapsis pulso red_convergente <- inactivo

    🍌 2. Tensores de entrada, pesos sinápticos y sesgo
    sinapsis tensor muestras_entrada <- [[0.90, 0.40], [0.25, 0.80]]
    sinapsis tensor matriz_pesos <- [[0.50, -0.20], [0.30, 0.75]]
    sinapsis tensor vector_sesgo <- [0.05, 0.05]
    sinapsis tensor mapa_activacion <- [0.0, 0.0]

    🍌 3. Ingesta de datos
    ingestar "lote_sierra_michoacan.cmx_data" -> muestras_entrada
    proyectar "Iniciando entrenamiento de:", nombre_modelo

    🍌 4. Ciclo de entrenamiento por épocas con agrupación de monitos 🐒 🐵
    entrenar converger 🐒epoca_actual <= max_epocas && 🐒error_perdida > umbral_convergencia🐵🐵 :
        ajustar mapa_activacion <- 🐒muestras_entrada @ matriz_pesos + vector_sesgo ~> mapa_activacion🐵
        ajustar error_perdida <- error_perdida - 🐒error_perdida * tasa_alfa ^ 2🐵
        ajustar epoca_actual <- epoca_actual + 1
    ;

    sinapsis peso confianza_modelo <- 1.0 - error_perdida

    🍌 5. Evaluación obligatoria de 3 caminos
    evaluar confianza_modelo >= 0.85
    activar :
        ajustar red_convergente <- activo
        proyectar "Modelo ACTIVADO. Confianza óptima:", confianza_modelo, red_convergente
    ;
    recalibrar confianza_modelo >= 0.65 :
        ajustar red_convergente <- inactivo
        ajustar tasa_alfa <- tasa_alfa * 0.50
        proyectar "Modelo en RECALIBRACION. Nueva tasa alfa:", tasa_alfa
    ;
    descartar :
        ajustar red_convergente <- inactivo
        proyectar "Modelo DESCARTADO por subajuste crítico. Error:", error_perdida
    ;

    proyectar "Total de épocas ejecutadas:", epoca_actual, "Estado:", red_convergente
;
```

### 8.3 Expresión compleja y demostración de precedencia

En esta instrucción se combinan nueve operadores y se utilizan los monitos `🐒` y `🐵` para agrupar partes de la expresión:

```
sinapsis pulso decision_capa <- 🐒🐒entrada @ pesos + sesgo * 🐒factor ^ 2🐵 ~> capa_norm >= 0.75🐵 && 🐒!inhibidor_activo🐵🐵
```

**Orden en que se evalúa la expresión:**

| Paso | Nivel | Operación | Resultado |
| :---: | :--- | :--- | :--- |
| **1** | 2 (unario `!`) | Se invierte el pulso `inhibidor_activo`. | $T1 =$ `!inhibidor_activo` |
| **2** | 3 (potencia `^`) | Se eleva `factor` al cuadrado. | $T2 =$ `factor ^ 2` |
| **3** | 4 (`@` matricial) | Producto matricial de `entrada` por `pesos`. | $T3 =$ `entrada @ pesos` |
| **4** | 5 (`*` mult) | Se multiplica el sesgo por la potencia $T2$. | $T4 =$ `sesgo * T2` |
| **5** | 6 (`+` suma) | Suma del producto matricial y el sesgo escalado. | $T5 =$ `T3 + T4` |
| **6** | 7 (`~>` tubería) | Propagación del resultado a `capa_norm`. | $T6 =$ `T5 ~> capa_norm` |
| **7** | 8 (`>=` relacional) | Comparación de la salida con el umbral 0.75. | $T7 =$ `T6 >= 0.75` |
| **8** | 10 (`&&` lógico) | Conjunción de $T7$ y $T1$. | $T8 =$ `T7 && T1` |
| **9** | 12 (`<-` enlace) | Asignación del pulso resultante a la nueva sinapsis. | `decision_capa <- T8` |

### 8.4 Dos ejemplos inválidos (casos de rechazo para la Fase 3)

**Ejemplo inválido 1: faltan uno de los tres caminos obligatorios y se usa punto y coma al final de una instrucción simple:**

```
arquitectura RedInvalidaUno :
    sinapsis peso precision <- 0.91 ;  🍌 ERROR 1: ; al final de instruccion simple

    evaluar precision >= 0.80
    activar :
        proyectar "Modelo aprobado"
    ;
    descartar :                        🍌 ERROR 2: falta la rama 'recalibrar'
        proyectar "Modelo rechazado"
    ;
;
```

| # | Regla violada | Diagnóstico de ANTLR4 |
| :---: | :--- | :--- |
| **1** | Delimitación de bloques | El `;` no pertenece a `declaracionSinapsis`. El parser lo toma como cierre prematuro del bloque raíz. Reporta: `extraneous input ';' expecting <EOF>`. |
| **2** | `decisionEvaluar` | La regla exige `ACTIVAR` bloque `RECALIBRAR` expresion bloque `DESCARTAR` bloque. Al omitir `recalibrar`, reporta: `mismatched input 'descartar' expecting 'recalibrar'`. |

**Ejemplo inválido 2: se utilizan una palabra no permitida y un literal de peso escrito de forma incorrecta:**

```
arquitectura RedInvalidaDos :
    flotante tasa <- .05               🍌 ERROR 1: 'flotante' prohibida y .05 sin parte entera

    mientras tasa < 1.0 :             🍌 ERROR 2: palabra prohibida 'mientras'
        ajustar tasa <- tasa + 0.1
    ;
;
```

| # | Regla violada | Diagnóstico de ANTLR4 |
| :---: | :--- | :--- |
| **1** | Vocabulario y `LIT_PESO` | `flotante` no existe en Comix (debe usarse `peso`). Además `.05` incumple `[0-9]+'.'[0-9]+` y produce: `token recognition error at: '.'`. |
| **2** | Palabra prohibida | `mientras` no es un token del lenguaje (la forma válida es `entrenar converger`). Reporta: `no viable alternative at input 'mientras'`. |

---

## 9. Implementación de la gramática en ANTLR4 (`Comix.g4`)

```antlr
grammar Comix;

@header {
    package org.parser;
}

// ==========================================
// 1. REGLAS SINTÁCTICAS (PARSER)
// ==========================================

// Raíz: una arquitectura seguida de EOF.
programa
    : ARQUITECTURA ID bloque EOF
    ;

// Bloque compuesto: abre con ':' y cierra con ';'.
bloque
    : DOS_PUNTOS instruccion* PUNTO_Y_COMA
    ;

// Cada instrucción inicia con una palabra reservada propia del dominio.
instruccion
    : declaracionSinapsis
    | ajusteSinapsis
    | ingestaDatos
    | proyeccionSalida
    | decisionEvaluar
    | cicloEntrenar
    ;

// sinapsis <tipo> <id> <- <expresion>
declaracionSinapsis
    : SINAPSIS tipoDato ID ENLACE_SINAPTICO expresion
    ;

// ajustar <id> <- <expresion>
ajusteSinapsis
    : AJUSTAR ID ENLACE_SINAPTICO expresion
    ;

// Los 5 tipos de datos nativos de Comix.
tipoDato
    : INDICE
    | PESO
    | TENSOR
    | CORPUS
    | PULSO
    ;

// Entrada: ingestar <id> | ingestar "ruta" -> <id>
ingestaDatos
    : INGESTAR ID
    | INGESTAR LIT_CORPUS CANAL_INGESTA ID
    ;

// Salida: una o varias expresiones separadas por coma.
proyeccionSalida
    : PROYECTAR expresion (COMA expresion)*
    ;

// Condicional de 3 caminos obligatorios: activar / recalibrar / descartar.
decisionEvaluar
    : EVALUAR expresion
      ACTIVAR bloque
      RECALIBRAR expresion bloque
      DESCARTAR bloque
    ;

// Repetición orientada a épocas y convergencia.
cicloEntrenar
    : ENTRENAR CONVERGER expresion bloque
    ;

// 2. EXPRESIONES Y PRECEDENCIA (de menor a mayor)

expresion
    : exprDisyuncion
    ;

// Nivel 11: disyunción (||), asociativa por la izquierda.
exprDisyuncion
    : exprConjuncion (DISYUNCION exprConjuncion)*
    ;

// Nivel 10: conjunción (&&), asociativa por la izquierda.
exprConjuncion
    : exprIgualdad (CONJUNCION exprIgualdad)*
    ;

// Nivel 9: igualdad y divergencia (==, !=).
exprIgualdad
    : exprRelacional ((IGUALDAD | DIVERGENCIA) exprRelacional)*
    ;

// Nivel 8: relacionales de umbral (>=, <=, >, <).
exprRelacional
    : exprTuberia ((MAYOR_IGUAL | MENOR_IGUAL | MAYOR | MENOR) exprTuberia)*
    ;

// Nivel 7: tubería de propagación de capas (~>), forward pass.
exprTuberia
    : exprAditiva (TUBERIA_CAPA exprAditiva)*
    ;

// Nivel 6: adición y sustracción (+, -).
exprAditiva
    : exprMultiplicativa ((SUMA | RESTA) exprMultiplicativa)*
    ;

// Nivel 5: multiplicación, división y módulo (*, /, %).
exprMultiplicativa
    : exprMatricial ((MULT | DIV | MOD) exprMatricial)*
    ;

// Nivel 4: producto matricial (@), asociativo por la izquierda.
exprMatricial
    : exprPotencia (PROD_MATRICIAL exprPotencia)*
    ;

// Nivel 3: potenciación (^), asociativa por la DERECHA.
exprPotencia
    : exprUnaria (POTENCIA exprPotencia)?
    ;

// Nivel 2: unarios prefijos (-, !), asociativos por la DERECHA.
exprUnaria
    : (RESTA | INHIBICION) exprUnaria
    | exprPrimaria
    ;

// Nivel 1: átomos, literales, tensores y agrupación con monitos.
exprPrimaria
    : PAREN_IZQ expresion PAREN_DER
    | tensorLiteral
    | LIT_PESO
    | LIT_INDICE
    | LIT_CORPUS
    | literalPulso
    | ID
    ;

// Literal de estado binario.
literalPulso
    : ACTIVO
    | INACTIVO
    ;

// Vectores [0.1, 0.2] y matrices [[1.0, 0.0], [0.0, 1.0]].
tensorLiteral
    : CORCHETE_IZQ (expresion (COMA expresion)*)? CORCHETE_DER
    ;

// ==========================================
// 3. REGLAS LÉXICAS (LEXER)
// ==========================================

// Palabras reservadas: estructura y flujo
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

// Palabras reservadas: tipos de datos
INDICE       : 'indice' ;
PESO         : 'peso' ;
TENSOR       : 'tensor' ;
CORPUS       : 'corpus' ;
PULSO        : 'pulso' ;

// Palabras reservadas: literales de pulso
ACTIVO       : 'activo' ;
INACTIVO     : 'inactivo' ;

// Delimitadores de agrupación con Emojis de Monitos
PAREN_IZQ    : '🐒' ;
PAREN_DER    : '🐵' ;

// Enlace, canalización y propagación
ENLACE_SINAPTICO : '<-' ;
CANAL_INGESTA    : '->' ;
TUBERIA_CAPA     : '~>' ;
PROD_MATRICIAL   : '@' ;

// Relacionales e igualdad
MAYOR_IGUAL  : '>=' ;
MENOR_IGUAL  : '<=' ;
IGUALDAD     : '==' ;
DIVERGENCIA  : '!=' ;
MAYOR        : '>' ;
MENOR        : '<' ;

// Lógicos
CONJUNCION   : '&&' ;
DISYUNCION   : '||' ;
INHIBICION   : '!' ;

// Aritméticos
POTENCIA     : '^' ;
MULT         : '*' ;
DIV          : '/' ;
MOD          : '%' ;
SUMA         : '+' ;
RESTA        : '-' ;

// Delimitadores
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
// Si la banana está al final de línea (seguida de salto de línea), es apertura de bloque multilínea hasta la siguiente banana.
// Si tiene texto en la misma línea, es comentario de una sola línea hasta el salto de línea.
COMENTARIO_BLOQUE : '🍌' [ \t]* [\r\n] .*? '🍌' -> skip ;
COMENTARIO_LINEA  : '🍌' ~[\r\n]* -> skip ;
ESPACIO_BLANCO    : [ \t\r\n\f]+ -> skip ;
```