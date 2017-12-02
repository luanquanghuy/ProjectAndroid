package com.huy.admin.alertdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listLapTrinh;
    TextView tvLogin;
    ArrayList<String> arrayContent;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLapTrinh = (ListView) findViewById(R.id.listViewLapTrinh);
        tvLogin = (TextView) findViewById(R.id.textViewLogin);
        arrayContent = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayContent);
        addArrayList();
        listLapTrinh.setAdapter(adapter);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLogin();
            }
        });
//        listLapTrinh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Confirm(arrayContent.get(position), position);
//                arrayContent.get(position).toString();
//                return false;
//            }
//        });
//        listLapTrinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                dialogLogin();
//            }
//
//        });
    }

    private void dialogLogin() {
        final Dialog dialog = new Dialog(this);
        setContentView(R.layout.dialog_login);
        EditText editTextUserName = (EditText) dialog.findViewById(R.id.editTextUserName);
        EditText editTextPassword = (EditText) dialog.findViewById(R.id.editTextPassword);
//        Button btnLogin  = (Button) dialog.findViewById(R.id.buttonLogin);
        Button btnCancel = (Button) dialog.findViewById(R.id.buttonCancel);
//        final String userName = editTextUserName.getText().toString().trim();
//        final String password = editTextPassword.getText().toString().trim();
//
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (userName.equals("quanghuy") && password.equals("123")){
//                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        dialog.show();
    }

    private void addArrayList() {
        arrayContent.add("Android");
        arrayContent.add("iOS");
        arrayContent.add("PHP");
        arrayContent.add("Java");
        arrayContent.add("Unity 3D");
        arrayContent.add("ASP.Net");
        arrayContent.add("Cplusplus");
    }

//    private void Confirm(String s, final int position){
//        final AlertDialog.Builder alertDialogConfirm = new AlertDialog.Builder(this);
//        alertDialogConfirm.setMessage("Are you sure you want to permanently delete " + s + "?");
//        alertDialogConfirm.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                arrayContent.remove(position);
//                adapter.notifyDataSetChanged();
//            }
//        });
//        alertDialogConfirm.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        alertDialogConfirm.show();
//    }
}
