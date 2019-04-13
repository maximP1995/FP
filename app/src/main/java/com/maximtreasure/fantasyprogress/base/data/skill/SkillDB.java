package com.maximtreasure.fantasyprogress.base.data.skill;

import android.content.Context;

import com.maximtreasure.fantasyprogress.base.data.BaseDB;
import com.maximtreasure.fantasyprogress.base.data.interfaces.QueryOnly;

/**
 * Created by Maxim on 19-4-11.
 * 技能总表
 */

public abstract class SkillDB extends BaseDB implements QueryOnly{

    public SkillDB(Context context) {
        super(context);
    }
}
