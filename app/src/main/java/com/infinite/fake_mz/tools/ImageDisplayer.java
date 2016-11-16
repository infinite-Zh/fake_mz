package com.infinite.fake_mz.tools;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.infinite.fake_mz.R;

/**
 * Created by inf on 2016/11/14.
 */

public class ImageDisplayer {

    public static void displayImage(ImageView imageView,String url, AppCompatActivity activity){
        Glide.with(activity).load(url).centerCrop().crossFade().placeholder(R.mipmap.ic_launcher).into(imageView);
    }
    public static void displayImage(ImageView imageView,String url, Context context){
        Glide.with(context).load(url).centerCrop().crossFade().placeholder(R.mipmap.ic_launcher).into(imageView);

    }
}
