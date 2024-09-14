/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Miles Trompeter
 * Last Updated: 9/14/24
 */
package trompeterm;

import java.util.Random;



/**
 * die class for lab. Stores the current value of the roll as well as the number
 * of sides of the die. Random is for the roll of the die
 */
public class Die {

    /**
     * minimum number of sides for a die
     */
    public static final int MIN_SIDES = 2;

    /**
     * maximum number of sides for a die
     */
    public static final int MAX_SIDES = 100;

    private int currentValue;
    private int numSides;
    private Random random;

    /**
     * constructor for die object. If not in range of acceptable sides,
     * throws an illegal argument exception.
     * @param numSides number of sides of the die
     * @throws IllegalArgumentException
     */
    public Die(int numSides) {
        if(numSides < MIN_SIDES || numSides > MAX_SIDES) {
            throw new IllegalArgumentException("Bad die creation: Illegal number of sides: "
                    + numSides);
        } else {
            this.numSides = numSides;
        }
        random = new Random();
    }

    /**
     * gets the current value of the die object.
     * @return currentValue - of die
     * @throws  DieNotRolledException
     */
    public int getCurrentValue() {
        if(currentValue == 0) {
            throw new DieNotRolledException();
        }
        int temp = currentValue;
        currentValue = 0;
        return temp;
    }

    /**
     * Generates random number for the die
     */
    public void roll() {
        currentValue = random.nextInt(1, numSides+1);
    }
}