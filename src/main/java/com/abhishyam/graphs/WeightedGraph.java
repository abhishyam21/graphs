package com.abhishyam.graphs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V> {

    private static final Logger log = LoggerFactory.getLogger(WeightedGraph.class);
    private Map<V,List<AdjacentNode<V>>> graph;

    WeightedGraph() {
        graph = new LinkedHashMap<>();
    }

    public void addEdge(V from,V to, int weight){
        AdjacentNode<V> adjacentNode = new AdjacentNode<>(weight,to);
        List<AdjacentNode<V>> adjacentNodeList = graph.get(from);
        if(adjacentNodeList == null){
            adjacentNodeList = new ArrayList<>();
        }
        adjacentNodeList.add(adjacentNode);
        graph.put(from,adjacentNodeList);
        graph.computeIfAbsent(to, k -> new ArrayList<>());
    }

    public void printGraph(){
        for (Map.Entry<V, List<AdjacentNode<V>>> entity : graph.entrySet()) {
            log.info("{}-->{}",entity.getKey(),entity.getValue());
        }

    }

    public Map<V, List<AdjacentNode<V>>> getGraph() {
        return graph;
    }

    public static class AdjacentNode<V>{
        int weight;
        V v;

        AdjacentNode(int weight, V v) {
            this.weight = weight;
            this.v = v;
        }

        public int getWeight() {
            return weight;
        }

        public V getV() {
            return v;
        }

        @Override
        public String toString() {
            return "{"+v +
                    "," + weight +
                    '}';
        }
    }
}
