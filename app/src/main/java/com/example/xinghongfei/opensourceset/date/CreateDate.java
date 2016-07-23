package com.example.xinghongfei.opensourceset.date;

import android.util.ArrayMap;

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
            button1Map=new ArrayMap<>();

//          Likebutton
            InfoBean infoBean1=new InfoBean("Like Button","https://github.com/jd-alexander/LikeButton","2种状态的动画按钮","4");
            button1Map.put(R.id.like_button,infoBean1);

//            SubmitButton
            InfoBean infoBean2=new InfoBean("SubmitButton","https://github.com/SparkYuan/SubmitButton","动画酷炫的提交按钮","4");
            button1Map.put(R.id.submit_button,infoBean2);

//            easyloadingbtn
            InfoBean infoBean3=new InfoBean("easyloadingbtn","https://github.com/DevinShine/easyloadingbtn","根据dribbble上的一个gif图片实现的Material Design加载按钮,加载进度有BUG","4.5");
            button1Map.put(R.id.easyloadingbtn,infoBean3);

//            SmoothCheckBox
            InfoBean infoBean4=new InfoBean("SmoothCheckBox","https://github.com/andyxialm/SmoothCheckBox","仿Twitter喜欢动画的按钮","4.5");
            button1Map.put(R.id.smooth_button,infoBean4);

//            android_process_button
            InfoBean infoBean5=new InfoBean("android_process_button","https://github.com/dmytrodanylyk/android-process-button","能显示加载状态的button控件。","4.6");
            button1Map.put(R.id.android_process_button,infoBean5);

        }

        return button1Map;
    };

    public static Map<Integer,InfoBean> button2(Map<Integer,InfoBean> button2Map){

        if (button2Map==null){
            button2Map=new ArrayMap<>();
            InfoBean infoBean1=new InfoBean("FloatingToolbar",
                    " https://github.com/rubensousa/FloatingToolbar","一个从FloatingActionButton演变的toolbar","4.3");
            button2Map.put(R.id.floatingToolbar_button,infoBean1);

        }

        return button2Map;

    }

}
