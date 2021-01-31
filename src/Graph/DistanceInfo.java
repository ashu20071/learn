package Graph;

/**
 * This class holds distance info of any vertex.
 * The distance specified is the distance from the source vertex.
 * Last vertex is the last vertex seen in the path from source to this vertex.
 */

public class DistanceInfo {
    private int distance;
    private int lastVertex;

    public DistanceInfo() {
        distance = -1;
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
