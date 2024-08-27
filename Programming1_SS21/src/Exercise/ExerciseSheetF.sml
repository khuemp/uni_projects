type var = string;
datatype exp = C of int
             | V of var
             | A of exp*exp
             | M of exp*exp;

(*F.1*);
fun vars e = case e of A(e1,e2) => vars e1 @ vars e2
                     | M(e1,e2) => vars e1 @ vars e2
                     | V v => [v]
                     | C c => nil;
vars (M(A(V "x", C 3),A(V "y", C 5)));

(*F.2*);
fun test x = (x*x;true) handle Overflow => false;
999999*999999;
test 999999;
test 2;
fun maxSquare () = 
let 
  fun max x = if test x = true then max(x+1) else x-1
  val y = max 1
in 
  SOME y
end;
maxSquare ();
test 32767;
test 32768;

(*F.3*);
type env = var -> int;
exception Unbound;
val env = (fn "x" => 5|"y" => 3| _ => raise Unbound);
fun instantiate env (V v) = C (env v)
  | instantiate env (A(e,e')) = A(instantiate env e,instantiate env e')
  | instantiate env (M(e,e')) = M(instantiate env e,instantiate env e')
  | instantiate env e = e;
instantiate env (A(V "x",V "y"));

(*F.5*);
exception Unbound;
val env = (fn "x" => 5|"y" => 3| _ => raise Unbound);
fun optionEval e = 
let 
  fun eval env (C c) = c
    | eval env (V v) = env v
    | eval env (A(e,e')) = eval env e + eval env e'
    | eval env (M(e,e')) = eval env e * eval env e';
in 
 (eval env e;SOME (eval env e)) handle Unbound => NONE
end;
optionEval (A(V "x",V "y"));
optionEval (A(V "z",V "y"));

(*F.6?*);
val u = fn x => x*x*x + 3*x*x + x + 2;

datatype tree = T of tree list;
fun fold f (T ts) = f (map (fold f) ts);
val t1 = T[];
val t2 = T[t1,t1,t1];
val t3 = T[T[t2],t1,t2];

(*F.7 done*);

(*F.8 done*);

(*F.9*);
fun breadth' (T ts) = foldl (fn(i,s)=> if i = T[] then 1+s else (breadth' i + s)) 0 ts;
breadth' (T[T[],T[T[T[T[],T[],T[]],T[]]]]);
fun sum xs = foldl op+ 0 xs;
fun breadth t = fold (fn [] => 1|xs => sum xs) t;
breadth (T[T[],T[T[T[T[],T[],T[]],T[]]]]);

(*F.10*);
val e = M (A (V "x",C 3) , A (V "y", C 7));

(*F.11?*);
fun degree (T ts) = 
let 
  fun pre (T ts) = length ts::List.concat(map pre ts)
in 
  foldl Int.max ~1 (pre (T ts))
end;
degree (T[T[T[],T[T[],T[]],T[]],T[]]);
degree (T[T[],T[T[],T[]],T[]]);

(*F.12 done*);

(*F.13*);
fun iter n s f = if n<1 then s else iter (n-1) (f s) f;
fun tree n = iter n (T[]) (fn(s) => T[s,s]);
tree 2;

(*F.15*);
fun kanten ts = 1 + fold (foldl op+ 1) ts;