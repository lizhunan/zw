package com.test.jtjt.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    protected final String TAG = this.getClass().getSimpleName();
    private View mContextView = null;
    /**
     * handler
     */
    protected Handler handler = new Handler(this);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContextView = inflater.inflate(bindLayout(), container, false);
        initView(mContextView);
        setListener();
        doBusiness(getContext(), getActivity());
        return mContextView;
    }

    @Override
    public void onClick(View view) {
        if (fastClick()) {
            widgetClick(view);
        }
    }


    /**
     * 绑定布局
     *
     * @return 布局ID
     */
    protected abstract int bindLayout();

    /**
     * 初始化控件
     *
     * @param view view
     */
    protected abstract void initView(final View view);

    /**
     * 业务操作
     *
     * @param mContext context
     */
    protected abstract void doBusiness(Context mContext, Activity activity);

    /**
     * View点击
     *
     * @param view view
     */
    protected abstract void widgetClick(View view);

    /**
     * 设置监听
     */
    protected abstract void setListener();

    public abstract void handleMessage(Message message,int what);
    /**
     * 绑定控件
     *
     * @param view  当前view
     * @param resId 控件ID
     * @param <T>   控件类型
     * @return 控件类型
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T $(View view, int resId) {
        return (T) view.findViewById(resId);
    }

    /**
     * 防止过快点击
     *
     * @return true 正常点击，false 过快点击
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }


    public static class Handler extends BaseHandler{

        private BaseFragment fragment;

        Handler(BaseFragment fragment){
            super(fragment);
            this.fragment = fragment;
        }

        @Override
        public void handleMessage(Message msg, int what) {
            fragment.handleMessage(msg,what);
        }
    }
}
