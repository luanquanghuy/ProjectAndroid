package com.huy.admin.readjson1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonObject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_object);

        new ReadJSON().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json");
    }
    private class ReadJSON extends AsyncTask<String, Void, String> {
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
                String monhoc;
                monhoc = object.getString("monhoc");
                String noihoc = object.getString("noihoc");
                String website = object.getString("website");
                String fanpage = object.getString("fanpage");
                String logo = object.getString("logo");
                Toast.makeText(JsonObject.this, monhoc + "\n" + noihoc + "\n" + website + "\n" + fanpage + "\n" + logo, Toast.LENGTH_LONG).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
