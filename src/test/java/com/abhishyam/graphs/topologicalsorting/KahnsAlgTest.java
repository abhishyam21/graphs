package com.abhishyam.graphs.topologicalsorting;

import com.abhishyam.graphs.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KahnsAlgTest extends TestBase{

    @Test
    public void testKahnsTopSort(){
        TopologicalSort<Integer> kahnsAlg1 = new KahnsAlg<>(graph1);
        List<Integer> actual1 = kahnsAlg1.topologicalSort();
        List<Integer> expected1 = new ArrayList<>();
        Assert.assertEquals(actual1,expected1);

        kahnsAlg1 = new KahnsAlg<>(graph2);
        actual1 = kahnsAlg1.topologicalSort();
        expected1 = Arrays.asList(   40, 20, 10, 50, 30, 60, 70);
        Assert.assertEquals(actual1,expected1);

        KahnsAlg<String> kahnsAlg2 = new KahnsAlg<>(graph3);
        List<String> actual2 = kahnsAlg2.topologicalSort();
        List<String> expected2 = Arrays.asList("A","B","C","D","E","H","F","G");
        Assert.assertEquals(actual2,expected2);

    }

}
