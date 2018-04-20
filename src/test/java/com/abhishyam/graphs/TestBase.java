package com.abhishyam.graphs;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.directedgraphs.DirectedGraph;
import com.abhishyam.graphs.directedgraphs.WeightedGraphImpl;
import com.abhishyam.graphs.undirected.UnDirectedGraph;

public class TestBase {
    protected static Graph<Integer> graph1 = new DirectedGraph<>();
    protected static Graph<Integer> graph2 = new DirectedGraph<>();
    protected static Graph<String> graph3 = new DirectedGraph<>();
    protected static Graph<String> graph4 = new DirectedGraph<>();
    protected static Graph<Integer> graph5 = new DirectedGraph<>();
    protected static Graph<String> graph6 = new DirectedGraph<>();
    protected static Graph<String> graph7 = new DirectedGraph<>();
    protected static Graph<Integer> graph8 = new DirectedGraph<>();
    protected static Graph<Integer> graph9 = new DirectedGraph<>();
    protected static Graph<Integer> graph10 = new DirectedGraph<>();
    protected static Graph<Integer> graph11 = new DirectedGraph<>();


    protected static WeightedGraph<String> weightedGraph1 = new WeightedGraphImpl<>();
    protected static WeightedGraph<Integer> weightedGraph2 = new UnDirectedGraph<>();
    protected static WeightedGraph<Integer> weightedGraph3 = new UnDirectedGraph<>();
    protected static WeightedGraph<Integer> weightedGraph4 = new UnDirectedGraph<>();
    protected static WeightedGraph<Integer> weightedGraph5 = new WeightedGraphImpl<>();
    protected static WeightedGraph<Integer> weightedGraph6 = new UnDirectedGraph<>();

    //https://www.youtube.com/watch?v=2kREIkF9UAs&t=419s
    protected static WeightedGraph<String> weightedGraph7 = new UnDirectedGraph<>();
    protected static WeightedGraph<Integer> weightedGraph8 = new UnDirectedGraph<>();

    //https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
    protected static WeightedGraph<Integer> weightedGraph9 = new UnDirectedGraph<>();
    protected static WeightedGraph<Integer> weightedGraph10 = new UnDirectedGraph<>();
    protected static WeightedGraph<Integer> weightedGraph11 = new UnDirectedGraph<>();

    protected static WeightedGraph<Integer> weightedGraph12 = new UnDirectedGraph<>();

    //https://www.geeksforgeeks.org/eulerian-path-and-circuit/
    protected static WeightedGraph<Integer> weightedGraph13 = new UnDirectedGraph<>();
    protected static WeightedGraph<Integer> weightedGraph14 = new UnDirectedGraph<>();
    protected static WeightedGraph<Integer> weightedGraph15 = new UnDirectedGraph<>();
    protected static WeightedGraph<Integer> weightedGraph16 = new UnDirectedGraph<>();


