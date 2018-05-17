import java.util.Date;

public class Course {
    private String name;
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Course(String validCourseName, Date INVALID_DATE) {
        this.name = validCourseName;
        this.createDate = INVALID_DATE;
    }

    public String getName() {
        return name;
    }
}
