package hashing;
import java.util.*;
public class UnionAndIntersection {
	public static void main(String[] args) {
		int arr1[] = {7, 3, 9};
		int arr2[] = {6, 3, 9, 2, 9, 4};
		HashSet <Integer> hs = new HashSet<>();
		//Union
		for (int ele : arr1)
			hs.add(ele);
		for (int ele : arr2)
			hs.add(ele);
		System.out.println("Union = " + hs.size());
		//Intersection
		hs.clear();
		for (int ele : arr1)
			hs.add(ele);
		int count = 0;
		for (int ele : arr2) {
			if (hs.contains(ele))
				count++;
			hs.remove(ele);
		}
		System.out.println("Intersection = " + count);
	}
}
