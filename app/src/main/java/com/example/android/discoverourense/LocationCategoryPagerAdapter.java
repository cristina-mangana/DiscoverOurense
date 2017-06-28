package com.example.android.discoverourense;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Cristina on 20/06/2017.
 * Provides the appropriate {@link Fragment} for a view pager.
 */

public class LocationCategoryPagerAdapter extends FragmentPagerAdapter {

    /**
     * Create a new {@link LocationCategoryPagerAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public LocationCategoryPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        return LocationCategoryFragment.getInstance(position);
    }

    /**
     * Get the title for each tab
     */
    @Override
    public CharSequence getPageTitle(int position) {
        // return null to display only the icon
        return null;
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }
}
