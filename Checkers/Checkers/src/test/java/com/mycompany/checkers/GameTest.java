/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.checkers;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Austin Winters
 */
//@RunWith(Parameterized.class)
public class GameTest {
    //private Integer row, col;
    private Game game;
    public GameTest() {
       // this.row = row;
       // this.col = col;
        
    
    }
    
    @Test
    public void testSelectedPieces(){
        game = new Game();
        game.setSelectedPiece(0, 0);
       assertTrue(game.getSelectedPiece()!= null);
    
    }
    
    
    /**
     * Test of movePiece method, of class Game.
     */
    @Test
    public void testMovePiece() {
        System.out.println("movePiece");
        
        game = new Game();
        
        int r = 0;
        int c = 0;
        boolean isRed = false;
       game.setSelectedPiece(2, 3);
       
        game.movePiece(r, c, isRed);
        assertTrue(game.getSelectedPiece() == null);
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    

    /**
     * Test of isValidMove method, of class Game.
     */
    
    @Test
    public void testIsValidMove() {
        System.out.println("isValidMove");
        int startRow = 0;
        int startCol = 0;
        int endRow = 0;
        int endCol = 0;
        boolean isRed = false;
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.isValidMove(startRow, startCol, endRow, endCol, isRed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        startRow = 0;
        startCol = 0;
        endRow = -3;
        endCol = -3;
        isRed = true;
        expResult = false;
        result = instance.isValidMove(startRow, startCol, endRow, endCol, isRed);
        assertEquals(expResult, result);
        
        startRow = 0;
        startCol = 2;
        endRow = 4;
        endCol = 3;
        isRed = true;
        expResult = false;
        result = instance.isValidMove(startRow, startCol, endRow, endCol, isRed);
        assertEquals(expResult, result);
        
        startRow = 0;
        startCol = 0;
        endRow = -3;
        endCol = -3;
        isRed = true;
        expResult = false;
        result = instance.isValidMove(startRow, startCol, endRow, endCol, isRed);
        assertEquals(expResult, result);
        
        startRow = 4;
        startCol = 2;
        endRow = 3;
        endCol = 3;
        isRed = true;
        expResult = true;
        result = instance.isValidMove(startRow, startCol, endRow, endCol, isRed);
        assertEquals(expResult, result);
        
        startRow = 7;
        startCol = 2;
        endRow = 3;
        endCol = 3;
        isRed = false;
        expResult = false;
        result = instance.isValidMove(startRow, startCol, endRow, endCol, isRed);
        assertEquals(expResult, result);        
    }


 
    
}
