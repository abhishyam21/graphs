package com.examples.graph;

import java.util.*;

/**
 * Problem Source:https://www.techiedelight.com/arrival-departure-time-vertices-dfs/
 * Created by Rachana Rao on 3/26/2017.
 */
public class ArrivalAndDepartureTimeOfVertices<V> extends AdjacencyListGraphImpl<V> {
    private int arrival = 0;
    public ArrivalAndDepartureTimeOfVertices(Comparator<V> comparator) {
        super(comparator);
    }

    public Map<V, Node> calculateArrivalAndDeparture(){
        Map<V,Node> arrivalDepartureGraph = new HashMap<>();
        Map<V, Boolean> isVisitedMap = generateIsVisitedMap();
        getRootNodes().forEach( node -> {
            arrivalDepartureGraph.put(node,new Node(0,0));
                calculateArrivalAndDepartureUtil(arrivalDepartureGraph,node,isVisitedMap);
        });
        return arrivalDepartureGraph;
    }

    private void calculateArrivalAndDepartureUtil( Map<V, Node> arrivalDepartureGraph, V vertex, Map<V, Boolean> isVisitedMap) {
        List<V> vs = this.graph.get(vertex);
        isVisitedMap.put(vertex,true);
            for (V v : vs) {
                if(!isVisitedMap.get(v)) {
                    Node node = new Node(++arrival, 0);
                    arrivalDepartureGraph.put(v, node);
                    calculateArrivalAndDepartureUtil( arrivalDepartureGraph, v, isVisitedMap);
                }
                Node node = arrivalDepartureGraph.get(vertex);
                node.departure =arrival++;
                arrivalDepartureGraph.put(vertex,node);
            }
    }


    public static class Node{
        int arrival;
        int departure;

        Node(int arrival, int departure) {
            this.arrival = arrival;
            this.departure = departure;
        }

        @Override
        public String toString() {
            return "{" + arrival + "," + departure + "}";
        }
    }
}
