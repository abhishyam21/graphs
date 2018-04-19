package com.abhishyam.graphs;

import java.util.ArrayList;
import java.util.List;

public  class Vertex<V>{
        private V data;
        private List<Edge<V>> edges = new ArrayList<>();
        private List<Vertex<V>> adjacentVertex = new ArrayList<>();

        public Vertex(V data) {
            this.data = data;
        }

        public V getData() {
            return data;
        }

        public List<Edge<V>> getEdges() {
            return edges;
        }

        public void addAdjacentVertex(Edge<V> e, Vertex<V> v){
            edges.add(e);
            adjacentVertex.add(v);
        }

        public List<Vertex<V>> getAdjacentVertexes(){
            return adjacentVertex;
        }

        public void setData(V data) {
            this.data = data;
        }

        public int getDegree(){
            return edges.size();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Vertex)) return false;

            Vertex<?> vertex = (Vertex<?>) o;

            return getData() != null ? getData().equals(vertex.getData()) : vertex.getData() == null;
        }

        @Override
        public int hashCode() {
            return getData() != null ? getData().hashCode() : 0;
        }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}