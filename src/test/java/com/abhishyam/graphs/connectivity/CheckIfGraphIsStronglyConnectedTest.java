package com.abhishyam.graphs.connectivity;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.Graph;
import com.abhishyam.graphs.TestBase;
import com.abhishyam.graphs.directedgraphs.DirectedGraph;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Abhishyam on 13-Apr,2018
 */
public class CheckIfGraphIsStronglyConnectedTest extends TestBase {

    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    @Test(expected = BadInputException.class)
    public void testExceptioni() throws BadInputException {
        CheckIfGraphIsStronglyConnected<Integer> integerCheckIfGraphIsStronglyConnected = new CheckIfGraphIsStronglyConnected<>(null);
        integerCheckIfGraphIsStronglyConnected.isGraphConnectedi();
    }

    @Test(expected = BadInputException.class)
    public void testExceptionii() throws BadInputException {
        CheckIfGraphIsStronglyConnected<Integer> integerCheckIfGraphIsStronglyConnected = new CheckIfGraphIsStronglyConnected<>(null);
        integerCheckIfGraphIsStronglyConnected.isGraphConnectedii();
    }

    @Test
    public void test1() throws BadInputException {
        CheckIfGraphIsStronglyConnected<Integer> graph = new CheckIfGraphIsStronglyConnected<>(graph11);
        Assert.assertEquals(TRUE,graph.isGraphConnectedi());
        Assert.assertEquals(TRUE,graph.isGraphConnectedii());
        graph = new CheckIfGraphIsStronglyConnected<>(graph1);
        Assert.assertEquals(FALSE,graph.isGraphConnectedi());
        Assert.assertEquals(FALSE,graph.isGraphConnectedii());
    }

    @Test
    public void test2() throws BadInputException {
        Graph<Integer> graph1 = new DirectedGraph<>();
        graph1.addEdge(1,1);
        CheckIfGraphIsStronglyConnected<Integer> graph = new CheckIfGraphIsStronglyConnected<>(graph1);
        Assert.assertEquals(TRUE,graph.isGraphConnectedi());
        Assert.assertEquals(TRUE,graph.isGraphConnectedii());
    }
}
