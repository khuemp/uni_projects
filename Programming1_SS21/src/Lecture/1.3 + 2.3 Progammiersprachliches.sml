(*Endrekursion/tail recursive/: khi kết quả ở Rekursionsfall là nguyên function đó không nhân, cộng, trừ... bất cứ thứ gì. Vorteil là tiết kiệm bộ nhớ*);
(*zB: 
-endrekursiv:*);
fun w (k:int,n:int):int = if k*k>n then k else w(k+1,n);
(*-nicht endrekursiv:*);
fun potenz(x:int,n:int):int = if n>0 then x*potenz(x,n-1) else 1;
(*-> endrekursiv:*);
fun p(a:int,x:int,n:int) = if n>0 then p(a*x,x,n-1) else a
fun potenz'(x:int,n:int) = p(1,x,n);
potenz (2,3);
potenz'(2,3);

fun potenz_int(x:int,n:int):int = if n>0 then x*potenz_int(x,n-1) else 1;
potenz_int(2,30);
(*int k được nhưng real được*);
fun potenz_real(x:real,n:int):real = if n>0 then x*potenz_real(x,n-1) else 1.0;
potenz_real(2.0,30);

1.0000000000000001;(*Rundungfehler*)

fun newton(a:real,x:real,n:int):real = if n<1 then a else newton (0.5*(a+x/a), x, n-1);
fun sqrt(x:real) = newton(x/2.0,x,5); (*trong đó a=x/2*);
sqrt 2.0;

Math.pi;
Math.e;