package com.abhishyam.graphs.cycles.directed;

import com.abhishyam.graphs.TestBase;
import com.abhishyam.graphs.cycles.CycleInGraph;
import com.abhishyam.graphs.cycles.undirected.CyclesInUnDirectedGraphi;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Abhishyam on 15-Feb,2018
 */
public class CycleInUnDirectedGraphTest extends TestBase {

    @Test
    public void testHasCyclesI(){
        CycleInGraph<Integer> cycleInGraph = new CyclesInUnDirectedGraphi<>();

        boolean actual = cycleInGraph.hasCycle(graph9);
        assertEquals(true,actual);

        cycleInGraph = new CyclesInUnDirectedGraphi<>();
        actual = cycleInGraph.hasCycle(graph1);
        assertEquals(true,actual);

        cycleInGraph = new CyclesInUnDirectedGraphi<>();
        actual = cycleInGraph.hasCycle(graph2);
        assertEquals(true,actual);

        cycleInGraph = new CyclesInUnDirectedGraphi<>();
        actual = cycleInGraph.hasCycle(graph5);
        assertEquals(true,actual);
    }

    @Test
    public void testHasCyclesII(){
        CycleInGraph<Integer> cycleInGraph = new CyclesInUnDirectedGraphi<>();

        boolean actual = cycleInGraph.hasCycle(graph10);
        assertEquals(false,actual);
    }

}
