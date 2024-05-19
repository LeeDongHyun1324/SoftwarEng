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
    //태그 탐색 메서드
    public List<Post> searchByTag(String tag) {
        List<Post> result = new ArrayList<>();
        for (Post post : posts) {
            for (String postTag : post.getTags()) {
                if (postTag.equalsIgnoreCase(tag)) {
                    result.add(post);
                    break;
                }
            }
        }
        return result;
    }
}
