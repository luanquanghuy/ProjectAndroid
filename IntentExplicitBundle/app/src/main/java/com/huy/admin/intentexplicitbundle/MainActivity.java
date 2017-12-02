package com.huy.admin.intentexplicitbundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = (Button) findViewById(R.id.buttonSend);
        final String[] array = {"Ha Noi", "Thai Nguyen", "Ho Chi Minh"};
        final SinhVien sinhVien = new SinhVien("Luan Quang Huy", 21);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("string", "Quang Huy");
                bundle.putInt("int", 2017);
                bundle.putStringArray("array", array);
                bundle.putSerializable("sinhvien", sinhVien);

                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });
    }
}
