package com.abhishyam.graphs.connectivity;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.TestBase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Abhishyam on 20-Apr,2018
 */
public class EulerianPathOrCircleTest extends TestBase {

    @Test
    public void testEulerGraphI() throws BadInputException {
        EulerianPathOrCircle<Integer> graph = new EulerianPathOrCircle<>(weightedGraph9);
        boolean expected = graph.isEulerianGraph();
        assertFalse(expected);
        assertTrue(graph.hasEulerPath());
    }

    @Test
    public void testEulerGraphII() throws BadInputException {
        EulerianPathOrCircle<Integer> graph = new EulerianPathOrCircle<>(weightedGraph12);
        boolean expected = graph.isEulerianGraph();
        assertFalse(expected);
        assertFalse(graph.hasEulerPath());
    }

    @Test
    public void testEulerGraphIII() throws BadInputException {
        EulerianPathOrCircle<Integer> graph = new EulerianPathOrCircle<>(weightedGraph13);
        boolean expected = graph.isEulerianGraph();
        assertTrue(expected);
        assertTrue(graph.hasEulerPath());
    }

    @Test
    public void testEulerGraphIV() throws BadInputException {
        EulerianPathOrCircle<Integer> graph = new EulerianPathOrCircle<>(weightedGraph14);
        boolean expected = graph.isEulerianGraph();
        assertFalse(expected);
        assertTrue(graph.hasEulerPath());
    }

    @Test
    public void testEulerGraphV() throws BadInputException {
        EulerianPathOrCircle<Integer> graph = new EulerianPathOrCircle<>(weightedGraph15);
        boolean expected = graph.isEulerianGraph();
        assertFalse(expected);
        assertFalse(graph.hasEulerPath());
    }

    @Test
    public void testEulerGraphVI() throws BadInputException {
        EulerianPathOrCircle<Integer> graph = new EulerianPathOrCircle<>(weightedGraph16);
        boolean expected = graph.isEulerianGraph();
        assertTrue(expected);
        assertTrue(graph.hasEulerPath());
    }

}
