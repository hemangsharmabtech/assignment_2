package fullabstract;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int prn;
    private String name;
    private String dob;
    private double marks;

    // Constructor
    public Student(int prn, String name, String dob, double marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    // Getters and setters (methods for accessing and modifying private fields)
    public int getPrn() {
        return prn;
    }

    public void setPrn(int prn) {
        this.prn = prn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // toString method to display student information
    @Override
    public String toString() {
        return "PRN: " + prn + ", Name: " + name + ", DoB: " + dob + ", Marks: " + marks;
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student Information");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner, studentList);
                    break;
                case 2:
                    displayStudents(studentList);
                    break;
                case 3:
                    searchByPRN(scanner, studentList);
                    break;
                case 4:
                    searchByName(scanner, studentList);
                    break;
                case 5:
                    updateStudent(scanner, studentList);
                    break;
                case 6:
                    deleteStudent(scanner, studentList);
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addStudent(Scanner scanner, ArrayList<Student> studentList) {
        System.out.println("Enter student details:");
        System.out.print("PRN: ");
        int prn = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Date of Birth (DoB): ");
        String dob = scanner.nextLine();
        System.out.print("Marks: ");
        double marks = scanner.nextDouble();

        Student newStudent = new Student(prn, name, dob, marks);
        studentList.add(newStudent);

        System.out.println("Student added successfully!");
    }

    private static void displayStudents(ArrayList<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("List of Students:");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    private static void searchByPRN(Scanner scanner, ArrayList<Student> studentList) {
        System.out.print("Enter PRN to search: ");
        int searchPRN = scanner.nextInt();

        for (Student student : studentList) {
            if (student.getPrn() == searchPRN) {
                System.out.println("Student found:\n" + student);
                return;
            }
        }

        System.out.println("No student found with PRN: " + searchPRN);
    }

    private static void searchByName(Scanner scanner, ArrayList<Student> studentList) {
        System.out.print("Enter Name to search: ");
        scanner.nextLine(); // consume the newline character
        String searchName = scanner.nextLine();

        for (Student student : studentList) {
            if (student.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Student found:\n" + student);
                return;
            }
        }

        System.out.println("No student found with Name: " + searchName);
    }

    private static void updateStudent(Scanner scanner, ArrayList<Student> studentList) {
        System.out.print("Enter PRN to update: ");
        int updatePRN = scanner.nextInt();

        for (Student student : studentList) {
            if (student.getPrn() == updatePRN) {
                System.out.println("Enter new details for PRN " + updatePRN + ":");
                System.out.print("Name: ");
                scanner.nextLine(); // consume the newline character
                String newName = scanner.nextLine();
                System.out.print("Date of Birth (DoB): ");
                String newDob = scanner.nextLine();
                System.out.print("Marks: ");
                double newMarks = scanner.nextDouble();

                student.setName(newName);
                student.setDob(newDob);
                student.setMarks(newMarks);

                System.out.println("Student details updated successfully!");
                return;
            }
        }

        System.out.println("No student found with PRN: " + updatePRN);
    }

    private static void deleteStudent(Scanner scanner, ArrayList<Student> studentList) {
        System.out.print("Enter PRN to delete: ");
        int deletePRN = scanner.nextInt();

        for (Student student : studentList) {
            if (student.getPrn() == deletePRN) {
                studentList.remove(student);
                System.out.println("Student with PRN " + deletePRN + " deleted successfully!");
                return;
            }
        }

        System.out.println("No student found with PRN: " + deletePRN);
    }
}
