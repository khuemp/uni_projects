(define (domain robot)
(:requirements :strips)
(:predicates
    (robot ?x)
    (location ?x)
    (key ?x)
    (connected ?l1 ?l2)

    (at ?x ?y)
    (holding ?r ?k)
    (free ?l)
    (locked ?l ?k)

    (fuel ?f)
    (fuel-predecessor ?f1 ?f2)
    (fuel-level ?r ?f)
)

(:action move-robot
 :parameters (?r ?f ?t ?f1 ?f2)
 :precondition (and (robot ?r) (location ?f) (location ?t)
                    (fuel ?f1) (fuel ?f2)
                    ;; TODO
               )
 :effect (and ;; TODO
         )
)

(:action take-key
 :parameters (?r ?k ?l)
 :precondition (and (robot ?r) (key ?k) (location ?l)
                ;; TODO
               )
 :effect (and ;; TODO
         )
)

(:action drop-key
 :parameters (?r ?k ?l)
 :precondition (and (robot ?r) (key ?k) (location ?l)
                ;; TODO
               )
 :effect (and ;; TODO
         )
)

(:action unlock
 :parameters (?r ?k ?f ?t)
 :precondition (and (robot ?r) (key ?k) (location ?f) (location ?t)
                ;; TODO
               )
 :effect (and ;; TODO
         )
)

)
