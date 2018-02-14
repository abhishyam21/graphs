package com.abhishyam.graphs.cycles.directed;

import com.abhishyam.graphs.Graph;
import com.abhishyam.graphs.cycles.CycleInGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * This is basically using colors.
 *
 * In this algorithm we gonna use 3 sets.
 * 1). White Set: Initially all the vertexes will there in this set
 * 2). Gray Set: vertex which is currently being visited
 * 3). Black Set: vertex which has been completely visited, i.e. all it's child
 *        nodes has been visited
 *
 *
 * Created by Abhishyam on 20-Jan,2018
 */
public class CycleInDirectedGraphI<V> implements CycleInGraph<V>{

    private Set<V> whiteSet = new HashSet<>();
    private Set<V> greySet = new HashSet<>();
    private Set<V> blackSet = new HashSet<>();

    @Override
    public boolean hasCycle(Graph<V> graph) {

        //add all elements to white set
        for (Map.Entry<V, List<V>> entry : graph.getGraph().entrySet()) {
            whiteSet.add(entry.getKey());
        }
        //randomly pick up vertex, and start traversing it's adjacent vertexes
        while (!whiteSet.isEmpty()){
            V vertex = whiteSet.iterator().next();
            if(dfs(vertex,graph)) return true;
        }

        return false;
    }

    private boolean dfs(V vertex, Graph<V> graph) {
        //move the vertex from white set to grey set
        moveVertex(vertex, whiteSet,greySet);

        // for each neighbour
        for (V adjacentVertex : graph.getGraph().get(vertex)) {
            //if vertex is already there in black set, it is already visited
            if(blackSet.contains(adjacentVertex)) continue;
            //if vertex in grey set, cycle detected
            if(greySet.contains(adjacentVertex)) return true;
            //else traverse it's adjacent vertexes
            if(dfs(adjacentVertex,graph)) return true;
        }
        //once vertex is completely visited, move the vertex from grey to black
        moveVertex(vertex,greySet,blackSet);

        return false;
    }

    private void moveVertex(V vertex, Set<V> source, Set<V> destination) {
        source.remove(vertex);
        destination.add(vertex);
    }
}
