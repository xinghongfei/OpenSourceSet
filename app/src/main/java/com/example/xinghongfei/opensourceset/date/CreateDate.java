package com.example.xinghongfei.opensourceset.date;

import com.example.xinghongfei.opensourceset.R;
import com.example.xinghongfei.opensourceset.bean.InfoBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xinghongfei on 16/7/22.
 */
public class CreateDate {

    public static Map<Integer,InfoBean> button1(Map<Integer,InfoBean> button1Map){

        if (button1Map==null){
            button1Map=new HashMap<Integer,InfoBean>();

//          Likebutton
            InfoBean infoBean1=new InfoBean("Like Button","https://github.com/jd-alexander/LikeButton","2种状态的动画按钮","4");
            button1Map.put(R.id.like_button,infoBean1);

//            SubmitButton
            InfoBean infoBean2=new InfoBean("SubmitButton","https://github.com/SparkYuan/SubmitButton","动画酷炫的提交按钮","4");
            button1Map.put(R.id.like_button,infoBean2);







        }





        return button1Map;
    };


}
