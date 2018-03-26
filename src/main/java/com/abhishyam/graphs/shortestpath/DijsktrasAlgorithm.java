package com.abhishyam.graphs.shortestpath;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.Edge;
import com.abhishyam.graphs.WeightedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static java.lang.Integer.MAX_VALUE;

/**
 *
 * Problem Link: https://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 *
 * Video Link: https://www.youtube.com/watch?v=WN3Rb9wVYDY
 *
 * Algorithm:
 * Starting from Source iterate through all the vertices in the graph
 * by updating the weight or distance from source to adjacent nodes.
 *
 * Created by Abhishyam on 19-Mar,2018
 */
public class DijsktrasAlgorithm<V> implements ShortestPath<V>{

    private static final Logger logger = LoggerFactory.getLogger(DijsktrasAlgorithm.class);
    static final String BAD_INPUT_GRAPH_CAN_T_BE_NULL = "Bad Input. Graph Can't be null";

    @Override
    public Map<V,Integer> findShortestPath(WeightedGraph<V> graph, V source) throws BadInputException {
        //basic null validation
        if(graph == null){
            logger.error(BAD_INPUT_GRAPH_CAN_T_BE_NULL);
            throw new BadInputException(BAD_INPUT_GRAPH_CAN_T_BE_NULL);
        }

        //check if source vertex is there or not in the given graph
        List<Edge<V>> adjacentNodeList = null;
        for (Map.Entry<V, List<Edge<V>>> entry : graph.getGraph().entrySet()) {
            if (entry.getKey().equals(source)) {
                adjacentNodeList = entry.getValue();
                break;
            }
        }

        //if source vertex is missing, then throw exception
            if(adjacentNodeList == null){
                logger.error(BAD_INPUT_GRAPH_CAN_T_BE_NULL);
                throw new BadInputException(BAD_INPUT_GRAPH_CAN_T_BE_NULL);
            }

        Set<V> visited = new HashSet<>();
        Map<V,Integer> vertexToWeightMap = populateVertexWeight(graph,source);
        shortestPathUtil(visited,graph,vertexToWeightMap,source);
        return vertexToWeightMap;
    }


    private void shortestPathUtil(Set<V> visited, WeightedGraph<V> graph,
                                  Map<V, Integer> vertexToWeightMap, V source) {

            //Get the adjacent vertices of source vertex
            List<Edge<V>> adjacentNodes = graph.getGraph().get(source);
            //if adjacent nodes is empty, then we reached the end of the graph
            if(adjacentNodes != null) {
                Integer shortestWeight = vertexToWeightMap.get(source);
                //Vertex to store the shortest weight vertex
                V nextShortestSource = null;
                Integer minWeight = MAX_VALUE;
                //iterate through all adjacent nodes
                for (Edge<V> adjacentNode : adjacentNodes) {
                    //get the node is already visited, then just skip it
                    if (visited.contains(adjacentNode.getVertex2().getData())) continue;
                    int actualWeight = adjacentNode.getWeight();
                    int tempWeight = shortestWeight + actualWeight;
                    //if weight of the current vertex is greater than tempWeight, then update the
                    //weight with tempWeight.
                    if (tempWeight < vertexToWeightMap.get(adjacentNode.getVertex2().getData())) {
                        vertexToWeightMap.put(adjacentNode.getVertex2().getData(), tempWeight);
                    }

                    //code to find the min weight vertex
                    if (vertexToWeightMap.get(adjacentNode.getVertex2().getData()) < minWeight) {
                        minWeight = vertexToWeightMap.get(adjacentNode.getVertex2().getData());
                        nextShortestSource = adjacentNode.getVertex2().getData();
                    }
                }
                //store the visited vertexes
                visited.add(source);
                shortestPathUtil( visited, graph, vertexToWeightMap, nextShortestSource);
            }
    }


    /**
     * This method will populate the distance/weights of all vertexes
     * For source vertex weight/distance will be ZERO.
     *
     */
    private Map<V, Integer> populateVertexWeight(WeightedGraph<V> graph, V source) {
        Map<V,Integer> vertexToWeightMap = new HashMap<>();
        for (Map.Entry<V, List<Edge<V>>> entry : graph.getGraph().entrySet()) {
            vertexToWeightMap.put(entry.getKey(), MAX_VALUE);
        }
        vertexToWeightMap.put(source,0);
        return vertexToWeightMap;
    }
}
