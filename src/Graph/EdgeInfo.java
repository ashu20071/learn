package Graph;

public class EdgeInfo {
    private final int vertex1;
    private final int vertex2;
    private final int weight;

    public EdgeInfo(int vertex1, int vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    public int getVertex1() {
        return vertex1;
    }

    public int getVertex2() {
        return vertex2;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.valueOf(vertex1) + String.valueOf(vertex2);
    }
}
