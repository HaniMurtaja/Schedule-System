/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectschedulesystem;


public class Student extends Person implements StudentInterface {
    
     private int stdId;
    private int stdLevel;
    private String college;

    private Schedule schedule ;

    public Student(int stdId, int stdLevel, String college, String firstName, String lastName) {
        super(firstName, lastName);
        this.stdId = stdId;
        this.stdLevel = stdLevel;
        this.college = college;
        this.schedule = new Schedule();
   
    
}
     public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public int getStdLevel() {
        return stdLevel;
    }

    public void setStdLevel(int stdLevel) {
        this.stdLevel = stdLevel;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
    
    public void AddCourseInSchedule(int day , int time,Course c){
        this.schedule.addCourse(day, time, c);
    }



    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    public void DeleteSchedule(){
        schedule = null;
    }
    
}
