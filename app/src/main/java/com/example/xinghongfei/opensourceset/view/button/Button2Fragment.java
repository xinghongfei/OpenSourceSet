package com.example.xinghongfei.opensourceset.view.button;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.xinghongfei.opensourceset.MainActivity;
import com.example.xinghongfei.opensourceset.R;
import com.like.LikeButton;

/**
 * Created by xinghongfei on 16/7/18.
 */
public class Button2Fragment extends Fragment{

    LikeButton likeButton;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view=inflater.inflate(R.layout.button2_layout,null);

        likeButton= (LikeButton) view.findViewById(R.id.like_button);

//        Snackbar.make(view, "Snackbar comes out", Snackbar.LENGTH_LONG)
//                .setAction("Action", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                }).show();
//        show();
        return view;
    }






    public void show(){

        View view1=LayoutInflater.from(getContext()).inflate(R.layout.snackview, (ViewGroup) view,false);





    }


}
