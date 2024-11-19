package routing;

/**
 * The possible directions that might be used during routing.
 */
public enum Direction {
	ANY, // < Both, forward and backward search,
	BACKWARD, // < Backward search (target --> start) [Part of a Bonus exercise]
	FORWARD, // < Forward search (start --> target)
}
