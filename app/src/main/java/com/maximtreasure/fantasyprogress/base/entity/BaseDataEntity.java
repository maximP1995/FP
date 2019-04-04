package com.maximtreasure.fantasyprogress.base.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhengmj on 19-4-2.
 */

public class BaseDataEntity implements Parcelable{
    public int charType;//人物种类
    public int charTypeLevel;//人物种类级别
    public long life;//人物寿命

    public BaseDataEntity(){}

    protected BaseDataEntity(Parcel in) {
        life = in.readLong();
    }

    public static final Creator<BaseDataEntity> CREATOR = new Creator<BaseDataEntity>() {
        @Override
        public BaseDataEntity createFromParcel(Parcel in) {
            return new BaseDataEntity(in);
        }

        @Override
        public BaseDataEntity[] newArray(int size) {
            return new BaseDataEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(charType);
        parcel.writeInt(charTypeLevel);
        parcel.writeLong(life);
    }
}
