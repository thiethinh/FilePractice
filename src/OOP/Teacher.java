package OOP;

public class Teacher {
    private String id;
    private String fullName;
    private String major;

    public Teacher(String id, String fullName, String major) {
        this.id = id;
        this.fullName = fullName;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
