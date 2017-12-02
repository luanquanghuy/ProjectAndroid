package com.huy.admin.intentdataresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnEdit;
    TextView txtNoiDung;
    int REQUEST_CODE_EDIT = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEdit = (Button) findViewById(R.id.buttonEdit);
        txtNoiDung = (TextView) findViewById(R.id.textViewNoiDung);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                startActivityForResult(intent, REQUEST_CODE_EDIT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK && data != null){
            txtNoiDung.setText(data.getStringExtra("newname"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
