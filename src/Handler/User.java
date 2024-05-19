package Handler;


public class User {
    private String name;
    private String email;
    private int reportCount;
    private int warningCount;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.reportCount = 0;
    }

    public void warn() {
        warningCount++;
        System.out.println("신고 횟수 : " + warningCount);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getReportCount() {
        return reportCount;
    }

    public void incrementReportCount() {
        reportCount++;
    }
    //사용자 정지 메서드
    public void suspend() {
        System.out.println(name + "는 정지당한 계정입니다.");
    }
}
