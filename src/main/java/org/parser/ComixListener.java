// Generated from src/main/java/org/parser/Comix.g4 by ANTLR 4.13.1

    package org.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ComixParser}.
 */
public interface ComixListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ComixParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(ComixParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(ComixParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(ComixParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(ComixParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(ComixParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(ComixParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#declaracionSinapsis}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionSinapsis(ComixParser.DeclaracionSinapsisContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#declaracionSinapsis}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionSinapsis(ComixParser.DeclaracionSinapsisContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#ajusteSinapsis}.
	 * @param ctx the parse tree
	 */
	void enterAjusteSinapsis(ComixParser.AjusteSinapsisContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#ajusteSinapsis}.
	 * @param ctx the parse tree
	 */
	void exitAjusteSinapsis(ComixParser.AjusteSinapsisContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void enterTipoDato(ComixParser.TipoDatoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void exitTipoDato(ComixParser.TipoDatoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#ingestaDatos}.
	 * @param ctx the parse tree
	 */
	void enterIngestaDatos(ComixParser.IngestaDatosContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#ingestaDatos}.
	 * @param ctx the parse tree
	 */
	void exitIngestaDatos(ComixParser.IngestaDatosContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#proyeccionSalida}.
	 * @param ctx the parse tree
	 */
	void enterProyeccionSalida(ComixParser.ProyeccionSalidaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#proyeccionSalida}.
	 * @param ctx the parse tree
	 */
	void exitProyeccionSalida(ComixParser.ProyeccionSalidaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#decisionEvaluar}.
	 * @param ctx the parse tree
	 */
	void enterDecisionEvaluar(ComixParser.DecisionEvaluarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#decisionEvaluar}.
	 * @param ctx the parse tree
	 */
	void exitDecisionEvaluar(ComixParser.DecisionEvaluarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#cicloEntrenar}.
	 * @param ctx the parse tree
	 */
	void enterCicloEntrenar(ComixParser.CicloEntrenarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#cicloEntrenar}.
	 * @param ctx the parse tree
	 */
	void exitCicloEntrenar(ComixParser.CicloEntrenarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(ComixParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(ComixParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#exprDisyuncion}.
	 * @param ctx the parse tree
	 */
	void enterExprDisyuncion(ComixParser.ExprDisyuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#exprDisyuncion}.
	 * @param ctx the parse tree
	 */
	void exitExprDisyuncion(ComixParser.ExprDisyuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#exprConjuncion}.
	 * @param ctx the parse tree
	 */
	void enterExprConjuncion(ComixParser.ExprConjuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#exprConjuncion}.
	 * @param ctx the parse tree
	 */
	void exitExprConjuncion(ComixParser.ExprConjuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#exprIgualdad}.
	 * @param ctx the parse tree
	 */
	void enterExprIgualdad(ComixParser.ExprIgualdadContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#exprIgualdad}.
	 * @param ctx the parse tree
	 */
	void exitExprIgualdad(ComixParser.ExprIgualdadContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#exprRelacional}.
	 * @param ctx the parse tree
	 */
	void enterExprRelacional(ComixParser.ExprRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#exprRelacional}.
	 * @param ctx the parse tree
	 */
	void exitExprRelacional(ComixParser.ExprRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#exprTuberia}.
	 * @param ctx the parse tree
	 */
	void enterExprTuberia(ComixParser.ExprTuberiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#exprTuberia}.
	 * @param ctx the parse tree
	 */
	void exitExprTuberia(ComixParser.ExprTuberiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#exprAditiva}.
	 * @param ctx the parse tree
	 */
	void enterExprAditiva(ComixParser.ExprAditivaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#exprAditiva}.
	 * @param ctx the parse tree
	 */
	void exitExprAditiva(ComixParser.ExprAditivaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#exprMultiplicativa}.
	 * @param ctx the parse tree
	 */
	void enterExprMultiplicativa(ComixParser.ExprMultiplicativaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#exprMultiplicativa}.
	 * @param ctx the parse tree
	 */
	void exitExprMultiplicativa(ComixParser.ExprMultiplicativaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#exprMatricial}.
	 * @param ctx the parse tree
	 */
	void enterExprMatricial(ComixParser.ExprMatricialContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#exprMatricial}.
	 * @param ctx the parse tree
	 */
	void exitExprMatricial(ComixParser.ExprMatricialContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#exprPotencia}.
	 * @param ctx the parse tree
	 */
	void enterExprPotencia(ComixParser.ExprPotenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#exprPotencia}.
	 * @param ctx the parse tree
	 */
	void exitExprPotencia(ComixParser.ExprPotenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#exprUnaria}.
	 * @param ctx the parse tree
	 */
	void enterExprUnaria(ComixParser.ExprUnariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#exprUnaria}.
	 * @param ctx the parse tree
	 */
	void exitExprUnaria(ComixParser.ExprUnariaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#exprPrimaria}.
	 * @param ctx the parse tree
	 */
	void enterExprPrimaria(ComixParser.ExprPrimariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#exprPrimaria}.
	 * @param ctx the parse tree
	 */
	void exitExprPrimaria(ComixParser.ExprPrimariaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#literalPulso}.
	 * @param ctx the parse tree
	 */
	void enterLiteralPulso(ComixParser.LiteralPulsoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#literalPulso}.
	 * @param ctx the parse tree
	 */
	void exitLiteralPulso(ComixParser.LiteralPulsoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComixParser#tensorLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTensorLiteral(ComixParser.TensorLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComixParser#tensorLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTensorLiteral(ComixParser.TensorLiteralContext ctx);
}