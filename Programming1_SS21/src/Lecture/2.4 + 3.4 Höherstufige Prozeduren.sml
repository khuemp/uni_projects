fun p (x:int) = x;
fun q (x:int) = p x;
fun p (x:int) = 2*x;
val a = (p 5, q 5);
(*tại vì q được xác định dựa vào p đứng trước, sau đó p bị viết đè*);

val x = 99999999
val y = 99999998
val z = (x-y)*(x-y);
val z' = x*x-2*x*y+y*y;

(*------------------------------------------------*);

(*thay vì*);
fun f(x:int,y:int) : int = x*y;
f (7,2);
(*ta viết thành Abstraktion*);
(fn(x:int,y:int) => x*y) (7,2);