package com.abhishyam.graphs.indegree;

import com.abhishyam.graphs.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This class will calculate the In-Degree of
 * each node provided in the given graph.
 *
 * In-Degree: No:of incoming edges for a node
 */
public class InDegreeImpl<V> implements InDegree<V>{

    private static final Logger log = LoggerFactory.getLogger(InDegreeImpl.class);

    private Graph<V> graph;

    public InDegreeImpl(Graph<V> graph) {
        this.graph = graph;
    }

    @Override
    public Map<V,Integer> inDegree() {
        if(null == graph)
        {
            log.info("Empty graph !!");
            return new LinkedHashMap<>();
        }

        Map<V,Integer> inDegreeMap = new LinkedHashMap<>();
        for (Map.Entry<V, List<V>> entry : graph.getGraph().entrySet()) {
            inDegreeMap.put(entry.getKey(),0);
        }

        for (Map.Entry<V, List<V>> entry : graph.getGraph().entrySet()) {
            for (V node : entry.getValue()) {
                Integer count = inDegreeMap.get(node);
                inDegreeMap.put(node,++count);
            }
        }
        return inDegreeMap;

    }
}
