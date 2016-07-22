package com.example.xinghongfei.opensourceset.util;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.example.xinghongfei.opensourceset.bean.InfoBean;
import com.like.LikeButton;

/**
 * Created by xinghongfei on 16/7/22.
 */
public class ShowSnack {
    public static final String NAME = "名称:";
    public static final String ADDRESS = "Github地址:";
    public static final String DES = "详情";
    public static final String INDEX = "推荐";

    static Boolean isOver = false;


    public static void show(final InfoBean infoBean, View view, final LikeButton likeButton) {


        if (isOver == false) {
            isOver=true;
            likeButton.setLiked(true);
            Snackbar.make(view, NAME + infoBean.getName() + "\n"
                            + ADDRESS + infoBean.getAddress() + "\n"
//                +
//                DES+infoBean.getDescribe()+"\n"+
//                INDEX+infoBean.getRecommentIndex()
                    , Snackbar.LENGTH_LONG)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).setCallback(new Snackbar.Callback() {
                @Override
                public void onDismissed(Snackbar snackbar, int event) {
                    super.onDismissed(snackbar, event);
                    likeButton.setLiked(false);
                    isOver = false;
                }

                @Override
                public void onShown(Snackbar snackbar) {
                    super.onShown(snackbar);
                }
            }).show();
        }
    }
}
