/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author udesc
 */
public class BoardTest {
    
    public BoardTest() {
    }
   
    @Test
    public void testCheckDraw() {
        System.out.println("checkDraw");
        Board b = new Board();
        int[][] boardTest = {{0,0,-1},{-1,1,1},{1,-1,-1}};
        b.setBoard(boardTest);
        assertTrue(b.checkDraw(2));
    }

   
}
