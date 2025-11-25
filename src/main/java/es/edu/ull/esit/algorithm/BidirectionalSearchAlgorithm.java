package es.edu.ull.esit.algorithm;

import es.edu.ull.esit.Node;
import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Bidirectional Search pathfinding algorithm.
 * Searches from both start and end simultaneously until the searches meet.
 * More efficient than unidirectional search for finding paths.
 */
public class BidirectionalSearchAlgorithm extends AbstractSearchAlgorithm {

    @Override
    public void search(Node start, Node end, int graphWidth, int graphHeight, int searchTime) {
        Queue<Node> queueStart = new LinkedList<>();
        Queue<Node> queueEnd = new LinkedList<>();

        Node[][] prevStart = new Node[graphWidth][graphHeight];
        Node[][] prevEnd = new Node[graphWidth][graphHeight];

        boolean[] visitedStart = new boolean[graphWidth * graphHeight];
        boolean[] visitedEnd = new boolean[graphWidth * graphHeight];

        queueStart.add(start);
        visitedStart[start.getX() * graphHeight + start.getY()] = true;

        queueEnd.add(end);
        visitedEnd[end.getX() * graphHeight + end.getY()] = true;

        Node meetingPoint = null;

        while (!queueStart.isEmpty() && !queueEnd.isEmpty()) {
            Node nodeStart = queueStart.poll();
            nodeStart.setColor(Color.ORANGE);
            try {
                Thread.sleep(searchTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            nodeStart.setColor(Color.BLUE);

            for (Node neighbor : nodeStart.getNeighbours()) {
                int neighborIndex = neighbor.getX() * graphHeight + neighbor.getY();
                if (!visitedStart[neighborIndex]) {
                    visitedStart[neighborIndex] = true;
                    prevStart[neighbor.getX()][neighbor.getY()] = nodeStart;
                    queueStart.add(neighbor);

                    if (visitedEnd[neighborIndex]) {
                        meetingPoint = neighbor;
                        break;
                    }
                }
            }
            if (meetingPoint != null)
                break;

            Node nodeEnd = queueEnd.poll();
            nodeEnd.setColor(Color.ORANGE);
            try {
                Thread.sleep(searchTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            nodeEnd.setColor(Color.BLUE);

            for (Node neighbor : nodeEnd.getNeighbours()) {
                int neighborIndex = neighbor.getX() * graphHeight + neighbor.getY();
                if (!visitedEnd[neighborIndex]) {
                    visitedEnd[neighborIndex] = true;
                    prevEnd[neighbor.getX()][neighbor.getY()] = nodeEnd;
                    queueEnd.add(neighbor);

                    if (visitedStart[neighborIndex]) {
                        meetingPoint = neighbor;
                        break;
                    }
                }
            }
            if (meetingPoint != null)
                break;
        }

        if (meetingPoint != null) {
            shortpath(prevStart, meetingPoint, searchTime);
            shortpath(prevEnd, meetingPoint, searchTime);
            meetingPoint.setColor(Color.CYAN); // Meeting point
        }
    }
}
