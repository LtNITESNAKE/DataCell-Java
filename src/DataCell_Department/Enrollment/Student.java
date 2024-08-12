package DataCell_Department.Enrollment;

import DataCell_Department.Courses.Courses;
import Users.DataCell;
import Utility.ConstantVal;
import Utility.ErrorHandling;
import Utility.Sorting_Searching;

public class Student {
    private String ID;
    private String name;
    private String contact;
  private   float gpa;
   private  float cgpa;
   private  float fees;
    private float fines;
    Enrollment enroll=new Enrollment();

    public  Courses[]Course=new Courses[ConstantVal.getCourse()];

    public Student() {
        for (int i = 0; i < Course.length; i++) {
            Course[i] = new Courses();
        }
    }
    public static void addStudent(DataCell dataCell, Student newStudent) {

        int existingIndex = Sorting_Searching.searchStudentByID(dataCell, newStudent.getID());

        if (existingIndex != -1) {
            System.out.println("Student with ID " + newStudent.getID() + " already exists.");
            dataCell.getStuds()[existingIndex] = newStudent;
        } else {
            // Check if there's enough space, and if not, increase size
            if (dataCell.getNumStudents() >= dataCell.getMaxStudents()) {
                int newSize = dataCell.getMaxStudents() + 10;
                Student[] newStudents = new Student[newSize];
                for (int i = 0; i < dataCell.getNumStudents(); i++) {
                    newStudents[i] = dataCell.getStuds()[i];
                }
                newStudents[dataCell.getNumStudents()] = newStudent;
                // Update the DataCell with the new array and size
                dataCell.setStuds(newStudents);
                dataCell.setMaxStudents(newSize);
                System.out.println("Student added successfully.");
            } else {
                // Enough space, add the new student at the next available index
                dataCell.getStuds()[dataCell.getNumStudents()] = newStudent;
                // Increment the count of students
                dataCell.setNumStudents(dataCell.getNumStudents() + 1);
                System.out.println("Student added successfully.");
            }
        }
    }



    public void updateStudentInfo(DataCell department, int index)
    {

        int choice;
        do {
            System.out.println("what information would you like to update?" );
            System.out.println("1. GPA" );
            System.out.println("2. Contact Number");
            System.out.println( "3. Fee");
            System.out.println("4. Email " );
            System.out.println("5. Address ");
            System.out.println("6. Exit Updating Section " );


            choice=ErrorHandling.promptInt("Enter your Choice: ");

            switch (choice)
            {
                case 1:

                    department.getStuds()[index].setGpa(ErrorHandling.promptFloat("Enter new GPA:"));
                    break;
                case 2:

                    department.getStuds()[index].setContact(ErrorHandling.promptString("Enter new Contact Number:"));
                    break;
                case 3:

                    department.getStuds()[index].setFees(ErrorHandling.promptFloat("Enter new Fee:"));
                    break;
                case 4:

                    department.getStuds()[index].getEnroll().setEmail(ErrorHandling.promptString("Enter new Email:"));
                    break;
                case 5:

                    department.getStuds()[index].getEnroll().setAddress(ErrorHandling.promptString("Enter new Address:"));
                    break;
                default:
                    System.out.println("Invalid choice." );
            }
        } while (choice != 6);
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }



    public void manageFees(DataCell department, int index) {
        System.out.println("Current fees: RS" + department.getStuds()[index].getFees());
        float paymentAmount = ErrorHandling.promptFloat("Enter payment amount:");


        if (paymentAmount > department.getStuds()[index].getFees()) {
            System.out.println("Payment amount exceeds current fees. Please enter a valid amount.");
            manageFees(department, index);
            return;
        }

        department.getStuds()[index].setFees(department.getStuds()[index].getFees() - paymentAmount);
        System.out.println("Fees managed successfully. Remaining fees: RS" + department.getStuds()[index].getFees());
    }

