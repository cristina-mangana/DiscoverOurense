package com.example.android.discoverourense;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        LocationCategoryPagerAdapter adapter = new LocationCategoryPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        // Connect the tab layout with the view pager
        tabLayout.setupWithViewPager(viewPager);

        // Set icons to the tabs
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_do_selector);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_see_selector);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_eat_selector);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_sleep_selector);
    }
}
