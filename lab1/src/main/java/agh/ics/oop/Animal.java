package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class Animal{
    static void run(MoveDirection[] directions) {
        System.out.println("Start");
        for (MoveDirection direction : directions) {
            switch (direction) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak idzie w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak idzie w lewo");
                    break;
                default:
                    System.out.println("błąd");
            }
        }
        System.out.println("Stop");
    }
}