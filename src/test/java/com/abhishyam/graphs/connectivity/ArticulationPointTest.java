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

    @Before
    public void init(){
        actual1 = new HashSet<>();actual1.add(1);actual1.add(4);actual1.add(5);actual1.add(6);
        actual2 = new HashSet<>();actual2.add("C");actual2.add("D");actual2.add("E");actual2.add("F");
        actual3 = new HashSet<>();actual3.add(3);
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
}
