package com.maximtreasure.fantasyprogress.core;

import android.content.Context;

import com.maximtreasure.fantasyprogress.base.data.user.UserTotalInfoDB;

/**
 * Created by maxim on 19-4-13.
 * 从数据库中获取角色所有的技能，并且维护技能树
 *
 */

public class SkillManager {
    private static SkillManager instance = null;
    private UserTotalInfoDB userTotalInfoDB;
    public static SkillManager getInstance(Context context){
        if (instance == null){
            synchronized (SkillManager.class){
                if (instance == null){
                    instance = new SkillManager(context);
                }
            }
        }
        return instance;
    }
    private SkillManager(Context context){
        userTotalInfoDB = new UserTotalInfoDB(context);
    }
}
