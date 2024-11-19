(*D.1d? in Drive*);
(*e,x:'a,x:'b,y:int,x:int*);
val x = fn x =>(fn x =>(fn y => let 
  fun x z = (z+y)+z
  val y = 5
  val z = 1
in
  x (y+z)
end));

(*D.2?*);

(*D.3 in Drive*);
(*c,*);
1::2::nil@3::4::nil;
1::(2::(3::(4::nil)));

(*D.4*);
val ls = nil::nil::nil;

(*D.5*);
fun member_a x nil = false
  | member_a x (y::ys) = x=y orelse member_a x ys;
member_a 1 [2,4,1,5];
member_a 0 [2,4,1,5];
fun member_b x xs = List.exists (fn y => y=x) xs;
member_b 1 [2,4,1,5];
member_b 0 [2,4,1,5];
fun member_c x xs = not (null (List.filter (fn y => y=x) xs));
member_c 1 [2,4,1,5];
member_c 0 [2,4,1,5];
fun member_d x xs = foldl (fn(y,s) => if x=y then true else s) false xs;
member_d 1 [2,4,1,5];
member_d 0 [2,4,1,5];

(*D.6?*);
fun or (false,false) = false
  | or (true,_) = true
  | or (_,true) = true;

(*D.7*);
fun map f nil = nil
  | map f (x::xr) = (f x)::(map f xr);
fun increment a = map(fn y => y+1) a;
increment [1,2,3,4];

(*D.8*);
fun fac x = if x<1 then 0 else x+(fac(x-1));
fun facSum y = foldl(fn(a,b) => (fac a)+b) 0 y;
facSum [3,4];

(*D.9*);
fun stringSize x = List.length(explode x);
stringSize "Hello, world!";

(*D.10?*);
fun teiler(x:int,y:int) = if x mod y = 0 then y else teiler (x,y+1);
fun itsprim(x:int):bool = if teiler (x,2) = x then true else false;
fun nextprim(a:int) = if itsprim(a+1) = true then a+1 else nextprim(a+1);

(*D.11*);
exception Empty
fun max nil = raise Empty
  | max x = foldl(fn(a,b) => if a>b then a else b) 0 x;
max [];
max[2,6,1,5];

(*D.12*);
(*a,*);
fun enumerate(m,n) = if m>n then [] else m::enumerate (m+1,n);
(*b,*);
fun map f nil = nil
  | map f (x::xr) = (f x)::(map f xr);
fun tabulateRange_b m n f = map f (enumerate(m,n));
tabulateRange_b 3 9 (fn a => a*a);
(*c,?*);

(*D.13*);
fun components nil = nil
  | components (x::nil) = [x]
  | components (x::xs) = if List.exists(fn a => a=x)(x::xs) then x::components (List.filter (fn b => b<>x)(x::xs)) else x::components xs;
components [3,6,6,9,3];