package com.abhishyam.graphs.connectivity;

import com.abhishyam.graphs.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class StronglyConnectedComponentTest extends TestBase{

    @Test
    public void testGetDfsOfGraph(){
        StronglyConnectedComponent<String> component = new StronglyConnectedComponent<>(graph7);
        List<Set<String>> actual = component.connectedComponent();
        List<Set<String>> expected = new ArrayList<>();
        expected.add(new HashSet<>(Arrays.asList("G","H","I","J")));
        expected.add(new HashSet<>(Collections.singletonList("K")));
        expected.add(new HashSet<>(Arrays.asList("A","B","C")));
        expected.add(new HashSet<>(Arrays.asList("D","E","F")));
        Assert.assertEquals(actual,expected);
        StronglyConnectedComponent<Integer> component1 = new StronglyConnectedComponent<>(graph8);
        List<Set<Integer>> actual1 = component1.connectedComponent();
        List<Set<Integer>> expected1 = new ArrayList<>();
        expected1.add(new HashSet<>(Arrays.asList(0,1,2)));
        expected1.add(new HashSet<>(Collections.singletonList(3)));
        expected1.add(new HashSet<>(Collections.singletonList(4)));
        Assert.assertEquals(actual1,expected1);

    }
}
