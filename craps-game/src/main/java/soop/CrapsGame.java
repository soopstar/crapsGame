package soop;

/**
 * Utility class for Craps game
 */
public class CrapsGame {
    private final static int[] initialWin = {7, 11};
    private final static int[] initialLoss = {2, 3, 12};

    private int winTarget = 0;

    private int wins = 0;
    private int losses = 0;
    private int played = 0;

    /**
     * Default constructor.
     */
    public CrapsGame() {
    }

    /**
     * Increases the number of wins by 1
     */
    public void incrementWins() {
        this.wins++;
    }

    /**
     * Returns the number of wins
     * @return the number of wins
     */
    public int getWins() {
        return this.wins;
    }

    /**
     * Increases the number of losses by 1
     */
    public void incrementLosses() {
        this.losses++;
    }

    /**
     * Increases the number of played games by 1
     */
    public void incrementPlayed() {
        this.played++;
    }

    /**
     * Returns the number of losses
     * @return the number of losses
     */
    public int getLosses() {
        return this.losses;
    }

    /**
     * Returns the number of games played
     * @return the number of games played
     */
    public int getPlayed() {
        return this.played;
    }

    /**
     * Sets the winning target for the game, given that the player didn't win the game by rolling an initial win or loss number.
     * It is implied that two dice objects were used to get this number.
     * @param winTarget the number to set the target to.
     */
    public void setWinTarget(int winTarget) {
        this.winTarget = winTarget;
    }

    /**
     * Returns the winning target for the game.
     * @return an integer, the winning target currently set.
     */
    public int getWinTarget() {
        return winTarget;
    }

    /**
     * Returns an integer array of the numbers needed to win on the first roll
     * @return An integer array of the numbers needed to win on the first roll
     */
    public int[] getStartWins() {
        return initialWin;
    }

    /**
     * Returns an integer array of the numbers needed to lose on the first roll
     * @return An integer array of the numbers needed to lose on the first roll
     */
    public int[] getStartLoss() {
        return initialLoss;
    }

    /**
     * Takes in a number and determines if the player has won the game by rolling one of the initial winning numbers, or lost the game by rolling one of the initial losing numbers.
     * Two dice should be used to get this number.
     * @param diceTotal the dice roll to be checked.
     * @return 1 if the player won the game, 0, if the user lost the game, -1 if the user did not roll any of the initial win or loss numbers.
     */
    public int winCase(int diceTotal) {
        int winResult;

        for (int i : initialWin) {
            if (diceTotal == i) {
                winResult = 1;
                return winResult;
            }
        }

        for (int i : initialLoss) {
            if (diceTotal == i) {
                winResult = 0;
                return winResult;
            }
        }

        winResult = -1;
        return winResult;
    }

    /**
     * Takes in a number and determines if the player has won the game by rolling the target number, or lost the game by rolling a 7.
     * Two dice should be used to get this number.
     * @param diceTotal the dice roll to be checked.
     * @return 1 if the player won the game, 0 if the user lost the game, -1 if the user didn't roll either the target number of a 7.
     */
    public int winCaseTarget(int diceTotal) {
        if (diceTotal == winTarget) {
            return 1;
        } else if (diceTotal == 7) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Tells the user how to play the game in small bites
     * @throws InterruptedException Exception used to control output flow
     */
    public void howToPlay() throws InterruptedException {
        String[] instructions = {
            "Here's how you play Craps:",
            "You're gonna roll two dice.",
            "On the first roll, if you get a ",
            "you win the game.",
            "However, if you get a ",
            "you'll lose the game.",
            "If you don't roll any of those numbers, then we'll save that roll.",
            "That roll will be the winning roll.",
            "You'll keep rolling until you roll that number, in which case, you win,",
            "or until you roll a 7, in which case, you lose.",
            "With that being said, let's begin the game"
        };

        for (int i = 0; i < instructions.length; i++) {
            System.out.print(instructions[i]);
            if (instructions[i].contains(", if you get a ")) {
                if (instructions[i+1].contains("win")) {
                    for (int j = 0; j < initialWin.length; j++) {
                        System.out.print(initialWin[j]);

                        if (j != initialWin.length-1) {
                            System.out.print(", ");
                        }

                        if (j == initialWin.length-2) {
                            System.out.print("or a(n) ");
                        }
                    }
                    System.out.print(", ");
                } else {
                    for (int j = 0; j < initialLoss.length; j++) {
                        System.out.print(initialLoss[j]);

                        if (j != initialLoss.length-1) {
                            System.out.print(", ");
                        }

                        if (j == initialLoss.length-2) {
                            System.out.print("or a(n) ");
                        }
                    }
                    System.out.print(", ");
                }
            }
            System.out.println();
            Thread.sleep(3000);
        }
    }

    /**
     * Tells the user how to play the game in small bites
     * This method is only used in uwu mode
     * @throws InterruptedException Exception used to control output flow
     */
    public void howToPway() throws InterruptedException {
        String[] instructions = {
                "h-hewe's how you p-pway cwaps:",
                "ur gonna woll two dice.",
                "o-on the f-fiwst woll, if you get a ",
                "you win the g-game.",
                "however... if you get a ",
                "y-you'll wose the game.",
                "if y-you don't w-woll any of those numbers... then we'll save that woll (OwO)",
                "that woll will b-be the winning woll (*UwU*)",
                "y-you'll k-keep wowwing untiw y-you woll that number, in w-which case, y-you win,",
                "ow untiw you woll a 7, in w-which case... you wose! (OwO)",
                "with that being said... wet's b-begin the game (OwO)"
        };

        for (int i = 0; i < instructions.length; i++) {
            System.out.print(instructions[i]);
            if (instructions[i].contains("if you get a ")) {
                if (instructions[i+1].contains("win")) {
                    for (int j = 0; j < initialWin.length; j++) {
                        System.out.print(initialWin[j]);

                        if (j != initialWin.length-1) {
                            System.out.print(", ");
                        }

                        if (j == initialWin.length-2) {
                            System.out.print("ow a(n) ");
                        }
                    }
                    System.out.print(", ");
                } else {
                    for (int j = 0; j < initialLoss.length; j++) {
                        System.out.print(initialLoss[j]);

                        if (j != initialLoss.length-1) {
                            System.out.print(", ");
                        }

                        if (j == initialLoss.length-2) {
                            System.out.print("ow a(n) ");
                        }
                    }
                    System.out.print(", ");
                }
            }
            Thread.sleep(3000);
            System.out.println();
        }
    }
}
