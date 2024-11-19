exception Error of string;
(*K.1*);
fun lex' nil = nil
  | lex' (#" "::cr) = lex' cr
  | lex' ((#"n")::(#"u")::(#"l")::(#"l")::cr) = 0::(lex' cr)
  | lex' ((#"e")::(#"i")::(#"n")::(#"s")::cr) = 1::(lex' cr)
  | lex' ((#"z")::(#"w")::(#"e")::(#"i")::cr) = 2::(lex' cr)
  | lex' ((#"d")::(#"r")::(#"e")::(#"i")::cr) = 3::(lex' cr)
  | lex' ((#"v")::(#"i")::(#"e")::(#"r")::cr) = 4::(lex' cr)
  | lex' ((#"f")::(#"ü")::(#"n")::(#"f")::cr) = 5::(lex' cr)
  | lex' ((#"s")::(#"e")::(#"c")::(#"h")::(#"s")::cr) = 6::(lex' cr)
  | lex' ((#"s")::(#"i")::(#"e")::(#"b")::(#"e")::(#"n")::cr) = 7::(lex' cr)
  | lex' ((#"a")::(#"c")::(#"h")::(#"t")::cr) = 8::(lex' cr)
  | lex' ((#"n")::(#"e")::(#"u")::(#"n")::cr) = 9::(lex' cr)
  | lex' _ = raise Error "lex'";
fun fac x n = if n<1 then 1 else x*fac x (n-1);
fun digitsToInt nil = 0
  | digitsToInt (x::xs) = x*(fac 10 (List.length xs)) + digitsToInt xs;
digitsToInt [1,7,6,0];
fun lex c = digitsToInt(lex'(explode c));
lex ("eins sieben sechs null");

(*K.2 Heft*);

(*K.3 Heft*);

(*K.5*);
datatype ty = Bool|Int|Arrow of ty*ty;
datatype token = BOOL | INT | ARROW;
fun test ts = case test' ts of ARROW::tr => test tr | tr => tr 
and test' (BOOL::tr) = tr
  | test' (INT::tr) = tr
  | test' _ = raise Error "test'";
test[INT, INT, ARROW, BOOL, ARROW, BOOL];
test[INT, ARROW, BOOL, ARROW, BOOL];
fun parse ts = (case parse' ts of (t,ARROW::tr) => 
let val (t',tr') = parse tr in (Arrow(t,t'),tr') end
                                | s => s)
and parse' (BOOL::tr) = (Bool,tr)
  | parse' (INT::tr) = (Int,tr)
  | parse' _ = raise Error "parse'";
parse[INT, ARROW, BOOL, ARROW, BOOL];
(*vì không có ngoặc trong bài này nên arrow links klammert*);
fun rep (Arrow(a,b)) = (rep a)@[ARROW]@(rep b)
  | rep Bool = [BOOL]
  | rep Int = [INT]
  | rep _ = raise Error "rep";
fun str (Arrow(a,b)) = "->"
  | str Bool = "bool"
  | str Int = "int"
  | str _ = raise Error "str";

(*K.7*);
datatype token = ID of string|CONS|APPEND|LPAR|RPAR;
datatype exp = Id of string|Cons of exp*exp|Append of exp*exp;
fun lex nil = nil
  | lex (#"@"::cs) = CONS::lex cs
  | lex ((#":")::(#":")::cs) = APPEND::lex cs
  | lex (#"(":: cr) = LPAR::lex cr
  | lex (#")":: cr) = RPAR::lex cr
  | lex (c::cr) = if Char.isAlpha c then (ID(implode [c]))::lex cr else raise Error "lex";
lex(explode"x::(y@(z::(u@v)))");
