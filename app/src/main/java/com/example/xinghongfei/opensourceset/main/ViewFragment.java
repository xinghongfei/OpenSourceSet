package com.example.xinghongfei.opensourceset.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xinghongfei.opensourceset.R;
import com.example.xinghongfei.opensourceset.main.adapter.ViewFragmentRecycleAdapter;
import com.example.xinghongfei.opensourceset.view.ViewDateBean;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by xinghongfei on 16/7/18.
 */
public class ViewFragment extends Fragment {
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

        viewAdapter=new ViewFragmentRecycleAdapter(list,getContext());

        viewRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        viewRecyclerview.setAdapter(viewAdapter);

        viewAdapter.setOnRecycleItemClickListener(new ViewFragmentRecycleAdapter.OnRecycleItemClickListener() {
            @Override
            public void onClickItem(View view, ViewDateBean date) {


                Toast.makeText(getContext(),date.getTitle(),Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }




    private void initialDate() {

        if (list==null){
            list=new ArrayList<ViewDateBean>();

            ViewDateBean view1= new ViewDateBean("aaaa",1,"111");
            list.add(view1);


        }

    }


}
