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
public interface ScheduleInterFace {
    
     public void addCourse(int day, int time, Course c);

    public void Display();

    public void ModifiyCourse(Course c, String nameCourseBerfor);
}
