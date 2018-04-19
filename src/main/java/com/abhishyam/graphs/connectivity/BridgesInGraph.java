package com.abhishyam.graphs.connectivity;

import com.abhishyam.graphs.Edge;
import com.abhishyam.graphs.Vertex;
import com.abhishyam.graphs.WeightedGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem Link: https://www.geeksforgeeks.org/bridge-in-a-graph/
 *
 * Created by Abhishyam on 19-Apr,2018
 */
public class BridgesInGraph<V> {

    private WeightedGraph<V> graph;
    private int time = 0;

    public BridgesInGraph(WeightedGraph<V> graph) { this.graph = graph;time=0; }

    public Set <Edge<V>> findBridgesInGraph(){
        Set<Vertex<V>> visited = new HashSet<>();
        Set<Edge<V>> bridges = new HashSet<>();
        Vertex<V> startVertex = this.graph.getAllEdges().iterator().next().getVertex1();

        Map<Vertex<V>,Integer> discoveredTime = new HashMap<>();
        Map<Vertex<V>,Integer> lowTime = new HashMap<>();
        Map<Vertex<V>,Vertex<V>> parents = new HashMap<>();

        dfsUtil(visited, bridges, discoveredTime, lowTime, parents, startVertex);
        return bridges;
    }


    private void dfsUtil(Set<Vertex<V>> visited, Set<Edge<V>> bridges, Map<Vertex<V>, Integer> discoveredTime,
                         Map<Vertex<V>, Integer> lowTime,
                         Map<Vertex<V>, Vertex<V>> parents, Vertex<V> vertex) {
            visited.add(vertex);
            discoveredTime.put(vertex,time);
            lowTime.put(vertex,time);
            time++;
        for (Vertex<V> adjacentVertex : vertex.getAdjacentVertexes()) {
            if(!visited.contains(adjacentVertex)){
                parents.put(adjacentVertex,vertex);
                dfsUtil(visited,bridges,discoveredTime,lowTime,parents,adjacentVertex);
                lowTime.put(vertex, Math.min(lowTime.get(vertex), lowTime.get(adjacentVertex)));
                if(lowTime.get(adjacentVertex) > discoveredTime.get(vertex)){
                        bridges.add(new Edge<>(vertex,adjacentVertex));
                }
            }else if(adjacentVertex != parents.get(vertex)){
                lowTime.put(vertex, Math.min(lowTime.get(vertex), discoveredTime.get(adjacentVertex)));
            }
        }
    }
}
