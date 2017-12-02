package com.huy.admin.listviewoptions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewNoiDung;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        adapter = new ArrayAdapter(this, R.layout.si)
    }

    private void AnhXa() {
        listViewNoiDung = (ListView) findViewById(R.id.listviewNoiDung);
        arrayList = new ArrayList<>();
        arrayList.add("Luan Quang Huy");

    }
}
