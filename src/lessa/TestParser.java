package lessa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class TestParser {

	@Before
	public void setUp() throws Exception {
		
	}

	public ExprParser CreateParser(String input){
		ANTLRInputStream stream = new ANTLRInputStream(input);
		ExprLexer lexer = new ExprLexer(stream);
		return new ExprParser(new CommonTokenStream(lexer));
	}
	
	@Test
	public void testProg() {
		ExprParser parser = CreateParser("import a; m = 1; while (m < 5) { m = m + 1;}");
		ParseTree tree = parser.prog();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(prog (single_input (stmt (simple_stmt (small_stmt (import_stmt (import_name import (dotted_as_names (dotted_as_name (dotted_name a)))))) ;)) (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom m))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;)) (stmt (iteration_stmt (while_stmt while ( (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom m)))))) (comp_op <) (arith_expr (term (factor (power (atom_trailer (atom 5))))))))))) ) (stmt (compound_stmt { (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom m))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom m))))) + (term (factor (power (atom_trailer (atom 1))))))) ;))) })))))))", tree.toStringTree(parser));
	}

	@Test
	public void testSingle_input() {
		ExprParser parser = CreateParser("import a; m = 1; while (m < 5) { m = m + 1;}");
		ParseTree tree = parser.single_input();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(single_input (stmt (simple_stmt (small_stmt (import_stmt (import_name import (dotted_as_names (dotted_as_name (dotted_name a)))))) ;)) (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom m))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;)) (stmt (iteration_stmt (while_stmt while ( (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom m)))))) (comp_op <) (arith_expr (term (factor (power (atom_trailer (atom 5))))))))))) ) (stmt (compound_stmt { (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom m))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom m))))) + (term (factor (power (atom_trailer (atom 1))))))) ;))) }))))))", tree.toStringTree(parser));
	}

	@Test
	public void testDecorator() {
		ExprParser parser = CreateParser("@ s.t (a, b, c)");
		ParseTree tree = parser.decorator();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(decorator @ (dotted_name s . t) ( (arglist (argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a)))))))))))) , (argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom b)))))))))))) , (argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom c))))))))))))) ))", tree.toStringTree(parser));
	}

	@Test
	public void testDecorators() {
		ExprParser parser = CreateParser("@ s.t (a, b, c) @ d.e");
		ParseTree tree = parser.decorators();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(decorators (decorator @ (dotted_name s . t) ( (arglist (argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a)))))))))))) , (argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom b)))))))))))) , (argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom c))))))))))))) )) (decorator @ (dotted_name d . e)))", tree.toStringTree(parser));
	}

	@Test
	public void testDecorated() {
		ExprParser parser = CreateParser("@aa.ss def func (e, f) {a = 1; b = 2; c = 3;}");
		ParseTree tree = parser.decorated();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(decorated (decorators (decorator @ (dotted_name aa . ss))) (funcdef def func (parameters ( (varargslist (fpdef e) , (fpdef f)) )) (compound_stmt { (stmt_list (stmt_list (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom a))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;))) (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom b))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 2))))))) ;))) (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom c))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 3))))))) ;))) })))", tree.toStringTree(parser));
	}

	@Test
	public void testStmt() {
		ExprParser parser = CreateParser("{a = 1; b = 2; c = 3;}");
		ParseTree tree = parser.stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(stmt (compound_stmt { (stmt_list (stmt_list (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom a))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;))) (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom b))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 2))))))) ;))) (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom c))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 3))))))) ;))) }))", tree.toStringTree(parser));
	}

	@Test
	public void testSimple_stmt() {
		ExprParser parser = CreateParser("import a; import b; del c;");
		ParseTree tree = parser.simple_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(simple_stmt (small_stmt (import_stmt (import_name import (dotted_as_names (dotted_as_name (dotted_name a)))))) ; (small_stmt (import_stmt (import_name import (dotted_as_names (dotted_as_name (dotted_name b)))))) ; (small_stmt (del_stmt del (expr_list (expr (arith_expr (term (factor (power (atom_trailer (atom c)))))))))) ;)", tree.toStringTree(parser));
	}

	@Test
	public void testSmall_stmt() {
		ExprParser parser = CreateParser("del e");
		ParseTree tree = parser.small_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(small_stmt (del_stmt del (expr_list (expr (arith_expr (term (factor (power (atom_trailer (atom e))))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testDel_stmt() {
		ExprParser parser = CreateParser("del a");
		ParseTree tree = parser.del_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(del_stmt del (expr_list (expr (arith_expr (term (factor (power (atom_trailer (atom a)))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testImport_stmt() {
		ExprParser parser = CreateParser("import a.b as e");
		ParseTree tree = parser.import_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(import_stmt (import_name import (dotted_as_names (dotted_as_name (dotted_name a . b) as e))))", tree.toStringTree(parser));
	}

	@Test
	public void testImport_name() {
		ExprParser parser = CreateParser("import a.b");
		ParseTree tree = parser.import_name();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(import_name import (dotted_as_names (dotted_as_name (dotted_name a . b))))", tree.toStringTree(parser));
	}

	@Test
	public void testImport_from() {
		ExprParser parser = CreateParser("from a.b import c as d");
		ParseTree tree = parser.import_from();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(import_from from (dotted_name a . b) import (import_as_names (import_as_name c as d)))", tree.toStringTree(parser));
	}

	@Test
	public void testImport_as_name() {
		ExprParser parser = CreateParser("a as c");
		ParseTree tree = parser.import_as_name();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(import_as_name a as c)", tree.toStringTree(parser));
	}

	@Test
	public void testDotted_as_name() {
		ExprParser parser = CreateParser("a.b as c");
		ParseTree tree = parser.dotted_as_name();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(dotted_as_name (dotted_name a . b) as c)", tree.toStringTree(parser));
	}

	@Test
	public void testImport_as_names() {
		ExprParser parser = CreateParser("aa as B");
		ParseTree tree = parser.import_as_names();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(import_as_names (import_as_name aa as B))", tree.toStringTree(parser));
	}

	@Test
	public void testDotted_as_names() {
		ExprParser parser = CreateParser("test.java as T;");
		ParseTree tree = parser.dotted_as_name();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(dotted_as_name (dotted_name test . java) as T)", tree.toStringTree(parser));
	}

	@Test
	public void testDotted_name() {
		ExprParser parser = CreateParser("test.java");
		ParseTree tree = parser.dotted_name();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(dotted_name test . java)", tree.toStringTree(parser));
	}

	@Test
	public void testExpr_stmt() {
		ExprParser parser = CreateParser("a, b, c;");
		ParseTree tree = parser.expr_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(expr_stmt (expr_list (expr (arith_expr (term (factor (power (atom_trailer (atom a))))))) , (expr (arith_expr (term (factor (power (atom_trailer (atom b))))))) , (expr (arith_expr (term (factor (power (atom_trailer (atom c)))))))) ;)", tree.toStringTree(parser));
	}

	@Test
	public void testCompound_stmt() {
		ExprParser parser = CreateParser("{ a = 1; b = 2; }");
		ParseTree tree = parser.compound_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(compound_stmt { (stmt_list (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom a))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;))) (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom b))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 2))))))) ;))) })", tree.toStringTree(parser));
	}

	@Test
	public void testStmt_list() {
		ExprParser parser = CreateParser("a = 1; b = 2; c = 3;");
		ParseTree tree = parser.stmt_list();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(stmt_list (stmt_list (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom a))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;))) (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom b))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 2))))))) ;))) (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom c))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 3))))))) ;)))", tree.toStringTree(parser));
	}

	@Test
	public void testSelection_stmt() {
		ExprParser parser = CreateParser("if (a > 0) {x = 1;} elif (b > 5) {x = 2;} else {x= 3;}");
		ParseTree tree = parser.selection_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(selection_stmt if ( (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a)))))) (comp_op >) (arith_expr (term (factor (power (atom_trailer (atom 0))))))))))) ) (stmt (compound_stmt { (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom x))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;))) })) elif ( (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom b)))))) (comp_op >) (arith_expr (term (factor (power (atom_trailer (atom 5))))))))))) ) (stmt (compound_stmt { (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom x))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 2))))))) ;))) })) else (stmt (compound_stmt { (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom x))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 3))))))) ;))) })))", tree.toStringTree(parser));
	}

	@Test
	public void testIteration_stmt() {
		ExprParser parser = CreateParser("while (a > 2) {x = 1; a -= 1;}");
		ParseTree tree = parser.iteration_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(iteration_stmt (while_stmt while ( (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a)))))) (comp_op >) (arith_expr (term (factor (power (atom_trailer (atom 2))))))))))) ) (stmt (compound_stmt { (stmt_list (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom x))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;))) (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom a))))))) (assign_operators -=) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;))) }))))", tree.toStringTree(parser));
	}

	@Test
	public void testWhile_stmt() {
		ExprParser parser = CreateParser("while (a > 2) {x = 1; a -= 1;}");
		ParseTree tree = parser.while_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(while_stmt while ( (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a)))))) (comp_op >) (arith_expr (term (factor (power (atom_trailer (atom 2))))))))))) ) (stmt (compound_stmt { (stmt_list (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom x))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;))) (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom a))))))) (assign_operators -=) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;))) })))", tree.toStringTree(parser));
	}

	@Test
	public void testFor_stmt() {
		ExprParser parser = CreateParser("for (a in range (0,3)) {a = 1;}");
		ParseTree tree = parser.for_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(for_stmt for ( (expr_list (expr (arith_expr (term (factor (power (atom_trailer (atom a)))))))) in (test_list (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom range) (trailer ( (arglist (argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 0)))))))))))) , (argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 3))))))))))))) ))))))))))))) ) (stmt (compound_stmt { (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom a))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;))) })))", tree.toStringTree(parser));
	}

	@Test
	public void testFuncdef() {
		ExprParser parser = CreateParser("def fun(a,b,c) {a = 1;}");
		ParseTree tree = parser.funcdef();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(funcdef def fun (parameters ( (varargslist (fpdef a) , (fpdef b) , (fpdef c)) )) (compound_stmt { (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom a))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;))) }))", tree.toStringTree(parser));
	}

	@Test
	public void testClassdef() {
		ExprParser parser = CreateParser("class aa { a = 1; b = 2; }");
		ParseTree tree = parser.classdef();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(classdef class aa (compound_stmt { (stmt_list (stmt_list (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom a))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))))) ;))) (stmt (assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom b))))))) (assign_operators =) (expr (arith_expr (term (factor (power (atom_trailer (atom 2))))))) ;))) }))", tree.toStringTree(parser));
	}

	@Test
	public void testAssign_stmt() {
		ExprParser parser = CreateParser("c -= 1 + 2;");
		ParseTree tree = parser.assign_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(assign_stmt (expr (arith_expr (term (factor (power (atom_trailer (atom c))))))) (assign_operators -=) (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))) + (term (factor (power (atom_trailer (atom 2))))))) ;)", tree.toStringTree(parser));
	}

	@Test
	public void testAssign_operators() {
		ExprParser parser = CreateParser("+=");
		ParseTree tree = parser.assign_operators();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(assign_operators +=)", tree.toStringTree(parser));
	}

	@Test
	public void testJump_stmt() {
		ExprParser parser = CreateParser("break;");
		ParseTree tree = parser.jump_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(jump_stmt (break_stmt break ;))", tree.toStringTree(parser));
	}

	@Test
	public void testBreak_stmt() {
		ExprParser parser = CreateParser("break;");
		ParseTree tree = parser.break_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(break_stmt break ;)", tree.toStringTree(parser));
	}

	@Test
	public void testContinue_stmt() {
		ExprParser parser = CreateParser("continue;");
		ParseTree tree = parser.continue_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(continue_stmt continue ;)", tree.toStringTree(parser));
	}

	@Test
	public void testReturn_stmt() {
		ExprParser parser = CreateParser("return a + b;");
		ParseTree tree = parser.return_stmt();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(return_stmt return (test_list (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a))))) + (term (factor (power (atom_trailer (atom b)))))))))))) ;)", tree.toStringTree(parser));
	}

	@Test
	public void testExpr_list() {
		ExprParser parser = CreateParser("1 + 2, e - f");
		ParseTree tree = parser.expr_list();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(expr_list (expr (arith_expr (term (factor (power (atom_trailer (atom 1))))) + (term (factor (power (atom_trailer (atom 2))))))) , (expr (arith_expr (term (factor (power (atom_trailer (atom e))))) - (term (factor (power (atom_trailer (atom f))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testTest_list() {
		ExprParser parser = CreateParser("a == b, c > d, i in m");
		ParseTree tree = parser.test_list();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(test_list (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a)))))) (comp_op ==) (arith_expr (term (factor (power (atom_trailer (atom b))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom c)))))) (comp_op >) (arith_expr (term (factor (power (atom_trailer (atom d))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom i)))))) (comp_op in) (arith_expr (term (factor (power (atom_trailer (atom m))))))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testSliceop() {
		ExprParser parser = CreateParser(": a or b");
		ParseTree tree = parser.sliceop();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(sliceop : (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a))))))))) or (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom b))))))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testTest() {
		ExprParser parser = CreateParser("a or b if 1 > 2 else c < d");
		ParseTree tree = parser.test();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a))))))))) or (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom b)))))))))) if (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 1)))))) (comp_op >) (arith_expr (term (factor (power (atom_trailer (atom 2)))))))))) else (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom c)))))) (comp_op <) (arith_expr (term (factor (power (atom_trailer (atom d))))))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testOr_test() {
		ExprParser parser = CreateParser("1 == 2 or c not in d");
		ParseTree tree = parser.or_test();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 1)))))) (comp_op ==) (arith_expr (term (factor (power (atom_trailer (atom 2))))))))) or (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom c)))))) (comp_op not in) (arith_expr (term (factor (power (atom_trailer (atom d))))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testAnd_test() {
		ExprParser parser = CreateParser("not a in b and c is not d");
		ParseTree tree = parser.and_test();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(and_test (not_test not (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a)))))) (comp_op in) (arith_expr (term (factor (power (atom_trailer (atom b))))))))) and (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom c)))))) (comp_op is not) (arith_expr (term (factor (power (atom_trailer (atom d)))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testNot_test() {
		ExprParser parser = CreateParser("not a in b");
		ParseTree tree = parser.not_test();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(not_test not (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a)))))) (comp_op in) (arith_expr (term (factor (power (atom_trailer (atom b)))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testComparison() {
		ExprParser parser = CreateParser("1 + 2 < 3 * 4 <= a / b ");
		ParseTree tree = parser.comparison();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(comparison (arith_expr (term (factor (power (atom_trailer (atom 1))))) + (term (factor (power (atom_trailer (atom 2)))))) (comp_op <) (arith_expr (term (factor (power (atom_trailer (atom 3)))) * (factor (power (atom_trailer (atom 4)))))) (comp_op <=) (arith_expr (term (factor (power (atom_trailer (atom a)))) / (factor (power (atom_trailer (atom b)))))))", tree.toStringTree(parser));
	}

	@Test
	public void testComp_op() {
		ExprParser parser = CreateParser("in");
		ParseTree tree = parser.comp_op();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(comp_op in)", tree.toStringTree(parser));
	}

	@Test
	public void testExpr() {
		ExprParser parser = CreateParser("5 * 4 + a - 20 * 30 / 5 ** 2");
		ParseTree tree = parser.arith_expr();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(arith_expr (term (factor (power (atom_trailer (atom 5)))) * (factor (power (atom_trailer (atom 4))))) + (term (factor (power (atom_trailer (atom a))))) - (term (factor (power (atom_trailer (atom 20)))) * (factor (power (atom_trailer (atom 30)))) / (factor (power (atom_trailer (atom 5)) ** (factor (power (atom_trailer (atom 2))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testArith_expr() {
		ExprParser parser = CreateParser("5 * 4 + a - 20 * 30 / 5 ** 2");
		ParseTree tree = parser.arith_expr();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(arith_expr (term (factor (power (atom_trailer (atom 5)))) * (factor (power (atom_trailer (atom 4))))) + (term (factor (power (atom_trailer (atom a))))) - (term (factor (power (atom_trailer (atom 20)))) * (factor (power (atom_trailer (atom 30)))) / (factor (power (atom_trailer (atom 5)) ** (factor (power (atom_trailer (atom 2))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testTerm() {
		ExprParser parser = CreateParser("20 * 30 / 5 ** 2");
		ParseTree tree = parser.term();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(term (factor (power (atom_trailer (atom 20)))) * (factor (power (atom_trailer (atom 30)))) / (factor (power (atom_trailer (atom 5)) ** (factor (power (atom_trailer (atom 2)))))))", tree.toStringTree(parser));
	}

	@Test
	public void testTone() {
		ExprParser parser = CreateParser("#'C3w'");
		ParseTree tree = parser.tone();
		System.out.println(tree.toStringTree(parser));
		assertEquals("(tone # (atom_trailer (atom 'C3w')))", tree.toStringTree(parser));
	}

	@Test
	public void testPower() {
		ExprParser parser = CreateParser("THIS.node(((a, b, c))) ** 3 ** 4");
		ParseTree tree = parser.power();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(power (atom_trailer (atom THIS) (trailer . node) (trailer ( (arglist (argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom ( (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom ( (listmaker_test (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom b))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom c)))))))))))) )))))))))))) )))))))))))))) ))) ** (factor (power (atom_trailer (atom 3)) ** (factor (power (atom_trailer (atom 4)))))))", tree.toStringTree(parser));
	}

	@Test
	public void testAtom_trailer() {
		ExprParser parser = CreateParser("THIS.node(((a, b, c)))");
		ParseTree tree = parser.atom_trailer();
		
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(atom_trailer (atom THIS) (trailer . node) (trailer ( (arglist (argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom ( (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom ( (listmaker_test (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom b))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom c)))))))))))) )))))))))))) )))))))))))))) )))", tree.toStringTree(parser));
	}

	@Test
	public void testAtom() {
		ExprParser parser = CreateParser("20");
		ParseTree tree = parser.atom();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(atom 20)", tree.toStringTree(parser));
		ExprParser parser2 = CreateParser("aa");
		ParseTree tree2 = parser2.atom();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(atom aa)", tree2.toStringTree(parser2));
	}

	@Test
	public void testListmaker_test() {
		ExprParser parser = CreateParser("a, b, c");
		ParseTree tree = parser.listmaker_test();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(listmaker_test (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom b))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom c))))))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testTrailer() {
		ExprParser parser = CreateParser("((a, b, c))");
		ParseTree tree = parser.trailer();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(trailer ( (arglist (argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom ( (listmaker_test (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom b))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom c)))))))))))) )))))))))))))) ))", tree.toStringTree(parser));
		ExprParser parser2 = CreateParser("[1, 2, a]");
		ParseTree tree2 = parser2.trailer();
		//System.out.println(tree2.toStringTree(parser2));
		assertEquals("(trailer [ (subscriptlist (subscript (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 1)))))))))))) , (subscript (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 2)))))))))))) , (subscript (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a))))))))))))) ])", tree2.toStringTree(parser2));
		ExprParser parser3 = CreateParser(".ab");
		ParseTree tree3 = parser3.trailer();
		//System.out.println(tree3.toStringTree(parser3));
		assertEquals("(trailer . ab)", tree3.toStringTree(parser3));
	}

	@Test
	public void testSequencemaker() {
		ExprParser parser = CreateParser("'C3w', a, 'B4w'");
		ParseTree tree = parser.sequencemaker();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(sequencemaker 'C3w' , a , 'B4w')", tree.toStringTree(parser));
	}

	@Test
	public void testSongmaker() {
		ExprParser parser = CreateParser("'C3w', a, 'B4w'");
		ParseTree tree = parser.songmaker();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(songmaker (sequencemaker 'C3w' , a , 'B4w'))", tree.toStringTree(parser));
		ExprParser parser2 = CreateParser("a");
		ParseTree tree2 = parser2.songmaker();
		//System.out.println(tree2.toStringTree(parser2));
		assertEquals("(songmaker (sequencemaker a))", tree2.toStringTree(parser2));
	}

	@Test
	public void testSubscriptlist() {
		ExprParser parser = CreateParser("1, a, b");
		ParseTree tree = parser.subscriptlist();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(subscriptlist (subscript (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 1)))))))))))) , (subscript (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a)))))))))))) , (subscript (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom b)))))))))))))",tree.toStringTree(parser));
	}

	@Test
	public void testSubscript() {
		ExprParser parser = CreateParser("1:2");
		ParseTree tree = parser.subscript();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(subscript (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 1))))))))))) : (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 2))))))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testArglist() {
		ExprParser parser = CreateParser("(3, 2, a, b)");
		ParseTree tree = parser.arglist();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(arglist (argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom ( (listmaker_test (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 3))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 2))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom a))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom b)))))))))))) ))))))))))))))", tree.toStringTree(parser));
	}

	@Test
	public void testArgument() {
		ExprParser parser1 = CreateParser("(2, aa, 3)");
		ParseTree tree1 = parser1.argument();
		//System.out.println(tree1.toStringTree(parser1));
		assertEquals("(argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom ( (listmaker_test (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 2))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom aa))))))))))) , (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 3)))))))))))) )))))))))))))", tree1.toStringTree(parser1));
		ExprParser parser2 = CreateParser("2");
		ParseTree tree2 = parser2.argument();
		//System.out.println(tree2.toStringTree(parser2));
		assertEquals("(argument (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 2))))))))))))", tree2.toStringTree(parser2));
	}

	@Test
	public void testParameters() {
		ExprParser parser = CreateParser("(a = 1, b = 2, c = 3)");
		ParseTree tree = parser.parameters();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(parameters ( (varargslist (fpdef a) = (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 1))))))))))) , (fpdef b) = (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 2))))))))))) , (fpdef c) = (test (or_test (and_test (not_test (comparison (arith_expr (term (factor (power (atom_trailer (atom 3)))))))))))) ))", tree.toStringTree(parser));
	}

	@Test
	public void testFpdef() {
		ExprParser parser = CreateParser("a = 1");
		ParseTree tree = parser.fpdef();
		//System.out.println(tree.toStringTree(parser));
		assertEquals("(fpdef a)", tree.toStringTree(parser));
	} 
}
