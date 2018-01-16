package com.abhishyam.graphs.topologicalsorting;

import com.abhishyam.graphs.Graph;
import com.abhishyam.graphs.indegree.InDegree;
import com.abhishyam.graphs.indegree.InDegreeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class AllTopologicalSorts<V> {
    private static final Logger log = LoggerFactory.getLogger(AllTopologicalSorts.class);
    public List<List<V>> topSort(Graph<V> graph){
        List<List<V>> result = new ArrayList<>();
        if( null == graph){
            log.info("Empty Graph is passed");
            return result;
        }

        Set<V> isVisted = new HashSet<>();
        InDegree<V> inDegree = new InDegreeImpl<>(graph);
        Map<V, Integer> inDegreeMap = inDegree.inDegree();
        List<V> list = new ArrayList<>();
        topSortUtil(isVisted,graph,inDegreeMap,list,result);
        return result;
    }

    private void topSortUtil(Set<V> isVisted, Graph<V> graph, Map<V, Integer> inDegreeMap, List<V> list, List<List<V>> result) {
        boolean isTopSortFound = false;

        for (Map.Entry<V, List<V>> entry : graph.getGraph().entrySet()) {
            //check node with zero in-degree
            if(inDegreeMap.get(entry.getKey()) == 0 && !isVisted.contains(entry.getKey())){
                for (V v : entry.getValue()) {
                    Integer counter = inDegreeMap.get(v);
                    counter--;
                    inDegreeMap.put(v,counter);
                }
                list.add(entry.getKey());
                isVisted.add(entry.getKey());
                topSortUtil(isVisted,graph,inDegreeMap,list, result);
                isVisted.remove(entry.getKey());
                list.remove(list.size()-1);

                for (V v : entry.getValue()) {
                    Integer counter = inDegreeMap.get(v);
                    counter++;
                    inDegreeMap.put(v,counter);
                }
                isTopSortFound = true;
            }
        }
        if(!isTopSortFound) {
            result.add(new ArrayList<>(list));
        }

    }
}
