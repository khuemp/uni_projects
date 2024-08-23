# Project Description

## Project 1a: CLEAning NAVigation system (CLEANAV)
We at DSys are supposed to develop a vessel to be cleaning an ocean patch (a rectangular area). The vessel is equipped with a map of the area and different movement & navigation algorithms. To plan the mission, you are supposed to simulate & evaluate these navigation algorithms.

You should design a program with the following specification:

### Specification
#### Example CLI Invocations
```
cargo run -- --help # shows all CLI parameters
cargo run -- -s "1,2" -t 5 -m ./maps/basic.txt -o p
```
cleanav should support the following CLI parameters:

#### Input Map (-m)
- The map is rectangular (and covering the entire surface, i.e., when leaving to one side, you re-enter on the opposite, thanks to a recently developed teleportation device). 

- The ship starts in the top-left corner of the map, which corresponds to the coordinates `(0, 0)`. If we later talk about visited cells, the starting cell is explicitly not visited initially. Keep in mind that even though the first cell does not count towards the _visited cells_, it still needs to be checked for the termination conditions. This means the ship can terminate without doing a step.

- Each cell is described with a distinct symbol (e.g., `.` is open water, `X` is a piece of trash, `O` is a buoy).

Here is an example:
```
..........................................X...................
............O............................XXX..................
......X.................................XXXXX.................
.........................................XXX..................
............................O.............X...................
..............................................................
..............................................................
```

#### Movement Algorithm (-s)
- The movement works using a rational slope, for example, 1 right 3 down. In one (time-)step, the ship travels the full distance (no intermediate cells are visited).
> e.g. -s "1,3"

- When you enter a position with a piece of trash, clean it up immediately (`map::clean`).

#### Termination Conditions (-t)
- A specified number of steps.
> -t ⟨N⟩ with ⟨N⟩ being a number of steps, e.g. -t 3

- Reaching a terminal symbol for the first time.
> -t "S,⟨X⟩" with ⟨X⟩ being a symbol, e.g. -t "S,O" for a buoy. Keep in mind that visiting a cell also means cleaning that cell. The output can therefore never be X for a visited cell.

- Reaching a position for the first time.
> -t "P,⟨X⟩,⟨Y⟩" with ⟨X⟩/⟨Y⟩ being the X / Y coordinate, e.g. -t "P,2,5"

#### Output Functions (-o)

- The number of steps.
> -o N outputs for example 42

- The number of encounters of special symbols (for example how many buoy cells were passed).
> -o "C,⟨S⟩", with ⟨S⟩ being the symbol to count, for example -o "C,X" for trash outputs for example 18

- The symbol on the terminal cell.
> -o S outputs for example X

- The position coordinates of the terminal cell.
> -o P outputs for example (4,5)

- The number of distinct visited symbols (including water).
> -o D outputs for example 2

### Submission
You only provide `navigation.rs` as a submission.

### Passing Criteria
- Correctness: Your solution must pass all provided tests. You should aim for general solutions, as we inspect your solution to check if you tailored your implementation to only pass on provided tests.

## Project 1b: MARKOCEAN
Building on the previous project, DSys is now also interested in simulating the effect of wind on the vessel.

We model the wind as a force that pushes the vessel either 0, 1 or 2 steps into a random direction (N, NE, E, SE, S, SW, W, NW). All possible 17 wind vectors are equally likely in each step. The vessel is moving passively with the wind and does not move on its own.

DSys wants to analyze how the vessel moves over time. Since all steps are independent, we can use a Markov model to simulate this scenario.

### Tasks
We have provided you with an template that to be completed with your knowledge of Markov chains. Make use of the nalgebra crate as much as possible for efficient computation.

1. Implement `generate_transition_matrix` to generate a transition probability matrix. Hint: Think about how to model the movement problem as a DTMC. How many states are there? What is the shape of the matrix?

2. Implement `compute_state_distribution` and `compute_transition_probability` to compute the probabilities of the vessel being in a state after a given number of time steps.

3. To estimate how expensive it will be to fetch the vessel, implement `expected_distance` to compute the expected value of the manhattan distance from the start.
For better understanding have a look at the Manhattan distance. However, do not copy the formula blindly but think about what happens when you can wrap around the grid as specified here.
If, after n steps, the entry at a position gives the probability of being in that position, how can you compute the expected value of the distance from the start?

### Submission
You only provide `analysis.rs` as a submission.

### Passing Criteria
- Correctness: Your solution must pass all provided tests. You should aim for general solutions, as we inspect your solution to check if you tailored your implementation to only pass on provided tests.