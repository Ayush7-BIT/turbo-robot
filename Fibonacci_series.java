////  Java Program for Fibonacci Series

import java.util.Scanner;

public class Fibonacci_series {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Read an integer value for 'n' from the user
		int n = sc.nextInt();
		// Call the Fibonacci method to generate the sequence
		Fibonacci(n);
		// Loop through the first 'n' Fibonacci numbers and print each one
		for (int i = 0; i < n; i++) {
			System.out.println(Fibonacci(i));
		}
		sc.close();
	}

	///// Recursive method to calculate the nth Fibonacci number
	public static int Fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}
}
