package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    public void testEquals() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(3, 4);

        assertEquals(v1, v2);
        assertNotEquals(v1, v3);
    }

    @Test
    public void testToString() {
        Vector2d v = new Vector2d(1, 2);
        assertEquals(v.toString(), "(1,2)");
    }

    @Test
    public void testPrecedes() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d v3 = new Vector2d(1, 4);

        assertTrue(v1.precedes(v2));
        assertTrue(v1.precedes(v3));
        assertTrue(v1.precedes(v1));
        assertFalse(v2.precedes(v3));
    }

    @Test
    public void testFollows() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d v3 = new Vector2d(1, 4);

        assertFalse(v1.follows(v2));
        assertTrue(v2.follows(v3));
        assertTrue(v2.follows(v2));
        assertTrue(v3.follows(v1));
    }

    @Test
    public void testUpperRight() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d v3 = new Vector2d(2, 1);

        assertEquals(v1.upperRight(v2), new Vector2d(3, 4));
        assertEquals(v1.upperRight(v3), new Vector2d(2, 2));
    }

    @Test
    public void testLowerLeft() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d v3 = new Vector2d(2, 1);

        assertEquals(v1.lowerLeft(v2), new Vector2d(1, 2));
        assertEquals(v1.lowerLeft(v3), new Vector2d(1, 1));
    }

    @Test
    public void testAdd() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);

        assertEquals(v1.add(v2), new Vector2d(4, 6));
    }

    @Test
    public void testSubtract() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);

        assertEquals(v1.subtract(v2), new Vector2d(-2, -2));
    }

    @Test
    public void testOpposite() {
        Vector2d v = new Vector2d(1, 2);
        Vector2d opposite = v.opposite();

        assertEquals(opposite, new Vector2d(-1, -2));
    }
}