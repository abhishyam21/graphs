package com.abhishyam.graphs.mst;

import com.abhishyam.disjointsets.DisjointSet;
import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.WeightedGraph;
import com.abhishyam.graphs.undirected.UnDirectedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * This class is implementation of Kruskal algorithm.
 *
 * I'm using {@link DisjointSet} to determine if cycle
 * exists in given MST.
 *
 * Step1: Sort the all the edges in increasing order by weight
 * Step2: Add all vertices to disjoint set
 * Step3: Iterate through all the edges and check if they form cycle or not
 * Step4: If no cycle add the edge to result.
 *
 * Created by Abhishyam on 20-Feb,2018
 */
public class KruskalMST<V> implements MST<V>{
    private static final Logger logger = LoggerFactory.getLogger(KruskalMST.class);

    private WeightedGraph<V> graph;

    private Comparator<UnDirectedGraph.Edge<V>> edgeWeightComparator;

    KruskalMST(WeightedGraph<V> graph) {
        this.graph = graph;
       edgeWeightComparator = Comparator.comparingInt(UnDirectedGraph.Edge::getWeight);
    }


    @Override
    public List<UnDirectedGraph.Edge<V>> minimumSpanningTree() throws BadInputException {
        emptyCheck();
        //sort the all edges based on weight
        List<UnDirectedGraph.Edge<V>> allEdges = graph.getAllEdges();
        allEdges.sort(edgeWeightComparator);
        //to check if cycle exists
        DisjointSet<V> disjointSet = new DisjointSet<>();

        //add all the edges to disjoint sets
        graph.getAllVertexes().keySet().forEach(disjointSet::makeSet);

        List<UnDirectedGraph.Edge<V>> result = new ArrayList<>();

        for (UnDirectedGraph.Edge<V> edge : allEdges) {
            V parent1 = disjointSet.findSet(edge.getVertex1().getData());
            V parent2 = disjointSet.findSet(edge.getVertex2().getData());

            if(parent1 != parent2){
                result.add(edge);
                disjointSet.union(edge.getVertex1().getData(),edge.getVertex2().getData());
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
