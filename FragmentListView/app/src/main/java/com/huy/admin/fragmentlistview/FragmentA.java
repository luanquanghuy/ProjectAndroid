package com.huy.admin.fragmentlistview;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by admin on 17-Sep-17.
 */

public class FragmentA extends ListFragment {
    String[] listCity = {"Ha Noi", "Thai Nguyen", "Ho Chi Minh", "Hai Phong"};
    ArrayAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listCity);
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), listCity[position], Toast.LENGTH_SHORT).show();
    }
}
