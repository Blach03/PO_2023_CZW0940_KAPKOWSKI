package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args)  {
        System.out.println("system wystartował");

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

        //run(directions);

        //Animal animal = new Animal();

        //System.out.println(animal.toString());

        System.out.println("system zakończył działanie");
    }



    static void run(List<MoveDirection> directions) {
        System.out.println("Start");
        for (MoveDirection direction : directions) {
            switch (direction) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak idzie w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak idzie w lewo");
                    break;
                default:
                    System.out.println("Błąd");
            }
        }
        System.out.println("Stop");
    }
}