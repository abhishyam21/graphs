package com.abhishyam.graphs.dfs;

import com.abhishyam.graphs.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DfsTest extends TestBase{

    @Test
    public void testDfs(){
        Dfs<Integer> dfs = new Dfs<>();
        List<Integer> actual = dfs.dfs(graph1);
        List<Integer> expected = Arrays.asList(0,2,3,1);
        Assert.assertEquals(actual,expected);

        actual = dfs.dfs(graph1,2);
        expected = Arrays.asList(2,3,0,1);
        Assert.assertEquals(actual,expected);

        actual = dfs.dfs(graph2);
        expected = Arrays.asList(40,20,50,70,60,30,10);
        Assert.assertEquals(actual,expected);

        actual = dfs.dfs(graph2,30);
        expected = Arrays.asList(30,60,70);
        Assert.assertEquals(actual,expected);

        Dfs<String> dfs1 = new Dfs<>();
        List<String> actual1 = dfs1.dfs(graph4);
        List<String> expected1 = Arrays.asList("a","d","b","e","c","f");
        Assert.assertEquals(actual1,expected1);
    }
}
