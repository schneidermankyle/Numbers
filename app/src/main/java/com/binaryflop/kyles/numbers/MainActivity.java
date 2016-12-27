package com.binaryflop.kyles.numbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.game = new Game(100);
        game.SetMaxGuesses(5);
    }

    public void checkGuess(View view) {
        int guess = 0;
        EditText input = (EditText) findViewById(R.id.guessed);

        // Check to make sure that an input has been
        if (input.getText().toString().trim().isEmpty())
            return;

        // parse our guess
        try {
            guess = Integer.parseInt(input.getText().toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        // If guesses are still valid, go ahead and submit guess.
        if (game.CanGuess()) {
            game.Guess(guess);

            // Since we have won, send the user to win screen
            if (game.HasWon()) {
                // Go to you have won menu
                System.out.println("you have won");
                return;
            }

            // Since we lost, go ahead and send the user to lost screen

            if (game.HasLost()) {
                setContentView(R.layout.lost);
                System.out.println("You have lost");
                return;
            }

            game.Debug();
            // Since we have not lost nor won, just display the message.
            Toast.makeText(getApplicationContext(), game.GetMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void NewGame(View view) {
        game.NewGame();
        setContentView(R.layout.activity_main);
    }
}
