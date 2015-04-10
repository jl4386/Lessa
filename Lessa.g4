/*
 * parser rules
 */

/// single_input: NEWLINE | stmt NEWLINE
single_input
 : NEWLINE
 | stmt NEWLINE
 ;

/// file_input: (NEWLINE | stmt NEWLINE)* ENDMARKER
file_input
 : ( NEWLINE | stmt NEWLINE )* EOF
 ;

/// decorator: '@' dotted_name [ '(' [arglist] ')' ] NEWLINE
decorator
 : '@' dotted_name ( '(' arglist? ')' )? NEWLINE
 ;

/// decorators: decorator+
decorators
 : decorator+
 ;

/// decorated: decorators (classdef | funcdef)
decorated
 : decorators ( classdef | funcdef )
 ;

/// stmt: simple_stmt | expr_stmt | compound_stmt | selection_stmt | iteration_stmt | jump_stmt | funcdef | classdef
stmt
 : simple_stmt 
 | expr_stmt 
 | compound_stmt 
 | selection_stmt 
 | iteration_stmt 
 | jump_stmt 
 | funcdef 
 | classdef
 ;

/// simple_stmt: small_stmt (';' small_stmt)* [';'] NEWLINE
simple_stmt
 : small_stmt ( ';' small_stmt )* ';'? NEWLINE
 ;

/// small_stmt: (del_stmt | import_stmt )
small_stmt
 : del_stmt 
 | import_stmt 
 ;

/// del_stmt: 'del' exprlist
del_stmt
 : DEL exprlist
 ;

 /// import_stmt: import_name | import_from
import_stmt
 : import_name 
 | import_from
 ;

/// import_name: 'import' dotted_as_names
import_name
 : IMPORT dotted_as_names
 ;

/// import_from: ('from' (('.')* dotted_name | ('.')+)
///               'import' ('*' | '(' import_as_names ')' | import_as_names))
import_from
 : FROM ( ( '.' )* dotted_name 
        | ( '.' )+ 
        )
   IMPORT ( '*' 
          | '(' import_as_names ')' 
          | import_as_names
          )         
 ;

/// import_as_name: NAME ['as' NAME]
import_as_name
 : NAME ( AS NAME )?
 ;

/// dotted_as_name: dotted_name ['as' NAME]
dotted_as_name
 : dotted_name ( AS NAME )?
 ;

/// import_as_names: import_as_name (',' import_as_name)* [',']
import_as_names
 : import_as_name ( ',' import_as_name )* ','?
 ;

/// dotted_as_names: dotted_as_name (',' dotted_as_name)*
dotted_as_names
 : dotted_as_name ( ',' dotted_as_name )*
 ;

/// dotted_name: NAME ('.' NAME)*
dotted_name
 : NAME ( '.' NAME )*
 ;

/// expr_stmt: exprlist
expr_stmt
 : exprlist
 ;           

/// compound_stmt: '{' stmt_list '}'
compound_stmt
 : '{' stmt_list '}'
 ;

/// stmt_list: stmt | stmt_list stmt
stmt_list
 : stmt 
 | stmt_list stmt
 ;

/// selection_stmt: 'if' '(' test ')' stmt ('elif' '(' test ')' stmt)* ['else' stmt]
selection_stmt
 : IF '(' test ')' stmt (ELIF '(' test ')' stmt)* (ELSE stmt)?
 ;

/// iteration_stmt: while_stmt | for_stmt
iteration_stmt:
 : while_stmt 
 | for_stmt
 ;

 /// while_stmt: 'while' '(' test ')' stmt
while_stmt
 : WHILE '(' test ')' stmt
 ;

/// for_stmt: 'for' '(' exprlist 'in' testlist ')' stmt
for_stmt
 : FOR '(' exprlist IN testlist ')' stmt
 ;

/// jump_stmt: break_stmt | continue_stmt | return_stmt
jump_stmt
 : break_stmt 
 | continue_stmt 
 | return_stmt
 ;

/// break_stmt: 'break'
break_stmt
 : BREAK
 ;

