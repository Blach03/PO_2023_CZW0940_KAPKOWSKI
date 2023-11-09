package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

public class World {
    public static void main(String[] args)  {
        System.out.println("system wystartował");

        MoveDirection[] directions = OptionsParser.parse(args);

        Animal.run(directions);

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection direction = MapDirection.NORTH;
        System.out.println(direction); //"Północ"
        MapDirection nextDirection = direction.next();
        System.out.println(nextDirection); //"Wschód"
        MapDirection prevDirection = direction.previous();
        System.out.println(prevDirection); //"Zachód"
        Vector2d unitVector = direction.toUnitVector();
        System.out.println(unitVector); //"(0,1)"

        System.out.println("system zakończył działanie");
    }
}