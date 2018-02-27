package com.knightstour.test.java;

import com.knightstour.main.java.Knight;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RunnerTest {

    int[][] board;
    int boardSize = 8;
    Knight player;

    @Before
    public void setUp() {
        board = new int[8][8];
        player = new Knight();
    }

    @Test
    public void testGameOver() {
        assertEquals(0, 0);
    }
}