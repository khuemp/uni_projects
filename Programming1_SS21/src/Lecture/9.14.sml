(*abs terminiert nhưng không có natürliche Terminierung vì nó không Rekursion
fac terminiert do có natürliche Terminierung λx∈Z. x
fib terminiert do có natürliche Terminierung thích hợp cho cả 2 Rekusionsrelation λx∈N. x
fib' không terminiert do Ergebnisbereich không phải là N*);

(*https://de.wikipedia.org/wiki/Konstituente

Die Konstituenten einer Menge X sind rekursiv definiert:
1. Jedes Element von X ist eine Konstituente von X
2. Jede Konstituente eines Elements von X ist eine Konstituente von X

Eine Relation heißt strukturell, wenn für jede Kante (x,y) ∈ R gilt, dass y eine Konstituente von x ist
Ter := {(x,y)∈NxN|x>y} ist eine strukturelle Relation
vì ví dụ x=6 -> y=5/y=4/y=3/... thì 5,4,3 luôn là Kóntituente của 6

VD: {{{∅}}} hat 3 Konstituenten {{∅}}, {∅} und ∅
{∅,{∅,{∅}}} hat 3 Konstituenten ∅,{∅,{∅}},{∅} (vì ∅ trùng nên chỉ lấy 1*);

(*Die Ergebnisfunktionen von fac und fac'sind gleich
vì chỉ xét Definitionsbereich chứ k xét Argumentbereich, nếu x trong fac' < 0 thì không có đáp án, nên Definitionsbereich của fac' = Definitionsbereich của fac => *);

(*Dom f ⊆ Dom p <=> p terminiert für alle x ∈Dom f*);