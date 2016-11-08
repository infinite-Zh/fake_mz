package com.infinite.fake_mz.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.infinite.fake_mz.entity.ValueInfo;

import java.util.List;

/**
 * Created by inf on 2016/11/8.
 */

public class ValueAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private List<ValueInfo> mInfos;
    public ValueAdapter(List<ValueInfo> valueInfos){
        mInfos=valueInfos;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
