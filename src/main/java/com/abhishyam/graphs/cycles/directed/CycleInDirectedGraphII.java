package com.abhishyam.graphs.cycles.directed;

import com.abhishyam.graphs.Graph;
import com.abhishyam.graphs.cycles.CycleInGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * In this class we gonna find-out cycle using
 * DFS approach.
 *
 * To detect cycle we need to find out back-edge
 * in the graph.
 *
 * To find back-edge, keep track of visited nodes
 * in the current recursion. If the same node is
 * found again, then we gonna stop the traverse
 * and return true saying cycle is found.
 *
 *
 * Created by Abhishyam on 14-Feb,2018
 */
public class CycleInDirectedGraphII<V> implements CycleInGraph<V>{

    private Set<V> visited = new HashSet<>();
    private Set<V> currentStackElements = new HashSet<>();

    @Override
    public boolean hasCycle(Graph<V> graph) {
        for (Map.Entry<V, List<V>> entry : graph.getGraph().entrySet())
            if(dfsUtil(entry.getKey(), entry.getValue(), graph)) return true;
        return false;
    }

    private boolean dfsUtil(V key, List<V> value, Graph<V> graph) {
        if(!visited.contains(key)) {
            visited.add(key);
            currentStackElements.add(key);
            for (V adjacentNode : value) {
                List<V> adjacentNodesList = graph.getGraph().get(adjacentNode);
                if(!visited.contains(adjacentNode) && dfsUtil(adjacentNode, adjacentNodesList, graph)) return true;
                else if(currentStackElements.contains(adjacentNode)) return true;
            }
        }
        currentStackElements.remove(key);
        return false;
    }
}
