package com.examples.test;

import com.examples.graph.RouteBetweenNodesImpl;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Rachana Rao on 3/28/2017.
 */
public class TestRouteBetweenNodes {
    private static final Logger logger = LoggerFactory.getLogger(TestRouteBetweenNodes.class);
    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compare;
        logger.info("-------------------------------------------------------");
        RouteBetweenNodesImpl<Integer> graph = new RouteBetweenNodesImpl<>(comparator);
        graph.addEdge(0,1); graph.addEdge(0,2);
        graph.addEdge(2,3); graph.addEdge(2,4);
        graph.addEdge(3,1); graph.addEdge(3,5);
        graph.addEdge(4,5); graph.addEdge(6,7);
        logger.info(graph);
        logger.info("Path b/w nodes");
        ArrayList<Integer> route = graph.routeBwNodes( 0,3);
        logger.info(route.toString());
    }
}
