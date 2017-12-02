package com.huy.admin.createmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menuSearch:
                Toast.makeText(this, "You choose Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSettings:
                Toast.makeText(this, "You choose Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuFacebook:
                Toast.makeText(this, "You choose Share Facebook", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuTwitter:
                Toast.makeText(this, "You choose Share Twitter", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuExit:
                Toast.makeText(this, "You choose Exit", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
