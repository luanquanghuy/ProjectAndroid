package com.huy.admin.webservicedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UpdateSinhViewActivity extends AppCompatActivity {

    EditText edtHoTen, edtNamSinh, edtDiaChi;
    Button btnUpdate, btnHuy;
    ArrayList<SinhVien> sinhVienList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sinh_view);

        AnhXa();
        Intent intent = getIntent();
        final SinhVien sinhVien = (SinhVien) intent.getSerializableExtra("sinhvien");
        edtDiaChi.setText(sinhVien.getDiaChi());
        edtHoTen.setText(sinhVien.getHoTen());
        edtNamSinh.setText(String.valueOf(sinhVien.getNamSinh()));

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtHoTen.getText().toString().trim().isEmpty() || edtNamSinh.getText().toString().trim().isEmpty()|| edtDiaChi.getText().toString().trim().isEmpty()){
                    Toast.makeText(UpdateSinhViewActivity.this, "Vui long nhap du du lieu", Toast.LENGTH_SHORT).show();
                }else {
                    String urlUpdate ="http://192.168.56.1/androidwebservice/update.php";
                    UpdateSinhVien(urlUpdate, String.valueOf(sinhVien.getId()));
                    finish();
                };

            }
        });
    }

    private void UpdateSinhVien(String url, final String id){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")){
                    Toast.makeText(UpdateSinhViewActivity.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateSinhViewActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(UpdateSinhViewActivity.this, "Lỗi sửa", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("ID", id);
                params.put("HoTen", edtHoTen.getText().toString().trim());
                params.put("NamSinh", edtNamSinh.getText().toString().trim());
                params.put("DiaChi", edtDiaChi.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void AnhXa() {
        edtHoTen = (EditText) findViewById(R.id.editTextUpdateHoTen);
        edtNamSinh = (EditText) findViewById(R.id.editTextUpdateNamSinh);
        edtDiaChi = (EditText) findViewById(R.id.editTextUpdateDiaChi);
        btnUpdate = (Button) findViewById(R.id.buttonUpdate);
        btnHuy = (Button) findViewById(R.id.buttonHuyUpdate);
    }
}
