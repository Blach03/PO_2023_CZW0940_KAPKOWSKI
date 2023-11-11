package agh.ics.oop;


import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


    public class OptionsParserTest {

        @Test
        public void testParse() {
            String[] args1 = {"f", "b", "r", "l"};
            MoveDirection[] expectedDirections1 = {
                    MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT
            };

            assertArrayEquals(expectedDirections1, OptionsParser.parse(args1).toArray());

            String[] args2 = {"f", "x", "r", "z"};
            MoveDirection[] expectedDirections2 = {
                    MoveDirection.FORWARD, MoveDirection.RIGHT
            };

            assertArrayEquals(expectedDirections2, OptionsParser.parse(args2).toArray());

            String[] args3 = {};
            MoveDirection[] expectedDirections3 = {};

            assertArrayEquals(expectedDirections3, OptionsParser.parse(args3).toArray());
        }
    }