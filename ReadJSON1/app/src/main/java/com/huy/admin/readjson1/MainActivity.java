package com.huy.admin.readjson1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnJsonObject, btnJsonArray, btnJson1, btnJson2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJsonObject = (Button) findViewById(R.id.buttonJsonObject);
        btnJsonArray = (Button) findViewById(R.id.buttonJsonArray);
        btnJson1 = (Button) findViewById(R.id.buttonJson1);
        btnJson2 = (Button) findViewById(R.id.buttonJson2);

        btnJsonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JsonObject.class);
                startActivity(intent);
            }
        });
        btnJsonArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JsonArray.class);
                startActivity(intent);
            }
        });
        btnJson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Json1.class);
                startActivity(intent);
            }
        });
        btnJson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Json2.class);
                startActivity(intent);
            }
        });
    }


}
