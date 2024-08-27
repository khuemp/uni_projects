(*TF.1*);
(*b = true
not b
x = true andalso akku
not cmp(x,p)=GREATER
if a then b else c*);

(*TF.2?*);

(*TF.3?*);
fun last nil = NONE
  | last [y] = SOME y
  | last ys =
let 
  val (x::xr) = rev ys
in 
  SOME x
end;
last [1,2,3,4];
last [];
last [1,2];
last [1];

(*TF.4*);
fun toOption x = SOME x;
fun toOptionList nil = NONE
  | toOptionList (x::xs) = SOME (x::xs);

(*TF.5*);
datatype matrjoschka = M of int option;
fun count (M NONE) = 1
  | count (M (SOME x)) = x+1;

(*TF.6*);
fun get xs i = 
let 
  fun get' xs i =
  let 
  val [(a,b)] = List.filter(fn(m,n)=>m = i) xs
in 
  SOME b
end
in 
  (get' xs i) handle Bind => NONE
end;
get [(1,true),(4,false)] 1;
get [(1,true),(4,false)] 3;

type var = string;
datatype exp = C of int
             | V of var
             | A of exp*exp
             | M of exp*exp;

(*TF.7*);
fun vars e = case e of A(e1,e2) => vars e1 @ vars e2
                     | M(e1,e2) => vars e1 @ vars e2
                     | V v => [v]
                     | C c => nil;
vars (M(A(V "x", C 3),A(V "y", C 5)));

fun count x e = List.length(List.filter(fn(i)=>i=x) (vars e));
count "x" (M(A(V "x", V "x"),A(V "y", C 5)));

fun subexps e = e::
(case e of A(e1,e2) => subexps e1 @ subexps e2
         | M(e1,e2) => subexps e1 @ subexps e2
         | _ => nil);
fun check se e = foldl (fn(i,s) => if i = se then true else s) false (subexps e);
check (V "x") (M(A(V "x", V "x"),A(V "y", C 5)));
check (V "z") (M(A(V "x", V "x"),A(V "y", C 5)));

type env = var -> int;
exception Unbound;
val env = (fn "x" => 5|"y" => 3| _ => raise Unbound);
fun instantiate env (V v) = C (env v)
  | instantiate env (A(e,e')) = A(instantiate env e,instantiate env e')
  | instantiate env (M(e,e')) = M(instantiate env e,instantiate env e')
  | instantiate env e = e;
instantiate env (A(V "x",V "y"));

fun eval env (C c) = c
  | eval env (V v) = env v
  | eval env (A(e,e')) = eval env e + eval env e'
  | eval env (M(e,e')) = eval env e * eval env e';
eval env (A(V "x",V "y"));

(*TF.8 done*);

(*TF.9 done*);

datatype tree = T of tree list;
fun fold f (T ts) = f (map (fold f) ts);
val t1 = T[];
val t2 = T[t1,t1,t1];
val t3 = T[T[t2],t1,t2];

(*TF.10*);
fun test (T ts) = length ts = 3;
test t3;
test (T[T[],T[]]);
fun iter n s f = if n<1 then s else iter(n-1)(f s) f;
fun ternary n = iter n (T[]) (fn(s) => T[s,s,s]);
ternary 2;

(*TF.11 done*);

(*TF.12*);
fun addb t = fold (fn [] => T[]|xs => T(xs@[T[]])) t;
addb t3;

(*TF.13*);
fun zweierTeilbaum ts = fold (fn [x,y] => 1+x+y | xs => foldl op+ 0 xs) ts;
zweierTeilbaum (T[T[T[], T[]], T[]]);