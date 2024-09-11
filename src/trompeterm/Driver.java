/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Miles Trompeter
 * Last Updated: 9/11/24
 */

package trompeterm;

import java.util.Scanner;

public class Driver {

    public final int MIN_DICE = 2;
    public final int MAX_DICE = 10;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] inputs = getInput(reader);
        int numDice = inputs[0];
        int sides = inputs[1];
        int rolls = inputs[2];
        int[] store = new int[numDice*sides - sides + 1];

        Die[] die = createDice(numDice, sides);
        int[] rollResults = rollDice(die, sides, rolls);

        for(int i = 0; i < rollResults.length; i++) {
            System.out.println(rollResults[i]);
        }



    }

    static int[] getInput(Scanner sc){
        System.out.println("Please enter the number of dice to roll, how many sides the dice have," +
                "\n and how many rolls to complete, separating the values by a space." +
                "\n Example: 2 6 1000 \nEnter Configuration: ");
        int v1;
        int v2;
        int v3;

        v1 = sc.nextInt();
        v2 = sc.nextInt();
        v3 = sc.nextInt();

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
        for (int roll : rolls) {
            if (roll > max) {
                max = roll;
            }
        }
        return max;
    }

    private void report(int numDice, int[] rolls, int max) {
        
    }
}