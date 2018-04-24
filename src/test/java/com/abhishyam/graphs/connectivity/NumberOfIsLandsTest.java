package com.abhishyam.graphs.connectivity;

import com.abhishyam.exceptions.BadInputException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Abhishyam on 23-Apr,2018
 */
public class NumberOfIsLandsTest {

    @Test
    public void test1() throws BadInputException {
        int M[][] = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        NumberOfIsLands numberOfIsLands = new NumberOfIsLands();
        int actual = numberOfIsLands.noOfIslands(M);
        Assert.assertEquals(5, actual);
    }
}
