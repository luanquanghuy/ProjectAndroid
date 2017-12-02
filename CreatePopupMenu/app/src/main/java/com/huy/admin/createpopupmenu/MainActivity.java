package com.huy.admin.createpopupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Button btnMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = (Button) findViewById(R.id.buttonMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu();
            }
        });
    }

    private void ShowMenu(){
        final PopupMenu popupMenu = new PopupMenu(this, btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuAdd:
                        btnMenu.setText(item.getTitle());
                        break;
                    case R.id.menuEdit:
                        btnMenu.setText(item.getTitle());
                        break;
                    case R.id.menuDelete:
                        btnMenu.setText(item.getTitle());
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}
