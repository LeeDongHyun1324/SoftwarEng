package BulletinBoard;

public class ReportPostCommand implements Command {
    private Post post;

    public ReportPostCommand(Post post) {
        this.post = post;
    }

    @Override
    public void execute() {
        // 게시물을 신고하는 기능을 여기에 구현
        System.out.println("게시물을 신고했습니다: " + post.getContent());
    }

    @Override
    public void undo() {
        // 게시물 신고를 취소하 는 기능을 여기에 구현
        System.out.println("게시물 신고를 취소했습니다: " + post.getContent());
    }
}