package mj.apps.demo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    
    @GET("posts")
    Single<List<Post>> getPosts();
    
    @GET("photos")
    Single<List<Photo>> getPhotos();
}
