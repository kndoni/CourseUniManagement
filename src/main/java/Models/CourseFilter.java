/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import BusinessNDataAccessLayer.CoursesDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class CourseFilter {
    private CoursesDao coursesDao;

    public CourseFilter(CoursesDao coursesDao) {
	this.coursesDao = coursesDao;
    }

    public List<Courses> filter() {

	List<Courses> allCourses = coursesDao.all();

	List<Courses> filtered = new ArrayList<Courses>();

	for (Courses course : allCourses) {
	    if (course.getCourseID() >= 1)
		filtered.add(course);
	}

	return filtered;

    }
}
