package com.example.lenovo.travelalone.news;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface Interface {

    @FormUrlEncoded
    @POST("/addinfo.php")
    public void Insertdata(
            @Field("name") String name,
            @Field("email") String email,
            @Field("phone") String phone,
            Callback<Response> callback
    );



}
