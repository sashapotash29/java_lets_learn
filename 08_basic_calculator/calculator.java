import java.util.Scanner;

public class calculator{
	// BELOW ARE OUR BUILDING BLOCKS FOR OUR CALCULATOR
	// THESE ARE THE OPERATIONS WE WOULD LIKE THE CALCULATOR TO COMPLETE GIVEN
	// THE TWO USER PROVIDED INPUTS.

	// ADD with no "return" value 

	// ADD
	public static int adder(int num1, int num2){
		return num1+num2;
	};

	// 
	public static int multiply(int num1, int num2){
		return num1*num2;
	};

	public static int subtract(int num1, int num2){
		return num1-num2;
	};

	public static double division(double num1, double num2){
		return num1/num2;
	};

	public static void evaluator(char operation, int num1, int num2){

		if (operation == '+'){
			int ans1 = adder(num1,num2);
			System.out.println("Your Answer is: "+ ans1);

		}

		else if(operation=='-'){
			int ans1 = subtract(num1,num2);
			System.out.println("Your Answer is: "+ ans1);
		}

		else if(operation=='*'){
			int ans1 = multiply(num1,num2);
			System.out.println("Your Answer is: "+ ans1);
		}

		else if(operation=='/'){
			double num1_db = (double)num1;
			double num2_db = (double)num2;
			double ans1 = division(num1_db,num2_db);
			System.out.println("Your Answer is: "+ ans1);
		}

		else{
			System.out.println("The operation you have provided is not possible. Please try again!");
		}

	};



	// MAIN
	public static void main(String[] args){

		// CREATE AN INSTANCE OF A SCANNER
		Scanner input = new Scanner(System.in);

		// GRAB USER INPUTS
		System.out.print("Please provide your first number: ");
		String first_number = input.nextLine();
		int number1 = Integer.parseInt(first_number);

		System.out.print("Please provide your second number: ");
		String second_number = input.nextLine();
		int number2 = Integer.parseInt(second_number);

		System.out.print("Please provide the operation (i.e. +,-,*,/): ");
		char operation = input.nextLine().charAt(0);

		System.out.println(first_number + " " + second_number + " " + operation);

		evaluator(operation, number1, number2);

	}



}