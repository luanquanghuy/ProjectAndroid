package com.huy.admin.readjson1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Json1 extends AppCompatActivity {

    Button btnVi, btnEn;
    TextView txtLang;
    String NoiDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json1);

        btnVi = (Button) findViewById(R.id.buttonVi);
        btnEn = (Button) findViewById(R.id.buttonEn);
        txtLang = (TextView) findViewById(R.id.textViewLang);

        new ReadJSON1().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");

        btnVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONLang("vn");
            }
        });
        btnEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONLang("en");
            }
        });

    }
    private class ReadJSON1 extends AsyncTask<String, Void, String>{
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
            NoiDung =s;
        }
    }
    private void JSONLang(String lang){

        try {
            JSONObject object = new JSONObject(NoiDung);
            JSONObject objectLang = object.getJSONObject("language");
            JSONObject objectVn = objectLang.getJSONObject(lang);
            String ten = objectVn.getString("name");
            String diachi = objectVn.getString("address");
            String khoahoc1 = objectVn.getString("course1");
            String khoahoc2 = objectVn.getString("course2");
            String khoahoc3 = objectVn.getString("course3");

            txtLang.setText(ten + "\n" + diachi + "\n" + khoahoc1 + "\n" + khoahoc2 + "\n"+khoahoc3);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
