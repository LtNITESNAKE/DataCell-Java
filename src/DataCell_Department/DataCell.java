package DataCell_Department;

public class DataCell {
   private Student []studs;
   private   int numStudents;
   private int maxStudents;
    UniversityCourse []UnivCourses=new UniversityCourse[ConstantVal.getCourse()];


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

    public void setUnivCourses(UniversityCourse[] univCourses) {
        UnivCourses = univCourses;
    }

    DataCell inDataCell()
    {
        DataCell dataCell = null;
        dataCell.studs = new Student[ConstantVal.getAllstudent()];
        dataCell.numStudents = 0;
        dataCell.maxStudents =ConstantVal.getAllstudent();
        return dataCell;
    }
}
