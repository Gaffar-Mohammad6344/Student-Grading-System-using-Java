import java.util.Scanner;

public class StudentGradingSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter marks for M1: ");
        int m1 = scanner.nextInt();
        System.out.print("Enter marks for M2: ");
        int m2 = scanner.nextInt();
        System.out.print("Enter marks for M3: ");
        int m3 = scanner.nextInt();

        Student student = new Student(studentId, studentName, m1, m2, m3);
        FileManager.saveStudent(student);
        System.out.println("Student added su1ccessfully!");
    }

    private static void searchStudent() {
        System.out.println("1. Search by Student ID");
        System.out.println("2. View All Students");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                System.out.print("Enter Student ID: ");
                String studentId = scanner.nextLine();
                Student student = FileManager.searchStudentById(studentId);
                if (student != null) {
                    System.out.println(student);
                } else {
                    System.out.println("Student not found.");
                }
                break;
            case 2:
                FileManager.displayAllStudents();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
