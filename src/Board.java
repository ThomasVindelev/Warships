public class Board {

    private boolean[][] firstBoard = new boolean[10][10];
    private boolean[][] secondBoard = new boolean[10][10];

    public boolean[][] getFirstBoard() {
        return firstBoard;
    }

    public boolean[][] getSecondBoard() {
        return secondBoard;
    }

    public void getBoard(boolean[][] board) {
        for (int i = 0; i < board.length + 1; i++) {
            if (i == 0) {
                System.out.print("   ");
            } else if (i < 10) {
                System.out.print(i + "  ");
            } else {
                System.out.print(i + " ");
            }
            if (i == board.length) {
                System.out.println("  X");
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (i > 8) {
                System.out.print(i + 1 + " ");
            } else {
                System.out.print(i + 1 + "  ");
            }
            for (int j = 0; j < board[i].length; j++) {
                if (!board[i][j]) {
                    System.out.print("-  ");
                } else {
                    System.out.print("x  ");
                }
            }
            System.out.println();
        }
        System.out.println("\nY");
    }

    public boolean setShips(int x1, int y1, int x2, int y2, boolean[][] board) {
        x1 -= 1;
        x2 -= 1;
        y1 -= 1;
        y2 -= 1;
        boolean isSet;
        if (!board[y1][x1]) {
           if (!board[y2][x2]) {
               board[y1][x1] = true;
               board[y2][x2] = true;
               if (x1 == x2 && y2-2 > y1 && !board[y2-2][x2] && !board[y2-1][x2]) {
                   board[y2-2][x2] = true;
                   board[y2-1][x2] = true;
                   isSet = true;
               } else if (x2-2 > x1 && y2 == y1 && !board[y2][x2-2] && !board[y2][x2-1]) {
                   board[y2][x2-2] = true;
                   board[y2][x2-1] = true;
                   isSet = true;
               } else if (x2 == x1 && y2-1 > y1 && !board[y2-1][x2]) {
                   board[y2-1][x2] = true;
                   isSet = true;
               } else if (x2-1 > x1 && y2 == y1 && !board[y2][x2-1]) {
                   board[y2][x2-1] = true;
                   isSet = true;
               } else if (x1 == x2 && y2+2 < y1 && !board[y2+2][x2] && !board[y2+1][x2]) {
                   board[y2+2][x2] = true;
                   board[y2+1][x2] = true;
                   isSet = true;
               } else if (x2+2 < x1 && y2 == y1 && !board[y2][x2+2] && !board[y2][x2+1]) {
                   board[y2][x2+2] = true;
                   board[y2][x2+1] = true;
                   isSet = true;
               } else if (x2 == x1 && y2+1 < y1 && !board[y2+1][x2]) {
                   board[y2-1][x2] = true;
                   isSet = true;
               } else if (x2+1 < x1 && y2 == y1 && !board[y2][x2+1]) {
                   board[y2][x2+1] = true;
                   isSet = true;
               } else if (x2 == x1 && y2-1 == y1) {
                   isSet = true;
               } else if (x2-1 == x1 && y2 == y1) {
                   isSet = true;
               } else if (x2 == x1 && y2+1 == y1) {
                   isSet = true;
               } else if (x2+1 == x1 && y2 == y1) {
                   isSet = true;
               } else {
                   System.out.print("Not a valid placement - try again.");
                   board[y1][x1] = false;
                   board[y2][x2] = false;
                   return false;
               }
           } else {
               System.out.print("Not a valid placement - try again.");
               return false;
           }
        } else {
            System.out.print("Not a valid placement - try again.");
            return false;
        }
        return isSet;
    }

    public boolean checkTile(boolean[][] enemyBoard, int x, int y) {
        if (enemyBoard[y][x]) {
            return true;
        } else {
            return false;
        }
    }

}
