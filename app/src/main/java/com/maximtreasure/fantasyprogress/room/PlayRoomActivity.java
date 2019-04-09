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
import com.maximtreasure.fantasyprogress.room.fragment.CharacterInfoFragment;
import com.maximtreasure.fantasyprogress.room.fragment.RelationshipInfoFragment;
import com.maximtreasure.fantasyprogress.room.fragment.SkillInfoFragment;

/**
 * Created by zhengmj on 19-4-2.
 */

public class PlayRoomActivity extends BaseActivity{
    private ViewPager viewPager;
    private PagerAdapter adapter;
    private BaseDataEntity entity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null && bundle.containsKey(ConstKey.KEY_BASE_DATA)){
            entity = bundle.getParcelable(ConstKey.KEY_BASE_DATA);
        }
        setContentView(R.layout.activity_play_room);
        viewPager = (ViewPager) findViewById(R.id.vp_play);
        adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
    public BaseDataEntity getBaseDataEntity(){
        return entity;
    }
    private class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return position == 0 ?CharacterInfoFragment.newInstance():position == 1? SkillInfoFragment.newInstance(): RelationshipInfoFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
