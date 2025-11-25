package es.edu.ull.esit.algorithm;

import es.edu.ull.esit.Node;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A* pathfinding algorithm.
 * Combines actual distance from start (g-cost) with estimated distance to end (h-cost).
 */
public class AstarAlgorithm extends AbstractSearchAlgorithm {

    @Override
    public void search(Node start, Node targetNode, int graphWidth, int graphHeight, int searchTime) {
        List<Node> openList = new ArrayList<Node>();
        Node[][] prev = new Node[graphWidth][graphHeight];

        // Initialize g-cost for start node
        start.setgCost(0);
        openList.add(start);

        while (!openList.isEmpty()) {

            Node curNode = getLeastHeuristic(openList, targetNode, start);
            openList.remove(curNode);

            if (curNode.isEnd()) {
                curNode.setColor(Color.MAGENTA);
                break;
            }
            curNode.setColor(Color.ORANGE);
            try {
                Thread.sleep(searchTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            curNode.setColor(Color.BLUE);
            for (Node adjacent : curNode.getNeighbours()) {
                if (adjacent.isSearched()) {
                    continue;
                }

                // Calculate g-cost: actual distance from start to adjacent through current node
                double tentativeGCost = curNode.getgCost() + Node.distance(curNode, adjacent);

                // If this path to adjacent is better than any previous one, or adjacent is not in openList
                if (!openList.contains(adjacent) || tentativeGCost < adjacent.getgCost()) {
                    prev[adjacent.getX()][adjacent.getY()] = curNode;
                    adjacent.setgCost(tentativeGCost);
                    if (!openList.contains(adjacent)) {
                        openList.add(adjacent);
                    }
                }
            }

        }
        shortpath(prev, targetNode, searchTime);
    }

    /**
     * Selects the node with the lowest heuristic cost from a list.
     * Calculates both the heuristic distance to the end and distance from the start.
     *
     * @param nodes The list of nodes to evaluate
     * @param end   The target/end node
     * @param start The starting node
     * @return The node with the lowest total heuristic cost
     */
    private Node getLeastHeuristic(List<Node> nodes, Node end, Node start) {
        if (!nodes.isEmpty()) {
            Node leastH = nodes.get(0);
            for (int i = 1; i < nodes.size(); i++) {
                // h-cost: heuristic distance to end
                double h1 = Node.distance(nodes.get(i), end);
                // g-cost: actual distance from start
                double g1 = nodes.get(i).getgCost();

                // h-cost: heuristic distance to end
                double h2 = Node.distance(leastH, end);
                // g-cost: actual distance from start
                double g2 = leastH.getgCost();

                // f = g + h
                if (g1 + h1 < g2 + h2) {
                    leastH = nodes.get(i);
                }
            }
            return leastH;
        }
        return null;
    }
}
