package com.example.jokerfactory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Killing_joke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_killing_joke);

        TextView textview = (TextView) findViewById(R.id.joke_text);

        //Retrieve the joke from the Intent Extras
        String JokeResult = null;

        Intent intent = getIntent();
        JokeResult = intent.getStringExtra("MR JOKER");

        if (JokeResult != null) {
            textview.setText(JokeResult);
        } else {
            textview.setText("MR J ALREADY LEFT,TRY AGAIN");
        }
    }
}
