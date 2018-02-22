package com.abhishyam.graphs.undirected;

import com.abhishyam.graphs.WeightedGraph;
import com.abhishyam.graphs.directedgraphs.WeightedGraphImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Abhishyam on 19-Feb,2018
 */
public class UnDirectedGraph<V> implements WeightedGraph<V> {

    private static final Logger logger = LoggerFactory.getLogger(UnDirectedGraph.class);

    private List<Edge<V>> allEdges;
    private Map<V,Vertex<V>> allVertexes;

    public UnDirectedGraph() {
        allEdges = new ArrayList<>();
        allVertexes = new HashMap<>();
    }

    @Override
    public void addEdge(V from, V to, int weight) {
        Vertex<V> vertex1 = allVertexes.computeIfAbsent(from, key->{
            Vertex<V> vertex = new Vertex<>(from);
            allVertexes.put(from,vertex);
            return vertex;
        });
        Vertex<V> vertex2 = allVertexes.computeIfAbsent(to, key->{
            Vertex<V> vertex = new Vertex<>(to);
            allVertexes.put(to,vertex);
            return vertex;
        });

        Edge<V> edge1 = new Edge<>(vertex1,vertex2,weight);
        allEdges.add(edge1);
        vertex1.addAdjacentVertex(edge1,vertex2);
        vertex2.addAdjacentVertex(edge1,vertex1);
    }

    @Override
    public void printGraph() {
       allVertexes.forEach((key,val)-> logger.info("{}->{}",key,val.getData()));
    }

    @Override
    public Map<V, List<WeightedGraphImpl.AdjacentNode<V>>> getGraph() {
        return null;
    }

    @Override
    public List<Edge<V>> getAllEdges() {
        return allEdges;
    }

    public void setAllEdges(List<Edge<V>> allEdges) {
        this.allEdges = allEdges;
    }

    @Override
    public Map<V, Vertex<V>> getAllVertexes() {
        return allVertexes;
    }

    public void setAllVertexes(Map<V, Vertex<V>> allVertexes) {
        this.allVertexes = allVertexes;
    }

   public static class Vertex<V>{
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

        void addAdjacentVertex(Edge<V> e, Vertex<V> v){
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


   }

    public static class Edge<V>{
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
}
