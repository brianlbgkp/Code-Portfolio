package org.depaul.logic.board;

import org.depaul.gui.GuiController;
import org.depaul.logic.data.Score;
import org.depaul.logic.data.ViewData;
import org.depaul.logic.events.MoveEvent;

public interface Board {

    boolean staticBrickMove(MoveEvent event);
    boolean rotateBrick();
    boolean createNewBrick();

    int[][] getBoardMatrix();

    ViewData getViewData();

    void mergeBrickToBackground();

    Score getScore();

    void newGame();

    int[] checkForLines();

    void clearLines(GuiController gui);

}
