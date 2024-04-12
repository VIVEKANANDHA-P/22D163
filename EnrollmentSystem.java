import java.sql.*;

public class EnrollmentSystem {
    private static Connection connection;

    // Establish database connection
    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:enrollment.db");
            createTables(); // Create tables if not exist
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Create tables if not exist
    private static void createTables() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Students (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Courses (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, faculty_id INTEGER)");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Faculty (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Enrollments (student_id INTEGER, course_id INTEGER, PRIMARY KEY(student_id, course_id))");
    }

    // Add a new student
    public static void addStudent(String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Students (name) VALUES (?)");
        statement.setString(1, name);
        statement.executeUpdate();
    }

    // Add a new course
    public static void addCourse(String name, int facultyId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Courses (name, faculty_id) VALUES (?, ?)");
        statement.setString(1, name);
        statement.setInt(2, facultyId);
        statement.executeUpdate();
    }

    // Add a new faculty
    public static void addFaculty(String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Faculty (name) VALUES (?)");
        statement.setString(1, name);
        statement.executeUpdate();
    }

    // Enroll a student in a course
    public static void enrollStudent(int studentId, int courseId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Enrollments (student_id, course_id) VALUES (?, ?)");
        statement.setInt(1, studentId);
        statement.setInt(2, courseId);
        statement.executeUpdate();
    }

    // Remove a student from a course
    public static void unenrollStudent(int studentId, int courseId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Enrollments WHERE student_id = ? AND course_id = ?");
        statement.setInt(1, studentId);
        statement.setInt(2, courseId);
        statement.executeUpdate();
    }

    // Main method to interact with the system via console interface
    public static void main(String[] args) {
        // Implement console interface here
        // Example usage:
        try {
            addStudent("Alice");
            addFaculty("Dr. Smith");
            addCourse("Mathematics", 1);
            enrollStudent(1, 1);
            unenrollStudent(1, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
