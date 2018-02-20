package com.abhishyam.graphs.mst;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.undirected.UnDirectedGraph;

import java.util.List;

/**
 * Created by Abhishyam on 20-Feb,2018
 */
public interface MST<V> {
    List<UnDirectedGraph.Edge<V>> minimumSpanningTree() throws BadInputException;
}
