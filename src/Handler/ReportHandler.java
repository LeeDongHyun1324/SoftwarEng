package Handler;

public abstract class ReportHandler {
    protected ReportHandler nextHandler;
    protected int limit;

    public ReportHandler(int limit) {
        this.limit = limit;
    }

    //다음 처리자 설정
    public void setNextHandler(ReportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    //신고 처리를 위한 추상 메서드
    public abstract void handleReport(User user);
    
}
