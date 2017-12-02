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

public class FragmentB extends Fragment {
    TextView txtB;
    EditText edtB;
    Button btnB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        txtB = (TextView) view.findViewById(R.id.textviewB);
        edtB = (EditText) view.findViewById(R.id.edittextB);
        btnB = (Button) view.findViewById(R.id.buttonB);


        return view;
    }
}
