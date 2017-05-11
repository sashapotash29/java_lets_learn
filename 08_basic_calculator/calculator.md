# Calculator


### Basic Facts

- Let's combine the skills we have learned into a calculator.
- Basic Specs:
	- The application will take in two numbers.
	- It will then take in an operation (i.e.: +,-,*,/)
	- It will perform the requested operation and then display the result.
- In order to move forwward faster, we will be using the methods from the previous lecture "07_making_functions".


### First Step
- First, in order for our code to be "dry", it is neater and more human readable to seperate each arithemtic operation (adding, subtracting, etc.) into methods that take in two numbers and return a result as a number. (Build one function that does its job well!)
- This is easy being we have done said methods in the previous lecture.
- **Note** For division, we changed the return type to a double and the inputs as doubles being for division we want a level accuracy beyond that of an integer.
```
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
```


### Second Step
- We need to grab our user's inputs. (Refer to 05_handling_user_inputs for more information)
- Here is some example code to refresh our memory:
```
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
```
- **Note** We create an instance of a Scanner which allows us to "scan" the System.in or terminal where the user is inputting information and retrieve the information in the form of Strings.
- In addition, the "Integer.parseInt(*string_parameter*)" piece of code is to convert the user's input (which is a string) into a integer being we need to complete arithmetic operations on these inputs.
- Also, our "operation" input is a char instead of a string being we are not expecting multiple characters. The ".charAt(0)" method being called on the string is because we want to take the string and grab the character that is at the beginning.


### Third Step
- Finally we need to meet and potatoes of the calculator which is the evaluator() method.
- The job of the evaluator is to take in all the information provided and decide which arithmetic operation should be performed. Therefore, the "operation" symbol is key.
- With the information inside the method, the first "if" statement is used to check if the operator is for addition, the following "else if" is to check if the operator is for subtraction, and so on.
- The "else" statement is used to trap the logic of the method translating to "if none of the potential cases are satisfied, assume the user made an error and display this message".
- **Note** This does not mean the user made an error ***but*** that none of the conditions were satisfied.
- Let's look at some code:
```
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
```

- As mentioned before, if the condition is met via checking the "operation" symbol, the corresponding arithmetic operation is invoked. When we invoke the method, we pass the two numbers asked for by the method and the method returns the answer.
- And at last! We print the answer into the terminal!!

### Final Thoughts
- This calculator is simple and allows for two numbers and basic operations.
- In other calculators, you can apply parantheses to establish an order of operations as well as more complex calculations such as exponents, logirithim, etc.
- Main learning objective was to create a basic calculator that uses the uer's inputs and accomplishes a task.












