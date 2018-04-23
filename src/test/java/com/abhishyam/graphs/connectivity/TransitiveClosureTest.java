package com.abhishyam.graphs.connectivity;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.TestBase;
import com.abhishyam.graphs.connectivity.transitiveclosure.TransitiveClosure;
import com.abhishyam.graphs.connectivity.transitiveclosure.TransitiveClosure1;
import com.abhishyam.graphs.connectivity.transitiveclosure.TransitiveClosure2;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Abhishyam on 23-Apr,2018
 */
public class TransitiveClosureTest extends TestBase {

    Integer[][] graph1;
    Integer[][] graphExpected1;
    Integer[][] graphExpected2;
    private TransitiveClosure transitiveClosure;

    @Before
    public void init() {
        graph1 = new Integer[][]{{1, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1}
        };
        graphExpected1 = new Integer[][]{{1, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 1}
        };

        graphExpected2 = new Integer[][]{{1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 1}
        };
    }

    @Test
    public void test1() throws BadInputException {
        transitiveClosure = new TransitiveClosure1(graph1);
        Integer[][] result = transitiveClosure.transitiveClosure();
        assertArrayEquals(result, graphExpected1);
    }

    @Test
    public void test2() throws BadInputException {
        transitiveClosure = new TransitiveClosure2(graph12);
        Integer[][] result = transitiveClosure.transitiveClosure();
        System.out.println(Arrays.deepToString(result));
        assertArrayEquals(result, graphExpected2);
    }
}
