package agh.ics.oop.model;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    public Animal() {
        this.position = new Vector2d(2, 2);
        this.orientation = MapDirection.NORTH;
    }

    public Animal(Vector2d initialPosition) {
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    public String toString() {
        return "Position: " + position.toString() + ", Orientation: " + orientation.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD:
                moveForward();
                break;
            case BACKWARD:
                moveBackward();
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

    private void moveForward() {
        Vector2d unitVector = this.orientation.toUnitVector();
        this.position = this.position.add(unitVector);
    }

    private void moveBackward() {
        Vector2d unitVector = this.orientation.toUnitVector();
        this.position = this.position.subtract(unitVector);
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
