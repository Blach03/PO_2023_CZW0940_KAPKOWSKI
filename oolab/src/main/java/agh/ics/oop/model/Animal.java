package agh.ics.oop.model;
import agh.ics.oop.model.RectangularMap;
public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    public Animal(Vector2d initialPosition) {
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    public void move(MoveDirection direction, MoveValidator moveValidator) throws PositionAlreadyOccupiedException {
        switch (direction) {
            case FORWARD:
                moveForward(moveValidator);
                break;
            case BACKWARD:
                moveBackward(moveValidator);
                break;
            case RIGHT:
                turnRight();
                break;
            case LEFT:
                turnLeft();
                break;
        }

        this.position = this.position.upperRight(new Vector2d(0, 0));
        this.position = this.position.lowerLeft(new Vector2d(4, 4));
    }

    public String toString() {
        return orientation.toString();
    }
    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }



    private void moveForward(MoveValidator moveValidator) throws PositionAlreadyOccupiedException {
        Vector2d potentialNewPosition = position.add(orientation.toUnitVector(MoveDirection.FORWARD));
        if (moveValidator.canMoveTo(potentialNewPosition)) {
            position = potentialNewPosition;
        }
    }

    private void moveBackward(MoveValidator moveValidator) throws PositionAlreadyOccupiedException {
        Vector2d potentialNewPosition = position.add(orientation.toUnitVector(MoveDirection.BACKWARD));
        if (moveValidator.canMoveTo(potentialNewPosition)) {
            position = potentialNewPosition;
        }
    }

    private void turnRight() {
        this.orientation = this.orientation.next();
    }

    private void turnLeft() {
        this.orientation = this.orientation.previous();
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }
}
