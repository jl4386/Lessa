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
		simple_stmt 
	| 	expr_stmt 
	| 	compound_stmt 
	| 	selection_stmt 
	|	iteration_stmt 
	| 	jump_stmt 
	| 	funcdef 
	| 	classdef
	|	assign_stmt
	|	decorated
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
        expr_list? ';' ;

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
	|	IS
	|	IS NOT ;

expr: 
		arith_expr ;
 
arith_expr:
        term (op=('+'|'-') term)* ;

/// note expr


term:
        factor (('*'|'/'|'%'|'//') factor)* 
    |	tone ;

tone:
		(SHARP|FLAT) atom
	|	atom ;
 
factor:
        ('+'|'-')  factor 
    | 	power ;

power: 
		atom_trailer ( '**' factor )? ;

atom_trailer:
		(THIS '.')? atom  (trailer)*;


atom:
		'(' (listmaker_test)? ')' 
	| 	'{' (songmaker)?  '}'
	/// what it testlist1 ????
	|	'\'' testlist1 '\''            
	|   '[' (sequencemaker)? ']'
	| 	NAME 
	| 	NUMBER 
	| 	STRING+ 
	| 	NONE
	|	TRUE
	|	FALSE
	| 	NOTE ;
 



listmaker_test:
		test ( list_for | (',' test)* ) ;
/// remove [',']

trailer: 
		'(' arglist? ')' 
 	| 	'[' subscriptlist ']' 
 	|	'.' NAME ;

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
		test 
 	| 	test? ':' test? sliceop? ;


arglist:
		(argument ',')* (argument (',')? 
	| '*' test (',' argument)* (',' '**' test)? | '**' test) ;

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



FLOAT			: DIGIT+ '.' DIGIT+ EXPONENT? ;

NOTE 			: '\'' ((('A'..'G'|'a'..'g') ('2'..'8') ('w'|'h'|'q'|'e'|'s')) | ('R'|'r') )'\'' ;

NAME            : ID ;

ID 				: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9')*;


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
