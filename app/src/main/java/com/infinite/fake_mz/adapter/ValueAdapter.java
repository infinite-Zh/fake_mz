package com.infinite.fake_mz.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.infinite.fake_mz.R;
import com.infinite.fake_mz.entity.ValueInfo;
import com.infinite.fake_mz.interf.OnItemClickListener;
import com.infinite.fake_mz.tools.ImageDisplayer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by inf on 2016/11/8.
 */

public class ValueAdapter extends RecyclerView.Adapter<ValueAdapter.ViewHolder>{


    private List<ValueInfo> mInfos;
    private Context mContext;
    public ValueAdapter(List<ValueInfo> valueInfos,Context context){
        mInfos=valueInfos;
        mContext=context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_value_infl, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ValueInfo info=mInfos.get(position);
        int width=0,height=0;
        if (position%3==0){
            width=200;
            height=300;
        }else if (position%3==1){
            width=200;
            height=250;
        }else {
            width=200;
            height=200;
        }


        String imageUrl=info.getUrl()+"?imageView2/1w/"+width+"/h"+height;
        holder.mTextDesc.setText(info.getWho());
        holder.mImg.setTag(R.id.image_url,imageUrl);
        RelativeLayout.LayoutParams lp= (RelativeLayout.LayoutParams) holder.mImg.getLayoutParams();
        lp.height= height*2;
        ImageDisplayer.displayImage(holder.mImg,imageUrl,mContext);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener!=null){
                    mListener.onItemCick(holder.itemView,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mInfos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.img)
        public ImageView mImg;
        @BindView(R.id.txt_desc)
        public TextView mTextDesc;

        public View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.itemView=itemView;

        }
    }

    private OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener=listener;
    }

}
