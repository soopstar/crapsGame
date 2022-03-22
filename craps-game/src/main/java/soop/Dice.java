package soop;

import java.util.*;

/**
 * A dice object that returns a random number from 1 to its number of sides.
 */
public class Dice {
    // Number of sides for the dice
    private int sides = 6;

    // Randomiser for dice
    private Random roll = new Random();

    /**
     * Creates a new, standard 6-sided dice.
     */
    public Dice() {
    }

    /**
     * Creates a new dice with a specified number of sides.
     * @param sides THe number of sides for the dice.
     */
    public Dice(int sides) {
        this.sides = sides;
    }

    /**
     * Rolls the dice.
     * @return A random number from 1 to its number of sides.
     */
    public int rollDice() {
        return roll.nextInt(this.sides) + 1;
    }

    /**
     * Returns the number of sides for the dice.
     * @return the number of sides that the dice has.
     */
    public int getSides() {
        return this.sides;
    }
}
