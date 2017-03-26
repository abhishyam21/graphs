package com.examples.graph;

import java.util.*;

/**
 * Created by Rachana Rao on 3/25/2017.
 */
public class AdjacencyListGraphImpl<V> implements Graph<V>{
    Map<V,List<V>> graph;//map which stores vertex and list of  vertexes connected
    Comparator<V> comparator;

    public AdjacencyListGraphImpl(Comparator<V> comparator) {
        graph = new HashMap<>();
        this.comparator = comparator;
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
     * Create the isVisited map.
     *  IsVisited Map, contains all the vertex and each
     *  vertex is mapped with false flag, so that it indicates
     *  that particular vertex is not visited
     * @return map of vertex and false flag set for each vertex
     */
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
