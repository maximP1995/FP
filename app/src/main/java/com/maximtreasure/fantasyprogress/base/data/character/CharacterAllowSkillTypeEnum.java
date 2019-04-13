package com.maximtreasure.fantasyprogress.base.data.character;

/**
 * Created by maxim on 19-4-13.
 */

public enum CharacterAllowSkillTypeEnum {
    NORMAL_1(1,new int[]{1});
    private final int charType;
    private final int[] skillTypeArgs;
    CharacterAllowSkillTypeEnum(int charType,int[] skillTypeArgs) {
        this.charType = charType;
        this.skillTypeArgs = skillTypeArgs;
    }

    public int[] getAllowTypes(int charType) {
        switch (charType){
            case 1:
                return NORMAL_1.skillTypeArgs;
                default:
                    return null;
        }
    }
}
