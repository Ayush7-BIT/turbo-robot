// Java program to find number of ways to get sum 'x' with 'n' 
// dice where every dice has 'm' faces 
import java.util.*; 
import java.lang.*; 
import java.io.*; 

class Dice { 
	/* The main function that returns the number of ways to get sum 'x' with 'n' dice and 'm' with m faces. */
	public static long findWays(int m, int n, int x){ 
		
	/* Create a table to store the results of subproblems. 
	One extra row and column are used for simplicity 
	(Number of dice is directly used as row index and sum is directly used as column index). 
	The entries in 0th row and 0th column are never used. */
	long[][] table = new long[n+1][x+1]; 
		
	/* Table entries for only one dice */
	for(int j = 1; j <= m && j <= x; j++) 
				table[1][j] = 1; 
			
	/* Fill rest of the entries in table using recursive relation 
	i: number of dice, j: sum */
	for(int i = 2; i <= n;i ++){ 
				for(int j = 1; j <= x; j++){ 
					for(int k = 1; k < j && k <= m; k++) 
						table[i][j] += table[i-1][j-k]; 
				} 
		} 
		
		/* Uncomment these lines to see content of table 
		for(int i = 0; i< n+1; i++){ 
			for(int j = 0; j< x+1; j++) 
				System.out.print(dt[i][j] + " "); 
			System.out.println(); 
		} */
		
		return table[n][x]; 
	} 
	
	// Driver Code 
	public static void main (String[] args) { 
		System.out.println(findWays(4, 2, 1)); 
		System.out.println(findWays(2, 2, 3)); 
		System.out.println(findWays(6, 3, 8)); 
		System.out.println(findWays(4, 2, 5)); 
		System.out.println(findWays(4, 3, 5)); 
	} 
} 

// This code is contributed by MaheshwariPiyush 
