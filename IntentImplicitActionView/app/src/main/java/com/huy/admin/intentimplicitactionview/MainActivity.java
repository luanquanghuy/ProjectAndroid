package com.huy.admin.intentimplicitactionview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewBrowser;
    ImageView imgBrowser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewBrowser = (TextView) findViewById(R.id.textViewBrowser);
        imgBrowser = (ImageView) findViewById(R.id.imageViewBrowser);
        textViewBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://myhuymmo.tech"));
                startActivity(intent);
            }
        });
        imgBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://myhuymmo.tech"));
                startActivity(intent);
            }
        });
    }
}
