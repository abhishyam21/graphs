package com.abhishyam.disjointsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet<K> {

    private static final Logger log = LoggerFactory.getLogger(DisjointSet.class);

    private Map<K,Node<K>> map = new HashMap<>();

    /**
     * This method will create set of
     * individual elements
     * @param data data in that node
     */
    public void makeSet(K data){
        Node<K> node = new Node<>();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data,node);
    }

    /**
     * This method will return the representative of
     * the set.
     * @param data data of the element to find
     * @return data of the representative
     */
    public K findSet(K data){
        Node<K> node = map.get(data);
        if(node == null){
            log.warn("No data found");
            return null;
        }else {
            return findSet(node).getData();
        }
    }

    private Node<K> findSet(Node<K> node) {
        return (node.getParent() == node) ? node.getParent() :
        findSet(node.getParent());
    }

    public boolean union(K data1, K data2){
        Node<K> node1 = map.get(data1);
        Node<K> node2 = map.get(data2);
        if(node1 == null){
            log.info("Null data passed for data1");return false;
        }
        if(node2 == null){
            log.info("Null data passed for data2");return false;
        }

        //Check if parents of both the nodes are same
        Node<K> parent1 = findSet(node1);
        Node<K> parent2 = findSet(node2);
        if(parent1 == parent2)
            return false;

        //if not check of ranks of both sets.
        //set with more rank will represents the whole set
        if(parent1.getRank() >= parent2.rank){
            parent1.rank = (parent1.getRank() == parent2.getRank()) ? parent1.getRank()+1: parent1.getRank();
            parent2.parent =parent1;
        }else {
            parent1.parent = parent2;
        }
        return true;
    }

    class Node<N>{
        private N data;
        private Node<N> parent;
        private int rank;

        N getData() {
            return data;
        }

        int getRank() {
            return rank;
        }

        Node<N> getParent() {
            return parent;
        }
    }
}
