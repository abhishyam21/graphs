package com.abhishyam.graphs.connectivity;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem Link: https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
 *
 * Basically the problem is to find if we can traverse from
 * one vertex of the graph to any other vertex of the graph.
 *
 * There are two ways to solve the problem.
 *
 * Approach 1: DFS
 * Start Dfs traversal from each vertex of the graph.
 * If each time it contains all the vertices except the
 * current one.
 * If same for evert vertex in the graph, then we can say
 * that graph is strongly connected.
 *
 * Approach2: Using Connected Components
 * Use Strongly connected components.
 *
 * Created by Abhishyam on 13-Apr,2018
 */
public class CheckIfGraphIsStronglyConnected<V> {
    private static final Logger logger = LoggerFactory.getLogger(CheckIfGraphIsStronglyConnected.class);

    private Graph<V> graph;

    public CheckIfGraphIsStronglyConnected(Graph<V> graph) {
        this.graph = graph;
    }

    public boolean isGraphConnectedi() throws BadInputException {
        if(graph == null){
            logger.error("Graph is null");
            throw new BadInputException("Graph is null");
        }
        int totalVertices = graph.getGraph().entrySet().size();
        if(totalVertices == 0){
            logger.error("Graph is Empty");
            throw new BadInputException("Graph is Empty");
        }

        if(totalVertices == 1){
            return true;
        }
        Set<V> vertices = this.graph.getGraph().keySet();
        Set<V> isVisited = new HashSet<>();
        for (V v : vertices) {
            if(!dfsUtil(totalVertices, v,isVisited)){
                return false;
            }else {
                isVisited = new HashSet<>();
            }
        }
        return true;
    }

    private boolean dfsUtil(int totalVertices, V v, Set<V> isVisited) {
        if(!isVisited.contains(v)){
            List<V> adjacentVertices = this.graph.getGraph().get(v);
            for (V adjacentVertex : adjacentVertices) {
                isVisited.add(v);
                if(!isVisited.contains(adjacentVertex))
                dfsUtil(totalVertices,adjacentVertex,isVisited);
            }
        }
        return isVisited.size() == totalVertices;
    }


    public boolean isGraphConnectedii() throws BadInputException {
        StronglyConnectedComponent<V> stronglyConnectedComponent  = new StronglyConnectedComponent<>(graph);
        List<Set<V>> connectedComponents = stronglyConnectedComponent.connectedComponent();
        return connectedComponents.size() ==1;
    }

}
