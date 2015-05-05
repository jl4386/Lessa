package lessa;

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
	 * Visit a parse tree produced by the {@code SIMPLESTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSIMPLESTMT(ExprParser.SIMPLESTMTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EXPRSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPRSTMT(ExprParser.EXPRSTMTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code COMPSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCOMPSTMT(ExprParser.COMPSTMTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SELECTSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSELECTSTMT(ExprParser.SELECTSTMTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ITRSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITRSTMT(ExprParser.ITRSTMTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JMPSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJMPSTMT(ExprParser.JMPSTMTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FUNCDEFSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFUNCDEFSTMT(ExprParser.FUNCDEFSTMTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CLASSDEFSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCLASSDEFSTMT(ExprParser.CLASSDEFSTMTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ASSIGNSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitASSIGNSTMT(ExprParser.ASSIGNSTMTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DECORATEDSTMT}
	 * labeled alternative in {@link ExprParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDECORATEDSTMT(ExprParser.DECORATEDSTMTContext ctx);
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
	 * Visit a parse tree produced by the {@code IMNAMESTMT}
	 * labeled alternative in {@link ExprParser#import_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIMNAMESTMT(ExprParser.IMNAMESTMTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IMFROMSTMT}
	 * labeled alternative in {@link ExprParser#import_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIMFROMSTMT(ExprParser.IMFROMSTMTContext ctx);
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
	 * Visit a parse tree produced by the {@code LISTLISTSTMT}
	 * labeled alternative in {@link ExprParser#stmt_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLISTLISTSTMT(ExprParser.LISTLISTSTMTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LISTSTMT}
	 * labeled alternative in {@link ExprParser#stmt_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLISTSTMT(ExprParser.LISTSTMTContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#selection_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection_stmt(ExprParser.Selection_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WILEITR}
	 * labeled alternative in {@link ExprParser#iteration_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWILEITR(ExprParser.WILEITRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FORITR}
	 * labeled alternative in {@link ExprParser#iteration_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFORITR(ExprParser.FORITRContext ctx);
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
	 * Visit a parse tree produced by the {@code ASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitASSIGNOP(ExprParser.ASSIGNOPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPASSIGNOP(ExprParser.PASSIGNOPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMASSIGNOP(ExprParser.MASSIGNOPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTASSIGNOP(ExprParser.TASSIGNOPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DASSIGNOP}
	 * labeled alternative in {@link ExprParser#assign_operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDASSIGNOP(ExprParser.DASSIGNOPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BJMP}
	 * labeled alternative in {@link ExprParser#jump_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBJMP(ExprParser.BJMPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CJMP}
	 * labeled alternative in {@link ExprParser#jump_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCJMP(ExprParser.CJMPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RJMP}
	 * labeled alternative in {@link ExprParser#jump_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRJMP(ExprParser.RJMPContext ctx);
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
	 * Visit a parse tree produced by the {@code FTERM}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFTERM(ExprParser.FTERMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TTERM}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTTERM(ExprParser.TTERMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SFATOMTONE}
	 * labeled alternative in {@link ExprParser#tone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSFATOMTONE(ExprParser.SFATOMTONEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ATOMTONE}
	 * labeled alternative in {@link ExprParser#tone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOMTONE(ExprParser.ATOMTONEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PMFACTOR}
	 * labeled alternative in {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPMFACTOR(ExprParser.PMFACTORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PWFACTOR}
	 * labeled alternative in {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPWFACTOR(ExprParser.PWFACTORContext ctx);
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
	 * Visit a parse tree produced by the {@code ATOMLIST}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOMLIST(ExprParser.ATOMLISTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ATOMSONG}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOMSONG(ExprParser.ATOMSONGContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ATOMTESTLIST}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOMTESTLIST(ExprParser.ATOMTESTLISTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ATOMSEQ}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOMSEQ(ExprParser.ATOMSEQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ATOMNAME}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOMNAME(ExprParser.ATOMNAMEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ATOMNUM}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOMNUM(ExprParser.ATOMNUMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ATOMSTR}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOMSTR(ExprParser.ATOMSTRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ATOMNONE}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOMNONE(ExprParser.ATOMNONEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ATOMTR}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOMTR(ExprParser.ATOMTRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ATOMFAL}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOMFAL(ExprParser.ATOMFALContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ATOMNOTE}
	 * labeled alternative in {@link ExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitATOMNOTE(ExprParser.ATOMNOTEContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#listmaker_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListmaker_test(ExprParser.Listmaker_testContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TLRARG}
	 * labeled alternative in {@link ExprParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTLRARG(ExprParser.TLRARGContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TLRSUBLIST}
	 * labeled alternative in {@link ExprParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTLRSUBLIST(ExprParser.TLRSUBLISTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TLRNAME}
	 * labeled alternative in {@link ExprParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTLRNAME(ExprParser.TLRNAMEContext ctx);
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
	 * Visit a parse tree produced by the {@code SUBSCRT}
	 * labeled alternative in {@link ExprParser#subscript}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSUBSCRT(ExprParser.SUBSCRTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SUBSCRTT}
	 * labeled alternative in {@link ExprParser#subscript}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSUBSCRTT(ExprParser.SUBSCRTTContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(ExprParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARGTEST}
	 * labeled alternative in {@link ExprParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARGTEST(ExprParser.ARGTESTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARGEQ}
	 * labeled alternative in {@link ExprParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARGEQ(ExprParser.ARGEQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LISTITRFOR}
	 * labeled alternative in {@link ExprParser#list_iter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLISTITRFOR(ExprParser.LISTITRFORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LISTITRIF}
	 * labeled alternative in {@link ExprParser#list_iter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLISTITRIF(ExprParser.LISTITRIFContext ctx);
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
	 * Visit a parse tree produced by the {@code CMPITRFOR}
	 * labeled alternative in {@link ExprParser#comp_iter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCMPITRFOR(ExprParser.CMPITRFORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CMPITRIF}
	 * labeled alternative in {@link ExprParser#comp_iter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCMPITRIF(ExprParser.CMPITRIFContext ctx);
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
	 * Visit a parse tree produced by the {@code FPDEFNAME}
	 * labeled alternative in {@link ExprParser#fpdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFPDEFNAME(ExprParser.FPDEFNAMEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FPDEFLIST}
	 * labeled alternative in {@link ExprParser#fpdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFPDEFLIST(ExprParser.FPDEFLISTContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#fplist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFplist(ExprParser.FplistContext ctx);
}