package com.huy.admin.oobjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SinhVien sinhVien = new SinhVien("Luan Quang Thin", "Thinh Dan", 2000);


        Toast.makeText(this,sinhVien.TenSV + "   " + sinhVien.DiaChi + "    " + sinhVien.GetNamSinh(), Toast.LENGTH_SHORT).show();
    }
}
