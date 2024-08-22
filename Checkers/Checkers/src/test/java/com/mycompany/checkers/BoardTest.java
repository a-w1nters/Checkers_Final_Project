package com.mycompany.checkers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    private int[][] board;
    private Game game;
    private Board b;

    @Before
    public void setUp() {
        game = new Game();
        b = new Board();
    }

    @Test
    public void testBoard() {
        board = b.getBoard();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (row == 0 && col % 2 == 0) {
                    assertEquals(1, board[row][col]);
                } else if (row == 1 && col % 2 == 1) {
                    assertEquals(1, board[row][col]);
                } else if (row == 2 && col % 2 == 0) {
                    assertEquals(1, board[row][col]);
                } else if (row == 3 || row == 4) {
                    assertEquals(0, board[row][col]);
                } else if (row == 5 && col % 2 == 1) {
                    assertEquals(2, board[row][col]);
                } else if (row == 6 && col % 2 == 0) {
                    assertEquals(2, board[row][col]);
                } else if (row == 7 && col % 2 == 1) {
                    assertEquals(2, board[row][col]);
                }
            }
        }
    }

}
