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



		



	}


}