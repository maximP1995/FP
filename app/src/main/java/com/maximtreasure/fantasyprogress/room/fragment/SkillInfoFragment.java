package com.maximtreasure.fantasyprogress.room.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by zhengmj on 19-4-9.
 */

public class SkillInfoFragment extends Fragment {
    public static SkillInfoFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SkillInfoFragment fragment = new SkillInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
