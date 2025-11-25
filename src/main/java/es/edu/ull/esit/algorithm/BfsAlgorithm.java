package es.edu.ull.esit.algorithm;

import es.edu.ull.esit.Node;
import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth-First Search (BFS) pathfinding algorithm.
 * Uses a queue to explore all neighbors at the current depth before moving to the next level.
 */
public class BfsAlgorithm extends AbstractSearchAlgorithm {

    @Override
    public void search(Node start, Node end, int graphWidth, int graphHeight, int searchTime) {
        Queue<Node> queue = new LinkedList<>();
        Node[][] prev = new Node[graphWidth][graphHeight];

        queue.add(start);
        while (!queue.isEmpty()) {

            Node curNode = queue.poll();
            if (curNode.isEnd()) {
                curNode.setColor(Color.MAGENTA);
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
                    queue.add(adjacent);
                    prev[adjacent.getX()][adjacent.getY()] = curNode;
                }
            }
        }

        shortpath(prev, end, searchTime);
    }
}
