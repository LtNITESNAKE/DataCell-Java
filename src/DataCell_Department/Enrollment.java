package DataCell_Department;

import java.sql.SQLOutput;

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
            if (course.getCourse_codes() == student.Course[i].getPrerequisite_course()) {
                return student.Course[i].isPrerequisite_completed();
            }
        }
        return true;
    }
    void enrollInUniversityCourse(DataCell dataCell, Student student) {
        UniversityCourse.displayUniversityCourses(dataCell);
Menu scanner=new Menu();
        System.out.println( "Enter the course code to enroll: ");
        String courseCode;
        courseCode=scanner.scanner.next();

        for (int i = 0; i < ConstantVal.getCourse(); ++i) {
            if (courseCode.equals(dataCell.UnivCourses[i].getCourse_codes())) {
                // Check prerequisites
                if (canEnroll(student, dataCell.UnivCourses[i])) {
                    System.out.println( "Enrolled in " + dataCell.UnivCourses[i].getCourse_names());
                    student.Course[i].setCourse_names(dataCell.UnivCourses[i].getCourse_names());
                    student.Course[i].setCourse_codes(dataCell.UnivCourses[i].getCourse_codes());
                    student.Course[i].setCredit_hours( dataCell.UnivCourses[i].getCredit_hours());
                    student.Course[i].setPrerequisite_course( dataCell.UnivCourses[i].getPrerequisite_course());

                    System.out.println("entering grading system----");

                    System.out.println( "enter mid lab and finals marks of " << student.Course[i].prerequisite_course << endl;

                    cout << "Enter Total Marks for Mid-Term: ";
                    float totalMidTermMarks;
                    cin >> totalMidTermMarks;

                    cout << "Enter Obtained Marks for Mid-Term: ";
                    cin >> student.Course[i].midTermMarks;

                    cout << "Enter Total Marks for Lab: ";
                    float totalLabMarks;
                    cin >> totalLabMarks;

                    cout << "Enter Obtained Marks for Lab: ";
                    cin >> student.Course[i].labMarks;

                    cout << "Enter Total Marks for Final Exam: ";
                    float totalFinalExamMarks;
                    cin >> totalFinalExamMarks;

                    cout << "Enter Obtained Marks for Final Exam: ";
                    cin >> student.Course[i].finalExamMarks;

                    // Calculate grades based on obtained marks and total marks
                    calculateGrades(dataCell , i, totalMidTermMarks, totalLabMarks, totalFinalExamMarks);

                    // Check prerequisite completion
                    if (student.Course[i].grades == 'F' || student.Course[i].grades == 'f') {
                        cout << "You can't enroll in " << dataCell.studs[i].Course[i].course_names
                                << " because you have failed this course previously." << endl;
                        dataCell.studs[i].Course[i].prerequisite_completed = false;
                        return;
                    }

                    cout << "Enrolled in " << dataCell.UnivCourses[i].course_names << endl;
                }
            }
        }

    }

}
