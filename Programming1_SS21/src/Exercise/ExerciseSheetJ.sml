datatype con = False|True|IC of int;
type id = string;
datatype opr = Add|Sub|Mul|Leq;
datatype ty = Bool|Int|Arrow of ty*ty;
datatype exp = Con of con
             | Id of id
             | Opr of opr*exp*exp
             | If of exp*exp*exp
             | Abs of id*ty*exp
             | App of exp*exp;
fun elabCon True = Bool
  | elabCon False = Bool
  | elabCon (IC_) = Int;
exception Error of string;
fun elabOpr Add Int Int = Int
  | elabOpr Sub Int Int = Int
  | elabOpr Mul Int Int = Int
  | elabOpr Leq Int Int = Int
  | elabOpr _ _ _ = raise Error "T Opr";
fun update env x a y = if x=y then a else env y;
fun elab f (Con c) = elabCon c
  | elab f (Id x) = f x
  | elab f (Opr(opr,e1,e2)) = elabOpr opr (elab f e1) (elab f e2)
  | elab f (If(e1,e2,e3)) = (case (elab f e1 , elab f e2 , elab f e3) of (Bool,t2,t3) => if t2=t3 then t2 else raise Error "T If1" | _ => raise Error "T If2")
  | elab f (Abs(x,t,e)) = Arrow (t,elab (update f x t) e)
  | elab f (App(e1,e2)) = (case elab f e1 of Arrow(t',t) => if t' = elab f e2 then t else raise Error "T App1" | _ => raise Error "T App2");
type 'a env = id -> 'a;
exception Unbound of id;
datatype value = IV of int|Proc of id*exp*value env;
fun evalCon False = IV 0
  | evalCon True = IV 1
  | evalCon (IC x) = IV x;
fun evalOpr Add (IV x1) (IV x2) = IV(x1+x2)
  | evalOpr Sub (IV x1) (IV x2) = IV(x1-x2)
  | evalOpr Mul (IV x1) (IV x2) = IV(x1*x2)
  | evalOpr Leq (IV x1) (IV x2) = IV(if x1<=x2 then 1 else 0)
  | evalOpr _ _ _ = raise Error "R Opr";
fun eval f (Con c) = evalCon c
  | eval f (Id x) = f x
  | eval f (Opr(opr,e1,e2)) = evalOpr opr (eval f e1) (eval f e2)
  | eval f (If(e1,e2,e3)) = (case eval f e1 of IV 1 => eval f e2 | IV 0 => eval f e3 | _ => raise Error "R If")
  | eval f (Abs(x,t,e)) = Proc(x,e,f)
  | eval f (App(e1,e2)) = (case (eval f e1,eval f e2) of (Proc(x,e,f'),v) => eval (update f' x v) e
  | _ => raise Error "R App");

(*J.8
int → bool Arrow(Int, Bool)
x ≤ 3 Opr(Leq, Id"x", Con(IC 3))
if b then x else y If (Id"b", Id"x", Id"y")
fn x : int ⇒ f x Abs("x", Int, App(Id"f ", Id"x"))*);
val e1 = Opr(Leq,Id "n",Con(IC 0));
val f = Abs("f",Arrow(Int,Int),If(e1,Con(IC 1),Opr(Mul,Id "n",App(Id "f",Opr(Sub,Id "n",Con(IC 1))))));