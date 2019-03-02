/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectschedulesystem;

 import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectScheduleSystem {
     private static void print(String x) {
        System.out.println(x);
    }

    static Scanner in = new Scanner(System.in);
    static List<Student> Students = new ArrayList();

    static int count = -1;
    static int isPlusCours = 0;
    static boolean isCreate = false;

  
    public static void main(String[] args) {
         while (true) {

        System.out.println("Welcome to the Department of Admission and Registration at the Islamic University of Gaza");
        System.out.println("1.Create Schedule form \n 2. Display Schedule form\n" + "3. Modify Schedule form\n" + "4. Delete Schedule form\n" + "5. Exit");

           char ch = in.next().toLowerCase().charAt(0);

            switch (ch) {
                case '1': {
                    int h = Create();
                    break;
                }
                case '2': {
                    if (isCreate == true) {

                        Students.get(count).getSchedule().Display();

                        break;
                    } else {
                        System.out.println("Dont enter any  inform. now");
                        break;
                    }
                }
                case '3': {
                    Modify();
                    break;
                }
                case '4': {
                    Delete();
                    break;
                }
                case '5': {
                    System.exit(0);

                }
                default: {
                     System.out.println("Error chosen .... Try Agine !!");
                    break;
                }
            }
        }
    }

    public static int Create() {
        System.out.println("Enter the First Name : ");
        String firstName = in.next();
        
         System.out.println("Enter the Last  Name : ");
        String lastName = in.next();

         System.out.println("Enter Student ID : ");
        int stdId = in.nextInt();

         System.out.println("Enter Student Level : ");
        int stdLevel = in.nextInt();

         System.out.println("Enter Student College :");
        String stdCollege = in.next();

        System.out.println("Enter Course Name : ");
        String courseName = in.next();

        System.out.println("Enter Course Number : ");
        int courseNumber = in.nextInt();

        System.out.println("Enter Course Room : ");
        String courseRoom = in.next();

        System.out.println("Enter Course Teacher : ");
        String courseTeacher = in.next();

     
       for (int i = 0; i < Students.size(); i++) {
           if (Students.get(i).getStdId() == stdId) {
                 System.out.println("This User Name Is Already exists .... choose another one ");
                 System.out.println("Do You want to Delete Scdeule OR Add Course choose one of them 'Delete' 'Add' ");

            String chOp = in.next().toLowerCase();
                    switch (chOp) {
                        case "delete": {
                            Students.remove(count);
                            return -1;
                        }
                        case "add": {
                            isPlusCours = 1;
                            break;
                        }
                    }

                    break;
                } else {
                    isPlusCours = 0;
                }
            }
        

        System.out.println("Do You want to confirma and save the schedule?  if you sure choose 'create' OR 'cancel'  ");
        String isSure = in.next().toLowerCase();

        switch (isSure) {
            case "create": {

             if (isPlusCours == 0) {
                 Students.add(new Student(stdId, stdLevel, stdCollege, firstName, lastName));
                  isCreate = true;
                  isPlusCours = 1;
                  count = count + 1;

                }

              for (int i = 0; i < Students.size(); i++) {
                   if (Students.get(i).getStdId() == stdId) {

                     count = i;
                      break;

                    }
                }
     Course c1 = new Course(courseName, courseNumber, courseRoom, courseTeacher);

            System.out.println("Enter the Days you want.... remark : you can choose ' 1 Or 2 Or 3 days only ");
              int days[][] = ChosessDay(c1);

                break;
            }

          case "cancel": {
              int idUser = -1;
              for (int i = 0; i < Students.size(); i++) {
                 if (Students.get(i).getStdId() == stdId) {

                        idUser = i;
                        break;

                    }
                }
                count = idUser;
                return idUser;
            }

            default: {

                break;
            }
        }

        return -1;
    }

    private static int[][] ChosessDay(Course c1) {
        System.out.println("How Many Days you want to take ?");
        int howDaysForCourse = 0;
        for (int i = 0; i < 10; i++) {
            howDaysForCourse = in.nextInt();
            if (howDaysForCourse > 4 || howDaysForCourse < 1) {
                System.out.println("Error! Pleas Enter 3 days ");
                i = i - 1;
            } else {
                i = 10;
                break;
            }
        }

        int m[][] = new int[howDaysForCourse][2];

        for (int i = 0; i < howDaysForCourse; i++) {
            System.out.println("Enter The : " + (i + 1) + " Day 'saturday , sunday , monday , thuesday , wednesday , thursday , friday ' ");
            String day = in.next().toLowerCase();

           if (HowDay(day) >= 0 && HowDay(day) <= 8) {

              if ((day.equals("thu") == false) && (day.equals("fri") == false)) {
                   System.out.println("Please Choses Hours For this Course : \" 08:00 , 09:00 , 10:00  .....  04:00 ");
                    int hour = in.nextInt();
                    System.out.println("Hour =  " + hour + " :00");

                  m[i][0] = HowDay(day);

            if (hour == 8 || hour == 9 || hour == 10 || hour == 11 || hour == 12 || hour == 1 || hour == 2 || hour == 3 || hour == 4) {


                   System.out.println("Hour =  " + hour + " :00");
                        m[i][0] = HowDay(day);

                    if (hour < 5) {
                         m[i][1] = (hour + 12) - 8;
                     } else {
                        m[i][1] = HowmanyHour(hour);
                        }

                 if (isPlusCours == 0) {
                        Students.get(count).getSchedule().addCourse(m[i][0], m[i][1], c1);
                        } else {
                           if (Students.get(count).getSchedule().isFoundCourse(m[i][0], m[i][1]) == true) {
                           if (Students.get(count).getSchedule().isFoundCourse(m[i][0], m[i][1]) == true) {
                               System.out.println("Error Add Coure in This Time ");
                                System.out.println("IF You Delete The Last Cours : " + Students.get(count).getSchedule().getNameCourseInThistime(m[i][0], m[i][1]));
                                System.out.println("And Add The : " + c1.getCourseName() + " In This Time ... Yes OR No");

              String replace = in.next().toLowerCase();
                            switch (replace) {
                                case "yes": {
                                    
                                            Students.get(count).getSchedule().addCourse(m[i][0], m[i][1], c1);
                                            break;
                                        }
                                        case "no": {
                                            
                                            i = i - 1;
                                            break;
                                        }
                                        default: {
                                            System.out.println("Error Chosen !");
                                            i = i - 1;
                                            break;
                                        }
                                    }

                                }
                            } else {
                                Students.get(count).getSchedule().addCourse(m[i][0], m[i][1], c1);
                            }
                        }

                 
 
                    } else {
                        System.out.println("Error Chose Hour please Selcet from 8 to 4 ..");
                        i = i - 1;
                    }

                } else {
                    System.out.println("This Day is Not used . Are You Sure? .... \" yer Or No \"  ");
                    String isSureCh = in.next().toLowerCase();
                    
                    switch (isSureCh) {
                        case "yes": {
                            System.out.println("Please Choses Hours For Course : \" 08:00  09:00  10:00  .....  04:00 ");
                            int hour = in.nextInt();

                         if (hour == 8 || hour == 9 || hour == 10 || hour == 11 || hour == 12 || hour == 1 || hour == 2 || hour == 3 || hour == 4) {
                            System.out.println("Hour =  " + hour + " :00");

                            if (HowDay(day) >= 0 && HowDay(day) <= 8) {
                                 m[i][0] = HowDay(day);

                              } else {
                                    System.out.println("Error Chosen Day , Correct the input");
                                    i = i - 1;
                                   break;
                              }

               if (hour < 5) {
                   m[i][1] = (hour + 12) - 8;
                                } else {
                                    m[i][1] = hour - 8;
                                }

                             
          if (isPlusCours == 0) {
              Students.get(count).getSchedule().addCourse(m[i][0], m[i][1], c1);
                                } else {
                                    if (Students.get(count).getSchedule().isFoundCourse(m[i][0], m[i][1]) == true) {
                                        System.out.println("Error Add Coure in This Time ");
                                        System.out.println("IF You Delete The Last Cours : " + Students.get(count).getSchedule().getNameCourseInThistime(m[i][0], m[i][1]));
                                        System.out.println("And Add The : " + c1.getCourseName() + " In This Time ... Yes OR No");

                    String replace = in.next().toLowerCase();
                              switch (replace) {
                                         case "yes": {
                                             
                                                Students.get(count).getSchedule().addCourse(m[i][0], m[i][1], c1);
                                                break;
                                            }
                                            case "no": {
                                                
                                                i = i - 1;
                                                break;
                                            }
                                            default: {
                                                System.out.println("Error input ! ");
                                                i = i - 1;

                                            }
                                        }

                                    } else {
                                        Students.get(count).getSchedule().addCourse(m[i][0], m[i][1], c1);
                                    }
                                }

                             
                            } else {

                                System.out.println("Error Chosen Hour ,you can  Selcet just in the period from 8 to 4 ");
                                i = i - 1;
                            }

                            break;
                        }
                        case "no": {

                            i = i - 1;
                            break;
                        }
                        default: {
                             System.out.println("Error Choes , Try agine");
                            i = i - 1;
                            break;
                        }
                    }
                }
            } else {
                 System.out.println("Error Chosen , Try agine ");
                i = i - 1;
                
            }
        }
        for (int i = 0; i < howDaysForCourse; i++) {
            System.out.println("Day : " + m[i][0] + " Houre : " + m[i][1]);
            
        }
        return m;
    }

    public static int HowDay(String h) {
        switch (h) {
            
            case "saturday": {return 0;}
            case "sunday": {return 1;}
            case "monday": {return 2;}
            case "tuesday": {return 3;}
            case "wednesday": {return 4;}
            case "thursday": {return 5;}
            case "friday": {return 6;}
            default: {return -1;}
        }
    }

    public static void Modify() {
        
        boolean isFound = false;
        
        if (isCreate == true) {

            System.out.println("Enter Course Name : ");
            String nameCourse = in.next();
            
  Course courses[][] = Students.get(count).getSchedule().getTimes();
  
        for (int i = 0; i < courses.length; i++) {
                
           for (int j = 0; j < courses[i].length; j++) {
                    
            if (courses[i][j] != null) {
                        
           if (courses[i][j].getCourseName().equals(nameCourse) == true) {
               
                 System.out.println("Enter the new  Course Name : ");
                            String newcourseName = in.next(); 
                            
               System.out.println("Enter the new Course Number : ");
                            int newcourseNumber = in.nextInt();
                            
                System.out.println("Enter New Ciurse Room : ");
                            String newcourseRoom = in.next();

                System.out.println("Enter New Course Teacher : ");
                            String newcourseTeacher = in.next();
                            
                            
                isFound = true;
          Course c = new Course(newcourseName, newcourseNumber, newcourseRoom, newcourseTeacher);
          Students.get(count).getSchedule().ModifiyCourse(c, nameCourse);
          
            Students.get(count).getSchedule().Display();
            break;

             }
                }
                             
           }      
          
            }
        } else {
            System.out.println("Error!! you did not entered new  Create operation yet .... ");
        }
        if (isFound == false) {
            System.out.println("Error!! the Course you entered is Not Found , try again ...");
        }
    }

    public static void Delete() {

        if (isCreate == true) {

            Students.get(count).DeleteSchedule();
            
            System.out.println("Sucsusfull Delete ");
            isCreate = false;

        } else {
            System.out.println("Error Delete operation  Because there is No  Create operation entered yet.... ");
        }
    }

    public static int HowmanyHour(int hour) {
        if (hour == 1 || hour == 2 || hour == 3) {
            return ((hour + 12) - 8);

        }
        return hour - 8;

    }
    
}
