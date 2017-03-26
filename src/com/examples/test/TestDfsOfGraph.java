package com.examples.test;

import com.examples.graph.AdjacencyListGraphImpl;
import com.examples.graph.Graph;

import java.util.Comparator;

/**
 * Created by Rachana Rao on 3/26/2017.
 */
public class TestDfsOfGraph implements Comparator<Integer>{
    public static void main(String[] args) {
        Comparator<Integer> comparator = ( num1, num2) -> Integer.compare(num2, num1);
        Graph<Integer> graph = new AdjacencyListGraphImpl<>(comparator);
        graph.addEdge(1,2); graph.addEdge(1,7); graph.addEdge(1,8);
        graph.addEdge(2,3); graph.addEdge(2,6);
        graph.addEdge(3,4);graph.addEdge(3,5);
        graph.addEdge(8,9);graph.addEdge(8,12);
        graph.addEdge(9,10); graph.addEdge(9,11);
        System.out.println(graph);
        System.out.println("DFS of the graph");
        System.out.println(graph.dfs(1).toString());


        //Test Case 2
        System.out.println("-------------------------------------------------------");
        Graph<Integer> graph1 = new AdjacencyListGraphImpl<>(comparator);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 3);
        System.out.println(graph1);
        System.out.println("BFS Of Graph for Test Case 2");
        System.out.println(graph1.dfs(2).toString());
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2,o1);
    }
}
