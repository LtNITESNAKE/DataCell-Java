package DataCell_Department.Enrollment;


import Utility.ConstantVal;
import Utility.ErrorHandling;
import DataCell_Department.Courses.Courses;
import DataCell_Department.Courses.UniversityCourse;
import Users.DataCell;

public class Enrollment {
  private  String add_date;
  private  String grad_date ;
  private  float fines ;
   private String programtostudy;
   private String degree;
   private int fscmarks, matricmarks;
   private String CNIC;
   private String Email;
   private String D_O_B;
   private String Address;

    public String getAdd_date() {
        return add_date;
    }

    public float getFines() {
        return fines;
    }

    public int getFscmarks() {
        return fscmarks;
    }

    public String getGrad_date() {
        return grad_date;
    }

    public int getMatricmarks() {
        return matricmarks;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    public String getDegree() {
        return degree;
    }

    public String getCNIC() {
        return CNIC;
    }

    public String getProgramtostudy() {
        return programtostudy;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setFines(float fines) {
        this.fines = fines;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public void setGrad_date(String grad_date) {
        this.grad_date = grad_date;
    }

    public void setProgramtostudy(String programtostudy) {
        this.programtostudy = programtostudy;
    }

    public String getAddress() {
        return Address;
    }

    public String getD_O_B() {
        return D_O_B;
    }

    public String getEmail() {
        return Email;
    }

    public void setFscmarks(int fscmarks) {
        this.fscmarks = fscmarks;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setMatricmarks(int matricmarks) {
        this.matricmarks = matricmarks;
    }

    public void setD_O_B(String d_O_B) {
        D_O_B = d_O_B;
    }

    public void setEmail(String email) {
        Email = email;
    }

    boolean canEnroll(Student student, UniversityCourse course) {
        for (int i = 0; i < ConstantVal.getCourse(); ++i) {
            if (course.getCourse_codes().equals(student.Course[i].getCourse_codes())) {
                return student.Course[i].isPrerequisite_completed();
            }
        }
        return true;
    }


    public void enrollInUniversityCourse(DataCell dataCell, Student student) {

        UniversityCourse.displayUniversityCourses(dataCell);

        String courseCode = ErrorHandling.promptString("Enter the course code to enroll: ");

        for (int i = 0; i < ConstantVal.getCourse(); ++i) {
            if (student.Course[i] != null && courseCode.equals(dataCell.UnivCourses[i].getCourse_codes())) {

                if (student.Course[i] == null) {
                    student.Course[i] = new Courses();
                }


                if (canEnroll(student, dataCell.UnivCourses[i])) {
                    UniversityCourse course = dataCell.UnivCourses[i];


                    student.Course[i].setCourse_names(course.getCourse_names());
                    student.Course[i].setCourse_codes(course.getCourse_codes());
                    student.Course[i].setCredit_hours(course.getCredit_hours());
                    student.Course[i].setPrerequisite_course(course.getPrerequisite_course());

                    float totalMidTermMarks = ErrorHandling.promptFloat("Enter Total Marks for Mid-Term: ");
                    student.Course[i].setMidTermMarks(ErrorHandling.promptFloat("Enter Obtained Marks for Mid-Term: "));

                    float totalLabMarks = ErrorHandling.promptFloat("Enter Total Marks for Lab: ");
                    student.Course[i].setLabMarks(ErrorHandling.promptFloat("Enter Obtained Marks for Lab: "));

                    float totalFinalExamMarks = ErrorHandling.promptFloat("Enter Total Marks for Final Exam: ");
                    student.Course[i].setFinalExamMarks(ErrorHandling.promptFloat("Enter Obtained Marks for Final Exam: "));

                    Student.calculateGrades(dataCell, i, totalMidTermMarks, totalLabMarks, totalFinalExamMarks);

                    if (student.Course[i].getGrades() == 'F' || student.Course[i].getGrades() == 'f') {
                        System.out.println("You can't enroll in " + course.getCourse_names() +
                                " because you have failed this course previously.");
                        student.Course[i].setPrerequisite_completed(false);
                        return;
                    }
                    else {
                        student.Course[i].setPrerequisite_completed(true);
                    }

                    System.out.println("Enrolled in " + course.getCourse_names());
                }
            }
        }
    }


}
