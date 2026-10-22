// Generated from src/main/java/org/parser/MiGramatica.g4 by ANTLR 4.13.1

    package org.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiGramaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiGramaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(MiGramaticaParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(MiGramaticaParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(MiGramaticaParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#declaracionSinapsis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionSinapsis(MiGramaticaParser.DeclaracionSinapsisContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#ajusteSinapsis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAjusteSinapsis(MiGramaticaParser.AjusteSinapsisContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#tipoDato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoDato(MiGramaticaParser.TipoDatoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#ingestaDatos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIngestaDatos(MiGramaticaParser.IngestaDatosContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#proyeccionSalida}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProyeccionSalida(MiGramaticaParser.ProyeccionSalidaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#decisionEvaluar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecisionEvaluar(MiGramaticaParser.DecisionEvaluarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#cicloEntrenar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicloEntrenar(MiGramaticaParser.CicloEntrenarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(MiGramaticaParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#exprDisyuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDisyuncion(MiGramaticaParser.ExprDisyuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#exprConjuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprConjuncion(MiGramaticaParser.ExprConjuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#exprIgualdad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIgualdad(MiGramaticaParser.ExprIgualdadContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#exprRelacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRelacional(MiGramaticaParser.ExprRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#exprTuberia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTuberia(MiGramaticaParser.ExprTuberiaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#exprAditiva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAditiva(MiGramaticaParser.ExprAditivaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#exprMultiplicativa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultiplicativa(MiGramaticaParser.ExprMultiplicativaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#exprMatricial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMatricial(MiGramaticaParser.ExprMatricialContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#exprPotencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPotencia(MiGramaticaParser.ExprPotenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#exprUnaria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnaria(MiGramaticaParser.ExprUnariaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#exprPrimaria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPrimaria(MiGramaticaParser.ExprPrimariaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#literalPulso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralPulso(MiGramaticaParser.LiteralPulsoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiGramaticaParser#tensorLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTensorLiteral(MiGramaticaParser.TensorLiteralContext ctx);
}