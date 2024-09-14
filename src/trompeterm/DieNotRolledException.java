/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Miles Trompeter
 * Last Updated: 9/14/24
 */
package trompeterm;

/**
 * Die not rolled exception class - for if the die is not
 * yet rolled and the value is still requested.
 */
public class DieNotRolledException extends RuntimeException {

    public String getMessage() {
        return "The die has not been rolled yet.";
    }
}
