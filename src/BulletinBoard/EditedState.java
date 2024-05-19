package BulletinBoard;
import java.util.Date;

public class EditedState implements State {
    @Override
    public void handle(Post post) {
        System.out.println("게시글이 수정된 상태입니다.");
        // 수정된 상태에서 실행할 기능
        post.setVisible(true);
        post.setLastModified(new Date());
        sendEditNotification(post);
        saveEditHistory(post);
    }

    // 게시물 수정 알림
    public void sendEditNotification(Post post) {
        System.out.println("게시물이 수정되었습니다: " + post.getContent());
    }

    // 수정 내역 저장
    public void saveEditHistory(Post post) {
        String editHistory = "수정 내용: " + post.getContent() + " > " + new Date().toString();
        post.addEditHistory(editHistory);
        System.out.println("수정 내역이 저장되었습니다.");
    }
    // 태그 갱신
    public void updateTags(Post post, String[] newTags) {
        post.setTags(newTags);
        System.out.println("게시물 태그가 갱신되었습니다: " + String.join(", ", newTags));
    }

    // EditedState일 때만 EditPostCommand 클래스 사용 가능하게 하는 메서드
    @Override
    public void executeCommand(Command command) {
        if (command instanceof EditPostCommand) {
            command.execute();
        } else {
            System.out.println("EditedState상태가 아니라면 실행 불가");
        }
    }
    // 이전 상태로 복구
    @Override
    public void undo(Post post) {
        post.setState(new CreatedState());
        System.out.println("게시물이 작성 상태로 복구되었습니다: " + post.getContent());
    }
}
