package com.huy.admin.readjson1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Json2 extends AppCompatActivity {

    ListView lvDanhSach;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json2);

        lvDanhSach = (ListView) findViewById(R.id.listviewMonHoc);
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lvDanhSach.setAdapter(adapter);

        new ReadJSON2().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo4.json");
    }
    private class ReadJSON2 extends AsyncTask<String, Void, String>{
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
                JSONArray array = new JSONArray(s);
                for (int i= 0; i<array.length();i++){
                    JSONObject object = array.getJSONObject(i);
                    String khoahoc = object.getString("khoahoc");
                    String hocphi = object.getString("hocphi");
                    arrayList.add(khoahoc + " - " + hocphi);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
