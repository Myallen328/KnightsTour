package com.knightstour.main.java;

import java.util.ArrayList;
import java.util.List;

//Even though the knight is very similar to the Point class, The point class has effectively final points whereas the knight will move
//I also pulled out the availableMoves function to make testing easier. It also kinda makes sense to have this class in charge of it...
public class Knight {
    private int x, y;

    public Knight() {
        x = 0;
        y = 0;
    }

    public Knight(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Point> availableSquares(int[][] board) {
        List<Point> nextMoves = new ArrayList<>();
        int size = board.length;

        //A little tedious but it'll do, maybe can clean this up a bit..
        if (x - 2 >= 0 && y - 1 >= 0 && board[x-2][y-1] == 0) {
            nextMoves.add(new Point(x-2, y-1));
        }
        if (x - 2 >= 0 && y + 1 < size && board[x-2][y+1] == 0) {
            nextMoves.add(new Point(x-2, y+1));
        }
        if (x - 1 >= 0 && y - 2 >= 0 && board[x-1][y-2] == 0) {
            nextMoves.add(new Point(x-1, y-2));
        }
        if (x - 1 >= 0 && y + 2 >= 0 && board[x-1][y+2] == 0) {
            nextMoves.add(new Point(x-1, y+2));
        }
        if (x + 2 < size && y - 1 >= 0 && board[x+2][y-1] == 0) {
            nextMoves.add(new Point(x+2, y-1));
        }
        if (x + 2 < size && y + 1 >= 0 && board[x+2][y+1] == 0) {
            nextMoves.add(new Point(x+2, y+1));
        }
        if (x + 1 < size && y - 2 >= 0 && board[x+1][y-2] == 0) {
            nextMoves.add(new Point(x+1, y-2));
        }
        if (x + 1 < size && y + 2 >= 0 && board[x+1][y+2] == 0) {
            nextMoves.add(new Point(x+1, y+2));
        }
        return nextMoves;
    }

}
