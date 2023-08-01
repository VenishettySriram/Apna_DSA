package hashing;
import java.util.*;
public class CountDistinctEle {
	public static void main(String[] args) {
		int nums[] = {4, 3, 2, 5, 6, 7, 3	, 4, 2, 1};
		HashSet<Integer> hs = new HashSet<>();
		for (int ele : nums) {
			hs.add(ele);
		}
		System.out.println(hs.size());
	}
}
