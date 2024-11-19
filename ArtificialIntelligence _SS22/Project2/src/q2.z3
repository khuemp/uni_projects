; The drink of each person is represented by a boolean value.
; WINE => false
; BEER => true

; After running z3, the solution is:
; Gregor ordered a beer.
; Natasha ordered a beer.
; Bob ordered a beer.
; Lise ordered a beer.
; Frank ordered a beer.
; Seifred ordered a wine.
; Ivan ordered a wine.

(declare-const G Bool)
(declare-const N Bool)
(declare-const B Bool)
(declare-const L Bool)
(declare-const F Bool)
(declare-const S Bool)
(declare-const I Bool)

; Everybody must order either beer, or wine. ((G \/ not G) /\ (N \/ not N) /\ (B \/ not B) /\ (L \/ not L) /\ (F \/ not F) /\ (S \/ not S) /\ (I \/ not I))
(assert (or G (not G)))
(assert (or N (not N)))
(assert (or B (not B)))
(assert (or L (not L)))
(assert (or F (not F)))
(assert (or S (not S)))
(assert (or I (not I)))

; Seifred will definitely order a wine. (not S)
(assert (not S))

; Bob orders a beer if and only if Frank orders a beer. (B <=> F)
(assert (and (implies B F) (implies F B)))

; If both Lise and Bob order a beer, then Natasha also orders a beer. ((L /\ B) => N)
(assert (implies (and L B) N))

; Either Gregor and Lise both order a beer, or they both order a wine. ((G /\ L) \/ (not G /\ not L))
(assert (or (and G L) (and (not G) (not L))))

; If Frank orders a wine, then Gregor does not order a beer. (not F => not G)
(assert (implies (not F) (not G)))

; At least one of Ivan, Gregor, and Lise orders a beer. (I \/ G \/ L)
(assert (or (or I G) L))

; Lise orders a beer if and only if Seifred orders a wine. (L <=> not S)
(assert (and (implies L (not S)) (implies (not S) L)))

; Compute solution
(check-sat)

; Print solution
(get-model)