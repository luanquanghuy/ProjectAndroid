package com.huy.admin.listviewcoban;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvLanguage;
    ArrayList<String> arrayMonHoc;
    EditText edtTextMonHoc;
    Button btnAdd, btnUpdate;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLanguage = (ListView) findViewById(R.id.listviewLanguage);
        edtTextMonHoc = (EditText) findViewById(R.id.editTextMonHoc);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnUpdate = (Button) findViewById(R.id.buttonUpdate);
        arrayMonHoc = new ArrayList<>();
        arrayMonHoc.add("Java");
        arrayMonHoc.add("PHP");
        arrayMonHoc.add("iOS");
        arrayMonHoc.add("Android");
        arrayMonHoc.add("Unity");

        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayMonHoc);
        lvLanguage.setAdapter(adapter);

        lvLanguage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtTextMonHoc.setText(arrayMonHoc.get(position));
                vitri = position;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayMonHoc.add(edtTextMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Da them mon hoc", Toast.LENGTH_SHORT).show();
                edtTextMonHoc.setText("");
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayMonHoc.set(vitri, edtTextMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Da cap nhat", Toast.LENGTH_SHORT).show();
                edtTextMonHoc.setText("");
            }
        });

        lvLanguage.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayMonHoc.remove(position);
                Toast.makeText(MainActivity.this, "Da xoa xong", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}
