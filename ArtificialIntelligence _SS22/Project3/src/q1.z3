(declare-datatypes () ((Vertex A B C D E F G H)))
(declare-fun Edge (Vertex Vertex) Bool)
(declare-fun Reachable (Vertex Vertex) Bool)
(declare-fun Isolated (Vertex) Bool)

; 1. Fully specify the graph by providing the definition of the Edge relation
(assert (forall ((x Vertex) (y Vertex)) (and (=> (Edge x y) (or (and (= x A) (= y B)) 
																(and (= x A) (= y C)) 
																(and (= x B) (= y C)) 
																(and (= x C) (= y D)) 
																(and (= x C) (= y E)) 
																(and (= x D) (= y A)) 
																(and (= x D) (= y E)) 
																(and (= x E) (= y E)) 
																(and (= x F) (= y C)) 
																(and (= x F) (= y G)) 
																(and (= x H) (= y F)))
															 )
											 (=> (or (and (= x A) (= y B)) 
													 (and (= x A) (= y C)) 
													 (and (= x B) (= y C)) 
													 (and (= x C) (= y D)) 
													 (and (= x C) (= y E)) 
													 (and (= x D) (= y A)) 
													 (and (= x D) (= y E)) 
													 (and (= x E) (= y E)) 
													 (and (= x F) (= y C)) 
													 (and (= x F) (= y G)) 
													 (and (= x H) (= y F))
												 ) 
												 (Edge x y))
										)
		)
)

; 2. Every node can reach itself
(assert (forall ((x Vertex)) (Reachable x x)))

; 3. If there is an edge from x to y and y can reach z then x can reach z
(assert (forall ((x Vertex) (y Vertex) (z Vertex)) (=> (and (Edge x y) (Reachable y z)) (Reachable x z))))

; 4. A node is isolated if and only if there is no incoming or outgoing edge
(assert
	(forall ((x Vertex)) (and (=> (Isolated x) (not (exists ((y Vertex)) (or (Edge x y) (Edge y x))))) 
							  (=> (not (exists ((y Vertex)) (or (Edge x y) (Edge y x)))) (Isolated x))
						 )
	)
)

; 5. Show that vertex E is reachable from vertex A and
; that no vertex in the graph is isolated.
(assert (= true (and (Reachable E A) 
					 (forall ((x Vertex)) (not (Isolated x)))
				)
		)
)

(check-sat)