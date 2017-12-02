package com.huy.admin.fragment1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView txtNoiDung;
    Button btnMainA, btnMainB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNoiDung = (TextView) findViewById(R.id.textViewNoiDung);
        btnMainA = (Button) findViewById(R.id.buttonMainA);
        btnMainB = (Button) findViewById(R.id.buttonMainB);

        btnMainA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentA fragmentA = (FragmentA) getFragmentManager().findFragmentById(R.id.fragmentA);
                fragmentA.SetTextViewA();
            }
        });
    }
}
