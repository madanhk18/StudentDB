import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== Welcome to Student Database System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Email");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone No: ");
                    long phone = sc.nextLong();

                    Student s = new Student(rollNo, name, dept, email, phone);
                    dao.addStudent(s);
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("⚠ No students found.");
                    } else {
                        for (Student st : students) {
                            System.out.println(st);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll No to Update Email: ");
                    int rNoUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();
                    dao.updateStudentEmail(rNoUpdate, newEmail);
                    break;

                case 4:
                    System.out.print("Enter Roll No to Delete: ");
                    int rNoDelete = sc.nextInt();
                    dao.deleteStudent(rNoDelete);
                    break;

                case 5:
                    System.out.println("Thank you for your time");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid ,  Try again.");
            }
        }
    }
}
