(declare-const P Bool)
(declare-const Q Bool)
(declare-const R Bool)

(assert (and (and (implies P R) (implies Q R)) (not (and (not Q) (or (not R) P)))))

; Compute solution
(check-sat)

; Print solution
(get-model)