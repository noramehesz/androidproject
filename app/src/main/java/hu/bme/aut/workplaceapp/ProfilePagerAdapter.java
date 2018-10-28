package hu.bme.aut.workplaceapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by mobsoft on 2017. 09. 27..
 */

class ProfilePagerAdapter extends FragmentPagerAdapter {
    private static final int NUM_PAGES = 2;

    public ProfilePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MainProfileFragment();
            case 1:
                return new DetailsProfileFragment();
            default:
                return new MainProfileFragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}