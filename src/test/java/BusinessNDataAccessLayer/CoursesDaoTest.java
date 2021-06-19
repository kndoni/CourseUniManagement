/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessNDataAccessLayer;

import static BusinessNDataAccessLayer.CoursesDaoIT.coursesDao;
import Models.CourseFilter;
import Models.Courses;
import Models.EnrolledCourses;
import PresentationLayer.AddCourseForm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Here we are testing the CourseFilter class which is in the business layer (second layer)
 *so it makes sense to mock the CoursesDao class, because the focus here is not on how 
 *the data access works, but on how the business logic works (how the filtering is done)
 *No need to setup and clean the database! -- this is a unit test!!!
 * @author ndoni
 */
public class CoursesDaoTest {
    
    private CoursesDao coursesDao;
    
    @Test
    public void filterCourses() {

	Courses course1 = new Courses(10,"Calculus 1","Major", "Akli Fundo", "Computer Engineering", "Tue 17:00-19:00", "AC33");
        Courses course2 = new Courses(11,"Calculus 3","Minor", "Denisa Salillari", "Computer Engineering", "Fri 12:00-14:00", "BB19");

	List<Courses> courses = Arrays.asList(course1, course2);

	coursesDao = EasyMock.mock(CoursesDao.class);

	EasyMock.expect(coursesDao.all()).andReturn(courses);
	EasyMock.replay(coursesDao);

	CourseFilter courseFilter = new CourseFilter(coursesDao);
	List<Courses> result = courseFilter.filter(); // method under test

	Assert.assertEquals(course1, result.get(0)); 
	Assert.assertEquals("Calculus 1", result.get(0).getCourseName());
	Assert.assertEquals(course2, result.get(1));
	Assert.assertEquals(2, result.size()); 

    }
    
    @Test
    public void testEnrollingCourse() {
        coursesDao = EasyMock.mock(CoursesDao.class);

	EasyMock.expect(coursesDao.enrolledCourses()).andReturn(new ArrayList<EnrolledCourses>());
	EasyMock.replay(coursesDao);

	CourseFilter courseFilter = new CourseFilter(coursesDao);
	List<EnrolledCourses> result = courseFilter.filterEnrolled();

	Assert.assertEquals(0, result.size());
    }
    
}
