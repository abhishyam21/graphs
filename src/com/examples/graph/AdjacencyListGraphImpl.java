package com.examples.graph;

import java.util.*;

/**
 * Created by Rachana Rao on 3/25/2017.
 */
public class AdjacencyListGraphImpl<V> implements Graph<V>{
    Map<V,List<V>> graph;//map which stores vertex and list of  vertexes connected

    public AdjacencyListGraphImpl() {
        graph = new HashMap<>();
    }

    /**
     *
     * @param from start of edge
     * @param to end of the edge
     */
    @Override
    public void addEdge(V from, V to) {
        List<V> list = this.graph.get(from);
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(to);
        this.graph.put(from,list);
        //add the vertex with no edges
        if(!this.graph.containsKey(to)){
            this.graph.put(to, new ArrayList<>());
        }
    }

    /**
     *  Traverse through the graph in bfs model
     * @param v vertex from which we need bfs to start of
     * @return list of vertex in bfs order
     */
    @Override
    public List<V> bfs(V v) {
        Queue<V> queue = new LinkedList<>();
        Map<V,Boolean> isVisited = generateIsVisitedMap();//map to store the visited vertexes
        List<V> bfsList = new ArrayList<>();
        queue.add(v);
        while (!queue.isEmpty()){
            V vertex = queue.poll();
            if(!isVisited.get(vertex)){
                List<V> adjacentList = this.graph.get(vertex);
                queue.addAll(adjacentList);
                isVisited.put(vertex,true);
                bfsList.add(vertex);
            }
        }
        return bfsList;
    }

    private Map<V, Boolean> generateIsVisitedMap() {
        Map<V,Boolean> isVisited = new HashMap<>();
        for (Map.Entry<V,List<V>> entity : this.graph.entrySet()){
            isVisited.put(entity.getKey(),false);
        }
        return isVisited;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<V, List<V>> entity : this.graph.entrySet()) {
            builder.append(entity.getKey()).append("--->");
            builder.append(entity.getValue().toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
