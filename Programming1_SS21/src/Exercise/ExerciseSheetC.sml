(*C.1 in Drive*);

(*C.2*);
fun f(x:bool) = if x then 1 else 0;
val x = 5*7;
fun g(z:int) = f (z < x) < x;
val x = g 5;

(*C.3
a, richtig
b, falsch - Semantische Analyse: nicht wohlgetypt
c, falsch - Lexikalische Analyse: fum
d, falsch - Syntaktische Analyse: a+ *);

(*C.4*);
(*fak:= (fun fak n = if n < 1 then 1 else n*fak(n-1), int->int, [])*);

(*C.5?*);
(*a, Welche Umgebung liefert die Ausführung des Programms in der leeren Umgebung?/khi leer Umgebung thì Ausführung des Programms có những Umgebung nào?/
[]
[x:=5]
[f:=(fun f y = x+y,int->int,[x:=5])]*);

(*C.6 khi U và V bằng nhau hoặc tất cả Bezeichner trong V không có trong U*);

(*C.7? Wir bezeichnen zwei Phrasen als semantisch äquivalent, wenn sie sich in Bezug auf die statische und dynamische Semantik nach außen hin gleich verhalten. […] Die Semantik von Programmiersprachen ist in Bezug auf einen abstrakten Interpreter definiert, der keiner Speicherbeschränkung unterliegt. Weiter nehmen wir an, dass mit beliebig großen ganzen Zahlen gerechnet werden kann. Semantische Äquivalenz ist in Bezug auf diese idealisierte Semantik definiert.*);
(*nicht semantisch äquivalent*);
(*fun fac(x:int) = if x = 0 then 1 else fac(x-1);
fun b(p:int*int) = (#2 p, #1 p);
val it = b ( fac (~1) , fac 1);
Execution terminated due to time limit violation*);
(*fun fac(x:int) = if x = 0 then 1 else x*fac(x-1);
fun b(p:int*int) = p;
val it = b(fac 1, fac(~1));
Execution terminated due to time limit violation*);
(*semantisch äquivalent*);
(*val it = 111111111111 mod 1 giả sử hợp lý*);
val it = 111111 mod 1;

(*C.8*);
fun cas(f:int*int->int)(x:int)(y:int) = f(x,y);
fun car(f:int->int->int)(x:int,y:int)= f x y;

(*C.9*);
fn((),x:int)=>fn(())=>x;
fn(x:int,y:real,())=>fn(z:real)=>(x,z);
fn(x:int)=>fn(())=>fn(y:real)=>(x,x);

(*C.10*);
fun first(s:int)(p:int->bool):int = 
 if p s then s else first(s+1) p;
fun aufrundenBitte(a:int):int= first (a+1) (fn(x:int)=>x mod 10 = 0);
aufrundenBitte 12;
(*Die Prozedur selbst darf nicht rekursiv sein/aufrundenBitte không được rekursiv/*);

(*C.11*);
(*a,*);
fn(x:int)=>x*x;
fun s1(x:int)=
 let
  val a=x*x
in a
end;
(*b,*);
fn(x:int)=>(fn(y:int)=>x+y);
fun s2(x:int,y:int)=x+y;

(*C.12*);
fun iter (n:int) (s:int*int) (f:int*int->int*int) :int*int = if n<1 then s else iter(n-1)(f s) f;
fun add(n:int)(s:int*int):int = #2(iter n s (fn(i:int,a:int)=>if i mod 2 = 0 then (i+1,a+3) else (i+1,a+7)));
add 3 (0,2);
add 4 (0,3);

(*C.13?*);

(*C.14*);
fun iter(n:int)(s:int*int)(f:int*int->int*int):int*int = if n<1 then s else iter(n-1)(f s) f;
fun fib(n:int) = #2(iter(n:int)(1,0)(fn(a:int,i:int)=>(a+i,a)));
fib 4;
fib 6;

(*C.15?*);

(*C.16*);
fun first(s:int)(f:int->int)(p:int->bool):int = 
 if p s then s else first(f s) f p;

(*C.17*);
fun f a b c = c = (a = b) 
(*a:''a,b:''a,c:bool*);
fun f a b (c,d) = a(b,c(d a))
(*a:('a*'b→'c), b:'a, c:('d→'b), d:(('a*'b→'c)→'d)*);

(*C.18*);
fun f a = (fn b => (fn c => a b c) b) 
(*(fn b => (fn c => a b c) b) là thay b vào c*);
fun f a b c d = 
 let
  val x = (a 1)
  val y = b = d
in y
end;
fun f (a,b,c) = b;
fun f (a,b) c = 
 let 
  val x = b(a c)
in true
end;

(*C.19*);

(*C.20*);

(*C.21*);