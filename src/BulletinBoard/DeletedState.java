package BulletinBoard;

public class DeletedState implements State {
    @Override
    public void handle(Post post) {
        System.out.println("Post is in Deleted state.");
    }
}
