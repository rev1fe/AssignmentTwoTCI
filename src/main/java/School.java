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

    public void addCourse(String validCourseName, Date date)  {
            courses.add(new Course(validCourseName, date));

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

    public void addCourse(Course expectedCourse) throws CourseException {
        if(createDate.compareTo(expectedCourse.getCreateDate())== 1)
        {
            throw new CourseException("Date cannot be before the create date of the school");
        }else{
            courses.add(expectedCourse);
        }

    }

    public Course getCourseByName(String validCourseName) {

        for (Course c: courses) {
            if(c.getName().equals(validCourseName))
                return c;
        }
        return null;
    }
}
