package com.knightstour.main.java;

import java.util.List;
import java.util.Scanner;

public class Runner {
    private int size = 8;
    //I really hate using ints for the board but this is just temporary. We'll use an Enum when we actually do this
    //As current impl, 0 means it hasn't been visited and can't be, 1 is current location, 2 is available locations, 3 is visited
    private int[][] board = new int[size][size];
    private Knight player;
    private List<Point> possibleMoves;

    Scanner reader = new Scanner(System.in);

    public void run() {
        //I tried breaking everything into fairly small parts to make testing a bit easier.
        initialize();

        //While there are moves available..
        do {
            possibleMoves = player.availableSquares(board);
            //Properly mark visited/current location/etc...
            markBoard();
            printBoard(); //For testing
            //Get user's next move
            Point nextMove = getNextMove();
            //Make all actions involved with making the move
            makeMove(nextMove);
            //Find next set of moves
        } while (!isGameOver());

        //Lastly, check to see if they won or not
        reader.close();
    }

    private void initialize() {
        //If we ever want to change these values we can. It's safe to always start on 0, 0 due to changing board sizes
        //Default constructor sets to 0, 0
        player = new Knight();
        board[0][0] = 1;
    }

    private void markBoard() {
        //Mark all past existing available moves as unreached again
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }
        for(Point p: possibleMoves) {
            board[p.getX()][p.getY()] = 2;
        }
    }

    private Point getNextMove() {
        int x = -1;
        int y = -1;

        boolean possible = false;

        while(!possible) {
            x = -1;
            y = -1;
            //Read in an x and y value
            while (x < 1 || x > size) {
                System.out.println("Enter x value: ");
                x = reader.nextInt(); // Scans the next token of the input as an int.
                if (x < 1 || x > size) {
                    System.out.println("Please enter a value between 0 and " + size);
                }
            }

            while (y < 1 || y > size) {
                System.out.println("Enter y value: ");
                y = reader.nextInt(); // Scans the next token of the input as an int.
                if (y < 1 || y > size) {
                    System.out.println("Please enter a value between 0 and " + size);
                }
            }

            //Decrement each since the board will display values, i.e., 1-8 when the array holds 0-7
            x--;
            y--;

            possible = validMove(x, y);
        }

        return new Point(x, y);
    }

    private boolean validMove(int x, int y) {
        return board[x][y] == 2;
    }

    private void makeMove(Point p) {
        //Set location as visited, move, then set as occupied
        board[player.getX()][player.getY()] = 3;
        player.setX(p.getX());
        player.setY(p.getY());
        board[player.getX()][player.getY()] = 1;
    }

    private boolean isGameOver() {
        if (possibleMoves.isEmpty()) {
            return true;
        }
        return false;
    }

    private void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
