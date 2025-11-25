package es.edu.ull.esit.algorithm;

import es.edu.ull.esit.Node;
import java.awt.Color;

/**
 * Abstract base class for pathfinding algorithms.
 * Provides common helper methods used by various search algorithms.
 */
public abstract class AbstractSearchAlgorithm implements SearchAlgorithm {

    /**
     * Reconstructs and displays the shortest path from start to end.
     * Backtracks from the end node using the previous node array.
     *
     * @param prev       2D array storing the previous node for each position
     * @param end        The target/end node
     * @param searchTime The delay time in milliseconds for visualization
     */
    protected void shortpath(Node[][] prev, Node end, int searchTime) {
        Node pathConstructor = end;
        while (pathConstructor != null) {
            pathConstructor = prev[pathConstructor.getX()][pathConstructor.getY()];

            if (pathConstructor != null) {
                pathConstructor.setColor(Color.ORANGE);
            }
            try {
                Thread.sleep(searchTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
