package com.example.nishanth0042.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button challengebutton;
    EditText movietext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        challengebutton=(Button)findViewById(R.id.button);
        movietext=(EditText)findViewById(R.id.editText);
        challengebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( !movietext.getText().toString().equals("") && movietext.getText().toString().length() > 0) {
                    String movie = movietext.getText().toString();

                    Intent myIntent;
                    myIntent = new Intent(MainActivity.this, ChildActivity.class);
                    myIntent.putExtra(Intent.EXTRA_TEXT, movie);
                    startActivity(myIntent);
                }
            }
        });



    }
}
