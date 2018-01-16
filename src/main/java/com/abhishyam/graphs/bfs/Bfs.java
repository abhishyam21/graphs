package com.abhishyam.graphs.bfs;

import com.abhishyam.graphs.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * This class will do Breadth first search of
 * the graph provided as method argument.
 *
 * @param <V> any directed graph
 */
public class Bfs<V> {

    private static final Logger log = LoggerFactory.getLogger(Bfs.class);

    /**
     * Bfs of the graph.
     * Here the head of the graph is considered
     * as first node which is inserted into graph.
     *
     * @param graph any @{@link Graph}
     * @return list which has bfs order
     */
    public List<V> bfs(Graph<V> graph){

            if(null == graph) {
                log.info("list is empty/null");
                return new ArrayList<>();
            }

        Optional<Map.Entry<V, List<V>>> first = graph.getGraph().entrySet().stream().findFirst();
        return first.isPresent() ? bfs(graph,first.get().getKey()):new ArrayList<>();
    }

    /**
     * Bfs of the graph by considering the vertex provided
     * by the user.
     * @param graph any @{@link Graph}
     * @param v any node in {@link Graph}
     * @return list which has bfs order
     */
    public List<V> bfs(Graph<V> graph, V v){
        if(null == graph || null == v){
            log.info("list is empty or provided node is null");
            return new ArrayList<>();
        }

        Set<V> isVisited = new HashSet<>();
        List<V> result = new ArrayList<>();

        Queue<V> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            V node = queue.poll();
            if(isVisited.contains(node)){
                continue;
            }
            isVisited.add(node);
            result.add(node);
            List<V> adjacentList = graph.getGraph().get(node);
            if(adjacentList != null)
            queue.addAll(adjacentList);

        }
        return result;
    }
}
