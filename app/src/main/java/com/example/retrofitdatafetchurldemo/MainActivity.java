package com.example.retrofitdatafetchurldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    private static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface=ApiClientData.getClient().create(ApiInterface.class);
    }

    public void getTodos(View view) {
        Call<List<DataClass>> call=apiInterface.getTodos();
        call.enqueue(new Callback<List<DataClass>>() {
            @Override
            public void onResponse(Call<List<DataClass>> call, Response<List<DataClass>> response) {
              //  Toast.makeText(getApplicationContext(),""+response,Toast.LENGTH_LONG).show();
                Log.e(TAG,"onResponce"+response.body());
            }

            @Override
            public void onFailure(Call<List<DataClass>> call, Throwable t) {
                //Toast.makeText(getApplicationContext(),""+t,Toast.LENGTH_LONG).show();
                Log.e(TAG,"onResponce"+t.getLocalizedMessage());
            }
        });
    }

    public void getTodosUsingRouteparameter(View view) {
        Call<DataClass> dataClassCall=apiInterface.getTodo(3);
        dataClassCall.enqueue(new Callback<DataClass>() {
            @Override
            public void onResponse(Call<DataClass> call, Response<DataClass> response) {
                Log.e(TAG,"onResponce"+response.body());

            }

            @Override
            public void onFailure(Call<DataClass> call, Throwable t) {
                Log.e(TAG,"onResponce"+t.getLocalizedMessage() );

            }
        });


    }

    public void getTodosUsingQuery(View view) {
        Call<List<DataClass>> classCall=apiInterface.getTodosUsingQuery(2,false);
        classCall.enqueue(new Callback<List<DataClass>>() {
            @Override
            public void onResponse(Call<List<DataClass>> call, Response<List<DataClass>> response) {
                Log.e(TAG,"onResponce"+response.body());

            }

            @Override
            public void onFailure(Call<List<DataClass>> call, Throwable t) {
//                Log.e(TAG,"onResponce"+t.getLocalizedMessage());

            }
        });

    }

    public void postTodo(View view) {
        DataClass dataClass= new DataClass(2,"hey shankar",true);
        Call<DataClass> dataClassCall=apiInterface.postTodo(dataClass);
        dataClassCall.enqueue(new Callback<DataClass>() {
            @Override
            public void onResponse(Call<DataClass> call, Response<DataClass> response) {
                Log.e(TAG, "onResponse: "+response.body() );
            }

            @Override
            public void onFailure(Call<DataClass> call, Throwable t) {

            }
        });
    }

}
