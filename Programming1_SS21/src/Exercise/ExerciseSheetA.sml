(*A.4*);
(*Bezeichner: x,y,z
Konstante: 7,4,1,2
Operatoren: +,*,-
Schlüsselwörter: val,=,(,)
Bindungen: x=11, y=110, z=1188*)

val x = 7+4
val y = x*(x-1)
val z = x*(y-2);

(*A.5*);
(*a. int ist ein Schlüsselwörter, weil sie dienen dazu, den Aufbau eines Programms
b. nein*)

(*A.6*);
fun hochv1 (x:int) : int = 
 let 
  val a = x*x
  val b = a*a
 in a*b
end;
hochv1 2;

fun hochv2 (x:int) : int =
 let 
  val a = x*x*x
in a*a
end; 
hochv2 2;

(*A.7*);
fun neg (x:int) : int = if x>0 then ~1*x else x;
neg ~1;
neg 999;
neg 0;

(*A.8*);
(*-Abbruch wegen Laufzeitfehler: Eine Operation
signalisiert einen Fehler.
-Abbruch wegen Speichererschöpfung: Der dem
Interpreter zur Verfügung stehende Speicherplatz ist
erschöpft.
-Abbruch durch den Benutzer: Die noch laufende
Ausführung des Programms wird durch den Benutzer
abgebrochen.*);

(*A.9*);
(*-Funktionale Programmierung ist ein Programmierparadigma /mô hình lập trình/, innerhalb dessen Funktionen nicht nur definiert und angewendet werden können, sondern auch wie Daten miteinander verknüpft, als Parameter /tham số/ verwendet und als Funktionsergebnisse auftreten können.
-funktionale, imperative, objektorientierte, deklarative, logische, nebenläufige Programmiersprachen*);

(*A.10*);
(*-Bezeichner: a, b (weil sie bei der Ausführung eines Programms an Werte gebunden werden)
-Konstanten: 5, 6, 0, 8 (weil sie Wörter sind, die bestimmte Werte bezeichnen)
-Operatoren: +, -, * (weil sie Wörter sind, die Operationen darstellen)
-Schlüsselwörter: void, main, (, ), {, },  decision, if, int, =, else (weil sie dienen dazu, den Aufbau eines Programms)*);

(*-------------------------------------------------*)

(*Korrektur Minitest 1
A.1 khi hỏi val thì dùng -9 không dùng ~9
A.2
a, triple/verdreifach: *3, không cần thêm điều kiện cho positive
b, Rumpf bao gồm cả dấu ngoặc của(x:int)*)