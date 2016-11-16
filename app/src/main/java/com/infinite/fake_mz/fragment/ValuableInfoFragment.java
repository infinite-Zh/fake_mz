package com.infinite.fake_mz.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.infinite.fake_mz.MzApp;
import com.infinite.fake_mz.R;
import com.infinite.fake_mz.activity.ImageScanActivity;
import com.infinite.fake_mz.adapter.ValueAdapter;
import com.infinite.fake_mz.entity.BaseValue;
import com.infinite.fake_mz.entity.ValueInfo;
import com.infinite.fake_mz.interf.OnItemClickListener;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by inf on 2016/11/4.
 */

public class ValuableInfoFragment extends Fragment{

    @BindView(R.id.recyclerView)
    public XRecyclerView mRecyclerView;
    private String mType;
    private int mCount,mPage=1;

    private List<ValueInfo> mInfos=new ArrayList<>();
    private ValueAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_value_info,container,false);
        ButterKnife.bind(this,view);
        getArgs();
        getList(0);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mAdapter=new ValueAdapter(mInfos,getActivity());
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLoadingMoreEnabled(true);

        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                getList(0);
            }

            @Override
            public void onLoadMore() {
                getList(mPage);
            }
        });
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemCick(View view, int position) {
                Intent intent=new Intent(getActivity(), ImageScanActivity.class);
                View imageView=view.findViewById(R.id.img);
                intent.putExtra("url", (String) imageView.getTag(R.id.image_url));

                ViewCompat.setTransitionName(imageView,"fff");
                ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),imageView,"fff");
                startActivity(intent,optionsCompat.toBundle());

            }
        });
    }

    private void getArgs(){
        Bundle bundle=getArguments();
        mType=bundle.getString("type");
        mCount=bundle.getInt("count",20);
    }

    private void getList(final int page){


        Call<String> call= MzApp.mGankIOService.getValueList(mType, mCount, page);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String res=response.body();
                Log.e("res",res);
                mRecyclerView.refreshComplete();
                mRecyclerView.loadMoreComplete();
                Gson gson=new Gson();
                Type type = new TypeToken<BaseValue<List<ValueInfo>>>() {
                }.getType();
                BaseValue<List<ValueInfo>> base=gson.fromJson(res, type);
                if (!base.error){
                    List<ValueInfo> valueInfos=base.getResults();
                    if (valueInfos!=null){
                        if (page==1){
                            mInfos.clear();
                            mPage=1;
                        }
                        mPage++;
                        mInfos.addAll(valueInfos);
                        mAdapter.notifyDataSetChanged();
                    }
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }


    public static ValuableInfoFragment newInstance(String type,int count){
        Bundle bundle=new Bundle();
        bundle.putString("type",type);
        bundle.putInt("count",count);
        ValuableInfoFragment info=new ValuableInfoFragment();
        info.setArguments(bundle);
        return info;
    }

    public CharSequence getTitle(){
        return mType;
    }
}
