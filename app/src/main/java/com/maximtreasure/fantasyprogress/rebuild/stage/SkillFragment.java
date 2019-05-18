package com.maximtreasure.fantasyprogress.rebuild.stage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maximtreasure.fantasyprogress.R;

public class SkillFragment extends Fragment {
    public static SkillFragment newInstance(){
        SkillFragment fragment = new SkillFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill,container,false);
        return view;
    }
}
