package com.abhishyam.graphs.mst;

import com.abhishyam.disjointsets.DisjointSet;
import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.Edge;
import com.abhishyam.graphs.Vertex;
import com.abhishyam.graphs.WeightedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Abhishyam on 24-Feb,2018
 */
public class BoruvkasMST<V> implements MST<V>{

    private static final Logger logger = LoggerFactory.getLogger(BoruvkasMST.class);

    private WeightedGraph<V> graph;

    private DisjointSet<Vertex<V>> disjointSet;


    BoruvkasMST(WeightedGraph<V> graph) {
        this.graph = graph;
        disjointSet = new DisjointSet<>();
    }

    @Override
    public List<Edge<V>> minimumSpanningTree() throws BadInputException {
        emptyCheck();

        //add all the vertices to disjoint set
        this.graph.getAllVertexes().forEach((key,val)-> disjointSet.makeSet(val));

        Map<Vertex<V>, Edge<V>> cheapestWeightEdge = new HashMap<>();
        List<Edge<V>> result = new ArrayList<>();
        int numOfSets = this.graph.getAllVertexes().keySet().size();

        while (numOfSets >1) {
            System.out.println(numOfSets);
            this.graph.getAllEdges().forEach( edge -> {
                Vertex<V> parent1 = disjointSet.findSet(edge.getVertex1());
                Vertex<V> parent2 = disjointSet.findSet(edge.getVertex2());

                if(!parent1.equals(parent2)){
                    Edge<V> edge1 = cheapestWeightEdge.get(parent1);
                    Edge<V> edge2 = cheapestWeightEdge.get(parent2);
                    if(edge1 == null || edge1.getWeight() > edge.getWeight())
                        cheapestWeightEdge.put(parent1, edge);

                    if(edge2 == null || edge2.getWeight() > edge.getWeight())
                        cheapestWeightEdge.put(parent2, edge);
                }
            });

            for (Map.Entry<V, Vertex<V>> entry : this.graph.getAllVertexes().entrySet()) {
                Edge<V> edge = cheapestWeightEdge.get(entry.getValue());
                if(edge != null){
                    Vertex<V> parent1 = disjointSet.findSet(edge.getVertex1());
                    Vertex<V> parent2 = disjointSet.findSet(edge.getVertex2());
                    if(!parent1.equals(parent2)){
                        //add the minimum edge to result
                        result.add(edge);
                        //union those vertexes
                        disjointSet.union(edge.getVertex1(), edge.getVertex2());
                        numOfSets--;
                    }
                }
            }

        }
        return result;
    }

    private void emptyCheck() throws BadInputException {
        if(graph == null){
            logger.error("Empty Graph has been passed");
            throw new BadInputException("Empty Graph has been passed");
        }
    }
}
