package com.abhishyam.graphs.paths;

import com.abhishyam.graphs.WeightedGraph;
import com.abhishyam.graphs.directedgraphs.WeightedGraphImpl;
import com.abhishyam.graphs.topologicalsorting.TopologicalSort;
import com.abhishyam.graphs.topologicalsorting.WeightedTopSort;

import java.util.*;

/**
 * In this class we are going to compute the
 * longest distance from the given vertex
 * to all the vertex's in the graph.
 *
 * @param <V>
 */
public class LongestPath<V> {
    private WeightedGraph<V> graph;

    LongestPath(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public Map<V, Integer> longestPath(V source){
        TopologicalSort<V> topologicalSort = new WeightedTopSort<>(graph);
        List<V> topSortOrder = topologicalSort.topologicalSort();
        return longestPathUtil(topSortOrder,source);
    }

    private Map<V, Integer> longestPathUtil(List<V> topologicalSort, V source) {
        Integer inf = Integer.MIN_VALUE;
        Deque<V> deque = new ArrayDeque<>(topologicalSort);
        Map<V,Integer> distance = new HashMap<>();
        //except the source node, rest everything set distance to infinity
        for (Map.Entry<V, List<WeightedGraphImpl.AdjacentNode<V>>> entry : graph.getGraph().entrySet()) {
            if(entry.getKey().equals(source)){
                distance.put(entry.getKey(),0);
            }else {
                distance.put(entry.getKey(),inf);
            }
        }
    //for each node calculate the max distance by summing
    //current distance with weight of the edge
        while (!deque.isEmpty()){
            V v = deque.poll();
            if(!distance.get(v).equals(inf)){
                for (WeightedGraphImpl.AdjacentNode<V> adjacentNode : graph.getGraph().get(v)) {
                   if(distance.get(adjacentNode.getV()) < (distance.get(v)+adjacentNode.getWeight())){
                       distance.put(adjacentNode.getV(),distance.get(v)+adjacentNode.getWeight());
                   }
                }
            }
        }
        return distance;

    }
}
