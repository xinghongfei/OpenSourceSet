package com.example.xinghongfei.opensourceset.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xinghongfei on 16/7/22.
 */
public class InfoBean implements Parcelable {
    public String name;
    public String address;
    public String describe;
    public String recommentIndex;

    public InfoBean(String name, String address, String describe, String recommentIndex) {
        this.name = name;
        this.address = address;
        this.describe = describe;
        this.recommentIndex = recommentIndex;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getRecommentIndex() {
        return recommentIndex;
    }

    public void setRecommentIndex(String recommentIndex) {
        this.recommentIndex = recommentIndex;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeString(this.describe);
        dest.writeString(this.recommentIndex);
    }

    protected InfoBean(Parcel in) {
        this.name = in.readString();
        this.address = in.readString();
        this.describe = in.readString();
        this.recommentIndex = in.readString();
    }

    public static final Parcelable.Creator<InfoBean> CREATOR = new Parcelable.Creator<InfoBean>() {
        @Override
        public InfoBean createFromParcel(Parcel source) {
            return new InfoBean(source);
        }

        @Override
        public InfoBean[] newArray(int size) {
            return new InfoBean[size];
        }
    };
}
