package org.example;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.parser.ComixBaseVisitor;
import org.parser.ComixLexer;
import org.parser.ComixParser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String DIRBASE = "src/main/test/resources/";
    private static final String[] FILES = {
            "clasificador_cacomixtle.cmx",
            "precedencia_expresion.cmx",
            "invalido1_tres_caminos.cmx",
            "invalido2_palabras_prohibidas.cmx"
    };

    // Listener para recolectar errores léxicos y sintácticos
    private static class ErrorCollector extends BaseErrorListener {
        final List<String> errors = new ArrayList<>();

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                int line, int charPositionInLine, String msg,
                                RecognitionException e) {
            String source = (recognizer instanceof Lexer) ? "LÉXICO" : "SINTÁCTICO";
            errors.add(String.format("[%s] Línea %d:%d -> %s", source, line, charPositionInLine, msg));
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("================================================================================");
        System.out.println("           LENGUAJE COMIX (.cmx) - COMPILADOR Y PARSER ANTLR4                   ");
        System.out.println("================================================================================");
        System.out.println("Directorio de pruebas: " + DIRBASE + "\n");

        String[] filesToRun = (args != null && args.length > 0) ? args : FILES;

        for (String file : filesToRun) {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println(">>> ANALIZANDO ARCHIVO: " + file);
            System.out.println("--------------------------------------------------------------------------------");

            File sourceFile = new File(file);
            if (!sourceFile.exists()) {
                sourceFile = new File(DIRBASE + file);
            }
            if (!sourceFile.exists()) {
                sourceFile = new File("entrega/3_Pruebas/" + file);
            }
            if (!sourceFile.exists()) {
                System.err.println("Archivo no encontrado: " + file);
                continue;
            }

            // 1. Cargar archivo con codificación UTF-8 para soportar emojis 🐒 🐵 🍌
            CharStream in = CharStreams.fromPath(sourceFile.toPath(), StandardCharsets.UTF_8);

            // 2. Análisis Léxico
            ComixLexer lexer = new ComixLexer(in);
            ErrorCollector lexerErrors = new ErrorCollector();
            lexer.removeErrorListeners();
            lexer.addErrorListener(lexerErrors);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            tokens.fill();

            System.out.println("\n[1] TOKENS RECONOCIDOS (" + tokens.getTokens().size() + " tokens):");
            int tokenCount = 0;
            for (Token token : tokens.getTokens()) {
                if (token.getType() == Token.EOF) continue;
                String tokenName = ComixLexer.VOCABULARY.getSymbolicName(token.getType());
                System.out.printf("  #%-3d | L%-3d:C%-3d | %-20s | '%s'%n",
                        ++tokenCount, token.getLine(), token.getCharPositionInLine(), tokenName, token.getText());
            }

            // 3. Análisis Sintáctico
            ComixParser parser = new ComixParser(tokens);
            ErrorCollector parserErrors = new ErrorCollector();
            parser.removeErrorListeners();
            parser.addErrorListener(parserErrors);

            ComixParser.ProgramaContext tree = parser.programa();

            // 4. Reporte de Validación
            List<String> allErrors = new ArrayList<>();
            allErrors.addAll(lexerErrors.errors);
            allErrors.addAll(parserErrors.errors);

            if (allErrors.isEmpty()) {
                System.out.println("\n[2] RESULTADO SINTÁCTICO: VALIDACIÓN EXITOSA (0 errores)");
                System.out.println("\n[3] ÁRBOL SINTÁCTICO (Notación textual LISP):");
                System.out.println(tree.toStringTree(parser));

                // Visitor opcional
                ComixBaseVisitor<Object> visitor = new ComixBaseVisitor<>() {
                    @Override
                    public Object visitPrograma(ComixParser.ProgramaContext ctx) {
                        System.out.println("\n[4] VISITOR: Arquitectura '" + ctx.ID().getText() + "' contiene "
                                + ctx.bloque().instruccion().size() + " instrucción(es) en el bloque principal.");
                        return super.visitPrograma(ctx);
                    }
                };
                visitor.visit(tree);

                // Exportar Árboles para el archivo principal
                if (file.equals("clasificador_cacomixtle.cmx")) {
                    exportarArbolGrafico(tree, parser, "antlr4_parse_tree.png");
                    exportarArbolGrafico(tree, parser, "entrega/4_Arbol_Sintactico/arbol_sintactico.png");
                    exportarArbolSvg(tree, parser, "arbol_sintactico.svg");
                    exportarArbolSvg(tree, parser, "entrega/4_Arbol_Sintactico/arbol_sintactico.svg");
                    try {
                        if (!GraphicsEnvironment.isHeadless()) {
                            Trees.inspect(tree, parser);
                        }
                    } catch (Exception ignored) {
                    }
                }
            } else {
                System.out.println("\n[2] RESULTADO: ARCHIVO RECHAZADO (" + allErrors.size() + " errores detectados)");
                for (String err : allErrors) {
                    System.err.println("  [-] " + err);
                }
            }
            System.out.println();
        }

        System.out.println("================================================================================");
        System.out.println("        PROCESO DE ANÁLISIS COMPLETADO PARA TODOS LOS CASOS DE PRUEBA           ");
        System.out.println("================================================================================");
    }

    /**
     * Renderiza el ParseTree en una imagen PNG nítida.
     */
    private static void exportarArbolGrafico(ParseTree tree, Parser parser, String filename) {
        try {
            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.setFont(new Font("Consolas", Font.PLAIN, 12));
            viewer.setScale(1.1);

            Dimension size = viewer.getPreferredSize();
            if (size.width <= 0) size.width = 1200;
            if (size.height <= 0) size.height = 800;
            viewer.setSize(size);

            BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, size.width, size.height);
            viewer.paint(g2d);
            g2d.dispose();

            ImageIO.write(image, "png", new File(filename));
            System.out.println("  -> [EXPORTACIÓN] Árbol gráfico PNG generado en: " + filename);
        } catch (Exception e) {
            System.err.println("  -> Error al exportar PNG: " + e.getMessage());
        }
    }

    /**
     * Exporta el ParseTree directamente a un archivo SVG vectorial estandarizado.
     */
    private static void exportarArbolSvg(ParseTree tree, Parser parser, String filename) {
        try {
            SvgNode root = buildSvgTree(tree, parser, 0);
            layoutSvgTree(root, 20, 30);

            double maxX = getMaxX(root) + 80;
            double maxY = getMaxY(root) + 80;

            StringBuilder svg = new StringBuilder();
            svg.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            svg.append(String.format("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"%.0f\" height=\"%.0f\" viewBox=\"0 0 %.0f %.0f\">\n",
                    maxX, maxY, maxX, maxY));
            svg.append("  <style>\n");
            svg.append("    text { font-family: 'Consolas', monospace; font-size: 11px; fill: #1e293b; }\n");
            svg.append("    .rule-box { fill: #e0f2fe; stroke: #0284c7; stroke-width: 1.5; rx: 6; }\n");
            svg.append("    .token-box { fill: #fef08a; stroke: #ca8a04; stroke-width: 1.5; rx: 4; }\n");
            svg.append("    .edge { stroke: #94a3b8; stroke-width: 1.2; fill: none; }\n");
            svg.append("  </style>\n");
            svg.append("  <rect width=\"100%\" height=\"100%\" fill=\"#ffffff\"/>\n");

            renderSvgEdges(svg, root);
            renderSvgNodes(svg, root);

            svg.append("</svg>\n");

            try (FileWriter writer = new FileWriter(filename, StandardCharsets.UTF_8)) {
                writer.write(svg.toString());
            }
            System.out.println("  -> [EXPORTACIÓN] Árbol vectorial SVG generado en: " + filename);
        } catch (Exception e) {
            System.err.println("  -> Error al exportar SVG: " + e.getMessage());
        }
    }

    private static class SvgNode {
        String label;
        boolean isToken;
        int depth;
        double x, y, width, height;
        List<SvgNode> children = new ArrayList<>();
    }

    private static SvgNode buildSvgTree(ParseTree tree, Parser parser, int depth) {
        SvgNode node = new SvgNode();
        node.depth = depth;
        if (tree instanceof RuleContext) {
            int ruleIndex = ((RuleContext) tree).getRuleIndex();
            node.label = parser.getRuleNames()[ruleIndex];
            node.isToken = false;
        } else {
            node.label = tree.getText().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
            node.isToken = true;
        }
        node.width = Math.max(40, node.label.length() * 8 + 16);
        node.height = 24;

        for (int i = 0; i < tree.getChildCount(); i++) {
            node.children.add(buildSvgTree(tree.getChild(i), parser, depth + 1));
        }
        return node;
    }

    private static double currentLeafX = 40;

    private static void layoutSvgTree(SvgNode node, double startX, double levelGap) {
        currentLeafX = 40;
        assignPositions(node, 40);
    }

    private static double assignPositions(SvgNode node, double y) {
        node.y = y;
        if (node.children.isEmpty()) {
            node.x = currentLeafX;
            currentLeafX += node.width + 15;
            return node.x;
        } else {
            double firstChildX = 0;
            double lastChildX = 0;
            for (int i = 0; i < node.children.size(); i++) {
                double cx = assignPositions(node.children.get(i), y + 55);
                if (i == 0) firstChildX = cx;
                if (i == node.children.size() - 1) lastChildX = cx;
            }
            node.x = (firstChildX + lastChildX) / 2.0;
            return node.x;
        }
    }

    private static double getMaxX(SvgNode node) {
        double max = node.x + node.width;
        for (SvgNode ch : node.children) {
            max = Math.max(max, getMaxX(ch));
        }
        return max;
    }

    private static double getMaxY(SvgNode node) {
        double max = node.y + node.height;
        for (SvgNode ch : node.children) {
            max = Math.max(max, getMaxY(ch));
        }
        return max;
    }

    private static void renderSvgEdges(StringBuilder svg, SvgNode node) {
        for (SvgNode child : node.children) {
            svg.append(String.format("  <line class=\"edge\" x1=\"%.1f\" y1=\"%.1f\" x2=\"%.1f\" y2=\"%.1f\"/>\n",
                    node.x + node.width / 2.0, node.y + node.height,
                    child.x + child.width / 2.0, child.y));
            renderSvgEdges(svg, child);
        }
    }

    private static void renderSvgNodes(StringBuilder svg, SvgNode node) {
        String boxClass = node.isToken ? "token-box" : "rule-box";
        svg.append(String.format("  <rect class=\"%s\" x=\"%.1f\" y=\"%.1f\" width=\"%.1f\" height=\"%.1f\"/>\n",
                boxClass, node.x, node.y, node.width, node.height));
        svg.append(String.format("  <text x=\"%.1f\" y=\"%.1f\" text-anchor=\"middle\" dominant-baseline=\"central\">%s</text>\n",
                node.x + node.width / 2.0, node.y + node.height / 2.0, node.label));
        for (SvgNode child : node.children) {
            renderSvgNodes(svg, child);
        }
    }
}