package com.binhvo.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    Button mTrueButton;
    Button mFalseButton;
    TextView mTextview;
    int mIndex = 0; // index for the questions
    int mQuestionID;

    // Stores the questions with its 'resource id' in an array so we can retrieve it later
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true), // Creating the trueFalse object dynamically
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mTextview = findViewById(R.id.question_text_view);


        mQuestionID = mQuestionBank[mIndex].getQuestionID(); // Retrieve the question id from the question bank
        mTextview.setText(mQuestionID); // Display the question text on the view scene



        // 1st way - Creating a Listener Callback to be set on the component. Type - View InterfaceType - OnClickListener
        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
                Toast.makeText(getApplicationContext(), "True Pressed", Toast.LENGTH_SHORT).show();
            }
        };
        mTrueButton.setOnClickListener(myListener); // Register the callback on the component


        // 2nd way - Creating an anonymous listener
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
                Toast myToast = Toast.makeText(MainActivity.this, "False pressed", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

    }

    private void updateQuestion() {
        mIndex = mIndex + 1;
        mQuestionID = mQuestionBank[mIndex].getQuestionID();
        mTextview.setText(mQuestionID);
    }
}
