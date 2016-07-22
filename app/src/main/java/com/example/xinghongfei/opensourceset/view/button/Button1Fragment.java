package com.example.xinghongfei.opensourceset.view.button;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xinghongfei.mylibrary.ProgressGenerator;
import com.example.xinghongfei.mylibrary.iml.ActionProcessButton;
import com.example.xinghongfei.opensourceset.R;
import com.example.xinghongfei.opensourceset.bean.InfoBean;
import com.example.xinghongfei.opensourceset.date.CreateDate;
import com.example.xinghongfei.opensourceset.util.ShowSnack;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by xinghongfei on 16/7/18.
 */
public class Button1Fragment extends Fragment implements View.OnClickListener, OnLikeListener, ProgressGenerator.OnCompleteListener {


    Map<Integer, InfoBean> button1Map;


    @InjectView(R.id.like_button)
    LikeButton likeButton;
    @InjectView(R.id.android_process_button_s)
    ActionProcessButton androidProcessButtonS;
    @InjectView(R.id.container)
    CoordinatorLayout container;
    @InjectView(R.id.android_process_button_s2)
    ActionProcessButton androidProcessButtonS2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.button1_layout, null);
        ButterKnife.inject(this, view);
        button1Map = CreateDate.button1(button1Map);


        likeButton.setOnClickListener(this);


        loading();

        return view;
    }

    private void loading() {


        androidProcessButtonS.setMode(ActionProcessButton.Mode.PROGRESS);
        final ProgressGenerator progressGenerator = new ProgressGenerator(this);
        androidProcessButtonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator.start(androidProcessButtonS);
                androidProcessButtonS.setEnabled(false);

            }
        });
        androidProcessButtonS2.setMode(ActionProcessButton.Mode.ENDLESS);
        final ProgressGenerator progressGenerator2 = new ProgressGenerator(this);
        androidProcessButtonS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator2.start(androidProcessButtonS2);
                androidProcessButtonS.setEnabled(false);

            }
        });

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


    @Override
    public void onComplete() {
//        androidProcessButtonS.setEnabled(true);
//        androidProcessButtonS2.setEnabled(true);
    }
}
