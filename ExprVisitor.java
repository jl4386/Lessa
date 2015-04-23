// Generated from Expr.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ExprParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#single_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_input(ExprParser.Single_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorator(ExprParser.DecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#decorators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorators(ExprParser.DecoratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#decorated}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorated(ExprParser.DecoratedContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(ExprParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#simple_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_stmt(ExprParser.Simple_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#small_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmall_stmt(ExprParser.Small_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#del_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDel_stmt(ExprParser.Del_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#import_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_stmt(ExprParser.Import_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#import_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_name(ExprParser.Import_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#import_from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_from(ExprParser.Import_fromContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#import_as_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_as_name(ExprParser.Import_as_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#dotted_as_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotted_as_name(ExprParser.Dotted_as_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#import_as_names}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_as_names(ExprParser.Import_as_namesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#dotted_as_names}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotted_as_names(ExprParser.Dotted_as_namesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#dotted_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotted_name(ExprParser.Dotted_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_stmt(ExprParser.Expr_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_stmt(ExprParser.Compound_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#stmt_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_list(ExprParser.Stmt_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#selection_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection_stmt(ExprParser.Selection_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#iteration_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteration_stmt(ExprParser.Iteration_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(ExprParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(ExprParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(ExprParser.FuncdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#classdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassdef(ExprParser.ClassdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(ExprParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_operators(ExprParser.Assign_operatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#jump_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_stmt(ExprParser.Jump_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#break_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_stmt(ExprParser.Break_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#continue_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_stmt(ExprParser.Continue_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(ExprParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(ExprParser.Expr_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#test_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest_list(ExprParser.Test_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#sliceop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSliceop(ExprParser.SliceopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(ExprParser.TestContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#or_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_test(ExprParser.Or_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#and_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_test(ExprParser.And_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#not_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_test(ExprParser.Not_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(ExprParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_op(ExprParser.Comp_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ExprParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#arith_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArith_expr(ExprParser.Arith_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(ExprParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#tone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTone(ExprParser.ToneContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(ExprParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#power}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(ExprParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#atom_trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_trailer(ExprParser.Atom_trailerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(ExprParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#listmaker_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListmaker_test(ExprParser.Listmaker_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailer(ExprParser.TrailerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#sequencemaker}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequencemaker(ExprParser.SequencemakerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#songmaker}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSongmaker(ExprParser.SongmakerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#subscriptlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptlist(ExprParser.SubscriptlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#subscript}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscript(ExprParser.SubscriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(ExprParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(ExprParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#list_iter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_iter(ExprParser.List_iterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#list_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_for(ExprParser.List_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#list_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_if(ExprParser.List_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#comp_iter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_iter(ExprParser.Comp_iterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#comp_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_for(ExprParser.Comp_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#comp_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_if(ExprParser.Comp_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#testlist1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestlist1(ExprParser.Testlist1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(ExprParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#varargslist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarargslist(ExprParser.VarargslistContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#fpdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFpdef(ExprParser.FpdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#fplist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFplist(ExprParser.FplistContext ctx);
}