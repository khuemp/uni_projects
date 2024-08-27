(*E.1*);
fun separate xr = foldr (fn((x,y),s)=> (x::(#1 s),y::(#2 s))) (nil,nil) xr;
separate [(true,1),(false,42),(true,23)];

(*E.2*);
fun sortEvenOdd xr = foldl (fn(i,s) => if i mod 2 = 0 then [i]@s else s@[i]) nil xr
(*không dùng i::s vì không hoán vị được s và i*);
sortEvenOdd [1,2,5,3,7,3,9,6,8];

(*E.3 done*);

(*E.4*);
fun insert(x,nil) = [x]
  | insert(x,y::ys) = if x<=y then x::y::ys else y::insert(x,ys);
fun isort' xs = foldl insert nil xs;

(*E.5*);
fun comparePair compareA compareB ((a1,b1),(a2,b2)) = case compareA (a1,a2) of EQUAL => compareB (b1,b2)
                       | v => v;
comparePair Int.compare String.compare ((2,"foo"), (3,"bar"));
fun tripleCompare ((a1,b1,c1),(a2,b2,c2)) = 
case comparePair Int.compare String.compare ((a1,b1),(a2,b2)) of EQUAL => comparePair String.compare Real.compare ((b1,c1),(b2,c2))
          | w => w;
tripleCompare ((1,"x",2.0),(1,"x",3.0));

(*E.6b?*);
fun drop compare a nil = nil
  | drop compare a (x::xr) = 
case compare(a,x) of EQUAL => drop compare a xr
                   | _ => x::drop compare a xr;
drop Int.compare 1 [1,~5,2,~3,4,1,7];
fun min x = foldl(fn(i,s)=>if i>s then s else i) 0 x;
min [1,~5,2,~3,4,1,7];

(*E.7*);
fun sorted nil = true
  | sorted [x] = true
  | sorted (x::y::ys) = case Int.compare (x,y) of GREATER => false
  | _ => sorted (y::ys);
sorted [1,5,2,8];
sorted [1,2,3,4];

(*E.8*);
(*Mischen/merge/*);
fun merge _ (nil,ys) = ys
  | merge _ (xs,nil) = xs
  | merge compare (x::xr,y::yr) = case compare(x,y) of LESS => x::merge compare (xr,y::yr)
 | EQUAL => x::merge compare (xr,yr)
 | GREATER => y::merge compare (x::xr,yr);
fun split xs = foldl(fn(x,(ys,zs)) => (zs,x::ys))
(nil,nil) xs;
fun polymsort compare =
let 
  fun msort nil = nil
    | msort [x] = [x]
    | msort xs = 
       let val (ys,zs) = split xs
       in 
         merge compare (msort ys,msort zs)
       end
in 
  msort 
end;

(*E.9?*);
fun loveGen x y = foldl (fn(i,s)=> (x,i)::s) nil y;
loveGen "Infomatik" ["Khue","Minh","Pham"];

(*E.10*);
fun sortFil xs = foldl(fn(i,s)=>(List.filter (fn(d)=> d<i) s)@[i]@(List.filter (fn(e)=> e>=i) s)) nil xs;
sortFil [4,5,6,2,9];

(*E.11*);
fun lex compareA compareB ((a1,b1),(a2,b2)) = 
let
  val x = [a1,a2]
  val y = [b1,b2]
in 
  case compareA (a1,a2) of EQUAL => compareB (b1,b2)
                       | v => v
end;

(*E.12*);
fun insert(x,nil) = [x]
  | insert(x,y::ys) = if x<=y then x::y::ys else y::insert(x,ys);
fun isort xs = foldl insert nil xs;
fun perm xs ys = (isort xs)=(isort ys);
perm [1,2,3,4,5] [5,3,2,4,1];

(*E.14*);
datatype shape = Circle of real
               | Square of real
               | Triangle of real*real*real
               | Polygon of real*real;
fun iter n s f = if n<1.0 then s else iter n (f s) f;
fun edgeLength (Circle r) = 2.0*Math.pi*r
  | edgeLength (Square a) = a
  | edgeLength (Triangle(a,b,c)) = b
  | edgeLength (Polygon(n,x)) = x;
edgeLength (Circle 2.0);
fun scale i (Circle r) = Circle (r*i)
  | scale i (Square a) = Square (a*i)
  | scale i (Triangle(a,b,c)) = Triangle(a*i,b*i,c*i)
  | scale i (Polygon(n,x)) = Polygon (n,x*i);
scale 0.5 (Square 3.0);

(*E.15*);
datatype nat = O | S of nat;
fun rep 0 = O
  | rep x = S (rep (x-1));
rep 1;
fun num O = 1
  | num (S x) = 1 + num x;
num (S (S (S O)));
fun add x y = rep(num x+num y);
add (S(S O)) (S O);
fun mul x y = rep(num x*num y);
mul (S(S O)) (S O);
fun less x y = num x<num y;
less (S O) (S(S O));