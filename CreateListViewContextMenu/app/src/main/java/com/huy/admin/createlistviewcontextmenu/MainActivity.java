package com.huy.admin.createlistviewcontextmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayListlistMenu;
    int vitri;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayListlistMenu);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuEdit:
                break;
            case R.id.menuRename:
                arrayListlistMenu.set(vitri,"Quang Huy");
                adapter.notifyDataSetChanged();
                break;
            case R.id.menuDelete:
                arrayListlistMenu.remove(vitri);
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void AnhXa() {
        listView = (ListView) findViewById(R.id.listviewNote);
        arrayListlistMenu = new ArrayList<>();
        arrayListlistMenu.add("Luan Quang Huy");
        arrayListlistMenu.add("Lap trinh Java");
    }




}
