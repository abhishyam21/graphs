package com.abhishyam.graphs.connectivity;

import com.abhishyam.exceptions.NoVertexFound;
import com.abhishyam.graphs.TestBase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Abhishyam on 11-Apr,2018
 */
public class PathBetweenTwoVerticesTest extends TestBase {

    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    @Test
    public void testFindPathI() throws NoVertexFound {
        PathBetweenTwoVertices<Integer> pathBetweenTwoVerticesInteger = new PathBetweenTwoVertices<>(graph1);
        Assert.assertEquals(TRUE, pathBetweenTwoVerticesInteger.findPath(0, 1));
        Assert.assertEquals(TRUE, pathBetweenTwoVerticesInteger.findPath(3, 3));
        Assert.assertEquals(FALSE, pathBetweenTwoVerticesInteger.findPath(3, 0));
    }

    @Test(expected = NoVertexFound.class)
    public void testFindPathII() throws NoVertexFound {
        PathBetweenTwoVertices<String> pathBetweenTwoVerticesString = new PathBetweenTwoVertices<>(graph3);
        Assert.assertEquals(TRUE, pathBetweenTwoVerticesString.findPath("A", "G"));
        Assert.assertEquals(TRUE, pathBetweenTwoVerticesString.findPath("C", "G"));
        Assert.assertEquals(FALSE, pathBetweenTwoVerticesString.findPath("C", "A"));
        Assert.assertEquals(FALSE, pathBetweenTwoVerticesString.findPath("E", "B"));
        pathBetweenTwoVerticesString.findPath("H", "Z");
    }
}
