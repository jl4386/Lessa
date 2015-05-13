package lessa;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

public class TestVisitor {

	@Before
	public void setUp() throws Exception {
	}
	
	public ExprParser CreateParser(String input){
		ANTLRInputStream stream = new ANTLRInputStream(input);
		ExprLexer lexer = new ExprLexer(stream);
		return new ExprParser(new CommonTokenStream(lexer));
	}
	
	public void CreateVisit(ParseTree tree, String expect, int i) throws FileNotFoundException, UnsupportedEncodingException {
		EvalVisitor eval = new EvalVisitor(true);
	    String result = eval.visit(tree);
	    if (i == 1){
	    	System.out.print(result);
	    }
		assertEquals(expect, result);
	}
	@Test
	public void testVisitSingle_inputSingle_inputContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a = 1 + 2;\n if (a > 0) {\n x = 1;\n} elif (b > 5) {\nx = 2;\n} else {\nx= 3;\n}");
		ParseTree tree = parser.single_input();
		CreateVisit(tree, "a = 1 + 2\n\nif a > 0:\n  x = 1\nelif b > 5:\n  x = 2\nelse:\n  x = 3\n\n", 0);
	}

	@Test
	public void testVisitSIMPLESTMTSIMPLESTMTContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("del a; import b;");
		ParseTree tree = parser.stmt();
		CreateVisit(tree, "del a\nimport b \n", 0);
	}

	@Test
	public void testVisitEXPRSTMTEXPRSTMTContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a = a + 1;");
		ParseTree tree = parser.stmt();
		CreateVisit(tree, "a = a + 1\n", 0);
	}

	@Test
	public void testVisitCOMPSTMTCOMPSTMTContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("{a = 1; b = 2; c = 3;}");
		ParseTree tree = parser.stmt();
		CreateVisit(tree, "a = 1\nb = 2\nc = 3\n", 0);
	}

	@Test
	public void testVisitSELECTSTMTSELECTSTMTContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("if (a > b) {\n c = 1;\n} else {\n d = 2;\n}");
		ParseTree tree = parser.stmt();
		CreateVisit(tree, "if a > b:\n  c = 1\nelse:\n  d = 2\n", 0);
	}

//	@Test
//	public void testVisitITRSTMTITRSTMTContext() throws FileNotFoundException, UnsupportedEncodingException {
//		String res = CreateVisit("");
//		//System.out.println(res);
//		assertEquals("break\n\n", res);
//	}

	@Test
	public void testVisitASSIGNSTMTASSIGNSTMTContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a = 1 + 2;");
		ParseTree tree = parser.stmt();
		CreateVisit(tree, "a = 1 + 2\n", 0);
	}

	@Test
	public void testVisitJMPSTMTJMPSTMTContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("break;");
		ParseTree tree = parser.jump_stmt();
		CreateVisit(tree, "break", 0);
	}

//	@Test
//	public void testVisitSimple_stmtSimple_stmtContext() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testVisitSmall_stmtSmall_stmtContext() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testVisitDel_stmtDel_stmtContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("del a");
		ParseTree tree = parser.del_stmt();
		CreateVisit(tree, "del a", 0);
	}

	@Test
	public void testVisitIMNAMESTMTIMNAMESTMTContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("import a");
		ParseTree tree = parser.import_stmt();
		CreateVisit(tree, "import a ", 0);
	}

	@Test
	public void testVisitIMFROMSTMTIMFROMSTMTContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("from a import b as c");
		ParseTree tree = parser.import_stmt();
		CreateVisit(tree, "from a import b as c", 0);
	}

