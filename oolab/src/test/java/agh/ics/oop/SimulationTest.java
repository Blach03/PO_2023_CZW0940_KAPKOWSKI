package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.PositionAlreadyOccupiedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;



public class SimulationTest {

    @Test
    public void testSimulation() throws PositionAlreadyOccupiedException {
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

        //zly ruch
        String[] args1 = {"f", "b", "a", "x", "r", "l"};
        List<MoveDirection> directions1 = OptionsParser.parse(args1);
        assertThrows(IllegalArgumentException.class, () -> new Simulation(positions, directions1));

        //sprawdzenie czy nie wchodzą na to samo pole
        String[] args2 = {"f", "b", "x", "a", "r", "l", "f", "f", "f", "f"};
        List<MoveDirection> directions2 = OptionsParser.parse(args2);
        assertThrows(PositionAlreadyOccupiedException.class, () -> new Simulation(positions, directions2));


        String[] args3 = {"b", "f", "b", "f", "b", "f", "b", "f"};
        List<MoveDirection> directions3 = OptionsParser.parse(args3);
        assertDoesNotThrow(() -> new Simulation(positions, directions3));
        Simulation simulation3 = new Simulation(positions, directions3);

        //granice
        assertTrue(simulation3.getAnimals().get(0).getPosition().precedes(new Vector2d(2, 0)));
        assertTrue(simulation3.getAnimals().get(1).getPosition().follows(new Vector2d(3, 4)));
    }
}