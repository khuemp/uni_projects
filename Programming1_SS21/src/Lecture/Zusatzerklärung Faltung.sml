fun gluehwein x = foldl op+ 0 x;
gluehwein [1, 5, 3, 1];

fun onlyTrue x = foldl (fn (i,s) => if i then s else false) true x;
onlyTrue [true,true,false];
onlyTrue [true,true,true];
onlyTrue [true,false,false];

fun someTrue x = foldl (fn (i,s) => if i then true else s) false x;
someTrue [false,false,false];
someTrue [true,true,true];
someTrue [true,false,false];

fun potenz a b = if b<1 then 1 else a*potenz a (b-1);
fun megaPotenz x = foldr (fn (i,s) => potenz i s) 1 x;
megaPotenz [3,2,4];

fun nurGerade x = foldr (fn (i,s) => if i mod 2 = 0 then i::s else s) nil x;
nurGerade [1,2,3,4,5];

fun eins 0 = false
  | eins x = if x mod 10 = 1 then true else eins (x div 10);
fun hasseEiner x = foldr (fn (i,s) => if eins i then s else i::s) nil x;
hasseEiner [1, 22, 12, 11, 353, 20001];

fun miniSum x =  