package mj.apps.demo;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import mj.apps.demo.Models.Post;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetPost {
    @GET("posts/{post}")
    Observable<Post> getPost(@Path("post") int postId);
}
