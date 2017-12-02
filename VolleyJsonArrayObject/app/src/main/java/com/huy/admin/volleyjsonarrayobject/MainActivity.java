package com.huy.admin.volleyjsonarrayobject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add compile 'com.android.volley:volley:1.0.0' vao build.gradle(module)
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://khoapham.vn/KhoaPhamTraining/json/tien/demo4.json";
//        JSONObject jsonOjectRequest = new JSONObject("tuong tu");
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
            for (int i= 0; i< response.length(); i++){
                try {
                    JSONObject object = response.getJSONObject(i);
                    String khoahoc = object.getString("khoahoc");
                    String hocphi = object.getString("hocphi");
                    Toast.makeText(MainActivity.this, khoahoc + "-" + hocphi, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
