fun split xs = foldl(fn(x,(ys,zs)) => (zs,x::ys))
(nil,nil) xs;
fun merge(nil,ys) = ys
 | merge(xs,nil) = xs
 | merge(x::xr,y::yr) = if x<=y then x::merge(xr,y::yr) else y::merge(x::xr,yr);
merge ([2,5],[3,8]);
merge ([1,3],[3,2]);
fun msort [] = []
  | msort [x] = [x]
  | msort xs = 
let 
  val (ys,zs) = split xs
in 
  merge(msort ys, msort zs) 
end;
msort [2,8,5,3];
msort [1,3,3,2];

fun sinsert (x,nil) = [x]
  | sinsert (x,y::yr) = case Int.compare(x,y) of
                      LESS => x::y::yr
                    | EQUAL => y::yr
                    | _ => y::sinsert(x,yr);
val issort = foldl sinsert nil;
issort [3,2,7];

fun diff nil ys = nil
  | diff xs nil = xs 
  | diff (x::xr) (y::yr) = case Int.compare(x,y) of                 LESS => x :: diff xr (y::yr) 
            | GREATER => diff (x::xr) yr
            | EQUAL => diff xr yr;
diff [1,2,4] [1,3,4];

fun union nil ys = ys
  | union xs nil = xs 
  | union (x::xr) (y::yr) = case Int.compare(x,y) of               LESS => x :: union xr (y::yr) 
            | GREATER => y :: union (x::xr) yr
            | EQUAL => union xr (y::yr);
union [1,2,4] [1,3,4];

datatype shape = Circle of int
               | Square of int
               | Triangle of int*int*int;
Circle 5 = Square 2;


datatype shape = Circle of real
               | Square of real
               | Triangle of real*real*real;
(*Circle 5.0 = Square 2.0 không được*);

fun area (Circle r) = Math.pi*r*r
  | area (Square a) = a*a
  | area (Triangle(a,b,c)) = 
    let 
      val s = (a+b+c)/2.0
    in 
      Math.sqrt(s*(s-a)*(s-b)*(s-c))
    end;
area (Square 3.0);
area (Triangle (6.0,6.0,Math.sqrt 72.0));

(*exp:expression, var:variable, env: environment*);