package com.test.jtjt.view.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.test.jtjt.R;
import com.test.jtjt.base.BaseActivity;
import com.test.jtjt.view.fragment.DeviceFragment;
import com.test.jtjt.view.fragment.UserFragment;

public class MainActivity extends BaseActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigation;
    private Toolbar toolbar;
    private TextView titleTv;

    private DeviceFragment deviceFragment;
    private UserFragment userFragment;

    @Override
    protected void initParms(Bundle parms) {

    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(View view) {
        navigation = $(R.id.navigation);
        toolbar = $(R.id.toolbar);
        titleTv = $(R.id.title_tv);

        deviceFragment = DeviceFragment.newInstance();
        userFragment = UserFragment.newInstance();

        /*
         * 设置toolbar
         * */
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("");
        titleTv.setText(getResources().getString(R.string.title_device));
        setSupportActionBar(toolbar);

        switchFragment(deviceFragment, R.id.content).commit();
    }

    @Override
    protected void doBusiness(Context mContext) {

    }

    @Override
    protected void widgetClick(View view) {

    }

    @Override
    protected void setListener() {
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void handleMessage(Message message, int what) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                titleTv.setText(getResources().getString(R.string.title_device));
                switchFragment(deviceFragment, R.id.content).commit();
                return true;
            case R.id.navigation_user:
                titleTv.setText(getResources().getString(R.string.title_user));
                switchFragment(userFragment, R.id.content).commit();
                return true;
        }
        return false;
    }
}