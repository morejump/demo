package mj.apps.demo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    public Single<List<Post>> getPosts();

    @GET("photos")
    public Single<List<Photo>> getPhotos();
}
