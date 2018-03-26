package com.abhishyam.graphs.directedgraphs;

import com.abhishyam.graphs.Edge;
import com.abhishyam.graphs.Vertex;
import com.abhishyam.graphs.WeightedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Abhishyam on 19-Feb,2018
 */
public class WeightedGraphImpl<V> implements WeightedGraph<V>{
    private static final Logger logger = LoggerFactory.getLogger(WeightedGraphImpl.class);

    private Map<V,List<Edge<V>>> graph;
    private List<Edge<V>> allEdges;
    private Map<V,Vertex<V>> allVertexes;

    public WeightedGraphImpl() {

        graph = new LinkedHashMap<>();
        allEdges = new ArrayList<>();
        allVertexes = new HashMap<>();
    }

    @Override
    public void addEdge(V from,V to, int weight){

        Vertex<V> vertex1 = allVertexes.computeIfAbsent(from, key->{
            Vertex<V> vertex = new Vertex<>(from);
            allVertexes.put(from,vertex);
            return vertex;
        });

        Vertex<V> vertex2 = allVertexes.computeIfAbsent(to, key->{
            Vertex<V> vertex = new Vertex<>(to);
            allVertexes.put(to,vertex);
            return vertex;
        });
        Edge<V> edge = new Edge<>(vertex1, vertex2, weight);
        allEdges.add(edge);

        List<Edge<V>> adjacentNodeList = graph.get(from);
        if(adjacentNodeList == null){
            adjacentNodeList = new ArrayList<>();
        }
        adjacentNodeList.add(edge);
        graph.put(from,adjacentNodeList);
        graph.computeIfAbsent(to, k -> new ArrayList<>());
    }

    @Override
    public void printGraph(){
        for (Map.Entry<V, List<Edge<V>>> entity : graph.entrySet()) {
            logger.info("{}-->{}",entity.getKey(),entity.getValue());
        }

    }

    public Map<V, List<Edge<V>>> getGraph() {
        return graph;
    }

    @Override
    public List<Edge<V>> getAllEdges() {
        return allEdges;
    }

    @Override
    public Map<V, Vertex<V>> getAllVertexes() {
        return allVertexes;
    }

}
