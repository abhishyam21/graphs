package com.abhishyam.graphs.paths;

import com.abhishyam.graphs.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestPathTest extends TestBase{
    @Test
    public void testLongestPath(){
        LongestPath<String> longestPath = new LongestPath<>(weightedGraph1);
        Map<String, Integer> actual = longestPath.longestPath("s");
        Map<String, Integer> expected = new HashMap<String, Integer>(){
            {
                put("r",-2147483648);put("s",0);
                put("t",2);put("x",9);put("y",8);
                put("z",10);
            }
        };

        Assert.assertEquals(actual,expected);

        actual = longestPath.longestPath("t");
        expected = new HashMap<String, Integer>(){
            {
                put("r",-2147483648);put("s",-2147483648);
                put("t",0);put("x",7);put("y",6);
                put("z",8);
            }
        };
        Assert.assertEquals(actual,expected);

        actual = longestPath.longestPath("y");
        expected = new HashMap<String, Integer>(){
            {
                put("r",-2147483648);put("s",-2147483648);
                put("t",-2147483648);put("x",-2147483648);
                put("y",0);
                put("z",-2);
            }
        };
        Assert.assertEquals(actual,expected);

    }

}
