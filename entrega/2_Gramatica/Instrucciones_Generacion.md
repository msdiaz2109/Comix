# Instrucciones para Reproducir la Generación y Pruebas — Comix (.cmx)

## 1. Requisitos
- **Java JDK:** Versión 21 o superior (probado con JDK 27).
- **Maven:** Versión 3.8+ (o el wrapper/plugin de IntelliJ).
- **ANTLR:** Versión 4.13.1.

## 2. Compilación del Proyecto
Desde la raíz del repositorio, ejecuta:
```bash
mvn compile
```

## 3. Generación del Parser y Lexer con ANTLR
Si deseas regenerar las clases del parser manualmente desde la consola:
```bash
mvn antlr4:antlr4
```
O directamente con la herramienta ANTLR Tool:
```bash
java -jar path/to/antlr-4.13.1-complete.jar -encoding UTF-8 -visitor -listener -o src/main/java/org/parser entrega/2_Gramatica/Comix.g4
```

## 4. Ejecución de las Pruebas y Generación de Árboles
Para ejecutar todas las pruebas léxicas y sintácticas (casos válidos, precedencia de operadores y casos inválidos) y generar automáticamente los árboles en SVG y PNG:
```bash
mvn exec:java -Dexec.mainClass=org.example.Main
```

## 5. Ubicación de Resultados
- **Árbol Sintáctico SVG:** `entrega/4_Arbol_Sintactico/arbol_sintactico.svg`
- **Árbol Sintáctico PNG:** `entrega/4_Arbol_Sintactico/arbol_sintactico.png`
- **Salida de Consola con Tokens:** `entrega/3_Pruebas/Evidencias_Salida_Pruebas.txt`
