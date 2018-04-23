package com.abhishyam.graphs.connectivity.transitiveclosure;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Problem Link: https://www.geeksforgeeks.org/transitive-closure-of-a-graph-using-dfs/
 * <p>
 * Created by Abhishyam on 23-Apr,2018
 */
public class TransitiveClosure2 implements TransitiveClosure {
    private static final Logger logger = LoggerFactory.getLogger(TransitiveClosure2.class);

    private Graph<Integer> graph;

    public TransitiveClosure2(Graph<Integer> graph) throws BadInputException {
        if (graph == null) {
            logger.error("Graph is null");
            throw new BadInputException("Graph is null");
        }
        this.graph = graph;
    }

    @Override
    public Integer[][] transitiveClosure() {
        int n = this.graph.getGraph().size();
        Integer[][] result = new Integer[n][n];
        for (int k = 0; k < n; k++) {
            Arrays.fill(result[k], 0);
        }
        for (int i = 0; i < n; i++) {
            dfsUtil(result, i, i);
        }
        return result;
    }

    private void dfsUtil(Integer[][] result, int source, int destination) {
        result[source][destination] = 1;
        for (Integer adjacentVertices : this.graph.getGraph().get(destination)) {
            if (result[source][adjacentVertices] == 0) {
                dfsUtil(result, source, adjacentVertices);
            }
        }
    }
}
