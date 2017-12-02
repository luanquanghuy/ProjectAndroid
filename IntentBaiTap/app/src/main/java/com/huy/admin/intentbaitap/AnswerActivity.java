package com.huy.admin.intentbaitap;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Collections;

public class AnswerActivity extends Activity {

    TableLayout myTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        myTable = (TableLayout) findViewById(R.id.tableLayoutHinh);

        int sodong = 7;
        int socot = 3;

        Collections.shuffle(MainActivity.arrayName);
        for (int i = 1; i <= sodong; i++) {
            TableRow tableRow = new TableRow(this);
            for (int j = 1; j <= socot; j++){
                final ImageView imageView = new ImageView(this);
                /// Converts 100 dip into its equivalent px

                Resources r = getResources();
                int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, r.getDisplayMetrics());
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(px, px);
                imageView.setLayoutParams(layoutParams);
                final int vitri = 3*(i-1)+j-1;
                int idHinh = getResources().getIdentifier(MainActivity.arrayName.get(vitri), "drawable", getPackageName());
                imageView.setImageResource(idHinh);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = getIntent();
                        intent.putExtra("traloi", MainActivity.arrayName.get(vitri));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
                tableRow.addView(imageView);
            }
            myTable.addView(tableRow);
        }
    }
}
