package com.huy.admin.intenexpicitdoituong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtContent = (TextView) findViewById(R.id.textViewNoiDung);
        Intent intent = getIntent();
        if (intent != null){
            MonHoc mon1 = (MonHoc) intent.getSerializableExtra("monhoc");
            txtContent.setText(mon1.getTen() + " - " + mon1.getSoTinChi());
        }


    }
}
