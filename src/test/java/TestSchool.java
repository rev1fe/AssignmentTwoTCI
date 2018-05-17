import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestSchool {
    private final static String VALID_NAME = "MySchool";
    private final static Date VALID_DATE = Calendar.getInstance().getTime();
    private final static ArrayList<Course> EMPTY_COURSE_COLLECTION = new ArrayList<>();



    //You can get a list of all course names.

    @Test
    public void listCopyOfAllCoursesIsReturned() {
        //arrange
        School school = new School();
        ArrayList<Course> courses;
        ArrayList<Course> expectedCourses = new ArrayList<>();

        //act
        courses = school.getAllCourses();

        //assert
        assertEquals("Class School is returning different list of courses than the one in it." ,expectedCourses , courses);
    }

    //A School has a name
    @Test
    public void schoolSchoolObjectHasNameProperty()  {
        //arrange
        School school = new School(VALID_NAME, VALID_DATE);

        //act
        String returnedName = school.getName();

        //assert
        assertEquals("Expected name is" + VALID_NAME + "But what was received is: " + returnedName, VALID_NAME, returnedName);
    }

    //A School has an opening date
    @Test
    public void schoolSchoolObjectHasNameProperty() {
        //arrange
        School school = new School(VALID_NAME, VALID_DATE);

        //act
        Date date = school.getCreateDate();

        //assert
        assertEquals("Expected date is" + date.toString() + "But what was received is: " + VALID_DATE.toString(), VALID_DATE, date);
    }

    //A School has a collection of courses.
    @Test
    public void schoolSchoolObjectHasCourseListProperty() {
        //arrange
        School school = new School(VALID_NAME, VALID_DATE);

        //act
        ArrayList<Course> returnedCollection = school.getAllCourses();

        //assert
        assertEquals("Expect empty collection [] But what was received is collection with : " + returnedCollection.size() + "elements", EMPTY_COURSE_COLLECTION, returnedCollection);
    }
}

/*

A School has a name, an opening date and a collection of courses.

Course objects function as placeholders for the name of the course, the start date and end date of the course.

You can add a course to the school.

The end date should be after the begin date, otherwise a CourseException is thrown.

The name of the course is unique.

You can get a course by name.

You can get a list of all course names.

You can get a list of copies of all courses

Course begin dates are after the school begin date. Throw a CourseException when it’s wrong.

 */