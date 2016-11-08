package com.infinite.fake_mz.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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

    private ValuableInfoFragment mWelFareFrg;
    private PagerFragmentAdaoter mAdapter;
    private List<Fragment> mFrags=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mWelFareFrg=ValuableInfoFragment.newInstance(Global.Type.WELfare,20);
        mFrags.add(mWelFareFrg);
        mAdapter=new PagerFragmentAdaoter(getSupportFragmentManager(),mFrags);
        mViewPager.setAdapter(mAdapter);

    }
}
