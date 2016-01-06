package com.example.emrebabayigit.pickoapp.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.emrebabayigit.pickoapp.R;
import com.example.emrebabayigit.pickoapp.fragments.HomeFragment;
import com.example.emrebabayigit.pickoapp.fragments.MeFragment;
import com.example.emrebabayigit.pickoapp.fragments.NewPickoFragment;
import com.example.emrebabayigit.pickoapp.fragments.SearchFragment;
import com.example.emrebabayigit.pickoapp.fragments.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    /**
     * Adding custom view to tab
     */
    private void setupTabIcons() {

        TextView tabHome = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabHome.setText("Home");
        tabHome.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_home_black_24dp, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabHome);

        TextView tabSearch = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabSearch.setText("Search");
        tabSearch.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_search_black_24dp, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabSearch);


        TextView tabNewPicko = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabNewPicko.setText("Picko");
        tabNewPicko.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_photo_camera_black_24dp, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabNewPicko);

        TextView tabMe = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabMe.setText("Me");
        tabMe.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.me, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabMe);

        TextView tabSettings = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabSettings.setText("Settings");
        tabSettings.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_settings_black_24dp, 0, 0);
        tabLayout.getTabAt(4).setCustomView(tabSettings);


    }


    public void setupViewPager(ViewPager upViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new SearchFragment(), "Search");
        adapter.addFragment(new NewPickoFragment(), "NewPicko");
        adapter.addFragment(new MeFragment(), "Me");
        adapter.addFragment(new SettingsFragment(), "Settings");

        viewPager.setAdapter(adapter);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
