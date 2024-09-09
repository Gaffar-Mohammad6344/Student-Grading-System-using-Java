import java.io.Serializable;

public class Student implements Serializable {
    private String studentId;
    private String studentName;
    private int m1, m2, m3;
    private int total;
    private double average;
    private char grade;

    public Student(String studentId, String studentName, int m1, int m2, int m3) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        calculateResults();
    }

    private void calculateResults() {
        this.total = m1 + m2 + m3;
        this.average = total / 3.0;
        this.grade = calculateGrade(average);
    }

    private char calculateGrade(double average) {
        if (average >= 80) 
        return 'A';
        if (average >= 70) 
        return 'B';
        if (average >= 60) 
        return 'C';
        if (average >= 50) 
        return 'D';
        return 'F';
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + studentName + ", Total: " + total + 
               ", Average: " + average + ", Grade: " + grade;
    }
}
