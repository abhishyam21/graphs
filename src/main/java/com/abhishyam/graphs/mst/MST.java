package com.abhishyam.graphs.mst;

import com.abhishyam.exceptions.BadInputException;
import com.abhishyam.graphs.Edge;

import java.util.List;

/**
 * Created by Abhishyam on 20-Feb,2018
 */
public interface MST<V> {
    List<Edge<V>> minimumSpanningTree() throws BadInputException;
}
