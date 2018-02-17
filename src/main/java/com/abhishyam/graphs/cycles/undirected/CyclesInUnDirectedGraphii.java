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
 * Do Dfs traversal of the graph by
 * keeping the track of visited nodes.
 * While traversing, pass the parent nodes
 * from which it is resulted, so that we
 * no need to traverse in that direction again.
 * While traversing, if we found out a vertex
 * in Visited set then cycle is found, else no.
 *
 *
 * Created by Abhishyam on 15-Feb,2018
 */
public class CyclesInUnDirectedGraphii<V> implements CycleInGraph<V>{

    private Set<V> isVisited = new HashSet<>();

    @Override
    public boolean hasCycle(Graph<V> graph) {
        for (Map.Entry<V, List<V>> entry : graph.getGraph().entrySet()) {
            if(!isVisited.contains(entry.getKey()) && dfsUtil(entry.getKey(),entry.getValue(), graph, null)) return true;
        }
        return false;
    }

    private boolean dfsUtil(V key, List<V> value, Graph<V> graph, V parent) {
            isVisited.add(key);
            for (V v : value) {
                if(!isVisited.contains(v)){
                    if(dfsUtil(v, graph.getGraph().get(v), graph,key)) return true;
                }else if(v != parent) return true;
            }
        return false;
    }
}