package com.example.xinghongfei.opensourceset.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xinghongfei.opensourceset.R;
import com.example.xinghongfei.opensourceset.main.adapter.ViewFragmentRecycleAdapter;
import com.example.xinghongfei.opensourceset.view.ViewDateBean;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by xinghongfei on 16/7/18.
 */
public class ViewFragment extends Fragment implements ViewFragmentRecycleAdapter.OnRecycleItemClickListener {
    public static final String PACAKGE = "com.example.xinghongfei.opensourceset";

    @InjectView(R.id.view_recyclerview)
    RecyclerView viewRecyclerview;

    ArrayList<ViewDateBean> list;

    ViewFragmentRecycleAdapter viewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.view_layout, null);

        ButterKnife.inject(this, view);

        initialDate();

        viewAdapter = new ViewFragmentRecycleAdapter(list, getContext());

        viewRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        viewRecyclerview.setAdapter(viewAdapter);


        viewAdapter.setOnRecycleItemClickListener(this);


        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    private void initialDate() {

        if (list == null) {
            list = new ArrayList<ViewDateBean>();

            ViewDateBean buttonBean1 = new ViewDateBean("Button", 6, "com.example.xinghongfei.opensourceset.view.button.ButtonActivity");
            list.add(buttonBean1);

            ViewDateBean buttonBean2 = new ViewDateBean("Refresh", 3, "com.example.xinghongfei.opensourceset.view.refresh.RegreshActivity");
            list.add(buttonBean2);


        }

    }


    @Override
    public void onClickItem(View view, ViewDateBean date) {
        Intent intent = new Intent();
        intent.setClassName(PACAKGE, date.getClassname());
        getActivity().startActivity(intent);
    }
}
