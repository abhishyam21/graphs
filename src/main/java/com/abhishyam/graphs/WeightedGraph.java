package com.abhishyam.graphs;

import com.abhishyam.graphs.directedgraphs.WeightedGraphImpl;

import java.util.List;
import java.util.Map;

public interface WeightedGraph<V>{

    void addEdge(V from,V to, int weight);

    void printGraph();

    Map<V, List<WeightedGraphImpl.AdjacentNode<V>>> getGraph();
}
