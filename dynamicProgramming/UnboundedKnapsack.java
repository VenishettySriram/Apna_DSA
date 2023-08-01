package dynamicProgramming;

public class UnboundedKnapsack {
	public static int unboundedKnapsack(int val[], int wt[], int W) {
		int n = val.length;
		int dp[][] = new int[n + 1][W + 1];
		for (int i = 0; i < dp.length; i++) { //0th col
			dp[i][0] = 0;
		}
		for (int i = 0; i < dp[0].length; i++) { //0th row
			dp[0][i] = 0;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < W + 1; j++) {
				if (wt[i - 1] <= j) { //valid
					int incProfit = val[i - 1] + dp[i][j - wt[i - 1]];
					int excProfit = dp[i - 1][j];
					dp[i][j] = Math.max(incProfit, excProfit);
				}
				else { //exclude
					int excProfit = dp[i - 1][j];
					dp[i][j] = excProfit;
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0;j < dp[0].length; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
		return dp[n][W];
	}
	
	public static void main(String[] args) {
		int val[] = {15, 14, 10, 45, 30};
		int wt[] = {2, 5, 1, 3, 4};
		int W = 7;
		int dp[][] = new int[val.length + 1][W + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0;j < dp[0].length; j++)
				dp[i][j] = -1;
		}
		System.out.println(unboundedKnapsack(val, wt, W));
	}
}
