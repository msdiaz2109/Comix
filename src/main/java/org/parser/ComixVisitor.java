// Generated from src/main/java/org/parser/Comix.g4 by ANTLR 4.13.1

    package org.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ComixParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ComixVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ComixParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(ComixParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(ComixParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(ComixParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#declaracionSinapsis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionSinapsis(ComixParser.DeclaracionSinapsisContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#ajusteSinapsis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAjusteSinapsis(ComixParser.AjusteSinapsisContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#tipoDato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoDato(ComixParser.TipoDatoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#ingestaDatos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIngestaDatos(ComixParser.IngestaDatosContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#proyeccionSalida}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProyeccionSalida(ComixParser.ProyeccionSalidaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#decisionEvaluar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecisionEvaluar(ComixParser.DecisionEvaluarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#cicloEntrenar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicloEntrenar(ComixParser.CicloEntrenarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(ComixParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#exprDisyuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDisyuncion(ComixParser.ExprDisyuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#exprConjuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprConjuncion(ComixParser.ExprConjuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#exprIgualdad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIgualdad(ComixParser.ExprIgualdadContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#exprRelacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRelacional(ComixParser.ExprRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#exprTuberia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTuberia(ComixParser.ExprTuberiaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#exprAditiva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAditiva(ComixParser.ExprAditivaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#exprMultiplicativa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultiplicativa(ComixParser.ExprMultiplicativaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#exprMatricial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMatricial(ComixParser.ExprMatricialContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#exprPotencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPotencia(ComixParser.ExprPotenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#exprUnaria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnaria(ComixParser.ExprUnariaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#exprPrimaria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPrimaria(ComixParser.ExprPrimariaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#literalPulso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralPulso(ComixParser.LiteralPulsoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ComixParser#tensorLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTensorLiteral(ComixParser.TensorLiteralContext ctx);
}