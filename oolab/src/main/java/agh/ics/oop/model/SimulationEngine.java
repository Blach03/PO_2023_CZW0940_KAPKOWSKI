package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine {
    private final List<Simulation> simulations;

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }


    public void runSync(List<MoveDirection> moves) throws PositionAlreadyOccupiedException {
        for (Simulation simulation : simulations) {
            simulation.run(moves);
        }
    }

    public void runAsync(List<MoveDirection> moves) throws PositionAlreadyOccupiedException {
        List<Thread> threads = new ArrayList<>();

        for (Simulation simulation : simulations) {
            Thread thread = new Thread(simulation.run(moves));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void awaitSimulationsEnd() {
        for (Simulation simulation : simulations) {
            simulation.awaitEnd();
        }
    }


}