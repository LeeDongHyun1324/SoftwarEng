package Handler;

public class WarningHandler extends ReportHandler{
    public WarningHandler() {
        super(5);
    }

    @Override
    public void handleReport(User user) {
        if (user.getReportCount() >= limit) {
            user.warn();
        }
        
        // 신고 횟수가 10회 이상이면 처리를 넘김
        if (user.getReportCount() >= 10 && nextHandler != null) {
            nextHandler.handleReport(user);
        }
    }
}
