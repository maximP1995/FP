package com.maximtreasure.fantasyprogress.base.data;

import android.content.Context;

/**
 * Created by Maxim on 19-4-11.
 * 技能总表
 */

public final class SkillDB extends BaseDB{
    private final static String TABLE_NAME = "skill_table";
    private final static String SKILL_ID = "skill_id";//技能ID
    private final static String SKILL_NAME = "skill_name";//技能名
    private final static String SKILL_TYPE = "skill_type";//技能类型（用来分类技能）
    private final static String SKILL_BASE_EXPERIENCE ="skill_base_experience";//每完成一次技能获得的基础经验
    private final static String SKILL_TOTAL_EXPERIENCE = "skill_base_total_experience";//技能升级需要的经验总额
    private final static String SKILL_EXPERIENCE_INCREMENT = "skill_experience_increment";//技能基础经验成长值
    private final static String SKILL_TOTAL_EXPERIENCE_INCREMENT = "skill_total_experience_increment";//经验总额成长值
    private final static String CREATE_TABLE = "create table "+TABLE_NAME+"if not exists ("+SKILL_ID+" integer primary key autoincrement ," +
            ""+SKILL_NAME+" varchar(20) not null,"+ SKILL_BASE_EXPERIENCE +" long not null,"+SKILL_TOTAL_EXPERIENCE+" long not null, "+SKILL_EXPERIENCE_INCREMENT+" long not null," +
            ""+SKILL_TOTAL_EXPERIENCE_INCREMENT+" long not null,"+SKILL_TYPE+" integer not null)";
    public SkillDB(Context context) {
        super(context);
        createTable(CREATE_TABLE);
    }

}
