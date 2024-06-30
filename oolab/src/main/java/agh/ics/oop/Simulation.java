package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.PositionAlreadyOccupiedException;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final RectangularMap map;
    private final List<Animal> animals;

    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> moves) throws PositionAlreadyOccupiedException {
        this.map = new RectangularMap(5, 5);
        this.animals = new ArrayList<>();
        for (Vector2d position : initialPositions) {
            Animal animal = new Animal(position);
            try {
                map.place(animal);
                this.animals.add(animal);
            } catch (PositionAlreadyOccupiedException e) {
                System.err.println(e.getMessage());
            }
        }
        this.run(moves);
    }

    public void run(List<MoveDirection> moves) throws PositionAlreadyOccupiedException {
        int animalsCount = animals.size();
        int movesCount = moves.size();

        for (int i = 0; i < movesCount; i++) {
            Animal currentAnimal = animals.get(i % animalsCount);
            MoveDirection currentMove = moves.get(i);

            map.move(currentAnimal, currentMove);
            System.out.println(map);
        }
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    public void awaitEnd() {
    }
}