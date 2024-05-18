package Handler;
public class User {
    private String username;
    private int reportCount;

    public User(String username, int reportCount) {
        this.username = username;
        this.reportCount = reportCount;
    }

    public String getUsername() {
        return username;
    }

    public int getReportCount() {
        return reportCount;
    }

    public void incrementReportCount() {
        reportCount++;
    }

    public void suspend() {
        System.out.println("User " + username + " has been suspended.");
    }
}
