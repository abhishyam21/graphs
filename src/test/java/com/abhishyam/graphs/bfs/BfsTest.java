package com.abhishyam.graphs.bfs;

import com.abhishyam.graphs.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BfsTest extends TestBase {

    @Test
    public void testBfs(){

       // graph1.printGraph();

        Bfs<Integer> bfs = new Bfs<>();
        List<Integer> expected = bfs.bfs(graph1);
        List<Integer> actual = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        Assert.assertEquals(expected,actual);

        expected = bfs.bfs(graph1,2);
        actual = Arrays.asList(2,0,3,1);
        Assert.assertEquals(expected,actual);

        graph2.printGraph();
        Bfs<Integer> bfs1 = new Bfs<>();
        expected = bfs1.bfs(graph2);
        actual = Arrays.asList(40,10,20,30,60,50,70);
        Assert.assertEquals(actual,expected);
    }
}
