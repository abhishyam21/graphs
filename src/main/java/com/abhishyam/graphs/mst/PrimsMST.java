package com.abhishyam.graphs.mst;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.WeightedGraph;
import com.abhishyam.graphs.undirected.UnDirectedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Abhishyam on 21-Feb,2018
 */
public class PrimsMST<V> implements MST<V>{

    private static final Logger logger = LoggerFactory.getLogger(PrimsMST.class);

    private WeightedGraph<V> graph;

    private Queue<UnDirectedGraph.Edge<V>> priorityQueue;

    public PrimsMST(WeightedGraph<V> graph) {
        this.graph = graph;
        Comparator<UnDirectedGraph.Edge<V>> edgeWeightComparator = Comparator.comparingInt(UnDirectedGraph.Edge::getWeight);
        priorityQueue = new PriorityQueue<>(edgeWeightComparator);

    }

    @Override
    public List<UnDirectedGraph.Edge<V>> minimumSpanningTree() throws BadInputException {

        emptyCheck();

        List<UnDirectedGraph.Edge<V>> result = new ArrayList<>();

        Set<UnDirectedGraph.Vertex<V>> unvisited = new HashSet<>();

        //add all the vertex to un-visited set
        this.graph.getAllVertexes().forEach( (key,value) -> unvisited.add(value));

        //some random vertex to start the algo
        UnDirectedGraph.Vertex<V> start = this.graph.getAllVertexes().entrySet().iterator().next().getValue();

        unvisited.remove(start);
        UnDirectedGraph.Vertex<V> vertex = start;
        while (!unvisited.isEmpty()){
            //iterate through all the neighbouring edges of the current vertex
            //and add the edge to queue if it not visited
            for (UnDirectedGraph.Edge<V> edge : vertex.getEdges()) {
                if(unvisited.contains(edge.getVertex2())){
                    priorityQueue.add(edge);
                }
            }

            UnDirectedGraph.Edge<V> edge = priorityQueue.remove();
            //Get the Correct to vertex
            UnDirectedGraph.Vertex<V> toVertex = getEdgeOtherVertex(edge, vertex);
            //if it not already added to path, then only add it
            if(unvisited.contains(toVertex))
                 result.add(edge);
            unvisited.remove(vertex);
            vertex = toVertex;
        }
        return result;
    }

    private void emptyCheck() throws BadInputException {
        if(graph == null){
            logger.error("Empty Graph has been passed");
            throw new BadInputException("Empty Graph has been passed");
        }
    }

    /**
     * We made this method because, since same vertex be to vertex in an edge.
     */
    private UnDirectedGraph.Vertex<V> getEdgeOtherVertex(UnDirectedGraph.Edge<V> edge, UnDirectedGraph.Vertex<V> vertex) {
        return edge.getVertex1().equals(vertex) ? edge.getVertex2() : edge.getVertex1();

    }
}