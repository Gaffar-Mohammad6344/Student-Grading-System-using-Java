import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "students.dat";

    public static void saveStudent(Student student) {
        List<Student> students = readAllStudents();
        students.add(student);
        writeAllStudents(students);
    }

    public static List<Student> readAllStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static void writeAllStudents(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Student searchStudentById(String studentId) {
        List<Student> students = readAllStudents();
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public static void displayAllStudents() {
        List<Student> students = readAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
