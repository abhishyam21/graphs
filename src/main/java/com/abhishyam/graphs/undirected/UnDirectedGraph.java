package com.abhishyam.graphs.undirected;

import com.abhishyam.graphs.Edge;
import com.abhishyam.graphs.Vertex;
import com.abhishyam.graphs.WeightedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Abhishyam on 19-Feb,2018
 */
public class UnDirectedGraph<V> implements WeightedGraph<V> {

    private static final Logger logger = LoggerFactory.getLogger(UnDirectedGraph.class);

    private List<Edge<V>> allEdges;
    private Map<V,Vertex<V>> allVertexes;
    private Map<V, List<Edge<V>>> graph;

    public UnDirectedGraph() {
        allEdges = new ArrayList<>();
        allVertexes = new HashMap<>();
        graph = new HashMap<>();
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
        Edge<V> edge2 = new Edge<>(vertex2,vertex1,weight);
        allEdges.add(edge1);
        allEdges.add(edge2);
        vertex1.addAdjacentVertex(edge1,vertex2);
        vertex2.addAdjacentVertex(edge1,vertex1);
        addVertexAndEdgeToGraph(edge1);
        addVertexAndEdgeToGraph(edge2);
    }

    private void addVertexAndEdgeToGraph(Edge<V> edge) {
        List<Edge<V>> edges = graph.get(edge.getVertex1().getData());
        if(edges == null){
            edges = new ArrayList<>();
        }
        edges.add(edge);
        graph.put(edge.getVertex1().getData(),edges);
    }

    @Override
    public void printGraph() {
       allVertexes.forEach((key,val)-> logger.info("{}->{}",key,val.getData()));
    }

    @Override
    public Map<V, List<Edge<V>>> getGraph() {
        return graph;
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
}
