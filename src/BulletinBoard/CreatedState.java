package BulletinBoard;

public class CreatedState implements State {
    @Override
    public void handle(Post post) {
        System.out.println("Post is in Created state.");
    }
}

