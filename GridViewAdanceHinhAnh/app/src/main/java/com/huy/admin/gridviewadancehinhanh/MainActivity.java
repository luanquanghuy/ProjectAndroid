package com.huy.admin.gridviewadancehinhanh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvHinhAnh;
    ArrayList<HinhAnh> arrayHinhAnh;
    HinhAnhAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        adapter = new HinhAnhAdapter(this, R.layout.dong_hinh_anh, arrayHinhAnh);

        gvHinhAnh.setAdapter(adapter);

        gvHinhAnh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayHinhAnh.get(position).getTen()+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void AnhXa(){
        gvHinhAnh = (GridView) findViewById(R.id.gridviewHinhAnh);
        arrayHinhAnh = new ArrayList<>();
        arrayHinhAnh.add(new HinhAnh("Hinh so 1", R.drawable.android1));
        arrayHinhAnh.add(new HinhAnh("Hinh so 2", R.drawable.android2));
        arrayHinhAnh.add(new HinhAnh("Hinh so 3", R.drawable.android3));
        arrayHinhAnh.add(new HinhAnh("Hinh so 4", R.drawable.android4));
        arrayHinhAnh.add(new HinhAnh("Hinh so 5", R.drawable.android5));
        arrayHinhAnh.add(new HinhAnh("Hinh so 6", R.drawable.android6));
        arrayHinhAnh.add(new HinhAnh("Hinh so 7", R.drawable.android7));
        arrayHinhAnh.add(new HinhAnh("Hinh so 8", R.drawable.android8));
        arrayHinhAnh.add(new HinhAnh("Hinh so 9", R.drawable.android9));

    }
}
