package com.huy.admin.sharepreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnConfirm;
    EditText edtUsername, edtPassword;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        sharedPreferences = getSharedPreferences("info", MODE_PRIVATE);
        edtUsername.setText(sharedPreferences.getString("taikhoan", ""));
        edtPassword.setText(sharedPreferences.getString("matkhau", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = edtUsername.getText().toString().trim();
                String matkhau = edtPassword.getText().toString().trim();
                if (taikhoan.equals("quanghuy") && matkhau.equals("1234")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    if (cbRemember.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan",taikhoan);
                        editor.putString("matkhau", matkhau);
                        editor.putBoolean("checked", true);
                        editor.commit();

                        }else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                }else Toast.makeText(MainActivity.this, "Bạn nhập sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AnhXa() {
        btnConfirm = (Button) findViewById(R.id.buttonConfirm);
        edtUsername = (EditText) findViewById(R.id.editTextUsername);
        edtPassword = (EditText) findViewById(R.id.editTextPassword);
        cbRemember = (CheckBox) findViewById(R.id.checkBoxRemember);
    }
}
