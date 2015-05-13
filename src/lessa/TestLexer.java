package lessa;

import static org.junit.Assert.*;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.pattern.TokenTagToken;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.Before;
import org.junit.Test;

public class TestLexer {

	@Before
	public void setUp() throws Exception {
	}
	
	public ExprLexer CreateLexer(String input){
		ANTLRInputStream stream = new ANTLRInputStream(input);
		ExprLexer lexer = new ExprLexer(stream);
		return lexer;
	}
	public void testToken(String input, String expect){
		ExprLexer lexer = CreateLexer(input);
		Token token = lexer.nextToken();
		System.out.print(token.getText());
		assertEquals(expect, token.getText());	
	}
	@Test
	public void testGetAtom() {
		testToken("a", "a");
		testToken("10", "10");
		testToken("'C3w'", "'C3w'");
		testToken("\"abc\"", "\"abc\"");
		testToken("5.5", "5.5");
		testToken("None", "None");
		testToken("True", "True");
		testToken("False", "False");
		testToken("2cs", "2");
	}

	@Test
	public void testGetOperator() {
		testToken("=", "=");
		testToken("+","+");
		testToken("-","-");
		testToken("*","*");
		testToken("/","/");
		testToken("%","%");
		testToken("**","**");
		testToken("+=","+=");
		testToken("-=","-=");
		testToken("*=","*=");
		testToken("/=","/=");
		testToken(">",">");
		testToken("<","<");
		testToken(">=",">=");
		testToken("<=","<=");
		testToken("==","==");
		testToken("!=","!=");
		testToken("#","#");
		testToken("~","~");
	}

	@Test
	public void testGetKeyWords() {
		testToken("while","while");
		testToken("if","if");
		testToken("elif","elif");
		testToken("else","else");
		testToken("for","for");
		testToken("in","in");
		testToken("and","and");
		testToken("or","or");
		testToken("not","not");
		testToken("is","is");
		testToken("this","this");
	}

	@Test
	public void testGetDeliminator() {
		testToken(".",".");
		testToken(",",",");
		testToken(";",";");
		testToken("(","(");
		testToken(")",")");
		testToken("[","[");
		testToken("]","]");
		testToken("{","{");
		testToken("}","}");
	}
}
