package BulletinBoard;
import java.util.Date;

public class DeletedState implements State {
    @Override
    public void handle(Post post) {
        System.out.println("게시글이 삭제된 상태입니다.");
        // 삭제된 상태에서 실행할 기능
        post.setVisible(false);
        post.setDeletedTime(new Date());
        sendDeletionNotification(post);
    }

    //게시글 삭제 알림
    public void sendDeletionNotification(Post post) {
        System.out.println("게시물이 삭제되었습니다 : " + post.getContent());
    }

    // 삭제 이유 설정
    public void setDeletionReason(Post post, String reason) {
        post.setDeletionReason(reason);
        System.out.println("삭제 이유 : " + reason);
    }

    // DeletedState일 때만 DeletePostCommand 클래스를 사용 가능하게 하는 메서드
    @Override
    public void executeCommand(Command command) {
        if (command instanceof DeletePostCommand) {
            command.execute();
        } else {
            System.out.println("DeletedState상태가 아니라면 실행 불가");
        }
    }
    //Undo를 활용한 게시글 복구
    @Override
    public void undo(Post post) {
        post.setState(new CreatedState());
        System.out.println("게시물이 복구되었습니다: " + post.getContent());
    }
}
