/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectschedulesystem;

/**
 *
 * @author jit
 */
public class Course {
    
      private String courseName;
    private int courseNumber;
    private String courseRoom;
    private String CourseTeacher;

    public Course(String courseName, int courseNumber, String courseRoom, String CourseTeacher) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.courseRoom = courseRoom;
        this.CourseTeacher = CourseTeacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseRoom() {
        return courseRoom;
    }

    public void setCourseRoom(String courseRoom) {
        this.courseRoom = courseRoom;
    }

    public String getCourseTeacher() {
        return CourseTeacher;
    }

    public void setCourseTeacher(String CourseTeacher) {
        this.CourseTeacher = CourseTeacher;
    }
}
