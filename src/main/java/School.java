import java.util.ArrayList;
import java.util.Date;

public class School {
    private ArrayList<Course> courses ;
    private String name;
    private Date createDate;
    public School(){}

    public School(String validName, Date validDate) {
        this.name = validName;
        this.createDate = validDate;
        this.courses = new ArrayList<>();

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

    public void addCourse(String validCourseName) {
        courses.add(new Course());
    }

    public void setAllCourses(ArrayList<Course> allCourses) {
        this.courses = allCourses;
    }

    public boolean isCourseNameUnique(String validCourseName) {
        for (Course c: courses) {
            if(c.getName().equals(validCourseName))
                return false;
        }

        return true;
    }
}
