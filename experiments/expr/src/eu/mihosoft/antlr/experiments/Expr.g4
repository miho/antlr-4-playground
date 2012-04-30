// java -Xmx500M -cp "/usr/local/lib/antlr4-complete.jar:$CLASSPATH" org.antlr.v4.Tool -visitor Expr.g4
grammar Expr;

@parser::header {package eu.mihosoft.antlr.experiments;}
@lexer::header {package eu.mihosoft.antlr.experiments;}

s : e*;

e :
    e '*' e             # Mult
  | e '+' e             # Add
  | e '-' e             # Sub
  | e '/' e             # Div
  | NUMBER              # Number
  | INT                 # Int
  | VAR                 # Var
  | LPAR e RPAR         # Par
  | VAR '=' e ';'       # Assign
  ;


LPAR : '(';
RPAR : ')';
INT : [0-9]+ ;
NUMBER : INT '.' [0-9]*;

VAR : [a-z]+;

WS : [ \t\n]+ -> skip ;
