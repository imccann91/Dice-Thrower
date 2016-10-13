package com.gmail.imccannascii.dice;

/**
 * Created by Ian on 8/1/2016.
 */

import java.lang.String;
import java.lang.Math;


public class DiceRoll {

    private int diceRolls[];
    private boolean criticalHit = false;

    public void rollDFour(int numberOfDice) {
        int roll = 0;

        diceRolls = new int[numberOfDice];

        for (int i = 0; i < numberOfDice; i++) {

            roll = (int) (5 * (Math.random()));

            if (roll == 0) {
                roll = 1;
            } else {
                if (roll >= 4) {
                    roll = 4;
                    criticalHit = true;
                }
            }

            diceRolls[i] = roll;
        }
    }

    public void rollDSix(int numberOfDice) {
        int roll = 0;
        diceRolls = new int[numberOfDice];

        for (int i = 0; i < numberOfDice; i++) {

            roll = (int) (7 * (Math.random()));

            if (roll == 0) {
                roll = 1;
            } else {
                if (roll >= 6) {
                    roll = 6;
                    criticalHit = true;
                }
            }
            diceRolls[i] = roll;
        }
    }

    public void rollDEight(int numberOfDice) {
        int roll = 0;
        diceRolls = new int[numberOfDice];

        for (int i = 0; i < numberOfDice; i++) {

            roll = (int) (9 * (Math.random()));

            if (roll == 0) {
                roll = 1;
            } else {
                if (roll >= 8) {
                    roll = 8;
                    criticalHit = true;
                }
            }
            diceRolls[i] = roll;
        }
    }

    public void rollDTen(int numberOfDice) {
        int roll = 0;
        diceRolls = new int[numberOfDice];

        for (int i = 0; i < numberOfDice; i++) {

            roll = (int) (11 * (Math.random()));

            if (roll == 0) {
                roll = 1;
            } else {
                if (roll >= 10) {
                    roll = 10;
                    criticalHit = true;
                }
            }

            diceRolls[i] = roll;
        }
    }

    public void rollDTwenty(int numberOfDice) {
        int roll = 0;
        diceRolls = new int[numberOfDice];

        for (int i = 0; i < numberOfDice; i++) {

            roll = (int) (21 * (Math.random()));

            if (roll == 0) {
                roll = 1;
            } else {
                if (roll >= 20) {
                    roll = 20;
                    criticalHit = true;
                }
            }

            diceRolls[i] = roll;
        }

    }

    public void rollDThirty(int numberOfDice) {
        int roll = 0;
        diceRolls = new int[numberOfDice];

        for (int i = 0; i < numberOfDice; i++) {

            roll = (int) (31 * (Math.random()));

            if (roll == 0) {
                roll = 1;
            } else {
                if (roll >= 30) {
                    roll = 30;
                    criticalHit = true;
                }
            }
            diceRolls[i] = roll;
        }
    }

    public void rollDOneHundred(int numberOfDice) {
        int roll = 0;
        diceRolls = new int[numberOfDice];

        for (int i = 0; i < numberOfDice; i++) {

            roll = (int) (101 * (Math.random()));

            if (roll == 0) {
                roll = 1;
            } else {
                if (roll >= 100) {
                    roll = 100;
                    criticalHit = true;
                }
            }
            diceRolls[i] = roll;
        }
    }

    public String toString() {

        String rollsAsString = "";

        for (int i = 0; i < diceRolls.length; i++) {

            if (i == diceRolls.length - 1) {
                rollsAsString = rollsAsString + diceRolls[i] + " ";
            } else {
                rollsAsString = rollsAsString + diceRolls[i] + ", ";
            }
        }

        return rollsAsString;
    }

    public int getSumOfRoll() {
        int sum = 0;
        for (int i = 0; i < diceRolls.length; i++) {
            sum = sum + diceRolls[i];
        }
        return sum;
    }

    public boolean isCritical() {
        return criticalHit;
    }

    public void clearCriticalHit() {
        criticalHit = false;
    }

    public int[] getDiceRolls() {
        return diceRolls;
    }
}
