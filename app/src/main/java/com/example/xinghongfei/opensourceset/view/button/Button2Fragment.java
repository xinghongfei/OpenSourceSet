package com.example.xinghongfei.opensourceset.view.button;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.xinghongfei.opensourceset.R;
import com.example.xinghongfei.opensourceset.bean.InfoBean;
import com.example.xinghongfei.opensourceset.date.CreateDate;
import com.example.xinghongfei.opensourceset.util.ShowSnack;
import com.github.rubensousa.floatingtoolbar.FloatingToolbar;
import com.like.LikeButton;

import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * Created by xinghongfei on 16/7/18.
 */
public class Button2Fragment extends Fragment implements CustomAdapter.ClickListener, FloatingToolbar.ItemClickListener {

    View view;
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    @InjectView(R.id.floatingToolbar)
    FloatingToolbar floatingToolbar;
    @InjectView(R.id.fab)
    FloatingActionButton fab;

    CustomAdapter customAdapter;

    Map<Integer, InfoBean> button2Map;
    @InjectView(R.id.floatingToolbar_button)
    LikeButton floatingToolbarButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.button2_layout, null);

        ButterKnife.inject(this, view);


        customAdapter = new CustomAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(customAdapter);


        floatingToolbar.setClickListener(this);
        floatingToolbar.attachFab(fab);
        floatingToolbar.attachRecyclerView(recyclerView);


        button2Map = CreateDate.button2(button2Map);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onAdapterItemClick(MenuItem item) {

    }

    @Override
    public void onItemClick(MenuItem menuItem) {

//        Snackbar.make(view,"hello",Snackbar.LENGTH_SHORT).show();

        Toast.makeText(view.getContext(), "Be kind one another", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(MenuItem menuItem) {

    }

    @OnClick(R.id.floatingToolbar_button)
    public void onClick() {
        InfoBean infoBean1 = button2Map.get(R.id.floatingToolbar_button);
        ShowSnack.show(infoBean1, view, (LikeButton) floatingToolbarButton);

    }
}
