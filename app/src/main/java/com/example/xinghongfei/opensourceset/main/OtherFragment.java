package com.example.xinghongfei.opensourceset.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xinghongfei.opensourceset.R;

/**
 * Created by xinghongfei on 16/7/18.
 */
public class OtherFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.other_layout,null);

        return view;
    }
}
