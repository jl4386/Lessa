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
		'del' expr_list ;

import_stmt:
		import_name
	| 	import_from ;

import_name:
		'import' dotted_as_names ;

import_from:
		('from' ('.'* dotted_name | '.'+) 'import' ('*' | '(' import_as_names ')' | import_as_names) );

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
        '{' stmt_list '}' ;

stmt_list:
		stmt
	|	stmt_list stmt ;

selection_stmt:
		'if' '(' test ')' stmt ('elif' '(' test ')' stmt)* ('else' stmt)? ;

iteration_stmt:
		while_stmt 
	| 	for_stmt ;

while_stmt:
		'while' '(' test ')' stmt ;

for_stmt:
		'for' '(' expr_list 'in' test_list ')' stmt ;

funcdef:
		'def' NAME parameters compound_stmt ;

classdef:
		'class' NAME ('(' (test_list)? ')')? compound_stmt ;

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
     	'break' ';'  ;

continue_stmt:
        'continue' ';' ;

return_stmt:
       	'return' (test_list)? ';' ;

expr_list:
		expr (',' expr)*  ;
/// remove [',']

test_list:
		test (',' test)* ;
/// remove [',']


sliceop:
		':' (test)? ;

test:
        or_test ('if' or_test 'else' test)? ;

or_test:
        and_test ('or' and_test)* ;

and_test:
        not_test ('and' not_test)* ;
 
not_test:
        'not' not_test | comparison ;
 
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
	|	'in'
	|	'not' 'in'
	|	'is'
	|	'is' 'not' ;

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
	| 	'{' (songmaker)? '}' 
	|	'\'' testlist1 '\'' 
	| 	NAME 
	| 	NUMBER 
	| 	STRING+ 
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
		'[' NOTE | NAME ( ',' NOTE | NAME )* ']' ;

songmaker:
		'{' sequencemaker | NAME (',' sequencemaker | NAME)* '}' ;

arglist:
		(argument ',')* (argument (',')? | '*' test (',' argument)* (',' '**' test)? | '**' test) ;

argument:
		test (comp_for)?
	| 	test '=' test ;

list_iter:
		list_for 
	| 	list_if ;

list_for:
		'for' expr_list 'in' test_list (list_iter)? ;
/// change testlist_safe to test_list 


list_if:
		'if' test (list_iter)? ;

comp_iter:
		comp_for 
	| 	comp_if ;
 
comp_for:
		'for' expr_list 'in' or_test (comp_iter)? ;

comp_if:
		'if' test (comp_iter)? ;

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




NAME:
		ID ;
NUMBER:
		INT
	|	FLOAT ;

NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;

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

fragment DIGIT 			: [0-9] ;
fragment EXPONENT		: [+-]? DIGIT+;
FLOAT					: DIGIT+ '.' DIGIT+ EXPONENT? ;

L_BRACKET 		: '{' ;
R_BRACKET 		: '}' ;
L_S_BRACKET		: '[' ;
R_S_BRACKET		: ']' ;
L_P 			: '(' ;
R_P				: ')' ;

NOTE 			: [A-Ga-gR|r] [0-8] [w|h|q|e|s] ;

ID 				: [a-zA-z][a-zA-Z0-9_]*;

PLUSASSIGN 		: '+=' ;
MINUSASSIGN 	: '-=' ;
TIMESASSIGN 	: '*=' ;
DIVIDEASSIGN 	: '/=' ;

POWER		: '**' ;
TIMES 		: '*' ;
DIVIDE 		: '/' ;
PLUS  		: '+' ;
MINUS 		: '-' ;

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

CMT		: '/$' .*? '$/' -> skip;
SCMT	: '$$' ~('\r' | '\n')* -> skip;
SPACES	: [ \t]+ -> skip;
LINE_JOINING : '\\' SPACES? ( '\r'? '\n' | '\r' ) -> skip;