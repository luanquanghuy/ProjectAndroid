package com.huy.admin.listviewadvancetraicay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewTraiCay;
    ArrayList<TraiCay> arrayTraiCay;
    TraiCayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        adapter = new TraiCayAdapter(MainActivity.this, R.layout.dong_trai_cay, arrayTraiCay);
        listViewTraiCay.setAdapter(adapter);
    }

    private void Anhxa(){
        listViewTraiCay = (ListView) findViewById(R.id.listviewTraiCay);
        arrayTraiCay = new ArrayList<>();
        arrayTraiCay.add(new TraiCay("Android","Lap trinh tren he dieu hanh mobile", R.drawable.android));
        arrayTraiCay.add(new TraiCay("Background1","back ground 1 la mau xanh", R.drawable.background1));
        arrayTraiCay.add(new TraiCay("Cat", "Day la 1 con meo", R.drawable.cat));
        arrayTraiCay.add(new TraiCay("Dog", "Day la 1 con cho", R.drawable.dog));
        arrayTraiCay.add(new TraiCay("Chicken", "Day la 1 con ga", R.drawable.chicken));
        arrayTraiCay.add(new TraiCay("Background2", "back ground 2 la mau xam", R.drawable.background2));

    }
}
