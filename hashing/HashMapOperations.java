package hashing;
import java.util.*;
public class HashMapOperations {
	public static void main(String[] args) {
		//Create
		HashMap<String, Integer> hm = new HashMap<>();
		//Insert - O(1)
		hm.put("India", 100);
		hm.put("China", 150);
		hm.put("USA", 50);
		System.out.println(hm);
		
		//Get - O(1)
		int population = hm.get("India");
		System.out.println(population);
		System.out.println(hm.get("Indonesia"));
		
		//Contains Key - O(1)
		System.out.println(hm.containsKey("India"));
		System.out.println(hm.containsKey("Indonesia"));
		
		//Remove - O(1)
		System.out.println(hm.remove("China"));
		System.out.println(hm);
		System.out.println(hm.remove("Indonesia"));
		
		//Size
		System.out.println(hm.size());
		
		//isEmpty
		System.out.println(hm.isEmpty());
		
		//Clear
		hm.clear();
		System.out.println(hm);
	}
}