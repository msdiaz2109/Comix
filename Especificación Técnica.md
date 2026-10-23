# Lenguaje Comix (.cmx) — Especificación Técnica del Lenguaje

## Fase 1 y Fase 2: Gramática en ANTLR4

## 1. Nombre del lenguaje y justificación de su diseño

Comix es un modelo de Machine Learning que opera de forma análoga al sistema nervioso de un cacomixtle: capta estímulos crudos (ingesta de muestras), los propaga por conexiones ponderadas (sinapsis y tensores), recalibra su comportamiento con la experiencia (entrenamiento por épocas) y emite respuestas adaptativas (predicciones).

El símbolo Unicode 🍌, usado para los comentarios de una línea y de bloque, junto con la agrupación de expresiones mediante los emojis de monitos 🐒 y 🐵, refuerzan una identidad visual lúdica, coherente y memorable que distingue a `.cmx` de los lenguajes tradicionales.

### 1.2 Cómo funciona Comix: Conceptos clave explicados de forma sencilla

En lugar de usar las palabras típicas de otros lenguajes (como `if`, `while` o `int`), Comix utiliza términos inspirados en el funcionamiento de una red neuronal para que el código represente directamente un proceso de aprendizaje:

1. **Vocabulario y cómo se usa:**
    - **`arquitectura` (El programa principal):** Es el contenedor donde se define todo el modelo o red neuronal.
    - **`sinapsis` (Declarar variables):** En una red, la información se almacena en las conexiones sinápticas. Se utiliza para crear variables y darles un valor inicial (por ejemplo: tasas de aprendizaje, contadores o tensores de pesos).
    - **`ajustar` (Modificar un valor):** Conforme la red aprende, recalibra sus valores. Se utiliza para actualizar una sinapsis ya creada (por ejemplo: `ajustar tasa <- tasa * 0.95`).
    - **`entrenar converger` (Repetir / Ciclo):** Es la estructura que repite las instrucciones una y otra vez (por épocas) mientras se cumpla una condición de entrenamiento.
    - **`evaluar` (Tomar decisiones con 3 opciones):** A diferencia de un condicional tradicional de dos caminos (sí / no), un modelo inteligente requiere tres posibles respuestas ante una métrica:
        - `activar`: Si la confianza es alta, el modelo aprueba y emite el resultado.
        - `recalibrar`: Si hay incertidumbre, el modelo reajusta parámetros para seguir mejorando.
        - `descartar`: Si el resultado no cumple los mínimos, se rechaza la muestra.
    - **`ingestar` y `proyectar` (Entrada y salida):** `ingestar` sirve para cargar datos o muestras desde archivos o consola, y `proyectar` muestra en pantalla predicciones y métricas.

2. **Operaciones matemáticas directas:**
    - Se cuenta con operadores nativos para álgebra lineal: el producto matricial `@` para multiplicar capas y la tubería `~>` para enviar datos hacia la siguiente capa (por ejemplo: `muestras @ pesos ~> salida`).

3. **Reglas para escribir el código (Delimitación):**
    - **Bloques:** Todo bloque (`arquitectura`, ciclo o condición) se abre con `:` y se cierra exclusivamente con `;`.
    - **Líneas simples:** Las instrucciones sencillas no llevan punto y coma al final, lo que mantiene el código limpio y legible.

---

## 2. Contexto de aplicación y problemas que representa

Comix es un Lenguaje de Dominio Específico (DSL) para especificar, preprocesar, entrenar y auditar tuberías de Machine Learning y redes neuronales artificiales. Modela cinco problemas del ciclo de vida de un modelo:

| Etapa del flujo de ML | Problema técnico que modela | Mecanismo nativo en Comix |
| --- | --- | --- |
| **1. Topología e hiperparámetros** | Declaración tipada de tasas de aprendizaje ($\alpha$), épocas, semillas, banderas de convergencia y metadatos, sin ambigüedad entre escalares discretos y pesos continuos. | `sinapsis` con tipos `indice`, `peso`, `tensor`, `corpus` y `pulso`, inicializados con el enlace sináptico `<-`. |
| **2. Ingesta y preprocesamiento tensorial** | Captura de lotes, normalización de características, producto punto entre entradas y pesos ($XW$) y propagación entre capas. | `ingestar` con canal `->`, literales matriciales `[...]`, producto `@` y tubería `~>`. |
| **3. Entrenamiento por épocas y convergencia** | Repetición de pasos de entrenamiento controlada por un límite de épocas y una tolerancia de error (*loss*). | Bloque `entrenar converger 🐒condicion🐵 :` con `ajustar` para recalibrar pesos en cada época. |
| **4. Evaluación con tres umbrales** | Un `if`/`else` binario es insuficiente: se distingue aceptación confiable, incertidumbre (recalibración) y rechazo (subajuste o anomalía). | `evaluar <cond>` con ramas `activar :`, `recalibrar <cond2> :` y `descartar :`. |
| **5. Predicciones y telemetría** | Reporte de etiquetas, probabilidades, precisión (*accuracy*) y estado final de la red. | `proyectar <expr>,...` para escalares, tensores, pulsos y corpus. |

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
| **Delimitadores y puntuación** | `:`, `;`, `[`, `]`, `,`, `🐒`, `🐵` |
| **Emoji de comentarios ($\Sigma_{emoji}$)** | 🍌 (Banana, $U+1F34C$): inicia comentario de una línea y abre/cierra comentario multilínea. |
| **Espaciado ($\Sigma_{espacio}$)** | Espacio ($U+0020$), tabulador `\t` ($U+0009$), retorno de carro `\r` ($U+000D$) y salto de línea `\n` ($U+000A$). |

