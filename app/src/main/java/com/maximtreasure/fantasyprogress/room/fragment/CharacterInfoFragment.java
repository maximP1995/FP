package com.maximtreasure.fantasyprogress.room.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maximtreasure.fantasyprogress.R;
import com.maximtreasure.fantasyprogress.base.entity.BaseDataEntity;
import com.maximtreasure.fantasyprogress.room.PlayRoomActivity;

/**
 * Created by zhengmj on 19-4-2.
 */

public class CharacterInfoFragment extends Fragment{
    private TextView tv_game_life;
    private BaseDataEntity entity;
    public static CharacterInfoFragment newInstance(){
        CharacterInfoFragment fragment = new CharacterInfoFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_main,container,false);
        bindViewWithId(view);
        return view;
    }
    private void bindViewWithId(View home){
        tv_game_life = home.findViewById(R.id.tv_game_life);
    }
    private void setDataToUI(){
        tv_game_life.setText(String.valueOf(entity.life));
    }
    private void getDataFromActivity(){
        try{
            entity = ((PlayRoomActivity)getActivity()).getBaseDataEntity();
            if (entity!=null)setDataToUI();
        }catch (ClassCastException e){

        }
    }
}
