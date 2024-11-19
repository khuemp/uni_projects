3<3;
3<=3;
if 4<5 then 7*2 else 2*2;
if 6<5 then 7*2 else 2*2;


fun betrag (x:int) = if x<0 then ~1*x else x;
betrag ~45;

fun hoch8 (x:int) = 
 let 
  val a = x*x
  val b = a*a
 in 
  b*b
 end;
hoch8 2;


(7,2,true,2);
(*true, false thuộc bool*)
(*4 Positionen are 7,2,true,2 and 3 Komponenten are 7,2,true*);

((1,2),(3,4));

(*Projektion aus Tupeln: #*);
val x = (5-2, 1>3, 4*3);
#3 x;
#2 x;
#2 (4-5, 4>1, 8*2);


val (x,y) = (3,4);
val (x,y) = (y,x);
fun swap (x:int,y:int) = (y,x);
swap (9,4);
fun p (x:int*int) = (#2 x,#1 x);
p (7,3);

(*Rekursion: In computer science, recursion is a method of solving a problem where the solution depends on solutions to smaller instances of the same problem*);

fun potenz (x:int,n:int) : int = 
 if n>0 then x*potenz(x,n-1) else 1;
potenz (4,3);

fun g (x:int) : int = if (x<0) then 0 else g(x+1);
g (~1);
g (2) (*Divergenz: lag a few minutes and can not give the output >< Terminierung: the progress gives the output sucessfully/error*)
