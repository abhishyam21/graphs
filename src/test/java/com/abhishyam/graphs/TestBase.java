package com.abhishyam.graphs;

public class TestBase {
    protected static Graph<Integer> graph1 = new Graph<>();
    protected static Graph<Integer> graph2 = new Graph<>();
    protected static Graph<String> graph3 = new Graph<>();
    protected static Graph<String> graph4 = new Graph<>();
    protected static Graph<Integer> graph5 = new Graph<>();
    protected static Graph<String> graph6 = new Graph<>();
    protected static Graph<String> graph7 = new Graph<>();
    protected static Graph<Integer> graph8 = new Graph<>();
    protected static Graph<Integer> graph9 = new Graph<>();


    protected static WeightedGraph<String> weightedGraph1 = new WeightedGraph<>();

    static {
        graph1.addEdge(0,1);graph1.addEdge(0,2);
        graph1.addEdge(1,2);
        graph1.addEdge(2,0);graph1.addEdge(2,3);
        graph1.addEdge(3,3);

        graph2.addEdge(40,10); graph2.addEdge(40,20);
        graph2.addEdge(10,30);
        graph2.addEdge(20,10); graph2.addEdge(20,30); graph2.addEdge(20,60); graph2.addEdge(20,50);
        graph2.addEdge(30,60);
        graph2.addEdge(50,70);
        graph2.addEdge(60,70);

        graph3.addEdge("A","C");
        graph3.addEdge("B","C"); graph3.addEdge("B","D");
        graph3.addEdge("C","E");
        graph3.addEdge("D","F");
        graph3.addEdge("E","H"); graph3.addEdge("E","F");
        graph3.addEdge("F","G");

        graph4.addEdge("a","b");graph4.addEdge("a","d");
        graph4.addEdge("b","e");
        graph4.addEdge("c","e"); graph4.addEdge("c","f");
        graph4.addEdge("d","b");
        graph4.addEdge("e","d");
        graph4.addEdge("f","f");

        graph5.addEdge(5,2); graph5.addEdge(5,0);
        graph5.addEdge(4,0); graph5.addEdge(4,1);
        graph5.addEdge(2,3); graph5.addEdge(3,1);

        graph6.addEdge("A","B"); graph6.addEdge("A","C");
        graph6.addEdge("B","C"); graph6.addEdge("B","D"); graph6.addEdge("B","E");
        graph6.addEdge("C","G"); graph6.addEdge("C","D");
        graph6.addEdge("D","E"); graph6.addEdge("D","F"); graph6.addEdge("D","G");
        graph6.addEdge("E","H");
        graph6.addEdge("F","H");
        graph6.addEdge("G","H");

        graph7.addEdge("A","B");
        graph7.addEdge("C","A");
        graph7.addEdge("B","C"); graph7.addEdge("B","D");
        graph7.addEdge("D","E");
        graph7.addEdge("E","F");
        graph7.addEdge("F","D");
        graph7.addEdge("G","F"); graph7.addEdge("G","H");
        graph7.addEdge("H","I");
        graph7.addEdge("I","J");
        graph7.addEdge("J","G"); graph7.addEdge("J","K");

        graph8.addEdge(1,0);
        graph8.addEdge(0, 2);
        graph8.addEdge(2, 1);
        graph8.addEdge(0, 3);
        graph8.addEdge(3, 4);

        graph9.addEdge(1,2);
        graph9.addEdge(4,1);
        graph9.addEdge(4,5);
        graph9.addEdge(5,6);
        graph9.addEdge(6,4);



        weightedGraph1.addEdge("r","t",3); weightedGraph1.addEdge("r","s",5);
        weightedGraph1.addEdge("t","y",4); weightedGraph1.addEdge("t","z",2);
        weightedGraph1.addEdge("t","x",7);
        weightedGraph1.addEdge("x","y",-1); weightedGraph1.addEdge("x","z",1);
        weightedGraph1.addEdge("s","t",2); weightedGraph1.addEdge("s","x",6);
        weightedGraph1.addEdge("y","z",-2);
    }
}
