package com.abhishyam.graphs.mst;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.Edge;
import com.abhishyam.graphs.Vertex;
import com.abhishyam.graphs.WeightedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Abhishyam on 21-Feb,2018
 */
public class PrimsMST<V> implements MST<V>{

    private static final Logger logger = LoggerFactory.getLogger(PrimsMST.class);

    private WeightedGraph<V> graph;

    private Queue<Edge<V>> priorityQueue;

    public PrimsMST(WeightedGraph<V> graph) {
        this.graph = graph;
        Comparator<Edge<V>> edgeWeightComparator = Comparator.comparingInt(Edge::getWeight);
        priorityQueue = new PriorityQueue<>(edgeWeightComparator);

    }

    @Override
    public List<Edge<V>> minimumSpanningTree() throws BadInputException {

        emptyCheck();

        List<Edge<V>> result = new ArrayList<>();

        Set<Vertex<V>> unvisited = new HashSet<>();

        //add all the vertex to un-visited set
        this.graph.getAllVertexes().forEach( (key,value) -> unvisited.add(value));

        //some random vertex to start the algo
        Vertex<V> start = this.graph.getAllVertexes().entrySet().iterator().next().getValue();

        unvisited.remove(start);
        Vertex<V> vertex = start;
        while (!unvisited.isEmpty()){
            //iterate through all the neighbouring edges of the current vertex
            //and add the edge to queue if it not visited
            for (Edge<V> edge : vertex.getEdges()) {
                if(unvisited.contains(edge.getVertex2())){
                    priorityQueue.add(edge);
                }
            }

            Edge<V> edge = priorityQueue.remove();
            //Get the Correct to vertex
            Vertex<V> toVertex = getEdgeOtherVertex(edge, vertex);
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
    private Vertex<V> getEdgeOtherVertex(Edge<V> edge, Vertex<V> vertex) {
        return edge.getVertex1().equals(vertex) ? edge.getVertex2() : edge.getVertex1();

    }
}