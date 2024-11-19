(*TD.1 in Drive**);

(*TD.2 in Drive*);

(*TD.3**);
nil;
1::2::3::nil(*nếu [1,2,3,[]] thì sẽ thành 'a list list*);
1::[2]@[3]@nil;
([1]@[2])::nil(*int list@int list list*);
nil::nil::nil (*'a::'a list::'a*);
nil@nil@nil;

(*TD.4*);
nil;
nil::nil;
(nil::nil)::nil(*('a::'a list)::a'list.list*);
(*(1::nil)::((1::nil)::nil)::nil nicht wohlgetypt*);
nil::nil@nil;
(nil::nil)::(nil::nil);
nil@(nil::nil)(*'a@'a*);

(*TD.5*);
fun howmany nil = 0
  | howmany ((0,_)::xs) = 1+(howmany xs)
  | howmany ((_,0)::xs) = 1+(howmany xs)
  | howmany ((0,0)::xs) = 2+(howmany xs)
  | howmany (_::xs) = howmany xs;
howmany [(1,2),(0,0),(0,9)];

(*TD.6*);
(*a,*);
fun enumerate m n = if m>n then [] else m::enumerate (m+1) n;
(*b,*);
fun rangeStepsize m n t = List.filter (fn x =>(x-m) mod t = 0) (enumerate m n);
rangeStepsize 2 8 3;

(*TD.7?*);

(*TD.8?*);

(*TD.9* done*);

(*TD.10**);
fun double (x::xs)(y::ys) = (x,y)::(double xs ys)
  | double nil (y::ys) = raise Subscript
  | double (x::xs) nil = raise Subscript
  | double nil nil = nil;
double [2,3] [true,false];
fun doublemap f a b = map f (double a b);
doublemap (fn (m,n) => m*n) [1,2] [5,2];
doublemap (fn (m,n) => m*n) [1,2] [5,2,3];

(*TD.11*);
fun prod a b = foldl op+ 0 (doublemap (fn (m,n) => m*n) a b);
prod [3,2,7] [1,6,2];

(*TD.12**);
fun foldmap f nil = nil
  | foldmap f x = foldr (fn (i,s) => (f i)::s) nil x;
foldmap (fn x => x div 2) [2, 5, 6, 9];

(*TD.13 done*);

(*TD.14**);
fun split n x = (foldr (fn (i,s) => if i<n then i::s else s) nil x, (foldr (fn (i,s) => if i>=n then i::s else s) nil x));
split 6 [7, 3, 6, 5, 4, 10, 1, 2, 9, 8];

(*TD.15* done*);

(*TD.16?*);

(*TD.17*);
fun howMany_a nil f = 0
  | howMany_a (x::xr) f = if f x then 1+(howMany_a xr f) else howMany_a xr f;
howMany_a [1,2,3,4,2,8](fn i => i mod 2 = 0);
fun howMany_b x f = List.length(List.filter f x);
howMany_b [1,2,3,4,2,8](fn i => i mod 2 = 0);
fun howMany_c x f = List.length(foldr (fn (y,ys) => if f y then y::ys else ys) nil x);
howMany_c [1,2,3,4,2,8](fn i => i mod 2 = 0);

(*TD.18?*);

(*TD.19*);
fun apply f nil = nil
  | apply f [x] = nil
  | apply f [x,y] = f(x,y)::nil
  | apply f (x::y::ys) = f(x,y)::apply f (y::ys);
apply op+ [2,3,4];

(*TD.25**);