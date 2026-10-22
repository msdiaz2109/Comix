// Generated from src/main/java/org/parser/MiGramatica.g4 by ANTLR 4.13.1

    package org.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiGramaticaParser}.
 */
public interface MiGramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(MiGramaticaParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(MiGramaticaParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(MiGramaticaParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(MiGramaticaParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(MiGramaticaParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(MiGramaticaParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#declaracionSinapsis}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionSinapsis(MiGramaticaParser.DeclaracionSinapsisContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#declaracionSinapsis}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionSinapsis(MiGramaticaParser.DeclaracionSinapsisContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#ajusteSinapsis}.
	 * @param ctx the parse tree
	 */
	void enterAjusteSinapsis(MiGramaticaParser.AjusteSinapsisContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#ajusteSinapsis}.
	 * @param ctx the parse tree
	 */
	void exitAjusteSinapsis(MiGramaticaParser.AjusteSinapsisContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void enterTipoDato(MiGramaticaParser.TipoDatoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void exitTipoDato(MiGramaticaParser.TipoDatoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#ingestaDatos}.
	 * @param ctx the parse tree
	 */
	void enterIngestaDatos(MiGramaticaParser.IngestaDatosContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#ingestaDatos}.
	 * @param ctx the parse tree
	 */
	void exitIngestaDatos(MiGramaticaParser.IngestaDatosContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#proyeccionSalida}.
	 * @param ctx the parse tree
	 */
	void enterProyeccionSalida(MiGramaticaParser.ProyeccionSalidaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#proyeccionSalida}.
	 * @param ctx the parse tree
	 */
	void exitProyeccionSalida(MiGramaticaParser.ProyeccionSalidaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#decisionEvaluar}.
	 * @param ctx the parse tree
	 */
	void enterDecisionEvaluar(MiGramaticaParser.DecisionEvaluarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#decisionEvaluar}.
	 * @param ctx the parse tree
	 */
	void exitDecisionEvaluar(MiGramaticaParser.DecisionEvaluarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#cicloEntrenar}.
	 * @param ctx the parse tree
	 */
	void enterCicloEntrenar(MiGramaticaParser.CicloEntrenarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#cicloEntrenar}.
	 * @param ctx the parse tree
	 */
	void exitCicloEntrenar(MiGramaticaParser.CicloEntrenarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(MiGramaticaParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(MiGramaticaParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#exprDisyuncion}.
	 * @param ctx the parse tree
	 */
	void enterExprDisyuncion(MiGramaticaParser.ExprDisyuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#exprDisyuncion}.
	 * @param ctx the parse tree
	 */
	void exitExprDisyuncion(MiGramaticaParser.ExprDisyuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#exprConjuncion}.
	 * @param ctx the parse tree
	 */
	void enterExprConjuncion(MiGramaticaParser.ExprConjuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#exprConjuncion}.
	 * @param ctx the parse tree
	 */
	void exitExprConjuncion(MiGramaticaParser.ExprConjuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#exprIgualdad}.
	 * @param ctx the parse tree
	 */
	void enterExprIgualdad(MiGramaticaParser.ExprIgualdadContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#exprIgualdad}.
	 * @param ctx the parse tree
	 */
	void exitExprIgualdad(MiGramaticaParser.ExprIgualdadContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#exprRelacional}.
	 * @param ctx the parse tree
	 */
	void enterExprRelacional(MiGramaticaParser.ExprRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#exprRelacional}.
	 * @param ctx the parse tree
	 */
	void exitExprRelacional(MiGramaticaParser.ExprRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#exprTuberia}.
	 * @param ctx the parse tree
	 */
	void enterExprTuberia(MiGramaticaParser.ExprTuberiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#exprTuberia}.
	 * @param ctx the parse tree
	 */
	void exitExprTuberia(MiGramaticaParser.ExprTuberiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#exprAditiva}.
	 * @param ctx the parse tree
	 */
	void enterExprAditiva(MiGramaticaParser.ExprAditivaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#exprAditiva}.
	 * @param ctx the parse tree
	 */
	void exitExprAditiva(MiGramaticaParser.ExprAditivaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#exprMultiplicativa}.
	 * @param ctx the parse tree
	 */
	void enterExprMultiplicativa(MiGramaticaParser.ExprMultiplicativaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#exprMultiplicativa}.
	 * @param ctx the parse tree
	 */
	void exitExprMultiplicativa(MiGramaticaParser.ExprMultiplicativaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#exprMatricial}.
	 * @param ctx the parse tree
	 */
	void enterExprMatricial(MiGramaticaParser.ExprMatricialContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#exprMatricial}.
	 * @param ctx the parse tree
	 */
	void exitExprMatricial(MiGramaticaParser.ExprMatricialContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#exprPotencia}.
	 * @param ctx the parse tree
	 */
	void enterExprPotencia(MiGramaticaParser.ExprPotenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#exprPotencia}.
	 * @param ctx the parse tree
	 */
	void exitExprPotencia(MiGramaticaParser.ExprPotenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#exprUnaria}.
	 * @param ctx the parse tree
	 */
	void enterExprUnaria(MiGramaticaParser.ExprUnariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#exprUnaria}.
	 * @param ctx the parse tree
	 */
	void exitExprUnaria(MiGramaticaParser.ExprUnariaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#exprPrimaria}.
	 * @param ctx the parse tree
	 */
	void enterExprPrimaria(MiGramaticaParser.ExprPrimariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#exprPrimaria}.
	 * @param ctx the parse tree
	 */
	void exitExprPrimaria(MiGramaticaParser.ExprPrimariaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#literalPulso}.
	 * @param ctx the parse tree
	 */
	void enterLiteralPulso(MiGramaticaParser.LiteralPulsoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#literalPulso}.
	 * @param ctx the parse tree
	 */
	void exitLiteralPulso(MiGramaticaParser.LiteralPulsoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiGramaticaParser#tensorLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTensorLiteral(MiGramaticaParser.TensorLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiGramaticaParser#tensorLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTensorLiteral(MiGramaticaParser.TensorLiteralContext ctx);
}