package com.aasavari.quizapp;

import android.app.Application;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.R.attr.checked;
import static android.R.attr.value;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "Quiz App";
    private static int score = 0;
    private static boolean bCompletedGrp1;
    private static boolean bCompletedGrp2;
    private static boolean bCompletedGrp3;
    private static boolean bCompletedGrp4;
    private static boolean bCompletedGrp5;
    private static boolean bCompletedGrp6;
    private static boolean bCompletedCb1;
    private static boolean bCompletedCb2;
    private static boolean bCompletedCb3;
    private static boolean bCompletedCb4;
    private static boolean bCompletedCb5;
    private static boolean bCompletedCb6;
    private static boolean bCompletedCb7;
    private static boolean bCompletedCb8;
    private static boolean bCompletedCb9;
    private static boolean bCompletedCb10;
    private static boolean bCompletedCb11;
    private static boolean bCompletedCb12;
    private static boolean bCompletedEdit1;
    private static boolean bCompletedEdit2;
    private static List<CheckBox> chkBoxIds = new ArrayList<CheckBox>(); // we maintain this list of checkbox ids so that they can be cleared at the same time later on
    private final int numCheckBoxes = 12;
    private RadioGroup radioGrp1;
    private RadioGroup radioGrp2;
    private RadioGroup radioGrp3;
    private RadioButton selectedOption;
    private String[] options;
    private String[] questions;
    private TextView question1;
    private TextView question2;
    private TextView question3;
    private TextView question4;
    private TextView question5;
    private TextView question6;
    private TextView question7;
    private TextView question8;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private CheckBox cb5;
    private CheckBox cb6;
    private CheckBox cb7;
    private CheckBox cb8;
    private CheckBox cb9;
    private CheckBox cb10;
    private CheckBox cb11;
    private CheckBox cb12;
    private EditText editOne;
    private EditText editTwo;
    private Button submitBtn;
    private TextView scoreView;
    private int radioBtnCount;
    private AnswerKey mAnswerKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get the resources for this app in a res object
        Resources res = getResources();
        //Extract the questions array from the resources to populate the text-views with questions
        questions = res.getStringArray(R.array.question);
        //initialize the answer-key class to create a map of correct answers and their corresponding buttons
        mAnswerKey = new AnswerKey(this);
        //find all the question text views and populate their text fields from the questions array
        question1 = (TextView) findViewById(R.id.question1);
        question1.setText(questions[0]);
        question2 = (TextView) findViewById(R.id.question2);
        question2.setText(questions[1]);
        question3 = (TextView) findViewById(R.id.question3);
        question3.setText(questions[2]);
        question4 = (TextView) findViewById(R.id.question4);
        question4.setText(questions[3]);
        question5 = (TextView) findViewById(R.id.question5);
        question5.setText(questions[4]);
        question6 = (TextView) findViewById(R.id.question6);
        question6.setText(questions[5]);
        question7 = (TextView) findViewById(R.id.question7);
        question7.setText(questions[6]);
        question8 = (TextView) findViewById(R.id.question8);
        question8.setText(questions[7]);
        scoreView = (TextView) findViewById(R.id.score);
        editOne = (EditText) findViewById(R.id.editOne);
        editTwo = (EditText) findViewById(R.id.editTwo);
        submitBtn = (Button) findViewById(R.id.submit);
        //reuse the options array to now get a list of answer options for radiogroup1
        options = res.getStringArray(R.array.options_q1);
        radioGrp1 = (RadioGroup) findViewById(R.id.answerGroup1);
        //get the number of radio buttons inside the radio group
        radioBtnCount = radioGrp1.getChildCount();
        //set the radio buttons' text fields using the options strings
        for (int i = 0; i < radioBtnCount; i++) {
            ((RadioButton) radioGrp1.getChildAt(i)).setText(options[i]);
        }
        //make sure that all radio buttons are de-selected at first
        radioGrp1.clearCheck();
        //reuse the options array to now get a list of answer options for radiogroup2
        options = res.getStringArray(R.array.options_q2);
        radioGrp2 = (RadioGroup) findViewById(R.id.answerGroup2);
        //get the number of radio buttons inside the radio group
        radioBtnCount = radioGrp2.getChildCount();
        //set the radio buttons' text fields using the options strings
        for (int i = 0; i < radioBtnCount; i++) {
            ((RadioButton) radioGrp2.getChildAt(i)).setText(options[i]);
        }
        //make sure that all radio buttons are de-selected at first
        radioGrp2.clearCheck();
        //reuse the options array to now get a list of answer options for radiogroup3
        options = res.getStringArray(R.array.options_q3);
        radioGrp3 = (RadioGroup) findViewById(R.id.answerGroup3);
        //get the number of radio buttons inside the radio group
        radioBtnCount = radioGrp3.getChildCount();
        //set the radio buttons' text fields using the options strings
        for (int i = 0; i < radioBtnCount; i++) {
            ((RadioButton) radioGrp3.getChildAt(i)).setText(options[i]);
        }
        //make sure that all radio buttons are de-selected at first
        radioGrp3.clearCheck();
        //reuse the options array to now get a list of answer options for question4
        options = res.getStringArray(R.array.options_q4);
        //set the text for  each of the four checkboxes using this options array
        cb1 = (CheckBox) findViewById(R.id.check1Q4);
        chkBoxIds.add(cb1);
        cb1.setText(options[0]);
        cb2 = (CheckBox) findViewById(R.id.check2Q4);
        chkBoxIds.add(cb2);
        cb2.setText(options[1]);
        cb3 = (CheckBox) findViewById(R.id.check3Q4);
        chkBoxIds.add(cb3);
        cb3.setText(options[2]);
        cb4 = (CheckBox) findViewById(R.id.check4Q4);
        chkBoxIds.add(cb4);
        cb4.setText(options[3]);
        //reuse the options array to now get a list of answer options for question5
        options = res.getStringArray(R.array.options_q5);
        //set the text for  each of the four checkboxes using this options array
        cb5 = (CheckBox) findViewById(R.id.check1Q5);
        chkBoxIds.add(cb5);
        cb5.setText(options[0]);
        cb6 = (CheckBox) findViewById(R.id.check2Q5);
        chkBoxIds.add(cb6);
        cb6.setText(options[1]);
        cb7 = (CheckBox) findViewById(R.id.check3Q5);
        chkBoxIds.add(cb7);
        cb7.setText(options[2]);
        cb8 = (CheckBox) findViewById(R.id.check4Q5);
        chkBoxIds.add(cb8);
        cb8.setText(options[3]);
        //reuse the options array to now get a list of answer options for question6
        options = res.getStringArray(R.array.options_q6);
        //set the text for  each of the four checkboxes using this options array
        cb9 = (CheckBox) findViewById(R.id.check1Q6);
        chkBoxIds.add(cb9);
        cb9.setText(options[0]);
        cb10 = (CheckBox) findViewById(R.id.check2Q6);
        chkBoxIds.add(cb10);
        cb10.setText(options[1]);
        cb11 = (CheckBox) findViewById(R.id.check3Q6);
        chkBoxIds.add(cb11);
        cb11.setText(options[2]);
        cb12 = (CheckBox) findViewById(R.id.check4Q6);
        chkBoxIds.add(cb12);
        cb12.setText(options[3]);
        //clear all the checkboxes at first
        for (CheckBox ch : chkBoxIds)
            ch.setChecked(false);
        //set event listeners for each radio group to modify the score if the correct radio button is picked
        radioGrp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //find the clicked/selected radio button by the id passed to the event
                selectedOption = (RadioButton) findViewById(i);
                //extract the string from the text field of the radio button
                String answer = selectedOption.getText().toString();
                //if the radiogroup has not yet been clicked for answers, then verify the answer
                //by calling into the ModifyScore method from the answerkey helper class
                //to this method, we pass the key and value pair formed by the button id and the answer string from its text field
                if (!bCompletedGrp1)
                    bCompletedGrp1 = ModifyScore(selectedOption.getId(), answer, bCompletedGrp1);
                else
                    Toast.makeText(getApplicationContext(), "You have already chosen an answer", Toast.LENGTH_SHORT).show();
            }
        });
        radioGrp2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selectedOption = (RadioButton) findViewById(i);
                String answer = selectedOption.getText().toString();
                if (!bCompletedGrp2)
                    bCompletedGrp2 = ModifyScore(selectedOption.getId(), answer, bCompletedGrp2);
                else
                    Toast.makeText(getApplicationContext(), "You have already chosen an answer", Toast.LENGTH_SHORT).show();
            }
        });
        radioGrp3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selectedOption = (RadioButton) findViewById(i);
                String answer = selectedOption.getText().toString();
                if (!bCompletedGrp3)
                    bCompletedGrp3 = ModifyScore(selectedOption.getId(), answer, bCompletedGrp3);
                else
                    Toast.makeText(getApplicationContext(), "You have already chosen an answer", Toast.LENGTH_SHORT).show();
            }
        });

        //set the event listener for the final submit button to give the user their final score
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editOneAns = editOne.getText().toString().trim().toLowerCase();
                bCompletedEdit1 = ModifyScore(R.id.editOne, editOneAns, bCompletedEdit1);
                String editTwoAns = editTwo.getText().toString().trim().toLowerCase();
                bCompletedEdit2 = ModifyScore(R.id.editTwo, editTwoAns, bCompletedEdit2);
                String finalScore = "Your final score is " + String.valueOf(score);
                Toast.makeText(getApplicationContext(), finalScore, Toast.LENGTH_SHORT).show();

            }
        });
    }

    //for checkboxes, implement the method defined in the OnClick attribute of the XML for the checkbox
    //use the same method for all the checkboxes in the XML
    //if the checkbox is checked, then send its id and the string from its text field to the ModifyScore method
    //set the checked value of this checkbox to true. At the same time uncheck all the other checkboxes related to this question
    //each question has checkboxes that follow it, related to it.
    public void CheckBoxChecked(View v) {
        switch (v.getId()) {
            case R.id.check1Q4:
                bCompletedCb1 = true;
                break;
            case R.id.check2Q4:
                bCompletedCb2 = true;
                break;
            case R.id.check3Q4:
                bCompletedCb3 = true;
                break;
            case R.id.check4Q4:
                bCompletedCb4 = true;
                break;
            case R.id.check1Q5:
                bCompletedCb5 = true;
                break;
            case R.id.check2Q5:
                bCompletedCb6 = true;
                break;
            case R.id.check3Q5:
                bCompletedCb7 = true;
                break;
            case R.id.check4Q5:
                bCompletedCb8 = true;
                break;
            case R.id.check1Q6:
                bCompletedCb9 = true;
                break;
            case R.id.check2Q6:
                bCompletedCb10 = true;
                break;
            case R.id.check3Q6:
                bCompletedCb11 = true;
                break;
            case R.id.check4Q6:
                bCompletedCb12 = true;
                break;
        }
        if(!bCompletedGrp4) {
            if (bCompletedCb2 == true && bCompletedCb4 == true && bCompletedCb1 == false && bCompletedCb3 == false) {
                score++;
                scoreView.setText(String.valueOf(score));
                bCompletedCb2 = bCompletedCb4 = false;
                bCompletedGrp4 = true;
            }
        }
        if(!bCompletedGrp5) {
            if (bCompletedCb5 == true && bCompletedCb7 == true && bCompletedCb6 == false && bCompletedCb8 == false) {
                score++;
                scoreView.setText(String.valueOf(score));
                bCompletedCb5 = bCompletedCb7 = false;
                bCompletedGrp5 = true;
            }
        }
        if(!bCompletedGrp6) {
            if (bCompletedCb11 == true && bCompletedCb12 == true && bCompletedCb9 == false && bCompletedCb10 == false) {
                score++;
                scoreView.setText(String.valueOf(score));
                bCompletedCb11 = bCompletedCb12 = false;
                bCompletedGrp6 = true;
            }
        }

    }


    //In this method, we check if the passed in key and value are a matching pair and then increase
    //the score for the player. We also make sure that multiple clicks on the same question
    //do not yield increases in the score. We keep track of this with the bCompleted Boolean variable.
    private boolean ModifyScore(int key, String value, boolean bCompleted) {
        try {
            if (mAnswerKey.IsRightAnswer(key, value)) {
                if (!bCompleted) {
                    score++;
                    scoreView.setText(String.valueOf(score));
                }
                bCompleted = true;
            }

        } catch (Exception e) {
            Log.e(LOG_TAG, e.getStackTrace().toString());
        }
        return bCompleted;
    }

}





