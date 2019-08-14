package mj.apps.demo;

import com.google.gson.JsonArray;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubEvents {
    @GET("users/{user}/events")
    Observable<JsonArray> listEvents(@Path("user") String user);
}
