package soop;

import java.util.*;

/**
 * Main file for Craps game
 */
public class Gameing {
    public static void main(String[] args) throws InterruptedException {
        boolean suffer = false;
        for (String s : args) {
            if (s.equals("--why")) {
                suffer = true;
                break;
            }
        }

        if (suffer) {
            awwCwapsNoDice();
        } else {
            allCrapsNoDice();
        }
    }

    /**
     * The main class for Craps gameplay.
     * @throws InterruptedException Exception used to control output flow
     */
    public static void allCrapsNoDice() throws InterruptedException {
        // Scanner and Strings for user input and for the user to control the flow of the text
        Scanner in = new Scanner(System.in);
        String userResponse;

        // Boolean to start whether the user said "yes" (true) or "no" (false)
        boolean decisionYN;

        // Whether the user is still playing or not
        boolean playing;

        // 2 dice for rolling
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        // Variables to store dice rolls and total
        int diceRoll1;
        int diceRoll2;

        int diceTotal;

        // Craps game utility
        CrapsGame game = new CrapsGame();

        // Welcome user to game
        System.out.println("Welcome to Craps! The game of crappy rolls!");

        // Ask if they want easter eggs on (given that they're implemented)

        // Ask the user if they've played the game before
        System.out.println("Do you know how to play Craps? (y/N)");
        userResponse = in.nextLine();

        // Catch no input from the user
        if (userResponse.length() == 0) {
            userResponse = "N";
        }


        // Store the user's response as a boolean
        decisionYN = userYN(userResponse.charAt(0));

        // If the user has played the game before, do not show them how to play
        // Otherwise, tell them how to play
        if (decisionYN) {
            System.out.println("Alright, we'll go ahead and start!");
        } else {
            game.howToPlay();
        }

        do {
            // Prompt the user to "roll" the dice
            System.out.println("Press Enter to roll the dice!");
            in.nextLine();

            System.out.println("Rolling the dice...");

            // Roll dice and calculate total.
            diceRoll1 = dice1.rollDice();
            diceRoll2 = dice2.rollDice();

            diceTotal = diceRoll1 + diceRoll2;

            Thread.sleep(2000);

            // Integer for game result case
            int gameResult = game.winCase(diceTotal);

            switch (gameResult) {
                // Case for if the user lost the game
                case 0:
                    System.out.println("Oh boy, I know ya gonna dig this: You rolled a " + diceTotal + " on your first roll! You lost!");
                    game.incrementLosses();
                    game.incrementPlayed();
                    break;
                // Case for if the user won the game
                case 1:
                    System.out.println("Well, dang, lucky you! You got a " + diceTotal + " on your first roll! You won!");
                    game.incrementWins();
                    game.incrementPlayed();
                    break;
                // Case for if the user didn't roll any of the initial numbers
                default:
                    System.out.println("You rolled a " + diceTotal + ".");

                    Thread.sleep(2500);

                    game.setWinTarget(diceTotal);

                    // Start rolling, and keep the player rolling until they win or lose
                    do {
                        System.out.println("Press Enter to roll the dice!");
                        in.nextLine();

                        System.out.println("Rolling the dice...");

                        diceRoll1 = dice1.rollDice();
                        diceRoll2 = dice2.rollDice();

                        diceTotal = diceRoll1 + diceRoll2;

                        System.out.println("You rolled a " + diceTotal + ".");
                        Thread.sleep(2500);

                        gameResult = game.winCaseTarget(diceTotal);
                    } while (gameResult == -1);

                    // Show result of game
                    System.out.println("Congratulations...");
                    Thread.sleep(2500);

                    if (gameResult == 1) {
                        System.out.println("You won!");
                        game.incrementWins();
                        game.incrementPlayed();
                    } else {
                        System.out.println("You lost!");
                        game.incrementLosses();
                        game.incrementPlayed();
                    }

                    System.out.println("With a roll of " + diceTotal + ".");

                    break;
            }

            System.out.print("Would you like to play again? ");
            userResponse = in.nextLine();

            // Catch no input from the user
            if (userResponse.length() == 0) {
                userResponse = "N";
            }

            // Store the user's response as a boolean
            playing = userYN(userResponse.charAt(0));
        } while (playing);

        System.out.println("You played " + game.getPlayed() + " games.");
        System.out.println("You won " + game.getWins() + " of those games, and lost " + game.getLosses() + " of those games.");

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
     * The uwu'd class for Craps gameplay that should never be used
     * @throws InterruptedException Exception used to control output flow
     */
    public static void awwCwapsNoDice() throws InterruptedException {
        // Scanner and Strings for user input and for the user to control the flow of the text
        Scanner in = new Scanner(System.in);
        String userResponse;

        // Boolean to start whether the user said "yes" (true) or "no" (false)
        boolean decisionYN;

        // Whether the user is still playing or not
        boolean playing;

        // 2 dice for rolling
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        // Variables to store dice rolls and total
        int diceRoll1;
        int diceRoll2;

        int diceTotal;

        // Craps game utility
        CrapsGame game = new CrapsGame();

        // Welcome user to game
        System.out.println("wewcome to cwaps! the g-game of c-cwappy wolls! (o^v^o)");

        // Ask if they want easter eggs on (given that they're implemented)

        // Ask the user if they've played the game before
        System.out.println("d-do you know h-how to pway cwaps? (y/N)");
        userResponse = in.nextLine();

        // Catch no input from the user
        if (userResponse.length() == 0) {
            userResponse = "N";
        }


        // Store the user's response as a boolean
        decisionYN = usewYN(userResponse.charAt(0));

        // If the user has played the game before, do not show them how to play
        // Otherwise, tell them how to play
        if (decisionYN) {
            System.out.println("awwight... we'll go ahead a-and stawt! (o^v^o)");
        } else {
            game.howToPway();
        }

        do {
            // Prompt the user to "roll" the dice
            System.out.println("pwess enter to woll the dice (> v <)");
            in.nextLine();

            System.out.println("wowwing the dice...");

            // Roll dice and calculate total.
            diceRoll1 = dice1.rollDice();
            diceRoll2 = dice2.rollDice();

            diceTotal = diceRoll1 + diceRoll2;

            Thread.sleep(2000);

            // Integer for game result case
            int gameResult = game.winCase(diceTotal);

            switch (gameResult) {
                // Case for if the user lost the game
                case 0:
                    System.out.println("oh boy, i know ya gonna d-dig this: y-you wowwed a(n) " + diceTotal + " on youw fiwst woll! you wost! (-.-)");
                    game.incrementLosses();
                    game.incrementPlayed();
                    break;
                // Case for if the user won the game
                case 1:
                    System.out.println("well〜☆ dang! wucky you! (OwO) you got a(n) " + diceTotal + " on youw fiwst w-woll! you won (* ^ w ^)");
                    game.incrementWins();
                    game.incrementPlayed();
                    break;
                // Case for if the user didn't roll any of the initial numbers
                default:
                    System.out.println("y-you wowwed a(n) " + diceTotal + ".");

                    Thread.sleep(2500);

                    game.setWinTarget(diceTotal);

                    // Start rolling, and keep the player rolling until they win or lose
                    do {
                        System.out.println("p-pwess e-enter t-to woll t-the dice!");
                        in.nextLine();

                        System.out.println("w-wowwing the dice.. (* ^ w ^)");

                        diceRoll1 = dice1.rollDice();
                        diceRoll2 = dice2.rollDice();

                        diceTotal = diceRoll1 + diceRoll2;

                        System.out.println("you w-wowwed a(n) " + diceTotal + ".");
                        Thread.sleep(2500);

                        gameResult = game.winCaseTarget(diceTotal);
                    } while (gameResult == -1);

                    // Show result of game
                    System.out.println("congwatuwations.. (* ^ w ^)");
                    Thread.sleep(2500);

                    if (gameResult == 1) {
                        System.out.println("y-you won〜☆");
                        game.incrementWins();
                        game.incrementPlayed();
                    } else {
                        System.out.println("you wost -.-");
                        game.incrementLosses();
                        game.incrementPlayed();
                    }

                    System.out.println("with a woll of " + diceTotal + ".");

                    break;
            }

            System.out.print("w-wouwd you wike to pway again (o_O)? ");
            userResponse = in.nextLine();

            // Catch no input from the user
            if (userResponse.length() == 0) {
                userResponse = "N";
            }

            // Store the user's response as a boolean
            playing = usewYN(userResponse.charAt(0));
        } while (playing);

        System.out.println("you pwayed " + game.getPlayed() + " games (> v < )");
        System.out.println("you w-won " + game.getWins() + " o-of t-those games... and wost " + game.getLosses() + " of those g-games.");

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
