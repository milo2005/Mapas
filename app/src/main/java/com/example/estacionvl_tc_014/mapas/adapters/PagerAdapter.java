package com.example.estacionvl_tc_014.mapas.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.estacionvl_tc_014.mapas.fragments.TitleFragment;

import java.util.List;

/**
 * Created by EstacionVL-TC-014 on 12/02/16.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    List<TitleFragment> data;

    public PagerAdapter(FragmentManager fm, List<TitleFragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getTitle();
    }
}
