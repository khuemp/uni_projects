# Project Description 
## Project 2: CLEAR COMMunication (CLEARCOMM)

The vessel developed by DSys is supposed to have regular communication with a base station - to receive new commands, provide status information, and more. Communicating with the vessel runs over a channel that follows a Gilbert-Elliot Model, i.e., it flips bits and tends to do this in bursts.

The overall system looks like depicted in the following diagram. Existing components are in a normal casing, to-be-developed ones in UPPERCASE:

```
    +---------+             +---------+
    | Vessel  |------------>| ENCODER |
    +---------+             +---------+
                                 |
                                 V
                            +---------+
                            | Channel |
                            +---------+
                                 |
                                 V
    +---------+             +---------+
    |  Base   |<------------| DECODER |
    | Station |             +---------+
    +---------+
```

The Gilbert-Elliot model we use has two parameters (tau and h), but they’re not the same as in the Simplified Gilbert-Elliot model. We have:
- &alpha; = &beta; = &tau; (tau)

- &rho; <sub>e,G</sub> = 0

- &rho; <sub>e,B</sub> = &eta; (h)

Note that you can still compute the average error rate and burst length in a straightforward way.

### Tasks
Your must implement an encoder-decoder pair so that the communication works reliably enough for the vessel to provide live video footage to the base station.

The code is structured using async streams of bytes (i.e., `Stream<Item = u8>`). Async streams are very similar to iterators and you can consume them like this:
```
while let Some(byte) = stream.next().await {
    do_something_with(byte);
}
```
`main.rs` is the structure of the communication pipeline. You MUST not change it. Instead, you are supposed to change the encode and decode in the `coder.rs` module. Here is an identity function:
```
pub(super) async fn encode(
    mut stream: impl Stream<Item = u8> + Unpin,
) -> Result<impl Stream<Item = u8>> {
    let mut data = vec![];
    while let Some(byte) = stream.next().await {
        data.push(byte);
    }
    let output = async_std::stream::from_iter(data);
    Ok(output)
}
```
We recommend that you use `async_std::stream::from_iter` and a local vector variable to get started. If you feel familiar with asynchronous programming and want to get into `async_std`, you should go ahead and try `map` and more of its stream adapters.

### Evaluation
Finally, you execute a pipeline with a codec like:
```
cargo run --release --bin clearcomm-<your-codec-name>
```
### Submission
- You only provide `coder.rs` as a submission.

- You MUST NOT use `unsafe` code, in particular, to use global data to circumvent the channel.

### Passing Criteria
- Performance: We evaluate the performance of your code. Your solution should fulfill the following:
    - E2E Time below 10 sec for any case.
    - Overhead Ratio lower than or equal 200% for any case.
    - Residual Error Rate lower than or equal X, depending on case:
        - h: 0.01, tau: 0.01, X = 5%
        - h: 0.1, tau: 0.05, X = 35%
        - h: 0.75, tau: 0.1, X = 50%
        - h: 0.5, tau: 0.5, X = 55%
        - h: 0.5, tau: 0.75, X = 55%
        - h: 0.75, tau: 0.9, X = 60%
