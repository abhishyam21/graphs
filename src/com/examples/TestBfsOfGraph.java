package com.examples;

import com.examples.graph.AdjacencyListGraphImpl;
import com.examples.graph.Graph;

public class TestBfsOfGraph {

    public static void main(String[] args) {
        Graph<Integer> graph= new AdjacencyListGraphImpl<>();
        graph.addEdge(1,2); graph.addEdge(1,3); graph.addEdge(1,4);
        graph.addEdge(2,5);graph.addEdge(2,6);
        graph.addEdge(4,7); graph.addEdge(4,8);
        graph.addEdge(5,9); graph.addEdge(5,10);
        graph.addEdge(7,11); graph.addEdge(7,12);
        System.out.println(graph);
        System.out.println("BFS Of Graph");
        System.out.println(graph.bfs(1).toString());
    }
}
