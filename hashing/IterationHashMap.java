package hashing;
import java.util.*;
public class IterationHashMap {
	public static void main(String[] args) {
		//Create
		HashMap<String, Integer> hm = new HashMap<>();
		//Insert - O(1)
		hm.put("India", 100);
		hm.put("China", 150);
		hm.put("USA", 50);
		hm.put("Indonesia", 6);
		hm.put("Nepal", 5);
		System.out.println(hm);
		
		//Iterate
		Set<String> keys = hm.keySet();
		System.out.println(keys);
		for (String k : keys) {
			System.out.println("key = " + k + ", value = " + hm.get(k));
		}
	}
}
