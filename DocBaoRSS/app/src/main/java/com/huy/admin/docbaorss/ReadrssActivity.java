package com.huy.admin.docbaorss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ReadrssActivity extends AppCompatActivity {

    WebView webSoHoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readrss);

        webSoHoa = (WebView) findViewById(R.id.webviewSoHoa);
        Intent intent = getIntent();
        String link = intent.getStringExtra("diachisohoa");
        webSoHoa.loadUrl(link);
        webSoHoa.setWebViewClient(new WebViewClient());
    }
}
