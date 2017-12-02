package com.huy.admin.gridviewcoban;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    GridView gvName;
    String[] name = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "X", "Y", "W", "Z"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvName = (GridView) findViewById(R.id.girdviewName);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, name);

        gvName.setAdapter(adapter);
        gvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, position + "." + name[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
