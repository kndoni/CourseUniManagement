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
public class Courses {
    private int CourseID;
    private String CourseName;
    private String Program;
    private String Instructor;
    private String Major;
    private String Schedule;
    private String Location;

    public Courses(int CourseID, String CourseName, String Program, String Instructor, String Major, String Schedule, String Location) {
        this.CourseID = CourseID;
        this.CourseName = CourseName;
        this.Program = Program;
        this.Instructor = Instructor;
        this.Major = Major;
        this.Schedule = Schedule;
        this.Location = Location;
    }  

    public int getCourseID() {
        return CourseID;
    }
    
    public String getCourseName() {
        return CourseName;
    }

    public String getMajor() {
        return Major;
    } 

    public String getInstructor() {
        return Instructor;
    }

    public String getProgram() {
        return Program;
    }

    public String getSchedule() {
        return Schedule;
    }

    public String getLocation() {
        return Location;
    }
  
}
