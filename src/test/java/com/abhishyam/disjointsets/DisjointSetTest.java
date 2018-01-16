package com.abhishyam.disjointsets;

import org.junit.Assert;
import org.junit.Test;

public class DisjointSetTest {

    @Test
    public void testDisjointSets(){
        DisjointSet<Long> ds = new DisjointSet<>();
        ds.makeSet(1L);
        ds.makeSet(2L);
        ds.makeSet(3L);
        ds.makeSet(4L);
        ds.makeSet(5L);
        ds.makeSet(6L);
        ds.makeSet(7L);

        ds.union(1L, 2L);
        Long actual = ds.findSet(2L);
        Long expected = 1L;
        Assert.assertEquals(expected,actual);

        ds.union(2L, 3L);
        actual = ds.findSet(3L);
        expected = 1L;
        Assert.assertEquals(expected,actual);

        ds.union(4L, 5L);
        actual = ds.findSet(4L);
        expected = 4L;
        Assert.assertEquals(expected,actual);

        ds.union(6L, 7L);
        ds.union(5L, 6L);
        actual = ds.findSet(5L);
        expected = 4L;
        Assert.assertEquals(expected,actual);

        ds.union(3L, 7L);
        actual = ds.findSet(3L);
        expected = 4L;
        Assert.assertEquals(expected,actual);

        actual = ds.findSet(1L);
        expected = 4L;
        Assert.assertEquals(expected,actual);

        actual = ds.findSet(4L);
        expected = 4L;
        Assert.assertEquals(expected,actual);

        actual = ds.findSet(7L);
        expected = 4L;
        Assert.assertEquals(expected,actual);

        actual = ds.findSet(8L);
        Assert.assertEquals(null,actual);

        ds.union(null,1L);
        ds.union(1L,null);

    }
}
