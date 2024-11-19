fn(x:int) => x*x;
it 7;
(fn(x:int) =>x*x) 7;

fun f(x:int) = fn(y:int) => fn(z:int) =>x+y+z;

fun mul(x:int) = fn(y:int) => x*y;
mul 7;
it 3;
mul 3 7;

fun sum (f:int->int) (n:int) : int =
 if n<1 then 0 else sum f(n-1) +f(n);
sum (fn(i:int)=>i) 100;
sum (fn(i:int)=>i*i) 10;

fun iter (n:int) (s:int) (f:int->int) : int =
 if n=0 then s else iter (n-1) (f s) f;
fun power (x:int) (n:int) = 
 iter n 1 (fn(a:int)=>a*x);
power 2 10;

fun first (s:int) (p:int->bool) : int = 
 if p s then s else first (s+1) p;
fun sqrt (x:int) = first 1 (fn(k:int)=>k*k>x)-1;
sqrt 5;

fun iter' (n:int) (s:int*int) (f:int*int->int*int) : int*int = 
 if n<1 then s else iter'(n-1) (f s) f;
fun gauss(n:int) = #2(iter' n (1,0) (fn(i:int,a:int)=>(i+1,a+i)));
gauss 4;

fun iter''(n:int) (s:bool) (f:bool->bool) : bool = 
 if n<1 then s else iter''(n-1) (f s) f;
fun inv(b:bool) = not b;
fun even(x:int) = iter'' x true inv;
even 4;
even 3;

fun 'a iter (n:int) (s:'a) (f:'a->'a) : 'a = 
 if n<1 then s else iter(n-1) (f s) f;
fun power (x:int) (n:int) = iter n 1 (fn(a:int)=>a*x);
power 2 10;
fun power' (x:real) (n:int) = iter n 1.0 (fn(a:real)=>a*x);
power' 2.0 10;
fun gauss(n:int)= #2 (iter n (1,0) (fn(i:int,a:int)=>(i+1,a+i)));
gauss 4;

fun ('a,'b) project2 (x:'a,y:'b) = y;
project2 (1,2);
project2 (1,2.0);
project2 (1,true);

fun 'a iterup (m:int) (n:int) (s:'a) (f:int*'a->'a) = 
 if m>n then s else iterup (m+1) n (f(m,s)) f;
fun gauss(n:int) = iterup 1 n 0 (fn(i:int,a:int)=>i+a);
gauss 4;

fun 'a iterdn (n:int) (m:int) (s:'a) (f:int*'a->'a) = 
 if m>n then s else iterdn (n-1) m (f(n,s)) f;

(*Typinferenz:tự xác định được Typ*);

fun 'a iter (n:int) (s:'a) (f:'a->'a) : 'a = 
 if n<1 then s else iter(n-1) (f s) f;
fun iter n s f = if n<1 then s else iter (n-1) (f s) f;
fun 'a iter n s f = if n<1 then (s:real) else iter (n-1) (f s) f;

fun plus x y = x+y;
fun plus (x:real) y =x+y;
fun plus x y : real = x+y;

fun eq x y = x = y;
fun neq x y = x <> y;
fun f(x,y,z) = if x=y then x else z;
(*(fn x => 2*x) = (fn x=> 2*x) bị type crash*);

val id = fn x => x;
val x = id id;
x 5.0;
x 5;