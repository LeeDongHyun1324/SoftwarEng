package BulletinBoard;

public class DeletePostCommand implements Command {
    private BulletinBoard bulletinBoard;
    private Post post;

    public DeletePostCommand(BulletinBoard bulletinBoard, Post post) {
        this.bulletinBoard = bulletinBoard;
        this.post = post;
    }

    @Override
    public void execute() {
        bulletinBoard.removePost(post);
    }

    @Override
    public void undo() {
        bulletinBoard.addPost(post);
    }
}
