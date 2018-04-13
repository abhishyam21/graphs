package com.abhishyam.graphs.topologicalsorting;

import com.abhishyam.graphs.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllTopologicalSortsTest extends TestBase{

    @Test
    public void testTopSort(){
        AllTopologicalSorts<Integer> allTopologicalSorts = new AllTopologicalSorts<>();
        List<List<Integer>> actual = allTopologicalSorts.topSort(graph5);
        List<List<Integer>> expected = new ArrayList<List<Integer>>(){
            {
                add(Arrays.asList(5, 2, 4, 0, 3, 1));
                add(Arrays.asList(5, 2, 4, 3, 0, 1));
                add(Arrays.asList(5, 2, 4, 3, 1, 0));
                add(Arrays.asList(5, 2, 3, 4, 0, 1));
                add(Arrays.asList(5, 2, 3, 4, 1, 0));
                add(Arrays.asList(5, 4, 2, 0, 3, 1));
                add(Arrays.asList(5, 4, 2, 3, 0, 1));
                add(Arrays.asList(5, 4, 2, 3, 1, 0));
                add(Arrays.asList(5, 4, 0, 2, 3, 1));
                add(Arrays.asList(4, 5, 2, 0, 3, 1));
                add(Arrays.asList(4, 5, 2, 3, 0, 1));
                add(Arrays.asList(4, 5, 2, 3, 1, 0));
                add(Arrays.asList(4, 5, 0, 2, 3, 1));
            }
        };
        Assert.assertEquals(actual,expected);

        actual = allTopologicalSorts.topSort(graph2);
        actual.forEach(System.out::println);

        AllTopologicalSorts<String> allTopologicalSorts1 = new AllTopologicalSorts<>();
        List<List<String>> actual1 = allTopologicalSorts1.topSort(graph3);
      //  actual1.forEach(System.out::println);

        actual1 = allTopologicalSorts1.topSort(graph6);
        //actual1.forEach(System.out::println);
    }
}
