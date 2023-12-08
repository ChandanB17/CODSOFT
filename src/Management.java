import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;

    // Constructors, getters, and setters

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade='" + grade + '\'' +
                '}';
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public int removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        return rollNumber;
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void saveDataToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadDataFromFile(String filename) {
        try {
            File file = new File(filename);
            if (file.exists() && file.isFile()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    students = (ArrayList<Student>) ois.readObject();
                    System.out.println("Data loaded successfully from " + filename);
                }
            } else {
                System.out.println("File " + filename + " does not exist. No data loaded.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class Management {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save Data to File");
            System.out.println("6. Load Data from File");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();

                    Student newStudent = new Student(name, rollNumber, grade);
                    system.addStudent(newStudent);
                    break;

                case 2:
                    // Remove Student
                    System.out.print("Enter roll number to remove: ");
                    int rollToRemove = scanner.nextInt();
                    Student searchStudent = system.searchStudent(rollToRemove);
                    if (searchStudent != null) {
                        int roll=system.removeStudent(rollToRemove);
                        System.out.println("Removed roll number:"+roll);
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 3:
                    // Search Student
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = scanner.nextInt();
                    Student searchedStudent = system.searchStudent(rollToSearch);
                    if (searchedStudent != null) {
                        System.out.println("Student found: " + searchedStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Display All Students
                    system.displayAllStudents();
                    break;

                case 5:
                    // Save Data to File
                    System.out.print("Enter file name to save data: ");
                    String saveFileName = scanner.nextLine();
                    system.saveDataToFile(saveFileName);
                    break;

                case 6:
                    // Load Data from File
                    System.out.print("Enter file name to load data: ");
                    String loadFileName = scanner.nextLine();
                    system.loadDataFromFile(loadFileName);
                    break;

                case 7:
                    // Exit
                    System.out.println("Exiting the Student Management System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