//	@Test
//	public void testVisitImport_fromImport_fromContext() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testVisitImport_as_namesImport_as_namesContext() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testVisitImport_as_nameImport_as_nameContext() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testVisitImport_nameImport_nameContext() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testVisitDotted_as_namesDotted_as_namesContext() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testVisitDotted_as_nameDotted_as_nameContext() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testVisitDotted_nameDotted_nameContext() throws FileNotFoundException, UnsupportedEncodingException {
//		ExprParser parser = CreateParser("break;");
//		ParseTree tree = parser.jump_stmt();
//		CreateVisit(tree, "break", 0);
//	}

	@Test
	public void testVisitBJMPBJMPContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("break;");
		ParseTree tree = parser.jump_stmt();
		CreateVisit(tree, "break", 0);
	}

	@Test
	public void testVisitCJMPCJMPContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("continue;");
		ParseTree tree = parser.jump_stmt();
		CreateVisit(tree, "continue", 0);
	}

	@Test
	public void testVisitRJMPRJMPContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("return;");
		ParseTree tree = parser.jump_stmt();
		CreateVisit(tree, "return ", 0);
	}

	@Test
	public void testVisitBreak_stmtBreak_stmtContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("break;");
		ParseTree tree = parser.break_stmt();
		CreateVisit(tree, "break", 0);
	}

	@Test
	public void testVisitContinue_stmtContinue_stmtContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("continue;");
		ParseTree tree = parser.continue_stmt();
		CreateVisit(tree, "continue", 0);
	}

	@Test
	public void testVisitReturn_stmtReturn_stmtContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("return;");
		ParseTree tree = parser.return_stmt();
		CreateVisit(tree, "return ", 0);
	}

	@Test
	public void testVisitCompound_stmtCompound_stmtContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("{a = c + d;\n e += 1;}");
		ParseTree tree = parser.compound_stmt();
		CreateVisit(tree, "a = c + d\ne += 1\n", 0);
	}

	@Test
	public void testVisitLISTLISTSTMTLISTLISTSTMTContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a = 1 + 2;\n if (a > 0) {\n x = 1;\n} elif (b > 5) {\nx = 2;\n} else {\nx= 3;\n}");
		ParseTree tree = parser.stmt_list();
		CreateVisit(tree, "a = 1 + 2\nif a > 0:\n  x = 1\nelif b > 5:\n  x = 2\nelse:\n  x = 3\n", 0);
	}

	@Test
	public void testVisitLISTSTMTLISTSTMTContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a = 1 + 2;");
		ParseTree tree = parser.stmt_list();
		CreateVisit(tree, "a = 1 + 2\n", 0);
	}

	@Test
	public void testVisitAssign_stmtAssign_stmtContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a = b + c;");
		ParseTree tree = parser.assign_stmt();
		CreateVisit(tree, "a = b + c", 0);
	}

	@Test
	public void testVisitASSIGNOPASSIGNOPContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("=");
		ParseTree tree = parser.assign_operators();
		CreateVisit(tree, "=", 0);
	}

	@Test
	public void testVisitPASSIGNOPPASSIGNOPContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("+=");
		ParseTree tree = parser.assign_operators();
		CreateVisit(tree, "+=", 0);
	}

	@Test
	public void testVisitMASSIGNOPMASSIGNOPContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("-=");
		ParseTree tree = parser.assign_operators();
		CreateVisit(tree, "-=", 0);
	}

	@Test
	public void testVisitTASSIGNOPTASSIGNOPContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("*=");
		ParseTree tree = parser.assign_operators();
		CreateVisit(tree, "*=", 0);
	}

	@Test
	public void testVisitDASSIGNOPDASSIGNOPContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("/=");
		ParseTree tree = parser.assign_operators();
		CreateVisit(tree, "/=", 0);
	}

	@Test
	public void testVisitSelection_stmtSelection_stmtContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("if (a > 0) {\n x = 1;\n} elif (b > 5) {\nx = 2;\n} else {\nx= 3;\n}");
		ParseTree tree = parser.selection_stmt();
		CreateVisit(tree, "if a > 0:\n  x = 1\nelif b > 5:\n  x = 2\nelse:\n  x = 3\n", 0);
	}

