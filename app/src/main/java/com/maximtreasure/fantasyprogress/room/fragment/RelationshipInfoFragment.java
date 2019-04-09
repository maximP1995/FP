package com.maximtreasure.fantasyprogress.room.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by zhengmj on 19-4-9.
 */

public class RelationshipInfoFragment extends Fragment {
    public static RelationshipInfoFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RelationshipInfoFragment fragment = new RelationshipInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
