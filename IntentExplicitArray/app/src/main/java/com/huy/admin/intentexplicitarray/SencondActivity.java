package com.huy.admin.intentexplicitarray;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SencondActivity extends AppCompatActivity {

    TextView txtCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sencond);

        txtCity = (TextView) findViewById(R.id.textViewDuLieu);
        Intent intent = getIntent();
        if (intent != null){
            String[] mang = intent.getStringArrayExtra("arraydata");
            txtCity.setText(mang[1]);
        }

    }
}
