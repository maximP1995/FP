package com.maximtreasure.fantasyprogress.room.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maximtreasure.fantasyprogress.R;

/**
 * Created by zhengmj on 19-4-2.
 */

public class MainPerformanceFragment extends Fragment{
    public static MainPerformanceFragment newInstance(){
        MainPerformanceFragment fragment = new MainPerformanceFragment();
        return fragment;
    }
    public void updateFromActivity(Bundle bundle){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_main,container,false);
        return view;
    }
}
