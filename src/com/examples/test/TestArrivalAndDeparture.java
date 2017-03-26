package com.examples.test;

import com.examples.graph.ArrivalAndDepartureTimeOfVertices;
import com.examples.graph.Graph;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by Rachana Rao on 3/26/2017.
 */
public class TestArrivalAndDeparture {
    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compare;
        ArrivalAndDepartureTimeOfVertices<Integer> graph = new ArrivalAndDepartureTimeOfVertices<>(comparator);
        graph.addEdge(0,1); graph.addEdge(0,2);
        graph.addEdge(2,3); graph.addEdge(2,4);
        graph.addEdge(3,1); graph.addEdge(3,5);
        graph.addEdge(4,5); graph.addEdge(6,7);
        System.out.println(graph);
        Map<Integer, ArrivalAndDepartureTimeOfVertices.Node> integerNodeMap = graph.calculateArrivalAndDeparture();
        for (Map.Entry<Integer, ArrivalAndDepartureTimeOfVertices.Node> integerNodeEntry : integerNodeMap.entrySet()) {
            System.out.println(integerNodeEntry.getKey()+"->"+integerNodeEntry.getValue());
        }

    }
}
