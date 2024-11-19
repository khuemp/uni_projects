(*1*)
fun zweiundvierzig x = if x>41 then x else zweiundvierzig(x+1);
zweiundvierzig 3;

(*2*)
fun cube' k n = if k*k*k>=n then k else cube'(k+1) n;
fun cube n = cube' 0 n;
cube 15;

(*3*)
fun mymod(x,y) = if x-y>=0 then mymod(x-y,y) else x;
mymod (0,2);
mymod (9,4);
mymod (8,4);

(*4*)
fun mydiv(x,y) = if x-y>=0 then 1+mydiv(x-y,y) else 0;
mydiv(0,2);
mydiv(4,2);
mydiv(9,2);
fun mydiv'(x,y,k) = if x-y>=0 then mydiv'(x-y,y,k+1) else k;
fun mydiv''(x,y) = mydiv'(x,y,0);
mydiv''(0,2);
mydiv''(4,2);
mydiv''(9,2);

(*5*)
fun fac n = if n<1 then 1 else n*fac(n-1);
fun binom(n,k) = (fac n) div ((fac k)*(fac(n-k)));
binom (5,3);
1 div 10;

(*6*)
fun sump p 0 = 0
  | sump p x = if p (x mod 10) then (x mod 10)+sump p (x div 10) else sump p (x div 10);
sump (fn  z=> z mod 2 = 0) 18429;

(*7*)
exception Subscript;
fun evens' x = if x>=2 then evens'(x-2)@[x] else nil;
fun evens x = if x>=2 then if x mod 2 = 0 then evens' x else raise Subscript else raise Subscript;
evens 8;
evens 9;

(*14*)
fun first s p = if p s then s else first (s+1) p;
fun divi x m = first 1 (fn k => k*m>=x) - 1;
divi 8 3;
divi 0 3;

(*15*)
fun teiler a b = first 2 (fn k=> a mod k = 0 andalso b mod k = 0);
teiler 9 6;
(*teiler 13 4;*)

(*16*);
fun itercond n s d t f = if n<=0 then s else if d s then itercond(n-1)(t s) d t f else itercond(n-1)(f s) d t f;

(*17*);
fun iterup m n s f = if m>n then s else iterup (m+1) n (f(m,s)) f;
fun iter' n s f = iterup 1 n s (fn(a,b) => f b);

(*18*);
fun iter n s f = if n<1 then s else iter (n-1) (f s) f;
fun condpart p xs = 
let 
 val (a,b,c) = iter (List.length xs) (xs,nil,nil) (fn((x::ys),m,n)=> if p x then (ys,x::m,n) else (ys,m,x::n))
in 
  (b,c)
end;
condpart (fn x => x mod 2 = 0) [1,3,2,3,5,7,8];

(*19*)
chr 4;
fun iterdn n m s f = if n<m then s else iterdn (n-1) m (f(n,s)) f;
fun enumchars n m = iterdn n m nil (fn(i,s)=>(chr i) ::s);
enumchars 13 1;

(*20*)
fun divide xs a = map (fn x => x/a) xs;

(*21*)
fun listEvenOdd xs = map (fn x => if x mod 2 = 0 then (x,true) else (x,false)) xs;
listEvenOdd [1,4,2,6,8,3,9];
fun countEvenOdd' (x::xs) (e,oo) = if x mod 2 = 0 then countEvenOdd' xs (e+1,oo) else countEvenOdd' xs (e,oo+1)
 | countEvenOdd' nil (e,oo) = (e,oo);
fun countEvenOdd xr = countEvenOdd' xr (0,0);
countEvenOdd [1,4,2,6,8,3,9];

