package com.huy.admin.webservicedatabase;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 09-Sep-17.
 */


public class SinhVienAdapter extends BaseAdapter {


    private MainActivity context;
    private int layout;
    private List<SinhVien> sinhVienList;

    public SinhVienAdapter(MainActivity context, int layout, List<SinhVien> sinhVienList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtHoTen, txtNamSinh, txtDiaChi;
        ImageView imgDelete, imgEdit;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtHoTen = (TextView) convertView.findViewById(R.id.textviewHoTen);
            holder.txtNamSinh = (TextView) convertView.findViewById(R.id.textviewNamSinh);
            holder.txtDiaChi = (TextView) convertView.findViewById(R.id.textviewDiaChi);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.imageviewDelete);
            holder.imgEdit = (ImageView) convertView.findViewById(R.id.imageviewEdit);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        final SinhVien sinhVien = sinhVienList.get(position);
        holder.txtHoTen.setText(sinhVien.getHoTen());
        holder.txtNamSinh.setText(sinhVien.getNamSinh() + "");
        holder.txtDiaChi.setText(sinhVien.getDiaChi());

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateSinhViewActivity.class);
                intent.putExtra("sinhvien", sinhVien);
                context.startActivity(intent);
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogXoa(sinhVien.getId());
            }
        });

        return convertView;
    }
    private void DialogXoa(final int id){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setMessage("Are you really want to delete?");
        dialog.setTitle("Xác thực xóa");
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.DeleteSinhVien(id);
            }
        });
        dialog.show();
    }

}
