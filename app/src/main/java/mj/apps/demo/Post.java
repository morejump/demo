package mj.apps.demo;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("userId")
    private String userId;
    private String id;
    private String title;
    private String body;
}
