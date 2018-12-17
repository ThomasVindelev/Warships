import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();
        boolean choiceMade = false;
        Scanner scanner = new Scanner(System.in);
        Scanner hitsScanner = new Scanner(System.in);
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
                    byte firstHits = 0;
                    byte secondHits = 0;
                    String tempFirstX;
                    String tempFirstY;
                    byte firstX;
                    byte firstY;
                    while (firstHits != 9 || secondHits != 9) {
                        System.out.print(firstPlayer.getName() + ", take your shot - x-coordinate: ");
                        try {
                            tempFirstX = hitsScanner.nextLine();
                            firstX = Byte.parseByte(tempFirstX);
                        } catch (NumberFormatException NFE) {
                            System.out.println("Not a coordinate - try again.");
                        }
                        System.out.print("\ny-coordinate: ");
                        tempFirstY = hitsScanner.nextLine();
                    }
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
