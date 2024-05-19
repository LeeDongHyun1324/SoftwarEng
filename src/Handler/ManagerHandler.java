package Handler;

public class ManagerHandler extends ReportHandler {
    public ManagerHandler() {
        super(10);
    }
    @Override
    public void handleReport(User user) {
        if (user.getReportCount() >= limit) {
            user.suspend();
        }
    }
}