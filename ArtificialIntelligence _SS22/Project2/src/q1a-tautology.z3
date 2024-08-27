(declare-const P Bool)
(declare-const Q Bool)
(declare-const R Bool)

(assert (not (or (implies P Q) (implies Q P))))

; Compute solution
(check-sat)