    public void manageFines(DataCell department, int index) {
        System.out.println("Current fines: RS" + department.getStuds()[index].getFines());
        float fineAmount = ErrorHandling.promptFloat("Enter fine amount:");


        if (fineAmount > department.getStuds()[index].getFines()) {
            System.out.println("Fine amount exceeds current fines. Please enter a valid amount.");
            manageFines(department, index);
            return;
        }

        department.getStuds()[index].setFines(department.getStuds()[index].getFines() - fineAmount);
        System.out.println("Fines managed successfully. Remaining fines: RS" + department.getStuds()[index].getFines());
    }

    public static void calculateGrades(DataCell department, int index, float totalMidTermMarks, float totalLabMarks, float totalFinalExamMarks) {

        if (department.getStuds() != null && index >= 0 && index < department.getNumStudents()) {
            Student student = department.getStuds()[index];

            float obtained = student.Course[index].getFinalExamMarks() + student.Course[index].getMidTermMarks() + student.Course[index].getLabMarks();

            float total = totalFinalExamMarks + totalLabMarks + totalMidTermMarks;
            float percentage = (obtained / total) * 100;

            if (percentage >= 89 && percentage <= 100) {
                student.Course[index].setGrades('A');
            } else if (percentage >= 79 && percentage < 89) {
                student.Course[index].setGrades('B');
            } else if (percentage >= 69 && percentage < 79) {
                student.Course[index].setGrades('C');
            } else if (percentage >= 50 && percentage < 69) {
                student.Course[index].setGrades('D');
            } else if (percentage < 50) {
                student.Course[index].setGrades('F');
            }

        }else {
            System.out.println("Invalid index or studs array is not initialized.");
        }

    }



    public void calculateGPA(Student student) {
        float totalCreditHours = 0;
        float totalGradePoints = 0;

        for (int i = 0; i < ConstantVal.getCourse(); i++) {
            int creditHours = student.Course[i].getCredit_hours();
            totalCreditHours += creditHours;
            int gradePoints = ErrorHandling.promptInt("Enter Grade points for course " + (i + 1) + ": ");

            totalGradePoints += (gradePoints * creditHours);
        }

        student.setGpa(totalGradePoints / totalCreditHours);
    }

    public void calculateCGPA(DataCell department, int index) {
        int totalCreditHours = 0;
        int totalGradePoints = 0;

        for (int i = 0; i < ConstantVal.getCourse(); i++) {
            int creditHours = department.getStuds()[index].Course[i].getCredit_hours();
            totalCreditHours += creditHours;
            int gradePoints = ErrorHandling.promptInt("Enter Grade points for course " + (i + 1) + ": ");

            totalGradePoints += (gradePoints * creditHours);
        }

        department.getStuds()[index].setCgpa((float) totalGradePoints / totalCreditHours);
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }



    public void Studentdetails(DataCell department, int index) {
        System.out.println("------- Student Details -------");

        department.getStuds()[index].enroll.setEmail(ErrorHandling.promptString("Enter Student Email:"));

        department.getStuds()[index].enroll.setD_O_B(ErrorHandling.promptString("Enter Student Date of Birth:"));

        department.getStuds()[index].enroll.setAddress(ErrorHandling.promptString("Enter Student Address:"));

        char choice;

        choice = ErrorHandling.promptChar("Is the student graduated? (Enter 'y' for Yes, 'n' for No)");

        if (choice == 'y' || choice == 'Y') {

            department.getStuds()[index].enroll.setGrad_date(ErrorHandling.promptString("Enter Graduation Date:"));
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGpa() {
        return gpa;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public float getCgpa() {
        return cgpa;
    }

    public float getFines() {
        return fines;
    }

    public void setFines(float fines) {
        this.fines = fines;
    }

    public float getFees() {
        return fees;
    }

    public void setFees(float fees) {
        this.fees = fees;

    }

    public Enrollment getEnroll() {
        return enroll;
    }

}
