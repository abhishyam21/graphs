package com.abhishyam.graphs.connectivity;

import com.abhishyam.exceptions.NoVertexFound;
import com.abhishyam.graphs.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Abhishyam on 10-Apr,2018
 * <p>
 * Problem Source: https://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/
 * We need to find if there is path b/w
 * given two vertices in the graph.
 * <p>
 * Basically the current solution is just doing BFS fo the graph.
 */
public class PathBetweenTwoVertices<V> {
    private static final Logger logger = LoggerFactory.getLogger(PathBetweenTwoVertices.class);

    private Graph<V> graph;

    PathBetweenTwoVertices(Graph<V> graph) {
        this.graph = graph;
    }

    public boolean findPath(V source, V destination) throws NoVertexFound {
        checkIfNodeExists(source);
        checkIfNodeExists(destination);
        if (source == destination) {
            logger.info("Both are same vertices");
            return true;
        }
        Deque<V> stack = new LinkedList<>();
        //This is used to check if the node has been visited or not.
        //It is helpful if the graph is having cycles or self edges.
        Set<V> isVisited = new HashSet<>();
        stack.push(source);
        return dfsUtil(stack, destination,source,isVisited);
    }

    private boolean dfsUtil(Deque<V> stack, V destination, V source, Set<V> isVisited) {
        while (!stack.isEmpty()) {
            V currentNode = stack.pop();
            if(!isVisited.contains(currentNode)) {
                isVisited.add(currentNode);
                if (currentNode == destination) {
                    logger.info("Found the path b/w two nodes {} and {}.", source, destination);
                    return true;
                } else {
                    List<V> adjacentVertices = this.graph.getGraph().get(currentNode);
                    if (adjacentVertices != null)
                        stack.addAll(adjacentVertices);
                }
            }
        }
        logger.info("No Path exists b/w two nodes {} and  {}",source,destination);
        return false;
    }

    private void checkIfNodeExists(V vertex) throws NoVertexFound {
        if (vertex == null || !graph.getGraph().containsKey(vertex)) {
            logger.error("Vertex {} not present in the given graph", vertex);
            throw new NoVertexFound("Vertex " + vertex + "not present in the given graph");
        }
    }


}
