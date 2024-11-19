package routing;

import java.util.Iterator;
import java.util.List;

public class MyRoute extends RouteBase {
    private List<RouteLeg> route;
    private TravelType tt;
    private double distance;

    public MyRoute(List<RouteLeg> route, TravelType tt) {
        this.route = route;
        this.tt = tt;
        this.distance = 0;
        for (int i = 0; i < route.size(); i++) {
            this.distance += route.get(i).getDistance();
        }
    }

    @Override
    public double distance() {
        return distance;
    }

    @Override
    public Node getEndNode() {
        return route.get(route.size() - 1).getEndNode();
    }

    @Override
    public Node getStartNode() {
        return route.get(0).getStartNode();
    }

    @Override
    public TravelType getTravelType() {
        return tt;
    }

    @Override
    public Iterator<RouteLeg> iterator() {
        return route.iterator();
    }

    @Override
    public int size() {
        return route.size();
    }

}
