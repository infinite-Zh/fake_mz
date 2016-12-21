package com.infinite.fake_mz;

import android.app.Application;

import com.infinite.fake_mz.api.GankIOService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by inf on 2016/11/8.
 */

public class MzApp extends Application {

    public static GankIOService mGankIOService;
    public static MzApp mzApp;
    @Override
    public void onCreate() {
        super.onCreate();
        mzApp=this;
        initGankIOService();

    }

    private void initGankIOService() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(loggingInterceptor)
                .readTimeout(20,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Global.END_POINT)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        mGankIOService = retrofit.create(GankIOService.class);
    }

    public static MzApp getApp(){
        return mzApp;
    }
}
