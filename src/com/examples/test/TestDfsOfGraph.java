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
        logger.info(graph);
        logger.info("DFS of the graph");
        logger.info(graph.dfs(1).toString());


        //Test Case 2
        logger.info("-------------------------------------------------------");
        Graph<Integer> graph1 = new AdjacencyListGraphImpl<>(comparator);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 3);
        logger.info(graph1);
        logger.info("BFS Of Graph for Test Case 2");
        logger.info(graph1.dfs(2).toString());
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2,o1);
    }
}
