package hashing;
import java.util.*;
public class IteratorHashSet {
	public static void main(String[] args) {
		HashSet <String> cities = new HashSet<>();
		cities.add("Delhi");
		cities.add("Mumbai");
		cities.add("Noida");
		cities.add("Bengaluru");
		//Using Iterators
		Iterator<String> it = cities.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println();
		
		//Using Enhanced for loop (Advanced for loop)
		for(String city : cities) {
			System.out.print(city + ", ");
		}
		System.out.println();
	}
}
