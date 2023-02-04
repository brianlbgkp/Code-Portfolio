package org.depaul.logic.board;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import org.depaul.gui.GuiController;
import org.depaul.logic.bricks.Brick;
import org.depaul.logic.bricks.BrickGenerator;
import org.depaul.logic.bricks.RandomBrickGenerator;
import org.depaul.logic.data.Score;
import org.depaul.logic.data.ViewData;
import org.depaul.logic.events.EventType;
import org.depaul.logic.events.MoveEvent;
import org.depaul.logic.rotator.BrickRotator;
import org.depaul.logic.util.Operations;

import java.awt.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SimpleBoard implements Board {

    private final int width;
    private final int height;
    private final BrickGenerator brickGenerator;
    private final BrickRotator brickRotator;
    private int[][] currentGameMatrix;
    private Point currentOffset;
    private final Score score;


    public SimpleBoard(int width, int height) {
        this.width = width;
        this.height = height;
        currentGameMatrix = new int[width][height];
        brickGenerator = new RandomBrickGenerator();
        brickRotator = new BrickRotator();
        score = new Score();
    }

    public boolean staticBrickMove(MoveEvent event) {
//        current matrix state
        int[][] currentMatrix = Operations.copyMatrix(currentGameMatrix);

        int[][] currentBrickMatrix = brickRotator.getCurrentShapeMatrix();

        int min_column_index = 0;
        int max_column_index = 0;

        int[] min_index = new int[currentBrickMatrix.length];
        int[] max_index = new int[currentBrickMatrix.length];

        // find the true start of the brick in the matrix.
        for (int x = 0; x < currentBrickMatrix.length; x++) {
            for (int y = 0; y < currentBrickMatrix[x].length; y++) {
                if (currentBrickMatrix[x][y] == 0) {
                    min_column_index += 1;
                } else {
                    break;
                }
            }
            min_index[x] = min_column_index;
            min_column_index = 0; // reset
        }

        // find the true end of the brick in the matrix.
        for (int x = currentBrickMatrix.length - 1; x >= 0; x--) {
            for (int y = currentBrickMatrix[x].length - 1; y >= 0; y--) {
                if (currentBrickMatrix[x][y] == 0) {
                    max_column_index += 1;
                } else {
                    break;
                }
            }
            max_index[x] = max_column_index;
            max_column_index = 0; // reset
        }

        Arrays.sort(min_index);
        Arrays.sort(max_index);

        //changed action to 1 since user input/rotate is not yet implemented
        //this action represents the game running when no input is given, so no random moves
        //bricks just fall to the floor of the playfield and pile till they reach the top
        int action = 1; // 0 for rotate - else for move

        if (action != 0) {
            //        current location
            Point p = new Point(currentOffset);
            int b_min_offset = p.x + min_index[0]; // the minimum offset
            int b_max_offset = p.x + currentBrickMatrix[0].length - max_index[0]; // the minimum offset

            if (event.getEventType() == EventType.SPACE) {
                Point newP = new Point(currentOffset);
                boolean conflict;
                do {
                    currentOffset = newP;
                    newP.translate(0, 1);
                    conflict = Operations.intersectMatrix(currentMatrix, currentBrickMatrix, (int) newP.getX(), (int) newP.getY());
                } while (!conflict);
                newP.translate(0, -1);
                return true;
            }

            // based off passed in Move.
            if (event.getEventType() == EventType.DOWN) {
                p.translate(0, 1);
            }
            if (event.getEventType() == EventType.LEFT) {
                if (b_min_offset <= 0) {
                    p.translate(0, 0); // do not go beyond the playing area.
                } else {
                    p.translate(-1, 0);
                }
            }
            if (event.getEventType() == EventType.RIGHT) {
                if (b_max_offset >= currentMatrix[0].length) {
                    p.translate(0, 0); // do not go beyond the playing area.
                } else {
                    p.translate(1, 0);
                }
            }
            //        do we have conflict with this move?
            boolean conflict = Operations.intersectMatrix(currentMatrix, currentBrickMatrix, (int) p.getX(), (int) p.getY());
            if (conflict) {
                //this should only conflict with the floor of the play field or any other bricks piled on floor
                //before returning false, we need to ask ourselves if DOWN is still a valid move.

                boolean no_other_move = Operations.intersectMatrix(currentMatrix, currentBrickMatrix, (int) currentOffset.getX(), (int) currentOffset.getY()+1);
                if(no_other_move) {
                    return false;
                } else {
                    return true;
                }
            } else {
                currentOffset = p;
                return true;
            }
        } else {
            return false;
        }

    }

    @Override
    public boolean rotateBrick() {
        int[][] currentMatrix = Operations.copyMatrix(currentGameMatrix);
        Point p = new Point(currentOffset);

        boolean conflict = Operations.intersectMatrix(currentMatrix, brickRotator.getNextShapeMatrix(), (int) p.getX(), (int) p.getY());

        if (conflict) {
            return false;
        } else {
            brickRotator.setCurrentShapeIndex(brickRotator.getNextShapeIndex());
            return true;
        }
    }

    @Override
    public boolean createNewBrick() {
        Brick currentBrick = brickGenerator.getBrick();
        brickRotator.setBrick(currentBrick);
        currentOffset = new Point(3, 0);
        return Operations.intersectMatrix(currentGameMatrix, brickRotator.getCurrentShapeMatrix(), (int) currentOffset.getX(), (int) currentOffset.getY());
    }

    @Override
    public int[][] getBoardMatrix() {
        return currentGameMatrix;
    }

    @Override
    public ViewData getViewData() {
        return new ViewData(brickRotator.getCurrentShapeMatrix(), (int) currentOffset.getX(), (int) currentOffset.getY(), brickGenerator.getNextBrick().getBrickMatrixList().get(0));
    }

    @Override
    public void mergeBrickToBackground() {
        currentGameMatrix = Operations.mergeMatrix(currentGameMatrix, brickRotator.getCurrentShapeMatrix(), (int) currentOffset.getX(), (int) currentOffset.getY());
    }

    @Override
    public Score getScore() {
        return score;
    }


    @Override
    public void newGame() {
        currentGameMatrix = new int[width][height];
        score.reset();
        createNewBrick();
    }


    /*  This method will need to be ran on the background board that is used to maintain the status of the bricks that have already been placed.
    	We can also use this method to then get the length of the array we return for use in calculating the score multiplier. (length of the array would = lines cleared)
        The Array we return will never be over 4 since no brick is over 4 spaces in length
    */
    @Override
    public int[] checkForLines() {
        ArrayList<Integer> rowsToClear = new ArrayList<Integer>(); //I do not believe you can return an ArrayList so this is used to have a dynamic array we can add to
        for (int i = 0; i < currentGameMatrix.length; i++) {
            boolean full = false; //will be made True if the row is full
            int numUsed = 0; //this variable will track to see how much of the row is full
            for (int y = 0; y < currentGameMatrix[i].length; y++) {
                if (currentGameMatrix[i][y] > 0) {
                    numUsed++;
                }
            }
            if (numUsed == currentGameMatrix[i].length) { //check to see if the whole array is full
                full = true;
            }
            if (full == true) { //if the row is full then add it to the list
                rowsToClear.add(i);
            }
        }
        if (rowsToClear.size() == 0) { //if there are no rows to be cleared then we return null
            return null;
        }
        int rowsToClearArray[] = new int[rowsToClear.size()]; //create an array that we can return to be used in another method
        for (int i = 0; i < rowsToClearArray.length; i++) { //add the elements of our ArrayList to the array we will return
            rowsToClearArray[i] = rowsToClear.get(i);
        }
        return rowsToClearArray;
    }

    @Override
    public void clearLines(GuiController gui) {
        int linesToBeCleared[] = checkForLines();
        int sumLines = 0;

        if (linesToBeCleared == null) {
            return;
        }
        for (int i : linesToBeCleared) {
            //Arrays.fill(currentGameMatrix[i], 0);
            if (i >= 0) {
                System.arraycopy(currentGameMatrix, 0, currentGameMatrix, 1, i);
                sumLines++;
            }

        }
        gui.pointsEarnedDisplay(score.scoreRow(sumLines));
        gui.refreshLevelSpeed(score.getLevelSpeed());

    }

}
