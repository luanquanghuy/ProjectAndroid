package com.huy.admin.readjson1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonArray extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_array);
        new ReadJSONArray().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo2.json");
    }
    private class ReadJSONArray extends AsyncTask<String, Void, String >{
        StringBuilder content = new StringBuilder();
        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    content.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);
                JSONArray arrayDanhSach = object.getJSONArray("danhsach");
                String DanhSachKhoaHoc = "";
                for (int i = 0; i < arrayDanhSach.length(); i++){
                    JSONObject objectDS = arrayDanhSach.getJSONObject(i);
                    String khoahoc = objectDS.getString("khoahoc");
                    DanhSachKhoaHoc += khoahoc + "\n";
                }
                Toast.makeText(JsonArray.this, DanhSachKhoaHoc, Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
