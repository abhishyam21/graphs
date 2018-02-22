package com.abhishyam.graphs.mst.performance;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.WeightedGraph;
import com.abhishyam.graphs.mst.KruskalMST;
import com.abhishyam.graphs.mst.MST;
import com.abhishyam.graphs.mst.PrimsMST;
import com.abhishyam.graphs.undirected.UnDirectedGraph;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Abhishyam on 20-Feb,2018
 */
public class MSTPerformanceTest {

    private static final Logger logger = LoggerFactory.getLogger(MSTPerformanceTest.class);
    private WeightedGraph<Integer> weightedGraph1;
    private WeightedGraph<Integer> weightedGraph2;
    private WeightedGraph<Integer> weightedGraph3;

    private MST<Integer> mst;

    @Before
    public void init(){
        weightedGraph1 = new UnDirectedGraph<>();
        weightedGraph2 = new UnDirectedGraph<>();
        weightedGraph3 = new UnDirectedGraph<>();

        File file1 = new File(MSTPerformanceTest.class.getClassLoader().getResource("files/250EWG.txt").getFile());
        File file2 = new File(MSTPerformanceTest.class.getClassLoader().getResource("files/1000EWG.txt").getFile());
        File file3 = new File(MSTPerformanceTest.class.getClassLoader().getResource("files/10000EWG.txt").getFile());
        populateGraph(weightedGraph1, file1);
        populateGraph(weightedGraph2, file2);
        populateGraph(weightedGraph3, file3);
    }

    private void populateGraph(WeightedGraph<Integer> weightedGraph, File file) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            int lineNumber = 0;
            while ((line =bufferedReader.readLine()) != null){
                if(lineNumber>=2){
                    String[] split = line.split(" ");
                    Double weight = Double.parseDouble(split[2]);
                    weight = weight*100000;
                    Integer weg = weight.intValue();
                    weightedGraph.addEdge(Integer.parseInt(split[0]),
                            Integer.parseInt(split[1]),weg);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void performanceTesti() throws BadInputException {
        mst = new KruskalMST<>(weightedGraph1);
        long start = System.currentTimeMillis();
        mst.minimumSpanningTree();
        long end = System.currentTimeMillis();
        logger.info("Time Taken for 1st file:{} MS",((end-start)));
    }

    @Test
    public void performanceTestii() throws BadInputException {
        mst = new KruskalMST<>(weightedGraph2);
        long start = System.currentTimeMillis();
        mst.minimumSpanningTree();
        long end = System.currentTimeMillis();
        logger.info("Time Taken for 2nd file:{} MS",((end-start)));
    }

    @Test
    public void performanceTestiii() throws BadInputException {
        mst = new KruskalMST<>(weightedGraph2);
        long start = System.currentTimeMillis();
        mst.minimumSpanningTree();
        long end = System.currentTimeMillis();
        logger.info("Time Taken for 3rd file:{} MS",((end-start)));
    }


    @Test
    public void performanceTestiV() throws BadInputException {
        mst = new PrimsMST<>(weightedGraph1);
        long start = System.currentTimeMillis();
        mst.minimumSpanningTree();
        long end = System.currentTimeMillis();
        logger.info("Time Taken for 1st file:{} MS",((end-start)));
    }

    @Test
    public void performanceTestV() throws BadInputException {
        mst = new PrimsMST<>(weightedGraph2);
        long start = System.currentTimeMillis();
        mst.minimumSpanningTree();
        long end = System.currentTimeMillis();
        logger.info("Time Taken for 2nd file:{} MS",((end-start)));
    }

    @Test
    public void performanceTestVi() throws BadInputException {
        mst = new PrimsMST<>(weightedGraph3);
        long start = System.currentTimeMillis();
        mst.minimumSpanningTree();
        long end = System.currentTimeMillis();
        logger.info("Time Taken for 3rd file:{} MS",((end-start)));
    }
}
