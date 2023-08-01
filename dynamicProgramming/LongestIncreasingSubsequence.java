package dynamicProgramming;
import java.util.*;

public class LongestIncreasingSubsequence {
	public static int lcsTab(int arr[], int arr2[]) {
		int n = arr.length;
		int m = arr2.length;
		int dp[][] = new int[n + 1][m + 1];
		//initialize 0th row and col to 0(Not needed in JAVA)
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (arr[i - 1] == arr2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				else {
					int ans1 = dp[i - 1][j];
					int ans2 = dp[i][ j - 1];
					dp[i][j] = Math.max(ans1, ans2);
				}
			}
		}
		return dp[n][m];
	}
	
	public static int lis(int arr[]) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++)
			set.add(arr[i]);
		int n = set.size();
		int arr2[] = new int[n];
		int i = 0;
		for (int num : set) {
			arr2[i] = num;
			i++;
		}
		Arrays.sort(arr2); //ascending
		return lcsTab(arr, arr2);
	}
	
	public static void main(String[] args) {
		int arr[] = {50, 3, 10, 7, 40, 80};
		System.out.println(lis(arr));
	}
}
