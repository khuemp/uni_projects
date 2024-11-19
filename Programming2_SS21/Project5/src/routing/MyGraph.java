package routing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyGraph implements Graph {
    private Map<Long, Node> id2node;

    public MyGraph(String fileName) throws FileNotFoundException {
        id2node = new HashMap<Long, Node>();

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lineSplit = line.split(" ");
            if (lineSplit[0].equals("N")) {
                long id = Long.parseLong(lineSplit[1]);
                double latitude = Double.parseDouble(lineSplit[2]);
                double longitude = Double.parseDouble(lineSplit[3]);

                Node node = new MyNode(id, latitude, longitude);
                id2node.put(id, node);

            } else if (lineSplit[0].equals("E")) {
                long startId = Long.parseLong(lineSplit[1]);
                long endId = Long.parseLong(lineSplit[2]);
                int carForward = Integer.parseInt(lineSplit[3]);
                int carBackward = Integer.parseInt(lineSplit[4]);
                int bikeForward = Integer.parseInt(lineSplit[5]);
                int bikeBackward = Integer.parseInt(lineSplit[6]);
                int footForward = Integer.parseInt(lineSplit[7]);
                int footBackward = Integer.parseInt(lineSplit[8]);

                Node start = id2node.get(startId);
                Node end = id2node.get(endId);

                Edge edgeStart = new MyEdge(start, end, carForward, carBackward, bikeForward, bikeBackward,
                        footForward, footBackward);
                start.addEdge(edgeStart);

                Edge edgeEnd = new MyEdge(end, start, carBackward, carForward, bikeBackward, bikeForward,
                        footBackward, footForward);
                end.addEdge(edgeEnd);

            }
        }
        scanner.close();

    }

    @Override
    public Node getNode(long id) {
        return id2node.get(id);
    }

    @Override
    public Coordinate getNWCoordinate() {
        double maxLat = Double.MIN_VALUE;
        double maxLon = Double.MIN_VALUE;

        for (Node node : id2node.values()) {
            if (node.getCoordinate().getLatitude() > maxLat) {
                maxLat = node.getCoordinate().getLatitude();
            }
            if (node.getCoordinate().getLongitude() > maxLon) {
                maxLon = node.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLat, maxLon);
    }

    @Override
    public Coordinate getSECoordinate() {
        double minLat = Double.MAX_VALUE;
        double minLon = Double.MAX_VALUE;

        for (Node node : id2node.values()) {
            if (node.getCoordinate().getLatitude() < minLat) {
                minLat = node.getCoordinate().getLatitude();
            }
            if (node.getCoordinate().getLongitude() < minLon) {
                minLon = node.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLat, minLon);
    }

    @Override
    public Iterator<Node> iterator() {
        return id2node.values().iterator();
    }

    @Override
    public int numEdges() {
        int n = 0;
        for (Node node : id2node.values()) {
            n += node.numEdges();
        }
        return n;
    }

    @Override
    public int numNodes() {
        return id2node.size();
    }

    @Override
    public int removeIsolatedNodes() {
        List<Long> deletedNodes = new ArrayList<Long>();

        for (long id : id2node.keySet()) {
            if (getNode(id).numEdges() == 0) {
                deletedNodes.add(id);
            }
        }

        for (long id : deletedNodes) {
            id2node.remove(id);
        }

        return deletedNodes.size();
    }

    @Override
    public int removeUntraversableEdges(RoutingAlgorithm ra, TravelType tt) {
        int deletedEdges = 0;

        for (Node node : id2node.values()) {
            for (Iterator<Edge> it = node.iterator(); it.hasNext();) {
                Edge edge = it.next();
                if (!ra.isBidirectional()) {
                    if (!edge.allowsTravelType(tt, Direction.FORWARD)) {
                        it.remove();
                        deletedEdges++;
                    }
                } else {
                    if (!edge.allowsTravelType(tt, Direction.FORWARD)
                            || !edge.allowsTravelType(tt, Direction.BACKWARD)) {
                        it.remove();
                        deletedEdges++;
                    }
                }
            }
        }
        return deletedEdges;
    }

    @Override
    public boolean isOverlayGraph() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Node getNodeInUnderlyingGraph(long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
