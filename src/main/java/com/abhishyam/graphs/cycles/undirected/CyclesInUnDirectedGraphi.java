package com.abhishyam.graphs.cycles.undirected;

import com.abhishyam.disjointsets.DisjointSet;
import com.abhishyam.graphs.Graph;
import com.abhishyam.graphs.cycles.CycleInGraph;

import java.util.List;
import java.util.Map;

/**
 *
 * In this class we find cycle using Disjoint sets.
 *
 * First add all the nodes in the graph to set.
 * once after adding them to set, traverse each
 * set nodes adjacent nodes and check if they both
 * have same parent.
 * If yes then there is cycle int eh graph, if not
 * no cycle.
 *
 * Created by Abhishyam on 14-Feb,2018
 */
public class CyclesInUnDirectedGraphi<V> implements CycleInGraph<V>{


    private DisjointSet<V> disjointSet = new DisjointSet<>();

    @Override
    public boolean hasCycle(Graph<V> graph) {
        //add all vertices to disjoint set
        addAllNodesToDisjointSet(graph);
        return checkCycle(graph);
    }

    private boolean checkCycle(Graph<V> graph) {
        for (Map.Entry<V, List<V>> entry : graph.getGraph().entrySet()) {
            for (V v : entry.getValue()) {
                V parent1 = disjointSet.findSet(entry.getKey());
                V parent2 = disjointSet.findSet(v);
                if(parent1 == parent2) return true;
                else {
                    disjointSet.union(entry.getKey(),v);
                }
            }

        }
        return false;
    }

    private void addAllNodesToDisjointSet(Graph<V> graph) {
        graph.getGraph().forEach((key,value) -> disjointSet.makeSet(key));
    }

}
