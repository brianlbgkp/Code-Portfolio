package org.depaul.logic.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public final class Score {

    private final IntegerProperty score;
    private final int baseRowScore;
    private int currentLevel;
    private double levelSpeed;
    private int rowClearCount;

    public Score(){
        rowClearCount = 0;
        score = new SimpleIntegerProperty();
        baseRowScore = 50;
        currentLevel = 1;
        levelSpeed = 1;
    }


    public IntegerProperty scoreProperty() {
        return score;
    }

    private void add(int i){
        score.setValue(score.getValue() + i);
    }

    public void reset() {
        rowClearCount = 0;
        currentLevel = 1;
        levelSpeed = 1.0;
        score.setValue(0);
    }

    public int scoreRow(int numRows){
        rowClearCount += numRows;
        int i = baseRowScore * numRows * getLevel();
        add(i);
        setLevel();
        return i;
    }

    public int getRowClearCount(){
        return rowClearCount;
    }

    public void setLevel() {
        if (getRowClearCount() <= 5) {
            levelSpeed = 1.0;
            currentLevel = 1;
        }
        else if (getRowClearCount() <= 10) {
            levelSpeed = 1.15;
            currentLevel = 2;
        }
        else if (getRowClearCount() <= 20) {
            levelSpeed = 1.30;
            currentLevel = 3;
        }
        else if (getRowClearCount() <= 30) {
            levelSpeed = 1.45;
            currentLevel = 4;
        }
        else if (getRowClearCount() <= 40) {
            levelSpeed = 1.60;
            currentLevel = 5;
        }
        else if (getRowClearCount() <= 50) {
            levelSpeed = 1.75;
            currentLevel = 6;
        }
        else if (getRowClearCount() <= 70) {
            levelSpeed = 1.90;
            currentLevel = 7;
        }
        else if (getRowClearCount() <= 90) {
            levelSpeed = 2.05;
            currentLevel = 8;
        }
        else if (getRowClearCount() <= 110) {
            levelSpeed = 2.20;
            currentLevel = 9;
        }
        else if (getRowClearCount() <= 140) {
            levelSpeed = 2.35;
            currentLevel = 10;
        }
        else if (getRowClearCount() <= 170) {
            levelSpeed = 2.50;
            currentLevel = 11;
        }
        else if (getRowClearCount() <= 200) {
            levelSpeed = 2.65;
            currentLevel = 12;
        }
        else if (getRowClearCount() <= 250) {
            levelSpeed = 2.80;
            currentLevel = 13;
        }
        else if (getRowClearCount() <= 300) {
            levelSpeed = 2.95;
            currentLevel = 14;
        }
        else if (getRowClearCount() <= 350) {
            levelSpeed = 3.10;
            currentLevel = 15;
        }
        else if (getRowClearCount() <= 400) {
            levelSpeed = 3.25;
            currentLevel = 16;
        }
        else {
            levelSpeed = 3.40;
            currentLevel = 17;
        }

    }

    public int getLevel() {
        return currentLevel;
    }

    public double getLevelSpeed() {
        return levelSpeed;
    }

}
