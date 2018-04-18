package com.abhishyam.graphs.connectivity;

import com.abhishyam.graphs.Vertex;
import com.abhishyam.graphs.WeightedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem link : https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
 * <p>
 * This is applicable for Un-directed graph
 * Articulation point:
 * -------------------
 * An articulation point is a node/vertex in a graph which by
 * removing the node/vertex including edges also from graph
 * will separates the connected graph into two dis-connected
 * graph components.
 * <p>
 * Basically there ways to solve the problem:
 * <p>
 * APPROACH 1: Using BFS/DFS approach
 * Start removing each vertex from the graph
 * each time we remove, perform BFS/DFS and
 * check if all the vertices are visited in traversal.
 * If not then that point is the articulation point.
 * Time complexity : O(V*(V+E))
 * <p>
 * APPROACH 2: Using DFS Tree
 * Do DFS traversal of the given graph in tree fashion.
 * The tree construction is based on traversal time based.
 *
 *  We can say a vertex is articulation point on 2 conditions
 *  1). If it is root node and it has 2 or more distinct nodes
 *  2). if he visited time of current node is less than the
 *  adjacent nodes lowest time.
 *
 *  So we gonna calculate the above points for all the nodes
 *  and add them to the articulation list.
 * <p>
 * Created by Abhishyam on 18-Apr,2018
 */
public class ArticulationPoint<V> {

    private static final Logger logger = LoggerFactory.getLogger(ArticulationPoint.class);

    private WeightedGraph<V> graph;

    private int time;

    public ArticulationPoint(WeightedGraph<V> graph) {
        this.graph = graph;
        time = 0;
    }

    public Set<V> articulationPoints() {
        Set<Vertex<V>> visited = new HashSet<>();
        Set<V> articulationPoints = new HashSet<>();

        Map<Vertex<V>, Integer> visitedTime = new HashMap<>();
        Map<Vertex<V>, Integer> lowTime = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> parent = new HashMap<>();

        Vertex<V> startVertex = this.graph.getAllEdges().listIterator().next().getVertex1();

        dfs(visited, articulationPoints, visitedTime, lowTime, parent, startVertex);
        return articulationPoints;
    }

    private void dfs(Set<Vertex<V>> visited, Set<V> articulationPoints,
                     Map<Vertex<V>, Integer> visitedTime, Map<Vertex<V>, Integer> lowTime,
                     Map<Vertex<V>, Vertex<V>> parent, Vertex<V> vertex) {

        visited.add(vertex);
        visitedTime.put(vertex, time);
        lowTime.put(vertex, time);
        time++;

        int childCount = 0;
        boolean isArticulationPoint = false;
        for (Vertex<V> adjacentVertex : vertex.getAdjacentVertexes()) {
            //if adjacentVertex is same as parent then just ignore this vertex
            if(adjacentVertex.equals(parent.get(vertex))) continue;

            //if adjacentVertex has not been visited, then process it
            if(!visited.contains(adjacentVertex)){
                parent.put(adjacentVertex, vertex);
                childCount++;
                dfs(visited,articulationPoints,visitedTime,lowTime,parent,adjacentVertex);

                //1st condition
                if(visitedTime.get(vertex) <= lowTime.get(adjacentVertex)){
                    isArticulationPoint = true;
                }else {
                    lowTime.put(vertex, Math.min(lowTime.get(vertex), lowTime.get(adjacentVertex)));
                }

            }else { //this condition indicates the back-edge case in graph
                //in the current input graph edge from B->C and G->E are back-edges
                //which will fall under this condition.
                lowTime.put(vertex, Math.min(lowTime.get(vertex), visitedTime.get(adjacentVertex)));
            }

            //Check if any one of the
            if(isRootNode(parent,vertex, childCount) || (parent.get(vertex) != null && isArticulationPoint))
                articulationPoints.add(vertex.getData());
        }
    }

    /**
     * Method to check if the given vertex is root
     * node and it has two distinct child.
     */
    private boolean isRootNode(Map<Vertex<V>, Vertex<V>> parent, Vertex<V> vertex, int childCount) {
        return parent.get(vertex) == null && childCount>=2;
    }
}
