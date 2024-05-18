package BulletinBoard;

public class ReportedState implements State {
    @Override
    public void handle(Post post) {
        System.out.println("Post is in Reported state.");
    }
}
