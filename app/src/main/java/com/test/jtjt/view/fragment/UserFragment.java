package com.test.jtjt.view.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.view.View;

import com.test.jtjt.R;
import com.test.jtjt.base.BaseFragment;


public class UserFragment extends BaseFragment {

    private static UserFragment INSTANCE;

    public UserFragment() {

    }

    public static UserFragment newInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserFragment();
        }
        return INSTANCE;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_blank;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void doBusiness(Context mContext, Activity activity) {

    }

    @Override
    protected void widgetClick(View view) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void handleMessage(Message message, int what) {

    }

}
