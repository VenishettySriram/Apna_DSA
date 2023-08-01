package dynamicProgramming;
import java.util.*;
public class ClimbingStairs {
	public static int countWays(int n) { //(2^n)
		if (n == 0)
			return 1;
		else if (n < 1)
			return 0;
		else
			return countWays(n - 1) + countWays(n - 2);
	}
	//O(n)
	
	public static int countWaysMem (int n, int ways[]) { // Memorization -> O(n)
		if (n == 0)
			return 1;
		else if (n < 1)
			return 0;
		if (ways[n] != -1) //already calculated
			return ways[n];
		
		ways[n] = countWaysMem(n - 1, ways) + countWaysMem(n - 2, ways);
		return ways[n];
	}
	
	public static int countWaysTab(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		//tabulation loop
		for (int i = 2; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(countWays(n));
		System.out.println(countWaysTab(n));
		int ways[] = new int[n + 1];
		Arrays.fill(ways, -1);
		System.out.println(countWaysMem(n, ways));
	}
}
