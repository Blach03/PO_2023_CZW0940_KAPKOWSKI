package agh.ics.oop;


import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    public void testparse() {
        String[] args1 = {"f", "b", "r", "l"};
        MoveDirection[] expectedDirections1 = {
                MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT
        };

        assertArrayEquals(expectedDirections1, OptionsParser.parse(args1));

        String[] args2 = {"f", "x", "r", "z"};
        MoveDirection[] expectedDirections2 = {
                MoveDirection.FORWARD, MoveDirection.RIGHT
        };

        assertArrayEquals(expectedDirections2, OptionsParser.parse(args2));

        String[] args3 = {};
        MoveDirection[] expectedDirections3 = {};

        assertArrayEquals(expectedDirections3, OptionsParser.parse(args3));
    }

}