package com.depaul.gsd;


public class CalculatorClassActivity {

    private int value;

    public CalculatorClassActivity() {
        this.value = 0;
    }

    public void add(int number) {
        this.value = this.value + number;
    }

    public void subtract(int number) {
        this.value = this.value - number;
    }

    public int getValue() {
        return this.value;
    }
}