/// continue_stmt: 'continue'
continue_stmt
 : CONTINUE
 ;

/// return_stmt: 'return' [testlist]
return_stmt
 : RETURN testlist?
 ;

/// funcdef: 'def' NAME parameters compound_stmt
funcdef
 : DEF NAME parameters compound_stmt
 ;

/// classdef: 'class' NAME ['(' [testlist] ')'] compound_stmt
classdef
 : CLASS NAME ( '(' testlist? ')' )? compound_stmt
 ;

/// parameters: '(' [typedargslist] ')'
parameters
 : '(' typedargslist? ')'
 ;


/// exprlist: expr (',' expr)* [',']
exprlist
 : expr ( ',' expr )* ','?
 ;

/// testlist: test (',' test)* [',']
testlist
 : test ( ',' test )* ','?
 ;

/// typedargslist: (tfpdef ['=' test] (',' tfpdef ['=' test])* [','
///                ['*' [tfpdef] (',' tfpdef ['=' test])* [',' '**' tfpdef] | '**' tfpdef]]
///              |  '*' [tfpdef] (',' tfpdef ['=' test])* [',' '**' tfpdef] | '**' tfpdef)
typedargslist
 : tfpdef ( '=' test )? ( ',' tfpdef ( '=' test )? )* ( ',' ( '*' tfpdef? ( ',' tfpdef ( '=' test )? )* ( ',' '**' tfpdef )? 
                                                            | '**' tfpdef 
                                                            )? 
                                                      )?
 | '*' tfpdef? ( ',' tfpdef ( '=' test )? )* ( ',' '**' tfpdef )? 
 | '**' tfpdef
 ;

/// tfpdef: NAME [':' test]
tfpdef
 : NAME ( ':' test )?
 ;

/// varargslist: (vfpdef ['=' test] (',' vfpdef ['=' test])* [','
///       ['*' [vfpdef] (',' vfpdef ['=' test])* [',' '**' vfpdef] | '**' vfpdef]]
///     |  '*' [vfpdef] (',' vfpdef ['=' test])* [',' '**' vfpdef] | '**' vfpdef)
varargslist
 : vfpdef ( '=' test )? ( ',' vfpdef ( '=' test )? )* ( ',' ( '*' vfpdef? ( ',' vfpdef ( '=' test )? )* ( ',' '**' vfpdef )? 
                                                            | '**' vfpdef 
                                                            )? 
                                                      )?
 | '*' vfpdef? ( ',' vfpdef ( '=' test )? )* ( ',' '**' vfpdef )?
 | '**' vfpdef
 ;

/// vfpdef: NAME
vfpdef
 : NAME
 ;



/// augassign: ('+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=' | '^=' |
///             '<<=' | '>>=' | '**=' | '//=')
augassign
 : '+=' 
 | '-=' 
 | '*=' 
 | '@=' // PEP 465
 | '/=' 
 | '%=' 
 | '&=' 
 | '|=' 
 | '^=' 
 | '<<=' 
 | '>>=' 
 | '**=' 
 | '//='
 ;

/// test: or_test ['if' or_test 'else' test] | lambdef
test
 : or_test ( IF or_test ELSE test )?
 ;

/// or_test: and_test ('or' and_test)*
or_test
 : and_test ( OR and_test )*
 ;

/// and_test: not_test ('and' not_test)*
and_test
 : not_test ( AND not_test )*
 ;

/// not_test: 'not' not_test | comparison
not_test
 : NOT not_test 
 | comparison
 ;

/// comparison: expr (comp_op expr)*
comparison
 : expr ( comp_op expr )*
 ;

/// # <> isn't actually a valid comparison operator in Python. It's here for the
/// # sake of a __future__ import described in PEP 401
/// comp_op: '<'|'>'|'=='|'>='|'<='|'<>'|'!='|'in'|'not' 'in'|'is'|'is' 'not'
comp_op
 : '<'
 | '>'
 | '=='
 | '>='
 | '<='
 | '<>'
 | '!='
 | IN
 | NOT IN
 | IS
 | IS NOT
 ;

