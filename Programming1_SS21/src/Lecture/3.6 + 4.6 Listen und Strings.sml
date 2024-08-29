(*val x = fn y => (fn y => (fn x => z x y) x) y
In dieser Phrase treten die Bezeichner x und z frei auf. Außerdem gibt es 2 definierende Auftreten des Bezeichners x*);

fun forall m n p = m>n orelse (p m andalso forall (m+1) n p);
fun forall' m n p = if m>n then true else (if p m then forall'(m+1) n p else false);
forall 5 7 (fn(x:int)=>x>0);
forall ~5 7 (fn(x:int)=>x>0);

(*fun f x y = if x then y else false không tương đương với e1 andalso e2*);
fun f x y = if x then y else false;
f true true;
fun g x = g x;
false andalso (g true);
(*f false (g true) tương đương cái trên nhưng lỗi Execution terminated due to time limit violation*);

fun plus x y = x+y;
fun times x y = x*y;
val foo = (plus 2) o (times 3);
foo 7;
7*3+2;

[(1,2),(3,4)];
[[1,2,3],[1]];
[[]];
[1,2,3]@[4,5,6]@[7,8,9];
1::2::3::nil;
1::(2::(3::nil));
1::[2,3];
(*mỗi List đều có nil nhưng Tupel thì không*);
val a = [1,2,3]@[4,5,6]@[7,8,9];
null a;
hd a;
tl a;

(1::2)::3;