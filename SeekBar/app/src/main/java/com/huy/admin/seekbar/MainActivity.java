package com.huy.admin.seekbar;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SeekBar sbVolume;
    Button btnRun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbVolume = (SeekBar) findViewById(R.id.seekBarVolume);
        btnRun = (Button) findViewById(R.id.buttonRun);

        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(70000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Random random1 = new Random();
                        int sk1 = random1.nextInt(10);
                        int current1= sbVolume.getProgress();
                        if (current1>=sbVolume.getMax()) {
                            this.cancel();
                            Toast.makeText(MainActivity.this, "Con 1 won", Toast.LENGTH_SHORT).show();
                        }
                        if (current1>=sbVolume.getMax()) current1= 0;
                        sbVolume.setProgress(current1+sk1);
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this, "End", Toast.LENGTH_SHORT).show();
                    }
                }.start();

            }
        });
    }
}
