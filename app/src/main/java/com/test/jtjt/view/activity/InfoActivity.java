package com.test.jtjt.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.test.jtjt.R;
import com.test.jtjt.base.BaseActivity;
import com.test.jtjt.view.activity.adapter.InfoAdapter;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends BaseActivity implements InfoAdapter.OnItemClickListener {

    private RecyclerView listRv;
    private FloatingActionButton addFab;
    private Toolbar toolbar;
    private TextView titleTv;
    private InfoAdapter infoAdapter;

    @Override
    protected void initParms(Bundle parms) {

    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_info;
    }

    @Override
    protected void initView(View view) {
        listRv = $(R.id.list);
        addFab = $(R.id.add_fab);
        toolbar = $(R.id.toolbar);
        titleTv = $(R.id.title_tv);
        listRv.setLayoutManager(new LinearLayoutManager(this));
        infoAdapter = new InfoAdapter(this);

        /*
         * 设置toolbar
         * */
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("");
        titleTv.setText(getResources().getString(R.string.title_device));
        setSupportActionBar(toolbar);
    }

    @Override
    protected void doBusiness(Context mContext) {
        listRv.setAdapter(infoAdapter);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            strings.add("设备");
        }
        infoAdapter.updateListView(strings);
    }

    @Override
    protected void widgetClick(View view) {

    }

    @Override
    protected void setListener() {
        addFab.setOnClickListener(this);
        infoAdapter.setOnItemClickListener(this);
    }

    @Override
    public void handleMessage(Message message, int what) {

    }

    @Override
    public void onItemClick(View view, int position) {
        startActivity(new Intent(this, BooksActivity.class));
    }
}
