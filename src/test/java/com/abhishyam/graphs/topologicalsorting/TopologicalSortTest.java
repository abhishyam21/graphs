package com.abhishyam.graphs.topologicalsorting;

import com.abhishyam.graphs.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TopologicalSortTest extends TestBase {

   @Test
    public void testTopologicalSort(){
       TopologicalSort<Integer> topologicalSort1 = new TopSort<>(graph2);

       List<Integer> actual1 = topologicalSort1.topologicalSort();
       List<Integer> expected1 = Arrays.asList(40,20,50,10,30,60,70);
       Assert.assertEquals(actual1,expected1);

       TopologicalSort<String> topologicalSort2 = new TopSort<>(graph3);

       List<String> actual2 = topologicalSort2.topologicalSort();
       List<String> expected2 = Arrays.asList("B","D","A","C","E","F","G","H");
       Assert.assertEquals(actual2,expected2);
   }
}
