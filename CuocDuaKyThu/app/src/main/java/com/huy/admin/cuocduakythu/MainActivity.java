package com.huy.admin.cuocduakythu;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton ibtnPlay;
    CheckBox checkBoxOne, checkBoxTwo, checkBoxThree;
    SeekBar seekBarOne, seekBarTwo, seekBarThree;
    TextView textViewScore;
    int Score = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        CheckBox();
        seekBarOne.setEnabled(false);
        seekBarTwo.setEnabled(false);
        seekBarThree.setEnabled(false);
        textViewScore.setText(Score + "");



       final CountDownTimer countDownTimer = new CountDownTimer(100000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                Random random = new Random();
                int numberOne = random.nextInt(5);
                int numberTwo = random.nextInt(5);
                int numberThree = random.nextInt(5);
                int currentOne = seekBarOne.getProgress();
                int currentTwo = seekBarTwo.getProgress();
                int currentThree = seekBarThree.getProgress();
                seekBarOne.setProgress(currentOne + numberOne);
                seekBarTwo.setProgress(currentTwo + numberTwo);
                seekBarThree.setProgress(currentThree + numberThree);

                if (seekBarOne.getProgress() >= seekBarOne.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Con thu 1 Win", Toast.LENGTH_SHORT).show();
                    if (checkBoxOne.isChecked()){
                        Toast.makeText(MainActivity.this, "Ban da thang", Toast.LENGTH_SHORT).show();
                        Score +=10;
                    }else {
                        Toast.makeText(MainActivity.this, "Ban da thua", Toast.LENGTH_SHORT).show();
                        Score -=5;
                    }
                    textViewScore.setText(Score + "");
                    SetEnableCheckBox();
                }
                if (seekBarTwo.getProgress() >= seekBarOne.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Con thu 2 Win", Toast.LENGTH_SHORT).show();
                    if (checkBoxTwo.isChecked()){
                        Toast.makeText(MainActivity.this, "Ban da thang", Toast.LENGTH_SHORT).show();
                        Score +=10;
                    }else{
                        Toast.makeText(MainActivity.this, "Ban da thua", Toast.LENGTH_SHORT).show();
                        Score -=5;
                    }
                    textViewScore.setText(Score + "");
                    SetEnableCheckBox();
                }
                if (seekBarThree.getProgress() >= seekBarOne.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Con thu 3 Win", Toast.LENGTH_SHORT).show();
                    if (checkBoxThree.isChecked()){
                        Toast.makeText(MainActivity.this, "Ban da thang", Toast.LENGTH_SHORT).show();
                        Score +=10;
                    }else{
                        Toast.makeText(MainActivity.this, "Ban da thua", Toast.LENGTH_SHORT).show();
                        Score -=5;
                    }
                    textViewScore.setText(Score + "");
                    SetEnableCheckBox();
                }

            }

            @Override
            public void onFinish() {

            }
        };

        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxOne.isChecked() || checkBoxTwo.isChecked() || checkBoxThree.isChecked()) {
                    if (Score >= 5) {
                        ibtnPlay.setVisibility(View.INVISIBLE);
                        seekBarOne.setProgress(0);
                        seekBarTwo.setProgress(0);
                        seekBarThree.setProgress(0);
                        checkBoxOne.setEnabled(false);
                        checkBoxTwo.setEnabled(false);
                        checkBoxThree.setEnabled(false);
                        countDownTimer.start();
                    }else Toast.makeText(MainActivity.this, "So diem cua ban da het", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Vui long dat cuoc", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void AnhXa(){
        ibtnPlay = (ImageButton) findViewById(R.id.ibtnPlay) ;
        checkBoxOne = (CheckBox) findViewById(R.id.checkboxOne);
        checkBoxTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        checkBoxThree = (CheckBox) findViewById(R.id.checkboxThree);
        seekBarOne = (SeekBar) findViewById(R.id.seekbarOne);
        seekBarTwo = (SeekBar) findViewById(R.id.seekbarTwo);
        seekBarThree = (SeekBar) findViewById(R.id.seekbarThree);
        textViewScore = (TextView) findViewById(R.id.textViewScore);
    }
    private void CheckBox(){
        checkBoxOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxTwo.setChecked(false);
                    checkBoxThree.setChecked(false);
                }
            }
        });
        checkBoxTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxOne.setChecked(false);
                    checkBoxThree.setChecked(false);
                }
            }
        });
        checkBoxThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxOne.setChecked(false);
                    checkBoxTwo.setChecked(false);
                }
            }
        });
    }

    private void SetEnableCheckBox(){
        checkBoxOne.setEnabled(true);
        checkBoxTwo.setEnabled(true);
        checkBoxThree.setEnabled(true);
        ibtnPlay.setVisibility(View.VISIBLE);
    }
}
