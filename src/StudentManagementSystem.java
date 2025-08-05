import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        boolean run = true;

        while (run) {
            System.out.println("----- Student Record Management -----");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    studentList.add(new Student(id, name, marks));
                    System.out.println("Student added.");
                    break;

                case 2: // View
                    if (studentList.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : studentList) {
                            s.display();
                        }
                    }
                    break;

                case 3: // Update
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    boolean found = false;
                    for (Student s : studentList) {
                        if (s.id == updateId) {
                            scanner.nextLine(); // consume newline
                            System.out.print("Enter new name: ");
                            s.name = scanner.nextLine();
                            System.out.print("Enter new marks: ");
                            s.marks = scanner.nextDouble();
                            System.out.println("Student updated.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with ID not found.");
                    }
                    break;

                case 4: // Delete
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    found = false;
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).id == deleteId) {
                            studentList.remove(i);
                            System.out.println("Student deleted.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with ID not found.");
                    }
                    break;

                case 5:
                    run = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
