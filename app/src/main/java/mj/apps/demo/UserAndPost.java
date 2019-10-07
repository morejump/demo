package mj.apps.demo;

import mj.apps.demo.Models.Post;
import mj.apps.demo.Models.User;

public class UserAndPost {
    public UserAndPost(User user, Post post) {
        this.post = post;
        this.user = user;
    }
    
    public Post post;
    public User user;
}
