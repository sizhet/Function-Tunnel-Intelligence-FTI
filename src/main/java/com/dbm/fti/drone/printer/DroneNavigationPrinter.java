package com.dbm.fti.drone.printer;

import com.dbm.fti.drone.model.NavigationResult;

public class DroneNavigationPrinter {

    public void print(
            String mode,
            NavigationResult result) {

        System.out.println("--------------------------------");
        System.out.println("Mode: " + mode);
        System.out.println("Result: " + result.getMessage());

        if (result.isSuccess()) {
            System.out.println("MISSION STATUS: SURVIVED");
        } else {
            System.out.println("MISSION STATUS: FAILED");
        }
    }
}