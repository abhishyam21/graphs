package com.abhishyam.graphs.shortestpath;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.Edge;
import com.abhishyam.graphs.Vertex;
import com.abhishyam.graphs.WeightedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.abhishyam.graphs.shortestpath.DijsktrasAlgorithm.BAD_INPUT_GRAPH_CAN_T_BE_NULL;

/**
 * Created by Abhishyam on 21-Mar,2018
 */
public class BellmanFordAlgorithm<V> implements ShortestPath<V>{

    private static final Logger logger = LoggerFactory.getLogger(BellmanFordAlgorithm.class);
    private static final Integer INFINITY = 100000;

    @Override
    public Map<V, Integer> findShortestPath(WeightedGraph<V> graph, V source) throws BadInputException {
        if(graph == null){
            logger.error(BAD_INPUT_GRAPH_CAN_T_BE_NULL);
            throw new BadInputException(BAD_INPUT_GRAPH_CAN_T_BE_NULL);
        }
        Map<V,Integer> vertexToWeightMap = populateVertexWeight(graph,source);
        /*we need to iterate trough (|V|-1) times where |V| is number of vertices in graph*/
        int numberOfVertices = graph.getGraph().entrySet().size()-1;
        findShortestPathUtil(numberOfVertices,vertexToWeightMap,graph);
        checkForNegativeWeightCycles(graph,vertexToWeightMap);
        return vertexToWeightMap;
    }

    private void findShortestPathUtil(int numberOfVertices, Map<V, Integer> vertexToWeightMap, WeightedGraph<V> graph) {
        for (int i = 0; i < numberOfVertices; i++) {
            for (Edge<V> edge : graph.getAllEdges()) {
                Vertex<V> u = edge.getVertex1();
                Vertex<V> v = edge.getVertex2();
                Integer temp = (vertexToWeightMap.get(u.getData()))+ edge.getWeight();

                if(vertexToWeightMap.get(v.getData()) > (temp)){
                    vertexToWeightMap.put(v.getData(),temp);
                }
            }
        }
    }

    /**
     * If we still get lesser distance it means
     * there is negative weight cycle in the graph.
     * Throw exception in that case
     */
    private void checkForNegativeWeightCycles(WeightedGraph<V> graph, Map<V, Integer> vertexToWeightMap) throws BadInputException {

        for (Edge<V> edge : graph.getAllEdges()) {
            Vertex<V> u = edge.getVertex1();
            Vertex<V> v = edge.getVertex2();
            if (vertexToWeightMap.get(u.getData()) + edge.getWeight() < vertexToWeightMap.get(v.getData())) {
                throw new BadInputException("There is Negative Weight cycle in the given graph.");
            }
        }
    }


    /**
     * This method will populate the distance/weights of all vertexes
     * For source vertex weight/distance will be ZERO.
     *
     */
    private Map<V, Integer> populateVertexWeight(WeightedGraph<V> graph, V source) {
        Map<V,Integer> vertexToWeightMap = new HashMap<>();
        for (Map.Entry<V, List<Edge<V>>> entry : graph.getGraph().entrySet()) {
            vertexToWeightMap.put(entry.getKey(), INFINITY);
        }
        vertexToWeightMap.put(source,0);
        return vertexToWeightMap;
    }
}
