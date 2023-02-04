package org.depaul.logic.events;

import org.depaul.gui.GuiController;
import org.depaul.logic.board.Board;
import org.depaul.logic.board.SimpleBoard;
import org.depaul.logic.data.ViewData;

import java.util.concurrent.ThreadLocalRandom;

public class GameController implements InputEventListener {

    private final Board board = new SimpleBoard(25, 10);

    private final GuiController viewGuiController;

    public GameController(GuiController c) {
        viewGuiController = c;
        board.createNewBrick();
        viewGuiController.setEventListener(this);
        viewGuiController.initGameView(board.getBoardMatrix(), board.getViewData());
        viewGuiController.bindScore(board.getScore().scoreProperty());
    }

    @Override
    public ViewData onMoveEvent(MoveEvent event) {
        boolean movable = board.staticBrickMove(event);
        if (!movable) {
            board.mergeBrickToBackground();
            board.clearLines(viewGuiController);
            if (board.createNewBrick()) {
                viewGuiController.gameOver();
            }
            viewGuiController.updateLevel(board.getScore().getLevel());
            viewGuiController.refreshGameBackground(board.getBoardMatrix());
        } else {
            if (event.getEventSource() == EventSource.USER) {
               // board.getScore().add(ThreadLocalRandom.current().nextInt(100));
            }
        }
        return board.getViewData();
    }

    @Override
    public ViewData onRotateEvent(MoveEvent event) {
        boolean movable = board.rotateBrick();
        if (!movable) {
            viewGuiController.updateLevel(board.getScore().getLevel());
            viewGuiController.refreshGameBackground(board.getBoardMatrix());
        }
        return board.getViewData();
    }

    @Override
    public void createNewGame() {
        board.getScore().reset();
        board.newGame();
        viewGuiController.refreshLevelSpeed(board.getScore().getLevelSpeed());
        viewGuiController.refreshGameBackground(board.getBoardMatrix());
    }
}
