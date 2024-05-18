package BulletinBoard;

public class Post {
    private State state;
    private String content;

    public Post(String content) {
        this.content = content;
        this.state = new CreatedState(); // 초기 상태는 작성됨
    }

    public void setState(State state) {
        this.state = state;
    }

    public void applyState() {
        state.handle(this);
    }

    public String getContent(){
        return content; 
    }

    public void setContent(String content){
        this.content = content;
    }
}

    