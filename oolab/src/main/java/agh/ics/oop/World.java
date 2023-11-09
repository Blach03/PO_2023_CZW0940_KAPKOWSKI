package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;


public class World {
    public static void main(String[] args)  {
        System.out.println("system wystartował");

        MoveDirection[] directions = OptionsParser.parse(args);

        Animal.run(directions);

        System.out.println("system zakończył działanie");
    }
}