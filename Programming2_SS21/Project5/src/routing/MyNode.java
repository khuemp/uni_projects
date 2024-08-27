package routing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyNode implements Node {
    private long id;
    private Coordinate coordinate;
    private List<Edge> outEdges;

    public MyNode(long id, double latitude, double longitude) {
        this.id = id;
        this.coordinate = new Coordinate(latitude, longitude);
        this.outEdges = new ArrayList<Edge>();
    }

    @Override
    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    @Override
    public Edge getEdge(int idx) {
        return outEdges.get(idx);
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public Iterator<Edge> iterator() {
        return outEdges.iterator();
    }

    @Override
    public int numEdges() {
        return outEdges.size();
    }

    @Override
    public void addEdge(Edge e) {
        outEdges.add(e);
    }

    @Override
    public void removeEdge(int i) {
        outEdges.remove(i);
    }

    @Override
    public String toString() {
        return "Node id=" + this.id + " ; " + this.getCoordinate();
    }

}
