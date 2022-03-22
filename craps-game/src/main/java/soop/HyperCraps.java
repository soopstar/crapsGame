package soop;

import java.util.*;
/**
 * Version of the Craps game that will automatically play a specified number of games of Craps
 * Please break this thing.
 * I'm begging you to.
 */
public class HyperCraps {
    public static void main(String[] args) {
        boolean suffer = false;
        for (String s : args) {
            if (s.equals("--why")) {
                suffer = true;
                break;
            }
        }

        if (suffer) {
            pwayBall();
        } else {
            playBall();
        }
    }

    /**
     * The automated craps game logic
     */
    public static void playBall() {
        // Scanner and String for user input
        Scanner in = new Scanner(System.in);
        String userResponse;

        // Dice to roll with
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        // Game utility object
        CrapsGame game = new CrapsGame();

        // Variables to store dice rolls and total
        int diceRoll1;
        int diceRoll2;
        int diceTotal;

        // Number of games to play
        int gaming;

        // Whether to show all games or not
        boolean showAllGames = false;

        // Ask user how many games to play
        System.out.print("How many games would you like me to play for your enjoyment? ");
        try {
            gaming = in.nextInt();

            if (gaming==1) {
                System.out.println("Wait, only one? Okay...");
            } else {
                System.out.println("I'll be here for hours playing these " + gaming + " rounds...");
            }
            // Catch input that's not an integer
        } catch (Exception e) {
            System.out.println("Alright, we're playing the base 100,000 games.");
            gaming = 100000;
        }

        // Temporary fix to catch new line
        in.nextLine();

        // Ask user if they want to see only the first 10 games, given that the number of games to play is greater than 10, defaults to true
        if (gaming > 10) {
            System.out.print("Would you like to see the results of only the first 10 games? (Y/n) ");
            userResponse = in.nextLine();
            if (userResponse.length() == 0) {
                userResponse = "y";
            }
            if (!userYN(userResponse.charAt(0))) {
                showAllGames = true;
            }
        }

        // Play ball
        for (int i = 0; i < gaming; i++) {
            // Output results of each round if it's the first 10 rounds, or if the user wants to see all rounds
            if (i < 10 || showAllGames) {
                // Roll dice and calculate total.
                System.out.println("Round " + (game.getPlayed() + 1));
                diceRoll1 = dice1.rollDice();
                diceRoll2 = dice2.rollDice();

                diceTotal = diceRoll1 + diceRoll2;

                System.out.println("Rolls: " + diceRoll1 + ", " + diceRoll2);
                System.out.println("Total: " + diceTotal);

                // Integer for game result case
                int gameResult = game.winCase(diceTotal);

                switch (gameResult) {
                    // Case for if the user lost the game
                    case 0:
                        System.out.println("Game lost.");
                        game.incrementLosses();
                        game.incrementPlayed();
                        System.out.println();
                        break;
                    // Case for if the user won the game
                    case 1:
                        System.out.println("Game won.");
                        game.incrementWins();
                        game.incrementPlayed();
                        System.out.println();
                        break;
                    // Case for if the user didn't roll any of the initial numbers
                    default:
                        game.setWinTarget(diceTotal);
                        System.out.println("The target number is now " + game.getWinTarget());

                        // Start rolling, and keep the player rolling until they win or lose
                        do {
                            diceRoll1 = dice1.rollDice();
                            diceRoll2 = dice2.rollDice();

                            diceTotal = diceRoll1 + diceRoll2;

                            System.out.println("Rolls: " + diceRoll1 + ", " + diceRoll2);
                            System.out.println("Total: " + diceTotal);

                            gameResult = game.winCaseTarget(diceTotal);
                        } while (gameResult == -1);

                        if (gameResult == 1) {
                            System.out.println("Game won");
                            game.incrementWins();
                        } else {
                            System.out.println("Game lost");
                            game.incrementLosses();
                        }
                        game.incrementPlayed();
                        System.out.println();
                        break;
                }
                // Play game with no output
            } else {
                diceRoll1 = dice1.rollDice();
                diceRoll2 = dice2.rollDice();

                diceTotal = diceRoll1 + diceRoll2;

                // Integer for game result case
                int gameResult = game.winCase(diceTotal);

                switch (gameResult) {
                    // Case for if the user lost the game
                    case 0:
                        game.incrementLosses();
                        game.incrementPlayed();
                        break;
                    // Case for if the user won the game
                    case 1:
                        game.incrementWins();
                        game.incrementPlayed();
                        break;
                    // Case for if the user didn't roll any of the initial numbers
                    default:
                        game.setWinTarget(diceTotal);

                        // Start rolling, and keep the player rolling until they win or lose
                        do {
                            diceRoll1 = dice1.rollDice();
                            diceRoll2 = dice2.rollDice();

                            diceTotal = diceRoll1 + diceRoll2;

                            gameResult = game.winCaseTarget(diceTotal);
                        } while (gameResult == -1);

                        if (gameResult == 1) {
                            game.incrementWins();
                        } else {
                            game.incrementLosses();
                        }
                        game.incrementPlayed();
                        break;
                }
            }
        }

        // Display results
        System.out.println("Alright, here are the results:");

        // Give grammatically correct output
        if (game.getWins() == 1) {
            System.out.println(game.getWins() + " game was won.");
        } else {
            System.out.println(game.getWins() + " games were won.");
        }

        if (game.getLosses() == 1) {
            System.out.println(game.getLosses() + " game was lost.");
        } else {
            System.out.println(game.getLosses() + " games were lost.");
        }

        if (game.getPlayed() == 1) {
            System.out.println(game.getPlayed() + " game was played.");
        } else {
            System.out.println(game.getPlayed() + " games were played.");
        }

        in.close();
    }

