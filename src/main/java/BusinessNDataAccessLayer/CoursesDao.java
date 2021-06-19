package BusinessNDataAccessLayer;

import Models.Courses;
import Models.EnrolledCourses;
import java.sql.*;
import PresentationLayer.DB;
import PresentationLayer.MainPage;
import java.util.ArrayList;
import java.util.List;

public class CoursesDao {

    public static String major = MainPage.Major;

    public static boolean checkBook(String courselno) {
        boolean status = false;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from courses where CourseID=?");
            ps.setString(1, courselno);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public List<Courses> all() {

        List<Courses> allCourses = new ArrayList<Courses>();

        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from courses");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int courseID = rs.getInt("CourseID");
                String courseName = rs.getString("CourseName");
                String program = rs.getString("Program");
                String instructor = rs.getString("Instructor");
                String major = rs.getString("Major");
                String schedule = rs.getString("Schedule");
                String location = rs.getString("Location");
                allCourses.add(new Courses(courseID, courseName, program, instructor, major, schedule, location));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allCourses;

    }
    
    public List<EnrolledCourses> enrolledCourses() {

        List<EnrolledCourses> enrollCourses = new ArrayList<EnrolledCourses>();

        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from enrollcourses");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int courseID = rs.getInt("CourseID");
                String userID = rs.getString("UserID");
                String issueDate = rs.getString("IssueDate");
                String returnDate = rs.getString("ReturnDate");    
                enrollCourses.add(new EnrolledCourses(courseID, userID, issueDate, returnDate));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enrollCourses;

    }

    public void save(Courses course) {
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into courses (CourseID, CourseName, Program, Instructor, Major, Schedule, Location) values (?,?,?,?,?,?,?)");
            ps.setInt(1, course.getCourseID());
            ps.setString(2, course.getCourseName());
            ps.setString(3, course.getProgram());
            ps.setString(4, course.getInstructor());
            ps.setString(5, course.getMajor());
            ps.setString(6, course.getSchedule());
            ps.setString(7, course.getLocation());

            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean CourseValidate(String CourseID) {
        boolean status = false;
        try (Connection con = DB.getConnection()) {
            System.out.println("ID qe vjen: " + CourseID);
            System.out.println("Major e perdoruesit: " + major);
            PreparedStatement ps = con.prepareStatement("select * from courses where CourseID = ? and Major='" + MainPage.Major + "'");
            ps.setString(1, CourseID);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            System.out.println("Gjendja statusit: " + status);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Gjendja statusit: " + status);
        return status;
    }

    public static boolean UserValidate(String LoginID) {
        boolean status = false;
        try (Connection con = DB.getConnection()) {
            System.out.println("ID qe vjen: " + LoginID);
            PreparedStatement ps = con.prepareStatement("select * from login where LoginID = ?");
            ps.setString(1, LoginID);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            System.out.println("Gjendja statusit: " + status);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int EnrollingCourse(int CourseID, String LoginID, String IDate, String RDate) {
        int status = 0;
        try {

            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into enrollcourses values(?,?,?,?)");
            ps.setInt(1, CourseID);
            ps.setString(2, LoginID);
            ps.setString(3, IDate);
            ps.setString(4, RDate);
            status = ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public List<Courses> getOrderedCourses() {
        List<Courses> allCourses = new ArrayList<Courses>();
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM courses ORDER BY CourseID");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int courseId= rs.getInt("CourseID");
                String courseName = rs.getString("CourseName");
                String program = rs.getString("Program");
                String instructor = rs.getString("Instructor");
                String major = rs.getString("major");
                String schedule = rs.getString("Schedule");
                String location = rs.getString("Location");

                allCourses.add(new Courses(courseId,courseName, program, instructor, major, schedule, location));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allCourses;
    }

    public static int DropingCourse(int CourseID, String LoginID) {
        int status = 0;
        try {

            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from enrollcourses where CourseID=? and UserID=?");
            ps.setInt(1, CourseID);
            ps.setString(2, LoginID);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static boolean CheckEnrollCourses(int CourseID) {
        boolean status = false;
        try (Connection con = DB.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from enrollcourses where CourseID=?");
            ps.setInt(1, CourseID);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

//    public static int Check(String LoginID) {
//        boolean status = false;
//        int num = 0;
//        try (Connection con = DB.getConnection()) {
//            PreparedStatement ps = con.prepareStatement("select * from course_count where UserID=?");
//            ps.setString(2, LoginID);
//            ResultSet rs = ps.executeQuery();
//            status = rs.next();
//            num = rs.getInt("CourseNo"); 
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//         System.out.println("Vlera numrit  "+ num);
//        if (num == 5) {
//            return 0;
//        } else {
//            return 1;
//        }
//    }

    public static Connection getC() {
        Connection con = DB.getConnection();
        return con;
    }

}
