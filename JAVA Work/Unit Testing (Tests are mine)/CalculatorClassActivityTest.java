package com.depaul.gsd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorClassActivityTest {

    CalculatorClassActivity test;

    @BeforeEach
    void initialize(){
        test = new CalculatorClassActivity();
    }

    @Test
    @DisplayName("AssertEquals Initial Value")
    void getInitialValue() {
        //CalculatorClassActivity test = new CalculatorClassActivity();

        int expected = 0;
        int actual = test.getValue();

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("AssertEquals Addition")
    void getAdditionValue(){
        //CalculatorClassActivity test = new CalculatorClassActivity();
        test.add(7);

        int expected = 7;
        int actual = test.getValue();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("AssertEquals Subtraction")
    void getSubtractionValue(){
        //CalculatorClassActivity test = new CalculatorClassActivity();
        test.subtract(10);

        int expected = -10;
        int actual = test.getValue();

        assertEquals(expected, actual);
    }

}