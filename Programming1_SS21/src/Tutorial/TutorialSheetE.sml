(*TE.1**);
fun is1 a = if a mod 10 = 1 then true else if a div 10 <> 0 then is1 (a div 10) else false;
fun noOne x = foldr (fn(i,s)=> if is1 i then s else i::s) nil x;
noOne [1,22,11,353,201];

(*TE.2**);
fun interval x n m = if x>=n then if x<=m then true else false else false;
interval 3 1 8;
interval 5 6 9;
fun inSum xs n m = foldl (fn(i,s)=> if interval i n m then i+s else s) 0 xs;
inSum [11,2,18,4,5,24,8,12] 1 10;

(*TE.3?**);

(*TE.4?*);
exception Unbound;
fun fruitVal "Birne" = "A"
  | fruitVal "Apfel" = "B"
  | fruitVal _ = raise Unbound;
fun fruitcompare x y = String.compare (fruitVal x, fruitVal y) handle Unbound => EQUAL;
fruitcompare "Banane" "Banane";
fruitcompare "Minh" "Khue";
fruitcompare "Birne" "Apfel";

(*TE.5*);
fun cmpinvert compare (x,y) = 
let 
  val a = [x,y]
in 
  case compare(y,x) of GREATER => compare(y,x)
                      | _ => compare(y,x)
end;
cmpinvert Int.compare (3,4);

(*TE.6**);
fun listcmp compare = 
let 
  fun cmp nil nil = EQUAL
    | cmp nil _ = LESS
    | cmp _ nil = GREATER
    | cmp (x::xs) (y::ys) = 
  let 
    val z =[x,y]
  in 
    if compare(x,y) = EQUAL then cmp xs ys else compare(x,y)
  end
in 
  cmp
end;
listcmp String.compare ["Pham","Minh","Khue"] ["Pham","Minh","Khue","Erm"];

(*TE.7**);

(*TE.8**);

(*TE.9*);
fun upwards c last nil ys = (c,last::ys)
  | upwards c last (x::xs) ys = if last>x then upwards (c+1) last xs (x::ys) else upwards c x xs (last::ys);
upwards 0 3 [2,5,6,1] nil;
fun downwards c last nil ys = (c,last::ys)
  | downwards c last (x::xs) ys = if last<x then upwards (c+1) last xs (x::ys) else upwards c x xs (last::ys);
downwards 0 3 [2,5,6,1] nil;

(*TE.10**);
exception empty;
fun last nil = raise empty
  | last x = 
let 
  val y::_ = rev x
in y
end;
last [1,2,3];
last [];
fun removeLast nil = raise empty
  | removeLast x = List.filter (fn(i)=> i<>(last x)) x;
removeLast [1,2,3];
removeLast [];
fun split xs = foldl (fn (x,(ys,zs)) => (zs,x::ys))
(nil,nil) xs;
split [1,2,3,4,5,6];
fun insert(x,nil) = [x]
  | insert(x,y::ys) = if x<=y then x::y::ys else y::insert(x,ys);
fun isort xs = foldl insert nil xs;

(*TE.11*);
datatype shape = Wurzel of real
               | Kugel of real
               | Zylinder of real*real
               | Prisma of (real*real*real)*real;
fun area (Wurzel a) = 6.0*a*a
  | area (Kugel r) = 4.0*Math.pi*r*r
  | area (Zylinder(r,h)) = 2.0*Math.pi*r*(r+h)
  | area (Prisma((a,b,c),h)) = 
let 
  val s = (a+b+c)/2.0
in 
  2.0*Math.sqrt(s*(s-a)*(s-b)*(s-c))+h*(a+b+c)
end;
fun volume (Wurzel a) = a*a*a
  | volume (Kugel r) = 0.75*Math.pi*r*r*r
  | volume (Zylinder(r,h)) = Math.pi*r*r*h
  | volume (Prisma((a,b,c),h)) = 
let 
  val s = (a+b+c)/2.0
in 
  Math.sqrt(s*(s-a)*(s-b)*(s-c))*h
end;
fun cmparea x y = Real.compare(area x,area y);
fun cmpvol x y = Real.compare(volume x,volume y);

(*TE.12*);
datatype Lang = PHP 
              | C 
              | Go
              | Java
              | CSCHARF 
              | Brainfuck
              | Haskell
              | Oz 
              | Alice
              | StandardML;
fun lang PHP = 1
  | lang C = 2
  | lang Go = 3
  | lang Java = 4
  | lang CSCHARF = 5
  | lang Brainfuck = 6
  | lang Haskell = 7
  | lang Oz = 8
  | lang Alice = 8
  | lang StandardML = 9;
fun langCompare x y = Int.compare(lang x, lang y);

(*TE.13*);

(*TE.14*);