package com.abhishyam.graphs;

import java.util.List;
import java.util.Map;

public interface WeightedGraph<V>{

    void addEdge(V from,V to, int weight);

    void printGraph();

    Map<V, List<Edge<V>>> getGraph();

    List<Edge<V>> getAllEdges();

    Map<V,Vertex<V>> getAllVertexes();
}
