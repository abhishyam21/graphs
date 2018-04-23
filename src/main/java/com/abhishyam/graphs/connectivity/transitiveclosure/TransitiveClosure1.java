package com.abhishyam.graphs.connectivity.transitiveclosure;

import com.abhishyam.exceptions.BadInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem Link: https://www.geeksforgeeks.org/transitive-closure-of-a-graph/
 * <p>
 * For Understanding the solution go through the following link
 * https://www.youtube.com/watch?v=oNI0rf2P9gE&t=59s
 * <p>
 * Basically the Algorithm will follow the Floyd Warshall Algorithm.
 * <p>
 * This solution works O(V^3) time complexity
 * <p>
 * Created by Abhishyam on 22-Apr,2018
 */
public class TransitiveClosure1 implements TransitiveClosure {
    private static final Logger logger = LoggerFactory.getLogger(TransitiveClosure1.class);

    private Integer[][] graph;
    private int n;

    public TransitiveClosure1(Integer[][] graph) throws BadInputException {
        if (graph == null) {
            logger.error("Graph is null");
            throw new BadInputException("Graph is null");
        }
        this.graph = graph;
        n = graph.length;
    }

    @Override
    public Integer[][] transitiveClosure() {
        Integer[][] result = new Integer[n][n];
        //copy the content from actual graph to result.
        for (int i = 0; i < n; i++) {
            System.arraycopy(graph[i], 0, result[i], 0, n);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //if the current value of the matrix is 1, then don't any thing
                    //if it is Zero, then introduce the k in the i and j and check if
                    //there is path from i->k and k>-j, if yes update with 1 else 0.
                    if (result[i][j] == 0) {
                        result[i][j] = ((result[i][k] == 1) && (result[k][j] == 1)) ? 1 : 0;
                    }
                }
            }
        }
        return result;
    }
}
