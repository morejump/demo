package mj.apps.demo;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static Retrofit instance = null;

    private static Retrofit getRetrofit() {
        if (instance == null) {
            instance = new Retrofit
                    .Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }

    public static ApiInterface getAPI() {
        return getRetrofit().create(ApiInterface.class);
    }
}
