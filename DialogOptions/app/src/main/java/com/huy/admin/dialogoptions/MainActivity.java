 package com.huy.admin.dialogoptions;

 import android.app.Dialog;
 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;
 import android.view.Window;
 import android.widget.Button;
 import android.widget.EditText;
 import android.widget.TextView;
 import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    TextView textDangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDangnhap = (TextView) findViewById(R.id.textviewDangNhap);
        textDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogMessenger();
            }
        });
    }

     private void DialogMessenger() {
         final Dialog dialog = new Dialog(this);
         dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
         dialog.setContentView(R.layout.dialog_dangnhap);
         dialog.setCanceledOnTouchOutside(false);
         final EditText edtUsername   = (EditText) dialog.findViewById(R.id.edittextUsername);
         final EditText edtPassword   = (EditText) dialog.findViewById(R.id.edittextPassword);
         Button btnDangNhap     = (Button) dialog.findViewById(R.id.buttonDangNhap);
         Button btnHuy          = (Button) dialog.findViewById(R.id.buttonHuy);

         btnDangNhap.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String user = edtUsername.getText().toString().trim();
                 String pass = edtPassword.getText().toString().trim();
                 if (edtUsername.getText().toString().trim().equals("quanghuy") && pass.equals("123")){
                     Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                 }else Toast.makeText(MainActivity.this, "Loi dang nhap", Toast.LENGTH_SHORT).show();
             }
         });
         btnHuy.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 dialog.dismiss();
             }
         });

         dialog.show();
     }
 }
