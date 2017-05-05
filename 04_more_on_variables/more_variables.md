# More on Java Data Types and Variables





### FLOAT

- Float is a number with decimal points (i.e. 10.00)
- Coding Example:	
	- float decimal = 75.9009f;
	- **NOTE** there is an "f" at the end of the decimal number.


### Boolean

- Boolean is a true or false value
- Useful for a series of verifications/tests that if the information passes should return True or False.
- Coding Example:
	- boolean result = true;
	- **NOTE** that that both "boolean" and "true" are lowercase.


### Byte

- an Integer number between -128 and +127.
- Coding Example:
	- byte byte_example = 127;


### Short

- an Integer between -32,768 to 32,767.
- Coding Example:
	- short short_example =  30000;


### Long

- a positive or negative number exceeding 2.14 billion.
- Coding Example:
	- long longer_number = 1200300400500;


### Double

- Extremely Long float number.
- Coding Example:
	- double long_decimal = 5.121231231231232;


### println() function

- Why "ln" after "print"?
	- Because it provides a new line or line break.
- Many different types of print.
	- print()
	- println()


## Extra Notes

- It's worth noting that the reason why "smaller" integers exists (such as Short and Byte) are to limit the amount of memory allocated for each number's storage. It would be "wasteful" to occupy the space for an Integer (int) in memory for the value 4, unless you intend to modify the variable outside of the scope of a byte and/or short.