import java.sql.*;
import java.util.Scanner;

public class StudentManager {

    // Database details
    static final String URL = "jdbc:postgresql://localhost:5432/studentManagement";
    static final String USER = "postgres";
    static final String PASS = "1022";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while(true){

            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Batch Insert");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch(choice){

                case 1 -> addStudent();

                case 2 -> viewStudents();

                case 3 -> updateStudent();

                case 4 -> deleteStudent();

                case 5 -> batchInsert();

                case 6 -> {
                    System.out.println("Program Ended");
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }

    // Add Student
    static void addStudent(){

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        String sql = "INSERT INTO student VALUES (?, ?, ?)";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setInt(3,marks);

            ps.executeUpdate();

            System.out.println("Student Added Successfully");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    // View Students
    static void viewStudents(){

        String sql = "SELECT * FROM student";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            System.out.println("\nStudent Records:");

            while(rs.next()){

                int id = rs.getInt("sid");
                String name = rs.getString("sname");
                int marks = rs.getInt("marks");

                System.out.println(id + " " + name + " " + marks);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    // Update Student Marks
    static void updateStudent(){

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Marks: ");
        int marks = sc.nextInt();

        String sql = "UPDATE student SET marks=? WHERE sid=?";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,marks);
            ps.setInt(2,id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Student Updated Successfully");
            else
                System.out.println("Student Not Found");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    // Delete Student
    static void deleteStudent(){

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM student WHERE sid=?";

        try(Connection con = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Student Deleted Successfully");
            else
                System.out.println("Student Not Found");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    // Batch Insert using Stored Procedure
    static void batchInsert(){

        try(Connection con = DriverManager.getConnection(URL, USER, PASS);
            CallableStatement cs = con.prepareCall("CALL add_student(?, ?, ?)")){

            cs.setInt(1,301);
            cs.setString(2,"Maya");
            cs.setInt(3,70);
            cs.addBatch();

            cs.setInt(1,302);
            cs.setString(2,"Akshay");
            cs.setInt(3,65);
            cs.addBatch();

            cs.setInt(1,303);
            cs.setString(2,"Zara");
            cs.setInt(3,80);
            cs.addBatch();

            cs.executeBatch();

            System.out.println("Batch Insert using Stored Procedure Completed");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
