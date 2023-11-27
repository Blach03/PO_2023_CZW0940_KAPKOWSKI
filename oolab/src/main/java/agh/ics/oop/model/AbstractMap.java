package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractWorldMap implements WorldMap {
    protected final List<Animal> animals;

    public AbstractWorldMap() {
        this.animals = new ArrayList<>();
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        Vector2d newPosition = animal.getPosition();

        if (!oldPosition.equals(newPosition)) {
            animals.remove(animal);
            animals.add(animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return (Animal) animal;
            }
        }
        return null;
    }


    public Collection<WorldElement> getElements() {
        List<WorldElement> elements = new ArrayList<>(animals);
        elements.addAll(getGrassList());
        return elements;
    }

    protected abstract List<Grass> getGrassList();

    public abstract boolean canMoveTo(Vector2d position);
}