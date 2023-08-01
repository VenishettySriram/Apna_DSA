package hashing;
import java.util.*;
public class LinkedHashSetImp {
	public static void main(String[] args) {
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("Delhi");
		lhs.add("Mumbai");
		lhs.add("Noida");
		lhs.add("Bengaluru");
		System.out.println(lhs);
	}
}
