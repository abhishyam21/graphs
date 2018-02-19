package com.abhishyam.graphs.indegree;

import com.abhishyam.graphs.WeightedGraph;
import com.abhishyam.graphs.directedgraphs.WeightedGraphImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WeightedInDegreeImpl<V> implements InDegree<V> {

    private static final Logger log = LoggerFactory.getLogger(WeightedInDegreeImpl.class);
    private WeightedGraph<V> graph;

    public WeightedInDegreeImpl(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public Map<V, Integer> inDegree() {
        Map<V,Integer> result = new LinkedHashMap<>();
        if(graph == null){
            log.info("Null of empty Graph");
            return result;
        }

        inDegreeUtil(result);
        return result;
    }

    private void inDegreeUtil(Map<V, Integer> result) {
        for (Map.Entry<V, List<WeightedGraphImpl.AdjacentNode<V>>> entry : graph.getGraph().entrySet()) {
            result.put(entry.getKey(),0);
        }

        for (Map.Entry<V, List<WeightedGraphImpl.AdjacentNode<V>>> entry : graph.getGraph().entrySet()) {
            for (WeightedGraphImpl.AdjacentNode<V> adjacentNode : entry.getValue()) {
                Integer count = result.get(adjacentNode.getV());
                result.put(adjacentNode.getV(),++count);
            }
        }

    }
}
