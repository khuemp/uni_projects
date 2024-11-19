package routing;

public class MyEdge implements Edge {
    private Node start;
    private Node end;
    private boolean carForward = false;
    private boolean carBackward = false;
    private boolean bikeForward = false;
    private boolean bikeBackward = false;
    private boolean footForward = false;
    private boolean footBackward = false;

    public MyEdge(Node start, Node end, int carForward, int carBackward, int bikeForward, int bikeBackward,
            int footForward, int footBackward) {
        this.start = start;
        this.end = end;
        if (carForward == 1) {
            this.carForward = true;
        }
        if (carBackward == 1) {
            this.carBackward = true;
        }
        if (bikeForward == 1) {
            this.bikeForward = true;
        }
        if (bikeBackward == 1) {
            this.bikeBackward = true;
        }
        if (footForward == 1) {
            this.footForward = true;
        }
        if (footBackward == 1) {
            this.footBackward = true;
        }
    }

    @Override
    public boolean allowsTravelType(TravelType tt, Direction dir) {
        switch (tt) {
            case CAR:
                switch (dir) {
                    case FORWARD:
                        return carForward;

                    case BACKWARD:
                        return carBackward;

                    case ANY:
                        return carForward || carBackward;

                    default:
                        return false;
                }

            case BIKE:
                switch (dir) {
                    case FORWARD:
                        return bikeForward;

                    case BACKWARD:
                        return bikeBackward;

                    case ANY:
                        return bikeForward || bikeBackward;

                    default:
                        return false;
                }

            case FOOT:
                switch (dir) {
                    case FORWARD:
                        return footForward;

                    case BACKWARD:
                        return footBackward;

                    case ANY:
                        return footForward || footBackward;

                    default:
                        return false;
                }

            case ANY:
                switch (dir) {
                    case FORWARD:
                        return carForward || bikeForward || footForward;

                    case BACKWARD:
                        return carBackward || bikeBackward || footBackward;

                    case ANY:
                        return carForward || carBackward || bikeForward || bikeBackward || footForward || footBackward;

                    default:
                        return false;
                }

            default:
                return false;

        }
    }

    @Override
    public Node getEnd() {
        return end;
    }

    @Override
    public double getLength() {
        return start.getCoordinate().getDistance(end.getCoordinate());
    }

    @Override
    public Node getStart() {
        return start;
    }

}
