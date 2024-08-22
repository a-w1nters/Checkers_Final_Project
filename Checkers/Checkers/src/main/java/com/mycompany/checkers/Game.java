
package com.mycompany.checkers;

/**
 * @author Austin Winters, Dakota Carpenter
 */

public class Game {
    private boolean validate;
    private boolean isFull;
    private boolean pdestroy;
    private int redCount, redKingCount, blackCount, blackKingCount;
    private int[][] board;
    private int[] selectedPiece;

   
    public Game(){
        this.validate = false;
        this.isFull = false;
        this.pdestroy = false;

        board = Board.getBoard();
        redCount = 12;
        blackCount = 12;
        redKingCount = 0;
        blackKingCount = 0;

    }

    // Returns the amount of normal red pieces on the board
    public int getRedCount() {
        return redCount;
    }

    // Returns the amount of king red pieces on the board
    public int getRedKingCount() {
        return redKingCount;
    }

    // Returns the amount of normal black pieces on the board
    public int getBlackCount() {
        return blackCount;
    }

    // Returns the amount of king black pieces on the board
    public int getBlackKingCount() {
        return blackKingCount;
    }

    // Returns the piece that is currently selected by the mouse
    public int[] getSelectedPiece() {
        return selectedPiece;
    }

    // Sets the selected piece given a row and column
    public void setSelectedPiece(int row, int col) {
        selectedPiece = new int[]{row, col};
    }

    // Tests if a valid move was selected and then moves the piece if there was
    public void movePiece(int row, int col, boolean isRed) {
        if (isValidMove(selectedPiece[0], selectedPiece[1], row, col, isRed)) {

            if (row == 0 && board[selectedPiece[0]][selectedPiece[1]] == 2) {
                blackCount--;
                blackKingCount++;
                board[row][col] = 4;
                board[selectedPiece[0]][selectedPiece[1]] = 0;
            } else if (row == 7 && board[selectedPiece[0]][selectedPiece[1]] == 1) {
                redCount--;
                redKingCount++;
                board[row][col] = 3;
                board[selectedPiece[0]][selectedPiece[1]] = 0;
            } else {
                board[row][col] = board[selectedPiece[0]][selectedPiece[1]];
                board[selectedPiece[0]][selectedPiece[1]] = 0;
            }
        }
        selectedPiece = null;
    }

    // Contains the logic for valid or invalid moves. Returns true if the move was valid.
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, boolean isRed) {
        // Checks if the end position is within the board
        if (endRow < 0 || endRow > 7 || endCol < 0 || endCol > 7) {
            return false;
        }
        // Checks if the end position is empty
        if (board[endRow][endCol] != 0) {
            return false;
        }
        // Checks if the move is diagonal
        if (Math.abs(endRow - startRow) != Math.abs(endCol - startCol)) {
            return false;
        }
        // Checks if the piece is moving in the correct direction
        if (board[startRow][startCol] == 2 && endRow > startRow) {
            return false;
        } else if (board[startRow][startCol] == 1 && endRow < startRow) {
            return false;
        }
        // Checks if the move is regular or jump
        if (Math.abs(endRow - startRow) == 1) {
            return true;
        }
        // Checks if there is a piece being jumped
        int jumpedRow = (startRow + endRow) / 2;
        int jumpedCol = (startCol + endCol) / 2;
        if (board[jumpedRow][jumpedCol] == 0) {
            return false;
        }
        // Checks if a piece is trying to jump its own color
        if (board[startRow][startCol] == board[jumpedRow][jumpedCol]) {
            return false;
        }
        // Removes jumped pieces
        if (Math.abs(endRow - startRow) == 2) {
            int midRow = (startRow + endRow) / 2;
            int midCol = (startCol + endCol) / 2;
            // Checks if piece is your own
            if (board[startRow][startCol] == board[midRow][midCol]) {
                return false;
            } else if (board[startRow][startCol] == 3 && board[midRow][midCol] == 1) {
                return false;
            } else if (board[startRow][startCol] == 4 && board[midRow][midCol] == 2) {
                return false;
            } else if (board[startRow][startCol] == 1 && board[midRow][midCol] == 3) {
                return false;
            } else if (board[startRow][startCol] == 2 && board[midRow][midCol] == 4) {
                return false;
            } else {
                if (board[midRow][midCol] == 1) {
                    redCount--;
                } else if (board[midRow][midCol] == 2) {
                    blackCount--;
                } else if (board[midRow][midCol] == 3) {
                    redKingCount--;
                } else if (board[midRow][midCol] == 4) {
                    blackKingCount--;
                }
                board[midRow][midCol] = 0;
            }
        }
        return true;
    }

}
