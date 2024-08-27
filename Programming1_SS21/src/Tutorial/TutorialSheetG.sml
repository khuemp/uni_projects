datatype tree = T of tree list
datatype 'a ltr = L of 'a*'a ltr list
val t1 = L(7,[])
val t2 = L(1,[L(2,[]),t1,t1])
val t3 = L(3,[L(0,[t2]),L(4,[]),t2]);

(*TG.1 Heft*);

(*TG.2*);
fun fold f (T ts) = f(map(fold f)ts);
fun mapltr f (L(x,y)) = L(f x, map (mapltr f)y);
mapltr (fn x => x*2) t3;

(*TG.3 bắt đầu đánh số từ 0*);
fun prestl l n = 
let 
 fun prel nil k = raise Subscript
   | prel ((L(x,y))::lr) 0 = x
   | prel ((L(x,y))::lr) k = prel (y@lr) (k-1)
in
 prel [l] n
end;
prestl t3 0;
prestl t3 6;
fun prefind l x = 
let
  fun prel nil x i = NONE
    | prel ((L(a,b))::lr) x i = if x=a then SOME i else prel (b@lr) x (i+1)
in
  prel [l] x 0
end;
prefind t2 7;

(*TG.4*);
fun count compare l x = 
let 
  fun count' compare' nil (m:'a) i = i
    | count' compare' ((L(a:'a,b))::lr) (m:'a) i = if compare'(m,a)=EQUAL then count' compare' (b@lr) m (i+1) else count' compare (b@lr) m i
in
  count' compare [l] x 0
end;
count Int.compare t3 7;

(*TG.5*);
fun exists p l =
 let
  fun exists' p nil = false
    | exists' p ((L(a,b))::lr) = if p a then true else exists' p (b@lr)
in
  exists' p [l]
end;
exists (fn x => x mod 2 = 0) t3;
exists (fn x => (x+1) mod 9 = 0) t3;

(*TG.8 Heft b?*);

(*TG.9
fun strictlySorted compare (t::t’::tr) = compare(t,t’) = LESS then strictlySorted(t’::tr) else false
 | strictlySorted compare _ = true
fun gerichtet (T ts) = strict compareTree ts andalso List.all directed ts*);

(*TG.10 Heft*);

(*TG.11 Heft*);

(*TG.12 Heft**);

(*TG.13 Heft*);

(*TG.14 Heft**);

(*TG.15 k cần thiết lắm*);

(*TG.17 Heft**);

(*TG.19 Heft**);

(*TG.20 Heft**);

(*TG.21 Heft a,b,f**);

(*TG.22?Heft a,b,f**);

(*TG.23 Heft*);

(*TG.24 Heft**);

(*TG.25 Heft**);