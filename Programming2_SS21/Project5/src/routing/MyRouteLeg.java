package routing;

import java.util.Iterator;
import java.util.List;

public class MyRouteLeg extends RouteLegBase {
    private List<Node> path;
    private double distance;

    public MyRouteLeg(List<Node> path) {
        this.path = path;
        this.distance = 0;
        for (int i = 1; i < path.size(); i++) {
            this.distance += path.get(i - 1).getCoordinate().getDistance(path.get(i).getCoordinate());
        }
    }

    @Override
    public double getDistance() {
        return distance;
    }

    @Override
    public Node getEndNode() {
        return path.get(path.size() - 1);
    }

    @Override
    public Node getStartNode() {
        return path.get(0);
    }

    @Override
    public Iterator<Node> iterator() {
        return path.iterator();
    }

    @Override
    public int size() {
        return path.size();
    }

}
