/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Miles Trompeter
 * Last Updated: 9/14/24
 */

package trompeterm;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class for this lab. Asks user to enter num die, sides ,and rolls, then
 * reports the number of times each value was rolled along with a bell curve as a visual.
 */
public class Driver {

    /**
     * min number of dice that can be entered
     */
    public static final int MIN_DICE = 2;

    /**
     * Max number of dice that can be entered
     */
    public static final int MAX_DICE = 10;

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        boolean good = false;

        while(!good){
            try{
                getInput(reader);
                good = true;
            } catch(InputMismatchException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static int[] getInput(Scanner sc) {

        int v1;
        int v2;
        int v3;

        System.out.println("""
                Please enter the number of dice to roll, how many sides the dice have,\
                
                 and how many rolls to complete, separating the values by a space.\
                
                 Example: 2 6 1000\s
                Enter Configuration:\s""");

        String inputLine = sc.nextLine();
        String[] nums = inputLine.split("\\s+");

        if (nums.length != 3) {
            throw new NumberFormatException("Invalid input: Expected 3 values but only received 2");
        }

        try {
            v1 = Integer.parseInt(nums[0]);
            v2 = Integer.parseInt(nums[1]);
            v3 = Integer.parseInt(nums[2]);

            if (v1 < MIN_DICE || v1 > MAX_DICE) {
                throw new IllegalArgumentException("Bad die creation: Illegal number of die: "+v1);
            }

            int[] store = new int[v1*v2 - v1 + 1];
            Die[] die = createDice(v1, v2);

            for(int i = 0; i<v3; i++) {
                int sum = 0;
                int[] rollResults = rollDice(die, v2, v3);

                for (int rollResult : rollResults) {
                    sum += rollResult;
                }
                store[sum-v1]++;
            }
            report(v1, store, findMax(store));

        } catch(NumberFormatException e) {
            throw new NumberFormatException("Invalid input: All values must be whole numbers.");
        }

        return new int[] {v1, v2, v3};
    }

    private static Die[] createDice(int numDice, int numSides) {
        Die[] r = new Die[numDice];
        for(int i = 0; i < numDice; i++){
            r[i] = new Die(numSides);
        }
        return r;
    }

    private static int[] rollDice(Die[] dice, int numSides, int numRolls) {
        int[] r = new int[dice.length];
        int val;
        for(int i = 0; i < dice.length; i++) {
            val = 0;
            dice[i].roll();
            val += dice[i].getCurrentValue();
            r[i] += val;
        }
        return r;
    }

    private static int findMax(int[] rolls) {
        int max = rolls[0];
        int iMax = 0;
        for(int i = 0; i < rolls.length; i++) {
            if(rolls[i] > max) {
                max = rolls[i];
                iMax = i;
            }
        }
        return iMax;
    }

    private static void report(int numDice, int[] rolls, int max) {
        int scale = rolls[max] / MAX_DICE;

        if(scale == 0){
            scale = 1;
        }

        int numStars;
        String starString;

        int countWidth = Integer.toString(rolls[max]).length();

        for(int i = 0; i < rolls.length; i++) {
            numStars = rolls[i] / scale;
            starString = "*".repeat(numStars);
            System.out.printf("%2d : %"+ countWidth + "d  %s%n", i + numDice, rolls[i], starString);
        }
    }
}