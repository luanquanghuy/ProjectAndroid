package com.huy.admin.fragmentsentrecivedata;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtContent;
    Button btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtContent = (TextView) findViewById(R.id.textViewContent);
        btnEdit = (Button) findViewById(R.id.buttonEdit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentA fragmentA = new FragmentA();
                Bundle bundle = new Bundle();
                bundle.putString("dulieu", txtContent.getText().toString());
                fragmentA.setArguments(bundle);
                fragmentTransaction.add(R.id.fragment2, fragmentA);
                fragmentTransaction.commit();
            }
        });
    }
}
