package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private final int width;
    private final int height;
    private final Map<Vector2d, Animal> animals;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.animals = new HashMap<>();
    }

    @Override
    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
        } else {
            throw new PositionAlreadyOccupiedException(animal.getPosition());
        }
    }

    @Override
    public Object getId() {
        return this;
    }

    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));
    }

    @Override
    public synchronized void move(Animal animal, MoveDirection direction) throws PositionAlreadyOccupiedException {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        Vector2d newPosition = animal.getPosition();

        if (!oldPosition.equals(newPosition) && animals.containsKey(oldPosition)) {
            animals.remove(oldPosition);
            animals.put(newPosition, animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) throws PositionAlreadyOccupiedException {
        if (position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(width - 1, height - 1)) && !isOccupied(position)) {
            return true;
        } else {
            throw new PositionAlreadyOccupiedException(position);
        }
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(getCurrentBounds().lowerLeft(), getCurrentBounds().upperRight());
    }
}