package com.examples.graph;

import java.util.List;

/**
 * Created by Rachana Rao on 3/25/2017.
 */
public interface Graph<V> {

    void addEdge(V from, V to);

    List<V> bfs(V v);
}
