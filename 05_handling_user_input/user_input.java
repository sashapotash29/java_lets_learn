import java.util.Scanner;

class user_input

{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		// CREATING A VARIABLE BUT NOT ASSIGNING IT A VALUE
		String movie;

		System.out.println("What is your favorite movie?");

		// PROMPTS THE USER IN THE TERMINAL FOR INFORMATION
		movie = input.nextLine();

		System.out.println("Really? "+ movie + " is a bad movie.");


		String x;

		System.out.println("Give me a number");
		
		x = input.nextLine();

		int y = Integer.parseInt(x);

		int answer = y*2;

		System.out.println("The number you gave me times 2 is equal to: " + answer);

		System.out.println("How about another number?");

		String z = input.nextLine();

		int int_z = Integer.parseInt(z);

		System.out.println("Your previous number "+ x + " multiplied by " + z + " gives you a value of " + int_z*y);











	}


}