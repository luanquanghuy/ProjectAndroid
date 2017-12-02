package com.huy.admin.timepickerdialog;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textViewChonTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewChonTime = (TextView) findViewById(R.id.textviewChon);
        textViewChonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChonGio();
            }
        });
    }

    private void ChonGio(){
        final Calendar calendar = Calendar.getInstance();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set( calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), hourOfDay , minute);
                textViewChonTime.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }
}
