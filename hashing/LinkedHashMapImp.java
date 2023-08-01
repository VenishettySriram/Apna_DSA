package hashing;
import java.util.*;
public class LinkedHashMapImp {
	public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
		lhm.put("India", 100);
		lhm.put("China", 150);
		lhm.put("USA", 50);
		lhm.put("Nepal", 5);
		System.out.println(lhm);
	}
}
