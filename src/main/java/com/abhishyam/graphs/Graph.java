package com.abhishyam.graphs;

import java.util.List;
import java.util.Map;

/**
 * This is the main class of graph.
 *
 * This class represents the Structure of the Graph
 * and it has all the basic methods required for graph.
 *
 * @param <V>
 */
public interface Graph<V> {
    void addEdge(V from, V to);
    void printGraph();
    Map<V, List<V>> getGraph();
}
