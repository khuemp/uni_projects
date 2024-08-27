(declare-const P Bool)
(declare-const Q Bool)
(declare-const R Bool)

(assert (implies R (and (or R P) (not P))))

; Compute solution
(check-sat)

; Print solution
(get-model)