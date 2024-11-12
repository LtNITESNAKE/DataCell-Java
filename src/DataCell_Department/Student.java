package DataCell_Department;

import java.util.Scanner;

public class Student {
    private String ID;
    private String name;
    private String contact;
  private   float gpa;
   private  float cgpa;
   private  float fees;
    private float fines;
    Enrollment enroll;


    final Courses []Course=new Courses[ConstantVal.getCourse()];
    void addStudent(DataCell dataCell,  Student  newStudent)
    {
        // Check if the student with the same ID already exists
        int existingIndex = Sorting_Searching.searchStudentByID(dataCell, newStudent.ID);

        if (existingIndex != -1)
        {
            System.out.println(STR."Student with ID \{newStudent.ID} already exists.");
            dataCell.getStuds()[existingIndex] = newStudent;
        }
        else {
            // Check if there's enough space, and if not, increase size
            if (dataCell.getNumStudents() >= dataCell.getMaxStudents())
            {
                int newSize = dataCell.getMaxStudents() + 10;
                Student[] newStudents = new Student[newSize];
                for (int i = 0; i < dataCell.getNumStudents(); i++)
                {
                    newStudents[i] = dataCell.getStuds()[i];
                }
                newStudents[dataCell.getNumStudents()+1] = newStudent;
                // Update the DataCell with the new array and size
                dataCell.setStuds(newStudents);
                dataCell.setMaxStudents(newSize);
                System.out.println("Studnt added successfully." );
            }
            else {
                // Enough space, add the new student
                dataCell.getStuds()[dataCell.getNumStudents()+1] = newStudent;
                System.out.println( "Student added successfully." );
            }
        }
    }

    void updateStudentInfo(DataCell department, int index)
    {
        Scanner cin=new Scanner(System.in);
        int choice=0;
        do {
            System.out.println("what information would you like to update?" );
            System.out.println("1. GPA" );
            System.out.println("2. Contact Number");
            System.out.println( "3. Fee");
            System.out.println("4. Email " );
            System.out.println("5. Address ");
            System.out.println("6. Exit Updating Section " );
            System.out.println("Enter your choice: ");

            choice=cin.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println( "Enter new GPA: ");
                    department.getStuds()[index].gpa= cin.nextFloat();
                    break;
                case 2:
                    System.out.println("Enter new Contact Number: ");

                     department.getStuds()[index].contact=cin.nextLine();
                    break;
                case 3:
                    System.out.println( "Enter new Fee: ");
                     department.getStuds()[index].fees=cin.nextFloat();
                    break;
                case 4:
                    System.out.println( "Enter new Email: ");

                    department.getStuds()[index].enroll.setEmail(cin.nextLine());
                    break;
                case 5:
                    System.out.println( "Enter new Address: ");
                     department.getStuds()[index].enroll.setAddress(cin.nextLine());
                    break;
                default:
                    System.out.println("Invalid choice." );
            }
        } while (choice != 6);
    }

  public  void calculateGrades(DataCell deparment, int index,int totalMidTermMarks, int totalLabMarks, int totalFinalExamMarks) {
        int total = totalFinalExamMarks + totalLabMarks + totalMidTermMarks;
        float obtained = deparment.getStuds()[index].Course[index].getFinalExamMarks() + deparment.getStuds()[index].Course[index].getMidTermMarks() + deparment.getStuds()[index].Course[index].getLabMarks();
        float percentage = ((float)obtained / total) * 100;
        if (percentage >= 89 && percentage <= 100)
        {
            deparment.getStuds()[index].Course[index].setGrades('A');
        }
        else if (percentage >= 79 && percentage <89)
        {
            deparment.getStuds()[index].Course[index].setGrades('B');
        }
        else if (percentage >= 69 && percentage <79)
        {
            deparment.getStuds()[index].Course[index].setGrades('C');
        }
        else if (percentage >= 50 && percentage <69)
        {
            deparment.getStuds()[index].Course[index].setGrades('D');
        }
        else if ( percentage <50)
        {
            deparment.getStuds()[index].Course[index].setGrades('F');;
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

    public void setGpa(float gpa) {
        this.gpa = gpa;
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

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
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

    public void setEnroll(Enrollment enroll) {
        this.enroll = enroll;
    }
}
