(set-option :produce-models true)

; Datatypes (items, stores)
(declare-datatypes () ((Item screwdriver saw hammer chips sweets cookie water juice coke)))
(declare-datatypes () ((Store store1 store2 store3 store4)))

; Predicates indicating whether an item is a tool, snack or beverage
(declare-fun Tool (Item) Bool)
(declare-fun Snack (Item) Bool)
(declare-fun Beverage (Item) Bool)

; Predicate indicating whether a store sells an item
(declare-fun Sells (Item Store) Bool)

; Define which items are tools, snacks, beverages
(assert (forall ((x Item)) (= (Tool x) (or (= x screwdriver) (= x saw) (= x hammer)))))
(assert (forall ((x Item)) (= (Snack x) (or (= x chips) (= x sweets) (= x cookie)))))
(assert (forall ((x Item)) (= (Beverage x) (or (= x water) (= x juice) (= x coke)))))



;; constraint 1
(assert (forall ((x Item)) (or (Tool x) (Snack x) (Beverage x))))

;; constraint 2
(assert (and (Sells saw store1) (Sells saw store4) (Sells sweets store3)))

;; constraint 3
(assert (forall ((x Item)) (exists ((y Store)) (Sells x y))))

;; constraint 4
(assert (exists ((x Store)) (and (Sells chips x) (Sells sweets x) (Sells cookie x)
								 (forall ((y Store)) (=> (and (Sells chips y) (Sells sweets y) (Sells cookie y)) (= x y)))	
							)
		)
)

;; constraint 5
(assert (not (exists ((x Store)) (and (Sells water x) (Sells saw x)))))

;; constraint 6
(assert (forall ((x Store)) (=> (Sells juice x) (or (Sells water x) (Sells coke x)))))

;; constraint 7
(assert (exists ((x Item) (y Item) (z Item)) (and (Tool x) (Snack y) (Beverage z) (Sells x store1) (Sells y store1) (Sells z store1))))

;; constraint 8
(assert (not (exists ((x Item)) (and (Beverage x) (Sells x store2)))))

;; constraint 9
(assert (forall ((a Store)) (exists ((x Item) (y Item) (z Item)) (and (distinct x y z) (Sells x a) (Sells y a) (Sells z a) 
																	  (forall ((t Item)) (=> (Sells t a) (or (= x t) (= y t) (= z t))))
																 )
							)
		)
)

;; constraint 10
(assert (exists ((x Item) (y Item) (z Item)) (and (Tool x) (Snack y) (Snack z) (distinct x y z) 
												  (exists ((ax Store) (bx Store)) (and (distinct ax bx) (Sells x ax) (Sells x bx)))
												  (exists ((ay Store) (by Store)) (and (distinct ay by) (Sells y ay) (Sells y by)))
												  (exists ((az Store) (bz Store)) (and (distinct az bz) (Sells z az) (Sells z bz)))
												  (forall ((p Item)) (=> (exists ((ap Store) (bp Store)) (and (distinct ap bp) (Sells p ap) (Sells p bp)))
																		 (or (= x p) (= y p) (= z p))
																	 )
												  )
												  (forall ((t Item)) (=> (distinct x y z t)
																		 (exists ((at Store)) (and (Sells t at) 
																								   (forall ((c Store)) (=> (Sells t c) (= at c)))
																							  )
																		 )
																	 )
												  )
											 )
		)
)


(check-sat) ; need to be satisfiable here

;; statements (a-c) to prove
(assert (not (and (Sells coke store1) 
				  (exists ((x Item)) (and (Snack x) (Sells x store2) (Sells x store3)))
				  (exists ((x Store)) (and (Sells juice x) (Sells water x)))
			 )
		)
)

(check-sat) ; need to be unsatisfiable here

