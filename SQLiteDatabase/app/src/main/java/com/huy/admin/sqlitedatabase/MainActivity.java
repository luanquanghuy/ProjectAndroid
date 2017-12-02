package com.huy.admin.sqlitedatabase;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;
    ListView listCongViec;
    ArrayList<CongViec> arrayCongViec;
    CongViecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCongViec = (ListView) findViewById(R.id.listViewCongViec);
        arrayCongViec = new ArrayList<>();
        adapter = new CongViecAdapter(this, R.layout.dong_cong_viec, arrayCongViec);
        listCongViec.setAdapter(adapter);

        // Tạo database Ghichu
        database = new Database(this, "ghichu.sqlite", null, 1);
        // Tạo bảng CongViec
        database.QueryData("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV VARCHAR(200))");
        // Insert Data
//        database.QueryData("INSERT INTO CongViec VALUES(null, 'Viet ung dung ghi chu')");
        // Select Data
        GetDataCongViec();
    }

    private void GetDataCongViec(){
        // Select Data
        Cursor dataCongViec = database.GetData("SELECT * FROM CongViec");
        arrayCongViec.clear();
        while (dataCongViec.moveToNext()){
            String ten = dataCongViec.getString(1);
            int id = dataCongViec.getInt(0);
            arrayCongViec.add(new CongViec(id, ten));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_congviec, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuAdd){
            DialogThem();
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogThem(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.dialog_them_cong_viec);
        final EditText edtTen = (EditText) dialog.findViewById(R.id.edtCongViec);
        Button btnThem = (Button) dialog.findViewById(R.id.buttonThem);
        Button btnHuy = (Button) dialog.findViewById(R.id.buttonHuy);
        dialog.show();
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tencv = edtTen.getText().toString();
                if (tencv.isEmpty()){
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập công việc", Toast.LENGTH_SHORT).show();
                }else{
                    database.QueryData("INSERT INTO CongViec VALUES(null, '" + tencv +"')");
                    Toast.makeText(MainActivity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    GetDataCongViec();
                }
            }
        });
    }

    public void DialogSuaCongViec(String ten, final int id){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.dialog_them_cong_viec);
        final EditText edtTen = (EditText) dialog.findViewById(R.id.edtCongViec);
        Button btnThem = (Button) dialog.findViewById(R.id.buttonThem);
        Button btnHuy = (Button) dialog.findViewById(R.id.buttonHuy);
        edtTen.setText(ten);
        dialog.show();
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tencv = edtTen.getText().toString();
                if (tencv.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập công việc", Toast.LENGTH_SHORT).show();
                } else {
                    database.QueryData("UPDATE CongViec SET TenCV = '" + tencv + "'WHERE Id ='" + id +"'");
                    Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    GetDataCongViec();
                }
            }
        });
    }

    public void DialogXoaCV(final String tencv, final int id){
        final AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Are you want to delete Cong Viec " + tencv + "?");
        dialogXoa.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                database.QueryData("DELETE FROM CongViec WHERE Id = '" + id + "'");
                Toast.makeText(MainActivity.this, "Da xoa" + tencv, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                GetDataCongViec();
            }
        });
        dialogXoa.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogXoa.show();
    }
}
