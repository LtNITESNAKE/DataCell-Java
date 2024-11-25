package Utility;

import DataCell_Department.Courses.Courses;
import DataCell_Department.Enrollment.Enrollment;
import DataCell_Department.TASKMANAGER.Menu;
import DataCell_Department.Enrollment.Student;

public class CallAllClasses {
 private final Student s=new Student();
 private final Menu m=new Menu();
 private final Enrollment e=new Enrollment();

 private final Courses c=new Courses();

    public Courses getC() {
        return c;
    }

    public Enrollment getE() {
        return e;
    }

    public Student getS() {
        return s;
    }

    public Menu getM() {
        return m;
    }
}
