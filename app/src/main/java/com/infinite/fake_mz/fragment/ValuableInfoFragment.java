package com.infinite.fake_mz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.infinite.fake_mz.MzApp;
import com.infinite.fake_mz.R;
import com.infinite.fake_mz.entity.BaseValue;
import com.infinite.fake_mz.entity.ValueInfo;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.lang.reflect.Type;
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
    private int mCount,mPage;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_value_info,container,false);
        ButterKnife.bind(this,view);
        getArgs();
        getList();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void getArgs(){
        Bundle bundle=getArguments();
        mType=bundle.getString("type");
        mCount=bundle.getInt("count",20);
    }

    private void getList(){
//        Call call= MzApp.mGankIOService.getValueList(mType,mCount,mPage);
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                String res=response.body();
//                Log.e("res",res);
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });
//        MzApp.mGankIOService.getValueList(mType, mCount, mPage, new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });


        Call<String> call= MzApp.mGankIOService.getValueList(mType, mCount, mPage);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String res=response.body();
                Log.e("res",res);
                Gson gson=new Gson();
                Type type = new TypeToken<BaseValue<List<ValueInfo>>>() {
                }.getType();
                BaseValue<List<ValueInfo>> base=gson.fromJson(res, type);
                if (!base.error){
                    List<ValueInfo> valueInfos=base.getResults();
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
}
