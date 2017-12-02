package com.huy.admin.myapplication;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rdgThoiGian;
    RadioButton RdSang, RdTrua, RdChieu, RdToi;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgThoiGian = (RadioGroup) findViewById(R.id.radioGroupThoiGian);
        RdSang = (RadioButton) findViewById(R.id.radioButtonSang);
        RdTrua = (RadioButton) findViewById(R.id.radioButtonTrua);
        RdChieu = (RadioButton) findViewById(R.id.radioButtonChieu);
        RdToi = (RadioButton) findViewById(R.id.radioButtonToi);
        btnConfirm = (Button) findViewById(R.id.buttonXacNhan);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RdSang.isChecked())
                    Toast.makeText(MainActivity.this, "You choose Sang", Toast.LENGTH_SHORT).show();
                if(RdTrua.isChecked())
                    Toast.makeText(MainActivity.this, "You choose Trua", Toast.LENGTH_SHORT).show();
                if (RdChieu.isChecked())
                    Toast.makeText(MainActivity.this, "You choose Chieu", Toast.LENGTH_SHORT).show();
                if (RdToi.isChecked())
                    Toast.makeText(MainActivity.this, "You choose Toi", Toast.LENGTH_SHORT).show();
            }
        });

        rdgThoiGian.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.radioButtonSang:
                        Toast.makeText(MainActivity.this, "Sang", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonTrua:
                        Toast.makeText(MainActivity.this, "Trua", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonChieu:
                        Toast.makeText(MainActivity.this, "Chieu", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Toi", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
