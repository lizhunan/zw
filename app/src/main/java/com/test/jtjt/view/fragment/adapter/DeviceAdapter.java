package com.test.jtjt.view.fragment.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.TextView;

import com.test.jtjt.R;
import com.test.jtjt.base.BaseListAdapter;
import com.test.jtjt.base.BaseViewHolder;

public class DeviceAdapter extends BaseListAdapter<String> {

    private OnItemClickListener onItemClickListener;

    public DeviceAdapter(Context mContext) {
        super(mContext);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getLayoutId() {
        return R.layout.device_item;
    }

    @Override
    public void onBindItemHolder(BaseViewHolder holder, final int position) {
        TextView t1 = holder.getView(R.id.t1);
        TextView t2 = holder.getView(R.id.t2);
        ConstraintLayout item = holder.getView(R.id.item);
        t1.setText("设备" + position);
        t2.setText("小标题" + position);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view, position);
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
