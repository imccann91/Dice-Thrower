package com.gmail.imccannascii.dice;

public class Vorple {

    private DiceRoll diceRoll;
    private int roll;

    public Vorple() {
        diceRoll = new DiceRoll();
        roll = 0;
    }
    
    public void rollVorple() {
        diceRoll.rollDSix(1);
        roll = diceRoll.getDiceRolls()[0];
    }

    public String getString() {
        String bodyPart = "";
        switch (roll) {
            case 1:
                bodyPart = "Head";
                break;
            case 2:
                bodyPart = "Torso";
                break;
            case 3:
                bodyPart = "Left Arm";
                break;
            case 4:
                bodyPart = "Right Arm";
                break;
            case 5:
                bodyPart = "Left Leg";
                break;
            case 6:
                bodyPart = "Right Leg";
                break;
        }
        return bodyPart;
    }
}
