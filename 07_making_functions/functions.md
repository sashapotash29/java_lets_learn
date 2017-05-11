# Creating Functions


#### Basic Function (Add two numbers!)

- The function we are creating will add two numbers we provide.
- First we will see an example and the deconstruct what each part is doing.
```
		// ADD with no "return" value 
		public static void add(int num1, int num2){
			System.out.println(num1);
			System.out.println(num2);
			System.out.println(num1 + num2);
		};

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

		public static int division(int num1, int num2){
			return num1/num2;
		};

```
##### Quick Breakdown
- The first function named " ADD with no "return" value " is an example of a function that does not return anything.
- This is indicated by void, meaning this function does not return anything.
- Notice how the other functions (adder, multiply, subtract, etc.) have "int" instead indicating that this method returns a integer.
- "public" indicates that it is accessible throughout the Java script and not limited to a set scope.
- "static" indicates that the function can not be changed and is immutable. Therefore, later, you can not change the construct/implementation of the function.

##### main()
- When a Java script is executed, the main() function is what is run and therefore implies that all necessary tasks and processes must be contained within.
- **Note** The functions written above are simply being declared, explaining what it intends to do with what variables. It is not being invoked or called until you write so.
- In addition, note that we create a variable each time we call the function and set the variable equal to what the method returns. In the original, add() function it prints the result of the addition into the system where as "return" does not display a result in the terminal.

```
			public static void main(String[] args){
				int x = 10;
				int y = 5;

				add(x,y);
				int ans1 = adder(x,y);
				System.out.println(ans1);

				int ans2 = multiply(x,y);
				System.out.println(ans2);

				int ans3 = subtract(x,y);
				System.out.println(ans3);

				int ans4 = division(x,y);
				System.out.println(ans4);

			};
```


