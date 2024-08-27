(*TB.1*);
(*a,*);
fun flatten1((a:int,b:int),c:int):int*int*int = (a,b,c);
flatten1((4,5),2);
(*b,*);
fun flatten2(f:(int*int)*int):int*int*int = 
 let 
  val a = #1 (#1 f)
  val b = #2 (#1 f)
  val c = #2 f
in (a,b,c)
end;
flatten2((4,5),2);
(*c,*);
fun flatten3(f:(int*int)*int):int*int*int = 
 (#1(#1 f),#2(#1 f),#2 f);
flatten3((4,5),2);

(*TB.2*);
(*a,*);
fun max1(x:int,y:int,z:int):int = if x>y then if x>z then x else z else if y>z then y else z;
max1(3,9,1);
(*b,*);
fun max2'(x:int,y:int) = if x>y then x else y;
fun max2(x:int,y:int,z:int) = max2'(x,max2'(y,z));
max2 (3,9,1);

(*TB.3*);
fun leapyear(x:int):bool = if x mod 4 = 0 then if x mod 100 = 0 then if x mod 400 = 0 then true else false else true else false;
leapyear 2400;
leapyear 2300;
leapyear 2020;

(*TB.4*);
(*a,*);
fun newton(a:real,x:real,n:int):real = if n<1 then a else newton (0.5*(a+x/a),x,n-1);
fun pq(p:real,q:real):(real*real) = 
if (p/2.0)*(p/2.0)<q then (0.0,0.0) else (~p/2.0+newton(((p/2.0)*(p/2.0)-q)/2.0,(p/2.0)*(p/2.0)-q,5),~p/2.0-newton(((p/2.0)*(p/2.0)-q)/2.0,(p/2.0)*(p/2.0)-q,5));
pq (0.0,~9.0);
(*b,*);

(*TB.5*);
(*a,*);
((1,2,3),(4,5),(1,3),(3,2),(9,4),(8,3),(2,8));
(*b,*);
(*int,bool,unit*);
(1,2,3);

(*TB.6*);
(*a, không có Baumdarstellung, 4 Komponenten, Länge=4*);
(((1,2,3)),1,2,3);
(*b,không có Baumdarstellung, 1 Komponenten, Länge=1*);
(((3)));
(*c, Baumdarstellung in Drive, 4 Komponenten, Länge=4*);
((),(1.0,(2,3)),false,42);
(*d,không có Baumdarstellung, 3 Komponenten, Länge=3*);
(3<4,1+2+3,(()));

(*TB.7*);
((),2,3,1.0,3>5);
(2.0,4,1);
(((3.0,1),()),((),7));
(4.0,5<6,9=1,3<3,5>3,2,0=1);
(((),(),((),())),());

(*TB.8*);
(*a,*);
val a = (3,(if false then 4 else ~1,(27,false)),((true,()),4));
#1 a;
#2 (#1 (#3 a));
#2 (#2 a);
#2 (#3 a);
(*b,*);
val b = (9>8,(7,(~1,2<3)),(),(1,4));
#1 b;
#3 b;
#2(#4 b);
#1(#2(#2 b));

(*TB.9*);
(4,2,42,false,());
((),(4,(2,42)),false);
(if true then 6 else ~5,3,(),true);
let
  val x = 1+2
  val y = true
in (x,(y),((),()),((())))
end;
let 
  fun f (x:int):bool = true 
  val a = if f 5 then 3 else 5 
  fun g(x:bool,y:int) = (f y,a)
in ((() ), g (true , 7) , f 5)
end;
let 
  fun f(a:int,b:int) = a div b
in f
end;

(*TB.10*);
fun gauss(n:int) = if n>0 then n+gauss(n-1) else 0;
gauss 5;
(*gauss 4->gauss 3->gauss 2->gauss 1->gauss 0*);

(*TB.11*);
fun foo(n:int) = if n = 0 then 1 else n*foo(n-1);
(*a,foo 2->foo 1->foo 0*);
(*b,
foo 2 
= if 2=0 then 1 else 2*foo(2-1)
= if false then 1 else 2*foo(2-1)
=2*foo(2-1)
=2*foo 1
=2*(if 1=0 then 1 else 1*foo(1-1)
=2*(if false then 1 else 1*foo(1-1)
=2*1*foo(1-1)
=2*1*foo 0
=2*1*(if 0=0 then 1 else 0*foo(0-1)
=2*1*(if true then 1 else 0*foo(0-1)
=2*1*1
=2*1
=2*);
(*c, foo 2 = 2*foo 1 = 2*1*foo 0 = 2*1*1 = 2*);
(*d,n!*);

(*TB.12 done*);

(*TB.13 weil (x div 2)+2 immer > 0 *);

(*TB.14*);
(*a,*);
fun md(x:int,y:int,k:int) = if k*y<=x then md(x,y,k+1) else k-1;
fun mydiv(x:int,y:int):int = md(x,y,0);
mydiv (12,3);
mydiv (10,3);
(*b,*);
fun mydiv'(x:int,y:int) = if x<0 then if y<0 then mydiv(~x,~y) else ~1*mydiv(~x,y) else if y<0 then ~1*mydiv(x,~y) else mydiv(x,y);
mydiv' (0,3);
mydiv' (~9,3);
mydiv' (9,~3);

(*TB.15*);
(*a,*);
fun potenz(b:int,x:int):int = if x>0 then b*potenz(b,x-1) else 1;
potenz(10,4);
(*b,*);
fun l(x:int,y:int) = if x mod 10 = 0 then y else l(x div 10,y+1);
fun length(x:int) = if x = 0 then 1 else l(x,0);
length 15;
length 01234;
length 0;
(*c,*);
fun concat(x:int,y:int) = if y = 0 then x*10 else if x = 0 then y else x*potenz(10,length x)+y;
concat (1337,0);
concat (0,42);
concat (012,034);
concat (023,0089);

(*TB.16*);
(*a, die Zweite
b,done
c,done
d,done*);

(*TB.17*);
fun mul((a:int,b:int),x:int):int = if a=0 then x else mul((a-1,b),x+b);
mul ((3,4),0);

(*TB.18*);
fun max(x:int,y:int) = if x>y then x else y;
fun abs(x:int) = if x>0 then x else ~x;
fun gZ(a:int,b:int) = if a div 10 =0 then b else gZ(a div 10,max(a mod 10,b));
fun grossteZiffer(a:int) = gZ(abs a,0);
grossteZiffer 12392;
grossteZiffer ~13;

(*TB.19,a,b,e,g,h,i*);

(*TB.20 done*);

(*TB.21*);
(*a, f(g(3+5))
b,int->(int->unit)
c, f(a,4-g(3),b)+3
d, fun p(x:int,n:int):int = if n>0 then x*p(x,n-1) else 1*);

(*TB.22 in Drive*);

(*TB.23?d in Drive*);