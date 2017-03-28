package com.examples.test;

import com.examples.graph.AdjacencyListGraphImpl;
import com.examples.graph.Graph;
import com.examples.graph.RouteBetweenNodesImpl;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Rachana Rao on 3/28/2017.
 */
public class TestRouteBetweenNodes {
    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compare;
        System.out.println("-------------------------------------------------------");
        RouteBetweenNodesImpl<Integer> graph1 = new RouteBetweenNodesImpl<>(comparator);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 3);
        System.out.println(graph1);
        System.out.println("Path b/w nodes");
        ArrayList<Integer> route = graph1.routeBwNodes(0, 5);
        System.out.println(route.toString());
    }
}