grammar Expr;		
prog:	(expr NEWLINE | CLASS | seq)*  ;
seq:	L_S_BRACKET (NOTE COMMA)* NOTE R_S_BRACKET ; 
expr:	expr ('*'|'/') expr
    |	expr ('+'|'-') expr
    |	INT
	|   FLOAT
	|   STRING
	|   ID
	|	ASSIGN	
    |	'(' expr ')'
    ;

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

CMT		: '/$' .*? '$/' ;
SCMT	: '$$' ~('\r' | '\n')* ;
