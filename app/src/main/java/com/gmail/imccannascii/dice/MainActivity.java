package com.gmail.imccannascii.dice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button rollButton;
    private Button clearButton;
    private TextView resultsText;
    private TextView summationText;
    private Spinner typeOfDiceSelection;
    private Spinner numberOfDiceSelection;
    private Context mainContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String message = "";
        mainContext = this.getApplicationContext();

        //Obtaining the ID's from the various XML entities.
        //So they can be referenced and used throughout the program.
        rollButton = (Button) findViewById(R.id.rollButtonID);
        clearButton = (Button) findViewById(R.id.clearButtonID);
        resultsText = (TextView) findViewById(R.id.resultsTextID);
        summationText = (TextView) findViewById(R.id.summationResultID);

        typeOfDiceSelection = (Spinner) findViewById(R.id.typeOfDiceSelectionID);


        //Populating the type of dice spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.diceType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeOfDiceSelection.setAdapter(adapter);

        numberOfDiceSelection = (Spinner) findViewById(R.id.numberOfDiceSelectionID);

        //Populating the number of dice spinner
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this, R.array.diceNumber, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberOfDiceSelection.setAdapter(adapter2);

        rollButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                boolean isVorple = false;
                int numberOfDiceToThrow = numberOfDiceSelection.getSelectedItemPosition();
                int typeOfDiceToThrow = typeOfDiceSelection.getSelectedItemPosition();
                String message = "";
                String summation = "";

                VibrateNotification vibrateNotification = new VibrateNotification();
                AudioNotification audioNotification = new AudioNotification();

                //Setup the vibration and audio notification threads to have this activities mainContext.
                vibrateNotification.setContext(mainContext);
                audioNotification.setContext(mainContext);

                DiceRoll diceRoll = new DiceRoll();

                switch(typeOfDiceToThrow)
                {
                    case 0:
                        diceRoll.rollDFour(numberOfDiceToThrow + 1);
                        message = diceRoll.toString();
                        break;
                    case 1:
                        diceRoll.rollDSix(numberOfDiceToThrow + 1);
                        message = diceRoll.toString();
                        break;
                    case 2:
                        diceRoll.rollDEight(numberOfDiceToThrow + 1);
                        message = diceRoll.toString();
                        break;
                    case 3:
                        diceRoll.rollDTen(numberOfDiceToThrow + 1);
                        message = diceRoll.toString();
                        break;
                    case 4:
                        diceRoll.rollDTwenty(numberOfDiceToThrow + 1);
                        message = diceRoll.toString();
                        break;
                    case 5:
                        diceRoll.rollDThirty(numberOfDiceToThrow + 1);
                        message = diceRoll.toString();
                        break;
                    case 6:
                        diceRoll.rollDOneHundred(numberOfDiceToThrow + 1);
                        message = diceRoll.toString();
                        break;
                    case 7:
                        isVorple = true;
                        Vorple vorple = new Vorple();
                        vorple.rollVorple();
                        message = vorple.getString();
                        break;
                }

                if (diceRoll.isCritical() == true && typeOfDiceToThrow == 4) {
                    vibrateNotification.start();
                    audioNotification.setUpAudioNotifier("");
                    audioNotification.start();
                }else if(diceRoll.isCritical() == true){
                    vibrateNotification.start();
                }

                if(isVorple == false) {
                    summation = summation + diceRoll.getSumOfRoll();
                    summationText.setText(summation);
                    diceRoll.clearCriticalHit();
                }else{
                    summationText.setText(summation);
                    diceRoll.clearCriticalHit(); //Shouldn't need this, doing it anyway.
                    audioNotification.setUpAudioNotifier(message);
                    audioNotification.start();
                }

                resultsText.setText(message);
            }
        });

        clearButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                resultsText.setText("");
                summationText.setText("");
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("message", resultsText.getText().toString());
        savedInstanceState.putString("summation", summationText.getText().toString());
        savedInstanceState.putInt("numberOfDice", numberOfDiceSelection.getSelectedItemPosition());
        savedInstanceState.putInt("typeOfDice", typeOfDiceSelection.getSelectedItemPosition());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        resultsText.setText(savedInstanceState.getString("message"));
        summationText.setText(savedInstanceState.getString("summation"));
        numberOfDiceSelection.setSelection(savedInstanceState.getInt("numberOfDice"));
        typeOfDiceSelection.setSelection(savedInstanceState.getInt("typeOfDice"));
    }
}

