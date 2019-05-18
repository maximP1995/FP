package com.maximtreasure.fantasyprogress.rebuild;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.maximtreasure.fantasyprogress.R;
import com.maximtreasure.fantasyprogress.rebuild.stage.SkillFragment;
import com.maximtreasure.fantasyprogress.rebuild.stage.ViewFragment;

public class HomeActivity2 extends AppCompatActivity {
    private ViewPager home_viewpager;
    private ViewPagerAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        home_viewpager = (ViewPager) findViewById(R.id.home_viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        home_viewpager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentStatePagerAdapter{

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return position == 0?ViewFragment.newInstance() :SkillFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
