import java.util.ArrayList;
import java.util.Date;

public class School {
    private ArrayList<Course> courses ;
    private String name;
    private Date createDate;

    public School(String validName, Date validDate) {

    }

    public ArrayList<Course> getAllCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