### 3.2 Reglas léxicas formales

| Categoría | Descripción | Expresión regular | Ejemplos válidos |
| --- | --- | --- | --- |
| **Identificador (`ID`)** | Inicia con letra o `_`, seguido de letras, dígitos o `_`. No puede coincidir con palabras reservadas. | `[a-zA-Z_][a-zA-Z0-9_]*` | `tasa_aprendizaje`, `pesos_capa1`, `_sesgo_inicial` |
| **Literal discreto (`LIT_INDICE`)** | Uno o más dígitos, sin punto decimal. Los negativos se forman con el unario prefijo. | `[0-9]+` | `0`, `1`, `64`, `1000` |
| **Literal de precisión decimal (`LIT_PESO`)** | Dígitos, punto decimal obligatorio, dígitos fraccionarios y notación científica opcional. | `[0-9]+'.'[0-9]+([eE][+]?[0-9]+)?` | `0.001`, `0.95`, `3.14159`, `1.0e-5` |
| **Literal textual (`LIT_CORPUS`)** | Cualquier carácter UTF-8 entre comillas dobles, excepto comillas sin escapar y saltos de línea. | `"~["\r\n]*"` | `"relu"`, `"dataset_michoacan_2026.csv"` |
| **Literal de estado (`literalPulso`)** | Exclusivamente los tokens reservados `activo` (disparo) e `inactivo` (inhibición). | `activo` | `inactivo` | `activo`, `inactivo` |
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

Comix define cinco tipos propios del dominio de Machine Learning, y prohíbe los nombres convencionales (`int`, `float`, `string`, `boolean`, `entero`, `flotante`, `cadena`).

| Tipo | Representación y propósito en ML | Ejemplos de valores |
| --- | --- | --- |
| **`indice`** | Magnitud discreta de indexación y conteo. Enteros exactos: épocas, tamaño de lote, neuronas por capa, semillas, pasos de iteración. | `0`, `1`, `32`, `128`, `1000`, `-5` |
| **`peso`** | Magnitud continua de punto flotante (IEEE 754). Pesos sinápticos, sesgos, tasas de aprendizaje, pérdida, gradientes y probabilidades. | `0.001`, `0.925`, `-0.34`, `0.0`, `1.5e-4` |
| **`tensor`** | Estructura algebraica multidimensional. Vectores 1D y matrices 2D/ND sobre las que operan `@` y `~>`. | `[0.5, 0.8, 0.1]`, `[[0.2, -0.4], [0.7, 0.1]]` |
| **`corpus`** | Secuencia textual y etiquetado semántico. Cadenas inmutables: etiquetas, rutas de datasets, funciones de activación, telemetría. | `"cacomixtle michoacano"`, `"sigmoide"` |
| **`pulso`** | Estado sináptico binario. Estado de una unidad neuronal o condición de parada temprana. Solo admite `activo` e `inactivo`. | `activo`, `inactivo` |

---

## 6. Estructuras de control

Todas las estructuras de control modelan fases reales del entrenamiento y la inferencia, y comparten la regla universal de delimitación: cada bloque se abre con `:` y se cierra exclusivamente con `;`.

### 6.1 Condicional de tres caminos obligatorios: `evaluar` / `activar` / `recalibrar` / `descartar`

**Justificación semántica:** Cuando un clasificador evalúa una métrica (precisión de validación, probabilidad softmax), existen tres regímenes operativos inevitables:

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

**Justificación semántica:** El aprendizaje de una red es un proceso iterativo de optimización por épocas que busca llevar la función de pérdida hacia un mínimo. Por eso Comix no ofrece un bucle genérico. Antes de cada época se evalúa la expresión de convergencia delimitada por monitos:
`🐒epoca_actual <= limite_epocas && 🐒perdida > umbral_minimo`

Mientras la expresión produzca `activo`, se ejecuta el bloque entre `:` y `;`, donde típicamente se propagan tensores (`@`, `~>`) y se actualizan pesos con `ajustar`. Cuando la condición pasa a `inactivo`, el entrenamiento termina y el flujo continúa tras el `;` de cierre.

**Regla gramatical (EBNF):**

```
cicloEntrenar
    : 'entrenar' 'converger' expresion bloque
    ;
```

