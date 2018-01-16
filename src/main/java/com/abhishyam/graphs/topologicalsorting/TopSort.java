package com.abhishyam.graphs.topologicalsorting;

import com.abhishyam.graphs.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * This class will generate a list
 * of graph nodes in topological sort order.
 *
 * In this class we r not checking if the graph
 * is DAG or not. so we are assuming that what ever the
 * DAG passed as constructor parameter should be a DAG.
 *
 */
public class TopSort<V> implements TopologicalSort<V>{

    private static final Logger log = LoggerFactory.getLogger(TopSort.class);
    private Graph<V> graph;
    private Set<V> isVisited;
    private List<V> result;

    TopSort(Graph<V> graph) {
        this.graph = graph;
        isVisited = new HashSet<>();
        result = new ArrayList<>();
    }

    @Override
    public List<V> topologicalSort(){
        if(null == graph){
            log.info("Empty Graph !!");
            return new ArrayList<>();
        }
        for (Map.Entry<V, List<V>> node : this.graph.getGraph().entrySet()) {
            if(isVisited.contains(node.getKey())) continue;
            topologicalSortUtil(node.getKey(), node.getValue());
        }
        Collections.reverse(result);
        return result;
    }

    private void topologicalSortUtil(V key, List<V> nodesList) {
        isVisited.add(key);
        for (V v : nodesList) {
            if(isVisited.contains(v)) continue;
            topologicalSortUtil(v, this.graph.getGraph().get(v));
            isVisited.add(v);
        }
        result.add(key);
    }
}
