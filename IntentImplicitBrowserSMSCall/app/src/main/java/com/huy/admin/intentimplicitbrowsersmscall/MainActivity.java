package com.huy.admin.intentimplicitbrowsersmscall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView imgBrowser, imgSms, imgCall;
    int REQUEST_CODE_CALL = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgBrowser  = (ImageView) findViewById(R.id.imageViewBrowser);
        imgSms = (ImageView) findViewById(R.id.imageViewSms);
        imgCall = (ImageView) findViewById(R.id.imageViewCall);

        imgBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://myhuymmo.tech"));
                startActivity(intent);
            }
        });

        imgSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body","Hello");
                intent.setData(Uri.parse("sms:01683380607"));
                startActivity(intent);
            }
        });

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_CALL);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // cap quyen cho goi
        if (requestCode == REQUEST_CODE_CALL && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:01683380607"));
            startActivity(intent);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
