package com.huy.admin.listviewadvancetraicay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 28-Aug-17.
 */

public class TraiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public List<TraiCay> getTraiCayList() {
        return traiCayList;
    }

    public void setTraiCayList(List<TraiCay> traiCayList) {
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // ViewHolder de toi uu View
    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtMoTa;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();

            //Anh xa
            holder.txtTen = (TextView) convertView.findViewById(R.id.textviewTen);
            holder.txtMoTa = (TextView) convertView.findViewById(R.id.textviewMoTa);
            holder.imgHinh = (ImageView) convertView.findViewById(R.id.imageviewHinh);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }


//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        convertView = inflater.inflate(layout,null);
//
//        //Anh xa
//        TextView txtTen = (TextView) convertView.findViewById(R.id.textviewTen);
//        TextView txtMoTa = (TextView) convertView.findViewById(R.id.textviewMoTa);
//        ImageView imgHinh = (ImageView) convertView.findViewById(R.id.imageviewHinh);

        //Gan gia tri
        TraiCay traiCay = traiCayList.get(position);

        holder.txtTen.setText(traiCay.getTen());
        holder.txtMoTa.setText(traiCay.getMoTa());
        holder.imgHinh.setImageResource(traiCay.getHinh());
        return convertView;
    }
}
