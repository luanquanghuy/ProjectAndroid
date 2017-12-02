package com.huy.admin.webservicedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String url;
    ListView listSinhVien;
    ArrayList<SinhVien> arraySinhVien;
    SinhVienAdapter adapter;
    String urlDeltete = "http://192.168.56.1/androidwebservice/delete.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        url = "http://192.168.56.1/androidwebservice/getdata.php ";
        GetData(url);
    }

    private void AnhXa() {
        listSinhVien = (ListView) findViewById(R.id.listviewSinhVien);
        arraySinhVien = new ArrayList<SinhVien>();
        adapter = new SinhVienAdapter(this, R.layout.dong_sinh_vien, arraySinhVien);
        listSinhVien.setAdapter(adapter);
    }

    private void GetData(String url){
        arraySinhVien.clear();
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);

                        arraySinhVien.add(i, new SinhVien(
                        object.getInt("ID"),
                        object.getString("HoTen"),
                        object.getInt("NamSinh"),
                        object.getString("DiaChi")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuThemSinhVien){
            startActivity(new Intent(MainActivity.this, AddSinhVienActivity.class));
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_sinh_vien, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void DeleteSinhVien(final int id){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringrequest = new StringRequest(Request.Method.POST, urlDeltete, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")){
                    Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    GetData(url);
                }else Toast.makeText(MainActivity.this, "Lỗi Xóa", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "@string/urldelete", Toast.LENGTH_SHORT).show();
                Log.d("error", error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("IDsv", String.valueOf(id));
                return params;
            }
        };
        requestQueue.add(stringrequest);
    }

}
