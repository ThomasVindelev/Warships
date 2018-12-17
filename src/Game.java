import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    private Validate validate = new Validate();
    private Board board = new Board();

    public void setupGame(Player player) {
        for (int i = 2; i < 5; i++) {
            int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
            do {
                do {
                    System.out.print("\n" + player.getName() + ", place your ship number " + (i - 1) + " - it can be a maximum of " + i + " tiles long\nX-coordinate 1: ");
                    String x1Temp = scanner.nextLine();
                    x1 = validate.validateNumber(x1Temp);
                    while (x1 == -1) {
                        System.out.print("That is not a number - try again.\nX-coordinate 1: ");
                        x1Temp = scanner.nextLine();
                        x1 = validate.validateNumber(x1Temp);
                    }
                    System.out.print("Y-coordinate 1: ");
                    String y1Temp = scanner.nextLine();
                    y1 = validate.validateNumber(y1Temp);
                    while (y1 == -1) {
                        System.out.print("That is not a number - try again.\nY-coordinate 1: ");
                        y1Temp = scanner.nextLine();
                        y1 = validate.validateNumber(y1Temp);
                    }
                    System.out.print("X-coordinate 2: ");
                    String x2Temp = scanner.nextLine();
                    x2 = validate.validateNumber(x2Temp);
                    while (x2 == -1) {
                        System.out.print("That is not a number - try again.\nX-coordinate 2: ");
                        x2Temp = scanner.nextLine();
                        x2 = validate.validateNumber(x2Temp);
                    }
                    System.out.print("Y-coordinate 2: ");
                    String y2Temp = scanner.nextLine();
                    y2 = validate.validateNumber(y2Temp);
                    while (y2 == -1) {
                        System.out.print("That is not a number - try again.\nY-coordinate 1: ");
                        y2Temp = scanner.nextLine();
                        y2 = validate.validateNumber(y2Temp);
                    }
                    if (!validate.validateLength(x1, y1, x2, y2, i)) {
                        System.out.print("Not a valid length for the ship - try again.\n");
                    }
                } while (!validate.validateLength(x1, y1, x2, y2, i));
            } while (!board.setShips(x1, y1, x2, y2, player.getBoard()));
            board.getBoard(player.getBoard());
        }

    }

    public void fireMissile(int x, int y, Player enemyPlayer) {
        if (board.checkTile(enemyPlayer.getBoard(), x, y)) {
            System.out.print("It's a direct hit!\n");
            enemyPlayer.setBoard(enemyPlayer, x, y);
        } else {
            System.out.print("It's a miss!\n");
        }
    }
}
