package Users;

import Utility.ConstantVal;
import DataCell_Department.Enrollment.Student;
import DataCell_Department.Courses.UniversityCourse;

public class DataCell {
   private Student[]studs;
   private   int numStudents;
   private int maxStudents;
    public UniversityCourse[]UnivCourses=new UniversityCourse[ConstantVal.getCourse()];


    public int getMaxStudents() {
        return maxStudents;
    }

    public  int getNumStudents() {
        return numStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public Student[] getStuds() {
        return studs;
    }

    public void setStuds(Student[] studs) {
        this.studs = studs;
    }

    static DataCell inDataCell() {
        DataCell dataCell = new DataCell();
        dataCell.studs = new Student[ConstantVal.getAllstudent()];
        dataCell.numStudents = 0;
        dataCell.maxStudents = ConstantVal.getAllstudent();
        return dataCell;
    }
    public Student findStudentByID(String studentID) {
        for (Student student : studs) {
            if (student != null && student.getID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }
    public void addUniversityCourse(UniversityCourse course) {
        for (int i = 0; i < UnivCourses.length; i++) {
            if (UnivCourses[i] == null) {
                UnivCourses[i] = course;
                return;
            }
        }
        System.out.println("Cannot add university course. Array is full.");
    }

    public UniversityCourse getUniversityCourse(String courseCode) {
        for (UniversityCourse course : UnivCourses) {
            if (course != null && course.getCourse_codes().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

}
