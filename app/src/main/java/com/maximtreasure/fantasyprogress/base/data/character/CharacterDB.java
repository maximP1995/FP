package com.maximtreasure.fantasyprogress.base.data.character;

import android.content.Context;

import com.maximtreasure.fantasyprogress.base.data.BaseDB;
import com.maximtreasure.fantasyprogress.base.data.interfaces.QueryOnly;

/**
 * Created by maxim on 19-4-13.
 * 角色数值的基础类
 */

public abstract class CharacterDB extends BaseDB implements QueryOnly{
    public CharacterDB(Context context) {
        super(context);
    }
}
