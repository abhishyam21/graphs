package com.examples.test;

import com.examples.graph.AdjacencyListGraphImpl;
import com.examples.graph.Graph;

public class TestBfsOfGraph {
    private static final Logger logger = LoggerFactory.getLogger(TestBfsOfGraph.class);
    public static void main(String[] args) {
        //Test Case 1
        Graph<Integer> graph= new AdjacencyListGraphImpl<>(Integer::compare);
        graph.addEdge(1,2); graph.addEdge(1,3); graph.addEdge(1,4);
        graph.addEdge(2,5);graph.addEdge(2,6);
        graph.addEdge(4,7); graph.addEdge(4,8);
        graph.addEdge(5,9); graph.addEdge(5,10);
        graph.addEdge(7,11); graph.addEdge(7,12);
        logger.info(graph);
        logger.info("BFS Of Graph for Test Case 1");
        logger.info(graph.bfs(2).toString());
        //Test Case 2
        logger.info("-------------------------------------------------------");
        Graph<Integer> graph1 = new AdjacencyListGraphImpl<>(Integer::compareTo);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 3);
        logger.info(graph1);
        logger.info("BFS Of Graph for Test Case 2");
        logger.info(graph1.bfs(2).toString());
    }
}
