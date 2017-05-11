public class functions{

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






}