/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.checkers;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Dakota Carpenter
 */
public class CPieceTest {
   private LinkedList<CPiece> cp;
    public CPieceTest() {
    }
    
    @Before
    public void initialize(){
        cp = new LinkedList<>();
    
    }
    @Test
    public void testPiecesExist(){
        
        CPiece instance = new CPiece(0, 0, true, cp);
        CPiece instance1 = new CPiece(1, 1, false, cp);
        assertTrue(cp.contains(instance));
        assertTrue(cp.contains(instance1));
        
    
    }

    /**
     * Test of isRed method, of class CPiece.
     */
    @Test
    public void testIsRed() {
      
        System.out.println("isRed");
        CPiece instance = new CPiece(0, 0, true, cp);
        CPiece instance1 = new CPiece(0, 0, false, cp);
        boolean expResult = true;
        boolean result = instance.isRed();
        assertEquals(expResult, result);
        
        expResult = false;
        result = instance1.isRed();
        assertEquals(expResult, result);
        
    }

  
    
}
