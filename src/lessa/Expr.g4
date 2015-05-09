grammar Expr;	

///prog:	(expr NEWLINE | CLASS | seq)*  ;
///seq:	L_S_BRACKET (NOTE COMMA)* NOTE R_S_BRACKET ; 
///expr:	expr op=('*'|'/') expr
///    |	expr op=('+'|'-') expr
///    |	INT
///	|   FLOAT
///	|   STRING
///	|   ID
///	|	ASSIGN	
///    |	'(' expr ')'
///    ;

prog: 	single_input ;
///	|	file_input ;

///single_input:
///		(NEWLINE | stmt NEWLINE)* ;

single_input:
		(stmt )* ;


decorator: 
		'@' dotted_name ( '(' (arglist)? ')' )?  ;
///'@' dotted_name ( '(' (arglist)? ')' )?  ;

decorators: 
		decorator+ ;

decorated: 
		decorators (classdef | funcdef) ;

// needs assign statement

stmt:
		simple_stmt         #SIMPLESTMT
	| 	expr_stmt           #EXPRSTMT
	| 	compound_stmt       #COMPSTMT
	| 	selection_stmt      #SELECTSTMT
	|	iteration_stmt      #ITRSTMT
	| 	jump_stmt           #JMPSTMT
	| 	funcdef             #FUNCDEFSTMT
	| 	classdef            #CLASSDEFSTMT
	|	assign_stmt         #ASSIGNSTMT
	|	decorated           #DECORATEDSTMT
	;

simple_stmt:
		small_stmt (';' small_stmt)* ';' ;

small_stmt:
		(del_stmt | import_stmt) ;

del_stmt:
		DEL expr_list ;

import_stmt:
		import_name         #IMNAMESTMT
	| 	import_from         #IMFROMSTMT
	;

import_name:
		IMPORT dotted_as_names ;

import_from:
		(FROM ('.'* dotted_name | '.'+) IMPORT ('*' | '(' import_as_names ')' | import_as_names) );

import_as_name:
		NAME ('as' NAME)?;

dotted_as_name:
		dotted_name ('as' NAME)? ;

import_as_names:
		import_as_name (',' import_as_name)* ;
/// remove [',']

dotted_as_names:
		dotted_as_name (',' dotted_as_name)* ;

dotted_name:
		NAME ('.' NAME)* ;


expr_stmt:
        expr_list? ';' ;

compound_stmt:
        '{' (stmt_list)? '}' ;

stmt_list:
		stmt               #LISTSTMT
	|	stmt_list stmt     #LISTLISTSTMT
	;

selection_stmt:
		IF '(' test ')' stmt (ELIF '(' test ')' stmt)* (ELSE stmt)? ;

iteration_stmt:
		while_stmt         #WILEITR
	| 	for_stmt           #FORITR
	;

while_stmt:
		WHILE '(' test ')' stmt ;

for_stmt:
		FOR '(' expr_list IN test_list ')' stmt ;

funcdef:
		DEF NAME parameters compound_stmt ;

classdef:
		CLASS NAME ('(' (test_list)? ')')? compound_stmt ;

assign_stmt:
		expr assign_operators expr ';' ;

assign_operators:
		ASSIGN             #ASSIGNOP
	|	PLUSASSIGN         #PASSIGNOP
	|	MINUSASSIGN        #MASSIGNOP
	|	TIMESASSIGN        #TASSIGNOP
	|	DIVIDEASSIGN       #DASSIGNOP
	;



jump_stmt:
        break_stmt         #BJMP
	| 	continue_stmt      #CJMP
	| 	return_stmt        #RJMP
	;
 
break_stmt:
     	BREAK ';'  ;

continue_stmt:
        CONTINUE ';' ;

return_stmt:
       	RETURN (test_list)? ';' ;

expr_list:
		expr (',' expr)*  ;
/// remove [',']

test_list:
		test (',' test)* ;
/// remove [',']


sliceop:
		':' (test)? ;

test:
        or_test (IF or_test ELSE test)? ;

or_test:
        and_test (OR and_test)* ;

and_test:
        not_test (AND not_test)* ;
 
not_test:
        NOT not_test 
    |   comparison ;
 
comparison:
        arith_expr (comp_op arith_expr)* ;


comp_op:              
        '<'
	|	'>'            
	|	'=='
	|	'>='
	|	'<='
	|	'<>'
	|	'!='
	|	IN
	|	NOT IN
	|	IS
	|	IS NOT ;

expr: 
		arith_expr ;
 
arith_expr:
        term (ADDMINOP term)* ;

ADDMINOP:
		'+'
	|	'-'
	;

/// note expr


term:
        factor (MULDIVOP factor)*            #FTERM
    |	tone                                 #TTERM
    ;

MULDIVOP:
		'*'
	|	'/'
	|	'%'
	|	'//'
	;

tone:
		op=(SHARP|FLAT) atom                    #SFATOMTONE
	|	atom                                 #ATOMTONE
	;
 
factor:
        op=('+'|'-')  factor                    #PMFACTOR
    | 	power                                #PWFACTOR
    ;

power: 
		atom_trailer ( '**' factor )? ;

atom_trailer:
		(THIS '.')? atom  (trailer)*;


atom:
		'(' (test | listmaker_test)? ')'            #ATOMLIST 
	| 	'{' (songmaker)?  '}'                #ATOMSONG
	|   '[' (sequencemaker)? ']'             #ATOMSEQ
	| 	NAME                                 #ATOMNAME
	| 	NUMBER                               #ATOMNUM
	| 	STRING+                              #ATOMSTR
	| 	NONE                                 #ATOMNONE
	|	TRUE                                 #ATOMTR
	|	FALSE                                #ATOMFAL
	| 	NOTE                                 #ATOMNOTE
	;
 



