datatype tree = T of tree list;
fun fold f (T ts) = f (map (fold f) ts);
val t1 = T[];
val t2 = T[t1,t1,t1];
val t3 = T[T[t2],t1,t2];

(*G.1 Heft*);

(*G.2*);
exception Subscript;
fun pred nil = raise Subscript
  | pred [x] = []
  | pred (x::xs) = rev(tl(rev(x::xs)));
pred [1,2,3];

fun dst (T ts) k = List.nth(ts,k-1);
fun ast t nil = t
  | ast t (n::a) = ast (dst t n) a;
fun succ t xs n = ast t (xs@[n]);
succ t3 [1,1] 3;

datatype 'a ltr = L of 'a*'a ltr list;

(*G.3*);
fun fold f (T ts) = f(map(fold f)ts);
fun lfold f (L(x,ts)) = f(x,map(lfold f)ts);

(*G.4*);
fun inpro (L(x,[t1,t2])) = (inpro t1)@[x]@(inpro t2)
  | inpro (L(x,[])) = [x]
  | inpro _ = raise Subscript;
inpro (L(3,[L(1,[L(0,[]),L(2,[])]),L(5,[L(4,[]),L(6,[])])]));
inpro (L(3,[L(1,[L(0,[])]),L(5,[L(4,[]),L(6,[])])]));

(*G.5*);
fun sum' (x::xs) = x + (sum' xs)
  | sum' nil = 0;
fun sum (L(x,ts)) = lfold (fn(y,[])=>y|(z,xs)=>z+sum' xs) (L(x,ts));
sum (L(3,[L(1,[L(0,[]),L(2,[])]),L(5,[L(4,[]),L(6,[])])]));

(*G.6 Heft und alle sind finitär?*);

(*G.9 Heft*);

(*G.10 Heft*);

(*G.11 Heft*);

(*G.12 ?*);

(*G.13 Heft*);

(*G.14 Heft*);

(*G.15 Heft*);

type vertex = int
type edge = vertex * vertex
type graph = vertex list * edge list;

(*G.17*);
fun valid (x,nil) = true
  | valid (x,((a,b)::y)) = if List.exists (fn m=> m=true) (map(fn n => n=a)x) then if List.exists (fn p=> p=true) (map(fn q => q=b)x) then valid (x,y) else false else false;
valid ([1,2,3],[(1,2)]);
valid ([1],[(2,3)]);

fun succ i (x,nil) = nil
  | succ i (x,((a,b)::y)) = if i=a then b::(succ i (x,y)) else succ i (x,y);
succ 1 ([1,2,3],[(1,2),(1,3)]);

(*G.19 ja-ja-ja-ja-nein wegen euclid(0,0)-ja*);

(*G.20*);
fun gcd(x,y) = if x>y then gcd(x-y,y) else if x<y then gcd(x,y-x) else x;
fun gcd' (x,y) (size,depth)= if x>y then gcd' (x-y,y) (size+1,depth+1) else if x<y then gcd' (x,y-x) (size+1,depth+1) else (size,depth);
fun size_depth (x,y) = gcd' (x,y) (0,~1);

fun euclid(x,y) = if y=0 then x else euclid(y,x mod y);
fun euclid' (x,y) (size,depth) = if y<>0 then euclid' (y,x mod y) (size+1,depth+1) else (size,depth);
fun size_depth' (x,y) = euclid' (x,y) (0,~1);