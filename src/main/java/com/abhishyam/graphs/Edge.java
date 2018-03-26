package com.abhishyam.graphs;

public class Edge<V> {
    private Vertex<V> vertex1;
    private Vertex<V> vertex2;

    private int weight;

    public Edge(Vertex<V> vertex1, Vertex<V> vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Edge(Vertex<V> vertex1, Vertex<V> vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    public Vertex<V> getVertex1() {
        return vertex1;
    }

    public Vertex<V> getVertex2() {
        return vertex2;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;

        Edge<?> edge = (Edge<?>) o;

        if (getVertex1() != null ? !getVertex1().equals(edge.getVertex1()) : edge.getVertex1() != null)
            return false;
        return getVertex2() != null ? getVertex2().equals(edge.getVertex2()) : edge.getVertex2() == null;
    }

    @Override
    public int hashCode() {
        int result = getVertex1() != null ? getVertex1().hashCode() : 0;
        result = 31 * result + (getVertex2() != null ? getVertex2().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Edge{");
        sb.append("vertex1=").append(vertex1);
        sb.append(", vertex2=").append(vertex2);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}