// Generated from Expr.g4 by ANTLR 4.5
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NAME=12, NUMBER=13, NEWLINE=14, INT=15, CLASS=16, DEF=17, 
		RETURN=18, CONTINUE=19, FOR=20, WHILE=21, BREAK=22, IN=23, IF=24, ELSE=25, 
		ELIF=26, NOT=27, AND=28, OR=29, DEL=30, THIS=31, FLOAT=32, L_BRACKET=33, 
		R_BRACKET=34, L_S_BRACKET=35, R_S_BRACKET=36, L_P=37, R_P=38, NOTE=39, 
		ID=40, PLUSASSIGN=41, MINUSASSIGN=42, TIMESASSIGN=43, DIVIDEASSIGN=44, 
		POWER=45, TIMES=46, DIVIDE=47, PLUS=48, MINUS=49, EQUAL=50, NOTEQUAL=51, 
		LE=52, GE=53, ASSIGN=54, LESS=55, GREATER=56, SHARP=57, FLAT=58, COMMA=59, 
		SEMICOLON=60, STRING=61, ESC=62, CMT=63, SCMT=64;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "NAME", "NUMBER", "NEWLINE", "INT", "CLASS", "DEF", "RETURN", 
		"CONTINUE", "FOR", "WHILE", "BREAK", "IN", "IF", "ELSE", "ELIF", "NOT", 
		"AND", "OR", "DEL", "THIS", "DIGIT", "EXPONENT", "FLOAT", "L_BRACKET", 
		"R_BRACKET", "L_S_BRACKET", "R_S_BRACKET", "L_P", "R_P", "NOTE", "ID", 
		"PLUSASSIGN", "MINUSASSIGN", "TIMESASSIGN", "DIVIDEASSIGN", "POWER", "TIMES", 
		"DIVIDE", "PLUS", "MINUS", "EQUAL", "NOTEQUAL", "LE", "GE", "ASSIGN", 
		"LESS", "GREATER", "SHARP", "FLAT", "COMMA", "SEMICOLON", "STRING", "STRING_GUTS", 
		"ESC", "CMT", "SCMT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'@'", "'import'", "'from'", "'.'", "'as'", "':'", "'<>'", "'is'", 
		"'%'", "'//'", "'''", null, null, null, null, "'class'", "'def'", "'return'", 
		"'continue'", "'for'", "'while'", "'break'", "'in'", "'if'", "'else'", 
		"'elif'", "'not'", "'and'", "'or'", "'del'", "'this'", null, "'{'", "'}'", 
		"'['", "']'", "'('", "')'", null, null, "'+='", "'-='", "'*='", "'/='", 
		"'**'", "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'<='", "'>='", "'='", 
		"'<'", "'>'", "'#'", "'~'", "','", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NAME", "NUMBER", "NEWLINE", "INT", "CLASS", "DEF", "RETURN", "CONTINUE", 
		"FOR", "WHILE", "BREAK", "IN", "IF", "ELSE", "ELIF", "NOT", "AND", "OR", 
		"DEL", "THIS", "FLOAT", "L_BRACKET", "R_BRACKET", "L_S_BRACKET", "R_S_BRACKET", 
		"L_P", "R_P", "NOTE", "ID", "PLUSASSIGN", "MINUSASSIGN", "TIMESASSIGN", 
		"DIVIDEASSIGN", "POWER", "TIMES", "DIVIDE", "PLUS", "MINUS", "EQUAL", 
		"NOTEQUAL", "LE", "GE", "ASSIGN", "LESS", "GREATER", "SHARP", "FLAT", 
		"COMMA", "SEMICOLON", "STRING", "ESC", "CMT", "SCMT"
	};
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2B\u018c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\5\16\u00b0"+
		"\n\16\3\17\6\17\u00b3\n\17\r\17\16\17\u00b4\3\20\6\20\u00b8\n\20\r\20"+
		"\16\20\u00b9\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3\"\5\"\u010d\n\"\3"+
		"\"\6\"\u0110\n\"\r\"\16\"\u0111\3#\6#\u0115\n#\r#\16#\u0116\3#\3#\6#\u011b"+
		"\n#\r#\16#\u011c\3#\5#\u0120\n#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)"+
		"\3*\3*\3*\3*\3+\3+\7+\u0134\n+\f+\16+\u0137\13+\3,\3,\3,\3-\3-\3-\3.\3"+
		".\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3"+
		"\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\3:\3:\3;\3"+
		";\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3@\3@\3A\3A\7A\u0170\nA\fA\16A\u0173\13"+
		"A\3B\3B\3B\3C\3C\3C\3C\7C\u017c\nC\fC\16C\u017f\13C\3C\3C\3C\3D\3D\3D"+
		"\3D\7D\u0188\nD\fD\16D\u018b\13D\3\u017d\2E\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\2C\2E\"G#I$K%M&O\'Q("+
		"S)U*W+Y,[-]._/a\60c\61e\62g\63i\64k\65m\66o\67q8s9u:w;y<{=}>\177?\u0081"+
		"\2\u0083@\u0085A\u0087B\3\2\13\4\2\f\f\17\17\3\2\62;\4\2--//\7\2CITTc"+
		"itt~~\3\2\62:\b\2ggjjssuuyy~~\3\2C|\6\2\62;C\\aac|\4\2$$^^\u0195\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s"+
		"\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\3\u0089\3\2\2"+
		"\2\5\u008b\3\2\2\2\7\u0092\3\2\2\2\t\u0097\3\2\2\2\13\u0099\3\2\2\2\r"+
		"\u009c\3\2\2\2\17\u009e\3\2\2\2\21\u00a1\3\2\2\2\23\u00a4\3\2\2\2\25\u00a6"+
		"\3\2\2\2\27\u00a9\3\2\2\2\31\u00ab\3\2\2\2\33\u00af\3\2\2\2\35\u00b2\3"+
		"\2\2\2\37\u00b7\3\2\2\2!\u00bb\3\2\2\2#\u00c1\3\2\2\2%\u00c5\3\2\2\2\'"+
		"\u00cc\3\2\2\2)\u00d5\3\2\2\2+\u00d9\3\2\2\2-\u00df\3\2\2\2/\u00e5\3\2"+
		"\2\2\61\u00e8\3\2\2\2\63\u00eb\3\2\2\2\65\u00f0\3\2\2\2\67\u00f5\3\2\2"+
		"\29\u00f9\3\2\2\2;\u00fd\3\2\2\2=\u0100\3\2\2\2?\u0104\3\2\2\2A\u0109"+
		"\3\2\2\2C\u010c\3\2\2\2E\u0114\3\2\2\2G\u0121\3\2\2\2I\u0123\3\2\2\2K"+
		"\u0125\3\2\2\2M\u0127\3\2\2\2O\u0129\3\2\2\2Q\u012b\3\2\2\2S\u012d\3\2"+
		"\2\2U\u0131\3\2\2\2W\u0138\3\2\2\2Y\u013b\3\2\2\2[\u013e\3\2\2\2]\u0141"+
		"\3\2\2\2_\u0144\3\2\2\2a\u0147\3\2\2\2c\u0149\3\2\2\2e\u014b\3\2\2\2g"+
		"\u014d\3\2\2\2i\u014f\3\2\2\2k\u0152\3\2\2\2m\u0155\3\2\2\2o\u0158\3\2"+
		"\2\2q\u015b\3\2\2\2s\u015d\3\2\2\2u\u015f\3\2\2\2w\u0161\3\2\2\2y\u0163"+
		"\3\2\2\2{\u0165\3\2\2\2}\u0167\3\2\2\2\177\u0169\3\2\2\2\u0081\u0171\3"+
		"\2\2\2\u0083\u0174\3\2\2\2\u0085\u0177\3\2\2\2\u0087\u0183\3\2\2\2\u0089"+
		"\u008a\7B\2\2\u008a\4\3\2\2\2\u008b\u008c\7k\2\2\u008c\u008d\7o\2\2\u008d"+
		"\u008e\7r\2\2\u008e\u008f\7q\2\2\u008f\u0090\7t\2\2\u0090\u0091\7v\2\2"+
		"\u0091\6\3\2\2\2\u0092\u0093\7h\2\2\u0093\u0094\7t\2\2\u0094\u0095\7q"+
		"\2\2\u0095\u0096\7o\2\2\u0096\b\3\2\2\2\u0097\u0098\7\60\2\2\u0098\n\3"+
		"\2\2\2\u0099\u009a\7c\2\2\u009a\u009b\7u\2\2\u009b\f\3\2\2\2\u009c\u009d"+
		"\7<\2\2\u009d\16\3\2\2\2\u009e\u009f\7>\2\2\u009f\u00a0\7@\2\2\u00a0\20"+
		"\3\2\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7u\2\2\u00a3\22\3\2\2\2\u00a4"+
		"\u00a5\7\'\2\2\u00a5\24\3\2\2\2\u00a6\u00a7\7\61\2\2\u00a7\u00a8\7\61"+
		"\2\2\u00a8\26\3\2\2\2\u00a9\u00aa\7)\2\2\u00aa\30\3\2\2\2\u00ab\u00ac"+
		"\5U+\2\u00ac\32\3\2\2\2\u00ad\u00b0\5\37\20\2\u00ae\u00b0\5E#\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\34\3\2\2\2\u00b1\u00b3\t\2\2"+
		"\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5"+
		"\3\2\2\2\u00b5\36\3\2\2\2\u00b6\u00b8\t\3\2\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba \3\2\2\2"+
		"\u00bb\u00bc\7e\2\2\u00bc\u00bd\7n\2\2\u00bd\u00be\7c\2\2\u00be\u00bf"+
		"\7u\2\2\u00bf\u00c0\7u\2\2\u00c0\"\3\2\2\2\u00c1\u00c2\7f\2\2\u00c2\u00c3"+
		"\7g\2\2\u00c3\u00c4\7h\2\2\u00c4$\3\2\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7"+
		"\7g\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca\7t\2\2\u00ca"+
		"\u00cb\7p\2\2\u00cb&\3\2\2\2\u00cc\u00cd\7e\2\2\u00cd\u00ce\7q\2\2\u00ce"+
		"\u00cf\7p\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7p\2\2"+
		"\u00d2\u00d3\7w\2\2\u00d3\u00d4\7g\2\2\u00d4(\3\2\2\2\u00d5\u00d6\7h\2"+
		"\2\u00d6\u00d7\7q\2\2\u00d7\u00d8\7t\2\2\u00d8*\3\2\2\2\u00d9\u00da\7"+
		"y\2\2\u00da\u00db\7j\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7n\2\2\u00dd\u00de"+
		"\7g\2\2\u00de,\3\2\2\2\u00df\u00e0\7d\2\2\u00e0\u00e1\7t\2\2\u00e1\u00e2"+
		"\7g\2\2\u00e2\u00e3\7c\2\2\u00e3\u00e4\7m\2\2\u00e4.\3\2\2\2\u00e5\u00e6"+
		"\7k\2\2\u00e6\u00e7\7p\2\2\u00e7\60\3\2\2\2\u00e8\u00e9\7k\2\2\u00e9\u00ea"+
		"\7h\2\2\u00ea\62\3\2\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed\7n\2\2\u00ed\u00ee"+
		"\7u\2\2\u00ee\u00ef\7g\2\2\u00ef\64\3\2\2\2\u00f0\u00f1\7g\2\2\u00f1\u00f2"+
		"\7n\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7h\2\2\u00f4\66\3\2\2\2\u00f5\u00f6"+
		"\7p\2\2\u00f6\u00f7\7q\2\2\u00f7\u00f8\7v\2\2\u00f88\3\2\2\2\u00f9\u00fa"+
		"\7c\2\2\u00fa\u00fb\7p\2\2\u00fb\u00fc\7f\2\2\u00fc:\3\2\2\2\u00fd\u00fe"+
		"\7q\2\2\u00fe\u00ff\7t\2\2\u00ff<\3\2\2\2\u0100\u0101\7f\2\2\u0101\u0102"+
		"\7g\2\2\u0102\u0103\7n\2\2\u0103>\3\2\2\2\u0104\u0105\7v\2\2\u0105\u0106"+
		"\7j\2\2\u0106\u0107\7k\2\2\u0107\u0108\7u\2\2\u0108@\3\2\2\2\u0109\u010a"+
		"\t\3\2\2\u010aB\3\2\2\2\u010b\u010d\t\4\2\2\u010c\u010b\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u010f\3\2\2\2\u010e\u0110\5A!\2\u010f\u010e\3\2\2"+
		"\2\u0110\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112D"+
		"\3\2\2\2\u0113\u0115\5A!\2\u0114\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011a\7\60"+
		"\2\2\u0119\u011b\5A!\2\u011a\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011a"+
		"\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011f\3\2\2\2\u011e\u0120\5C\"\2\u011f"+
		"\u011e\3\2\2\2\u011f\u0120\3\2\2\2\u0120F\3\2\2\2\u0121\u0122\7}\2\2\u0122"+
		"H\3\2\2\2\u0123\u0124\7\177\2\2\u0124J\3\2\2\2\u0125\u0126\7]\2\2\u0126"+
		"L\3\2\2\2\u0127\u0128\7_\2\2\u0128N\3\2\2\2\u0129\u012a\7*\2\2\u012aP"+
		"\3\2\2\2\u012b\u012c\7+\2\2\u012cR\3\2\2\2\u012d\u012e\t\5\2\2\u012e\u012f"+
		"\t\6\2\2\u012f\u0130\t\7\2\2\u0130T\3\2\2\2\u0131\u0135\t\b\2\2\u0132"+
		"\u0134\t\t\2\2\u0133\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2"+
		"\2\2\u0135\u0136\3\2\2\2\u0136V\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139"+
		"\7-\2\2\u0139\u013a\7?\2\2\u013aX\3\2\2\2\u013b\u013c\7/\2\2\u013c\u013d"+
		"\7?\2\2\u013dZ\3\2\2\2\u013e\u013f\7,\2\2\u013f\u0140\7?\2\2\u0140\\\3"+
		"\2\2\2\u0141\u0142\7\61\2\2\u0142\u0143\7?\2\2\u0143^\3\2\2\2\u0144\u0145"+
		"\7,\2\2\u0145\u0146\7,\2\2\u0146`\3\2\2\2\u0147\u0148\7,\2\2\u0148b\3"+
		"\2\2\2\u0149\u014a\7\61\2\2\u014ad\3\2\2\2\u014b\u014c\7-\2\2\u014cf\3"+
		"\2\2\2\u014d\u014e\7/\2\2\u014eh\3\2\2\2\u014f\u0150\7?\2\2\u0150\u0151"+
		"\7?\2\2\u0151j\3\2\2\2\u0152\u0153\7#\2\2\u0153\u0154\7?\2\2\u0154l\3"+
		"\2\2\2\u0155\u0156\7>\2\2\u0156\u0157\7?\2\2\u0157n\3\2\2\2\u0158\u0159"+
		"\7@\2\2\u0159\u015a\7?\2\2\u015ap\3\2\2\2\u015b\u015c\7?\2\2\u015cr\3"+
		"\2\2\2\u015d\u015e\7>\2\2\u015et\3\2\2\2\u015f\u0160\7@\2\2\u0160v\3\2"+
		"\2\2\u0161\u0162\7%\2\2\u0162x\3\2\2\2\u0163\u0164\7\u0080\2\2\u0164z"+
		"\3\2\2\2\u0165\u0166\7.\2\2\u0166|\3\2\2\2\u0167\u0168\7=\2\2\u0168~\3"+
		"\2\2\2\u0169\u016a\7$\2\2\u016a\u016b\5\u0081A\2\u016b\u016c\7$\2\2\u016c"+
		"\u0080\3\2\2\2\u016d\u0170\5\u0083B\2\u016e\u0170\n\n\2\2\u016f\u016d"+
		"\3\2\2\2\u016f\u016e\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u016f\3\2\2\2\u0171"+
		"\u0172\3\2\2\2\u0172\u0082\3\2\2\2\u0173\u0171\3\2\2\2\u0174\u0175\7^"+
		"\2\2\u0175\u0176\t\n\2\2\u0176\u0084\3\2\2\2\u0177\u0178\7\61\2\2\u0178"+
		"\u0179\7&\2\2\u0179\u017d\3\2\2\2\u017a\u017c\13\2\2\2\u017b\u017a\3\2"+
		"\2\2\u017c\u017f\3\2\2\2\u017d\u017e\3\2\2\2\u017d\u017b\3\2\2\2\u017e"+
		"\u0180\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0181\7&\2\2\u0181\u0182\7\61"+
		"\2\2\u0182\u0086\3\2\2\2\u0183\u0184\7&\2\2\u0184\u0185\7&\2\2\u0185\u0189"+
		"\3\2\2\2\u0186\u0188\n\2\2\2\u0187\u0186\3\2\2\2\u0188\u018b\3\2\2\2\u0189"+
		"\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u0088\3\2\2\2\u018b\u0189\3\2"+
		"\2\2\20\2\u00af\u00b4\u00b9\u010c\u0111\u0116\u011c\u011f\u0135\u016f"+
		"\u0171\u017d\u0189\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}