import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TestSchool {
    private final static String VALID_COURSE_NAME = "UniqueName";
    private final static String VALID_COURSE_NAME_TWO = "SecondName";
    private final static String VALID_SCHOOL_NAME = "MySchool";
    private final static Date VALID_DATE = Calendar.getInstance().getTime();
    private final static ArrayList<Course> EMPTY_COURSE_COLLECTION = new ArrayList<>();
    private final static ArrayList<Course> ONE_ELEMENT_COURSE_COLLECTION = new ArrayList<Course>(Arrays.asList(new Course("Test Course", VALID_DATE)));



    //You can get a list of all course names.

    @Test
    public void listCopyOfAllCoursesIsReturned() {
        //arrange
        School school = new School(VALID_SCHOOL_NAME, VALID_DATE);
        ArrayList<Course> courses;
        school.setAllCourses(ONE_ELEMENT_COURSE_COLLECTION);

        //act
        courses = school.getAllCourses();

        //assert
        assertEquals("Class School is returning different list of courses than the one in it." ,ONE_ELEMENT_COURSE_COLLECTION , courses);
    }

    //A School has a name
    @Test
    public void schoolSchoolObjectHasNameProperty()  {
        //arrange
        School school = new School(VALID_SCHOOL_NAME, VALID_DATE);

        //act
        String returnedName = school.getName();

        //assert
        assertEquals("Expected name is " + VALID_SCHOOL_NAME + "But what was received is: " + returnedName, VALID_SCHOOL_NAME, returnedName);
    }

    //A School has an opening date
    @Test
    public void schoolSchoolObjectHasDateProperty() {
        //arrange
        School school = new School(VALID_SCHOOL_NAME, VALID_DATE);

        //act
        Date date = school.getCreateDate();

        //assert
        assertEquals("Expected date is " + date.toString() + "But what was received is: " + VALID_DATE.toString(), VALID_DATE, date);
    }

    //A School has a collection of courses.
    @Test
    public void schoolSchoolObjectHasCourseListProperty() {
        //arrange
        School school = new School(VALID_SCHOOL_NAME, VALID_DATE);

        //act
        ArrayList<Course> returnedCollection = school.getAllCourses();

        //assert
        assertEquals("Expect empty collection [] But what was received is collection with : " + returnedCollection.size() + "elements", EMPTY_COURSE_COLLECTION, returnedCollection);
    }

    //The name of the course is unique.
    @Test
    public void courseNameIsUnique() throws CourseException {
        //arrange
        School school = new School(VALID_SCHOOL_NAME, VALID_DATE);


        //act
        school.addCourse(VALID_COURSE_NAME, VALID_DATE);
        boolean resultFromNameCheck = school.isCourseNameUnique(VALID_COURSE_NAME);
        //assert
        assertFalse("Expected FALSE but received " + String.valueOf(resultFromNameCheck).toUpperCase(), resultFromNameCheck ); ;
    }

    @Test
    public void courseNameIsNotUnique()throws CourseException {
        //arrange
        School school = new School(VALID_SCHOOL_NAME, VALID_DATE);

        //act
        school.addCourse(VALID_COURSE_NAME_TWO, VALID_DATE);
        boolean resultFromNameCheck = school.isCourseNameUnique(VALID_COURSE_NAME);

        //assert
        assertTrue("Expected TRUE but received " + String.valueOf(resultFromNameCheck).toUpperCase(), resultFromNameCheck ) ;
    }

    @Test
    public void getCourseByName() throws CourseException {
        //arrange
        School school = new School(VALID_SCHOOL_NAME, VALID_DATE);
        Course expectedCourse = new Course(VALID_COURSE_NAME, VALID_DATE, VALID_DATE);
        school.addCourse(expectedCourse);

        //act
        Course returnedCourse = school.getCourseByName(VALID_COURSE_NAME);

        //assert
        assertEquals("Expected object is" + expectedCourse + "but it was returned " + returnedCourse, expectedCourse, returnedCourse);
    }

    //Course begin dates are after the school begin date. Throw a CourseException when it’s wrong.
    @Test(expected = CourseException.class)
    public void courseBeginDateIsAfterSchoolDate() throws CourseException {
        //arrange
        School school = new School(VALID_SCHOOL_NAME, VALID_DATE);
        Calendar cal = Calendar.getInstance();
        cal.setTime(VALID_DATE);
        cal.add(Calendar.DATE, -30);
        Date INVALID_DATE = cal.getTime();
        System.out.println(INVALID_DATE);

        //act
        school.addCourse(new Course(VALID_COURSE_NAME, INVALID_DATE));

        //assert
    }


    @Test
    public void courseCanBeAddedToSchool() throws CourseException{
        //arrange
        School school = new School(VALID_SCHOOL_NAME, VALID_DATE);
        ArrayList<Course> courses = school.getAllCourses();
        int initialSize = courses.size() + 1;
        Course course = new Course(VALID_COURSE_NAME, VALID_DATE, VALID_DATE);
        school.addCourse(course);
        courses = school.getAllCourses();
        int newSize = courses.size();

        //act
        Course returnedCourse = school.getCourseByName(course.getName());

        //assert
        assertEquals("Expected number of elements is" + initialSize + "Reality is " + newSize, initialSize, newSize);
        assertEquals("Expected is course " + course + "reality is" + returnedCourse ,course, returnedCourse);
    }

    //Course begin dates are after the school begin date. Throw a CourseException when it’s wrong.
    @Test(expected = CourseException.class)
    public void courseEndDateIsAfterSchoolDate() throws CourseException {
        //arrange
        School school = new School(VALID_SCHOOL_NAME, VALID_DATE);
        Calendar cal = Calendar.getInstance();
        cal.setTime(VALID_DATE);
        cal.add(Calendar.DATE, -30);
        Date INVALID_DATE = cal.getTime();
        System.out.println(INVALID_DATE);

        //act
        school.addCourse(new Course(VALID_COURSE_NAME, VALID_DATE, INVALID_DATE));

        //assert
    }


}

/*


Course objects function as placeholders for the name of the course, the start date and end date of the course.

You can add a course to the school.


You can get a list of all course names.



 */