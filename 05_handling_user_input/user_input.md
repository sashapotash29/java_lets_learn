# USER INPUT


### General

- Anything the user can provide (i.e Name, Number, etc.)



### import java.util.Scanner

- this is the command to import Scanner which is necessary for receiving information from the client.



### Scanner

- Scanner needs to be intialized.
- Coding Example:
	- Scanner input = new Scanner(System.in);
	-**NOTE** "Scanner" data type and usage of "new" to state creation of an instance of a scanner.
	- Passing "System.in" as an argument in the Scanner initialization.

- input.nextLine();
	- the above function is necessary to pause the application from running and wait for a user input.


### Getting Numbers from User

- Everything from the user comes in string form and therefore needs to be converted into a number data type in order to be used for mathematical calculations.
- To convert a string into an integer, use the following code:
	```
		String x;
		x = input.nextLine();

		int y = Integer.parseInt(x);
	```
	- The idea here is that x is the users input and then the class "Integer" has a method called parseInt which can interpret the string and try to convert it to the appropriate number.