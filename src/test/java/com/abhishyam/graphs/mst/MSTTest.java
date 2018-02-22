package com.abhishyam.graphs.mst;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.TestBase;
import com.abhishyam.graphs.undirected.UnDirectedGraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhishyam on 20-Feb,2018
 */
public class MSTTest extends TestBase{

    private MST<Integer> mst;
    private List<UnDirectedGraph.Edge<Integer>> expected1;
    private List<UnDirectedGraph.Edge<Integer>> expected2;

    private static int compare(UnDirectedGraph.Edge<Integer> edge1, UnDirectedGraph.Edge<Integer> edge2) {
        int val = edge1.getVertex1().getData().compareTo(edge2.getVertex1().getData());
        if (val != 0) return val;
        val = edge1.getVertex2().getData().compareTo(edge2.getVertex2().getData());
        if (val != 0) return val;
        return Integer.compare(edge1.getWeight(), edge2.getWeight());
    }

    @Before
    public void init(){
        expected1 = new ArrayList<>();
        expected1.add(createEdge(1,3,1));
        expected1.add(createEdge(2,5,1));
        expected1.add(createEdge(2,4,2));
        expected1.add(createEdge(6,5,2));
        expected1.add(createEdge(4,7,2));
        expected1.add(createEdge(1,2,4));

        expected2 = new ArrayList<>();
        expected2.add(createEdge(2,3,5));
        expected2.add(createEdge(0,3,5));
        expected2.add(createEdge(0,1,10));

    }

    @Test(expected = BadInputException.class)
    public void testMSTi() throws BadInputException {
        mst = new KruskalMST<>(null);
        mst.minimumSpanningTree();
    }


    @Test()
    public void testMSTii() throws BadInputException {
        mst = new KruskalMST<>(weightedGraph2);
        List<UnDirectedGraph.Edge<Integer>> actual = mst.minimumSpanningTree();
        actual.sort(MSTTest::compare);
        expected1.sort(MSTTest::compare);
        Assert.assertEquals(expected1,actual);

    }

    @Test()
    public void testMSTiii() throws BadInputException {
        mst = new KruskalMST<>(weightedGraph3);
        List<UnDirectedGraph.Edge<Integer>> actual = mst.minimumSpanningTree();
        actual.sort(MSTTest::compare);
        expected2.sort(MSTTest::compare);
        Assert.assertEquals(expected2,actual);
    }


    @Test(expected = BadInputException.class)
    public void testMSTiV() throws BadInputException {
        mst = new PrimsMST<>(null);
        mst.minimumSpanningTree();
    }


    @Test()
    public void testMSTV() throws BadInputException {
        mst = new PrimsMST<>(weightedGraph2);
        List<UnDirectedGraph.Edge<Integer>> actual = mst.minimumSpanningTree();
        actual.sort(MSTTest::compare);
        expected1.sort(MSTTest::compare);
        Assert.assertEquals(expected1,actual);
    }

    @Test()
    public void testMSTVi() throws BadInputException {
        mst = new PrimsMST<>(weightedGraph3);
        List<UnDirectedGraph.Edge<Integer>> actual = mst.minimumSpanningTree();
        actual.sort(MSTTest::compare);
        expected2.sort(MSTTest::compare);
        Assert.assertEquals(expected2,actual);

    }

    private UnDirectedGraph.Edge<Integer> createEdge(int data1, int data2, int weight){
        UnDirectedGraph.Vertex<Integer> vertex1 = new UnDirectedGraph.Vertex<>(data1);
        UnDirectedGraph.Vertex<Integer> vertex2 = new UnDirectedGraph.Vertex<>(data2);
        return new UnDirectedGraph.Edge<>(vertex1,vertex2,weight);
    }


}
