package com.example.lenovo.travelalone;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

     String key="AIzaSyAVeHDNxJocA83vQ178OhVUvY-COzY0e5Y";

    @GET("?key="+key)
Call<Postlist> getPostList();
    //@GET("{postId}/key="+key)
    //Call<Item> getPostById(@Path("postId") String id);
}