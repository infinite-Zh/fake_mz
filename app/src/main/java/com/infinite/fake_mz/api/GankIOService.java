package com.infinite.fake_mz.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by inf on 2016/11/8.
 */

public interface GankIOService {


    @GET("data/{type}/{count}/{page}")
    Call<String> getValueList(@Path("type") String type,
                              @Path("count") int count,
                              @Path("page") int page);

}
