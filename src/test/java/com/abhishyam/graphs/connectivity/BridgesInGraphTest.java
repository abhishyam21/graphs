package com.abhishyam.graphs.connectivity;

import com.abhishyam.graphs.Edge;
import com.abhishyam.graphs.TestBase;
import com.abhishyam.graphs.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by Abhishyam on 19-Apr,2018
 */
public class BridgesInGraphTest extends TestBase {
    private Set<Edge<Integer>> actual1;
    private Set<Edge<String>>actual2;
    private Set<Edge<Integer>> actual3;
    private Set<Edge<Integer>> actual4;
    private Set<Edge<Integer>> actual5;
    private Set<Edge<Integer>> actual6;
    private Vertex<Integer> vertex1, vertex2, vertex3, vertex4, vertex5, vertex6, vertex7, vertex8, vertex9, vertex0;
    private Vertex<String> vertexA, vertexB, vertexC, vertexD, vertexE, vertexF, vertexG, vertexH, vertexI, vertexJ;
    private Comparator<String> stringComparator = Comparator.naturalOrder();

    @Before
    public void init(){
        vertex0 = new Vertex<>(0);vertex1 = new Vertex<>(1);vertex2 = new Vertex<>(2);
        vertex3 = new Vertex<>(3);
        vertex4 = new Vertex<>(4);vertex5 = new Vertex<>(5);vertex6 = new Vertex<>(6);
        vertex7 = new Vertex<>(7);vertex8 = new Vertex<>(8);vertex9 = new Vertex<>(9);

        vertexC = new Vertex<>("C"); vertexD = new Vertex<>("D"); vertexF = new Vertex<>("F");
        vertexH = new Vertex<>("H"); vertexE = new Vertex<>("E");

        actual1 = new HashSet<>();actual1.add(new Edge<>(vertex4,vertex5));actual1.add(new Edge<>(vertex6,vertex8));actual1.add(new Edge<>(vertex1,vertex4));
        actual2 = new LinkedHashSet<>();actual2.add(new Edge<>(vertexD,vertexE));actual2.add(new Edge<>(vertexC, vertexD));actual2.add(new Edge<>(vertexF,vertexH));
        actual3 = new HashSet<>();actual3.add(new Edge<>(vertex3,vertex5));
        actual4 = new HashSet<>();actual4.add(new Edge<>(vertex0,vertex3));actual4.add(new Edge<>(vertex3,vertex4));
        actual5 = new HashSet<>();actual5.add(new Edge<>(vertex2,vertex3));actual5.add(new Edge<>(vertex1,vertex2));actual5.add(new Edge<>(vertex0,vertex1));
        actual6 = new HashSet<>();actual6.add(new Edge<>(vertex1,vertex6));
    }

    @Test
    public void test1(){
        BridgesInGraph<Integer> bridgesInGraph = new BridgesInGraph<>(weightedGraph6);
        Set<Edge<Integer>> expected = bridgesInGraph.findBridgesInGraph();
       Assert.assertEquals(expected,actual1);
    }

    @Test
    public void test2(){
       BridgesInGraph<String> bridgesInGraph = new BridgesInGraph<>(weightedGraph7);
              Set<Edge<String>> expected = bridgesInGraph.findBridgesInGraph();
              Assert.assertEquals(expected,actual2);

    }

    @Test
    public void test3(){
        BridgesInGraph<Integer> bridgesInGraph = new BridgesInGraph<>(weightedGraph8);
        Set<Edge<Integer>> expected = bridgesInGraph.findBridgesInGraph();
        Assert.assertEquals(expected,actual3);
    }

    @Test
    public void test4(){
        BridgesInGraph<Integer> bridgesInGraph = new BridgesInGraph<>(weightedGraph9);
        Set<Edge<Integer>> expected = bridgesInGraph.findBridgesInGraph();
        Assert.assertEquals(expected,actual4);
    }

    @Test
    public void test5(){
        BridgesInGraph<Integer> bridgesInGraph = new BridgesInGraph<>(weightedGraph10);
        Set<Edge<Integer>> expected = bridgesInGraph.findBridgesInGraph();
        Assert.assertEquals(expected,actual5);
    }

    @Test
    public void test6(){
        BridgesInGraph<Integer> bridgesInGraph = new BridgesInGraph<>(weightedGraph11);
        Set<Edge<Integer>> expected = bridgesInGraph.findBridgesInGraph();
        Assert.assertEquals(expected,actual6);
    }
}
