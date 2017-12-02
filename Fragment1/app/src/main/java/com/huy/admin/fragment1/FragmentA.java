package com.huy.admin.fragment1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by admin on 13-Sep-17.
 */

public class FragmentA extends Fragment {

    TextView txtA;
    Button btnA;
    EditText edtA;
    TextView txtMain;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        txtA = (TextView) view.findViewById(R.id.textviewA);
        edtA = (EditText) view.findViewById(R.id.edittextA);
        btnA = (Button) view.findViewById(R.id.buttonA);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    public void SetTextViewA(){
        txtA.setText("A");
    }
}
