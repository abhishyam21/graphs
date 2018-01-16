package com.abhishyam.graphs.topologicalsorting;

import com.abhishyam.graphs.WeightedGraph;
import com.abhishyam.graphs.indegree.InDegree;
import com.abhishyam.graphs.indegree.WeightedInDegreeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class WeightedTopSort<V> implements TopologicalSort<V> {

    private static final Logger log = LoggerFactory.getLogger(WeightedGraph.class);
    private WeightedGraph<V> graph;

    public WeightedTopSort(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public List<V> topologicalSort() {
        if(graph == null){
            log.info("Null or empty graph");
            return new ArrayList<>();
        }

        return topologicalSortUtil();
    }

    private List<V> topologicalSortUtil() {
        List<V> result = new ArrayList<>();
        InDegree<V> inDegree = new WeightedInDegreeImpl<>(graph);
        Map<V, Integer> inDegreeMap = inDegree.inDegree();

        Queue<V> queue = new LinkedList<>();

        for (Map.Entry<V, Integer> entry : inDegreeMap.entrySet()) {
            if(entry.getValue() == 0) queue.add(entry.getKey());
        }

        while (!queue.isEmpty()){
            V node = queue.poll();
            result.add(node);
            for (WeightedGraph.AdjacentNode<V> adjacentNode : graph.getGraph().get(node)) {
                Integer count = inDegreeMap.get(adjacentNode.getV());
                count--;
                if(count == 0) {
                    queue.add(adjacentNode.getV());
                }
                inDegreeMap.put(adjacentNode.getV(),count);
            }
        }
        return result;
    }
}
