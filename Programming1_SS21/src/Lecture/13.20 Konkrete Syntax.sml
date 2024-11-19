exception Error of string;
datatype token = BOOL | INT | ARROW | LPAR | RPAR;
(*Lexer für Typ von F/Ein Lexer ist eine Prozedur, die ‣prüft, ob eine Zeichenfolge lexikalisch zulässig ist und ‣sie gegebenenfalls in eine Wortfolge übersetzt/*);
fun lex nil = nil
  | lex (#" ":: cr) = lex cr
  | lex (#"\t":: cr) = lex cr
  | lex (#"\n":: cr) = lex cr
  | lex (#"b":: #"o":: #"o":: #"l"::cr) = BOOL::lex cr
  | lex (#"i":: #"n":: #"t":: cr) = INT:: lex cr
  | lex (#"-":: #">":: cr) = ARROW:: lex cr
  | lex (#"(":: cr) = LPAR:: lex cr
  | lex (#")":: cr) = RPAR:: lex cr
  | lex _ = raise Error "lex";
lex (explode"(int->int)->int");

(*RA-Prüfer für seq/Ein Prüfer für A ist eine Prozedur, die für eine Wortfolge entscheidet, ob es sich um einen Satz gemäß A handelt/*);
fun test (0::tr) = tr
  | test (1::tr) = test tr
  | test (2::tr) = test (test tr)
  | test _ = raise Error "test";
test [2,0,0,2,0];
test [2,1,0];
test [2,1,0,0];

datatype tree = A | B of tree | C of tree * tree;
fun rep A = [0]
  | rep (B t) = 1::rep t
  | rep (C(t,t')) = 2::rep t@rep t';
rep (C(B A,A));

(*RA-Parser für seq/Ein Parser für A ist ein Prüfer für A, der, falls es sich um einen Satz gemäß A handelt, eine Baumdarstellung gemäß einer abstrakten Syntax für die dargestellte Phrase liefert./*);
fun parse (0::tr) = (A,tr)
  | parse (1::tr) = let 
                      val (s,ts) = parse tr 
                    in (B s,ts) 
                    end
  | parse (2::tr) = let 
                      val (s,ts) = parse tr
                      val (s',ts') = parse ts
                    in (C(s,s'),ts') 
                    end
  | parse _ = raise Error "parse";
parse[2,1,0,0,0];

(*Prüfer für Typen*);
fun ty ts = case pty ts of ARROW::tr => ty tr|tr=>tr 
and pty (BOOL::tr) = tr
  | pty (INT::tr) = tr
  | pty (LPAR::tr) = (case ty tr of RPAR::tr => tr 
                         | _ => raise Error "RPAR")
  | pty _ = raise Error "pty";
ty[INT, ARROW, BOOL, ARROW, BOOL];

(*Parser für Typen*);
datatype ty = Bool | Int | Arrow of ty*ty;
fun ty ts = (case pty ts of (t,ARROW::tr) => 
let val (t',tr') = ty tr in (Arrow(t,t'),tr') end
                | s => s)
and pty (BOOL::tr) = (Bool,tr)
  | pty (INT::tr) = (Int,tr)
  | pty (LPAR::tr) = 
(case ty tr of (t,RPAR::tr') => (t,tr')
    | _ => raise Error "ty")
  | pty _ = raise Error "pty";
ty[INT, ARROW, BOOL, ARROW, BOOL];