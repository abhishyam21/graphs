package com.abhishyam.graphs.cycles.undirected;

import com.abhishyam.graphs.Graph;
import com.abhishyam.graphs.cycles.CycleInGraph;

/**
 * Created by Abhishyam on 14-Feb,2018
 */
public class CyclesInUnDirectedGraphi<V> implements CycleInGraph<V>{

    @Override
    public boolean hasCycle(Graph<V> graph) {
        return false;
    }

}
