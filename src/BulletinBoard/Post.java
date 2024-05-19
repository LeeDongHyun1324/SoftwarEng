package BulletinBoard;
import java.util.*;

import Handler.User;

public class Post {
    private State state;
    private String content;
    private boolean visible;
    private boolean underReview;
    private Date createdTime;
    private Date lastModified;
    private Date deletedTime;
    private User author;
    private String[] tags;
    private String deletionReason;
    private List<String> editHistory;

    public Post(String content) { 
        this.content = content;
        this.state = new CreatedState(); // 초기 상태는 작성됨
        this.visible = true;
        this.underReview = false;
        this.createdTime = new Date();
        this.lastModified = null; // 초기에는 수정된 시간이 없으므로 null로 설정
        this.deletedTime = null; // 초기에는 삭제된 시간이 없으므로 null로 설정 
        this.editHistory = new ArrayList<>();
    }

    public void setState(State state) {
        this.state = state;
        state.handle(this);
    }

    public void applyState() {
        state.handle(this);
    }
    public void executeCommand(Command command) {
        state.executeCommand(command);
    }
    public void undoState() {
        state.undo(this);
    }
    //getter와 setter
    public String getContent() {
        return content; 
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isUnderReview() {
        return underReview;
    }

    public void setUnderReview(boolean underReview) {
        this.underReview = underReview;
    }
    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    public Date getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Date deletedTime) {
        this.deletedTime = deletedTime;
    }
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
    public String getDeletionReason() {
        return deletionReason;
    }

    public void setDeletionReason(String deletionReason) {
        this.deletionReason = deletionReason;
    }
    public List<String> getEditHistory() {
        return editHistory;
    }

    public void addEditHistory(String edit) {
        this.editHistory.add(edit);
    }
}

    