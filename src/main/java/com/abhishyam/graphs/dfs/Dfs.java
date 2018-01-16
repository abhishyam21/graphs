package com.abhishyam.graphs.dfs;

import com.abhishyam.graphs.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * This class will do depth first search
 * of the graph provided as method argument.
 */

public class Dfs<V> {
    private static final Logger log = LoggerFactory.getLogger(Dfs.class);

    public List<V> dfs(Graph<V> graph){
        if(graph == null) {
            log.info("Empty list has been passed");
            return new ArrayList<>();
        }

        Set<V> isVisited = new HashSet<>();
        Deque<V> stack = new ArrayDeque<>();
        List<V> result = new ArrayList<>();
        for (Map.Entry<V, List<V>> node : graph.getGraph().entrySet()) {
            if(isVisited.contains(node.getKey())) continue;
            stack.push(node.getKey());
            dfsUtil(graph,isVisited,stack,result);

        }
        return result;
    }

    private void dfsUtil(Graph<V> graph, Set<V> isVisited, Deque<V> stack, List<V> result) {
        while (!stack.isEmpty()){
            V node = stack.pop();
            if(isVisited.contains(node)) continue;
            isVisited.add(node);
            result.add(node);
            List<V> adjacentList = graph.getGraph().get(node);
            adjacentList.forEach(stack::push);
        }
    }

    public List<V> dfs(Graph<V> graph, V v){
        if(null == graph || null == v){
            log.info("list is empty or provided node is null");
            return new ArrayList<>();
        }

        Set<V> isVisited = new HashSet<>();
        Deque<V> stack = new ArrayDeque<>();
        List<V> result = new ArrayList<>();

        stack.push(v);
        while (!stack.isEmpty()){
            V node = stack.pop();
            if(isVisited.contains(node)) continue;

            isVisited.add(node);
            result.add(node);
            List<V> adjacentList = graph.getGraph().get(node);
            if(adjacentList != null)
                adjacentList.forEach(stack::push);
            }

        return result;
    }
}