listmaker_test:
		test ( list_for | (',' test)* ) ;
/// remove [',']

trailer: 
		'(' arglist? ')'                     #TLRARG
 	| 	'[' subscriptlist ']'                #TLRSUBLIST
 	|	'.' NAME                             #TLRNAME
 	;

sequencemaker: 
		 (NOTE | NAME) ( ',' (NOTE | NAME) )*  ;

songmaker:
		 (sequencemaker | NAME) (',' (sequencemaker | NAME))* ;




/// subscriptlist: subscript (',' subscript)* [',']
subscriptlist: 
		subscript ( ',' subscript )* ;
///','?

/// subscript: test | [test] ':' [test] [sliceop]
subscript: 
		test                             #SUBSCRT
 	| 	test? ':' test? sliceop?         #SUBSCRTT
 	;


arglist:
		(argument ',')* (argument (',')?                       
	| '*' test (',' argument)* (',' '**' test)? | '**' test)   
	;

argument:
		test (comp_for)?              #ARGTEST
	| 	test '=' test                 #ARGEQ
	;

list_iter:
		list_for                      #LISTITRFOR
	| 	list_if                       #LISTITRIF
	;

list_for:
		FOR expr_list IN test_list (list_iter)? ;
/// change testlist_safe to test_list 


list_if:
		IF test (list_iter)? ;

comp_iter:
		comp_for                       #CMPITRFOR
	| 	comp_if                        #CMPITRIF
	;
 
comp_for:
		FOR expr_list IN or_test (comp_iter)? ;

comp_if:
		IF test (comp_iter)? ;

parameters: 
		'(' (varargslist)? ')' ;

varargslist: 
		(fpdef ('=' test)? ',')* ('*' NAME (',' '**' NAME)? | '**' NAME) | fpdef ('=' test)? (',' fpdef ('=' test)?)* (',')? ;

fpdef: 
		NAME                          #FPDEFNAME
	| 	'(' fplist ')'                #FPDEFLIST
	;

fplist: 
		fpdef (',' fpdef)*  ;
/// [',']


CLASS		: 'class' ;
DEF			: 'def' ;
RETURN		: 'return' ;
CONTINUE	: 'continue' ;
FOR			: 'for' ;
WHILE		: 'while' ;
BREAK		: 'break' ;
IN			: 'in' ;
IF			: 'if' ;
ELSE		: 'else' ;
ELIF		: 'elif' ;
NOT			: 'not' ;
AND			: 'and' ;
OR			: 'or' ;
DEL			: 'del' ;
THIS		: 'this' ; 
FROM 		: 'from';
IMPORT 		: 'import';
AS 			: 'as';
GLOBAL 		: 'global';
IS 			: 'is';
NONE 		: 'None';
TRUE 		: 'True';
FALSE 		: 'False';

NUMBER      	: INT |	FLOAT ;



FLOAT			: DIGIT+ '.' DIGIT+ EXPONENT? ;

NOTE 			: '\'' ((('A'..'G'|'a'..'g') ('1'..'8') ('w'|'h'|'q'|'e'|'s')) | ('R'|'r') )'\'' ;

NAME            : ID ;

ID 				: ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;


fragment INT             	: DEC_INT | OCT_INT | HEX_INT ;
fragment DEC_INT			: NONZERO_DIGIT DIGIT* | '0' ;
fragment OCT_INT			: '0' ('o' | 'O') OCT_DIGIT+ | '0' OCT_DIGIT+ ;
fragment HEX_INT			: '0' ('x' | 'X') HEX_DIGIT+ ;
fragment NONZERO_DIGIT		: [1-9] ;
fragment OCT_DIGIT			: [0-7] ;
fragment HEX_DIGIT			: [a-fA-F0-9] ;

PLUSASSIGN 		: '+=' ;
MINUSASSIGN 	: '-=' ;
TIMESASSIGN 	: '*=' ;
DIVIDEASSIGN 	: '/=' ;
MOD_ASSIGN 		: '%=' ;

POWER		: '**' ;
TIMES 		: '*' ;
DIVIDE 		: '/' ;
PLUS  		: '+' ;
MINUS 		: '-' ;
MOD 		: '%' ;

EQUAL 		: '==' ;
NOTEQUAL 	: '!=' ;
LE 			: '<=' ;
GE 			: '>=' ;
ASSIGN 		: '=' ;
LESS 		: '<' ;
GREATER 	: '>' ;
SHARP 		: '#' ;
FLAT 		: '~' ;

COMMA		: ',' ;
SEMICOLON   : ';' ;

STRING					: '"' STRING_GUTS '"' ;
fragment STRING_GUTS 	: (ESC | ~('\\' | '"'))* ;
ESC						: '\\' ('\\' | '"') ;

SKIP
 : ( SPACES | CMT | SCMT | LINE_JOINING | LINE_BAR | NEWLINE ) -> skip
 ;

NEWLINE 		: [\r\n]+ ;
fragment CMT			: '/$' .*? '$/' ;
fragment SCMT			: '$$' ~('\r' | '\n')* ;
fragment SPACES			: [ \t]+ ;

/// valid line_bar like ['C3q', | , 'C3q'] or ['C3q', | 'C3q']
LINE_BAR		: '|' (SPACES)* (',')? ; 		

fragment LINE_JOINING : '\\' SPACES? ( '\r'? '\n' | '\r' ) ;
fragment DIGIT 			: ('0'..'9')+ ;
fragment EXPONENT		: ('+'|'-')? DIGIT+;
