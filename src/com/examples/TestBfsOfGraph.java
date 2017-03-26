package com.examples;

import com.examples.graph.AdjacencyListGraphImpl;
import com.examples.graph.Graph;

public class TestBfsOfGraph {

    public static void main(String[] args) {
        //Test Case 1
        Graph<Integer> graph= new AdjacencyListGraphImpl<>();
        graph.addEdge(1,2); graph.addEdge(1,3); graph.addEdge(1,4);
        graph.addEdge(2,5);graph.addEdge(2,6);
        graph.addEdge(4,7); graph.addEdge(4,8);
        graph.addEdge(5,9); graph.addEdge(5,10);
        graph.addEdge(7,11); graph.addEdge(7,12);
        System.out.println(graph);
        System.out.println("BFS Of Graph for Test Case 1");
        System.out.println(graph.bfs(1).toString());
        //Test Case 2
        System.out.println("-------------------------------------------------------");
        Graph<Integer> graph1 = new AdjacencyListGraphImpl<>();
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 3);
        System.out.println(graph1);
        System.out.println("BFS Of Graph for Test Case 2");
        System.out.println(graph1.bfs(2).toString());
    }
}
