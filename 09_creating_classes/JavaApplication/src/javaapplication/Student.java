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
public class Student {
	int student_id;
	String first_name;
	String last_name;
	String email;
	String course;
	int age;
	double grade;

	void new_test(int new_score){
		double new_grade = (grade + new_score)/2;
		grade = new_grade;
		System.out.println("New Grade for "+ first_name + " " + last_name + " is: " + grade);

	};

	void update_email(String new_email){
		String temp = email;
		email = new_email;
		System.out.println("Email "+ temp + " has been set to: " + email);


	};

	// public static void main(String[] args){

	
	// }
    
}
