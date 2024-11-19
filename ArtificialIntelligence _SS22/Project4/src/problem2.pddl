(define (problem robot1) (:domain robot)
(:objects
  robot1
  loc1 loc2 loc3 loc4 loc5 loc6 loc7 loc8
  key1 key2 key3
  fuel1 fuel2 fuel3 fuel4 fuel5 fuel6 fuel7 fuel8 fuel9
)
(:init
  (robot robot1)
  (location loc1)
  (location loc2)
  (location loc3)
  (location loc4)
  (location loc5)
  (location loc6)
  (location loc7)
  (location loc8)
  (key key1)
  (key key2)
  (key key3)

  (connected loc1 loc2)
  (connected loc2 loc1)
  (connected loc2 loc3)
  (connected loc3 loc2)
  (connected loc3 loc4)
  (connected loc4 loc3)
  (connected loc4 loc5)
  (connected loc5 loc4)
  (connected loc5 loc6)
  (connected loc6 loc5)
  (connected loc6 loc7)
  (connected loc7 loc6)
  (connected loc7 loc8)
  (connected loc8 loc7)
  (connected loc8 loc1)
  (connected loc1 loc8)

  (at robot1 loc1)
  (at key1 loc4)
  (at key2 loc6)
  (at key3 loc2)
  (free loc2)
  (locked loc3 key3)
  (free loc4)
  (free loc5)
  (free loc6)
  (free loc7)
  (locked loc8 key1)

  (fuel fuel1)
  (fuel fuel2)
  (fuel fuel3)
  (fuel fuel4)
  (fuel fuel5)
  (fuel fuel6)
  (fuel fuel7)
  (fuel fuel8)
  (fuel fuel9)
  (fuel-predecessor fuel1 fuel2)
  (fuel-predecessor fuel2 fuel3)
  (fuel-predecessor fuel3 fuel4)
  (fuel-predecessor fuel4 fuel5)
  (fuel-predecessor fuel5 fuel6)
  (fuel-predecessor fuel6 fuel7)
  (fuel-predecessor fuel7 fuel8)
  (fuel-predecessor fuel8 fuel9)
  (fuel-level robot1 fuel9)
)

(:goal (and (at key2 loc1))
)
)


