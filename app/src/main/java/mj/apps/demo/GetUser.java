package mj.apps.demo;


import com.google.gson.JsonObject;

import io.reactivex.Observable;
import mj.apps.demo.Models.User;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetUser {
    
    @GET("users/{userid}")
    Observable<User> getuser(@Path("userid") String userId);
}
