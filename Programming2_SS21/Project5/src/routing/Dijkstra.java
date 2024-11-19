package routing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class NodeDistancePair implements Comparable<NodeDistancePair> {
    Node node;
    double distance;

    public NodeDistancePair(Node node, double distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(NodeDistancePair other) {
        if (distance < other.distance) {
            return -1;
        } else if (distance == other.distance) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class Dijkstra implements RoutingAlgorithm {

    public Dijkstra() {
    }

    @Override
    public Route computeRoute(Graph g, List<Node> nodes, TravelType tt) throws NoSuchRouteException {
        if (nodes.size() < 2) {
            throw new NoSuchRouteException();
        }

        List<RouteLeg> route = new ArrayList<RouteLeg>();
        List<Node> deletedNodes = new ArrayList<Node>();

        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i - 1).getId() == nodes.get(i).getId()) {
                deletedNodes.add(nodes.get(i - 1));
            }
        }

        for (Node node : deletedNodes) {
            nodes.remove(node);
        }

        if (nodes.size() == 1) {
            route.add(computeRouteLeg(g, nodes.get(0), nodes.get(0), tt));
        } else {
            for (int i = 1; i < nodes.size(); i++) {
                route.add(computeRouteLeg(g, nodes.get(i - 1), nodes.get(i), tt));
            }
        }
        return new MyRoute(route, tt);
    }

    @Override
    public RouteLeg computeRouteLeg(Graph g, long startId, long endId, TravelType tt) throws NoSuchRouteException {
        Node startNode = g.getNode(startId);
        Node endNode = g.getNode(endId);
        return computeRouteLeg(g, startNode, endNode, tt);
    }

    @Override
    public RouteLeg computeRouteLeg(Graph g, Node startNode, Node endNode, TravelType tt) throws NoSuchRouteException {
        if (startNode == null || endNode == null) {
            throw new NoSuchRouteException();
        }

        if (startNode.getId() == endNode.getId()) {
            List<Node> path = new ArrayList<Node>();
            path.add(startNode);

            return new MyRouteLeg(path);
        }

        Map<Node, Double> node2distance = new HashMap<Node, Double>();
        Map<Node, Node> node2prevNode = new HashMap<Node, Node>();

        PriorityQueue<NodeDistancePair> q = new PriorityQueue<NodeDistancePair>();
        q.offer(new NodeDistancePair(startNode, 0));

        Set<Node> visisted = new HashSet<Node>();

        while (!q.isEmpty()) {
            NodeDistancePair nd = q.poll();
            Node s = nd.node;
            double initDist = nd.distance;

            if (visisted.contains(s)) {
                continue;
            }

            visisted.add(s);

            if (s.getId() == endNode.getId()) {
                break;
            }

            for (Edge e : s) {
                Node t = e.getEnd();
                if (visisted.contains(t)) {
                    continue;
                }

                if (!e.allowsTravelType(tt, Direction.FORWARD)) {
                    continue;
                }

                double curDist = node2distance.getOrDefault(t, Double.MAX_VALUE);
                double newDist = initDist + e.getLength();

                double dist = Math.min(curDist, newDist);

                q.offer(new NodeDistancePair(t, dist));

                if (newDist < curDist) {
                    node2distance.put(t, dist);
                    node2prevNode.put(t, s);
                }
            }
        }

        if (!node2prevNode.containsKey(endNode)) {
            throw new NoSuchRouteException();
        }

        List<Node> path = new ArrayList<Node>();
        path.add(endNode);
        while (true) {
            Node lastNode = path.get(path.size() - 1);
            if (lastNode.getId() != startNode.getId()) {
                path.add(node2prevNode.get(lastNode));
            } else {
                break;
            }
        }
        Collections.reverse(path);

        return new MyRouteLeg(path);
    }

    @Override
    public boolean isBidirectional() {
        return false;
    }

}
