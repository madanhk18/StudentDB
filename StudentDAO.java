import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection con;

    public StudentDAO() {
        try {
            String url = "jdbc:mysql://host.docker.internal:3306/studentDB";
            String userName = "root";
            String password = "M@dan890";
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("✅ Connected to DB from StudentDAO");
        } catch (SQLException e) {
            System.out.println("❌ Connection failed in StudentDAO: " + e.getMessage());
        }
    }

    // 1. To Add Student
    public void addStudent(Student s) {
        String sql = "INSERT INTO students (roll_no, name, department, email, phn_no) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, s.getRoll_no());
            ps.setString(2, s.getName());
            ps.setString(3, s.getDepartment());
            ps.setString(4, s.getEmail());
            ps.setLong(5, s.getPhn_no());

            ps.executeUpdate();
            System.out.println("✅ Student added successfully.");
        } catch (SQLException e) {
            System.out.println("❌ Failed to add student: " + e.getMessage());
        }
    }

    // 2. To fetch all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("roll_no"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("email"),
                        rs.getLong("phn_no")
                );
                students.add(s);
            }
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch students: " + e.getMessage());
        }
        return students;
    }

    // 3. Update Student
    public void updateStudentEmail(int rollNo, String newEmail) {
        String sql = "UPDATE students SET email = ? WHERE roll_no = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newEmail);
            ps.setInt(2, rollNo);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Email updated for roll_no: " + rollNo);
            } else {
                System.out.println("⚠ No student found with roll_no: " + rollNo);
            }
        } catch (SQLException e) {
            System.out.println("❌ Failed to update student: " + e.getMessage());
        }
    }

    // 4. Delete Student
    public void deleteStudent(int rollNo) {
        String sql = "DELETE FROM students WHERE roll_no = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rollNo);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student deleted with roll_no: " + rollNo);
            } else {
                System.out.println("⚠ No student found with roll_no: " + rollNo);
            }
        } catch (SQLException e) {
            System.out.println("❌ Failed to delete student: " + e.getMessage());
        }
    }
}
