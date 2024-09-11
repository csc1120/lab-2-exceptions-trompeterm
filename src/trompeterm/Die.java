/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Miles Trompeter
 * Last Updated: 9/11/24
 */
package trompeterm;

import java.util.Random;

public class Die {

    public final int MIN_SIDES = 2;
    public final int MAX_SIDES = 100;

    private int currentValue;
    private int numSides;
    private Random random;

    public Die(int numSides) {
        if(numSides < MIN_SIDES || numSides > MAX_SIDES) {
            throw new IllegalArgumentException("Bad die creation: Illegal number of sides: "
                    + numSides);
        } else {
            this.numSides = numSides;
        }
        random = new Random();
    }

    public int getCurrentValue() {
        int temp = currentValue;
        currentValue = 0;
        return temp;
    }

    public void roll() {
        currentValue = random.nextInt(1, numSides+1);
    }
}