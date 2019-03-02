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
public class Schedule implements ScheduleInterFace{
    
         private Course[][] times;

    public Course[][] getTimes() {
        return times;
    }

    public boolean isFoundCourse(int day, int time) {
        if (times[day][time] != null) {
            return true;
        } else {
            return false;
        }
    }

    public void setTimes(Course[][] times) {
        this.times = times;
    }

    public Schedule() {
        this.times = new Course[7][8];
    }

    public void addCourse(int day, int time, Course c) {
        this.times[day][time] = c;

    }

    public void Display() {
        
        String[] days = {"saturday", "sunday","monday" , "tuesday" , "wednesday" , "thursday" , "friday"};
        
        System.out.println("Day / Time :   8-9          9-10         10-11         11-12         12-1         1-2         2-3         3-4");

        for (int i = 0; i < 7; i++) {
            System.out.print(days[i]+" "  + "       :  ");
            for (int j = 0; j < 8; j++) {
                if (times[i][j] != null) {
                    int len = times[i][j].getCourseName().length();
                    System.out.print(times[i][j].getCourseName());
                    for (int k = len; k < 12; k++) {
                        System.out.print(" ");
                    }
                    System.out.print("|");

                } else {
                    for (int k = 0; k < 12; k++) {

                        System.out.print(" ");
                    }
                    System.out.print("|");
                    continue;
                }
            }
            System.out.println("");
        }
    }

    public String getNameCourseInThistime(int day, int time) {
        return times[day][time].getCourseName();
    }

    public void ModifiyCourse(Course c, String nameCourseBerfor) {
        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < times[i].length; j++) {
                if (times[i][j] != null) {
                    if (times[i][j].getCourseName().equals(nameCourseBerfor) == true) {
                        times[i][j] = c;
                    }
                }
            }
        }

    }
}
