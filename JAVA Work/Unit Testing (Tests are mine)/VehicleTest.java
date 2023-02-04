/*
 * Assignment: #3
 * Topic: Identifying Vehicles
 * Author: Brian Salinas
 */
package edu.depaul.vehicle;

import static edu.depaul.vehicle.VehicleType.UNICYCLE;
import static edu.depaul.vehicle.VehicleType.BICYCLE;
import static edu.depaul.vehicle.VehicleType.MOTORCYCLE;
import static edu.depaul.vehicle.VehicleType.CAR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VehicleTest {

  /*
  This test uses a valid set of inputs for the Car classification and should pass
   */
  @Test
  @DisplayName("Check for a valid input that results in Car, assertion is true")
  void assertEqualsPasses() {
    VehicleType expected = CAR;
    Vehicle vehicle = new Vehicle(new String[] {"4", "4", "60"});
    VehicleType result = vehicle.classify();

    assertEquals(expected, result);
  }

  /*
  This test uses a valid set of inputs for the Bicycle classification and should fail
   */
  @Test
  @DisplayName("Check for an invalid input of Bicycle, assertion is false")
  void assertEqualFails(){
    VehicleType expected = BICYCLE;
    Vehicle vehicle = new Vehicle(new String[] {"2", "2", "35"});
    VehicleType result = vehicle.classify();

    assertEquals(expected, result);
  }

  /*
  This test uses an invalid set of inputs for the Wheels parameter that should throw an exception and should pass
   */
  @Test
  @DisplayName("Check for an invalid input of Wheels, assertion is true")
  void assertThrowsPasses(){
    assertThrows(IllegalArgumentException.class, () -> new Vehicle(new String[] {"5", "4", "60"}));
  }

  /*
  This test uses an invalid set of inputs for the Seats parameter that should throw an exception and should fail
   */
  @Test
  @DisplayName("Check for an invalid input of seats, assertion is false")
  void assertThrowsFails(){
    assertThrows(IllegalArgumentException.class, () -> new Vehicle(new String[] {"4", "10", "60"}));
  }
}
