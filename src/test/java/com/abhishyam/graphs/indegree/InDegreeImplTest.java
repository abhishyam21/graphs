package com.abhishyam.graphs.indegree;

import com.abhishyam.graphs.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class InDegreeImplTest extends TestBase{

    @Test
    public void testInDegree(){
        InDegree<Integer> inDegree1 = new InDegreeImpl<>(graph1);
        Map<Integer, Integer> expected1 = inDegree1.inDegree();
        Map<Integer,Integer> actual1 = new LinkedHashMap<Integer,Integer>(){
            {
                put(1,1);put(2,2);put(0,1);put(3,2);
            }
        };
        Assert.assertEquals(expected1,actual1);

        inDegree1 = new InDegreeImpl<>(graph2);
        expected1 = inDegree1.inDegree();
        actual1 = new LinkedHashMap<Integer, Integer>(){
            {
                put(40,0);put(10,2);put(20,1);put(30,2);put(60,2);put(50,1);put(70,2);
            }
        };

        Assert.assertEquals(expected1,actual1);
    }
}
