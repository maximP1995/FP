package com.maximtreasure.fantasyprogress.base.data.skill.entity;

/**
 * Created by zhengmj on 19-4-13.
 */

public class SkillRelationEntity {
    public long skillId;
    public String skillName;
    public int skillType;
    public long permissionId;//-1则不需要前置
    public int permissionLevel;
    public long nextId;//下一级的技能
}
