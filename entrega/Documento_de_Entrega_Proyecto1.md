# Instituto Tecnológico — Lenguajes y Autómatas II
## T2 Proyecto 1 (Parte 1: Análisis Léxico y Sintáctico)
### Diseño de un Lenguaje de Programación Propio: Lenguaje Comix (.cmx)

---

### Datos Generales del Proyecto

- **Materia:** Lenguajes y Autómatas II
- **Docente:** M.S.C. Alma Lilia Núñez González
- **Equipo:** ComixTech
- **Nombre del Lenguaje:** Comix
- **Extensión Oficial:** `.cmx`
- **Contexto de Aplicación:** Redes Neuronales Artificiales y Flujos de Machine Learning (inspirado en la agilidad sensorial del cacomixtle de Michoacán)
- **Repositorio Oficial en GitHub:** [https://github.com/msdiaz2109/Comix](https://github.com/msdiaz2109/Comix)
- **Rama Principal:** `main`

---

## 1. Índice de Enlaces a GitHub por Fases y Entregables

A continuación se presentan los enlaces directos a cada uno de los archivos correspondientes a los requerimientos oficiales de la materia.

### Entregable 1: Documentación (Fase 1 - Especificación del Lenguaje)
Documento integral con la justificación del lenguaje, alfabeto formal, tablas de tokens, tabla de tipos de datos propios, estructuras de decisión obligatoria de 3 caminos, ciclo por épocas, 12 niveles de precedencia y delimitación simétrica.
- **Enlace en GitHub:**  
  [Especificacion_Tecnica_Comix.md](https://github.com/msdiaz2109/Comix/blob/main/entrega/1_Documentacion/Especificacion_Tecnica_Comix.md)

---

### Entregable 2: Gramática Formal (Fase 2 - Implementación en ANTLR4)
Archivo `.g4` que define las reglas sintácticas y léxicas del lenguaje Comix, con cada una de sus secciones y reglas comentadas detallando su función dentro del flujo de Machine Learning. Incluye la guía para reproducir la compilación.
- **Archivo de Gramática (.g4):**  
  [Comix.g4](https://github.com/msdiaz2109/Comix/blob/main/entrega/2_Gramatica/Comix.g4)
- **Instrucciones para Reproducir la Generación:**  
  [Instrucciones_Generacion.md](https://github.com/msdiaz2109/Comix/blob/main/entrega/2_Gramatica/Instrucciones_Generacion.md)

---

### Entregable 3: Pruebas del Lenguaje (Fase 3 - Validación de Casos)
Suite de pruebas con la extensión propia `.cmx`, que cubre programas válidos, demostración de precedencia con operadores nativos y casos inválidos con diagnóstico de rechazo.
- **Directorio de Pruebas en GitHub:**  
  [Carpeta de Pruebas (.cmx)](https://github.com/msdiaz2109/Comix/tree/main/entrega/3_Pruebas)
- **Programa Completo Válido (Red Neuronal Bioacústica):**  
  [clasificador_cacomixtle.cmx](https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/clasificador_cacomixtle.cmx)
- **Prueba de Precedencia de Operadores (12 niveles):**  
  [precedencia_expresion.cmx](https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/precedencia_expresion.cmx)
- **Caso Inválido 1 (Delimitación incorrecta y ramas incompletas):**  
  [invalido1_tres_caminos.cmx](https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/invalido1_tres_caminos.cmx)
- **Caso Inválido 2 (Palabras reservadas prohibidas y literal malformado):**  
  [invalido2_palabras_prohibidas.cmx](https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/invalido2_palabras_prohibidas.cmx)
- **Evidencia de Salida en Consola (Tokens y Diagnósticos):**  
  [Evidencias_Salida_Pruebas.txt](https://github.com/msdiaz2109/Comix/blob/main/entrega/3_Pruebas/Evidencias_Salida_Pruebas.txt)

---

### Entregable 4: Árbol Sintáctico (Fase 3 - Visualización y Exportación)
Representación gráfica y vectorial del árbol de análisis sintáctico generado a partir del programa principal `clasificador_cacomixtle.cmx`.
- **Árbol Sintáctico Vectorial Oficial (.svg):**  
  [arbol_sintactico.svg](https://github.com/msdiaz2109/Comix/blob/main/entrega/4_Arbol_Sintactico/arbol_sintactico.svg)
- **Árbol Sintáctico en Imagen Rasterizada (.png):**  
  [arbol_sintactico.png](https://github.com/msdiaz2109/Comix/blob/main/entrega/4_Arbol_Sintactico/arbol_sintactico.png)

---

### Entregable 5: Bitácora de Desarrollo (Fase 4 - Evidencias de Depuración)
Registro cronológico de las incidencias reales enfrentadas durante la implementación, incluyendo la solución a la ambigüedad léxica del emoji banana (🍌), balanceo de caracteres suplementarios (🐒 🐵), y rechazo estricto de delimitadores indebidos y palabras prohibidas.
- **Enlace a la Bitácora:**  
  [Bitacora_de_Desarrollo.md](https://github.com/msdiaz2109/Comix/blob/main/entrega/5_Bitacora/Bitacora_de_Desarrollo.md)

---

### Entregable 6: Presentación en Video (1 Minuto)
Estructura y guion técnico cronometrado para la exposición en video de 60 segundos del proyecto en Microsoft Teams.
- **Guion de la Presentación:**  
  [Guion_Video_Presentacion.md](https://github.com/msdiaz2109/Comix/blob/main/entrega/6_Presentacion/Guion_Video_Presentacion.md)
- **Enlace al Video:** *(Se comparte el archivo / enlace de acceso en el canal general de Teams de la materia)*

---

### Código Fuente del Compilador y Ejecutor de Pruebas
- **Clase Principal Java (Parser, Listener y Exportador SVG/PNG):**  
  [Main.java](https://github.com/msdiaz2109/Comix/blob/main/src/main/java/org/example/Main.java)
- **Archivo de Configuración de Dependencias:**  
  [pom.xml](https://github.com/msdiaz2109/Comix/blob/main/pom.xml)

---

## 2. Matriz de Cumplimiento de Requerimientos Técnicos

| Requerimiento Técnico Mínimo | Elemento Implementado en Comix | Archivo / Regla de Referencia |
| :--- | :--- | :--- |
| **1. Tipos de datos propios (mínimo 3)** | 5 tipos: `indice`, `peso`, `tensor`, `corpus`, `pulso` | `Comix.g4` (regla `tipoDato`) |
| **2. Declaración y asignación propia** | `sinapsis <tipo> <id> <- <expr>` y `ajustar <id> <- <expr>` | `Comix.g4` (`declaracionSinapsis`, `ajusteSinapsis`) |
| **3. Expresiones con precedencia definida** | 12 niveles formales (`@`, `^`, `*`, `/`, `+`, `-`, `~>`, relacionales, booleanos) | `Comix.g4` (`expresion`, `exprMatricial`, etc.) |
| **4. Decisión con tres caminos de ejecución** | `evaluar <c1> activar : ... ; recalibrar <c2> : ... ; descartar : ... ;` | `Comix.g4` (`decisionEvaluar`) |
| **5. Repetición orientada al contexto** | `entrenar converger 🐒condicion🐵 : ... ;` | `Comix.g4` (`cicloEntrenar`) |
| **6. Entrada y salida propias** | `ingestar` (flujo `->`) y `proyectar` (telemetría / salida) | `Comix.g4` (`ingestaDatos`, `proyeccionSalida`) |
| **7. Delimitación de instrucciones y bloques** | Bloques simétricos con `:` y `;`. Instrucciones simples sin `;` | `Comix.g4` (`bloque`) |
| **8. Comentarios y espacios ignorados** | Comentarios con banana `🍌` (línea y bloque multilínea) y espacios con `skip` | `Comix.g4` (`COMENTARIO_BLOQUE`, `COMENTARIO_LINEA`) |

---

## 3. Instrucciones de Clonación y Ejecución

Para clonar y reproducir las pruebas del proyecto localmente:

```bash
# 1. Clonar el repositorio
git clone https://github.com/msdiaz2109/Comix.git
cd Comix

# 2. Compilar el proyecto con Maven
mvn compile

# 3. Ejecutar la suite completa de pruebas
mvn exec:java -Dexec.mainClass=org.example.Main
```

El ejecutor evaluará automáticamente los archivos `.cmx` en consola y regenerará los árboles sintácticos en las rutas:
- `entrega/4_Arbol_Sintactico/arbol_sintactico.svg`
- `entrega/4_Arbol_Sintactico/arbol_sintactico.png`
