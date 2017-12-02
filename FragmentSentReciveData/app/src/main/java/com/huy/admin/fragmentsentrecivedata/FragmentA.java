package com.huy.admin.fragmentsentrecivedata;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by admin on 13-Sep-17.
 */

public class FragmentA extends Fragment {
    EditText edtFragA;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        edtFragA = (EditText) view.findViewById(R.id.editTextA);
        Bundle bundle = getArguments();
        if (bundle!=null){
            edtFragA.setText(bundle.getString("dulieu"));
        }

        return view;
    }
}
