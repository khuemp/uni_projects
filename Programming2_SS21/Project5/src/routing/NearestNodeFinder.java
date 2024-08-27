package routing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NearestNodeFinder implements NodeFinder {
    private Graph graph;
    private Coordinate upperPoint;
    private Coordinate lowerPoint;

    private static final int NUM_BINS = 128;
    private ArrayList<ArrayList<HashSet<Long>>> grid;

    public NearestNodeFinder(Graph graph) {
        this.graph = graph;
        this.upperPoint = graph.getNWCoordinate();
        this.lowerPoint = graph.getSECoordinate();

        this.grid = new ArrayList<ArrayList<HashSet<Long>>>();
        // Construct grid
        for (int i = 0; i < NUM_BINS; i++) {
            ArrayList<HashSet<Long>> row = new ArrayList<HashSet<Long>>();
            for (int j = 0; j < NUM_BINS; j++) {
                row.add(new HashSet<Long>());
            }
            this.grid.add(row);
        }
        // Add nodes to grid
        for (Node node : this.graph) {
            getGridBox(node.getCoordinate()).add(node.getId());
        }
    }

    private int computeISlot(Coordinate c) {
        double length = upperPoint.getLatitude() - lowerPoint.getLatitude();
        double binSize = length / NUM_BINS;
        return Math.min((int) ((c.getLatitude() - lowerPoint.getLatitude()) / binSize), NUM_BINS - 1);
    }

    private int computeJSlot(Coordinate c) {
        double length = upperPoint.getLongitude() - lowerPoint.getLongitude();
        double binSize = length / NUM_BINS;
        return Math.min((int) ((c.getLongitude() - lowerPoint.getLongitude()) / binSize), NUM_BINS - 1);
    }

    private HashSet<Long> getGridBox(Coordinate c) {
        return grid.get(computeISlot(c)).get(computeJSlot(c));
    }

    @Override
    public Node getNodeForCoordinates(Coordinate c) {
        int startI = computeISlot(c);
        int startJ = computeJSlot(c);

        int bound = 0;
        int foundI = -1;
        int foundJ = -1;

        //find outter box (1st step)
        outterWhile: while (startI - bound >= 0 || startJ - bound >= 0 || startI + bound < NUM_BINS
                || startJ + bound < NUM_BINS) {
            for (int i = startI - bound; i <= startI + bound; i++) {
                if (i < 0 || i >= NUM_BINS) {
                    continue;
                }

                // first column
                int firstColIndex = startJ - bound;
                if (firstColIndex >= 0 && firstColIndex < NUM_BINS) {
                    if (grid.get(i).get(firstColIndex).size() > 0) {
                        foundI = i;
                        foundJ = firstColIndex;
                        break outterWhile;
                    }
                }

                // last column
                int lastColIndex = startJ + bound;
                if (lastColIndex >= 0 && lastColIndex < NUM_BINS) {
                    if (grid.get(i).get(lastColIndex).size() > 0) {
                        foundI = i;
                        foundJ = lastColIndex;
                        break outterWhile;
                    }
                }
            }

            for (int j = startJ - bound; j <= startJ + bound; j++) {
                if (j < 0 || j >= NUM_BINS) {
                    continue;
                }

                // first row
                int firstRowIndex = startI - bound;
                if (firstRowIndex >= 0 && firstRowIndex < NUM_BINS) {
                    if (grid.get(firstRowIndex).get(j).size() > 0) {
                        foundI = firstRowIndex;
                        foundJ = j;
                        break outterWhile;
                    }
                }

                // last row
                int lastRowIndex = startI + bound;
                if (lastRowIndex >= 0 && lastRowIndex < NUM_BINS) {
                    if (grid.get(lastRowIndex).get(j).size() > 0) {
                        foundI = lastRowIndex;
                        foundJ = j;
                        break outterWhile;
                    }
                }
            }

            bound += 1;
        }

        if (foundI < 0 && foundJ < 0) {
            return null;
        }

        // find nearest point in the found grid box (1st step)
        double boundDis = Double.MAX_VALUE;
        for (long nodeId : grid.get(foundI).get(foundJ)) {
            double d = c.getDistance(graph.getNode(nodeId).getCoordinate());
            if (d < boundDis) {
                boundDis = d;
            }
        }

        //find all nodes in bound box within radius of 1st step (2nd step)
        CoordinateBox boundBox = c.computeBoundingBox(boundDis);
        int boundStartI = computeISlot(boundBox.getLowerBound());
        int boundStartJ = computeJSlot(boundBox.getLowerBound());
        int boundEndI = computeISlot(boundBox.getUpperBound());
        int boundEndJ = computeJSlot(boundBox.getUpperBound());
        Set<Long> candidates = new HashSet<Long>();
        for (int i = boundStartI; i <= boundEndI; i++) {
            if (i >= NUM_BINS || i < 0) {
                continue;
            }
            for (int j = boundStartJ; j <= boundEndJ; j++) {
                if (j >= NUM_BINS || j < 0) {
                    continue;
                }
                candidates.addAll(grid.get(i).get(j));
            }
        }

        // find actual nearest point (2nd step)
        Node resNode = null;
        double resDis = Double.MAX_VALUE;
        for (long nodeId : candidates) {
            double d = c.getDistance(graph.getNode(nodeId).getCoordinate());
            if (d < resDis) {
                resDis = d;
                resNode = graph.getNode(nodeId);
            }
        }

        return resNode;
    }

}
