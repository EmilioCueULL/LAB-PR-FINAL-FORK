import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.Color;
import java.util.List;

public class NodeTest {

    @Test
    public void testConstructorAndPositions() {
        Node n = new Node(50, 100);
        assertEquals((50 - 15) / 35, n.getX());
        assertEquals((100 - 15) / 35, n.getY());
    }

    @Test
    public void testSetXandY() {
        Node n = new Node();
        n.setX(70).setY(140);
        assertEquals((70 - 15) / 35, n.getX());
        assertEquals((140 - 15) / 35, n.getY());
    }

    @Test
    public void testgCost() {
        Node n = new Node();
        n.setgCost(12.5);
        assertEquals(12.5, n.getgCost());
    }

    @Test
    public void testFCost() {
        Node n = new Node();
        n.setFCost(9.9);
        assertEquals(9.9, n.getFCost());
    }

    @Test
    public void testDistance() {
        Node a = new Node(0, 0);
        Node b = new Node(3, 4);
        assertEquals(5.0, Node.distance(a, b));
    }

    @Test
    public void testClickedChangesColor() {
        Node n = new Node();

        n.Clicked(1); // wall
        assertEquals(Color.BLACK, n.getColor());

        n.Clicked(2); // start
        assertEquals(Color.GREEN, n.getColor());

        n.Clicked(3); // end
        assertEquals(Color.RED, n.getColor());

        n.Clicked(4); // clear
        assertEquals(Color.LIGHT_GRAY, n.getColor());
    }

    @Test
    public void testSetAsWall() {
        Node n = new Node();
        n.setAsWall();
        assertEquals(Color.BLACK, n.getColor());
        assertTrue(n.isWall());
    }

    @Test
    public void testClearNode() {
        Node n = new Node();
        n.setColor(Color.RED);
        n.clearNode();
        assertEquals(Color.LIGHT_GRAY, n.getColor());
    }

    @Test
    public void testColorFlags() {
        Node n = new Node();

        n.setColor(Color.BLACK);
        assertTrue(n.isWall());
        assertFalse(n.isStart());
        assertFalse(n.isEnd());

        n.setColor(Color.GREEN);
        assertTrue(n.isStart());

        n.setColor(Color.RED);
        assertTrue(n.isEnd());
        assertTrue(n.isPath());

        n.setColor(Color.LIGHT_GRAY);
        assertTrue(n.isPath());

        n.setColor(Color.BLUE);
        assertTrue(n.isSearched());

        n.setColor(Color.ORANGE);
        assertTrue(n.isSearched());

        n.setColor(Color.CYAN);
        assertTrue(n.isSearched());
    }

    @Test
    public void testGetNeighbours() {
        Node center = new Node();

        Node left = new Node();
        Node right = new Node();
        Node up = new Node();
        Node down = new Node();
        Node blocked = new Node();

        left.setColor(Color.LIGHT_GRAY);
        right.setColor(Color.RED);     // red counts as path
        up.setColor(Color.BLACK);      // blocked, not a path
        down.setColor(Color.LIGHT_GRAY);
        blocked.setColor(Color.BLACK); // extra blocked node

        center.setDirections(left, right, up, down);

        List<Node> neighbours = center.getNeighbours();

        assertEquals(3, neighbours.size());
        assertTrue(neighbours.contains(left));
        assertTrue(neighbours.contains(right));
        assertTrue(neighbours.contains(down));
        assertFalse(neighbours.contains(up));
        assertFalse(neighbours.contains(blocked));
    }

}