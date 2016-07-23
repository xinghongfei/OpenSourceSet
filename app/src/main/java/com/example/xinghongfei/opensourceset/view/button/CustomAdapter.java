package com.example.xinghongfei.opensourceset.view.button;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xinghongfei.opensourceset.R;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ClickListener mListener;
    private List<String> mItems;





    public CustomAdapter(ClickListener listener) {
        mItems = new ArrayList<>();
        mListener = listener;
        for (int i = 'A'; i < 'z'; i++)
        {
            mItems.add("" + (char) i);
        }
    }

    public void setClickListener(ClickListener listener) {
        mListener = listener;
    }

    public void addItem(String item) {
        mItems.add(item);
        notifyItemInserted(mItems.size() - 1);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.button2_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public MenuItem item;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

        public void setData(String item) {

            textView.setText(item);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onAdapterItemClick(item);
            }
        }
    }

    public interface ClickListener {
        void onAdapterItemClick(MenuItem item);
    }
}
