package com.maximtreasure.fantasyprogress.base.data.skill;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;

import com.maximtreasure.fantasyprogress.base.data.skill.entity.SkillRelationEntity;

/**
 * Created by maxim on 19-4-13.
 * 技能与技能的关系
 */

public class SkillRelationDB extends SkillDB {
    private final static String TABLE_NAME = "skill_table";
    private final static String SKILL_ID = "skill_id";//技能ID
    private final static String SKILL_NAME = "skill_name";//技能名
    private final static String SKILL_TYPE = "skill_type";//技能类型（用来分类技能）
    private final static String SKILL_PERMISSION_ID = "skill_permission_id";//解锁技能前置技能ID
    private final static String SKILL_PERMISSION_LEVEL = "skill_permission_level";//解锁技能前置技能等级
    private final static String CREATE_TABLE = "create table "+TABLE_NAME+
            " ("+SKILL_ID+" long primary key autoincrement , "+
            SKILL_NAME+" varchar(24) not null ,"+
            SKILL_TYPE+" integer not null ,"+
            SKILL_PERMISSION_ID+" long not null ,"+
            SKILL_PERMISSION_LEVEL+" integer not null )";


    public SkillRelationDB(Context context) {
        super(context);
        createTable(CREATE_TABLE);
        setTableName(TABLE_NAME);
    }
    public SkillRelationEntity queryBySkillId(long id){
        setSelection(SKILL_ID);
        setSelectionArgs(new String[]{String.valueOf(id)});
        return query();
    }
    @Override
    public SkillRelationEntity query() {
        SkillRelationEntity entity = null;
        Cursor cursor = sqlQuery();
        if (cursor.moveToNext()){
            entity = new SkillRelationEntity();
            entity.skillId = cursor.getLong(cursor.getColumnIndex(SKILL_ID));
            entity.skillName = cursor.getString(cursor.getColumnIndex(SKILL_NAME));
            entity.skillType = cursor.getInt(cursor.getColumnIndex(SKILL_TYPE));
            entity.permissionId = cursor.getLong(cursor.getColumnIndex(SKILL_PERMISSION_ID));
            entity.permissionLevel = cursor.getInt(cursor.getColumnIndex(SKILL_PERMISSION_LEVEL));
        }
        return entity;
    }
}
