package com.huy.admin.intentdataresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText edtName;
    Button btnConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edtName = (EditText) findViewById(R.id.editTextName);
        btnConfirm = (Button) findViewById(R.id.buttonConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("newname",edtName.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