/// expr: arith_expr
expr
 : arith_expr
 ;

/// arith_expr: term (('+'|'-') term)*
arith_expr
 : term ( '+' term
        | '-' term 
        )*
 ;

/// term: factor (('*'|'/'|'%'|'//') factor)*
term
 : factor ( '*' factor
          | '/' factor
          | '%' factor 
          | '//' factor 
          )*
 ;

/// factor: ('+'|'-') factor | power
factor
 : '+' factor 
 | '-' factor 
 | power
 ;

/// power: atom trailer* ['**' factor]
power
 : atom trailer* ( '**' factor )?
 ;

/// atom: ('(' [yield_expr|testlist_comp] ')' |
///        '[' [testlist_comp] ']' |
///        '{' [dictorsetmaker] '}' |
///        NAME | NUMBER | STRING+ | '...' | 'None' | 'True' | 'False')
atom
 : '(' ( yield_expr | testlist_comp )? ')' 
 | '[' testlist_comp? ']'  
 | '{' dictorsetmaker? '}' 
 | NAME 
 | number 
 | string+ 
 | '...' 
 | NONE
 | TRUE
 | FALSE
 ;

/// testlist_comp: test ( comp_for | (',' test)* [','] )
testlist_comp
 : test ( comp_for 
        | ( ',' test )* ','? 
        )
 ;

/// trailer: '(' [arglist] ')' | '[' subscriptlist ']' | '.' NAME
trailer
 : '(' arglist? ')' 
 | '[' subscriptlist ']' 
 | '.' NAME
 ;

/// subscriptlist: subscript (',' subscript)* [',']
subscriptlist
 : subscript ( ',' subscript )* ','?
 ;

/// subscript: test | [test] ':' [test] [sliceop]
subscript
 : test 
 | test? ':' test? sliceop?
 ;

/// sliceop: ':' [test]
sliceop
 : ':' test?
 ;

/// dictorsetmaker: ( (test ':' test (comp_for | (',' test ':' test)* [','])) |
///                   (test (comp_for | (',' test)* [','])) )
dictorsetmaker
 : test ':' test ( comp_for 
                 | ( ',' test ':' test )* ','? 
                 ) 
 | test ( comp_for 
        | ( ',' test )* ','? 
        )
 ;

/// arglist: (argument ',')* (argument [',']
///                          |'*' test (',' argument)* [',' '**' test]
///                          |'**' test)
arglist
 : ( argument ',' )* ( argument ','?
                     | '*' test ( ',' argument )* ( ',' '**' test )?
                     | '**' test
                     )
 ;

/// # The reason that keywords are test nodes instead of NAME is that using NAME
/// # results in an ambiguity. ast.c makes sure it's a NAME.
/// argument: test [comp_for] | test '=' test  # Really [keyword '='] test
argument
 : test comp_for? 
 | test '=' test
 ;

/// comp_iter: comp_for | comp_if
comp_iter
 : comp_for 
 | comp_if
 ;

/// comp_for: 'for' exprlist 'in' or_test [comp_iter]
comp_for
 : FOR exprlist IN or_test comp_iter?
 ;

/// comp_if: 'if' test [comp_iter]
comp_if
 : IF test comp_iter?
 ;

string
 : STRING_LITERAL
 | BYTES_LITERAL
 ;

number
 : integer
 | FLOAT_NUMBER
 | IMAG_NUMBER
 ;

/// integer        ::=  decimalinteger | octinteger | hexinteger | bininteger
integer
 : DECIMAL_INTEGER
 | OCT_INTEGER
 | HEX_INTEGER
 | BIN_INTEGER
 ;

/*
 * lexer rules
 */


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


FROM : 'from';
IMPORT : 'import';
AS : 'as';
GLOBAL : 'global';
IS : 'is';
NONE : 'None';


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

MOD_ASSIGN : '%=';
MOD : '%';


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


SKIP
 : ( SPACES | COMMENT | LINE_JOINING ) -> skip
 ;