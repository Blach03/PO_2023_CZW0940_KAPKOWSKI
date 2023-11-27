package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class GrassField extends AbstractWorldMap {
    private final List<Grass> grassList;

    public GrassField(int grassCount) {
        super();
        this.grassList = new ArrayList<>();
        placeGrass(grassCount);
    }


    private void placeGrass(int grassCount) {
        Random random = new Random();
        int gridSize = (int) Math.sqrt(grassCount * 10);

        for (int i = 0; i < grassCount; i++) {
            Vector2d randomPosition;
            do {
                int x = random.nextInt(gridSize);
                int y = random.nextInt(gridSize);
                randomPosition = new Vector2d(x, y);
            } while (isOccupied(randomPosition));

            Grass grass = new Grass(randomPosition);
            grassList.add(grass);
        }
    }

    @Override
    protected List<Grass> getGrassList() {
        return grassList;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return true;
    }
}