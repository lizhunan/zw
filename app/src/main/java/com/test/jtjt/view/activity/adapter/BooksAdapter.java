package com.test.jtjt.view.activity.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.View;

import com.test.jtjt.R;
import com.test.jtjt.base.BaseListAdapter;
import com.test.jtjt.base.BaseViewHolder;

public class BooksAdapter extends BaseListAdapter<String> {

    private OnItemClickListener onItemClickListener;

    public BooksAdapter(Context mContext) {
        super(mContext);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getLayoutId() {
        return R.layout.books_item;
    }

    @Override
    public void onBindItemHolder(BaseViewHolder holder, final int position) {
        ConstraintLayout item = holder.getView(R.id.item);
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
