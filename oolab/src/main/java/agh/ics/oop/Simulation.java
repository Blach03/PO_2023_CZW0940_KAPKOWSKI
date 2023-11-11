package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals;
    private final List<MoveDirection> moves;

    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> moves) {
        this.animals = new ArrayList<>();
        for (Vector2d position : initialPositions) {
            this.animals.add(new Animal(position));
        }
        this.moves = moves;
    }

    public void run() {
        int animalsCount = animals.size();
        int movesCount = moves.size();

        for (int i = 0; i < movesCount; i++) {
            Animal currentAnimal = animals.get(i % animalsCount);
            MoveDirection currentMove = moves.get(i);

            currentAnimal.move(currentMove);
            System.out.println("Zwierzę " + (i % animalsCount + 1) + ": " + currentAnimal.toString());
        }
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

}