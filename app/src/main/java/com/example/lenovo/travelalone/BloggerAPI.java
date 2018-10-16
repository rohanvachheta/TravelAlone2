package com.example.lenovo.travelalone;

import android.content.Context;
import android.net.http.HttpResponseCache;
import android.util.Log;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.CallAdapter.Factory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class BloggerAPI {
    Context context;
    int cacheSize = 10 * 1024 * 1024; // 10 MB
    //OkHttpClient okHttpClient = createCachedClient(context);
    File httpCacheDirectory = new File(context.getCacheDir(), "responses");


    private static final String key="AIzaSyAVeHDNxJocA83vQ178OhVUvY-COzY0e5Y";
    private static final String url="https://www.googleapis.com/blogger/v3/blogs/1278848638611977750/posts/";
    Cache cache = null;
    public static PostService postService=null;
    static PostService getService(){
        if(postService==null){
            //create
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService=retrofit.create(PostService.class);


        }
        return postService;

    }




}
