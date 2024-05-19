package BulletinBoard;

public interface State {
    void handle(Post post);
    void executeCommand(Command command);
    void undo(Post post);
}
