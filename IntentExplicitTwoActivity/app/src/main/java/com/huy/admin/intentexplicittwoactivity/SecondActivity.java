package com.huy.admin.intentexplicittwoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textViewData = (TextView) findViewById(R.id.textViewSecond);
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        textViewData.setText(data);
    }
}
