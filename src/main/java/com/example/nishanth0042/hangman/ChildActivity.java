package com.example.nishanth0042.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {
    Button submit;
    char vowels[]={'a','e','i','o','u','A','E','I','O','U',' '};
    TextView hang;
    TextView moviestatus;
    EditText letter;
    Button checker;
    String movietext;
    int len;
    StringBuilder movie;
    StringBuilder hman;
    int count;
    String l;
    int flag2;
    int lefttobeguessed;
    TextView player;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        Intent startingIntent=getIntent();
        movietext= startingIntent.getStringExtra(Intent.EXTRA_TEXT);
        movie=new StringBuilder(movietext);
        len=movietext.length();
        hang=(TextView)findViewById(R.id.textView2);
        moviestatus=(TextView)findViewById(R.id.textView4);
        checker=(Button)findViewById(R.id.button2);
        letter=(EditText)findViewById(R.id.editText2);
        hman=new StringBuilder("hangman");
        player=(TextView)findViewById(R.id.textView3);
        for(int i=0;i<len;i++){
            int flag=1;
            for(int j=0;j<vowels.length;j++){
                if (vowels[j]==movietext.charAt(i)){
                    flag=0;
                }
            }
            if(flag==1){
                movie.setCharAt(i,'*');
            }
        }
        count=-1;
        lefttobeguessed=0;
        for (int j=0;j<len;j++){
            if (movie.charAt(j)=='*'){
                lefttobeguessed++;
            }
        }
        moviestatus.setText(movie.toString());
        hang.setText(hman);


            checker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (count < 6 && lefttobeguessed > 0) {
                        l = letter.getText().toString();
                        if (l.length() == 1) {
                            flag2 = 0;
                            for (int i = 0; i < len; i++) {
                                if (l.charAt(0) == movietext.charAt(i)) {
                                    if (movie.charAt(i) == '*') {
                                        movie.setCharAt(i, l.charAt(0));
                                        flag2 = 1;
                                        break;
                                    }
                                }
                            }
                            if (flag2 == 1) {
                                moviestatus.setText(movie.toString());
                                lefttobeguessed--;
                                count++;
                                hman.setCharAt(count, 'x');
                                hang.setText(hman.toString());
                            } else {
                                count++;
                                hman.setCharAt(count, 'x');
                                hang.setText(hman.toString());
                            }
                            if (count >= 6 || lefttobeguessed <= 0){
                                if (count >= 6){
                                    player.setText("PLATER 1 WINS!!");
                                }
                                else {
                                    player.setText("PLAYER 2 WINS!!");
                                }
                            }
                        }
                    }
                }
            });






    }
}
