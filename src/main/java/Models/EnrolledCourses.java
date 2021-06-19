/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author user
 */
public class EnrolledCourses {
    private int courseId;
    private String userId;
    private String ifDate;
    private String rtDate;

    public EnrolledCourses(int courseId, String userId, String ifDate, String rtDate) {
        this.courseId = courseId;
        this.userId = userId;
        this.ifDate = ifDate;
        this.rtDate = rtDate;
    }

    public int getCourseId() {
        return courseId;
    }    
}
