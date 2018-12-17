import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();
        boolean choiceMade = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Warships!");

        while(!choiceMade) {
            System.out.println("1. New game   2. Exit game");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    Game game = new Game();
                    System.out.print("Please enter the first players name: ");
                    String firstPlayerName = scanner.nextLine();
                    Player firstPlayer = new Player(firstPlayerName, true, board.getFirstBoard());
                    System.out.print("Please enter the second players name: ");
                    String secondPlayerName = scanner.nextLine();
                    Player secondPlayer = new Player(secondPlayerName, false, board.getSecondBoard());
                    game.setupGame(firstPlayer);
                    game.setupGame(secondPlayer);
                    game.fireMissile(1, 1, secondPlayer);
                    board.getBoard(secondPlayer.getBoard());
                    break;
                case "2":
                    System.exit(0);
                    break;
                default:
                    System.out.println("That's not a valid choice - try again");
                    break;
            }
        }

    }
}
