package com.huy.admin.webservicedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddSinhVienActivity extends AppCompatActivity {

    EditText edtHoTen, edtNamSinh, edtDiaChi;
    Button btnThem, btnHuyThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);

        AnhXa();

        btnHuyThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "";
                if (edtHoTen.getText().toString().trim().isEmpty() || edtNamSinh.getText().toString().trim().isEmpty() || edtDiaChi.getText().toString().trim().isEmpty()){
                    Toast.makeText(AddSinhVienActivity.this, "Bạn chưa nhập đủ", Toast.LENGTH_SHORT).show();
                }else {
                    ThemSinhVien("http://192.168.56.1/androidwebservice/insert.php");
                }
            }
        });
    }

    private void AnhXa() {
        edtDiaChi = (EditText) findViewById(R.id.editTextThemDiaChi);
        edtNamSinh = (EditText) findViewById(R.id.editTextThemNamSinh);
        edtHoTen = (EditText) findViewById(R.id.editTextThemHoTen);
        btnHuyThem = (Button) findViewById(R.id.buttonHuyThem);
        btnThem = (Button) findViewById(R.id.buttonThem);
    }

    private void ThemSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")){
                    Toast.makeText(AddSinhVienActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddSinhVienActivity.this, MainActivity.class));
                }else {
                    Toast.makeText(AddSinhVienActivity.this, "Thêm không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddSinhVienActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
                Log.d("error", error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("hotenSV", edtHoTen.getText().toString().trim());
                params.put("namsinhSV", edtNamSinh.getText().toString().trim());
                params.put("diachiSV", edtDiaChi.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
