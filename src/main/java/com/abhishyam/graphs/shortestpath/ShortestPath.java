package com.abhishyam.graphs.shortestpath;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.WeightedGraph;

import java.util.Map;

/**
 * Created by Abhishyam on 19-Mar,2018
 */
public interface ShortestPath<V> {
    Map<V,Integer> findShortestPath(WeightedGraph<V> graph, V source) throws BadInputException;
}
