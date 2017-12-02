package com.huy.admin.intentbaitap;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> arrayName;
    ImageView imgHoi, imgTraLoi;
    int REQUEST_CODE_ANSWER =1234, total;
    String tenHinhHoi;
    TextView txtDiem;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgHoi = (ImageView) findViewById(R.id.imageViewHoi);
        imgTraLoi = (ImageView) findViewById(R.id.imageViewTraLoi);
        String[] mangTen = getResources().getStringArray(R.array.list_name);
        arrayName = new ArrayList<>(Arrays.asList(mangTen));
        txtDiem = (TextView) findViewById(R.id.textViewDiem);
        sharedPreferences = getSharedPreferences("diem", MODE_PRIVATE);
        total = sharedPreferences.getInt("total", 100);
        txtDiem.setText(total + "");

        //Tron Mang arrayName
        Collections.shuffle(arrayName);
        tenHinhHoi = arrayName.get(10);
        int idHinh = getResources().getIdentifier(tenHinhHoi, "drawable", getPackageName());
        imgHoi.setImageResource(idHinh);
            imgTraLoi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (total >= 5){
                        startActivityForResult(new Intent(MainActivity.this, AnswerActivity.class),REQUEST_CODE_ANSWER);
                    }else {
                        Toast.makeText(MainActivity.this, "Ban da het diem", Toast.LENGTH_SHORT).show();
                    }

                }
            });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ANSWER && resultCode == RESULT_OK && data != null){
            String hinhNhan = data.getStringExtra("traloi");
            int idHinhNhan = getResources().getIdentifier(hinhNhan, "drawable", getPackageName());
            imgTraLoi.setImageResource(idHinhNhan);
            if (hinhNhan.equals(tenHinhHoi)){
                Toast.makeText(this, "Ban Chon Dung", Toast.LENGTH_SHORT).show();
                CountDownTimer countDownTimer = new CountDownTimer(1600, 800) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        //Tron Mang arrayName
                        Collections.shuffle(arrayName);
                        tenHinhHoi = arrayName.get(10);
                        int idHinh = getResources().getIdentifier(tenHinhHoi, "drawable", getPackageName());
                        imgHoi.setImageResource(idHinh);
                    }
                }.start();
                total += 10;
                saveDiem();
                txtDiem.setText(total + "");
            }else {
                Toast.makeText(this, "Ban Chon Sai", Toast.LENGTH_SHORT).show();
                total -= 5;
                saveDiem();
                txtDiem.setText(total + "");
            }

        }
        if (requestCode == REQUEST_CODE_ANSWER && resultCode == RESULT_CANCELED ){
            Toast.makeText(this, "Ban chu chon hinh", Toast.LENGTH_SHORT).show();
            total -= 15;
            saveDiem();
            txtDiem.setText(total + "");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuReload){
            //Tron Mang arrayName
            Collections.shuffle(arrayName);
            tenHinhHoi = arrayName.get(10);
            int idHinh = getResources().getIdentifier(tenHinhHoi, "drawable", getPackageName());
            imgHoi.setImageResource(idHinh);
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveDiem(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("total", total);
        editor.commit();
    }
}
