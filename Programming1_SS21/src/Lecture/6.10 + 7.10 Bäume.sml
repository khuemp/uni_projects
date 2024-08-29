(*exp:expression, var:variable, env:environment/Umgebung/*);
type var = string;
type env = var -> int;
exception Unbound;
val e = fn "x" => 0
         | "y" => 3
         |  _  => raise Unbound;
e "y";
e "z";
datatype exp = C of int
             | V of var
             | A of exp*exp
             | M of exp*exp;
fun eval env (C c) = c
  | eval env (V v) = env v
  | eval env (A(e,e')) = eval env e + eval env e'
  | eval env (M(e,e')) = eval env e * eval env e';
eval e (A(C 2,C 2));
eval e (A(C 2,V "z"));
eval e (M(C 2,V "y"));
Empty;

exception New;
exception Newer of int;
fun f x y = if x then y else raise New;
f (1>2) 1;
fun test New = 0
  | test (Newer x) = 1
  | test _ = ~1;
test New;
(*test (f (1>2) 1) Type clash, phải có handle*);

(5;7)
(*cả 2 bên cùng một typ thì sau->trước*);
(raise New;7);
(raise Unbound;raise New);
(*2 bên khác typ thì trước->sau*);

(raise New) handle New => ();
(raise Newer 7) handle Newer x => x+1;
fun test f = f() handle 
  Newer x => x 
| Overflow => ~1;
test (fn () => raise Newer 6);
fun fac n = if n<1 then 1 else n*fac(n-1);
fac 15;
test (fn () => fac 15);

fun f x = if (x < 0) then 1 else 2 div x handle Div => 3 handle Empty => 4;
2 div 0;
f 0;
fun f' x = (if (x < 0) then 1 else 2 div x handle Empty => 3) handle Div => 4;
f' 0;

exception Double;
fun pisort compare = 
 let 
  fun insert (x,nil) = [x]
    | insert (x,y::yr) = case compare(x,y) of
          GREATER => y::insert(x,yr)
         |   _    => x::y::yr
in
  foldl insert nil
end;
fun mask compare p = case compare p of 
  EQUAL => raise Double 
| v => v;
fun testDouble compare xs = (pisort (mask compare) xs; false) handle Double => true;
testDouble Int.compare [1,1,3,4,2];
testDouble Int.compare [1,2,3,4,5];
(*nếu double thì phải lấy Double trước false, Double=>true/ nếu không double thì (v;false) lấy false vì đều là Konstante và đứng sau*);

exception Unbound;
fun adjoin oldenv newenv x = newenv x handle Unbound => oldenv x;
fun umgebung1 s = if s="banane" then 2 else if s="apfel" then 4 else raise Unbound;
fun umgebung2 s = if s="aprikose" then 6 else if s="banane" then 3 else raise Unbound;
val umgebung3 = adjoin umgebung1 umgebung2;
umgebung3 "banane";
umgebung3 "apfel"(*chuyển sang umgebung1*);
umgebung3 "erm";

fun nth _ nil = NONE
  | nth n (x::xr) = if n<1 then SOME x else nth (n-1) xr;
nth 2 [3,4,5];
nth 3 [3,4,5];

fun valOf (SOME x) = x
  | valOf NONE = raise Option.Option;
valOf (nth 2 [3,4,5]);
valOf (nth 3 [3,4,5]);

fun isSome NONE = false
  | isSome (SOME _) = true;
isSome(nth 2 [3,4,5]);
isSome(nth 3 [3,4,5]);

fun findDouble compare xs = 
let
  exception Double of 'a fun compare' (x,y) = case compare (x,y) of EQUAL => raise Double x 
               | v => v
in
  (pisort compare' xs;NONE) handle Double x => SOME x
end;
findDouble Int.compare [1,1,3,4,2];
findDouble Int.compare [1,1,3,4,2,2];
findDouble Int.compare [1,2,3,4,5];

(*------------------------------------------------*);

datatype tree = T of tree list;
fun arity (T ts) = length ts;
fun dst (T ts) k = List.nth(ts,k-1);
fun linear (T nil) = true
  | linear (T [t]) = linear t
  | linear _ = false;
fun size (T ts) = foldl op+ 1 (map size ts);