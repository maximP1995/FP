package com.maximtreasure.fantasyprogress.base.data;

import android.content.Context;
import android.database.Cursor;

import com.maximtreasure.fantasyprogress.base.entity.SkillGrowEntity;

/**
 * Created by zhengmj on 19-4-11.
 */

public class SkillGrowDB extends BaseDB {
    private final static String TABLE_NAME = "skill_grow_table";
    private final static String SKILL_ID = "skill_id";
    private final static String SKILL_EXPERIENCE_COEFFICIENT = "skill_experience_coefficient";//基础成长系数
    private final static String SKILL_TOTAL_EXPERIENCE_COEFFICIENT = "skill_total_experience_coefficient";//总额成长系数
    private final static String CREATE_TABLE = "create table "+TABLE_NAME+"if not exists ("+SKILL_ID+" integer primary key,"+ SKILL_EXPERIENCE_COEFFICIENT +" long not null, "+ SKILL_TOTAL_EXPERIENCE_COEFFICIENT +" long not null)";
    public SkillGrowDB(Context context) {
        super(context);
        createTable(CREATE_TABLE);
    }
    public String getTableName(){
        return TABLE_NAME;
    }
    public SkillGrowEntity getValueByID(int id){
        SkillGrowEntity entity = null;
        Cursor cursor = getDB().query(getTableName(),null,SKILL_ID+" = ?",new String[]{String.valueOf(id)},null,null,null);
        if (cursor.moveToNext()){
            entity = new SkillGrowEntity();
            entity.skill_experience_coefficient= cursor.getLong(cursor.getColumnIndex(SKILL_EXPERIENCE_COEFFICIENT));
            entity.skill_total_experience_coefficient = cursor.getLong(cursor.getColumnIndex(SKILL_TOTAL_EXPERIENCE_COEFFICIENT));
        }
        return entity;
    }

}
