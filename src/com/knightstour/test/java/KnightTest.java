package com.knightstour.test.java;

import com.knightstour.main.java.Knight;
import com.knightstour.main.java.Point;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class KnightTest {

    int[][] board;
    int boardSize = 8;
    Knight player;

    @Before
    public void setUp() {
        board = new int[8][8];
        player = new Knight();
    }

    @Test
    public void testAvailableSquaresCorner() {
        List<Point> moves = player.availableSquares(board);
        assertEquals(2, moves.size());
    }

    @Test
    public void testAvailableSquaresMiddle() {
        //Put knight in middle of board
        player = new Knight(3, 3);
        List<Point> moves = player.availableSquares(board);
        assertEquals(8, moves.size());
    }

    @Test
    public void testAvailableSquaresEdge() {
        player = new Knight(0, 3);
        List<Point> moves = player.availableSquares(board);
        assertEquals(4, moves.size());
    }

    @Test
    public void testAvailableSquaresHalfMiddle() {
        //Also puts the knight in the middle of the board, but marks one half of the board as being visited
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 1;
            }
        }

        player = new Knight(3, 3);

        List<Point> moves = player.availableSquares(board);
        assertEquals(4, moves.size());
    }

    @Test
    public void testAvailableSquaresCornerNone() {
        board[1][2] = 1;
        board[2][1] = 1;
        List<Point> moves = player.availableSquares(board);
        assertEquals(0, moves.size());
    }
}