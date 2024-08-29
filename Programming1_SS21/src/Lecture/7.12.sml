datatype tree = T of tree list;
fun fold f (T ts) = f (map (fold f) ts);
val t1 = T[];
val t2 = T[t1,t1,t1];
val t3 = T[T[t2],t1,t2];

(*cách 1*);
(*Auflisten aller Teilbäume in Postordnung*);
fun postsubtrees (T ts) = foldr (fn (t,tr) => (postsubtrees t) @ tr) [T ts] ts;
(*Zugriff auf Teilbaum mit Postnummer*);
fun postst t k = List.nth(postsubtrees t,k);

(*cách 2*);
datatype 'a entry = I of 'a | F of 'a
(*I: “Muss noch komplett bearbeitet werden”
F: “Unterbäume befinden sich bereits weiter links auf der Agenda”*);
fun postst t = 
let 
 fun postl nil k = raise Subscript
  | postl (I (T ts)::es) k = postl ((map (fn t => (I t)) ts) @ ((F (T ts))::es)) k 
  | postl (F t::es) 0 = t
  | postl (F t::es) k = postl es (k-1)
in
 postl [I t]
end;

(*Linearisierung*);
fun pre (T ts) = length ts :: List.concat(map pre ts)(*khác với fun prep của Projektion*);
pre (T[]);
pre (T[T[]]);
pre (T[T[],T[]]);
pre (T[T[],T[T[],T[]],T[T[]]]);
fun post (T ts) = List.concat(map post ts)@[length ts](*khác với fun pop của Projektion*);
post (T[]);
post (T[T[]]);
post (T[T[],T[]]);
post (T[T[],T[T[],T[]],T[T[]]]);

exception Unbalanced;
fun check (n,m) = if n=m then n else raise Unbalanced
fun depthb (T nil) = 0
  | depthb (T(t::tr)) = 1+foldl check (depthb t) (map depthb tr);
fun balance t = (depthb t;true) handle Unbalance => false;

(*Ein Baum ist gerichtet, wenn seine Unterbaumlisten strikt sortiert sind gemäß der lexikalischen Baumordnung/khi toàn bộ unterbaum đều được sắp xếp theo thứ tự nhỏ -> lớn/
fun strict(t::t'::tr) = compareTree(t,t') = LESS andalso strict(t'::tr)
  | strict _ = true;
fun directed (T ts) = strict ts andalso List.all directed ts;*);

fun eqset x y = subset x y andalso subset y x
and subset (T xs) y = List.all (fn x => member x y) xs
and member x (T ys) = List.exists (eqset x) ys;

fun size (T ts) = foldl accusize 1 ts 
and accusize (t,a) = size t + a;

datatype 'a ltr = L of 'a*'a ltr list;
val t1 = L(7,[]);
val t2 = L(1,[L(2,[]),t1,t1]);
val t3 = L(3,[L(0,[t2]),L(4,[]),t2]);

fun head (L(x,_)) = x;
fun shape (L(_,ts)) = T(map shape ts);
shape t2;

fun find p t = 
let
 fun find' nil = NONE
   | find' (L(x,ts)::tr) = if p x then SOME x else find' (ts @ tr)
in
 find' [t]
end;
find (fn x => x+1=2) (L(3,[L(0,[t2]),L(4,[]),t2]));

(*Anwenden einer Prozedur auf alle Marken im Baum
/sử dụng f cho tất cả x trong Baum/*)
fun lmap f (L(x,ts)) = L (f x,map (lmap f) ts);