(*22*)
fun seperate' nil (a,b) = (a,b)
  | seperate' ((x:'a*'b)::xs) (a,b) = seperate' xs (a@[#1 x],b@[#2 x]);
fun seperate xr = seperate' xr (nil,nil);
seperate [(true,1),(false,42)];
fun foldr f s nil = s
  | foldr f s (x::xs) = f(x,foldr f s xs);
fun seperate xr = foldr (fn((i:'a*'b),(a,b))=>((#1 i)::a,(#2 i)::b)) (nil,nil) xr;
seperate [(true,1),(false,42)];

(*23*)
fun cut 0 xs = xs
  | cut n (x::xs) = cut (n-1) xs
  | cut _ nil = raise Subscript;
cut 2 [1,4,2,6,7];
fun sub 0 xs = nil
  | sub n (x::xs) = x:: sub (n-1) xs
  | sub _ nil = nil;
sub 2 [1,4,2,6,7];
sub 8 [1,4,2,6,7];
fun substr x y a = implode(cut(x+1)(sub(x+y+1)(explode a)));
substr 2 4 " Programmierung ";

(*24*)
fun init nil = nil
  | init [x] = nil
  | init (x::xs) = x::init xs;
fun snoc a nil = [a]
  | snoc a (x::xs) = x::snoc a xs;
fun snoc a xs = rev(a::(rev xs));
fun snoc a xs = foldr op:: [a] xs;

(*25*)
fun posx' nil x i = NONE
  | posx' (y::ys) x i = if x=y then SOME i else posx' ys x (i+1);
fun posx xs x= posx' xs x 0;
fun posx xs x = #2(foldl(fn(i,(a,b)) => if i=x then (a+1,b) else (a+1,SOME a)) (0,NONE) xs);

(*26*)
fun undouble' _ a nil = a
  | undouble' compare a (x::xs) = if List.exists(fn i => compare(i,x)=EQUAL) xs then undouble' compare a xs else undouble' compare (x::a) xs;
fun undouble compare xs = undouble' compare nil xs;
undouble Int.compare [1,2,3,4,5,2,5];
fun undouble compare xs = foldl (fn(i,s)=> if List.exists (fn k => compare(k,i)=EQUAL)s then s else i::s) nil xs;
undouble Int.compare [1,2,3,4,5,2,5];

(*27*)
fun intPairCompare ((a1,a2),(b1,b2)) = 
    case Int.compare(a1,b1) of EQUAL => Int.compare (a2,b2) 
  | s => s;
intPairCompare((3,5),(3,4));
intPairCompare((3,4),(4,0));

(*28*)
fun listcmp compare (_,nil) = GREATER
  | listcmp compare (nil,_) = LESS
  | listcmp compare (nil,nil) = EQUAL
  | listcmp compare (x::xs,y::ys) = case compare(x,y) of EQUAL => listcmp compare(xs,ys) | s => s;

(*29*)
fun sdsorted compare nil = NONE
  | sdsorted compare [x] = NONE
  | sdsorted compare (x::y::ys) = case compare(x,y) of GREATER => sdsorted compare (y::ys) | _ => SOME(x,y);
sdsorted Int.compare [5,4,3,1,2];

(*30*)
fun oneMoreMax nil = 0
  | oneMoreMax [x] = 1+x
  | oneMoreMax (x::y::ys) = if x>y then oneMoreMax(x::ys) else oneMoreMax(y::ys);
oneMoreMax [3,2,8,4];
fun fill k l = iter l nil (fn s => k::s);
fill 3 4;
fun increment (n,xs) = rev(#1(foldl(fn(i,(s,a)) => if a=n then ((i+1)::s,a+1) else (i::s,a+1))(nil,0)xs));
increment (3,[4,2,6,3,2]);
fun encode xs = foldl (fn(i,s)=>increment(i,s)) (fill 0 (oneMoreMax xs)) xs;
encode [3,1,0,1,0,1];
fun decode xs = rev(#1(foldl (fn(i,(a,b)) => (iter i a (fn s => b::s),b+1)) (nil,0) xs));
decode [2,3,0,1];
fun countingSort xs = encode xs;

(*31*)
datatype zaun = Startpfahl of zaun
              | Latte of zaun
              | Endpfahl
              | Pfahl of zaun;

val ersterZaum = Startpfahl(Latte(Latte(Latte Endpfahl)));
val zweiterZaum = Latte(Latte(Latte Endpfahl));

fun num Endpfahl = 0
  | num (Latte zs) = 1+num zs
  | num (Startpfahl zs) = num zs;
num (Latte(Startpfahl(Latte(Latte Endpfahl))));

exception NoZaun;
fun zaunHelp n = if n=0 then Endpfahl else Pfahl(Latte(Latte(Latte(Latte(Latte (zaunHelp(n-5)))))));
fun zaunBauen 0 = raise NoZaun
  | zaunBauen n = if n mod 5 = 0 then zaunHelp n else raise NoZaun;

datatype farbe = Rot|Gruen|Blau|Gelb
datatype zaun' = Startpfahl' of zaun'
               | Latte' of (farbe*zaun')
               | Endpfahl';

fun colorCheck f (Startpfahl' zs) = colorCheck f zs
  | colorCheck f (Latte' (a,b)) = if a=f then 1+(colorCheck f b) else colorCheck f b
  | colorCheck f Endpfahl' = 0;
colorCheck Rot (Latte'(Rot,(Startpfahl'(Latte'(Blau,(Latte'(Rot,Endpfahl')))))));

fun sameColor zs = 
 let
  fun sameColor' (Startpfahl' zr) = sameColor' zr
    | sameColor' (Latte'(a,b)) = a::(sameColor' b)
    | sameColor' Endpfahl' = nil
in
  List.all(fn i => i = hd(sameColor' zs))(sameColor' zs)
end;
sameColor (Latte'(Rot,(Startpfahl'(Latte'(Blau,(Latte'(Rot,Endpfahl')))))));
sameColor (Latte'(Rot,(Startpfahl'(Latte'(Rot,(Latte'(Rot,Endpfahl')))))));

(*32*)
datatype formula = V of string
                 | C of bool
                 | N of formula
                 | D of (formula*formula)
                 | K of (formula*formula);
fun simplify (V a) = V a
  | simplify (C b) = C b
  | simplify (N f) = simplify f
  | simplify (D(f1,f2)) = (case (simplify f1,simplify f2) of (_,C true) => C true
     | (C true,_) => C true
     | (f,C false) => f
     | (C false,f) => f
     | (f1,f2) => D(f1,f2))
  | simplify (K(f1,f2)) = (case (simplify f1,simplify f2) of (_,C fasle) => C false
     | (C false,_) => C false
     | (f,C true) => f
     | (C true,f) => f
     | (f1,f2) => K(f1,f2));
type env = string -> bool;
fun free e (V a) = ((e a;true)handle Unbound=>false)
  | free e (C _) = true
  | free e (N f) = free e f
  | free e (D(f1,f2)) = free e f1 andalso free e f2
  | free e (K(f1,f2)) = free e f1 andalso free e f2;
fun eval e (V a) = e a
  | eval e (C b) = b
  | eval e (N f) = eval e f
  | eval e (D(f1,f2)) = eval e f1 orelse eval e f2
  | eval e (K(f1,f2)) = eval e f1 andalso eval e f2;