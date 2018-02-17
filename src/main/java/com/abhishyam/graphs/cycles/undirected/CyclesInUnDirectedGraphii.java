package com.abhishyam.graphs.cycles.undirected;

import com.abhishyam.graphs.Graph;
import com.abhishyam.graphs.cycles.CycleInGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * In this class we will detect the cycle
 * using dfs traversal.
 *
 * Keep  track of visited nodes in current
 * recursion and check if same node is
 * visited again.
 * If yes then cycle found else no
 *
 * Created by Abhishyam on 15-Feb,2018
 */
public class CyclesInUnDirectedGraphii<V> implements CycleInGraph<V>{

    private Set<V> isVisted = new HashSet<>();
    private Set<V> currentStackElements = new HashSet<>();

    @Override
    public boolean hasCycle(Graph<V> graph) {
        for (Map.Entry<V, List<V>> entry : graph.getGraph().entrySet()) {

        }

        return false;
    }
}
