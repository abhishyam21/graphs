package com.examples.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Rachana Rao on 3/25/2017.
 */
public class AdjacencyListGraphImpl<V> implements Graph<V>{
    Map<V,List<V>> graph;//map which stores vertex and list of  vertexes connected
    private Comparator<V> comparator;

    public AdjacencyListGraphImpl(Comparator<V> comparator) {
        graph = new HashMap<>();
        this.comparator = comparator;
    }

    /**
     * Add a directed edge to graph
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
        list.sort(this.comparator);
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

    /**
     *
     * @param v vertex from where we need to start dfs
     * @return list of vertexes in dfs order
     */
    @Override
    public List<V> dfs(V v) {
        Stack<V> stack = new Stack<V>();
        stack.push(v);

        List<V> dfsList = new ArrayList<V>();
        Map<V,Boolean> isVisited = generateIsVisitedMap();

        while (!stack.isEmpty()){
            V pop = stack.pop();
            if(!isVisited.get(pop)){
                dfsList.add(pop);
                stack.addAll(this.graph.get(pop));
                isVisited.put(pop,true);
            }
        }
        return dfsList;
    }

    /**
     * Return the list containing all the vertex whose
     * in-degree is zero
     * @return Set<V>
     */
    @Override
    public Set<V> getRootNodes() {
        return inDegree().entrySet().stream().
                filter(entity -> entity.getValue() == 0).map(Map.Entry::getKey).collect(Collectors.toSet());
    }

    /**
     * Create the isVisited map.
     *  IsVisited Map, contains all the vertex and each
     *  vertex is mapped with false flag, so that it indicates
     *  that particular vertex is not visited
     * @return map of vertex and false flag set for each vertex
     */
      Map<V, Boolean> generateIsVisitedMap() {
        Map<V,Boolean> isVisited = new HashMap<>();
        for (Map.Entry<V,List<V>> entity : this.graph.entrySet()){
            isVisited.put(entity.getKey(),false);
        }
        return isVisited;
    }

    /**
     * Calculate the in-degree of the each node in the graph
     */
    @Override
    public Map<V,Integer> inDegree() {
        Map<V,Integer> result = new HashMap<>();
        for (V v: graph.keySet()) result.put(v, 0);       // All in-degrees are 0
        for (V from: graph.keySet()) {
            for (V to: graph.get(from)) {
                result.put(to, result.get(to) + 1);           // Increment in-degree
            }
        }
        return result;
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