//	@Test
//	public void testVisitWILEITRWILEITRContext() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testVisitFORITRFORITRContext() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testVisitFuncdefFuncdefContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("def fun(a,b,c) {\na = 1;\n}");
		ParseTree tree = parser.funcdef();
		CreateVisit(tree, "def fun(a,b,c):\n  a = 1\n", 0);
	}

	@Test
	public void testVisitClassdefClassdefContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("class aa {\n a = 1;\n b = 2;\n }");
		ParseTree tree = parser.classdef();
		CreateVisit(tree, "class aa():\n  a = 1\n  b = 2\n", 0);
	}

	@Test
	public void testVisitWhile_stmtWhile_stmtContext() throws FileNotFoundException, UnsupportedEncodingException {
		
		ExprParser parser = CreateParser("while (True) {\n  b = e;\n if(b == m) {\n b = 5;\nbreak;\n}\n}");
		ParseTree tree = parser.while_stmt();
		CreateVisit(tree, "while True:\n  b = e\n  if b == m:\n    b = 5\n    break\n", 0);
	}

	@Test
	public void testVisitFor_stmtFor_stmtContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("for (a in b) {\n c = 3;\n}");
		ParseTree tree = parser.for_stmt();
		CreateVisit(tree, "for a in b:\n  c = 3\n", 0);
	}

	@Test
	public void testVisitTest_listTest_listContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("b or a, c and d");
		ParseTree tree = parser.test_list();
		CreateVisit(tree, "b or a,c and d", 0);
	}

	@Test
	public void testVisitTestTestContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("b or a");
		ParseTree tree = parser.test();
		CreateVisit(tree, "b or a", 0);//有问题！
	}

	@Test
	public void testVisitOr_testOr_testContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("b or a");
		ParseTree tree = parser.or_test();
		CreateVisit(tree, "b or a", 0);
	}

	@Test
	public void testVisitAnd_testAnd_testContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("c and a");
		ParseTree tree = parser.and_test();
		CreateVisit(tree, "c and a", 0);//这里也是
	}

	@Test
	public void testVisitNot_testNot_testContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("not a");
		ParseTree tree = parser.not_test();
		CreateVisit(tree, "not a", 0);
	}

	@Test
	public void testVisitComparisonComparisonContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a + 1 < b + 2 < c * 3");
		ParseTree tree = parser.comparison();
		CreateVisit(tree, "a + 1 < b + 2 < c * 3", 0);
	}

	@Test
	public void testVisitComp_opComp_opContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("<");
		ParseTree tree = parser.comp_op();
		CreateVisit(tree, "<", 0);
	}

	@Test
	public void testVisitExpr_stmtExpr_stmtContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a + 1, b + 2;");
		ParseTree tree = parser.expr_stmt();
		CreateVisit(tree, "a + 1 ,b + 2\n", 1);
	}

	@Test
	public void testVisitExpr_listExpr_listContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("(1 + 2 * 3)/ 4, c + d");
		ParseTree tree = parser.expr_list();
		CreateVisit(tree, "(1 + 2 * 3) / 4 ,c + d", 0);
	}
	
	@Test
	public void testVisitExprExprContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("(1 + 2 * 3)/ 4");
		ParseTree tree = parser.expr();
		CreateVisit(tree, "(1 + 2 * 3) / 4", 0);
	}

	@Test
	public void testVisitArith_exprArith_exprContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("(1 + 2 * 3)/ 4");
		ParseTree tree = parser.arith_expr();
		CreateVisit(tree, "(1 + 2 * 3) / 4", 0);
	}

	@Test
	public void testVisitFTERMFTERMContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a * b");
		ParseTree tree = parser.term();
		CreateVisit(tree, "a * b", 0);
	}

	@Test
	public void testVisitTTERMTTERMContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("'C3w'");
		ParseTree tree = parser.term();
		CreateVisit(tree, "note('C3w')", 0);
	}

	@Test
	public void testVisitSFATOMTONESFATOMTONEContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("'C3w'");
		ParseTree tree = parser.tone();
		CreateVisit(tree, "note('C3w')", 0);
	}
