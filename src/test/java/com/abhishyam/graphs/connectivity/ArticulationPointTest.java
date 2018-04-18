package com.abhishyam.graphs.connectivity;

import com.abhishyam.graphs.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Abhishyam on 18-Apr,2018
 */
public class ArticulationPointTest extends TestBase {

    private Set<Integer> actual1;
    private Set<String> actual2;
    private Set<Integer> actual3;
    private Set<Integer> actual4;
    private Set<Integer> actual5;
    private Set<Integer> actual6;

    @Before
    public void init(){
        actual1 = new HashSet<>();actual1.add(1);actual1.add(4);actual1.add(5);actual1.add(6);
        actual2 = new HashSet<>();actual2.add("C");actual2.add("D");actual2.add("E");actual2.add("F");
        actual3 = new HashSet<>();actual3.add(3);
        actual4 = new HashSet<>();actual4.add(0);actual4.add(3);
        actual5 = new HashSet<>();actual5.add(1);actual5.add(2);
        actual6 = new HashSet<>();actual6.add(1);
    }

    @Test
    public void test1(){
        ArticulationPoint<Integer> articulationPoint = new ArticulationPoint<>(weightedGraph6);
        Set<Integer> expected = articulationPoint.articulationPoints();
        Assert.assertEquals(expected,actual1);
    }

    @Test
    public void test2(){
        ArticulationPoint<String> articulationPoint = new ArticulationPoint<>(weightedGraph7);
        Set<String> expected = articulationPoint.articulationPoints();
        Assert.assertEquals(expected,actual2);
    }

    @Test
    public void test3(){
        ArticulationPoint<Integer> articulationPoint = new ArticulationPoint<>(weightedGraph8);
        Set<Integer> expected = articulationPoint.articulationPoints();
        Assert.assertEquals(expected,actual3);
    }

    @Test
    public void test4(){
        ArticulationPoint<Integer> articulationPoint = new ArticulationPoint<>(weightedGraph9);
        Set<Integer> expected = articulationPoint.articulationPoints();
        Assert.assertEquals(expected,actual4);
    }

    @Test
    public void test5(){
        ArticulationPoint<Integer> articulationPoint = new ArticulationPoint<>(weightedGraph10);
        Set<Integer> expected = articulationPoint.articulationPoints();
        Assert.assertEquals(expected,actual5);
    }

    @Test
    public void test6(){
        ArticulationPoint<Integer> articulationPoint = new ArticulationPoint<>(weightedGraph11);
        Set<Integer> expected = articulationPoint.articulationPoints();
        Assert.assertEquals(expected,actual6);
    }
}
