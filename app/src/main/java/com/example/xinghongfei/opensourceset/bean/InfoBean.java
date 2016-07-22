package com.example.xinghongfei.opensourceset.bean;

/**
 * Created by xinghongfei on 16/7/22.
 */
public class InfoBean {
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
}
