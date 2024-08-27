(declare-const P Bool)
(declare-const Q Bool)
(declare-const R Bool)

(assert (and (and (and (and P Q) (implies Q (not R))) (implies P R)) (implies (not Q) R)))

; Compute solution
(check-sat)