package com.maximtreasure.fantasyprogress.room;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.maximtreasure.fantasyprogress.R;
import com.maximtreasure.fantasyprogress.base.BaseActivity;
import com.maximtreasure.fantasyprogress.base.ConstKey;
import com.maximtreasure.fantasyprogress.base.entity.BaseDataEntity;
import com.maximtreasure.fantasyprogress.room.fragment.MainPerformanceFragment;

/**
 * Created by zhengmj on 19-4-2.
 */

public class PlayRoomActivity extends BaseActivity{
    private ViewPager viewPager;
    private PagerAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_room);
        viewPager = (ViewPager) findViewById(R.id.vp_play);
        adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
    private void updateDataToFragment(Bundle bundle){
        try{
            MainPerformanceFragment fragment = (MainPerformanceFragment) adapter.instantiateItem(viewPager,0);
            fragment.updateFromActivity(bundle);
        }catch (ClassCastException e){

        }
    }
    private BaseDataEntity loadDataFromDB(){
        BaseDataEntity entity = null;
        return entity;
    }
    private class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return MainPerformanceFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 1;
        }
    }
}