    static {
        try {
            graph1.addEdge(0, 1);
            graph1.addEdge(0, 2);
            graph1.addEdge(1, 2);
            graph1.addEdge(2, 0);
            graph1.addEdge(2, 3);
            graph1.addEdge(3, 3);

            graph2.addEdge(40, 10);
            graph2.addEdge(40, 20);
            graph2.addEdge(10, 30);
            graph2.addEdge(20, 10);
            graph2.addEdge(20, 30);
            graph2.addEdge(20, 60);
            graph2.addEdge(20, 50);
            graph2.addEdge(30, 60);
            graph2.addEdge(50, 70);
            graph2.addEdge(60, 70);

            graph3.addEdge("A", "C");
            graph3.addEdge("B", "C");
            graph3.addEdge("B", "D");
            graph3.addEdge("C", "E");
            graph3.addEdge("D", "F");
            graph3.addEdge("E", "H");
            graph3.addEdge("E", "F");
            graph3.addEdge("F", "G");

            graph4.addEdge("a", "b");
            graph4.addEdge("a", "d");
            graph4.addEdge("b", "e");
            graph4.addEdge("c", "e");
            graph4.addEdge("c", "f");
            graph4.addEdge("d", "b");
            graph4.addEdge("e", "d");
            graph4.addEdge("f", "f");

            graph5.addEdge(5, 2);
            graph5.addEdge(5, 0);
            graph5.addEdge(4, 0);
            graph5.addEdge(4, 1);
            graph5.addEdge(2, 3);
            graph5.addEdge(3, 1);

            graph6.addEdge("A", "B");
            graph6.addEdge("A", "C");
            graph6.addEdge("B", "C");
            graph6.addEdge("B", "D");
            graph6.addEdge("B", "E");
            graph6.addEdge("C", "G");
            graph6.addEdge("C", "D");
            graph6.addEdge("D", "E");
            graph6.addEdge("D", "F");
            graph6.addEdge("D", "G");
            graph6.addEdge("E", "H");
            graph6.addEdge("F", "H");
            graph6.addEdge("G", "H");

            graph7.addEdge("A", "B");
            graph7.addEdge("C", "A");
            graph7.addEdge("B", "C");
            graph7.addEdge("B", "D");
            graph7.addEdge("D", "E");
            graph7.addEdge("E", "F");
            graph7.addEdge("F", "D");
            graph7.addEdge("G", "F");
            graph7.addEdge("G", "H");
            graph7.addEdge("H", "I");
            graph7.addEdge("I", "J");
            graph7.addEdge("J", "G");
            graph7.addEdge("J", "K");

            graph8.addEdge(1, 0);
            graph8.addEdge(0, 2);
            graph8.addEdge(2, 1);
            graph8.addEdge(0, 3);
            graph8.addEdge(3, 4);

            graph9.addEdge(1, 2);
            graph9.addEdge(4, 1);
            graph9.addEdge(4, 5);
            graph9.addEdge(5, 6);
            graph9.addEdge(6, 4);

            //this is same as graph 5 without cycle
            graph10.addEdge(5, 2);
            graph10.addEdge(5, 0);
            graph10.addEdge(0, 4);
            graph10.addEdge(4, 1);
            graph10.addEdge(2, 3);
            //graph10.addEdge(3,1);

            //Graph link
            graph11.addEdge(0, 1);
            graph11.addEdge(1, 2);
            graph11.addEdge(2, 3);
            graph11.addEdge(3, 0);
            graph11.addEdge(2, 4);
            graph11.addEdge(4, 2);
        }catch (BadInputException e){
            //just eat don't add that edge
        }

    }

