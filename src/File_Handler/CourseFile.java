package File_Handler;
import DataCell_Department.Courses.UniversityCourse;
import Users.DataCell;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class CourseFile {
    public static void writeCoursesToFile(DataCell dataCell, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            UniversityCourse[] courses = dataCell.UnivCourses;
            for (UniversityCourse course : courses) {
                if (course != null) {
                    String courseData = course.getCourse_codes() + "," + course.getCourse_names() + "," +
                            course.getCredit_hours() + "," + course.getPrerequisite_course() + "\n";
                    writer.write(courseData);
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing courses to file: " + e.getMessage());
        }
    }
    public static void readCoursesFromFile(DataCell dataCell, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    UniversityCourse course = new UniversityCourse();
                    course.setCourse_codes(parts[0]);
                    course.setCourse_names(parts[1]);
                    course.setCredit_hours(Integer.parseInt(parts[2]));
                    course.setPrerequisite_course(parts[3]);
                    dataCell.addUniversityCourse(course);
                }
            }
        } catch (IOException  e) {
            System.err.println("Error reading courses from file: " + e.getMessage());
        }
    }
}
