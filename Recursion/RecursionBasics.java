package Recursion;

public class RecursionBasics {
	// Time & Space complexities are O(n)
	public static void printDec(int n) {
		if (n == 1) {
			System.out.println(n);
			return;
		}
		System.out.print(n + " ");
		printDec(n - 1);
	}
	
	// Time & Space complexities are O(n)
	public static void printInc(int n) {
		if (n == 1) {
			System.out.println(n);
			return;
		}
		System.out.print(n + " ");
		printInc(n - 1);
	}
	
	// Time & Space complexities are O(n)
	public static int fact(int n) {
		if (n == 0)
			return 1;
		int fn = n * fact(n - 1);
		return fn;
	}
	
	// Time & Space complexities are O(n)
	public static boolean isSorted(int arr[], int i) {
		if (i == arr.length - 1)
			return true;
		if (arr[i] > arr[i + 1])
			return false;
		return isSorted(arr, i + 1);
	}
	
	// Time & Space complexities are O(n)
	public static int firstOccurence(int arr[], int key, int i) {
		if (i == arr.length)
			return -1;
		if (arr[i] == key)
			return i;
		return firstOccurence(arr, key, i + 1);
	}
	
	public static int lastOccurence(int arr[], int key, int i) {
		if (arr.length == i)
			return -1;
		int isFound = lastOccurence(arr, key, i + 1);
		if (isFound == -1 && arr[i] == key)
			return i;
		return isFound;
	}
	
	// Time & Space complexities are O(n)
	public static int power(int x, int n) {
		if (n == 0)
			return 1;
		return  n * power(x, n - 1);
	}
	
	// Time & Space complexities are O(log n)
	public static int optimizedPower(int a, int n) {
		if (n == 0)
			return 1;
		int halfPower = optimizedPower(a, n / 2);
		int halfPowerSq = halfPower * halfPower;
		
	// n is odd
		if (n % 2 != 0)
			halfPowerSq = a * halfPowerSq;
		return halfPowerSq;
	}
	
	//Tiling Problem
	public static int tilingProblem(int n) {
		//base case
		if (n == 0 || n == 1)
			return 1;
//		//vertical choice
//		int fnm1 = tilingProblem(n - 1);
//		//horizontal choice
//		int fnm2 = tilingProblem(n - 2);
//		int totWays = fnm1 + fnm2;
//		return totWays;
		return tilingProblem(n - 1) + tilingProblem(n - 2);
	}
	//Remove Duplicates of a String with characters within range a to z.
	public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
		if (idx == str.length()) {
			System.out.println(newStr);
			return;
		}
		char currChar = str.charAt(idx);
		if (map[currChar - 'a'] == true) {
			//duplicate
			removeDuplicates(str, idx + 1, newStr, map);
		}
		else {
			map[currChar - 'a'] = true;
			removeDuplicates(str, idx + 1, newStr.append(currChar), map);
		}
	}
	
	//Friends Paring Problem
	public static int friendsPairing(int n) {
		//Base case
		if (n == 1 || n == 2)
			return n;
		
//		//single
//		int fnm1 = friendsPairing(n - 1);
//		
//		//pair
//		int fnm2 = friendsPairing(n - 2);
//		int pairWays = (n -  1) * fnm2;
//		
//		//Total ways
//		int totWays = fnm1 + pairWays;
		return friendsPairing(n - 1) + (n - 1) * friendsPairing(n - 2);
	}
	
	//Binary String Problem
	public static void printBinStrings(int n, int lastPlace, String str) {
		//Base class
		if (n == 0) {
		System.out.println(str);
		return;
		}
		
		printBinStrings(n - 1, 0, str + "0");
		
		if (lastPlace == 0)
			//sit 0 on chair n
			printBinStrings(n - 1, 1, str + "1");
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 3, 4, 5};
//		printInc(5);
//		printDec(10);
//		System.out.println(fact(5));
//		System.out.println(isSorted(arr, 2));
//		System.out.println(firstOccurence(arr,3, 3));
//		System.out.println(lastOccurence(arr,3, 3));
//		System.out.println(power(3, 5));
//		System.out.println(optimizedPower(2, 9));
//		System.out.println(tilingProblem(5));
//		String str  = "appnnaaacollege";
//		removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
//		System.out.println(friendsPairing(3));
		printBinStrings(3, 0, "");
	}

}
