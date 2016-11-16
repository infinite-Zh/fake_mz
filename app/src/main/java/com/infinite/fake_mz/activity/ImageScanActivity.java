package com.infinite.fake_mz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.infinite.fake_mz.R;
import com.infinite.fake_mz.views.ToolBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by inf on 2016/11/15.
 */

public class ImageScanActivity extends AppCompatActivity{

    @BindView(R.id.img)
    public ImageView mImg;

    @BindView(R.id.toolBar)
    public ToolBar mToolBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_image_scan);
        setSupportActionBar(mToolBar);
        ButterKnife.bind(this);
        processIntent();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mToolBar.setTitle("MeiZhi");
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.finishAfterTransition(ImageScanActivity.this);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        processIntent();
    }

    private void processIntent(){
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        if (TextUtils.isEmpty(url)){
            finish();
        }else {
            Glide.with(this).load(url).centerCrop().crossFade().into(mImg);
        }
    }
}
