# Lenguaje Comix (.cmx) — Proyecto 1: Análisis Léxico y Sintáctico

| Campo | Detalle |
| :--- | :--- |
| **Materia** | Lenguajes y Autómatas II |
| **Docente** | M.S.C. Alma Lilia Núñez González |
| **Equipo** | ComixTech |
| **Lenguaje** | Comix |
| **Extensión** | `.cmx` |
| **Paradigma** | Declarativo / Imperativo orientado a Machine Learning y Redes Neuronales |

---

## Estructura Oficial de Entrega

Todo el proyecto se encuentra estrictamente organizado en la carpeta `entrega/`, estructurada de acuerdo con los 6 requerimientos oficiales de la rúbrica:

```text
COMIX/
│
├── entrega/
│   ├── 1_Documentacion/
│   │   └── Especificacion_Tecnica_Comix.md   # Especificación técnica completa, alfabeto, tokens y reglas
│   │
│   ├── 2_Gramatica/
│   │   ├── Comix.g4                         # Gramática formal en ANTLR4 completamente comentada
│   │   └── Instrucciones_Generacion.md      # Instrucciones de compilación y reproducción
│   │
│   ├── 3_Pruebas/
│   │   ├── clasificador_cacomixtle.cmx      # Programa completo válido
│   │   ├── precedencia_expresion.cmx        # Expresión con 12 niveles de precedencia
│   │   ├── invalido1_tres_caminos.cmx       # Caso inválido 1 (delimitación y ramas incompletas)
│   │   ├── invalido2_palabras_prohibidas.cmx# Caso inválido 2 (palabras prohibidas y literal malformado)
│   │   └── Evidencias_Salida_Pruebas.txt    # Registro completo de la ejecución y tokens reconocidos
│   │
│   ├── 4_Arbol_Sintactico/
│   │   ├── arbol_sintactico.svg             # Árbol sintáctico vectorial oficial (.svg)
│   │   └── arbol_sintactico.png             # Árbol sintáctico en formato gráfico (.png)
│   │
│   ├── 5_Bitacora/
│   │   └── Bitacora_de_Desarrollo.md        # Bitácora con evidencias reales de depuración
│   │
│   └── 6_Presentacion/
│       └── Guion_Video_Presentacion.md      # Guion medido para el video de 1 minuto
│
├── src/                                     # Código fuente Java del analizador y pruebas
│   ├── main/java/org/example/Main.java      # Ejecutor principal de pruebas y exportador de SVG/PNG
│   └── main/java/org/parser/                # Clases generadas por ANTLR4
│
└── pom.xml                                  # Configuración de dependencias Maven y ANTLR4
```

---

## Cómo Ejecutar el Proyecto

Desde la terminal en la raíz del proyecto:
```bash
# Compilar el proyecto
mvn compile

# Ejecutar el analizador léxico y sintáctico sobre todos los casos de prueba
mvn exec:java -Dexec.mainClass=org.example.Main
```
Esto analizará todos los archivos de prueba, imprimirá los tokens, validará la sintaxis y exportará automáticamente los árboles sintácticos en SVG y PNG.
