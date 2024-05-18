import BulletinBoard.BulletinBoard;
import BulletinBoard.Command;
import BulletinBoard.CommandInvoker;
import BulletinBoard.CreatePostCommand;
import BulletinBoard.DeletePostCommand;
import BulletinBoard.DeletedState;
import BulletinBoard.EditPostCommand;
import BulletinBoard.EditedState;
import BulletinBoard.Post;
import BulletinBoard.ReportedState;
import Handler.ManagerHandler;
import Handler.ReportCounterHandler;
import Handler.ReportHandler;
import Handler.User;

public class Client {
    public static void main(String[] args) {
        // Command
        //게시판과 인보커 초기화,인보커 = 실행 클래스
        BulletinBoard bulletinBoard = new BulletinBoard();
        CommandInvoker invoker = new CommandInvoker();

        Post post1 = new Post("This is the first post.");
        Post updatedPost1 = new Post("Updated post");

        // 글 등록
        Command createPost1 = new CreatePostCommand(bulletinBoard, post1);
        invoker.executeCommand(createPost1);

        // 글 수정
        Command editPost1 = new EditPostCommand(bulletinBoard, post1, updatedPost1);
        invoker.executeCommand(editPost1);

        // 글 삭제
        Command deletePost1 = new DeletePostCommand(bulletinBoard, updatedPost1);
        invoker.executeCommand(deletePost1);

        // 실행 취소
        invoker.undoCommand(); // 삭제 취소
        invoker.undoCommand(); // 수정 취소
        invoker.undoCommand(); // 등록 취소


        // State
        Post post = new Post("This is a new post.");
        post.applyState(); // Created state 처리

        post.setState(new EditedState());
        post.applyState(); // Edited state 처리

        post.setState(new ReportedState());
        post.applyState(); // Reported state 처리

        post.setState(new DeletedState());
        post.applyState(); // Deleted state 처리

        //chain of resposibility
        
        User user = new User("john_doe", 0); // 신고 횟수 0회로 초기화된 사용자
        ManagerHandler managerHandler = new ManagerHandler("admin1"); // 관리자 객체 생성

        ReportHandler reportHandler = new ReportCounterHandler();
        reportHandler.setNextHandler(managerHandler); // 체인 설정

        reportHandler.handleReport(user); // 사용자 신고 처리
    }
}