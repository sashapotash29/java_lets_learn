/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

/**
 *
 * @author Alexander_Potashnik
 */
public class studentPlay {
    
    public static void main(String[] args){
		Student bob = new Student();
		bob.student_id =  17;
		bob.first_name = "Robert";
		bob.last_name = "Johnson";
		bob.email = "bobbyJ@gmail.com";
		bob.course = "Computer Science";
		bob.age = 19;
		bob.grade = 85;
                
                System.out.println("Executing Methods");
                
		bob.new_test(95);
		bob.update_email("jbob@gmail.com");




	}
    
}
