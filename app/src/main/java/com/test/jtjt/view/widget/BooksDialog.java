package com.test.jtjt.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.TextView;

import com.test.jtjt.R;

public class BooksDialog extends Dialog {

    public BooksDialog(Context context) {
        super(context);
    }

    public void showDialog(){
        setContentView(R.layout.station_dialog);
        NestedScrollView nestedScrollView = findViewById(R.id.nv);
        TextView t = findViewById(R.id.name_tv);
        TextView t3 = findViewById(R.id.time_tv);
        TextView t1 = findViewById(R.id.avg_water_tv);
        TextView t2 = findViewById(R.id.max_water_tv);
        TextView t4 = findViewById(R.id.ss_water_tv);
        TextView t5 = findViewById(R.id.channel_name);
        nestedScrollView.setVisibility(View.VISIBLE);
        show();
    }

}
