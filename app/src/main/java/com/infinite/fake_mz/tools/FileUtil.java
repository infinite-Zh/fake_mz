package com.infinite.fake_mz.tools;

import android.os.Environment;
import android.support.annotation.Nullable;

import com.infinite.fake_mz.MzApp;

import java.io.File;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by inf on 2016/11/17.
 */

public class FileUtil {

    private static final String FILE_IMAGE="image";

    /**
     * 保存网络图片
     * @param url
     * @return
     */
    public static boolean save(String url){
        File file=createFile(FILE_IMAGE);
        if (file!=null){
            Call<ResponseBody> call=MzApp.mGankIOService.downloadImage(url);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }
        return false;
    }

    @Nullable
    private static File createFile(String name){
        if (isStorageAvaliable()){
            File file=new File(MzApp.getApp().getExternalCacheDir()+name);
            if (!file.exists()){
               if ( file.mkdirs()){
                   return file;
               }
            }
        }else {
            return null;
        }
        return null;
    }

    private static boolean isStorageAvaliable(){
        return  Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

}
