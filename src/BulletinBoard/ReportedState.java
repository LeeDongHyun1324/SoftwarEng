package BulletinBoard;

public class ReportedState implements State {
    @Override
    public void handle(Post post) {
        System.out.println("게시글이 신고된 상태입니다.");
        // 신고된 상태에서 실행할 기능
        post.setVisible(false); // 일반 사용자에게 보이지 않도록 설정
        post.setUnderReview(true); // 관리자 검토 중으로 표시
        sendReportNotification(post);
    }
    // 게시물 신고 알림
    public void sendReportNotification(Post post) {
        System.out.println("게시물이 신고되었습니다: " + post.getContent());
    }
    // ReportedState일 때만 ReportPostCommand 클래스 사용 가능하게 하는 메서드
    @Override
    public void executeCommand(Command command) {
        if (command instanceof ReportPostCommand) {
            command.execute();
        } else {
            System.out.println("RepotedState상태가 아니라면 실행 불가");
        }
    }
    // 이전 상태로 복구
    @Override
    public void undo(Post post) {
        post.setState(new CreatedState());
        System.out.println("게시물이 작성 상태로 복구되었습니다: " + post.getContent());
    }
}