    /**
     * Takes in the first character of the user's answer to a yes/no question, and returns a boolean based off of it.
     * With that being said, the user could enter something like "yoascndcscncncjncasncnkdc," and the method will still count it was a "yes."
     * @param user The first character of the user's response
     * @return "true" if the first character of the user's response was 'y' or 'Y', "false" otherwise.
     */
    public static boolean userYN(char user) {
        if (user == 'Y' || user == 'y') {
            System.out.println("I'm gonna take that as a \"yes.\"");
            return true;
        } else {
            System.out.println("I'm gonna take that as a \"no.\"");
            return false;
        }
    }

    /**
     * The automated craps game logic to not be utilised
     */
    public static void pwayBall() {
        // Scanner and String for user input
        Scanner in = new Scanner(System.in);
        String userResponse;

        // Dice to roll with
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        // Game utility object
        CrapsGame game = new CrapsGame();

        // Variables to store dice rolls and total
        int diceRoll1;
        int diceRoll2;
        int diceTotal;

        // Number of games to play
        int gaming;

        // Whether to show all games or not
        boolean showAllGames = false;

        // Ask user how many games to play
        System.out.print("how many games wouwd you wike me t-to pway f-fow youw enjoyment? (OwO) ");
        try {
            gaming = in.nextInt();

            if (gaming==1) {
                System.out.println("wait... onwy one (o_O)? okay...");
            } else {
                System.out.println("i'll be here f-fow houws pwaying these " + gaming + " wounds (-.- )");
            }
            // Catch input that's not an integer
        } catch (Exception e) {
            System.out.println("a-awwight!  w-we're pwaying t-the base 100,000 games.");
            gaming = 100000;
        }

        // Temporary fix to catch new line
        in.nextLine();

        // Ask user if they want to see only the first 10 games, given that the number of games to play is greater than 10, defaults to true
        if (gaming > 10) {
            System.out.print("w-wouwd you wike t-to see the wesuwts o-of onwy the fiwst 10 games (o_O)? (Y/n) ");
            userResponse = in.nextLine();
            if (userResponse.length() == 0) {
                userResponse = "y";
            }
            if (!usewYN(userResponse.charAt(0))) {
                showAllGames = true;
            }
        }

        // Play ball
        for (int i = 0; i < gaming; i++) {
            // Output results of each round if it's the first 10 rounds, or if the user wants to see all rounds
            if (i < 10 || showAllGames) {
                // Roll dice and calculate total.
                System.out.println("Wound " + (game.getPlayed() + 1));
                diceRoll1 = dice1.rollDice();
                diceRoll2 = dice2.rollDice();

                diceTotal = diceRoll1 + diceRoll2;

                System.out.println("Wowws: " + diceRoll1 + ", " + diceRoll2);
                System.out.println("Totaw: " + diceTotal);

                // Integer for game result case
                int gameResult = game.winCase(diceTotal);

                switch (gameResult) {
                    // Case for if the user lost the game
                    case 0:
                        System.out.println("game wost (> v <)");
                        game.incrementLosses();
                        game.incrementPlayed();
                        System.out.println();
                        break;
                    // Case for if the user won the game
                    case 1:
                        System.out.println("game won (* ^ w ^)");
                        game.incrementWins();
                        game.incrementPlayed();
                        System.out.println();
                        break;
                    // Case for if the user didn't roll any of the initial numbers
                    default:
                        game.setWinTarget(diceTotal);
                        System.out.println("t-the tawget number is now " + game.getWinTarget());

                        // Start rolling, and keep the player rolling until they win or lose
                        do {
                            diceRoll1 = dice1.rollDice();
                            diceRoll2 = dice2.rollDice();

                            diceTotal = diceRoll1 + diceRoll2;

                            System.out.println("Wowws: " + diceRoll1 + ", " + diceRoll2);
                            System.out.println("Totaw: " + diceTotal);

                            gameResult = game.winCaseTarget(diceTotal);
                        } while (gameResult == -1);

                        if (gameResult == 1) {
                            System.out.println("game w-won xD");
                            game.incrementWins();
                        } else {
                            System.out.println("game wost (* ^ w ^)");
                            game.incrementLosses();
                        }
                        game.incrementPlayed();
                        System.out.println();
                        break;
                }
                // Play game with no output
            } else {
                diceRoll1 = dice1.rollDice();
                diceRoll2 = dice2.rollDice();

                diceTotal = diceRoll1 + diceRoll2;

                // Integer for game result case
                int gameResult = game.winCase(diceTotal);

                switch (gameResult) {
                    // Case for if the user lost the game
                    case 0:
                        game.incrementLosses();
                        game.incrementPlayed();
                        break;
                    // Case for if the user won the game
                    case 1:
                        game.incrementWins();
                        game.incrementPlayed();
                        break;
                    // Case for if the user didn't roll any of the initial numbers
                    default:
                        game.setWinTarget(diceTotal);

                        // Start rolling, and keep the player rolling until they win or lose
                        do {
                            diceRoll1 = dice1.rollDice();
                            diceRoll2 = dice2.rollDice();

                            diceTotal = diceRoll1 + diceRoll2;

                            gameResult = game.winCaseTarget(diceTotal);
                        } while (gameResult == -1);

                        if (gameResult == 1) {
                            game.incrementWins();
                        } else {
                            game.incrementLosses();
                        }
                        game.incrementPlayed();
                        break;
                }
            }
        }

        // Display results
        System.out.println("awwight! here are t-the wesuwts: (OwO)");

        // Give grammatically correct output
        if (game.getWins() == 1) {
            System.out.println(game.getWins() + " g-game was won!");
        } else {
            System.out.println(game.getWins() + " games were won! (> v <)");
        }

        if (game.getLosses() == 1) {
            System.out.println(game.getLosses() + " game w-was wost (-.- )");
        } else {
            System.out.println(game.getLosses() + " games were wost xD");
        }

        if (game.getPlayed() == 1) {
            System.out.println(game.getPlayed() + " g-game w-was pwayed.");
        } else {
            System.out.println(game.getPlayed() + " games were p-pwayed (* ^ w ^)");
        }

        in.close();
    }

    /**
     * Takes in the first character of the user's answer to a yes/no question, and returns a boolean based off of it.
     * With that being said, the user could enter something like "yoascndcscncncjncasncnkdc," and the method will still count it was a "yes."
     * It is assumed that the "--why" flag was used.
     * @param user The first character of the user's response
     * @return "true" if the first character of the user's response was 'y' or 'Y', "false" otherwise.
     */
    public static boolean usewYN(char user) {
        if (user == 'Y' || user == 'y') {
            System.out.println("i'm g-gonna take that as a \"yes.\"");
            return true;
        } else {
            System.out.println("i-i'm gonna take that as a \"no.\"");
            return false;
        }
    }
}
