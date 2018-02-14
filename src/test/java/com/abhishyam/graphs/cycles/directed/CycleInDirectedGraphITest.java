package com.abhishyam.graphs.cycles.directed;

import com.abhishyam.graphs.TestBase;
import com.abhishyam.graphs.cycles.CycleInGraph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Abhishyam on 21-Jan,2018
 */
public class CycleInDirectedGraphITest extends TestBase{



    @Test
    public void testHasCyclesI(){
        CycleInGraph<Integer> cycleInGraph = new CycleInDirectedGraphI<>();

        boolean actual = cycleInGraph.hasCycle(graph9);
        assertEquals(true,actual);

        cycleInGraph = new CycleInDirectedGraphI<>();
        actual = cycleInGraph.hasCycle(graph1);
        assertEquals(true,actual);

        cycleInGraph = new CycleInDirectedGraphI<>();
        actual = cycleInGraph.hasCycle(graph2);
        assertEquals(false,actual);

        cycleInGraph = new CycleInDirectedGraphI<>();
        actual = cycleInGraph.hasCycle(graph5);
        assertEquals(false,actual);
    }

    @Test
    public void testHasCyclesII(){
        CycleInGraph<Integer> cycleInGraph = new CycleInDirectedGraphII<>();

        boolean actual = cycleInGraph.hasCycle(graph9);
        assertEquals(true,actual);

        cycleInGraph = new CycleInDirectedGraphII<>();
        actual = cycleInGraph.hasCycle(graph1);
        assertEquals(true,actual);


        cycleInGraph = new CycleInDirectedGraphII<>();
        actual = cycleInGraph.hasCycle(graph2);
        assertEquals(false,actual);


        cycleInGraph = new CycleInDirectedGraphII<>();
        actual = cycleInGraph.hasCycle(graph5);
        assertEquals(false,actual);
    }


}
