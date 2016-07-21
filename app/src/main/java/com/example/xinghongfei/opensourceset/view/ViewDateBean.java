package com.example.xinghongfei.opensourceset.view;

import java.util.LinkedList;

/**
 * Created by xinghongfei on 16/7/21.
 */
public class ViewDateBean {

    private String title ;
    private  int   count;
    private String classname;
    private String describe;

    public ViewDateBean(String describe, String classname, int count, String title) {
        this.describe = describe;
        this.classname = classname;
        this.count = count;
        this.title = title;
    }

    public ViewDateBean(String title, int count, String classname) {
        this.title = title;
        this.count = count;
        this.classname = classname;
        describe="";
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public String getClassname() {
        return classname;
    }

    public String getDescribe() {
        return describe;
    }
}
