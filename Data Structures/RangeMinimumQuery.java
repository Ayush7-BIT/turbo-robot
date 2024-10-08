import java.util.*;

class GFG {
	
  static int MAX = 500;
	static int[][] lookup = new int[MAX][MAX];
	
  static class Query {
		int L, R;
		public Query(int L, int R)
		{
			this.L = L;
			this.R = R;
		}
	};
	
  static void preprocess(int arr[], int n)
	{
		for (int i = 0; i < n; i++)
			lookup[i][i] = i;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++)
				if (arr[lookup[i][j - 1]] < arr[j])
					lookup[i][j] = lookup[i][j - 1];
				else
					lookup[i][j] = j;
		}
	}

  static void RMQ(int arr[], int n, Query q[], int m)
	{
		preprocess(arr, n);
		for (int i = 0; i < m; i++) {
			int L = q[i].L, R = q[i].R;
			System.out.println("Minimum of [" + L + ", " + R
							+ "] is "
							+ arr[lookup[L][R]]);
		}
	}
	public static void main(String[] args)
	{
		int a[] = { 7, 2, 3, 0, 5, 10, 3, 12, 18 };
		int n = a.length;
		Query q[] = { new Query(0, 4), new Query(4, 7),
					new Query(7, 8) };
		int m = q.length;
		RMQ(a, n, q, m);
	}
}
