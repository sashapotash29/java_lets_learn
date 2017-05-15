# Class/Object and Basic Java Application Structure


### Class vs Object

- Both are very similar, ***but*** Class is the prototype or template of the object and the Object is the actual creation made.
- For example, Schools vs Public School 150.
	- "Schools" is the generic template for a school.
	- "Public School 150" is an instance (or specific example) of a school.

### Before we start coding!

#### Application

- To start making sense of how to create an application in a professional environment, it is important to note that at the highest level, we create applications.
- Inside of your application, you will most likely have: Packages, Libraries, and other files.
- Example: JavaApplication is the name of the application.
- When creating an application, a ".java" is created that will contain the main() method that will be called if the application is told to run. Therefore, all the logic will be written inside that file and will pull methods/objects and other information from their respective package/library.

#### Packages
- Unlike other languages, Java has this notion of Packages.
- Packages are used to designate what classes are part of a group.
- For example, package for your application requires these set classes/objects to function.

```
package javaapplication;
```
- The above line states that the code written below is part of the "javaapplication" package and any other code written with the same statement should know about other classes written in seperate files.


### Creating a Class

- To begin, we write in our java file the "public class" and the name of our class.
- **Note** We have been writing the above code in every example thus far and this is a key feature or Java. (More on this later)

```
public class Student{
	int student_id;
	String first_name;
	String last_name;
	String email;
	String course;
	int age;
	double grade;
	
}
```
- Above, we create a class called "Student" that contains a variety of variables.
- **Note** There is no main method because we are simply explaining what a "Student" object looks like and not asking for something to be invoked when this class is asked for.


### Methods for our Class

- As with other object oriented languages, we can create methods for our objects that work with the object's attributes (age, first_name, last_name, etc.). If we think back to Scanner, each scanner object we created contained methods to grab information from the user and these methods were declared in a "Scanner" class, explaining what the operation is.

```
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
```
- new_test() takes as a parameter an integer and adjusts the student's score accordingly.
- update_email() takes as a parameter a String and updates the existing email.


### Addition Information

- Looking into the JavaApplication folder. There will be a lot of files that seem unusual but keep in mind these are part of the IDE NetBeans that are created for our benefit. You will notice they have a "build" folder that has a "classes" folder (i.e. JavaApplication/build/classes). Although the finals are ignore as you will compile these files yourself, the file is where NetBeans designates your ".class" files to be executed.
- Likewise, there is a "src" file (or Source) which contains the ".java" files that hold the code that have been used to create our ".class" files.
	- This directory is also where you can look for the human-readable code that we are used to leading up to this lecture.
- The other files are used mainly for configuration. An example will be file pathes. As you are creating these files and need them to communicate, the pathes are made in a default fashion that allows the applcation to flow in an understandable and most likely in a way that conforms to common programming standards with respect to Java.








