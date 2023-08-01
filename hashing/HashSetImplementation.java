package hashing;
import java.util.*;
public class HashSetImplementation {
	public static void main(String[] args) {
		HashSet <Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		System.out.println(set);
		if(set.contains(2))
			System.out.println("set contain 2");
		set.remove(2);
		if (!set.contains(2))
			System.out.println("set does not contain 2");
		System.out.println(set.size());
		set.clear();
		System.out.println(set);
		System.out.println(set.isEmpty());
	}
}
