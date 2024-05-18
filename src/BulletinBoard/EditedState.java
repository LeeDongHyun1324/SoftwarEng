package BulletinBoard;

public class EditedState implements State {
    @Override
    public void handle(Post post) {
        System.out.println("Post is in Edited state.");
    }
}
