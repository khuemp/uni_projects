package routing.utils;

/**
 * Helper class that allows to time operations.
 */
public class Stopwatch {

	/**
	 * The accumulated time.
	 */
	private long accumulator = 0;

	/**
	 * The time of the last invocation.
	 */
	private long starttime = -1;

	/**
	 * Reset the stop watch to the initial state (this implicitly stops it too).
	 */
	public void reset() {
		accumulator = 0;
		starttime = -1;
	}

	/**
	 * Start the stop watch.
	 */
	public void start() {
		assert (starttime == -1) : "Accumulator was started twice without a stop or reset.";
		starttime = System.currentTimeMillis();
	}

	/**
	 * Stop the stop watch.
	 * 
	 * @return The time since the last start.
	 */
	public long stop() {
		assert (starttime != -1) : "Accumulator was stoped but not started.";
		long timeStep = System.currentTimeMillis() - starttime;
		accumulator += timeStep;
		starttime = -1;
		return timeStep;
	}

	/**
	 * @return The accumulated time since the last reset.
	 */
	public long time() {
		return accumulator;
	}
}
