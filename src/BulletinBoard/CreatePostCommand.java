package BulletinBoard;

public class CreatePostCommand implements Command {
    private BulletinBoard bulletinBoard;
    private Post post;

    public CreatePostCommand(BulletinBoard bulletinBoard, Post post) {
        this.bulletinBoard = bulletinBoard;
        this.post = post;
    }

    @Override
    public void execute() {
        bulletinBoard.addPost(post);
    }

    @Override
    public void undo() {
        bulletinBoard.removePost(post);
    }
}
