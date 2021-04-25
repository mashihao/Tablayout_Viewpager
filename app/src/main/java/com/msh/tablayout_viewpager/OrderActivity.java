package com.msh.tablayout_viewpager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private String[] mTitles = new String[]{"全部", "待付款", "代发货", "已发货", "已完成"};

    private List<Fragment> fragments = new ArrayList<>();

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MSH","onCreate");


        for (int i = 0; i < mTitles.length; i++) {
            fragments.add(BaseOrderFragment.newInstance(mTitles[i]));
        }

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragments));

        int tab = getIntent().getIntExtra("tab", 0);

        viewPager.setCurrentItem(tab);


    }


    public class FragmentAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<Fragment>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

    }


}