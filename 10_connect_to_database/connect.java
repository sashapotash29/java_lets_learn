/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Alexander_Potashnik
 */
public class DatabaseProject {

    
    public static void displayResults(ResultSet rs) 
        throws SQLException{
            while(rs.next()){
                int id = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                int grade = rs.getInt(4);
                System.out.println(id + " " + fname + " " + lname + " " + grade);


            }
    };

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        String URL = "jdbc:postgresql://localhost:5432/students";
        Connection conn = DriverManager.getConnection(URL);

//        SELECT * WITH NO WHERE CLAUSES
        Statement stmt = conn.createStatement();
        String SQL = "Select * from student_info";
        ResultSet rs = stmt.executeQuery(SQL);
        System.out.println(rs);
        displayResults(rs);
        
//        SELECT WITH WHERE STATEMENT
        String SQL2 = "SELECT * FROM student_info WHERE grade > 9";
        ResultSet rs2 = stmt.executeQuery(SQL2);
        System.out.println(rs2);
        displayResults(rs2);
        
        String SQL3 = "SELECT * FROM student_info WHERE fname LIKE '%ob%'";
        ResultSet rs3 = stmt.executeQuery(SQL3);
        System.out.println(rs3);
        displayResults(rs3);
        
//        INSERT STATEMENT
        Scanner input = new Scanner(System.in);
        System.out.print("New Student's ID number: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("New Student's First Name: ");
        String new_fname = input.nextLine();
        System.out.print("New Student's Last Name: ");
        String new_lname = input.nextLine();
        System.out.print(new_fname + " " + new_lname +"'s Grade: ");
        int new_grade = Integer.parseInt(input.nextLine());
        
        
        String SQL4 = "INSERT INTO student_info VALUES('"+id+"','"+new_fname+"','"+ new_lname + "','" + new_grade+ "')";
        stmt.executeUpdate(SQL4);
        
        ResultSet rs5 = stmt.executeQuery("SELECT * from student_info");

        displayResults(rs5);
        
        
        
        
        
        
        
        
    }
    
}
