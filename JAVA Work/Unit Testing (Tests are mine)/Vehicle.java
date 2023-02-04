/* 
 * Assignment: #3
 * Topic: Classifying Vehicles
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
 * Given a set of parameters:
 * - number of wheels
 * - number of seats
 * - maximum achievable speed
 * attempt to classify the input as describing a particular type
 * of vehicle (unicycle, bicycle, motor cycle or car)
 * You should not be able to create an invalid Vehicle.  The
 * constructor throws an IllegalArgumentException if the input
 * cannot be interpreted as a vehicle for any reason.
 */
public class Vehicle {

  private static final Logger logger = LoggerFactory.getLogger(Vehicle.class);
  private int wheels = 0;
  private int seats = 0;
  private int maxSpeed = 0;
  
  /**
   * Define as private so that it is not a valid
   * choice.
   */
  private Vehicle() {}
  
  public Vehicle(String[] args) {
    validateArgs(args);

    parseArgs(args);

    validateValues();
  }

  public VehicleType classify() {
    VehicleType result =  null;

    if (wheels == 1 && seats == 1) {
      result = UNICYCLE;
    } else if (wheels == 2 && seats <= 2) {
      if (maxSpeed < 35) {
        result = BICYCLE;
      } else {
        result = MOTORCYCLE;
      }
    } else if (wheels == 4) {
      result = CAR;
    }
    
    logger.debug("classified as: " + result);
    return result;
  }

  private void parseArgs(String[] args) {
    // throws IllegalArgumentException on a failed parse
    wheels = Integer.parseInt(args[0]);
    seats = Integer.parseInt(args[1]);
    maxSpeed = Integer.parseInt(args[2]);
  }

  private void validateArgs(String[] args) {
    if ((args == null) || (args.length != 3)) {
      throw new IllegalArgumentException("Must have 3 elements");
    }
  }

  private void validateValues() {
    if (wheels < 1 || wheels > 4) {
      throw new IllegalArgumentException("wheels must be 1,2, or 4");
    }

    if (seats < 1) {
      throw new IllegalArgumentException("seats must be between 1 and 7");
    }

    if (maxSpeed < 1) {
      throw new IllegalArgumentException("max speed must be greater than 1");
    }
  }
}
