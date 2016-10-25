package com.example.gustavoranz.cs477_lab_2;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private Button button_noResult, button_withResult, button_implicitly;
    private EditText input1, input2;
    private String s_input1, s_input2, buttonIdentifier;
    private int input1_num, input2_num, counter=0;
    private TextView textView_result, textView_counter;
    private Bundle newBundle = new Bundle();

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_counter = (TextView) findViewById(R.id.textView_counter);

        //Linking buttons from layout to button objects created in this file
        button_noResult = (Button) findViewById(R.id.button_noResult);
        button_withResult = (Button) findViewById(R.id.button_withResult);
        button_implicitly = (Button) findViewById(R.id.button_implicitly);

        //creating the EditText objects so that I can read in the users input
        input1 = (EditText) findViewById(R.id.editText_input1);
        input2 = (EditText) findViewById(R.id.editText_input2);

        textView_counter.setText("Rotation Counter: " + counter);

        //Event Listener for the Convert Button
        button_noResult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                buttonIdentifier = "noResult";
                // Getting the string that the user types in to the editText
                s_input1 = input1.getText().toString();
                s_input2 = input2.getText().toString();

                //Converting string into integer, with a try/catch to check for strings
                try {
                    input1_num = Integer.parseInt(s_input1);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Illegal input, please type in a number", Toast.LENGTH_SHORT).show();
                }

                //Converting string into integer, with a try/catch to check for strings
                try {
                    input2_num = Integer.parseInt(s_input2);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Illegal input, please type in a number", Toast.LENGTH_SHORT).show();
                }

                //creating an intent  for the ActivityA
                Intent myIntentWithNoResult = new Intent(MainActivity.this, ActivityA.class);
                Bundle extras = new Bundle();//This bundle allows me to pass 2 different strings to the new activity
                extras.putString("Input1", s_input1);//attaching the string to my bundle
                extras.putString("Input2", s_input2);//attaching the string to my bundle
                extras.putString("Identifier", buttonIdentifier);//attaching the buttonIdentifier
                myIntentWithNoResult.putExtras(extras);//attaching the bundle to the intent
                startActivity(myIntentWithNoResult);//starting the new activity
            }

        });

        //Event Listener for the withResult button
        button_withResult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                buttonIdentifier = "withResult";
                // Getting the string that the user types in to the editText
                s_input1 = input1.getText().toString();
                s_input2 = input2.getText().toString();

                //Converting string into integer, with a try/catch to check for strings
                try {
                    input1_num = Integer.parseInt(s_input1);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Illegal input, please type in a number", Toast.LENGTH_SHORT).show();
                }

                //Converting string into integer, with a try/catch to check for strings
                try {
                    input2_num = Integer.parseInt(s_input2);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Illegal input, please type in a number", Toast.LENGTH_SHORT).show();
                }

                //creating an intent  for the ActivityA
                Intent myIntentWithResult = new Intent(MainActivity.this, ActivityA.class);
                Bundle extras = new Bundle();//This bundle allows me to pass 2 different strings to the new activity
                extras.putString("Input1", s_input1);//attaching the string to my bundle
                extras.putString("Input2", s_input2);//attaching the string to my bundle
                extras.putString("Identifier", buttonIdentifier);//attaching the string to my bundle
                myIntentWithResult.putExtras(extras);//attaching the bundle to the intent
                startActivityForResult(myIntentWithResult, 1);//starting the new activity with result
            }

        });

        //Event Listener for the Convert Implicitly
        button_implicitly.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //This is used to start lab1 by clicking this button
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setType("text/plain");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);

            }

        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        textView_result = (TextView) findViewById(R.id.textView_result);

        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                textView_result.setText("Result: " + data.getStringExtra("Result"));
            }
            if (resultCode == RESULT_CANCELED) {
                textView_result.setText("No result passed back.");
            }
        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        counter++;
        textView_counter.setText("Rotation Counter: " + counter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("STATE_COUNTER", counter);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("STATE_COUNTER");
    }



    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.gustavoranz.cs477_lab_2/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.gustavoranz.cs477_lab_2/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
