package com.infinite.fake_mz.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.widget.TextView;

import com.infinite.fake_mz.R;

/**
 * Created by inf on 2016/11/15.
 */

public class ToolBar extends Toolbar{

    public Toolbar mToolBar;
    public TextView mTextTitle;
    public ToolBar(Context context) {
        super(context);
        initViews();
    }

    public ToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public ToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    private void initViews(){
        mTextTitle= (TextView) findViewById(R.id.toolbarr_title);
    }

    @Override
    public void setTitle(@StringRes int resId) {
        initViews();
        mTextTitle.setText(resId);
    }

    @Override
    public void setTitle(CharSequence title) {
        initViews();
        super.setTitle("");
        mTextTitle.setText(title);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        initViews();
    }
}
