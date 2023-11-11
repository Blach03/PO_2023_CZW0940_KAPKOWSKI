package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;



public class SimulationTest {

    @Test
    public void testSimulation() {
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

        String[] args1 = {"f", "b", "a", "x", "r", "l"};
        List<MoveDirection> directions1 = OptionsParser.parse(args1);
        Simulation simulation1 = new Simulation(positions, directions1);
        simulation1.run();

        //orientacja
        assertEquals("Wschód", simulation1.getAnimals().get(0).getOrientation().toString());
        assertEquals("Zachód", simulation1.getAnimals().get(1).getOrientation().toString());

        String[] args2 = {"f", "b", "x", "a", "r", "l", "f", "f", "f", "f"};
        List<MoveDirection> directions2 = OptionsParser.parse(args2);
        Simulation simulation2 = new Simulation(positions, directions2);
        simulation2.run();

        //pozycja
        assertEquals(new Vector2d(4, 3), simulation2.getAnimals().get(0).getPosition());
        assertEquals(new Vector2d(1, 3), simulation2.getAnimals().get(1).getPosition());

        String[] args3 = {"b", "f", "b", "f", "b", "f", "b", "f"};
        List<MoveDirection> directions3 = OptionsParser.parse(args3);
        Simulation simulation3 = new Simulation(positions, directions3);
        simulation3.run();

        //granice
        assertTrue(simulation3.getAnimals().get(0).isAt(new Vector2d(2, 0)));
        assertTrue(simulation3.getAnimals().get(1).isAt(new Vector2d(3, 4)));
    }
}