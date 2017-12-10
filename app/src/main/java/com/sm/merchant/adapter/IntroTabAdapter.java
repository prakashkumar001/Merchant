package com.sm.merchant.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sm.merchant.fragment.Splash1Fragment;
import com.sm.merchant.fragment.Splash2Fragment;


public class IntroTabAdapter extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public IntroTabAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                Splash1Fragment tab1 = new Splash1Fragment();
                return tab1;
            case 1:
                Splash2Fragment tab2 = new Splash2Fragment();
                return tab2;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Reviews";
            case 1:
                return "Info";
            default:
                return "Map";
        }
    }
}
