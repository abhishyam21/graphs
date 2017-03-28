package com.examples.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This problem is taken from Cracking the coding interview book
 * Created by Rachana Rao on 3/28/2017.
 */
public class RouteBetweenNodesImpl<V> extends AdjacencyListGraphImpl<V>{
    public RouteBetweenNodesImpl(Comparator<V> comparator) {
        super(comparator);
    }
    public ArrayList<V> routeBwNodes(V from, V to){
        ArrayList<V> route = new ArrayList<V>();
        if(from == to) return route;
        List<V> adjacentList = this.graph.get(from);
        if(adjacentList.size() ==0) return route;
        dfsUtil(adjacentList,to,route);
        if(route.size()>0){
            route.add(0,from);
        }
        return route;
    }

    private boolean dfsUtil(List<V> adjacentList, V to, ArrayList<V> route) {
        if (adjacentList.size() == 0) return false;
        for (V v : adjacentList) {
            if (adjacentList.contains(to)) {
                route.add(to);
                return true;
            }
            route.add(v);
            if (dfsUtil(this.graph.get(v), to, route)) {
                return true;
            } else route.remove(v);
        }

        return false;
    }
}
