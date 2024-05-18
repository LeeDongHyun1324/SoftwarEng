package Handler;

public class ManagerHandler extends ReportHandler {
    private String managerName;

    public ManagerHandler(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public void setNextHandler(ReportHandler nextHandler) {
        // ManagerHandler는 마지막 핸들러이므로 다음 핸들러가 없습니다.
    }

    @Override
    public void handleReport(User user) {
        System.out.println("Manager : " + managerName + " is handling the report for user: " + user.getUsername());
        suspendUser(user);
    }

    private void suspendUser(User user) {
        System.out.println("Manager : " + managerName + " has suspended user " + user.getUsername());
        user.suspend();
    }
}