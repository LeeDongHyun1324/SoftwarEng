package Handler;
public abstract class ReportHandler {
    protected ReportHandler nextHandler;

    public void setNextHandler(ReportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleReport(User user);
}
