package com.abhishyam.graphs.shortestpath;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.TestBase;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Abhishyam on 21-Mar,2018
 */
public class ShortestPathTest extends TestBase{

    private ShortestPath<Integer> integerShortestPath;
    private ShortestPath<String> stringShortestPath;

    private Map<Integer,Integer> expected1;
    private Map<Integer,Integer> expected2;
    private Map<Integer,Integer> expected3;

    @Before
    public void init(){
        expected1 = new HashMap<>();
        expected1.put(0,0);
        expected1.put(1,4);
        expected1.put(2,12);
        expected1.put(3,19);
        expected1.put(4,21);
        expected1.put(5,11);
        expected1.put(6,9);
        expected1.put(7,8);
        expected1.put(8,14);

        expected2 = new HashMap<>();
        expected2.put(0,0);
        expected2.put(1,10);
        expected2.put(2,6);
        expected2.put(3,5);

        expected3 = new HashMap<>();
        expected3.put(0,0);
        expected3.put(1,-1);
        expected3.put(2,2);
        expected3.put(3,-2);
        expected3.put(4,1);

    }

    @Test
    public void testDijsktrasAlgorithm() throws BadInputException {
        integerShortestPath = new DijsktrasAlgorithm<>();
        Map<Integer, Integer> actual1 = integerShortestPath.findShortestPath(weightedGraph4, 0);
        assertEquals(actual1,expected1);

        actual1 = integerShortestPath.findShortestPath(weightedGraph3, 0);
        assertEquals(actual1,expected2);

    }

    @Test
    public void testBellmanFordAlgorithm() throws BadInputException {
        integerShortestPath = new BellmanFordAlgorithm<>();
        Map<Integer, Integer> actual1 = integerShortestPath.findShortestPath(weightedGraph4, 0);
        assertEquals(expected1,actual1);

        actual1 = integerShortestPath.findShortestPath(weightedGraph3, 0);
        assertEquals(expected2,actual1);

        actual1 = integerShortestPath.findShortestPath(weightedGraph5, 0);
        assertEquals(expected3,actual1);
    }
}
