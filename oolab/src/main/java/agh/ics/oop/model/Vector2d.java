package agh.ics.oop.model;


import java.util.Objects;

public class Vector2d {
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    final private int x;
    final private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other){
        return other.x >= this.x && other.y >= this.y;
    }

    public boolean follows(Vector2d other) {
        return other.x <= this.x && other.y <= this.y;
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(other.x+ this.x,other.y+ this.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public Vector2d upperRight(Vector2d other){
        int x;
        if (this.x > other.x){
            x = this.x;
        }
        else x = other.x;
        int y;
        if (this.y > other.y){
            y = this.y;
        }
        else y = other.y;
        return new Vector2d(x,y);
    }

    public Vector2d lowerLeft(Vector2d other){
        int x;
        if (this.x < other.x) x = this.x;
        else x = other.x;
        int y;
        if (this.y < other.y) y = this.y;
        else y = other.y;
        return new Vector2d(x,y);
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
