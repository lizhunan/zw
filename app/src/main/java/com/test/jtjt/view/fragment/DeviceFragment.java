package com.test.jtjt.view.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.jtjt.R;
import com.test.jtjt.base.BaseFragment;
import com.test.jtjt.view.activity.InfoActivity;
import com.test.jtjt.view.fragment.adapter.DeviceAdapter;

import java.util.ArrayList;
import java.util.List;


public class DeviceFragment extends BaseFragment implements DeviceAdapter.OnItemClickListener {

    private RecyclerView listRv;
    private FloatingActionButton addFab;
    private DeviceAdapter deviceAdapter;

    private static DeviceFragment INSTANCE;

    public DeviceFragment() {

    }

    public static DeviceFragment newInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DeviceFragment();
        }
        return INSTANCE;
    }


    @Override
    protected int bindLayout() {
        return R.layout.fragment_device;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView(View view) {
        listRv = $(view, R.id.list);
        addFab = $(view, R.id.add_fab);
        listRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        deviceAdapter = new DeviceAdapter(getContext());
    }

    @Override
    protected void doBusiness(Context mContext, Activity activity) {
        listRv.setAdapter(deviceAdapter);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            strings.add("设备");
        }
        deviceAdapter.updateListView(strings);
    }

    @Override
    protected void widgetClick(View view) {

    }

    @Override
    protected void setListener() {
        addFab.setOnClickListener(this);
        deviceAdapter.setOnItemClickListener(this);
    }

    @Override
    public void handleMessage(Message message, int what) {

    }

    @Override
    public void onItemClick(View view, int position) {
        startActivity(new Intent(getActivity(), InfoActivity.class));
    }
}
