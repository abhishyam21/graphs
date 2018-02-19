package com.abhishyam.graphs.directedgraphs;

import com.abhishyam.graphs.WeightedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Abhishyam on 19-Feb,2018
 */
public class WeightedGraphImpl<V> implements WeightedGraph<V>{
    private static final Logger logger = LoggerFactory.getLogger(WeightedGraphImpl.class);

    private Map<V,List<AdjacentNode<V>>> graph;

    public WeightedGraphImpl() {
        graph = new LinkedHashMap<>();
    }

    @Override
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

    @Override
    public void printGraph(){
        for (Map.Entry<V, List<AdjacentNode<V>>> entity : graph.entrySet()) {
            logger.info("{}-->{}",entity.getKey(),entity.getValue());
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
