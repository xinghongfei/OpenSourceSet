package com.example.xinghongfei.opensourceset.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.example.xinghongfei.opensourceset.bean.InfoBean;
import com.example.xinghongfei.opensourceset.main.DetailActivity;
import com.like.LikeButton;

/**
 * Created by xinghongfei on 16/7/22.
 */
public class ShowSnack {
    public static final String NAME = "项目名称:";
    public static final String ADDRESS = "Github地址:";
    public static final String DES = "详情";
    public static final String INDEX = "推荐";

    static Boolean isOver = false;


    public static void show(final InfoBean infoBean, final View view, final LikeButton likeButton) {


        if (isOver == false) {
            isOver=true;
            likeButton.setLiked(true);
            Snackbar.make(view, NAME + infoBean.getName()
                    , Snackbar.LENGTH_LONG)
                    .setAction("More", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context=view.getContext();
                    Intent intent =new Intent(context, DetailActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putParcelable(DetailActivity.INFO,infoBean);
                    intent.putExtra(DetailActivity.INFO,bundle);
                    DetailActivity.show(context,intent);

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
