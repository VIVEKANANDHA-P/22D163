# Enrollment System

## description
The furnished Java code constitutes an Enrollment System, a simplified implementation for coping with students, publications, schools, and their enrollments in a relational database. Let's destroy down the code and offer a description:

Database Connection Establishment:

The class EnrollmentSystem initializes a static block to set up a connection to an SQLite database named enrollment.Db. It makes use of JDBC (Java Database Connectivity) to connect to the SQLite database.
It hundreds the SQLite JDBC driving force the use of Class.ForName(&quot;org.Sqlite.JDBC&quot;) and then connects to the database the usage of DriverManager.GetConnection(&quot;jdbc:sqlite:enrollment.Db&quot;).
Table Creation:

Inside the createTables() approach, SQL statements are completed to create four tables if they do now not exist already: Students, Courses, Faculty, and Enrollments.
Each desk is created with suitable columns, along with identification, call, and overseas key constraints where essential.
Adding Entities:

The gadget presents techniques to feature students, guides, and faculty contributors to the database.
AddStudent(String name): Inserts a brand new student into the Students desk with the furnished name.
AddCourse(String call, int facultyId): Adds a brand new path to the Courses table with the required call and faculty ID.
AddFaculty(String call): Inserts a new faculty member into the Faculty desk with the given call.
Enrollment Management:

The system lets in for enrolling and unenrolling students in publications.
EnrollStudent(int studentId, int courseId): Inserts a brand new enrollment document into the Enrollments table, linking a pupil with a direction.
UnenrollStudent(int studentId, int courseId): Removes the enrollment record for a student from a particular path.
Main Method:

The principal() technique serves as a placeholder for interacting with the machine. It demonstrates sample utilization by means of adding a student, faculty, path, enrolling the pupil in that course, after which unenrolling the scholar from the route.
Exception dealing with is applied to capture and print any SQL-related exceptions that might arise throughout database operations.
Console Interface (Not Implemented):

Although the class structure is in location, the code lacks a right console interface for user interplay. It's anticipated that similarly development would include techniques to deal with consumer input and provide remarks through the console.
Error Handling:

The code consists of simple error dealing with for SQL exceptions, printing stack traces if an exception takes place in the course of database operations.
Overall, this code provides a foundation for dealing with pupil enrollments in publications inside a relational database device. It can be extended with extra capability along with querying scholar/route information, updating facts, or implementing a more user-friendly interface for interplay.
