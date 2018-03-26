package com.abhishyam.graphs.backtracking;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.Edge;
import com.abhishyam.graphs.WeightedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Problem Link: https://www.geeksforgeeks.org/find-if-there-is-a-path-of-more-than-k-length-from-a-source/
 *
 * Here we gonna use backtracking to solve this problem.
 *
 * Created by Abhishyam on 19-Mar,2018
 */
public class PathMoreThanKLen<V> {

    private static final Logger logger = LoggerFactory.getLogger(PathMoreThanKLen.class);
    private List<V> path = null;

    public boolean findPathGreaterThanLenK(WeightedGraph<V> graph, int length, V startVertex) throws BadInputException {
        if(graph == null) {
            logger.error("Empty Graph had been passed");
            throw new BadInputException("Empty Graph has been passed");
        }
        else {
            int currentLen = 0;
            path = new ArrayList<>();
            List<Edge<V>> adjacentNodeList = null;
            for (Map.Entry<V, List<Edge<V>>> entry : graph.getGraph().entrySet()) {
                if(entry.getKey().equals(startVertex)){
                    logger.debug("Found startVertex in the given Graph");
                    adjacentNodeList = entry.getValue();
                    break;
                }
            }
            if(adjacentNodeList == null){
                logger.error("Didn't found the start vertex in the given graph");
                throw new BadInputException("Didn't found the start vertex in the given graph");
            }
            path.add(startVertex);
            boolean result = calLen(currentLen, length, graph, adjacentNodeList);
            logger.info(path.toString());
            return result;

        }
    }

    private boolean calLen(int currentLen, int length, WeightedGraph<V> graph, List<Edge<V>> adjacentNodeList) {
        if(currentLen >= length) return true;
        for (Edge<V> adjacentNode : adjacentNodeList) {
            if(path.contains(adjacentNode.getVertex2().getData())) continue;
            currentLen+=adjacentNode.getWeight();
            path.add(adjacentNode.getVertex2().getData());
            if(currentLen >= length) return true;
            if(calLen(currentLen,length,graph,graph.getGraph().get(adjacentNode.getVertex2().getData()))) return true;

            else {
                currentLen-=adjacentNode.getWeight();
                path.remove(path.size()-1);
            }
        }
        return false;
    }
}
