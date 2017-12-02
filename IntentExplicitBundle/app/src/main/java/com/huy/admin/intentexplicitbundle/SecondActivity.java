package com.huy.admin.intentexplicitbundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtNoiDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtNoiDung = (TextView) findViewById(R.id.textViewNoiDung);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        if (bundle != null){
            String string = bundle.getString("string");
            int nam = bundle.getInt("int", 1234);
            String[] array = bundle.getStringArray("array");
            SinhVien sinhVien = (SinhVien) bundle.getSerializable("sinhvien");

            txtNoiDung.setText(string + "\n" + nam + "\n" + array[1] + "\n" + sinhVien.getTen() + "-" + sinhVien.getTuoi());
        }
    }
}
