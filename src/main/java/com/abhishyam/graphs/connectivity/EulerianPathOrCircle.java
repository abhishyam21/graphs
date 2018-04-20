package com.abhishyam.graphs.connectivity;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.Vertex;
import com.abhishyam.graphs.WeightedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Problem Link: https://www.geeksforgeeks.org/eulerian-path-and-circuit/
 * <p>
 * Go through the readme file
 * <p>
 * Created by Abhishyam on 20-Apr,2018
 */
public class EulerianPathOrCircle<V> {
    private static final Logger logger = LoggerFactory.getLogger(EulerianPathOrCircle.class);
    private static final String GRAPH_IS_NULL = "Graph is null";

    private WeightedGraph<V> graph;

    public EulerianPathOrCircle(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    /**
     * Basically for this we need to check if given graph
     * is strongly connected and degree of all the vertices
     * is even.
     * To check if connected do the dfs traversal.
     */
    public boolean isEulerianGraph() throws BadInputException {
        if (graph == null) {
            logger.error(GRAPH_IS_NULL);
            throw new BadInputException(GRAPH_IS_NULL);
        }
        if (!isConnected()) {
            logger.error("Given Graph is Not Connected!!");
            return false;
        } else {
            logger.info("Graph is Connected");
            if (checkForDegree() != 0) {
                logger.error("Degree check failed");
                return false;
            }
        }
        return true;
    }

    public boolean hasEulerPath() throws BadInputException {
        if (graph == null) {
            logger.error(GRAPH_IS_NULL);
            throw new BadInputException(GRAPH_IS_NULL);
        }
        if (!isConnected()) {
            logger.error("Given Graph is Not Connected!!");
            return false;
        } else {
            logger.info("Graph is Connected");
            if (checkForDegree() > 2) {
                logger.error("Degree check failed");
                return false;
            }
        }
        return true;
    }

    private int checkForDegree() {
        int oddVerticesCount = 0;
        for (Map.Entry<V, Vertex<V>> entry : this.graph.getAllVertexes().entrySet()) {
            Vertex<V> vertex = entry.getValue();
            if (vertex != null) {
                List<Vertex<V>> adjacentVertexes = vertex.getAdjacentVertexes();
                if (adjacentVertexes != null && adjacentVertexes.size() % 2 != 0)
                    oddVerticesCount++;
            }
        }
        logger.info("Odd Vertices Count: {}", oddVerticesCount);
        return oddVerticesCount;
    }

    /**
     * Do Dfs traversal fo the un-directed Graph
     */
    private boolean isConnected() {
        int totalVertices = this.graph.getGraph().size();
        Vertex<V> startVertex = this.graph.getAllEdges().listIterator().next().getVertex1();
        Set<Vertex<V>> isVisited = new HashSet<>();
        Deque<Vertex<V>> stack = new ArrayDeque<>();
        stack.push(startVertex);
        while (!stack.isEmpty()) {
            Vertex<V> vertex = stack.poll();
            if (!isVisited.contains(vertex)) {
                Vertex<V> adjacentVertices = this.graph.getAllVertexes().get(vertex.getData());
                stack.addAll(adjacentVertices.getAdjacentVertexes());
                isVisited.add(vertex);
            }
        }
        return totalVertices == isVisited.size();
    }
}
