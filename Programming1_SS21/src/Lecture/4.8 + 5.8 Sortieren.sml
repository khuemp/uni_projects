(*fun foldl f s nil = nil
  | foldl f s (x::xr) = foldl f (f(x,s)) xr;
fun foldr f s nil = s
  | foldr f s (x::xr) = f(x,foldr f s xr);
đã có sẵn fun foldl và foldr*);
foldl op:: nil [1,2,3];
foldr op:: nil [1,2,3];

fun notconcat xs = foldl op@ nil xs;
notconcat [[1,2],[3,4],[5,6]];
fun concat xs = foldr op@ nil xs;
concat [[1,2],[3,4],[5,6]];

(*Wenn man zwischen foldl und foldr wählen kann, sollte man sich für das endrekursive foldl entscheiden!
vì foldl cần ít bước hơn*);

(*------------------------------------------------*);

fun insert (x,nil) = [x]
  | insert (x,y::yr) = if x<=y then x::y::yr else y::insert(x,yr);
insert (3,[1,2,3,4,5]);
fun isort xs = foldl insert nil xs;
isort [3,6,1,2,7];