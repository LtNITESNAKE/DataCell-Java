package DataCell_Department;

public class ConstantVal {
    private static int course=49;
    private static int  Allstudent=100;

    public static void setCourse(int course) {
        ConstantVal.course = course;
    }

    public static void setAllstudent(int allstudent) {
        Allstudent = allstudent;
    }

    public static int getCourse() {
        return course;
    }

    public static int getAllstudent() {
        return Allstudent;
    }
}
