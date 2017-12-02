package com.huy.admin.progressbarcountdowntime;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar pbXuly;
    Button btnDownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbXuly = (ProgressBar) findViewById(R.id.progressBarXuly);
        btnDownload = (Button) findViewById(R.id.buttonDownload);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(10000, 500) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = pbXuly.getProgress();
                        if (current >= pbXuly.getMax()) current = 0;
                        pbXuly.setProgress(current + 10);
                    }

                    @Override
                    public void onFinish() {
                        this.start();
                    }
                };
                countDownTimer.start();

            }
        });


    }
}
