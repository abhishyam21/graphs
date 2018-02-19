package com.abhishyam.graphs.directedgraphs;

import com.abhishyam.graphs.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Abhishyam on 19-Feb,2018
 */
public class DirectedGraph<V> implements Graph<V> {

    private static final Logger logger = LoggerFactory.getLogger(DirectedGraph.class);

    private Map<V,List<V>> graph;

    public DirectedGraph() {
        this.graph = new LinkedHashMap<>();
    }


    /**
     * Add an edge to graph
     */
    @Override
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

    @Override
    public void printGraph(){
        for (Map.Entry<V, List<V>> node : this.graph.entrySet()) {
            logger.info("{} -> {}",node.getKey(),node.getValue());
        }
    }


    @Override
    public Map<V, List<V>> getGraph() {
        return graph;
    }

    public void setGraph(Map<V, List<V>> graph) {
        this.graph = graph;
    }

}
