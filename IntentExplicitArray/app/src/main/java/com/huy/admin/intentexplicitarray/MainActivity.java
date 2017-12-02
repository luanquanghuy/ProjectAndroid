package com.huy.admin.intentexplicitarray;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSendArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendArray = (Button) findViewById(R.id.buttonMain);
        final String[] mang = {"Thai Nguyen", "Ha Noi", "TP Ho Chi Minh", "Da Nang"};
        btnSendArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SencondActivity.class);
                intent.putExtra("arraydata",mang);
                startActivity(intent);
            }
        });
    }
}
