package com.abhishyam.graphs.connectivity;

import com.abhishyam.exceptions.BadInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Abhishyam on 23-Apr,2018
 */
public class NumberOfIsLands {
    private static final Logger logger = LoggerFactory.getLogger(NumberOfIsLands.class);
    private int ROW;
    private int COL;

    public int noOfIslands(int[][] graph) throws BadInputException {
        if (graph == null) {
            logger.error("Graph is null");
            throw new BadInputException("Graph is null");
        }
        ROW = graph.length;
        COL = graph[0].length;

        return dfs(graph);
    }

    private int dfs(int[][] graph) {
        int counter = 0;
        boolean[][] isVisited = new boolean[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (graph[i][j] == 1 && !isVisited[i][j]) {
                    dfsUtil(i, j, graph, isVisited);
                    counter++;
                }
            }
        }
        return counter;
    }

    private void dfsUtil(int row, int col, int[][] graph, boolean[][] isVisited) {
        int[] rowVal = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] colVal = {-1, 0, 1, 1, 1, 0, -1, -1};
        isVisited[row][col] = true;
        for (int i = 0; i < 8; i++) {
            if (isValid(row + rowVal[i], col + colVal[i], graph, isVisited)) {
                dfsUtil(row + rowVal[i], col + colVal[i], graph, isVisited);
            }
        }
    }

    private boolean isValid(int row, int col, int[][] graph, boolean[][] isVisited) {
        return ROW > row && COL > col &&
                row >= 0 && col >= 0 &&
                graph[row][col] == 1 &&
                !isVisited[row][col];
    }
}
