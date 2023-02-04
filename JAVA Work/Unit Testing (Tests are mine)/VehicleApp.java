/* 
 * Assignment: #3
 * Topic: Classifying vehicles
 * Author: Dan Walker
 */
package edu.depaul.vehicle;

import static edu.depaul.vehicle.VehicleType.UNICYCLE;
import static edu.depaul.vehicle.VehicleType.BICYCLE;
import static edu.depaul.vehicle.VehicleType.MOTORCYCLE;
import static edu.depaul.vehicle.VehicleType.CAR;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is a rudimentary user interface for the Vehicle classification
 * problem.  It collects a string of values from the user and attempts to use
 * it as parameters for creating a Vehicle.
 */
public class VehicleApp {

  private static final Logger logger = LoggerFactory.getLogger(VehicleApp.class);
    
  private String[] getArgs(Scanner scanner) {
    System.out.println("press Enter by itself to quit");
    System.out.println("enter 3 integers separated by space.");
    String args = scanner.nextLine();
    return args.split(" ");
  }
  
  public void run() {
    try (Scanner scanner = new Scanner(System.in)) {
      String[] args = getArgs(scanner);
      while (args[0].length() != 0) {
        try {
          Vehicle v = new Vehicle(args);
          VehicleType vehicleClass = v.classify();
          System.out.println("Vehicle class: " + vehicleClass);
        } catch (IllegalArgumentException e) {
          logger.error("Invalid input: " + e.getMessage());
        }
        args = getArgs(scanner);
      }
      System.out.println("Done");
    }
  }

  public static void main(String[] args) {
    new VehicleApp().run();
  }
}
