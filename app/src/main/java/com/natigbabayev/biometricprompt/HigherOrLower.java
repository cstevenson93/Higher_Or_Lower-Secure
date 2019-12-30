package com.natigbabayev.biometricprompt;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.Math;

public class HigherOrLower extends AppCompatActivity {

    int genNum;
    String output;

    public void generateRandomNumber(){
        genNum = (int) (Math.random() * 20 + 1);
    }



    public void guessNumber(View view){

        //Retrieves user's guess and converts it into an int
        EditText guessEditText = (EditText) findViewById(R.id.guessEditText);
        int userGuess = Integer.parseInt(guessEditText.getText().toString());

        //Show developer numbers being used in Logcat
        Log.i("Generated Number: ", Integer.toString(genNum));
        Log.i("User Guess: ", Integer.toString(userGuess));

        //Determines whether the guess is a valid;
        if (userGuess <= 20 && userGuess >= 1) {
            //show user if their guess is too high
            if (userGuess > genNum) {
                output ="Lower";
            }

            //show user if their guess is too low
            if (userGuess < genNum) {
                output ="Higher";
            }

            //show user if their guess is correct; new number is generated
            if (userGuess == genNum) {
                output ="Correct! Try again!";
                generateRandomNumber();
            }
        } else
            output = "Number must be between 1 and 20";

        //Displays output
        Toast.makeText(HigherOrLower.this, output, Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.higher_or_lower);

        generateRandomNumber();
    }
}