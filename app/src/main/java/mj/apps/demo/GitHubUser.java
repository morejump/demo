package mj.apps.demo;


import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubUser {
    
    @GET("users/{user}")
    Observable<JsonObject> getuser(@Path("User") String user);
}
