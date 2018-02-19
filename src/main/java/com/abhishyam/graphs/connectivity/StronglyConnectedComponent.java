package com.abhishyam.graphs.connectivity;

import com.abhishyam.graphs.Graph;
import com.abhishyam.graphs.directedgraphs.DirectedGraph;

import java.util.*;

/**
 * This class will find out the strongly connected
 * components in a graph.
 *
 * Strongly connected component means, if we are able to
 * connect each vertex from one of the vertex's in that component
 * in that graph.
 *
 * Algorithm:
 * 1). find out the dfs of the given graph in finish time in decreasing order
 * 2). Reverse the graph
 * 3). Do dfs of the reversed graph by removing the elements in
 *     from list above dfs order.
 * Links:
 * https://www.youtube.com/watch?v=RpgcYiky7uw
 * https://www.geeksforgeeks.org/strongly-connected-components/
 *
 */
public class StronglyConnectedComponent<V> {

    private Graph<V> graph;

    StronglyConnectedComponent(Graph<V> graph) {
        this.graph = graph;
    }

    public List<Set<V>> connectedComponent(){
        Deque<V> dfsOfGraph = getDfsOfGraph();
        Graph<V> reversedGraph = reverseGraph();
        reversedGraph.printGraph();
        return getStrongConCompo(dfsOfGraph,reversedGraph);

    }

    /**
     * This method will traverse the graph in
     * Dfs manner and sorts the vertex's by
     * time to finish in decreasing order
     * i.e. vertex which has ended 1st will be
     * added fist.
     *
     * This is reversing the graph
     */
    private Deque<V> getDfsOfGraph() {
        Set<V> isVisited = new HashSet<>();
        Deque<V> deque = new ArrayDeque<>();

        for (Map.Entry<V, List<V>> entry : graph.getGraph().entrySet()) {
            if(!isVisited.contains(entry.getKey()))
            sortOnFinishTime(entry.getKey(),isVisited,deque);
        }
        return deque;
    }

    private void sortOnFinishTime(V node, Set<V> isVisited, Deque<V> deque) {
        isVisited.add(node);
        List<V> adjacentNodes = graph.getGraph().get(node);
        for (V adjacentNode : adjacentNodes) {
            if(!isVisited.contains(adjacentNode))
                sortOnFinishTime(adjacentNode,isVisited,deque);
        }
        deque.add(node);
    }


    private List<Set<V>> getStrongConCompo(Deque<V> dfsOfGraph, Graph<V> reversedGraph) {
        Set<V> isVisited = new HashSet<>();
        List<Set<V>> result = new ArrayList<>();
        while (!dfsOfGraph.isEmpty()){
            V node = dfsOfGraph.removeLast();
            if(!isVisited.contains(node)){
                Set<V> component = new HashSet<>();
                dfsUtil(node,reversedGraph,component,isVisited);
                result.add(component);
            }
        }

        return result;
    }

    private void dfsUtil(V node, Graph<V> reversedGraph, Set<V> component, Set<V> isVisited) {
        isVisited.add(node);
        component.add(node);
        for (V v : reversedGraph.getGraph().get(node)) {
            if(!isVisited.contains(v))
                dfsUtil(v, reversedGraph, component, isVisited);
        }

    }


    /**
     * method to reverse the whole graph.
     * This method will re-direct the
     * directed edge.
     * @return reversed graph
     */
    private Graph<V> reverseGraph() {
        Graph<V> reverseGraph = new DirectedGraph<>();
        for (Map.Entry<V, List<V>> entry : graph.getGraph().entrySet()) {
            for (V adjacentNode : entry.getValue()) {
                reverseGraph.addEdge(adjacentNode,entry.getKey());
            }
        }

        return reverseGraph;
    }
}
