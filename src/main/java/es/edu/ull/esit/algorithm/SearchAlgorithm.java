package es.edu.ull.esit.algorithm;

import es.edu.ull.esit.Node;

/**
 * Strategy interface for pathfinding algorithms.
 * Implementations of this interface provide different search strategies
 * for finding paths in a maze grid.
 */
public interface SearchAlgorithm {

    /**
     * Performs the search algorithm to find a path from start to end.
     *
     * @param start       The starting node
     * @param end         The target/end node
     * @param graphWidth  The width of the grid
     * @param graphHeight The height of the grid
     * @param searchTime  The delay time in milliseconds for visualization
     */
    void search(Node start, Node end, int graphWidth, int graphHeight, int searchTime);
}
