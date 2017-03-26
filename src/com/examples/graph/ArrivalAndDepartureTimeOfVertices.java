package com.examples.graph;

import java.util.*;

/**
 * Problem Source:https://www.techiedelight.com/arrival-departure-time-vertices-dfs/
 * Created by Rachana Rao on 3/26/2017.
 */
public class ArrivalAndDepartureTimeOfVertices<V> extends AdjacencyListGraphImpl<V> {
    private int arrival = -1;// initialize the counter to -1
    public ArrivalAndDepartureTimeOfVertices(Comparator<V> comparator) {
        super(comparator);
    }

    /**
     * This method traverse the graph in the dfs fashion
     *  for each parent node go though down, until it is
     *  leaf node and update the corresponding .arrival and
     *  departure timing.
     * @return Map with vertex and it's arrival and departure time
     */
    public Map<V, Node> calculateArrivalAndDeparture(){
        Map<V,Node> arrivalDepartureGraph = new HashMap<>();
        Map<V, Boolean> isVisitedMap = generateIsVisitedMap();
        //for each parent in the graph go through it's adjacent
        // vertexes and updates the arrival and departure time
        getRootNodes().forEach( node -> {
            arrivalDepartureGraph.put(node,new Node(++arrival,0));
                calculateArrivalAndDepartureUtil(arrivalDepartureGraph,node,isVisitedMap);
        });

        return arrivalDepartureGraph;
    }

    /**
     * Util function for dfs traversal
     * @param arrivalDepartureGraph map which stores the vertex and it's corresponding arrival and departure times
     * @param vertex current vertex
     * @param isVisitedMap map which stores if the vertex is visited or not
     */
    private void calculateArrivalAndDepartureUtil( Map<V, Node> arrivalDepartureGraph, V vertex, Map<V, Boolean> isVisitedMap) {

        isVisitedMap.put(vertex,true);
            for (V v : this.graph.get(vertex)) {
                if(!isVisitedMap.get(v)) {
                    Node node = new Node(++arrival, 0);
                    arrivalDepartureGraph.put(v, node);
                    calculateArrivalAndDepartureUtil( arrivalDepartureGraph, v, isVisitedMap);
                }
            }

            //update the departure timing
        Node node = arrivalDepartureGraph.get(vertex);
        node.departure =++arrival;
        arrivalDepartureGraph.put(vertex,node);
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