---

## 7. Reglas preliminares del lenguaje

### 7.1 Declaración de sinapsis y ajuste de valores

Para alejarse de la declaración imperativa de C/Java (`int x = 10;`), Comix separa la creación de un nodo de memoria (`sinapsis`) de la recalibración de su valor (`ajustar`), usando el enlace `<-` y sin `;` al final.

| Instrucción | Estructura | Semántica | Ejemplo |
| --- | --- | --- | --- |
| **Declaración** | `sinapsis <tipoDato> <ID> <- <expresion>` | Reserva una conexión tipada en la arquitectura y le enlaza su estado inicial. | `sinapsis peso tasa_alfa <- 0.005` |
| **Actualización** | `ajustar <ID> <- <expresion>` | Modifica una sinapsis ya declarada (recalibración de parámetros). | `ajustar tasa_alfa <- tasa_alfa * 0.95` |

### 7.2 Precedencia y asociatividad de operadores

Las expresiones combinan operandos escalares (`indice`, `peso`), matriciales (`tensor`), textuales (`corpus`) y lógicos (`pulso`). La tabla establece 12 niveles, de mayor (1) a menor (12) precedencia:

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

1. **Bloques con `:` y `;`:** Los dos puntos abren el bloque y el punto y coma lo cierra. Ninguna instrucción simple lleva `;` al final.
2. **Espacios en blanco:** Espacios, tabulaciones y saltos de línea solo separan tokens y se descartan (`> skip`).
3. **Comentarios con Emoji de Banana 🍌:**
    - Una línea: inicia con 🍌 y llega hasta el final de la línea.
    - Multilínea: se abre con 🍌 y se cierra con 🍌.

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
sinapsis tensor salida_capa <- 🐒muestras_lote @ pesos_ocultos + sesgo_capa * 0.52 ~> mapa_activacion
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

La siguiente instrucción combina nueve operadores con la sintaxis de monitos `🐒 🐵`:

```
sinapsis pulso decision_capa <- 🐒🐒entrada @ pesos + sesgo * 🐒factor ^ 2🐵 ~> capa_norm >= 0.75🐵 && 🐒!inhibidor_activo🐵🐵
```

**Orden de evaluación paso a paso:**

| Paso | Nivel | Operación | Resultado |
| --- | --- | --- | --- |
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

**Inválido 1: tres caminos incompletos y punto y coma en instrucción simple:**

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
| --- | --- | --- |
| **1** | Delimitación de bloques | El `;` no pertenece a `declaracionSinapsis`. El parser lo toma como cierre prematuro del bloque raíz. Reporta: `extraneous input ';' expecting <EOF>`. |
| **2** | `decisionEvaluar` | La regla exige `ACTIVAR` bloque `RECALIBRAR` expresion bloque `DESCARTAR` bloque. Al omitir `recalibrar`, reporta: `mismatched input 'descartar' expecting 'recalibrar'`. |

**Inválido 2: palabras prohibidas y literal de peso malformado:**

```
arquitectura RedInvalidaDos :
    flotante tasa <- .05               🍌 ERROR 1: 'flotante' prohibida y .05 sin parte entera

    mientras tasa < 1.0 :             🍌 ERROR 2: palabra prohibida 'mientras'
        ajustar tasa <- tasa + 0.1
    ;
;
```

| # | Regla violada | Diagnóstico de ANTLR4 |
| --- | --- | --- |
| **1** | Vocabulario y `LIT_PESO` | `flotante` no existe en Comix (debe usarse `peso`). Además `.05` incumple `[0-9]+'.'[0-9]+` y produce: `token recognition error at: '.'`. |
| **2** | Palabra prohibida | `mientras` no es un token del lenguaje (la forma válida es `entrenar converger`). Reporta: `no viable alternative at input 'mientras'`. |

---

## 9. Implementación de la gramática en ANTLR4 (`Comix.g4`)

```
grammar Comix;

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
    : CORCHETE_IZQ expresion (COMA expresion)* CORCHETE_DER
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
LIT_PESO     : [0-9]+ '.' [0-9]+ ([eE] [+]? [0-9]+)? ;
LIT_INDICE   : [0-9]+ ;
LIT_CORPUS   : '"' (~["\r\n])* '"' ;
ID           : [a-zA-Z_] [a-zA-Z0-9_]* ;

// Comentarios con Emoji de Banana 🍌 y Espacios en blanco
// Si la banana está al final de línea (seguida de salto de línea), es apertura de bloque multilínea hasta la siguiente banana.
// Si tiene texto en la misma línea, es comentario de una sola línea hasta el salto de línea.
COMENTARIO_BLOQUE : '🍌' [ \t]* [\r\n] .*? '🍌' -> skip ;
COMENTARIO_LINEA  : '🍌' ~[\r\n]* -> skip ;
ESPACIO_BLANCO    : [ \t\r\n\f]+ -> skip ;
```