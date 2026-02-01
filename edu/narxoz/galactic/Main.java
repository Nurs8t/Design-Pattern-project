package edu.narxoz.galactic;

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.drones.HeavyDrone;
import edu.narxoz.galactic.drones.LightDrone;
import edu.narxoz.galactic.task.DeliveryTask;

public class Main{
    public static void main(String[] args) {
        Planet earth = new Planet("Earth", 0, 0, "Oxygen");
        SpaceStation marsStation = new SpaceStation("Mars Station", 100, 0, 3);

        Cargo heavyCargo = new Cargo(50, "Mining equipment");

        LightDrone light = new LightDrone("LD-1", 10);
        HeavyDrone heavy = new HeavyDrone("HD-1", 100);

        DeliveryTask task = new DeliveryTask(earth, marsStation, heavyCargo);
        Dispatcher dispatcher = new Dispatcher();

        System.out.println(dispatcher.assignTask(task, light));
        System.out.println(dispatcher.assignTask(task, heavy));

        System.out.println("Estimated time: " + task.estimateTime());

        System.out.println(dispatcher.completeTask(task));
        System.out.println("Drone status: " + heavy.getStatus());
        System.out.println("Task state: " + task.getState());
    }
}
