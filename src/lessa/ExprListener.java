package lessa;// Generated from Expr.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#single_input}.
	 * @param ctx the parse tree
	 */
	void enterSingle_input(ExprParser.Single_inputContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#single_input}.
	 * @param ctx the parse tree
	 */
	void exitSingle_input(ExprParser.Single_inputContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecorator(ExprParser.DecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecorator(ExprParser.DecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#decorators}.
	 * @param ctx the parse tree
	 */
	void enterDecorators(ExprParser.DecoratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#decorators}.
	 * @param ctx the parse tree
	 */
	void exitDecorators(ExprParser.DecoratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#decorated}.
	 * @param ctx the parse tree
	 */
	void enterDecorated(ExprParser.DecoratedContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#decorated}.
	 * @param ctx the parse tree
	 */
	void exitDecorated(ExprParser.DecoratedContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(ExprParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(ExprParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSimple_stmt(ExprParser.Simple_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSimple_stmt(ExprParser.Simple_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSmall_stmt(ExprParser.Small_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSmall_stmt(ExprParser.Small_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#del_stmt}.
	 * @param ctx the parse tree
	 */
	void enterDel_stmt(ExprParser.Del_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#del_stmt}.
	 * @param ctx the parse tree
	 */
	void exitDel_stmt(ExprParser.Del_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImport_stmt(ExprParser.Import_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImport_stmt(ExprParser.Import_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#import_name}.
	 * @param ctx the parse tree
	 */
	void enterImport_name(ExprParser.Import_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#import_name}.
	 * @param ctx the parse tree
	 */
	void exitImport_name(ExprParser.Import_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#import_from}.
	 * @param ctx the parse tree
	 */
	void enterImport_from(ExprParser.Import_fromContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#import_from}.
	 * @param ctx the parse tree
	 */
	void exitImport_from(ExprParser.Import_fromContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#import_as_name}.
	 * @param ctx the parse tree
	 */
	void enterImport_as_name(ExprParser.Import_as_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#import_as_name}.
	 * @param ctx the parse tree
	 */
	void exitImport_as_name(ExprParser.Import_as_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#dotted_as_name}.
	 * @param ctx the parse tree
	 */
	void enterDotted_as_name(ExprParser.Dotted_as_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#dotted_as_name}.
	 * @param ctx the parse tree
	 */
	void exitDotted_as_name(ExprParser.Dotted_as_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#import_as_names}.
	 * @param ctx the parse tree
	 */
	void enterImport_as_names(ExprParser.Import_as_namesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#import_as_names}.
	 * @param ctx the parse tree
	 */
	void exitImport_as_names(ExprParser.Import_as_namesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#dotted_as_names}.
	 * @param ctx the parse tree
	 */
	void enterDotted_as_names(ExprParser.Dotted_as_namesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#dotted_as_names}.
	 * @param ctx the parse tree
	 */
	void exitDotted_as_names(ExprParser.Dotted_as_namesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#dotted_name}.
	 * @param ctx the parse tree
	 */
	void enterDotted_name(ExprParser.Dotted_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#dotted_name}.
	 * @param ctx the parse tree
	 */
	void exitDotted_name(ExprParser.Dotted_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(ExprParser.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(ExprParser.Expr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCompound_stmt(ExprParser.Compound_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCompound_stmt(ExprParser.Compound_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(ExprParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(ExprParser.Stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#selection_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSelection_stmt(ExprParser.Selection_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#selection_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSelection_stmt(ExprParser.Selection_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#iteration_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIteration_stmt(ExprParser.Iteration_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#iteration_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIteration_stmt(ExprParser.Iteration_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(ExprParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(ExprParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(ExprParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(ExprParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(ExprParser.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(ExprParser.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#classdef}.
	 * @param ctx the parse tree
	 */
	void enterClassdef(ExprParser.ClassdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#classdef}.
	 * @param ctx the parse tree
	 */
	void exitClassdef(ExprParser.ClassdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(ExprParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(ExprParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 */
	void enterAssign_operators(ExprParser.Assign_operatorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 */
	void exitAssign_operators(ExprParser.Assign_operatorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#jump_stmt}.
	 * @param ctx the parse tree
	 */
	void enterJump_stmt(ExprParser.Jump_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#jump_stmt}.
	 * @param ctx the parse tree
	 */
	void exitJump_stmt(ExprParser.Jump_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreak_stmt(ExprParser.Break_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreak_stmt(ExprParser.Break_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#continue_stmt}.
	 * @param ctx the parse tree
	 */
	void enterContinue_stmt(ExprParser.Continue_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#continue_stmt}.
	 * @param ctx the parse tree
	 */
	void exitContinue_stmt(ExprParser.Continue_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(ExprParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(ExprParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(ExprParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(ExprParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#test_list}.
	 * @param ctx the parse tree
	 */
	void enterTest_list(ExprParser.Test_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#test_list}.
	 * @param ctx the parse tree
	 */
	void exitTest_list(ExprParser.Test_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#sliceop}.
	 * @param ctx the parse tree
	 */
	void enterSliceop(ExprParser.SliceopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#sliceop}.
	 * @param ctx the parse tree
	 */
	void exitSliceop(ExprParser.SliceopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTest(ExprParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTest(ExprParser.TestContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#or_test}.
	 * @param ctx the parse tree
	 */
	void enterOr_test(ExprParser.Or_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#or_test}.
	 * @param ctx the parse tree
	 */
	void exitOr_test(ExprParser.Or_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#and_test}.
	 * @param ctx the parse tree
	 */
	void enterAnd_test(ExprParser.And_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#and_test}.
	 * @param ctx the parse tree
	 */
	void exitAnd_test(ExprParser.And_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#not_test}.
	 * @param ctx the parse tree
	 */
	void enterNot_test(ExprParser.Not_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#not_test}.
	 * @param ctx the parse tree
	 */
	void exitNot_test(ExprParser.Not_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(ExprParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(ExprParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterComp_op(ExprParser.Comp_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitComp_op(ExprParser.Comp_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void enterArith_expr(ExprParser.Arith_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void exitArith_expr(ExprParser.Arith_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ExprParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ExprParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#tone}.
	 * @param ctx the parse tree
	 */
	void enterTone(ExprParser.ToneContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#tone}.
	 * @param ctx the parse tree
	 */
	void exitTone(ExprParser.ToneContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(ExprParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(ExprParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#power}.
	 * @param ctx the parse tree
	 */
	void enterPower(ExprParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#power}.
	 * @param ctx the parse tree
	 */
	void exitPower(ExprParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#atom_trailer}.
	 * @param ctx the parse tree
	 */
	void enterAtom_trailer(ExprParser.Atom_trailerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#atom_trailer}.
	 * @param ctx the parse tree
	 */
	void exitAtom_trailer(ExprParser.Atom_trailerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ExprParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ExprParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#listmaker_test}.
	 * @param ctx the parse tree
	 */
	void enterListmaker_test(ExprParser.Listmaker_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#listmaker_test}.
	 * @param ctx the parse tree
	 */
	void exitListmaker_test(ExprParser.Listmaker_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTrailer(ExprParser.TrailerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTrailer(ExprParser.TrailerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#sequencemaker}.
	 * @param ctx the parse tree
	 */
	void enterSequencemaker(ExprParser.SequencemakerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#sequencemaker}.
	 * @param ctx the parse tree
	 */
	void exitSequencemaker(ExprParser.SequencemakerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#songmaker}.
	 * @param ctx the parse tree
	 */
	void enterSongmaker(ExprParser.SongmakerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#songmaker}.
	 * @param ctx the parse tree
	 */
	void exitSongmaker(ExprParser.SongmakerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#subscriptlist}.
	 * @param ctx the parse tree
	 */
	void enterSubscriptlist(ExprParser.SubscriptlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#subscriptlist}.
	 * @param ctx the parse tree
	 */
	void exitSubscriptlist(ExprParser.SubscriptlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#subscript}.
	 * @param ctx the parse tree
	 */
	void enterSubscript(ExprParser.SubscriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#subscript}.
	 * @param ctx the parse tree
	 */
	void exitSubscript(ExprParser.SubscriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(ExprParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(ExprParser.ArglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(ExprParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(ExprParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#list_iter}.
	 * @param ctx the parse tree
	 */
	void enterList_iter(ExprParser.List_iterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#list_iter}.
	 * @param ctx the parse tree
	 */
	void exitList_iter(ExprParser.List_iterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#list_for}.
	 * @param ctx the parse tree
	 */
	void enterList_for(ExprParser.List_forContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#list_for}.
	 * @param ctx the parse tree
	 */
	void exitList_for(ExprParser.List_forContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#list_if}.
	 * @param ctx the parse tree
	 */
	void enterList_if(ExprParser.List_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#list_if}.
	 * @param ctx the parse tree
	 */
	void exitList_if(ExprParser.List_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#comp_iter}.
	 * @param ctx the parse tree
	 */
	void enterComp_iter(ExprParser.Comp_iterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#comp_iter}.
	 * @param ctx the parse tree
	 */
	void exitComp_iter(ExprParser.Comp_iterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#comp_for}.
	 * @param ctx the parse tree
	 */
	void enterComp_for(ExprParser.Comp_forContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#comp_for}.
	 * @param ctx the parse tree
	 */
	void exitComp_for(ExprParser.Comp_forContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#comp_if}.
	 * @param ctx the parse tree
	 */
	void enterComp_if(ExprParser.Comp_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#comp_if}.
	 * @param ctx the parse tree
	 */
	void exitComp_if(ExprParser.Comp_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#testlist1}.
	 * @param ctx the parse tree
	 */
	void enterTestlist1(ExprParser.Testlist1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#testlist1}.
	 * @param ctx the parse tree
	 */
	void exitTestlist1(ExprParser.Testlist1Context ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(ExprParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(ExprParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#varargslist}.
	 * @param ctx the parse tree
	 */
	void enterVarargslist(ExprParser.VarargslistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#varargslist}.
	 * @param ctx the parse tree
	 */
	void exitVarargslist(ExprParser.VarargslistContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#fpdef}.
	 * @param ctx the parse tree
	 */
	void enterFpdef(ExprParser.FpdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#fpdef}.
	 * @param ctx the parse tree
	 */
	void exitFpdef(ExprParser.FpdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#fplist}.
	 * @param ctx the parse tree
	 */
	void enterFplist(ExprParser.FplistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#fplist}.
	 * @param ctx the parse tree
	 */
	void exitFplist(ExprParser.FplistContext ctx);
}