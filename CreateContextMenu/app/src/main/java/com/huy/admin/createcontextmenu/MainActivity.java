package com.huy.admin.createcontextmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCollor;
    ConstraintLayout manHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCollor = (Button) findViewById(R.id.buttonChooseColor);
        manHinh = (ConstraintLayout) findViewById(R.id.manhinh);

        registerForContextMenu(btnCollor);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.menu_context, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuBlue:
                manHinh.setBackgroundColor(Color.BLUE);
                break;
            case R.id.menuGreen:
                manHinh.setBackgroundColor(Color.GREEN);
                break;
            case R.id.menuRed:
                manHinh.setBackgroundColor(Color.RED);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
