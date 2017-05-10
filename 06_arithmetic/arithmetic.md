# Arithmetic


### Basic Arithmetic


##### String Concatenation
- String Concatenation is the process of combining two strings together in the order specified.
```
		String first_name = "Alex";
		String last_name = "Potashnik";

		System.out.println(first_name+" "+last_name);
```
- **Note** The strings are being "added" or combined together via the "+" symbol. 
- This also will work with Integers. 
	- i.e.:  1 + 3 
	```
		System.out.println("Addition\n");
		int x = 5;
		int y = 3;
		System.out.println(x+y);
		// OUTPUT: 8

	```

##### Subtraction
- Subtraction is done via the "-" symbol. It is an operation used generally on numbers.

```
		System.out.println("Subtraction\n");
		int x = 5;
		int y = 3;
		System.out.println(x-y);
		// OUTPUT: 2

```


##### Multiplication
- Multiplication is done via the "*" symbol. It is an operation used generally on numbers.

```
		System.out.println("Multiplication\n");
		int x = 5;
		int y = 3;
		System.out.println(x*y);
		// OUTPUT: 15
```



##### Division/Modulus
- Division is done via the "/" symbol. It is an operation used generally on numbers.
```
		System.out.println("Division\n");
		int x = 6;
		int y = 2;
		System.out.println(x/y);
		// OUTPUT: 3
```
- Modulus is done via the "%" symbol and is used to find the remainder between two numbers.
```
		System.out.println("Modulus\n");
		int x = 6;
		int y = 5;
		System.out.println(x%y);
```
	- **Note** This is useful for identifying if a number is odd or even. 
		- i.e.: Number % 2
		- If the value returned is 1 then it is clearly an odd number.


##### Plus-Plus / Minus-Minus
- Plus-Plus is done via two "+" symbold followed by the number. This operation takes the number provided after the "++" and adds 1 to it.
```
		System.out.println("Plus-Plus\n");
		x = 4;
		y = 7;
		System.out.println(++x);
		System.out.println(++y);
```
- Minus-Minus is done via two "-" symbold followed by the number. This operation takes the number provided after the "--" and subtracts 1 to it.
```
		System.out.println("Minus-Minus\n");
		x = 4;
		y = 7;
		System.out.println(--x);
		System.out.println(--y);
```




