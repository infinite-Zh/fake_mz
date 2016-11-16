package com.infinite.fake_mz.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.infinite.fake_mz.fragment.ValuableInfoFragment;

import java.util.List;

/**
 * Created by inf on 2016/11/8.
 */

public class PagerFragmentAdaoter extends FragmentStatePagerAdapter{
    private List<Fragment> mFrags;
    public PagerFragmentAdaoter(FragmentManager fm, List<Fragment> frags) {
        super(fm);
        mFrags=frags;
    }

    @Override
    public Fragment getItem(int position) {
        return mFrags.get(position);
    }

    @Override
    public int getCount() {
        return mFrags.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ((ValuableInfoFragment)mFrags.get(position)).getTitle();
    }
}
