package com.abhishyam.graphs.topologicalsorting;

import com.abhishyam.graphs.Graph;
import com.abhishyam.graphs.indegree.InDegree;
import com.abhishyam.graphs.indegree.InDegreeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * This is another algorithm for finding
 * the topological sorting of elements.
 *
 * This algorithm works on In-Degree of Nodes.
 *
 * The First node in the topological ordering will
 * be node with In-Degree Zero. So start traversing
 * the graph and find the node with In-Degree Zero,
 * then add that element to result. Now reduce the
 * In-Degree for those adjacent nodes by one.
 * If anyone of the node is having In-Degree Zero
 * add that node to result. Repeat till all nodes
 * are traversed.
 *
 * url:https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
 */
public class KahnsAlg<V> implements TopologicalSort<V>{
    private static final Logger log = LoggerFactory.getLogger(KahnsAlg.class);

    private Graph<V> graph;
    private InDegree<V> inDegree;

    KahnsAlg(Graph<V> graph) {
        this.graph = graph;
        inDegree = new InDegreeImpl<>(graph);
    }

    @Override
    public List<V> topologicalSort(){
        if (graph == null) {
            log.info("Empty list is passed");
            return new ArrayList<>();
        }

        return kahnsTopSortUti();
    }

    private List<V> kahnsTopSortUti() {

        Map<V, Integer> inDegreeMap = inDegree.inDegree();
        Queue<V> queue = new LinkedList<>();

        //add noes with Zero In-Degree
        for (Map.Entry<V, Integer> node : inDegreeMap.entrySet()) {
            if(node.getValue() == 0) queue.add(node.getKey());
        }

        List<V> result = new ArrayList<>();

        if(queue.isEmpty()){
            log.info("Graph is Not DAG, there is no Node with In-Degree Zero");
           return result;
        }

        while (!queue.isEmpty()){
            V node = queue.poll();
            result.add(node);
            List<V> adjacentNodes = graph.getGraph().get(node);
            for (V adjacentNode : adjacentNodes) {
                Integer count = inDegreeMap.get(adjacentNode);
                count--;
                if(count == 0) {
                    queue.add(adjacentNode);
                }
                inDegreeMap.put(adjacentNode,count);
            }
        }
        return result;
    }
}
