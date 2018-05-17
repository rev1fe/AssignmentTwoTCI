import java.util.Date;

public class Course {
    private String name;
    private Date createDate;

    public Course(String validCourseName, Date validDate, Date invalid_date) {
        this.name = validCourseName;
        this.createDate = validDate;
        this.endDate = invalid_date;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    private Date endDate;

    public Course (){}

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
