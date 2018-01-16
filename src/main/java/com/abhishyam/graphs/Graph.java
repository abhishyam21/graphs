package com.abhishyam.graphs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * This is the main class of graph.
 *
 * This class represents the Structure of the Graph
 * and it has all the basic methods required for graph.
 *
 * @param <V>
 */
public class Graph<V> {
    private static final Logger log = LoggerFactory.getLogger(Graph.class);
    private Map<V,List<V>> graph;

    public Graph() {
        this.graph = new LinkedHashMap<>();
    }

    /**
     * Add an edge to graph
     */
    public void addEdge(V from, V to){
        List<V> adjacentNodes = this.graph.get(from);
        if(adjacentNodes == null){
            adjacentNodes = new ArrayList<>();
        }
        adjacentNodes.add(to);
        this.graph.put(from,adjacentNodes);
        //add vertex with no edge
        if(!this.graph.containsKey(to))
            this.graph.put(to,new ArrayList<>());
    }


    public void printGraph(){
        for (Map.Entry<V, List<V>> node : this.graph.entrySet()) {
            log.info("{} -> {}",node.getKey(),node.getValue());
        }

    }

    public Map<V, List<V>> getGraph() {
        return graph;
    }

    public void setGraph(Map<V, List<V>> graph) {
        this.graph = graph;
    }
}
