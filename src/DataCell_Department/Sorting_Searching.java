package DataCell_Department;

public class Sorting_Searching {
   public static int searchStudentByID(DataCell department, String studentID)
    {
        for (int i = 0; i < department.getNumStudents(); i++)
        {
            if (department.getStuds()[i].getID().equals(studentID))
            {
                return i;
            }
        }
        return -1;
    }

    void sortStudentsByID(DataCell department)
    {

        for (int i = 0; i < department.getNumStudents() - 1; i++)
        {
            for (int j = 0; j < department.getNumStudents() - i - 1; j++)
            {
                if (department.getStuds()[j].getID().equals( department.getStuds()[j + 1].getID()))
                {

                    Student temp = department.getStuds()[j];
                    department.getStuds()[j] = department.getStuds()[j + 1];
                    department.getStuds()[j + 1] = temp;
                }
            }
        }

    }
}
