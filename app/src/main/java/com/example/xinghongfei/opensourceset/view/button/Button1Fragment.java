package com.example.xinghongfei.opensourceset.view.button;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.example.xinghongfei.opensourceset.R;
import com.example.xinghongfei.opensourceset.bean.InfoBean;
import com.example.xinghongfei.opensourceset.date.CreateDate;
import com.example.xinghongfei.opensourceset.util.ShowSnack;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by xinghongfei on 16/7/18.
 */
public class Button1Fragment extends Fragment implements View.OnClickListener, OnLikeListener {

   Handler handler=new Handler();

    LikeButton thumbButton;
    @InjectView(R.id.like_button)
    LikeButton likeButton;
    @InjectView(R.id.container)
    CoordinatorLayout container;



    Map<Integer, InfoBean> button1Map;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.button1_layout, null);
        ButterKnife.inject(this, view);
        button1Map = CreateDate.button1(button1Map);


        likeButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.like_button:
                InfoBean infoBean1 = button1Map.get(R.id.like_button);
                ShowSnack.show(infoBean1, container, likeButton);

                break;


        }


    }


    @Override
    public void liked() {

    }

    @Override
    public void unLiked() {

    }
}
