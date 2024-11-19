(*TA.1*);
(*-Bezeichner: x, p
-Schlüsselwörter: fun, bool, if, then, else, int, val, (, ), =, :
-Operationen: -, =
-Konstanten: ~1, 3, 2, 0*)
(*~ đứng trước () hoặc Bezeichner thì là Operator, k thì ~1 thuộc Konstant*)
(* * có thể là Schlüsselwort khi int*int*);

(*TA.2*);
(*a.
-Bezeichner: x, y
dienen als Namen, die bei der Ausführung eines Programms an Werte gebunden werden.
-Konstanten: 3,4,7,29
sind Wörter, die bestimmte Werte bezeichnen.
-Operatoren: +, -, *
sind Wörter, die Operationen darstellen.
-Schlüsselwörter val, =, (, )
dienen dazu, den Aufbau eines Programms darzustellen.
b. already know*);

(*TA.3*);
(*a.
Bezeichner: x, y, z, foo
Konstanten: 1337, 42, 5, ~7, 3, true, false
Operatoren: +, -, <, =
Schlüsselwörter: val, =, (, ), if, then, else*)
(*<,> và = trong x=0 là Operator vì nó kết nối 2 giá trị, nhưng = trong val x = 0 là Schlüsselwort*)
(*b.*)
val x = (1337+42)
val y = 3 = 5
val z = if y then x else x-3
val foo = if x < ~7 then true else false;

(*TA.4*);
(*a.
Bezeichner: a, x, b, c, foo, y, z
Konstanten: 0, 17, ~21, 3
Operatoren: ~, -, +, <
Schlüsselwörter: fun, int, (, ), =, if, then, else, val, :, ,
b*)
fun a (x:int) : int = if x < 0 then ~x else x;
val b = 17
val c = ~21;
fun foo (y:int,z:int) : int = y - 3 + a z;
val c = foo (b,c);

(*TA.5*);
(*a.
-Funktionen sind mathematische Objekte. Sie gibt an, wie ihre Argumente dem Ausgabewert zugeordnet werden. Sie geben keine konkrete Berechnungsvorschrift vor.
-Prozeduren wiederum sind direkte, eindeutige Berechnungsvorschriften. Sie berechnen eine bestimmte
Funktion und sind in der Regel in einer Programmiersprache geschrieben.
b.
Prozenduren: ii, iv, v
Funktionen: i, iii, vi*)

(*TA.6*);
fun f(x:int):int = x*x;
fun g(x:int):int = x*x*x*x*x+3*x*x*x+x+7;

(*TA.7*);
fun hoch17_LokaleDeklarationen(x:int):int =
 let 
  val a = x*x
  val b = a*a
  val c = b*b
  val d = c*c
in d*x
end;
hoch17_LokaleDeklarationen 2;
fun q(x:int) = x*x
fun hoch17_Hilfsprozedur(x:int) = q(q(q(q x)))*x;
hoch17_Hilfsprozedur 2;

(*TA.8*);
(*a.*)
fun modulo(x:int,y:int):int = x-(x div y)*y;
modulo(11,3);
(*b*)
fun moduloComp((x:int,y:int),(a:int,b:int)):bool= modulo(x,y) = modulo(a,b);
moduloComp((11,3),(18,4));
moduloComp((11,3),(19,4));