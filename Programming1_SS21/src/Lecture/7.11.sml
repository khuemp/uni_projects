datatype tree = T of tree list;
fun fold f (T ts) = f (map (fold f) ts);
val t1 = T[];
val t2 = T[t1,t1,t1];
val t3 = T[T[t2],t1,t2];

fun fold f (T ts) = f (map (fold f) ts);
(*nghĩa là 
fold f (T[T[],T[T[],T[]]])
= f(map(fold f)(T[],T[T[],T[]])) lặp lại fold f lên mọi T trong list/mọi Unterbaum của T ban đầu
= f [fold f (T[]),fold f (T[T[],T[]])]
= f [fold f (T[]),f [fold f (T[]),fold f (T[])]] dùng tiếp fold f lên Unterbaum của baum thứ hai
= f [f(map(fold f)[]),f[f(map(fold f)[]),f(map(fold f)[])]]
= f [f(fold f []),f[f(fold f []),f(fold f [])]]
nên f mới có dạng fn[]=>1|[x,y]=>x+y*);

(*lấy tổng của size unterbaum cộng với 1*)
fun size (T ts) = foldl op+ 1 (map size ts);
fun size (T ts) = fold (foldl op+ 1) (T ts);

(*lấy depth lớn nhất của unterbaum*)
fun depth (T ts) = 1 + foldl Int.max ~1 (map depth ts);
fun depth (T ts) = fold (fn xs => 1 + foldl Int.max ~1 xs) (T ts);

(*cách 1*);
(*Auflisten aller Teilbäume in Präordnung*);
fun presubtrees (T ts) = foldl (fn (t,tr) => tr @ (presubtrees t)) [T ts] ts;
presubtrees t3;
(*Zugriff auf Teilbaum mit Pränummer*);
fun prest t k = List.nth(presubtrees t,k);

(*cách 2*);
fun prest t = 
let 
 fun prel nil k = raise Subscript
   | prel (t::tr) 0 = t
   | prel ((T ts)::tr) k = prel (ts@tr) (k-1)
in
 prel [t]
end;
prest t3 3;