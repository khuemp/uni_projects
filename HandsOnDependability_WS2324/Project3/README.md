# Project Description 
## Project 3: SAFEty of the autonomous Vessel (SAFE-V)

Finally, the whole vessel system must be analyzed for its safety using fault trees.

While our safety engineers at DSys provide the fault trees, they are not happy with the current analysis tool, as it is (a) too slow and (b) does not implement quantitative fault analysis techniques.

Your concrete tasks are the following:

### Algorithm Efficiency
You should implement a more efficient algorithm to find minimal cut sets. The current one is called naive, as it uses an inefficient approach to reduce the sets, starting with the power set of the set of all events.

Performance benchmarking for a small fault tree can be done with the following command-lines that print out the time elapsed to compute the MCSs:
```
cargo run --release --bin naive
cargo run --release --bin efficient
```
In order to benchmark your algorithm on a larger set of fault trees, run:
```
cargo run --release --bin bench
```
Here are our results to compare your solution against:
```
+--------------------+----------------+
| File               | Inference Time |
+--------------------+----------------+
| ffort\csd.dft      | 41.1µs         |
+--------------------+----------------+
| ffort\GSTF_NEW.dft | 56.6µs         |
+--------------------+----------------+
| ffort\GSTF_OLD.dft | 34.5µs         |
+--------------------+----------------+
| ffort\LSTF.dft     | 45.8µs         |
+--------------------+----------------+
| ffort\PCBA.dft     | 69.4µs         |
+--------------------+----------------+
| ffort\pt.dft       | 14.7µs         |
+--------------------+----------------+
| ffort\simple.dft   | 3.2µs          |
+--------------------+----------------+
| ffort\SMS_A1.dft   | 13.6µs         |
+--------------------+----------------+
| ffort\SMS_A11.dft  | 57.3µs         |
+--------------------+----------------+
| ffort\SMS_A5.dft   | 39.3µs         |
+--------------------+----------------+
| ffort\WQDN.dft     | 63.1µs         |
+--------------------+----------------+
```

## Path Sets
You should extend the analysis software with functionality to compute (a) if a set of events is a _path set_ and (b) all _minimal path sets_.

The safety engineers have already provided acceptance tests for you.

## Quantitative Analysis
You should extend the current software with functionality to support quantitative fault tree analysis. As you might have noticed, basic events have a probability value associated with them. The goal is now to provide fault trees with algorithms to compute:

- `q0(tree: &Tree, overwrite: &BTreeSet<Event>)` computes the Q0 function with some events having their probability overwritten. As second argument, the function `q0` takes a set of events overwriting the probabilities of their equally named counterparts in the tree. For example, if the set overwrite contains an event `⟨"x", 0.1⟩`, then the probability of the basic event named `x` should be set to 0.1 for the analysis regardless of its actual probability in the input tree.

- `failure_probability(tree: &Tree)` computes the probability of the tree’s top-level element. You are not allowed to use the `q0` function here, as it provides a conservative overapproximation.

- `birnbaum_importance(tree: &Tree, event: &Event)`.

- `improvement_potential_importance(tree: &Tree, event: &Event)`.

The safety engineers have already provided acceptance tests for you.

## Submission
You only provide fault_tree.rs as a submission.

## Passing Criteria

- Correctness: Your solution must pass all provided tests. You should aim for general solutions, as we inspect your solution to check if you tailored your implementation to only pass on provided tests.

- Performance: When running `cargo run --release --bin bench`, each inference time should be below 1ms.
