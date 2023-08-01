package backtracking;

public class Permutations {
	public static void main(String[] args) {
		String str = "abc";
		findPermutation(str, "");
	}
	public static void findPermutation(String str, String ans) {
		//Base case
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		//recursion
		for (int i = 0; i < str.length(); i++) {
			char curr = str.charAt(i);
			//"abcde" => "ab" + "de" = "abde"
			String str1 = str.substring(0, i) + str.substring(i + 1);
			findPermutation(str1, ans + curr);
		}
	}
}
