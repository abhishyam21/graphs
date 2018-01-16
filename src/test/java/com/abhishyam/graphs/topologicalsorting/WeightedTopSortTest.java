package com.abhishyam.graphs.topologicalsorting;

import com.abhishyam.graphs.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WeightedTopSortTest extends TestBase{
    @Test
    public void testTopologicalSort(){
        TopologicalSort<String> topologicalSort = new WeightedTopSort<>(weightedGraph1);
        List<String> actual = topologicalSort.topologicalSort();
        List<String> expected = Arrays.asList("r","s","t","x","y","z");
        Assert.assertEquals(actual,expected);
    }
}
