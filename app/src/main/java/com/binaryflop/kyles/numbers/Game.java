package com.binaryflop.kyles.numbers;

import java.util.Random;
/**
 * Created by kylei on 12/26/2016.
 */

public class Game extends MainActivity {
    private int randomNumber;
    private int maxNumber;
    private int maxGuesses;
    private int guessCount = 0;
    private Random randomGenerator = new Random();
    private String message = "None";
    private boolean won = false;

    public Game(int MaxValue) {
        if (MaxValue > 0) {
            try {
                this.maxNumber = MaxValue;
                this.randomNumber = this.randomGenerator.nextInt(this.maxNumber + 1);
            } catch (Exception e) {
                System.out.println(e.toString());
            }

        }
    }

    public void SetMaxGuesses(int MaxGuesses) {
        if (MaxGuesses > 0) {
            try {
                this.maxGuesses = MaxGuesses;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public String GetMessage() {
        return this.message;
    }

    public boolean CanGuess() {
        return ((guessCount < maxGuesses) && (this.won != true) ) ? true : false;
    }

    public boolean HasWon() {
        return won;
    }

    public boolean HasLost() {
        return (guessCount >= maxGuesses && !this.won ) ? true : false;
    }

    public void Guess(int guessedValue) {
        if (guessedValue < 0 || guessedValue > this.maxNumber)
            return;

        this.guessCount++;

        if (randomNumber == guessedValue) {
            // We have won
            this.won = true;
            this.message = "You have won!";
        } else if (randomNumber > guessedValue) {
            this.won = false;
            this.message = "Low";
        } else {
            this.won = false;
            this.message = "High";
        }

    }

    public void NewGame() {
        this.guessCount = 0;
        this.randomNumber = this.randomGenerator.nextInt(this.maxNumber + 1);
        this.message = "None";
    }

    public void Debug() {
        System.out.println("Max Guesses:" + this.maxGuesses);
        System.out.println("Won: " + this.won);
        System.out.println("Max Number: " + this.maxNumber);
        System.out.println("Guess Count: " + this.guessCount);
        System.out.println("Message: " + this.message);
    }

}
