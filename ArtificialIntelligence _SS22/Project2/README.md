# Project Description
## Question 1
Let P, Q, R be atomic propositions. For each of the following formulas:

1a. (P → Q) ∨ (Q → P) 

1b. R → ((R ∨ P) ∧ ¬P) 

1c. (P → R) ∧ (Q → R) ∧ ¬(¬Q ∧ (¬R ∨ P)) 

1d. ((P ∨ Q) ↔ R) ∨ (¬R ∨ ¬P) 

1e. ((P ∧ Q) ∧ (Q → ¬R) ∧ (P → R) ∧ (¬Q → R)) 

Use Z3 to find out whether the formula is satisfiable, unsatisfiable or a tautology. For each X ∈ {1a, 1b, 1c, 1d, 1e}, submit your solution in the following way:
- If X is a tautology, submit the file `qX-tautology.z3` (e.g., `q1a-tautology.z3`, `q1b-tautology.z3`, ...) containing the Z3 program proving that X is a tautology.

- If X is not a tautology, but it is satisfiable, then submit the file `qX-sat.z3` (e.g., `q1a-sat.z3`) containing a Z3 program that finds and prints out an assignment
to P, Q, and R that satisfies the formula.

- If X is not satisfiable, then submit the file `qX-unsat.z3` containing the Z3
program proving that X is unsatisfiable.

For each X ∈ {1a, 1b, 1c, 1d, 1e}, you can submit only one `.z3` file and you are
not allowed to use truth tables in your solutions.

## Question 2
Gregor, Natasha, Bob, Lise, Frank, Seifred, and Ivan meet at a pub and they want to order a drink. However, their order must satisfy the following conditions:
- Everybody must order either beer, or wine.

- Seifred will definitely order a wine.

- Bob orders a beer if and only if Frank orders a beer.

- If both Lise and Bob order a beer, then Natasha also orders a beer.

- Either Gregor and Lise both order a beer, or they both order a wine.

- If Frank orders a wine, then Gregor does not order a beer.

- At least one of Ivan, Gregor, and Lise orders a beer.

- Lise orders a beer if and only if Seifred orders a wine.

Write a program in Z3 to find out who orders what.