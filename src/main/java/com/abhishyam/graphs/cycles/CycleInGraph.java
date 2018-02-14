package com.abhishyam.graphs.cycles;

import com.abhishyam.graphs.Graph;

/**
 * Created by Abhishyam on 20-Jan,2018
 */
public interface CycleInGraph<V> {
    boolean hasCycle(Graph<V> graph) ;
}
