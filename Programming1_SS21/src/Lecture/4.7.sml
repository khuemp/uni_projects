fun append(xs,ys) = if null xs then ys else hd xs::append(tl xs,ys);
append([1,2,3],[4,5]);
fun append'(xs,ys) = if xs=nil then ys else hd xs::append(tl xs,ys);
append'([1,2,3],[4,5]);

fun nth(xs,n) = if n<0 orelse null xs then raise Subscript else if n=0 then hd xs else nth(tl xs,n-1);
nth([7,8,9],2);
nth([1,2,3],0);
nth([4,5,6],3);
(*Nummerierung beginnt bei 0!*);
val x = 2;
List.nth([1,2,3],x);

fun append(nil,ys) = ys
  | append(x::xr,ys) = x::append(xr,ys);
append ([1,2,3],[4,5]);

fun length nil = 0
  | length (x::xr) = 1+length xr;
length [1,6,5,3];

fun concat nil = nil
  | concat (x::xr) = x @ concat xr;
concat [[1,2,3],[4,5,6,7]];

fun rev nil=nil
  | rev(x::xr) = rev xr @ [x];
rev [1,2,3];

fun 'a iterdn(n:int)(m:int)(s:'a)(f:int*'a->'a):'a = 
 if n<m then s else iterdn (n-1) m (f(n,s)) f;
fun tabulate(n,f) = iterdn (n-1) 0 nil (fn(i,xs)=>f i::xs);
tabulate(3,fn x=>x*x);
tabulate(3,fn x=>x>1);
List.tabulate(3,fn x=>x*x);
List.tabulate(3,fn x=>x>1);

fun map f nil = nil
  | map f(x::xr) = (f x)::(map f xr);
map (fn x => x>4)[6,2,5];
map (fn f => f 10)[fn x => x+1,fn y => y-1,fn z => z*2];

fun filter f nil = nil
  | filter f (x::xr) = if f x then x::filter f xr else filter f xr;
filter (fn x => x<0)[0,~1,2,~3];
filter (fn x => x>=0)[0,~1,2,~3];

fun exists f nil = false
  | exists f (x::xr) = f x orelse exists f xr;
exists (fn x => x>0)[~1,1,4];
exists (fn x => x>0)[~1,~3,~4];
List.exists (fn x => x<3)[3,4,5];

fun all f nil = true
  | all f (x::xr) = f x andalso all f xr;
all (fn x => x>0)[~1,1,4];
all (fn x => x>0)[1,3,4];
List.all (fn x => x>=3)[3,4,5];

(*nicht erschöpfend-WARN: Pattern matching is not exhaustive.*);
fun test nil = 0
  | test [_] = 1;
fun pairs(x::y::xs) = (x,y)::pairs xs
  | pairs nil = nil (*zB: pairs [1]*);
(*erschöpfend*);
exception SomethingWrong
fun test nil = 0
  | test [_] = 1
  | test _ = raise SomethingWrong;
test [1,2];

fun foldl f s nil = nil
  | foldl f s (x::xr) = foldl f (f(x,s)) xr;

fun rev xs = foldl op:: nil xs;
fun lenghth xs = foldl (fn(x,n)=>n+1) 0 xs;