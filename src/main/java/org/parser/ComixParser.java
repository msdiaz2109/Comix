// Generated from src/main/java/org/parser/Comix.g4 by ANTLR 4.13.1

    package org.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ComixParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ARQUITECTURA=1, SINAPSIS=2, AJUSTAR=3, EVALUAR=4, ACTIVAR=5, RECALIBRAR=6, 
		DESCARTAR=7, ENTRENAR=8, CONVERGER=9, INGESTAR=10, PROYECTAR=11, INDICE=12, 
		PESO=13, TENSOR=14, CORPUS=15, PULSO=16, ACTIVO=17, INACTIVO=18, PAREN_IZQ=19, 
		PAREN_DER=20, ENLACE_SINAPTICO=21, CANAL_INGESTA=22, TUBERIA_CAPA=23, 
		PROD_MATRICIAL=24, MAYOR_IGUAL=25, MENOR_IGUAL=26, IGUALDAD=27, DIVERGENCIA=28, 
		MAYOR=29, MENOR=30, CONJUNCION=31, DISYUNCION=32, INHIBICION=33, POTENCIA=34, 
		MULT=35, DIV=36, MOD=37, SUMA=38, RESTA=39, DOS_PUNTOS=40, PUNTO_Y_COMA=41, 
		CORCHETE_IZQ=42, CORCHETE_DER=43, COMA=44, LIT_PESO=45, LIT_INDICE=46, 
		LIT_CORPUS=47, ID=48, COMENTARIO_BLOQUE=49, COMENTARIO_LINEA=50, ESPACIO_BLANCO=51;
	public static final int
		RULE_programa = 0, RULE_bloque = 1, RULE_instruccion = 2, RULE_declaracionSinapsis = 3, 
		RULE_ajusteSinapsis = 4, RULE_tipoDato = 5, RULE_ingestaDatos = 6, RULE_proyeccionSalida = 7, 
		RULE_decisionEvaluar = 8, RULE_cicloEntrenar = 9, RULE_expresion = 10, 
		RULE_exprDisyuncion = 11, RULE_exprConjuncion = 12, RULE_exprIgualdad = 13, 
		RULE_exprRelacional = 14, RULE_exprTuberia = 15, RULE_exprAditiva = 16, 
		RULE_exprMultiplicativa = 17, RULE_exprMatricial = 18, RULE_exprPotencia = 19, 
		RULE_exprUnaria = 20, RULE_exprPrimaria = 21, RULE_literalPulso = 22, 
		RULE_tensorLiteral = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "bloque", "instruccion", "declaracionSinapsis", "ajusteSinapsis", 
			"tipoDato", "ingestaDatos", "proyeccionSalida", "decisionEvaluar", "cicloEntrenar", 
			"expresion", "exprDisyuncion", "exprConjuncion", "exprIgualdad", "exprRelacional", 
			"exprTuberia", "exprAditiva", "exprMultiplicativa", "exprMatricial", 
			"exprPotencia", "exprUnaria", "exprPrimaria", "literalPulso", "tensorLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'arquitectura'", "'sinapsis'", "'ajustar'", "'evaluar'", "'activar'", 
			"'recalibrar'", "'descartar'", "'entrenar'", "'converger'", "'ingestar'", 
			"'proyectar'", "'indice'", "'peso'", "'tensor'", "'corpus'", "'pulso'", 
			"'activo'", "'inactivo'", "'\\uD83D\uDC12'", "'\\uD83D\uDC35'", "'<-'", 
			"'->'", "'~>'", "'@'", "'>='", "'<='", "'=='", "'!='", "'>'", "'<'", 
			"'&&'", "'||'", "'!'", "'^'", "'*'", "'/'", "'%'", "'+'", "'-'", "':'", 
			"';'", "'['", "']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ARQUITECTURA", "SINAPSIS", "AJUSTAR", "EVALUAR", "ACTIVAR", "RECALIBRAR", 
			"DESCARTAR", "ENTRENAR", "CONVERGER", "INGESTAR", "PROYECTAR", "INDICE", 
			"PESO", "TENSOR", "CORPUS", "PULSO", "ACTIVO", "INACTIVO", "PAREN_IZQ", 
			"PAREN_DER", "ENLACE_SINAPTICO", "CANAL_INGESTA", "TUBERIA_CAPA", "PROD_MATRICIAL", 
			"MAYOR_IGUAL", "MENOR_IGUAL", "IGUALDAD", "DIVERGENCIA", "MAYOR", "MENOR", 
			"CONJUNCION", "DISYUNCION", "INHIBICION", "POTENCIA", "MULT", "DIV", 
			"MOD", "SUMA", "RESTA", "DOS_PUNTOS", "PUNTO_Y_COMA", "CORCHETE_IZQ", 
			"CORCHETE_DER", "COMA", "LIT_PESO", "LIT_INDICE", "LIT_CORPUS", "ID", 
			"COMENTARIO_BLOQUE", "COMENTARIO_LINEA", "ESPACIO_BLANCO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Comix.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ComixParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode ARQUITECTURA() { return getToken(ComixParser.ARQUITECTURA, 0); }
		public TerminalNode ID() { return getToken(ComixParser.ID, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ComixParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(ARQUITECTURA);
			setState(49);
			match(ID);
			setState(50);
			bloque();
			setState(51);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode DOS_PUNTOS() { return getToken(ComixParser.DOS_PUNTOS, 0); }
		public TerminalNode PUNTO_Y_COMA() { return getToken(ComixParser.PUNTO_Y_COMA, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(DOS_PUNTOS);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3356L) != 0)) {
				{
				{
				setState(54);
				instruccion();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(PUNTO_Y_COMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstruccionContext extends ParserRuleContext {
		public DeclaracionSinapsisContext declaracionSinapsis() {
			return getRuleContext(DeclaracionSinapsisContext.class,0);
		}
		public AjusteSinapsisContext ajusteSinapsis() {
			return getRuleContext(AjusteSinapsisContext.class,0);
		}
		public IngestaDatosContext ingestaDatos() {
			return getRuleContext(IngestaDatosContext.class,0);
		}
		public ProyeccionSalidaContext proyeccionSalida() {
			return getRuleContext(ProyeccionSalidaContext.class,0);
		}
		public DecisionEvaluarContext decisionEvaluar() {
			return getRuleContext(DecisionEvaluarContext.class,0);
		}
		public CicloEntrenarContext cicloEntrenar() {
			return getRuleContext(CicloEntrenarContext.class,0);
		}
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterInstruccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitInstruccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitInstruccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruccion);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINAPSIS:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				declaracionSinapsis();
				}
				break;
			case AJUSTAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				ajusteSinapsis();
				}
				break;
			case INGESTAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				ingestaDatos();
				}
				break;
			case PROYECTAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				proyeccionSalida();
				}
				break;
			case EVALUAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				decisionEvaluar();
				}
				break;
			case ENTRENAR:
				enterOuterAlt(_localctx, 6);
				{
				setState(67);
				cicloEntrenar();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionSinapsisContext extends ParserRuleContext {
		public TerminalNode SINAPSIS() { return getToken(ComixParser.SINAPSIS, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(ComixParser.ID, 0); }
		public TerminalNode ENLACE_SINAPTICO() { return getToken(ComixParser.ENLACE_SINAPTICO, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionSinapsisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionSinapsis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterDeclaracionSinapsis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitDeclaracionSinapsis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitDeclaracionSinapsis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionSinapsisContext declaracionSinapsis() throws RecognitionException {
		DeclaracionSinapsisContext _localctx = new DeclaracionSinapsisContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracionSinapsis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(SINAPSIS);
			setState(71);
			tipoDato();
			setState(72);
			match(ID);
			setState(73);
			match(ENLACE_SINAPTICO);
			setState(74);
			expresion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AjusteSinapsisContext extends ParserRuleContext {
		public TerminalNode AJUSTAR() { return getToken(ComixParser.AJUSTAR, 0); }
		public TerminalNode ID() { return getToken(ComixParser.ID, 0); }
		public TerminalNode ENLACE_SINAPTICO() { return getToken(ComixParser.ENLACE_SINAPTICO, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public AjusteSinapsisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ajusteSinapsis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterAjusteSinapsis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitAjusteSinapsis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitAjusteSinapsis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AjusteSinapsisContext ajusteSinapsis() throws RecognitionException {
		AjusteSinapsisContext _localctx = new AjusteSinapsisContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ajusteSinapsis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(AJUSTAR);
			setState(77);
			match(ID);
			setState(78);
			match(ENLACE_SINAPTICO);
			setState(79);
			expresion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoDatoContext extends ParserRuleContext {
		public TerminalNode INDICE() { return getToken(ComixParser.INDICE, 0); }
		public TerminalNode PESO() { return getToken(ComixParser.PESO, 0); }
		public TerminalNode TENSOR() { return getToken(ComixParser.TENSOR, 0); }
		public TerminalNode CORPUS() { return getToken(ComixParser.CORPUS, 0); }
		public TerminalNode PULSO() { return getToken(ComixParser.PULSO, 0); }
		public TipoDatoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoDato; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterTipoDato(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitTipoDato(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitTipoDato(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoDatoContext tipoDato() throws RecognitionException {
		TipoDatoContext _localctx = new TipoDatoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tipoDato);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IngestaDatosContext extends ParserRuleContext {
		public TerminalNode INGESTAR() { return getToken(ComixParser.INGESTAR, 0); }
		public TerminalNode ID() { return getToken(ComixParser.ID, 0); }
		public TerminalNode LIT_CORPUS() { return getToken(ComixParser.LIT_CORPUS, 0); }
		public TerminalNode CANAL_INGESTA() { return getToken(ComixParser.CANAL_INGESTA, 0); }
		public IngestaDatosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ingestaDatos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterIngestaDatos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitIngestaDatos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitIngestaDatos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IngestaDatosContext ingestaDatos() throws RecognitionException {
		IngestaDatosContext _localctx = new IngestaDatosContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ingestaDatos);
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(INGESTAR);
				setState(84);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(INGESTAR);
				setState(86);
				match(LIT_CORPUS);
				setState(87);
				match(CANAL_INGESTA);
				setState(88);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProyeccionSalidaContext extends ParserRuleContext {
		public TerminalNode PROYECTAR() { return getToken(ComixParser.PROYECTAR, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(ComixParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ComixParser.COMA, i);
		}
		public ProyeccionSalidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proyeccionSalida; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterProyeccionSalida(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitProyeccionSalida(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitProyeccionSalida(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProyeccionSalidaContext proyeccionSalida() throws RecognitionException {
		ProyeccionSalidaContext _localctx = new ProyeccionSalidaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_proyeccionSalida);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(PROYECTAR);
			setState(92);
			expresion();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(93);
				match(COMA);
				setState(94);
				expresion();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecisionEvaluarContext extends ParserRuleContext {
		public TerminalNode EVALUAR() { return getToken(ComixParser.EVALUAR, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode ACTIVAR() { return getToken(ComixParser.ACTIVAR, 0); }
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public TerminalNode RECALIBRAR() { return getToken(ComixParser.RECALIBRAR, 0); }
		public TerminalNode DESCARTAR() { return getToken(ComixParser.DESCARTAR, 0); }
		public DecisionEvaluarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decisionEvaluar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterDecisionEvaluar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitDecisionEvaluar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitDecisionEvaluar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecisionEvaluarContext decisionEvaluar() throws RecognitionException {
		DecisionEvaluarContext _localctx = new DecisionEvaluarContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_decisionEvaluar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(EVALUAR);
			setState(101);
			expresion();
			setState(102);
			match(ACTIVAR);
			setState(103);
			bloque();
			setState(104);
			match(RECALIBRAR);
			setState(105);
			expresion();
			setState(106);
			bloque();
			setState(107);
			match(DESCARTAR);
			setState(108);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CicloEntrenarContext extends ParserRuleContext {
		public TerminalNode ENTRENAR() { return getToken(ComixParser.ENTRENAR, 0); }
		public TerminalNode CONVERGER() { return getToken(ComixParser.CONVERGER, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public CicloEntrenarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cicloEntrenar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterCicloEntrenar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitCicloEntrenar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitCicloEntrenar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CicloEntrenarContext cicloEntrenar() throws RecognitionException {
		CicloEntrenarContext _localctx = new CicloEntrenarContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cicloEntrenar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(ENTRENAR);
			setState(111);
			match(CONVERGER);
			setState(112);
			expresion();
			setState(113);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionContext extends ParserRuleContext {
		public ExprDisyuncionContext exprDisyuncion() {
			return getRuleContext(ExprDisyuncionContext.class,0);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			exprDisyuncion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprDisyuncionContext extends ParserRuleContext {
		public List<ExprConjuncionContext> exprConjuncion() {
			return getRuleContexts(ExprConjuncionContext.class);
		}
		public ExprConjuncionContext exprConjuncion(int i) {
			return getRuleContext(ExprConjuncionContext.class,i);
		}
		public List<TerminalNode> DISYUNCION() { return getTokens(ComixParser.DISYUNCION); }
		public TerminalNode DISYUNCION(int i) {
			return getToken(ComixParser.DISYUNCION, i);
		}
		public ExprDisyuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprDisyuncion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterExprDisyuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitExprDisyuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitExprDisyuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprDisyuncionContext exprDisyuncion() throws RecognitionException {
		ExprDisyuncionContext _localctx = new ExprDisyuncionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprDisyuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			exprConjuncion();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DISYUNCION) {
				{
				{
				setState(118);
				match(DISYUNCION);
				setState(119);
				exprConjuncion();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprConjuncionContext extends ParserRuleContext {
		public List<ExprIgualdadContext> exprIgualdad() {
			return getRuleContexts(ExprIgualdadContext.class);
		}
		public ExprIgualdadContext exprIgualdad(int i) {
			return getRuleContext(ExprIgualdadContext.class,i);
		}
		public List<TerminalNode> CONJUNCION() { return getTokens(ComixParser.CONJUNCION); }
		public TerminalNode CONJUNCION(int i) {
			return getToken(ComixParser.CONJUNCION, i);
		}
		public ExprConjuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprConjuncion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterExprConjuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitExprConjuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitExprConjuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprConjuncionContext exprConjuncion() throws RecognitionException {
		ExprConjuncionContext _localctx = new ExprConjuncionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exprConjuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			exprIgualdad();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONJUNCION) {
				{
				{
				setState(126);
				match(CONJUNCION);
				setState(127);
				exprIgualdad();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprIgualdadContext extends ParserRuleContext {
		public List<ExprRelacionalContext> exprRelacional() {
			return getRuleContexts(ExprRelacionalContext.class);
		}
		public ExprRelacionalContext exprRelacional(int i) {
			return getRuleContext(ExprRelacionalContext.class,i);
		}
		public List<TerminalNode> IGUALDAD() { return getTokens(ComixParser.IGUALDAD); }
		public TerminalNode IGUALDAD(int i) {
			return getToken(ComixParser.IGUALDAD, i);
		}
		public List<TerminalNode> DIVERGENCIA() { return getTokens(ComixParser.DIVERGENCIA); }
		public TerminalNode DIVERGENCIA(int i) {
			return getToken(ComixParser.DIVERGENCIA, i);
		}
		public ExprIgualdadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprIgualdad; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterExprIgualdad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitExprIgualdad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitExprIgualdad(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprIgualdadContext exprIgualdad() throws RecognitionException {
		ExprIgualdadContext _localctx = new ExprIgualdadContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exprIgualdad);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			exprRelacional();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IGUALDAD || _la==DIVERGENCIA) {
				{
				{
				setState(134);
				_la = _input.LA(1);
				if ( !(_la==IGUALDAD || _la==DIVERGENCIA) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(135);
				exprRelacional();
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprRelacionalContext extends ParserRuleContext {
		public List<ExprTuberiaContext> exprTuberia() {
			return getRuleContexts(ExprTuberiaContext.class);
		}
		public ExprTuberiaContext exprTuberia(int i) {
			return getRuleContext(ExprTuberiaContext.class,i);
		}
		public List<TerminalNode> MAYOR_IGUAL() { return getTokens(ComixParser.MAYOR_IGUAL); }
		public TerminalNode MAYOR_IGUAL(int i) {
			return getToken(ComixParser.MAYOR_IGUAL, i);
		}
		public List<TerminalNode> MENOR_IGUAL() { return getTokens(ComixParser.MENOR_IGUAL); }
		public TerminalNode MENOR_IGUAL(int i) {
			return getToken(ComixParser.MENOR_IGUAL, i);
		}
		public List<TerminalNode> MAYOR() { return getTokens(ComixParser.MAYOR); }
		public TerminalNode MAYOR(int i) {
			return getToken(ComixParser.MAYOR, i);
		}
		public List<TerminalNode> MENOR() { return getTokens(ComixParser.MENOR); }
		public TerminalNode MENOR(int i) {
			return getToken(ComixParser.MENOR, i);
		}
		public ExprRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprRelacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterExprRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitExprRelacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitExprRelacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprRelacionalContext exprRelacional() throws RecognitionException {
		ExprRelacionalContext _localctx = new ExprRelacionalContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_exprRelacional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			exprTuberia();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1711276032L) != 0)) {
				{
				{
				setState(142);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1711276032L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(143);
				exprTuberia();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprTuberiaContext extends ParserRuleContext {
		public List<ExprAditivaContext> exprAditiva() {
			return getRuleContexts(ExprAditivaContext.class);
		}
		public ExprAditivaContext exprAditiva(int i) {
			return getRuleContext(ExprAditivaContext.class,i);
		}
		public List<TerminalNode> TUBERIA_CAPA() { return getTokens(ComixParser.TUBERIA_CAPA); }
		public TerminalNode TUBERIA_CAPA(int i) {
			return getToken(ComixParser.TUBERIA_CAPA, i);
		}
		public ExprTuberiaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprTuberia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterExprTuberia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitExprTuberia(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitExprTuberia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprTuberiaContext exprTuberia() throws RecognitionException {
		ExprTuberiaContext _localctx = new ExprTuberiaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_exprTuberia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			exprAditiva();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TUBERIA_CAPA) {
				{
				{
				setState(150);
				match(TUBERIA_CAPA);
				setState(151);
				exprAditiva();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprAditivaContext extends ParserRuleContext {
		public List<ExprMultiplicativaContext> exprMultiplicativa() {
			return getRuleContexts(ExprMultiplicativaContext.class);
		}
		public ExprMultiplicativaContext exprMultiplicativa(int i) {
			return getRuleContext(ExprMultiplicativaContext.class,i);
		}
		public List<TerminalNode> SUMA() { return getTokens(ComixParser.SUMA); }
		public TerminalNode SUMA(int i) {
			return getToken(ComixParser.SUMA, i);
		}
		public List<TerminalNode> RESTA() { return getTokens(ComixParser.RESTA); }
		public TerminalNode RESTA(int i) {
			return getToken(ComixParser.RESTA, i);
		}
		public ExprAditivaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprAditiva; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterExprAditiva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitExprAditiva(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitExprAditiva(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprAditivaContext exprAditiva() throws RecognitionException {
		ExprAditivaContext _localctx = new ExprAditivaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_exprAditiva);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			exprMultiplicativa();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SUMA || _la==RESTA) {
				{
				{
				setState(158);
				_la = _input.LA(1);
				if ( !(_la==SUMA || _la==RESTA) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(159);
				exprMultiplicativa();
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprMultiplicativaContext extends ParserRuleContext {
		public List<ExprMatricialContext> exprMatricial() {
			return getRuleContexts(ExprMatricialContext.class);
		}
		public ExprMatricialContext exprMatricial(int i) {
			return getRuleContext(ExprMatricialContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(ComixParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(ComixParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(ComixParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(ComixParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(ComixParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(ComixParser.MOD, i);
		}
		public ExprMultiplicativaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprMultiplicativa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterExprMultiplicativa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitExprMultiplicativa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitExprMultiplicativa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprMultiplicativaContext exprMultiplicativa() throws RecognitionException {
		ExprMultiplicativaContext _localctx = new ExprMultiplicativaContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_exprMultiplicativa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			exprMatricial();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 240518168576L) != 0)) {
				{
				{
				setState(166);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 240518168576L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(167);
				exprMatricial();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprMatricialContext extends ParserRuleContext {
		public List<ExprPotenciaContext> exprPotencia() {
			return getRuleContexts(ExprPotenciaContext.class);
		}
		public ExprPotenciaContext exprPotencia(int i) {
			return getRuleContext(ExprPotenciaContext.class,i);
		}
		public List<TerminalNode> PROD_MATRICIAL() { return getTokens(ComixParser.PROD_MATRICIAL); }
		public TerminalNode PROD_MATRICIAL(int i) {
			return getToken(ComixParser.PROD_MATRICIAL, i);
		}
		public ExprMatricialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprMatricial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterExprMatricial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitExprMatricial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitExprMatricial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprMatricialContext exprMatricial() throws RecognitionException {
		ExprMatricialContext _localctx = new ExprMatricialContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_exprMatricial);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			exprPotencia();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROD_MATRICIAL) {
				{
				{
				setState(174);
				match(PROD_MATRICIAL);
				setState(175);
				exprPotencia();
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprPotenciaContext extends ParserRuleContext {
		public ExprUnariaContext exprUnaria() {
			return getRuleContext(ExprUnariaContext.class,0);
		}
		public TerminalNode POTENCIA() { return getToken(ComixParser.POTENCIA, 0); }
		public ExprPotenciaContext exprPotencia() {
			return getRuleContext(ExprPotenciaContext.class,0);
		}
		public ExprPotenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprPotencia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterExprPotencia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitExprPotencia(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitExprPotencia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprPotenciaContext exprPotencia() throws RecognitionException {
		ExprPotenciaContext _localctx = new ExprPotenciaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exprPotencia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			exprUnaria();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==POTENCIA) {
				{
				setState(182);
				match(POTENCIA);
				setState(183);
				exprPotencia();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprUnariaContext extends ParserRuleContext {
		public ExprUnariaContext exprUnaria() {
			return getRuleContext(ExprUnariaContext.class,0);
		}
		public TerminalNode RESTA() { return getToken(ComixParser.RESTA, 0); }
		public TerminalNode INHIBICION() { return getToken(ComixParser.INHIBICION, 0); }
		public ExprPrimariaContext exprPrimaria() {
			return getRuleContext(ExprPrimariaContext.class,0);
		}
		public ExprUnariaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprUnaria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterExprUnaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitExprUnaria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitExprUnaria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprUnariaContext exprUnaria() throws RecognitionException {
		ExprUnariaContext _localctx = new ExprUnariaContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exprUnaria);
		int _la;
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INHIBICION:
			case RESTA:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				_la = _input.LA(1);
				if ( !(_la==INHIBICION || _la==RESTA) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(187);
				exprUnaria();
				}
				break;
			case ACTIVO:
			case INACTIVO:
			case PAREN_IZQ:
			case CORCHETE_IZQ:
			case LIT_PESO:
			case LIT_INDICE:
			case LIT_CORPUS:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				exprPrimaria();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprPrimariaContext extends ParserRuleContext {
		public TerminalNode PAREN_IZQ() { return getToken(ComixParser.PAREN_IZQ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_DER() { return getToken(ComixParser.PAREN_DER, 0); }
		public TensorLiteralContext tensorLiteral() {
			return getRuleContext(TensorLiteralContext.class,0);
		}
		public TerminalNode LIT_PESO() { return getToken(ComixParser.LIT_PESO, 0); }
		public TerminalNode LIT_INDICE() { return getToken(ComixParser.LIT_INDICE, 0); }
		public TerminalNode LIT_CORPUS() { return getToken(ComixParser.LIT_CORPUS, 0); }
		public LiteralPulsoContext literalPulso() {
			return getRuleContext(LiteralPulsoContext.class,0);
		}
		public TerminalNode ID() { return getToken(ComixParser.ID, 0); }
		public ExprPrimariaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprPrimaria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterExprPrimaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitExprPrimaria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitExprPrimaria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprPrimariaContext exprPrimaria() throws RecognitionException {
		ExprPrimariaContext _localctx = new ExprPrimariaContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_exprPrimaria);
		try {
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PAREN_IZQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(PAREN_IZQ);
				setState(192);
				expresion();
				setState(193);
				match(PAREN_DER);
				}
				break;
			case CORCHETE_IZQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				tensorLiteral();
				}
				break;
			case LIT_PESO:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				match(LIT_PESO);
				}
				break;
			case LIT_INDICE:
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				match(LIT_INDICE);
				}
				break;
			case LIT_CORPUS:
				enterOuterAlt(_localctx, 5);
				{
				setState(198);
				match(LIT_CORPUS);
				}
				break;
			case ACTIVO:
			case INACTIVO:
				enterOuterAlt(_localctx, 6);
				{
				setState(199);
				literalPulso();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 7);
				{
				setState(200);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralPulsoContext extends ParserRuleContext {
		public TerminalNode ACTIVO() { return getToken(ComixParser.ACTIVO, 0); }
		public TerminalNode INACTIVO() { return getToken(ComixParser.INACTIVO, 0); }
		public LiteralPulsoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalPulso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterLiteralPulso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitLiteralPulso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitLiteralPulso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralPulsoContext literalPulso() throws RecognitionException {
		LiteralPulsoContext _localctx = new LiteralPulsoContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_literalPulso);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_la = _input.LA(1);
			if ( !(_la==ACTIVO || _la==INACTIVO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TensorLiteralContext extends ParserRuleContext {
		public TerminalNode CORCHETE_IZQ() { return getToken(ComixParser.CORCHETE_IZQ, 0); }
		public TerminalNode CORCHETE_DER() { return getToken(ComixParser.CORCHETE_DER, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(ComixParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ComixParser.COMA, i);
		}
		public TensorLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tensorLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).enterTensorLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComixListener ) ((ComixListener)listener).exitTensorLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ComixVisitor ) return ((ComixVisitor<? extends T>)visitor).visitTensorLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TensorLiteralContext tensorLiteral() throws RecognitionException {
		TensorLiteralContext _localctx = new TensorLiteralContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_tensorLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(CORCHETE_IZQ);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 532721974509568L) != 0)) {
				{
				setState(206);
				expresion();
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(207);
					match(COMA);
					setState(208);
					expresion();
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(216);
			match(CORCHETE_DER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00013\u00db\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001"+
		"8\b\u0001\n\u0001\f\u0001;\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"E\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006Z\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007`\b\u0007\n\u0007\f\u0007c\t\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000by\b\u000b\n\u000b\f\u000b|\t"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u0081\b\f\n\f\f\f\u0084\t\f\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u0089\b\r\n\r\f\r\u008c\t\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u0091\b\u000e\n\u000e\f\u000e\u0094\t\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0099\b\u000f\n\u000f"+
		"\f\u000f\u009c\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u00a1\b\u0010\n\u0010\f\u0010\u00a4\t\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0005\u0011\u00a9\b\u0011\n\u0011\f\u0011\u00ac\t\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u00b1\b\u0012\n\u0012\f\u0012\u00b4"+
		"\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00b9\b\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00be\b\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00ca\b\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u00d2\b\u0017\n\u0017\f\u0017\u00d5\t\u0017\u0003\u0017\u00d7\b\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0000\u0000\u0018\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.\u0000\u0007\u0001\u0000\f\u0010\u0001\u0000\u001b\u001c\u0002\u0000"+
		"\u0019\u001a\u001d\u001e\u0001\u0000&\'\u0001\u0000#%\u0002\u0000!!\'"+
		"\'\u0001\u0000\u0011\u0012\u00dc\u00000\u0001\u0000\u0000\u0000\u0002"+
		"5\u0001\u0000\u0000\u0000\u0004D\u0001\u0000\u0000\u0000\u0006F\u0001"+
		"\u0000\u0000\u0000\bL\u0001\u0000\u0000\u0000\nQ\u0001\u0000\u0000\u0000"+
		"\fY\u0001\u0000\u0000\u0000\u000e[\u0001\u0000\u0000\u0000\u0010d\u0001"+
		"\u0000\u0000\u0000\u0012n\u0001\u0000\u0000\u0000\u0014s\u0001\u0000\u0000"+
		"\u0000\u0016u\u0001\u0000\u0000\u0000\u0018}\u0001\u0000\u0000\u0000\u001a"+
		"\u0085\u0001\u0000\u0000\u0000\u001c\u008d\u0001\u0000\u0000\u0000\u001e"+
		"\u0095\u0001\u0000\u0000\u0000 \u009d\u0001\u0000\u0000\u0000\"\u00a5"+
		"\u0001\u0000\u0000\u0000$\u00ad\u0001\u0000\u0000\u0000&\u00b5\u0001\u0000"+
		"\u0000\u0000(\u00bd\u0001\u0000\u0000\u0000*\u00c9\u0001\u0000\u0000\u0000"+
		",\u00cb\u0001\u0000\u0000\u0000.\u00cd\u0001\u0000\u0000\u000001\u0005"+
		"\u0001\u0000\u000012\u00050\u0000\u000023\u0003\u0002\u0001\u000034\u0005"+
		"\u0000\u0000\u00014\u0001\u0001\u0000\u0000\u000059\u0005(\u0000\u0000"+
		"68\u0003\u0004\u0002\u000076\u0001\u0000\u0000\u00008;\u0001\u0000\u0000"+
		"\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:<\u0001\u0000"+
		"\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0005)\u0000\u0000=\u0003\u0001"+
		"\u0000\u0000\u0000>E\u0003\u0006\u0003\u0000?E\u0003\b\u0004\u0000@E\u0003"+
		"\f\u0006\u0000AE\u0003\u000e\u0007\u0000BE\u0003\u0010\b\u0000CE\u0003"+
		"\u0012\t\u0000D>\u0001\u0000\u0000\u0000D?\u0001\u0000\u0000\u0000D@\u0001"+
		"\u0000\u0000\u0000DA\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000"+
		"DC\u0001\u0000\u0000\u0000E\u0005\u0001\u0000\u0000\u0000FG\u0005\u0002"+
		"\u0000\u0000GH\u0003\n\u0005\u0000HI\u00050\u0000\u0000IJ\u0005\u0015"+
		"\u0000\u0000JK\u0003\u0014\n\u0000K\u0007\u0001\u0000\u0000\u0000LM\u0005"+
		"\u0003\u0000\u0000MN\u00050\u0000\u0000NO\u0005\u0015\u0000\u0000OP\u0003"+
		"\u0014\n\u0000P\t\u0001\u0000\u0000\u0000QR\u0007\u0000\u0000\u0000R\u000b"+
		"\u0001\u0000\u0000\u0000ST\u0005\n\u0000\u0000TZ\u00050\u0000\u0000UV"+
		"\u0005\n\u0000\u0000VW\u0005/\u0000\u0000WX\u0005\u0016\u0000\u0000XZ"+
		"\u00050\u0000\u0000YS\u0001\u0000\u0000\u0000YU\u0001\u0000\u0000\u0000"+
		"Z\r\u0001\u0000\u0000\u0000[\\\u0005\u000b\u0000\u0000\\a\u0003\u0014"+
		"\n\u0000]^\u0005,\u0000\u0000^`\u0003\u0014\n\u0000_]\u0001\u0000\u0000"+
		"\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000"+
		"\u0000\u0000b\u000f\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000"+
		"de\u0005\u0004\u0000\u0000ef\u0003\u0014\n\u0000fg\u0005\u0005\u0000\u0000"+
		"gh\u0003\u0002\u0001\u0000hi\u0005\u0006\u0000\u0000ij\u0003\u0014\n\u0000"+
		"jk\u0003\u0002\u0001\u0000kl\u0005\u0007\u0000\u0000lm\u0003\u0002\u0001"+
		"\u0000m\u0011\u0001\u0000\u0000\u0000no\u0005\b\u0000\u0000op\u0005\t"+
		"\u0000\u0000pq\u0003\u0014\n\u0000qr\u0003\u0002\u0001\u0000r\u0013\u0001"+
		"\u0000\u0000\u0000st\u0003\u0016\u000b\u0000t\u0015\u0001\u0000\u0000"+
		"\u0000uz\u0003\u0018\f\u0000vw\u0005 \u0000\u0000wy\u0003\u0018\f\u0000"+
		"xv\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000"+
		"\u0000z{\u0001\u0000\u0000\u0000{\u0017\u0001\u0000\u0000\u0000|z\u0001"+
		"\u0000\u0000\u0000}\u0082\u0003\u001a\r\u0000~\u007f\u0005\u001f\u0000"+
		"\u0000\u007f\u0081\u0003\u001a\r\u0000\u0080~\u0001\u0000\u0000\u0000"+
		"\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0019\u0001\u0000\u0000\u0000"+
		"\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u008a\u0003\u001c\u000e\u0000"+
		"\u0086\u0087\u0007\u0001\u0000\u0000\u0087\u0089\u0003\u001c\u000e\u0000"+
		"\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000\u0000"+
		"\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000"+
		"\u008b\u001b\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000"+
		"\u008d\u0092\u0003\u001e\u000f\u0000\u008e\u008f\u0007\u0002\u0000\u0000"+
		"\u008f\u0091\u0003\u001e\u000f\u0000\u0090\u008e\u0001\u0000\u0000\u0000"+
		"\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u001d\u0001\u0000\u0000\u0000"+
		"\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u009a\u0003 \u0010\u0000\u0096"+
		"\u0097\u0005\u0017\u0000\u0000\u0097\u0099\u0003 \u0010\u0000\u0098\u0096"+
		"\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u001f"+
		"\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u00a2"+
		"\u0003\"\u0011\u0000\u009e\u009f\u0007\u0003\u0000\u0000\u009f\u00a1\u0003"+
		"\"\u0011\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3!\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a5\u00aa\u0003$\u0012\u0000\u00a6\u00a7\u0007\u0004\u0000\u0000"+
		"\u00a7\u00a9\u0003$\u0012\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ab#\u0001\u0000\u0000\u0000\u00ac\u00aa"+
		"\u0001\u0000\u0000\u0000\u00ad\u00b2\u0003&\u0013\u0000\u00ae\u00af\u0005"+
		"\u0018\u0000\u0000\u00af\u00b1\u0003&\u0013\u0000\u00b0\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b4\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3%\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b8\u0003(\u0014\u0000"+
		"\u00b6\u00b7\u0005\"\u0000\u0000\u00b7\u00b9\u0003&\u0013\u0000\u00b8"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9"+
		"\'\u0001\u0000\u0000\u0000\u00ba\u00bb\u0007\u0005\u0000\u0000\u00bb\u00be"+
		"\u0003(\u0014\u0000\u00bc\u00be\u0003*\u0015\u0000\u00bd\u00ba\u0001\u0000"+
		"\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be)\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0005\u0013\u0000\u0000\u00c0\u00c1\u0003\u0014\n\u0000"+
		"\u00c1\u00c2\u0005\u0014\u0000\u0000\u00c2\u00ca\u0001\u0000\u0000\u0000"+
		"\u00c3\u00ca\u0003.\u0017\u0000\u00c4\u00ca\u0005-\u0000\u0000\u00c5\u00ca"+
		"\u0005.\u0000\u0000\u00c6\u00ca\u0005/\u0000\u0000\u00c7\u00ca\u0003,"+
		"\u0016\u0000\u00c8\u00ca\u00050\u0000\u0000\u00c9\u00bf\u0001\u0000\u0000"+
		"\u0000\u00c9\u00c3\u0001\u0000\u0000\u0000\u00c9\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c9\u00c5\u0001\u0000\u0000\u0000\u00c9\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000"+
		"\u0000\u00ca+\u0001\u0000\u0000\u0000\u00cb\u00cc\u0007\u0006\u0000\u0000"+
		"\u00cc-\u0001\u0000\u0000\u0000\u00cd\u00d6\u0005*\u0000\u0000\u00ce\u00d3"+
		"\u0003\u0014\n\u0000\u00cf\u00d0\u0005,\u0000\u0000\u00d0\u00d2\u0003"+
		"\u0014\n\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d6\u00ce\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005+\u0000"+
		"\u0000\u00d9/\u0001\u0000\u0000\u0000\u00119DYaz\u0082\u008a\u0092\u009a"+
		"\u00a2\u00aa\u00b2\u00b8\u00bd\u00c9\u00d3\u00d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}