package com.examples.graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Rachana Rao on 3/25/2017.
 */
public interface Graph<V> {

    void addEdge(V from, V to);

    List<V> bfs(V v);

    List<V> dfs(V v);

    Set<V> getRootNodes();

    Map<V,Integer> inDegree();
}
