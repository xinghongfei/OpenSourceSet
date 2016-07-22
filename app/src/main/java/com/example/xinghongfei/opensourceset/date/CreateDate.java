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
            InfoBean infoBean1=new InfoBean("Like Button","www.baidu.com","good button","5");
            button1Map.put(R.id.like_button,infoBean1);
        }





        return button1Map;
    };


}