//
//	@Test
//	public void testVisitATOMTONEATOMTONEContext() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testVisitPMFactor() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testVisitPWFactor() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a ** b");
		ParseTree tree = parser.factor();
		CreateVisit(tree, "a**b", 0);
	}

	@Test
	public void testVisitPowerPowerContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a ** b");
		ParseTree tree = parser.power();
		CreateVisit(tree, "a**b", 0);
	}

	@Test
	public void testVisitAtom_trailerAtom_trailerContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("This.a");
		ParseTree tree = parser.atom_trailer();
		CreateVisit(tree, "This.a", 0);
	}

	@Test
	public void testVisitATOMSONGATOMSONGContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("{a, b}");
		ParseTree tree = parser.atom();
		CreateVisit(tree, "song()", 0);//这里好像也不太对
	}

	@Test
	public void testVisitATOMNAMEATOMNAMEContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("harry");
		ParseTree tree = parser.atom();
		CreateVisit(tree, "harry", 0);
	}

	@Test
	public void testVisitATOMNUMATOMNUMContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("10.2");
		ParseTree tree = parser.atom();
		CreateVisit(tree, "10.2", 0);
	}

	@Test
	public void testVisitATOMSTRATOMSTRContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("\"abc\"");
		ParseTree tree = parser.atom();
		CreateVisit(tree, "\"abc\"", 0);
	}

	@Test
	public void testVisitATOMNONEATOMNONEContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("None");
		ParseTree tree = parser.atom();
		CreateVisit(tree, "None", 0);
	}

	@Test
	public void testVisitATOMTRATOMTRContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("True");
		ParseTree tree = parser.atom();
		CreateVisit(tree, "True", 0);
	}

	@Test
	public void testVisitATOMFALATOMFALContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("False");
		ParseTree tree = parser.atom();
		CreateVisit(tree, "False", 0);
	}

	@Test
	public void testVisitATOMNOTEATOMNOTEContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("'C3w'");
		ParseTree tree = parser.atom();
		CreateVisit(tree, "note('C3w')", 0);
	}

	@Test
	public void testVisitATOMLISTATOMLISTContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("(a, b, c)");
		ParseTree tree = parser.atom();
		CreateVisit(tree, "[a, b, c]", 0);
	}

	@Test
	public void testVisitATOMSEQATOMSEQContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("['C3w', b, 'D4q']");
		ParseTree tree = parser.atom();
		CreateVisit(tree, "sequence([note('C3w'), b, note('D4q')])", 0);
	}

	@Test
	public void testVisitTLRARGTLRARGContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("(a, b, c)");
		ParseTree tree = parser.trailer();
		CreateVisit(tree, "(a,b,c)", 0);
	}

	@Test
	public void testVisitArglistArglistContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a, b, c");
		ParseTree tree = parser.arglist();
		CreateVisit(tree, "a,b,c", 0);
	}

//	@Test
//	public void testVisitARGTESTARGTESTContext() throws FileNotFoundException, UnsupportedEncodingException {
//		ExprParser parser = CreateParser("a for b in c");
//		ParseTree tree = parser.argument();
//		CreateVisit(tree, "(a,b,c)", 1);
//	}

	@Test
	public void testVisitARGEQARGEQContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a = 1");
		ParseTree tree = parser.argument();
		CreateVisit(tree, "a=1", 0);
	}

	@Test
	public void testVisitTLRSUBLISTTLRSUBLISTContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("(a, b, c)");
		ParseTree tree = parser.trailer();
		CreateVisit(tree, "(a,b,c)", 0);
	}

	@Test
	public void testVisitTLRNAMETLRNAMEContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser(".a");
		ParseTree tree = parser.trailer();
		CreateVisit(tree, ".a", 0);
	}

	@Test
	public void testVisitSubscriptlistSubscriptlistContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("[a, b]");
		ParseTree tree = parser.trailer();
		CreateVisit(tree, "[a,b]", 0);
	}
//
//	@Test
//	public void testVisitSUBSCRTSUBSCRTContext() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testVisitSUBSCRTTSUBSCRTTContext() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testVisitSliceopSliceopContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser(": a or b");
		ParseTree tree = parser.sliceop();
		CreateVisit(tree, "a or b", 0);//这里有问题！
	}

	@Test
	public void testVisitListmaker_testListmaker_testContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("a, b, c");
		ParseTree tree = parser.listmaker_test();
		CreateVisit(tree, "a, b, c", 0);
	}

	@Test
	public void testVisitSequencemakerSequencemakerContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("'C3w', b, 'D4q'");
		ParseTree tree = parser.sequencemaker();
		CreateVisit(tree, "note('C3w'), b, note('D4q')", 0);
	}

	@Test
	public void testVisitParametersParametersContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("(a, a)");
		ParseTree tree = parser.parameters();
		CreateVisit(tree, "(a,a)", 0);
	}
//
//	@Test
//	public void testVisitVarargslistVarargslistContext() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testVisitFPDEFNAMEFPDEFNAMEContext() throws FileNotFoundException, UnsupportedEncodingException {
		ExprParser parser = CreateParser("aa");
		ParseTree tree = parser.fpdef();
		CreateVisit(tree, "aa", 0);
	}


}
