(*B.1*);
val a = (1,1,1);
val b = (1,(true,(1,())));
val c = ((1,2),(3,4,5));

(*B.2*);
fun min_kartesischenArgumentmuster (x:int,y:int):int =  if x>y then y else x (*là (x:int,y:int)*);
min_kartesischenArgumentmuster (~1,2);
fun min_lokalenDeklaration (p:int*int):int = 
 let
  val (x,y) = p
in if x>y then y else x
end (*là val (x,y) = p*);
min_lokalenDeklaration (4,2);
fun min_Projektionen (p:int*int):int = 
 if #1 p > #2 p then #2 p else #1 p (*là #1p, #2p*);
min_Projektionen (6,~11);

(*B.3*);
fun f (n:int,a:int):int = if n = 0 then a else f(n-1, a*n);
(*a, f(3,1)->f(2,3)->f(1,6)->f(0,6)*);
(*b, 
f(3,1)
= if 3=0 then 1 else f(3-1,1*3)
= if false then 1 else f(3-1,1*3)
= f(3-1,1*3)
= f(2,1*3) !!!
= f(2,3)
= if 2=0 then 3 else f(2-1,3*2)
= if false then 3 else f(2-1,3*2)
= f(2-1,3*2)
= f(1,3*2) !!!
= f(1,6)
= if 1=0 then 6 else f(1-1,6*1)
= if false then 6 else f(1-1,6*1)
= f(1-1,6*1)
= f(0,6*1) !!!
= f(0,6)
= if 0=0 then 6 else (0-1,6*0)
= if true then 6 else (0-1,6*0)
= 6*);
(*c, f(3,1) = f(2,3) = f(1,6) = f(0,6) = 6*);
(*d, f(n,a) = f(n-1,a*n) = f(n-2,a*n*(n-1)) = f(n-3,a*n*(n-1)*(n-2))=...=a*n!*);

(*B.4*);
(*a,Rekursionsgleichung 
t1(x,a,b) = a+t1(x+1,a,b)*);
fun t1(x:int,a:int,b:int):int = if x<b then a+t1(x+1,a,b) else 0;
fun times1(a:int,b:int) = t1(0,a,b);
times1(3,4);
(*b, Rekursionsgleichung 
t2(n,a,b,x) = t2(t2'(n,a),a,b,x+1)*);
fun t2'(n:int,a:int) = n+a;
fun t2(n:int,a:int,b:int,x:int) = if x<b then t2(t2'(n,a),a,b,x+1) else n;
fun times2(a:int,b:int) = t2(0,a,b,0);
times2 (3,4);

(*B.5*);
(*a*)
(*Rekursionsgleichung:
quer x = quer (~x)
quer 0 = 0
quer x = (x mod 10) + quer [x/10]*);
34 div 10;
0 div 10;(*tự lấy giá trị nguyên < kết quả cao nhất*)
fun quer(x:int):int = 
 if x<0 then quer (~x) else 
  if x=0 then 0 else x mod 10 + quer(x div 10);
quer 902;
quer 3745;
(*b*)
fun q(n:int,x:int):int = 
 if x = 0 then n else q(n + x mod 10,x div 10);
fun quer'(x:int):int = 
 if x<0 then q(0,~x) else 
  if x=0 then 0 else q(0,x);
quer' 384;
quer' 902;
quer' 0

(*B.6?*);

(*B.7*);
fun potenz(a:int,b:int):int = if b>0 then a*potenz(a,b-1) else 1;
potenz (10,4);
fun c(n:int,x:int,d:int):int = if x = 0 then n else c(n + ((x+3) mod 10)*potenz(10,d),x div 10,d+1);
fun caeser (x:int):int = if x>0 then c(0,x,0) else if x = 0 then 3 else ~1*c(0,~x,0);
caeser ~987;
caeser 744;
caeser 67;
caeser 903;
caeser 0;

(*B.8?*);
(*fun p (n:int):int = if n = 0 then 0 else if n <= 2 then 1 else p(n-1)+p(n-2)
Rekusionsfolge: p 5 -> p 4 + p 3 -> p 3 + p 2 -> p 2 có 2 Rekursion*);

(*B.10*);
(*a,*);
fun teilbar(x:int,y:int) = if x mod y = 0 then true else false;
teilbar (9,3);
teilbar (9,4);
(*b,*);
fun teiler(x:int,y:int) = if x mod y = 0 then y else teiler (x,y+1);
teiler (19,4);
teiler (26,3);
(*c,*);
fun itsprim(x:int):bool = if teiler (x,2) = x then true else false;
itsprim 2;
itsprim 18;
itsprim 13;

(*B.9*);
fun nextprim(a:int) = if itsprim(a+1) = true then a+1 else nextprim(a+1);
nextprim 19;

(*B.11*);
(*a,*)
fun rev'(x:int,y:int) = if y = 0 then x else rev'(x*10 + y mod 10,y div 10);
rev' (65,73);
rev' (0,12300);
(*b,*);
fun rev(a:int) = rev'(0,a:int);
rev 1234;

(*B.12?*);
(*a,*);
fun fib(n:int) = if n = 0 then 0 else if n = 1 then 1 else fib(n-1)+fib(n-2);
fun tB(n:int,k:int) = if fib(k)>n then if fib(k) mod n = 0 then k else tB(n,k+1) else tB(n,k+1);
fun teilerFib(n:int):int = tB(n,1);
teilerFib 2;
teilerFib 3;
teilerFib 4;
teilerFib 5;
teilerFib 6;
teilerFib 7;
fib 9;
fib 8;
fib 7;
fib 6;
fib 5;
fib 4;
fib 3;
fib 2;
(*b,*);

(*B.13.in Drive*);

(*B.14.done*);

(*-------------------------------------------------*)

(*Korrektur Minitest 2
A.2 phải là 
fun genFak'(a:int,m:int,n:int) = if m<=n then a else genFak'(a*m,m+1,n)
fun genFak(m:int,n:int):int = genFak'(1,m,n)
và không có dấu ; *)