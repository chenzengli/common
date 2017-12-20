package com.mc.common.mvp.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.mvp.mine.view.PasswordManagerAdapter;

/**
 * Created by momologo on 2017/12/18 14:39.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public class OperateBean implements MultiItemEntity, Parcelable {

    private int operateId;

    private String operateName;

    public int getOperateId() {
        return operateId;
    }

    public void setOperateId(int operateId) {
        this.operateId = operateId;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    @Override
    public int getItemType() {
        return PasswordManagerAdapter.TYPE_OPERATE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.operateId);
        dest.writeString(this.operateName);
    }

    public OperateBean() {
    }

    protected OperateBean(Parcel in) {
        this.operateId = in.readInt();
        this.operateName = in.readString();
    }

    public static final Parcelable.Creator<OperateBean> CREATOR = new Parcelable.Creator<OperateBean>() {
        @Override
        public OperateBean createFromParcel(Parcel source) {
            return new OperateBean(source);
        }

        @Override
        public OperateBean[] newArray(int size) {
            return new OperateBean[size];
        }
    };
}
