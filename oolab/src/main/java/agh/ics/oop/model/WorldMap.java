package agh.ics.oop.model;

import java.util.Collection;

public interface WorldMap extends MoveValidator {
    boolean place(Animal animal);

    void move(Animal animal, MoveDirection direction);

    boolean isOccupied(Vector2d position);

    Animal objectAt(Vector2d position);

    Collection<WorldElement> getElements();
}