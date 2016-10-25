package com.example.gustavoranz.cs477_lab_2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityA extends AppCompatActivity {

    private String input1_str, input2_str, finalString, buttonIdentifier;
    private int input1_int, input2_int, result;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Intent intent = getIntent(); //creating and getting intent from mainActivity
        Bundle extras = intent.getExtras();//creating and getting bundle from intent
        input1_str = extras.getString("Input1");//getting string Input1 from bundle
        input2_str = extras.getString("Input2");//getting string Input2 from bundle
        buttonIdentifier = extras.getString("Identifier");//getting string Input2 from bundle
        input1_int = Integer.parseInt(input1_str);//converting string to int
        input2_int = Integer.parseInt(input2_str);//converting string to int
        result = input1_int * input2_int; //calculation
        finalString = input1_str + " * " + input2_str + " = " + result;//string concatenation

        resultView = (TextView) findViewById(R.id.textView_1);//linking TextView to be able to display string
        resultView.setText(finalString);//setting String to be displayed by TextView

        if(buttonIdentifier.equalsIgnoreCase("noResult"))
            finalString = "No result passed back";
    }

    @Override
    public void onBackPressed(){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("Result", finalString);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