    static {
        weightedGraph1.addEdge("r","t",3); weightedGraph1.addEdge("r","s",5);
        weightedGraph1.addEdge("t","y",4); weightedGraph1.addEdge("t","z",2);
        weightedGraph1.addEdge("t","x",7);
        weightedGraph1.addEdge("x","y",-1); weightedGraph1.addEdge("x","z",1);
        weightedGraph1.addEdge("s","t",2); weightedGraph1.addEdge("s","x",6);
        weightedGraph1.addEdge("y","z",-2);


        weightedGraph2.addEdge(1, 2, 4);
        weightedGraph2.addEdge(1, 3, 1);
        weightedGraph2.addEdge(2, 5, 1);
        weightedGraph2.addEdge(2, 6, 3);
        weightedGraph2.addEdge(2, 4, 2);
        weightedGraph2.addEdge(6, 5, 2);
        weightedGraph2.addEdge(6, 4, 3);
        weightedGraph2.addEdge(4, 7, 2);
        weightedGraph2.addEdge(3, 4, 5);
        weightedGraph2.addEdge(3, 7, 8);


        weightedGraph3.addEdge(0, 1, 10);
        weightedGraph3.addEdge(0, 2, 6);
        weightedGraph3.addEdge(0, 3, 5);
        weightedGraph3.addEdge(1, 3, 15);
        weightedGraph3.addEdge(2, 3, 5);


        weightedGraph4.addEdge(0, 1, 4);
        weightedGraph4.addEdge(0, 7, 8);
        weightedGraph4.addEdge(1, 2, 8);
        weightedGraph4.addEdge(1, 7, 11);
        weightedGraph4.addEdge(2, 3, 7);
        weightedGraph4.addEdge(2, 8, 2);
        weightedGraph4.addEdge(2, 5, 4);
        weightedGraph4.addEdge(3, 4, 9);
        weightedGraph4.addEdge(3, 5, 14);
        weightedGraph4.addEdge(4, 5, 10);
        weightedGraph4.addEdge(5, 6, 2);
        weightedGraph4.addEdge(6, 7, 1);
        weightedGraph4.addEdge(6, 8, 6);
        weightedGraph4.addEdge(7, 8, 7);

        weightedGraph5.addEdge(0, 1, -1);
        weightedGraph5.addEdge(0, 2, 4);
        weightedGraph5.addEdge(1, 2, 3);
        weightedGraph5.addEdge(1, 3, 2);
        weightedGraph5.addEdge(1, 4, 2);
        weightedGraph5.addEdge(3, 2, 5);
        weightedGraph5.addEdge(3, 1, 1);
        weightedGraph5.addEdge(4, 3, -3);

        weightedGraph6.addEdge(1, 2,1);
        weightedGraph6.addEdge(2, 3,1);
        weightedGraph6.addEdge(1, 3,1);
        weightedGraph6.addEdge(1, 4,1);
        weightedGraph6.addEdge(4, 5,1);
        weightedGraph6.addEdge(5, 6,1);
        weightedGraph6.addEdge(6, 7,1);
        weightedGraph6.addEdge(7, 5,1);
        weightedGraph6.addEdge(6, 8,1);


        weightedGraph7.addEdge("A", "B",1);
        weightedGraph7.addEdge("A", "C",1);
        weightedGraph7.addEdge("C", "D",1);
        weightedGraph7.addEdge("D", "E",1);
        weightedGraph7.addEdge("E", "G",1);
        weightedGraph7.addEdge("G", "F",1);
        weightedGraph7.addEdge("E", "F",1);
        weightedGraph7.addEdge("F", "H",1);
        weightedGraph7.addEdge("B", "C",1);

        weightedGraph8.addEdge(0, 1,1);
        weightedGraph8.addEdge(0, 2,1);
        weightedGraph8.addEdge(0, 3,1);
        weightedGraph8.addEdge(0, 4,1);
        weightedGraph8.addEdge(4, 2,1);
        weightedGraph8.addEdge(3, 5,1);
        weightedGraph8.addEdge(4, 6,1);
        weightedGraph8.addEdge(6, 3,1);
        weightedGraph8.addEdge(6, 7,1);
        weightedGraph8.addEdge(6, 8,1);
        weightedGraph8.addEdge(7, 9,1);
        weightedGraph8.addEdge(9, 1,10);
        weightedGraph8.addEdge(8, 1,10);

        weightedGraph9.addEdge(1, 0,1);
        weightedGraph9.addEdge(0, 2,1);
        weightedGraph9.addEdge(2, 1,1);
        weightedGraph9.addEdge(0, 3,1);
        weightedGraph9.addEdge(3, 4,1);

        weightedGraph10.addEdge(0, 1,1);
        weightedGraph10.addEdge(1, 2,1);
        weightedGraph10.addEdge(2, 3,1);

        weightedGraph11.addEdge(0, 1,1);
        weightedGraph11.addEdge(1, 2,1);
        weightedGraph11.addEdge(2, 0,1);
        weightedGraph11.addEdge(1, 3,1);
        weightedGraph11.addEdge(1, 4,1);
        weightedGraph11.addEdge(1, 6,1);
        weightedGraph11.addEdge(3, 5,1);
        weightedGraph11.addEdge(4, 5,1);

        weightedGraph12.addEdge(0, 1, 1);
        weightedGraph12.addEdge(1, 2, 1);
        weightedGraph12.addEdge(4, 3, 1);

        weightedGraph13.addEdge(1, 0, 1);
        weightedGraph13.addEdge(0, 2, 1);
        weightedGraph13.addEdge(2, 1, 1);
        weightedGraph13.addEdge(0, 3, 1);
        weightedGraph13.addEdge(3, 4, 1);
        weightedGraph13.addEdge(4, 0, 1);

        weightedGraph14.addEdge(1, 0, 1);
        weightedGraph14.addEdge(0, 2, 1);
        weightedGraph14.addEdge(2, 1, 1);
        weightedGraph14.addEdge(0, 3, 1);
        weightedGraph14.addEdge(3, 4, 1);

        weightedGraph15.addEdge(1, 0, 1);
        weightedGraph15.addEdge(0, 2, 1);
        weightedGraph15.addEdge(2, 1, 1);
        weightedGraph15.addEdge(0, 3, 1);
        weightedGraph15.addEdge(3, 4, 1);
        weightedGraph15.addEdge(1, 3, 1);

        weightedGraph16.addEdge(0, 1, 0);
        weightedGraph16.addEdge(1, 2, 0);
        weightedGraph16.addEdge(2, 0, 0);
    }
}
