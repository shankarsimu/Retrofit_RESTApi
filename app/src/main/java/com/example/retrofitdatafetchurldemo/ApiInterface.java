package com.example.retrofitdatafetchurldemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/todos")
    Call<List<DataClass>> getTodos();

    @GET("/todo/{id}")
    Call<DataClass> getTodo(@Path("id") int id);

    @GET("/todos")
    Call<List<DataClass>>getTodosUsingQuery(@Query("userId") int userId,@Query("completed") boolean completed);


    @POST("/todos")
    Call<DataClass> postTodo(@Body  DataClass dataClass);


}
