package BulletinBoard;
import java.util.*;

public class BulletinBoard {
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
    }

    public void updatePost(Post oldPost, Post newPost) {
        int index = posts.indexOf(oldPost);
        if (index != -1) {
            posts.set(index, newPost);
        }
    }

    public void removePost(Post post) {
        posts.remove(post);
    }

    public List<Post> getPosts() {
        return posts;
    }
}
