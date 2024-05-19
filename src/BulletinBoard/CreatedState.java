package BulletinBoard;

import java.util.Date;

import Handler.User;

public class CreatedState implements State {
    @Override
    public void handle(Post post) {
        System.out.println("게시글이 작성된 상태입니다.");
        // 작성된 상태에서 실행할 기능
        post.setVisible(true);
        // 작성 시간
        post.setCreatedTime(new Date());
        sendCreationNotification(post);
    }
    //게시물 작성 알림
    public void sendCreationNotification(Post post) {
        System.out.println("새로운 게시물이 작성되었습니다 : " + post.getContent());
    }
    //작성자 정보
    public void setAuthorInfo(Post post, User author) {
        post.setAuthor(author);
        System.out.println("게시글 작성자 정보 : " + author.getName());
    }
    //태그
    public void setInitialTags(Post post, String[] tags) {
        post.setTags(tags);
        System.out.println("게시물 태그 : " + String.join(", ", tags));
    }
    // CreatedState일 때만 CreatePostCommand 클래스를 사용 가능하게 하는 메서드
    public void executeCommand(Command command) {
        if (command instanceof CreatePostCommand) {
            command.execute();  //CreatePostCommand의 execute 메서드를 실행
        } else {
            System.out.println("CreatedState상태가 아니라면 실행 불가");
        }
    } 
    //Undo를 활용한 게시글 삭제
    @Override
    public void undo(Post post) {
        post.setState(new DeletedState());
        System.out.println("게시물이 삭제되었습니다 (복구 이전 상태로 돌아감): " + post.getContent());
    }
}

