(*TC.1*);
(*a,geschlossen vì test2 của res2 tính theo x trên nên k ảnh hưởng khi thay đổi giá trị x*);
val x = 5;
val a = 7;
fun test1 () = a+x;
fun test2 (a:int) = a+x;
val res1 = (test1(),test2(2));
val x = 4;
val res2 = (test1(),test2(2));
(*b,frei Bezeichner x von res 2 /vì bị ảnh hưởng bởi x câu a nên bằng 4/*);
fun test () : int =
 let
   val x = 5 
in 3
end;
val res1 = test ();
val res2 = x;
(*c,geschlossen vì test của res2 tính theo x trên nên k ảnh hưởng khi thay đổi giá trị x*);
val a = 3;
fun test(x:int) = if x > 0 then a*x else 0;
val res1 = test(5);
val a = ~3;
val res2 = test(2);
(*d,frei Bezeichner y vì là val nên phải là một số*);
(*fun test1(a:int) = if a>0 then a*a else ~(a*a);
fun test1(y:int) = 4*y+5;
val res1 = test1(3y);
val x = ~3;
val res2 = test2(2x);*);

(*TC.2*);
(*fun double x = if x>0 then 2+double(x−1) else 0,int->int,[]*);
(*fun fak n = if n<1 then 1 else n*fak(n−1),int->int,[]*);
(*fn b => if b then x else 7,bool->int,[x:=5]*);

(*TC.3*);
(*a,*);
fun q(n:int):int = if n=0 then 0 else n mod 2 + q(n div 2);
q 9;
(*b,*);
fun add(x:int,y:int):int = (fn(n:int) => if x=n then y else add(x-1,y+1)) 0;
add (3,4);
(*c,*);
fun f(n:int):int = 2*n;
fun c(z:int):int = 10*f(z div 10)+f(z mod 10);

(*TC.4 in Drive/d sai xem chữa/*);

(*TC.5*);
val a = fn x => 1;
(*val b = fun f x = 1
Expected atomic expression, "fun" found*);
val c = 
 let 
  val x = fn q => 2 
in x 
end;
val d = 
 let 
  fun x q = 2 
in x 
end;
val f = (fn g => g 5) (fn x => x+4)
(*thay g bằng phương trình (fn x => x+4)*);
(*val g = (fn x = x) 5
Expected "=>" but got "="*);
(*val i = (fun x => x) 42
Expected atomic expression, "fun" found*);

(*TC.6*);
(*-kaskadierten Prozeduren: die Prozeduren als Ergebnis liefern
fun mul(x:int) = /fn(y:int) => x*y/*);
(*-höherstufigen Prozeduren: eines ihrer Argumente eine Prozedur ist
fun sum /(f:int->int)/(n:int):int = if n<1 then 0 else sum f(n-1)+f n*);

(*TC.7*);
val q = fn x => x*x;
q 3;
val add = fn (x,y) => x+y;
add (3,4);
val add' = fn x => fn y => x+y;
add' 3 4;

(*TC.8*);
fun psum (p:int->bool)(m:int)(n:int):int = if p m then n else psum p (m+1) (n+m);
psum (fn(i:int)=>i=5) 2 5;

(*TC.9?*);

(*TC.10*);
fun add(x:int)(y:int) = x+y;
val addme = add 3;
val i = addme 5;
val j = addme 4;
val addmetoo = add 7;
val k = addmetoo 5;

(*TC.11*);
fun iter(n:int)(s:int)(f:int->int) = 
 if n<1 then s else iter(n-1)(f s) f;
fun add(n:int)(m:int) = iter n m (fn(i:int)=>i+1);
add 3 4;
fun mul(x:int)(y:int) = iter x 0 (add y);
mul 3 9;
fun pot(a:int)(b:int) = iter a 1 (mul b);
pot 2 10;

(*TC.12?*);

(*TC.13?*);
fun limitedFirst(p:int->bool)(m:int) = if p m then m else limitedFirst p (m-1);
limitedFirst(fn(i:int)=>i<5) 5;
(*TC.14?*);

(*TC.15 
ist Instanz von: từ * sang ->
alle Instanzen sind auch Instanzen von: từ -> sang -> *);

(*TC.16 làm như bình thường sau đó thay typ đaauf tiên của a là 'a*);
fun f x = x;
fun f x y = x;
fun f a b = a b b;
fun f a b c = a b c;
fun f a b c = a (b c);
fun f g s n = if n = 0 then s else f g (g s) (n-1);
(*fun y a (b : real ) c = if c then b else 3 
nicht wohlgetypt*);
fun f (a,b,c) d = if c then (a+4)=b else d(true);

(*TC.17*);
fun f a b = (a,b);
fun f a b c = a;
fun f a b c = a c (b c);
fun f a b c = if a=a then b a else c;

(*TC.18*);
fn (a:int->bool->real) => fn (b:int) => fn (c:bool) => a b c;
fn (a:int->bool) => fn (b:bool->real) => fn (c:int) => b (a c);

(*TC.19*);
fun sharp3(p:'a*'b*'c) = 
 let 
  val (a,b,c) = p
in c
end;

(*TC.20*);
fun fortytwo f p s = if p s then fortytwo f p (f s) else s;
fun f x y z = x z (y z);
fun f a (b, c) d = a (b (c d) c a);
(*fun f x = x f
My brain trembles; too much circularity*);
fun f a (b, c) d (e, f) = a (f e) ((a b) (c d));
fun f a (b, c) = (a b, a c, a b c);

(*TC.21*);
fun Y f x = f (Y f) x;