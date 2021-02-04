package Graph;

/**
 * This class holds distance info of any vertex in a Weighted Graph.
 * The distance specified is the distance from the source vertex.
 * Last vertex is the last vertex seen in the path from source to this vertex.
 */

class DistanceInfo {
    private int distance;
    private int lastVertex;

    public DistanceInfo() {
        distance = Integer.MAX_VALUE;
        lastVertex = -1;
    }

    public int getDistance() {
        return distance;
    }

    public int getLastVertex() {
        return lastVertex;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setLastVertex(int lastVertex) {
        this.lastVertex = lastVertex;
    }
}
