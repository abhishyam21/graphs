package com.abhishyam.graphs.backtracking;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Abhishyam on 19-Mar,2018
 */
public class PathMoreThanKLenTest extends TestBase{

    private PathMoreThanKLen<Integer> integerPathMoreThanKLen;

    private PathMoreThanKLen<String> stringPathMoreThanKLen;

    @Before
    public void init(){
        integerPathMoreThanKLen = new PathMoreThanKLen<>();
        stringPathMoreThanKLen = new PathMoreThanKLen<>();
    }

    @Test(expected = BadInputException.class)
    public void testException() throws BadInputException {
        integerPathMoreThanKLen.findPathGreaterThanLenK(null,0,0);
        stringPathMoreThanKLen.findPathGreaterThanLenK(null,0,"A");
    }

    @Test(expected = BadInputException.class)
    public void testNoStartPointFoundException() throws BadInputException {
        integerPathMoreThanKLen.findPathGreaterThanLenK(null,0,10);
        stringPathMoreThanKLen.findPathGreaterThanLenK(null,0,"BN");
    }


    @Test
    public void testIntegerGraphI() throws BadInputException {
        boolean expected = integerPathMoreThanKLen.findPathGreaterThanLenK(weightedGraph4, 58, 0);
        Assert.assertEquals(expected,true);
        expected = integerPathMoreThanKLen.findPathGreaterThanLenK(weightedGraph4,62,0);
        Assert.assertEquals(expected,false);
    }

    @Test
    public void testIntegerGraphII() throws BadInputException {
        boolean expected = integerPathMoreThanKLen.findPathGreaterThanLenK(weightedGraph3, 30, 0);
        Assert.assertEquals(expected,true);
        expected = integerPathMoreThanKLen.findPathGreaterThanLenK(weightedGraph3,31,0);
        Assert.assertEquals(expected,false);
    }
}
