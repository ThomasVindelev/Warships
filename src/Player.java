public class Player {

    private String name;
    private boolean goesFirst;
    private boolean[][] board;

    public Player(String name, boolean goesFirst, boolean[][] board) {
        this.name = name;
        this.goesFirst = goesFirst;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public boolean[][] getBoard() {
        return board;
    }

    public void setBoard(Player player, int x, int y) {
        player.board[y][x] = false;
    }

    public boolean isGoesFirst() {
        return goesFirst;
    }
}
