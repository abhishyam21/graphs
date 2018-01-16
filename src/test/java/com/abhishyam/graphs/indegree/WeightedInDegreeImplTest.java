package com.abhishyam.graphs.indegree;

import com.abhishyam.graphs.TestBase;
import org.junit.Test;

import java.util.Map;

public class WeightedInDegreeImplTest extends TestBase {

    @Test
    public void inDegree(){
        InDegree<String> inDegree1 = new WeightedInDegreeImpl<>(weightedGraph1);

        Map<String, Integer> actual = inDegree1.inDegree();
        System.out.println(actual.toString());
    }
}
