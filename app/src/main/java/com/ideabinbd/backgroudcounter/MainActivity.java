package com.ideabinbd.backgroudcounter;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart= findViewById(R.id.button);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });
    }

    private void startTimer() {
        btnStart.setEnabled(false);
        //first parameter is the number of total seconds 2nd is the number of interval
        new CountDownTimer(60000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                String timeRemaining="0:"+String.valueOf(millisUntilFinished / 1000);
                btnStart.setText(timeRemaining);

            }

            @Override
            public void onFinish() {
                String btnText="Resend";
                btnStart.setText(btnText);
                btnStart.setEnabled(true);
            }
        }.start();
    }
}
