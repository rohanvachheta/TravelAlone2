package com.example.lenovo.travelalone.news;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface Json {


    @GET("/json.php")
    Call<List<User>> getuser();
}
