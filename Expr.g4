grammar Expr;	

///prog:	(expr NEWLINE | CLASS | seq)*  ;
///seq:	L_S_BRACKET (NOTE COMMA)* NOTE R_S_BRACKET ; 
///expr:	expr ('*'|'/') expr
///    |	expr ('+'|'-') expr
///    |	INT
///	|   FLOAT
///	|   STRING
///	|   ID
///	|	ASSIGN	
///    |	'(' expr ')'
///    ;

prog: 	single_input ;
///	|	file_input ;

single_input:
		(NEWLINE | stmt NEWLINE) ;

decorator: 
		'@' dotted_name ( '(' (arglist)? ')' )? NEWLINE ;

decorators: 
		decorator+ ;

decorated: 
		decorators (classdef | funcdef) ;

// needs assign statement
stmt:
		simple_stmt 
	| 	expr_stmt 
	| 	compound_stmt 
	| 	selection_stmt 
	|	iteration_stmt 
	| 	jump_stmt 
	| 	funcdef 
	| 	classdef
	|	assign_stmt
	;

simple_stmt:
		small_stmt (';' small_stmt)* ';' ;

small_stmt:
		(del_stmt | import_stmt) ;

del_stmt:
		DEL expr_list ;

import_stmt:
		import_name
	| 	import_from ;

import_name:
		IMPORT dotted_as_names ;

import_from:
		(FROM ('.'* dotted_name | '.'+) IMPORT ('*' | '(' import_as_names ')' | import_as_names) );

import_as_name:
		NAME ('as' NAME) ;

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
        expr_list ';' ;

compound_stmt:
        '{' (stmt_list)? '}' ;

stmt_list:
		stmt
	|	stmt_list stmt ;

selection_stmt:
		IF '(' test ')' stmt (ELIF '(' test ')' stmt)* (ELSE stmt)? ;

iteration_stmt:
		while_stmt 
	| 	for_stmt ;

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
		ASSIGN
	|	PLUSASSIGN
	|	MINUSASSIGN
	|	TIMESASSIGN
	|	DIVIDEASSIGN ;



jump_stmt:
        break_stmt 
	| 	continue_stmt 
	| 	return_stmt ;
 
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
        NOT not_test | comparison ;
 
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
	|	'is'
	|	'is' NOT ;

expr: 
	arith_expr ;
 
arith_expr:
        term (('+'|'-') term)* ;
 
term:
        factor (('*'|'/'|'%'|'//') factor)* ;
 
factor:
        ('+'|'-')  factor 
    | 	power ;

power: 
		atom trailer* ( '**' factor )? ;


atom:
		'(' (listmaker)? ')' 
	| 	songmaker
	|	'\'' testlist1 '\'' 
	|   sequencemaker
	| 	NAME 
	| 	NUMBER 
	| 	STRING+ 
	| 	NONE
	|	TRUE
	|	FALSE
	| 	NOTE ;
 
trailer: 
		'(' arglist? ')' 
 	| 	'[' subscriptlist ']' 
 	|	'.' NAME ;

/// subscriptlist: subscript (',' subscript)* [',']
subscriptlist: 
		subscript ( ',' subscript )* ','? ;

/// subscript: test | [test] ':' [test] [sliceop]
subscript: 
		test 
 	| 	test? ':' test? sliceop? ;


listmaker:
		test ( list_for | (',' test)* ) ;
/// remove [',']


sequencemaker: 
		'[' ((NOTE | NAME) ( ',' (NOTE | NAME) )*)? ']' ;

songmaker:
		'{' ((sequencemaker | NAME) (',' (sequencemaker | NAME))*)? '}' ;

arglist:
		(argument ',')* (argument (',')? | '*' test (',' argument)* (',' '**' test)? | '**' test) ;

argument:
		test (comp_for)?
	| 	test '=' test ;

list_iter:
		list_for 
	| 	list_if ;

list_for:
		FOR expr_list IN test_list (list_iter)? ;
/// change testlist_safe to test_list 


list_if:
		IF test (list_iter)? ;

comp_iter:
		comp_for 
	| 	comp_if ;
 
comp_for:
		FOR expr_list IN or_test (comp_iter)? ;

comp_if:
		IF test (comp_iter)? ;

testlist1: 
		test (',' test)* ;

parameters: 
		'(' (varargslist)? ')' ;

varargslist: 
		(fpdef ('=' test)? ',')* ('*' NAME (',' '**' NAME)? | '**' NAME) | fpdef ('=' test)? (',' fpdef ('=' test)?)* (',')? ;

fpdef: 
		NAME 
	| 	'(' fplist ')' ;

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

NEWLINE 		: [\r\n]+ ;

FLOAT			: DIGIT+ '.' DIGIT+ EXPONENT? ;

NOTE 			: '\'' [A-Ga-gR|r] [0-8] [w|h|q|e|s] '\'' ;

NAME            : ID ;

ID 				: [a-zA-z][a-zA-Z0-9_]*;
INT     		: [0-9]+ ;

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
 : ( SPACES | CMT | SCMT | LINE_JOINING ) -> skip
 ;

fragment CMT			: '/$' .*? '$/' ;
fragment SCMT			: '$$' ~('\r' | '\n')* ;
fragment SPACES			: [ \t]+ ;
fragment LINE_JOINING : '\\' SPACES? ( '\r'? '\n' | '\r' ) ;
fragment DIGIT 			: [0-9] ;
fragment EXPONENT		: [+-]? DIGIT+;