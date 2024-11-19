(declare-const P Bool)
(declare-const Q Bool)
(declare-const R Bool)

(assert (not (or (and (implies (or P Q) R) (implies R (or P Q))) (or (not R) (not P)))))

; Compute solution
(check-sat)