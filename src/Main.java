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
                    String tempSecondX;
                    String tempSecondY;
                    byte firstX = 0;
                    byte firstY = 0;
                    byte secondX = 0;
                    byte secondY = 0;
                    boolean checkX = false;
                    boolean checkY = false;
                    boolean isFinished = false;
                    while (!isFinished) {
                        System.out.print(firstPlayer.getName() + ", take your shot - x-coordinate: ");
                        while (!checkX) {
                            try {
                                tempFirstX = hitsScanner.nextLine();
                                firstX = Byte.parseByte(tempFirstX);
                                checkX = true;
                            } catch (NumberFormatException NFE) {
                                System.out.println("Not a coordinate - try again.");
                                System.out.print("x-coordinate: ");
                                checkX = false;
                            }
                        }
                        while (!checkY) {
                            System.out.print("\ny-coordinate: ");
                            try {
                                tempFirstY = hitsScanner.nextLine();
                                firstY = Byte.parseByte(tempFirstY);
                                checkY = true;
                            } catch (NumberFormatException NFE) {
                                System.out.println("Not a coordinate - try again.");
                                checkY = false;
                            }
                        }
                        if(game.fireMissile(firstX, firstY, secondPlayer)) {
                            firstHits++;
                        }
                        if (firstHits == 9) {
                            isFinished = true;
                        }
                    }
                    checkX = false;
                    checkY = false;
                    while (!isFinished) {
                        System.out.print(secondPlayer.getName() + ", take your shot - x-coordinate: ");
                        while (!checkX) {
                            try {
                                tempSecondX = hitsScanner.nextLine();
                                secondX = Byte.parseByte(tempSecondX);
                                checkX = true;
                            } catch (NumberFormatException NFE) {
                                System.out.println("Not a coordinate - try again.");
                                System.out.print("x-coordinate: ");
                                checkX = false;
                            }
                        }
                        while (!checkY) {
                            System.out.print("\ny-coordinate: ");
                            try {
                                tempSecondY = hitsScanner.nextLine();
                                secondY = Byte.parseByte(tempSecondY);
                                checkY = true;
                            } catch (NumberFormatException NFE) {
                                System.out.println("Not a coordinate - try again.");
                                checkY = false;
                            }
                        }
                        if(game.fireMissile(firstX, firstY, firstPlayer)) {
                            secondHits++;
                        }
                        if (firstHits == 9) {
                            isFinished = true;
                        }
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
