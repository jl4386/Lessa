package lessa;

// Generated from Expr.g4 by ANTLR 4.5
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
	 * Enter a parse tree produced by the {@code SIMPLESTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterSIMPLESTMT(ExprParser.SIMPLESTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SIMPLESTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitSIMPLESTMT(ExprParser.SIMPLESTMTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EXPRSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterEXPRSTMT(ExprParser.EXPRSTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EXPRSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitEXPRSTMT(ExprParser.EXPRSTMTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code COMPSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterCOMPSTMT(ExprParser.COMPSTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code COMPSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitCOMPSTMT(ExprParser.COMPSTMTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SELECTSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterSELECTSTMT(ExprParser.SELECTSTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SELECTSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitSELECTSTMT(ExprParser.SELECTSTMTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ITRSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterITRSTMT(ExprParser.ITRSTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ITRSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitITRSTMT(ExprParser.ITRSTMTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JMPSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterJMPSTMT(ExprParser.JMPSTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JMPSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitJMPSTMT(ExprParser.JMPSTMTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FUNCDEFSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterFUNCDEFSTMT(ExprParser.FUNCDEFSTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FUNCDEFSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitFUNCDEFSTMT(ExprParser.FUNCDEFSTMTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CLASSDEFSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterCLASSDEFSTMT(ExprParser.CLASSDEFSTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CLASSDEFSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitCLASSDEFSTMT(ExprParser.CLASSDEFSTMTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ASSIGNSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterASSIGNSTMT(ExprParser.ASSIGNSTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ASSIGNSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitASSIGNSTMT(ExprParser.ASSIGNSTMTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DECORATEDSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDECORATEDSTMT(ExprParser.DECORATEDSTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DECORATEDSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDECORATEDSTMT(ExprParser.DECORATEDSTMTContext ctx);
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
	 * Enter a parse tree produced by the {@code IMNAMESTMT}
	 * labeled alternative in {@link ExprParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIMNAMESTMT(ExprParser.IMNAMESTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IMNAMESTMT}
	 * labeled alternative in {@link ExprParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIMNAMESTMT(ExprParser.IMNAMESTMTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IMFROMSTMT}
	 * labeled alternative in {@link ExprParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIMFROMSTMT(ExprParser.IMFROMSTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IMFROMSTMT}
	 * labeled alternative in {@link ExprParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIMFROMSTMT(ExprParser.IMFROMSTMTContext ctx);
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
	 * Enter a parse tree produced by the {@code LISTLISTSTMT}
	 * labeled alternative in {@link ExprParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterLISTLISTSTMT(ExprParser.LISTLISTSTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LISTLISTSTMT}
	 * labeled alternative in {@link ExprParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitLISTLISTSTMT(ExprParser.LISTLISTSTMTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LISTSTMT}
	 * labeled alternative in {@link ExprParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterLISTSTMT(ExprParser.LISTSTMTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LISTSTMT}
	 * labeled alternative in {@link ExprParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitLISTSTMT(ExprParser.LISTSTMTContext ctx);
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
	 * Enter a parse tree produced by the {@code WILEITR}
	 * labeled alternative in {@link ExprParser#iteration_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWILEITR(ExprParser.WILEITRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WILEITR}
	 * labeled alternative in {@link ExprParser#iteration_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWILEITR(ExprParser.WILEITRContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FORITR}
	 * labeled alternative in {@link ExprParser#iteration_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFORITR(ExprParser.FORITRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FORITR}
	 * labeled alternative in {@link ExprParser#iteration_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFORITR(ExprParser.FORITRContext ctx);
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
	 * Enter a parse tree produced by the {@code ASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 */
	void enterASSIGNOP(ExprParser.ASSIGNOPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 */
	void exitASSIGNOP(ExprParser.ASSIGNOPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 */
	void enterPASSIGNOP(ExprParser.PASSIGNOPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 */
	void exitPASSIGNOP(ExprParser.PASSIGNOPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 */
	void enterMASSIGNOP(ExprParser.MASSIGNOPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 */
	void exitMASSIGNOP(ExprParser.MASSIGNOPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 */
	void enterTASSIGNOP(ExprParser.TASSIGNOPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 */
	void exitTASSIGNOP(ExprParser.TASSIGNOPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 */
	void enterDASSIGNOP(ExprParser.DASSIGNOPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 */
	void exitDASSIGNOP(ExprParser.DASSIGNOPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BJMP}
	 * labeled alternative in {@link ExprParser#jump_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBJMP(ExprParser.BJMPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BJMP}
	 * labeled alternative in {@link ExprParser#jump_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBJMP(ExprParser.BJMPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CJMP}
	 * labeled alternative in {@link ExprParser#jump_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCJMP(ExprParser.CJMPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CJMP}
	 * labeled alternative in {@link ExprParser#jump_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCJMP(ExprParser.CJMPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RJMP}
	 * labeled alternative in {@link ExprParser#jump_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRJMP(ExprParser.RJMPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RJMP}
	 * labeled alternative in {@link ExprParser#jump_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRJMP(ExprParser.RJMPContext ctx);
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
	 * Enter a parse tree produced by the {@code FTERM}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterFTERM(ExprParser.FTERMContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FTERM}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitFTERM(ExprParser.FTERMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TTERM}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTTERM(ExprParser.TTERMContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TTERM}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTTERM(ExprParser.TTERMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SFATOMTONE}
	 * labeled alternative in {@link ExprParser#tone}.
	 * @param ctx the parse tree
	 */
	void enterSFATOMTONE(ExprParser.SFATOMTONEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SFATOMTONE}
	 * labeled alternative in {@link ExprParser#tone}.
	 * @param ctx the parse tree
	 */
	void exitSFATOMTONE(ExprParser.SFATOMTONEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ATOMTONE}
	 * labeled alternative in {@link ExprParser#tone}.
	 * @param ctx the parse tree
	 */
	void enterATOMTONE(ExprParser.ATOMTONEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ATOMTONE}
	 * labeled alternative in {@link ExprParser#tone}.
	 * @param ctx the parse tree
	 */
	void exitATOMTONE(ExprParser.ATOMTONEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PMFACTOR}
	 * labeled alternative in {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterPMFACTOR(ExprParser.PMFACTORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PMFACTOR}
	 * labeled alternative in {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitPMFACTOR(ExprParser.PMFACTORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PWFACTOR}
	 * labeled alternative in {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterPWFACTOR(ExprParser.PWFACTORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PWFACTOR}
	 * labeled alternative in {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitPWFACTOR(ExprParser.PWFACTORContext ctx);
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
	 * Enter a parse tree produced by the {@code ATOMLIST}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterATOMLIST(ExprParser.ATOMLISTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ATOMLIST}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitATOMLIST(ExprParser.ATOMLISTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ATOMSONG}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterATOMSONG(ExprParser.ATOMSONGContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ATOMSONG}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitATOMSONG(ExprParser.ATOMSONGContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ATOMSEQ}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterATOMSEQ(ExprParser.ATOMSEQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ATOMSEQ}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitATOMSEQ(ExprParser.ATOMSEQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ATOMNAME}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterATOMNAME(ExprParser.ATOMNAMEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ATOMNAME}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitATOMNAME(ExprParser.ATOMNAMEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ATOMNUM}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterATOMNUM(ExprParser.ATOMNUMContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ATOMNUM}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitATOMNUM(ExprParser.ATOMNUMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ATOMSTR}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterATOMSTR(ExprParser.ATOMSTRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ATOMSTR}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitATOMSTR(ExprParser.ATOMSTRContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ATOMNONE}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterATOMNONE(ExprParser.ATOMNONEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ATOMNONE}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitATOMNONE(ExprParser.ATOMNONEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ATOMTR}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterATOMTR(ExprParser.ATOMTRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ATOMTR}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitATOMTR(ExprParser.ATOMTRContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ATOMFAL}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterATOMFAL(ExprParser.ATOMFALContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ATOMFAL}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitATOMFAL(ExprParser.ATOMFALContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ATOMNOTE}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterATOMNOTE(ExprParser.ATOMNOTEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ATOMNOTE}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitATOMNOTE(ExprParser.ATOMNOTEContext ctx);
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
	 * Enter a parse tree produced by the {@code TLRARG}
	 * labeled alternative in {@link ExprParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTLRARG(ExprParser.TLRARGContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TLRARG}
	 * labeled alternative in {@link ExprParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTLRARG(ExprParser.TLRARGContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TLRSUBLIST}
	 * labeled alternative in {@link ExprParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTLRSUBLIST(ExprParser.TLRSUBLISTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TLRSUBLIST}
	 * labeled alternative in {@link ExprParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTLRSUBLIST(ExprParser.TLRSUBLISTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TLRNAME}
	 * labeled alternative in {@link ExprParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTLRNAME(ExprParser.TLRNAMEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TLRNAME}
	 * labeled alternative in {@link ExprParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTLRNAME(ExprParser.TLRNAMEContext ctx);
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
	 * Enter a parse tree produced by the {@code SUBSCRT}
	 * labeled alternative in {@link ExprParser#subscript}.
	 * @param ctx the parse tree
	 */
	void enterSUBSCRT(ExprParser.SUBSCRTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SUBSCRT}
	 * labeled alternative in {@link ExprParser#subscript}.
	 * @param ctx the parse tree
	 */
	void exitSUBSCRT(ExprParser.SUBSCRTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SUBSCRTT}
	 * labeled alternative in {@link ExprParser#subscript}.
	 * @param ctx the parse tree
	 */
	void enterSUBSCRTT(ExprParser.SUBSCRTTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SUBSCRTT}
	 * labeled alternative in {@link ExprParser#subscript}.
	 * @param ctx the parse tree
	 */
	void exitSUBSCRTT(ExprParser.SUBSCRTTContext ctx);
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
	 * Enter a parse tree produced by the {@code ARGTEST}
	 * labeled alternative in {@link ExprParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterARGTEST(ExprParser.ARGTESTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ARGTEST}
	 * labeled alternative in {@link ExprParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitARGTEST(ExprParser.ARGTESTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ARGEQ}
	 * labeled alternative in {@link ExprParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterARGEQ(ExprParser.ARGEQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ARGEQ}
	 * labeled alternative in {@link ExprParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitARGEQ(ExprParser.ARGEQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LISTITRFOR}
	 * labeled alternative in {@link ExprParser#list_iter}.
	 * @param ctx the parse tree
	 */
	void enterLISTITRFOR(ExprParser.LISTITRFORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LISTITRFOR}
	 * labeled alternative in {@link ExprParser#list_iter}.
	 * @param ctx the parse tree
	 */
	void exitLISTITRFOR(ExprParser.LISTITRFORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LISTITRIF}
	 * labeled alternative in {@link ExprParser#list_iter}.
	 * @param ctx the parse tree
	 */
	void enterLISTITRIF(ExprParser.LISTITRIFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LISTITRIF}
	 * labeled alternative in {@link ExprParser#list_iter}.
	 * @param ctx the parse tree
	 */
	void exitLISTITRIF(ExprParser.LISTITRIFContext ctx);
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
	 * Enter a parse tree produced by the {@code CMPITRFOR}
	 * labeled alternative in {@link ExprParser#comp_iter}.
	 * @param ctx the parse tree
	 */
	void enterCMPITRFOR(ExprParser.CMPITRFORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CMPITRFOR}
	 * labeled alternative in {@link ExprParser#comp_iter}.
	 * @param ctx the parse tree
	 */
	void exitCMPITRFOR(ExprParser.CMPITRFORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CMPITRIF}
	 * labeled alternative in {@link ExprParser#comp_iter}.
	 * @param ctx the parse tree
	 */
	void enterCMPITRIF(ExprParser.CMPITRIFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CMPITRIF}
	 * labeled alternative in {@link ExprParser#comp_iter}.
	 * @param ctx the parse tree
	 */
	void exitCMPITRIF(ExprParser.CMPITRIFContext ctx);
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
	 * Enter a parse tree produced by the {@code FPDEFNAME}
	 * labeled alternative in {@link ExprParser#fpdef}.
	 * @param ctx the parse tree
	 */
	void enterFPDEFNAME(ExprParser.FPDEFNAMEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FPDEFNAME}
	 * labeled alternative in {@link ExprParser#fpdef}.
	 * @param ctx the parse tree
	 */
	void exitFPDEFNAME(ExprParser.FPDEFNAMEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FPDEFLIST}
	 * labeled alternative in {@link ExprParser#fpdef}.
	 * @param ctx the parse tree
	 */
	void enterFPDEFLIST(ExprParser.FPDEFLISTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FPDEFLIST}
	 * labeled alternative in {@link ExprParser#fpdef}.
	 * @param ctx the parse tree
	 */
	void exitFPDEFLIST(ExprParser.FPDEFLISTContext ctx);
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