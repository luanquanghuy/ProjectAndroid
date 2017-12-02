package com.huy.admin.calendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCalendar = (TextView) findViewById(R.id.textviewCalendar);
        Calendar calendar = Calendar.getInstance();

        textCalendar.append(calendar.getTime() + "\n");
        textCalendar.append(calendar.get(Calendar.DATE) + "\n");
        textCalendar.append(calendar.get(Calendar.MONTH) + "\n");
        textCalendar.append(calendar.get(Calendar.YEAR) + "\n");

        SimpleDateFormat dinhDangNgay = new SimpleDateFormat("dd/MM/yyyy");

        textCalendar.append(dinhDangNgay.format(calendar.getTime()) + "\n");
        textCalendar.append(calendar.get(Calendar.HOUR) + "\n");
        textCalendar.append(calendar.get(Calendar.HOUR_OF_DAY) + "\n");
        textCalendar.append(calendar.get(Calendar.MINUTE) + "\n");
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("hh:mm a");
        textCalendar.append(dinhDangGio.format(calendar.getTime()) + "\n");
    }
    // Tham Khao tren develope.android.com phan SimpleDateFormat
}
