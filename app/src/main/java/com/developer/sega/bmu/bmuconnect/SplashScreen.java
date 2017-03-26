package com.developer.sega.bmu.bmuconnect;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    public static final int seconds = 8 ;
    public static final int milliseconds= seconds * 1000;
    public static final int delay=2;
    private ProgressBar pbprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        pbprogress= (ProgressBar)findViewById(R.id.progressBar);
        pbprogress.setMax(maximum_progess());
        StartAnimation();
    }
    public void StartAnimation()
    {
        new CountDownTimer(milliseconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                pbprogress.setProgress(establish_progress(millisUntilFinished));
            }

            @Override
            public void onFinish() {
            startActivity(new Intent(SplashScreen.this,Login.class));
                finish();
            }
        }.start();
    }

    public int establish_progress(long miliseconds)
    {
        return (int)((milliseconds-miliseconds)/1000);
    }

    public int maximum_progess()
    {
            return  seconds-delay;
    }
}
