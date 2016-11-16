package com.infinite.fake_mz.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.infinite.fake_mz.Global;
import com.infinite.fake_mz.R;
import com.infinite.fake_mz.adapter.PagerFragmentAdaoter;
import com.infinite.fake_mz.fragment.ValuableInfoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolBar)
    public Toolbar mToolBar;

    @BindView(R.id.tabLayout)
    public TabLayout mTabLayout;

    @BindView(R.id.viewPager)
    public ViewPager mViewPager;

    private ValuableInfoFragment mWelFareFrg,mAndroidFrg,mIosFrg,mVideoFrg;
    private PagerFragmentAdaoter mAdapter;
    private List<Fragment> mFrags=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(mToolBar);

        mWelFareFrg=ValuableInfoFragment.newInstance(Global.Type.WELfare,20);
        mFrags.add(mWelFareFrg);
        mAndroidFrg=ValuableInfoFragment.newInstance(Global.Type.ANDROID,20);
        mFrags.add(mAndroidFrg);
        mIosFrg=ValuableInfoFragment.newInstance(Global.Type.IOS,20);
        mFrags.add(mIosFrg);
        mVideoFrg=ValuableInfoFragment.newInstance(Global.Type.VIDEO,20);
        mFrags.add(mVideoFrg);
        mAdapter=new PagerFragmentAdaoter(getSupportFragmentManager(),mFrags);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.addTab(mTabLayout.newTab().setText("gggg"));
        mTabLayout.addTab(mTabLayout.newTab().setText("gggg"));
        mTabLayout.addTab(mTabLayout.newTab().setText("gggg"));
        mTabLayout.addTab(mTabLayout.newTab().setText("gggg"));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        mTabLayout.getTabAt(0).setText(Global.Type.WELfare);
        mTabLayout.getTabAt(1).setText(Global.Type.ANDROID);
        mTabLayout.getTabAt(2).setText(Global.Type.IOS);
        mTabLayout.getTabAt(3).setText(Global.Type.VIDEO);
        mTabLayout.setTabTextColors(Color.BLACK,Color.WHITE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mToolBar.setTitleTextColor(Color.WHITE);
        mToolBar.setTitle("Gank.Io");

    }
}
