package com.huy.admin.docbaorss;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTinTuc;
    ArrayAdapter adapter;
    ArrayList<String> array, link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTinTuc = (ListView) findViewById(R.id.listviewTinTuc);
        array = new ArrayList<>();
        link = new ArrayList<>();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, array);
        lvTinTuc.setAdapter(adapter);
        lvTinTuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ReadrssActivity.class);
                intent.putExtra("diachisohoa", link.get(position));
                startActivity(intent);
            }
        });

        new ReadRss().execute("http://vnexpress.net/rss/so-hoa.rss");
    }
    private class ReadRss extends AsyncTask<String, Void, String>{
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

            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
            String tieuDe = "" ;
            for (int i = 0; i < nodeList.getLength(); i++){
                Element element = (Element) nodeList.item(i);
                tieuDe = parser.getValue(element, "title");
                array.add(tieuDe);
                link.add(parser.getValue(element, "link"));
            }
            adapter.notifyDataSetChanged();
        }
    }
}
