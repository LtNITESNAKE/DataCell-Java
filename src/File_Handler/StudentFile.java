package File_Handler;

import DataCell_Department.Enrollment.Student;
import Users.DataCell;
import Utility.Sorting_Searching;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class StudentFile {

    public static void writeStudentsToFile(DataCell dataCell, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            Student[] students = dataCell.getStuds();
            for (Student student : students) {
                if (student != null) {
                    String studentData = student.getID() + "," + student.getName() + "," +
                            student.getContact() + "," + student.getEnroll().getAdd_date() + "," +
                            student.getEnroll().getProgramtostudy() + "," + student.getEnroll().getDegree() + "," +
                            student.getEnroll().getFscmarks() + "," + student.getEnroll().getMatricmarks() + "," +
                            student.getFees() + "," + student.getFines() + "\n";
                    writer.write(studentData);
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void readStudentsFromFile(DataCell dataCell, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 10) {
                    Student student = new Student();
                    student.setID(parts[0]);
                    student.setName(parts[1]);
                    student.setContact(parts[2]);
                    student.getEnroll().setAdd_date(parts[3]);
                    student.getEnroll().setProgramtostudy(parts[4]);
                    student.getEnroll().setDegree(parts[5]);

                    try {

                        int fscMarks = Integer.parseInt(parts[6]);
                        int matricMarks = Integer.parseInt(parts[7]);
                        float fees = Float.parseFloat(parts[8]);
                        float fines = Float.parseFloat(parts[9]);

                        // Set parsed values to student object
                        student.getEnroll().setFscmarks(fscMarks);
                        student.getEnroll().setMatricmarks(matricMarks);
                        student.setFees(fees);
                        student.setFines(fines);

                        // Add student to dataCell
                        addStudent(dataCell, student);
                        System.out.println("Added student: " + student.getName() + " (" + student.getID() + ")");
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing numeric value: " + e.getMessage());

                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void addStudent(DataCell dataCell, Student newStudent) {
        int currentSize = dataCell.getMaxStudents();
        int currentCount = dataCell.getNumStudents();

        // Check if there's enough space, and if not, increase size
        if (currentCount >= currentSize) {

            int newSize = currentSize + 10;
            Student[] newStudents = new Student[newSize];

            // Copy existing students to the new array
            for (int i = 0; i < currentCount; i++) {
                newStudents[i] = dataCell.getStuds()[i];
            }

            // Add the new student at the next available index
            newStudents[currentCount] = newStudent;

            // Update DataCell with the new array and size
            dataCell.setStuds(newStudents);
            dataCell.setMaxStudents(newSize);
            dataCell.setNumStudents(currentCount + 1);

            System.out.println("Student added successfully.");
        } else {

            dataCell.getStuds()[currentCount] = newStudent;
            dataCell.setNumStudents(currentCount + 1);

            System.out.println("Student added successfully.");
        }
    }


}

