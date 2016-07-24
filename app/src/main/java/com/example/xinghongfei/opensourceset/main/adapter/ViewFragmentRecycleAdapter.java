package com.example.xinghongfei.opensourceset.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xinghongfei.opensourceset.R;
import com.example.xinghongfei.opensourceset.view.ViewDateBean;

import java.util.ArrayList;

/**
 * Created by xinghongfei on 16/7/21.
 */
public class ViewFragmentRecycleAdapter extends RecyclerView.Adapter<ViewFragmentRecycleAdapter.MyViewHolder> {

    ArrayList<ViewDateBean> list;
    Context context;

    OnRecycleItemClickListener listener;

    public ViewFragmentRecycleAdapter(ArrayList<ViewDateBean> beans, Context context) {
        list = beans;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){

                    listener.onClickItem(view, (ViewDateBean) myViewHolder.describe_tv.getTag());
                }

            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ViewDateBean viewBean = list.get(position);
        holder.title_tv.setText(viewBean.getTitle());
        holder.describe_tv.setText(String.valueOf(viewBean.getCount()));
        holder.describe_tv.setTag(viewBean);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {


        TextView title_tv;
        TextView describe_tv;

        public MyViewHolder(View view) {
            super(view);
            title_tv = (TextView) view.findViewById(R.id.view_item_id_title);
            describe_tv = (TextView) view.findViewById(R.id.view_item_id_describe);
        }
    }


    public void setOnRecycleItemClickListener(OnRecycleItemClickListener onRecycleItemClickListener){

        listener = onRecycleItemClickListener;

    }

    public interface  OnRecycleItemClickListener{
        void onClickItem(View view ,ViewDateBean date);
    }
}

