package Handler;
public class ReportCounterHandler extends ReportHandler {
    private static final int REPORT_THRESHOLD = 10;

    @Override
    public void handleReport(User user) {
        if (user.getReportCount() >= REPORT_THRESHOLD) {
            System.out.println("User " + user.getUsername() + " has been suspended.");
            user.suspend();
        } else if (nextHandler != null) {
            nextHandler.handleReport(user);
        }
    }
}
