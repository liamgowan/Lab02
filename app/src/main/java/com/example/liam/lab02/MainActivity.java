package com.example.liam.lab02;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView time;
    Button start;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.ssbutton);
        time = (TextView) findViewById(R.id.time);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(1000,100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        count++;
                        time.setText(Integer.toString(count));
                    }

                    @Override
                    public void onFinish() {
                        //Set text to "00", reset the count as well
                        time.setText("00");
                        count = 0;
                        //make and show toast
                        Context context = getApplicationContext();
                        CharSequence text = "Timer done!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }.start();
            }
        });
    }
}
