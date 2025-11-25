package es.edu.ull.esit.algorithm;

import es.edu.ull.esit.Node;
import java.awt.Color;
import java.util.Stack;

/**
 * Depth-First Search (DFS) pathfinding algorithm.
 * Uses a stack to explore as far as possible along each branch before backtracking.
 */
public class DfsAlgorithm extends AbstractSearchAlgorithm {

    @Override
    public void search(Node start, Node end, int graphWidth, int graphHeight, int searchTime) {
        Stack<Node> nodes = new Stack<>();
        Node[][] prev = new Node[graphWidth][graphHeight];
        nodes.push(start);

        while (!nodes.empty()) {

            Node curNode = nodes.pop();
            if (curNode.isEnd()) {
                curNode.setColor(Color.MAGENTA);
                shortpath(prev, end, searchTime);
                break;
            }

            if (!curNode.isSearched()) {
                curNode.setColor(Color.ORANGE);
                try {
                    Thread.sleep(searchTime);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                curNode.setColor(Color.BLUE);
                for (Node adjacent : curNode.getNeighbours()) {
                    if (!adjacent.isSearched()) {
                        nodes.push(adjacent);
                        prev[adjacent.getX()][adjacent.getY()] = curNode;
                    }
                }
            }
        }
    }
}
