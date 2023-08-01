package arraylist;

import java.util.*;

public class PairSum {
	public static boolean pairsum(ArrayList <Integer> list, int target) {
		int lp = 0;
		int rp = list.size() - 1;
		while(lp < rp) {
			//case 1
			if (list.get(lp) + list.get(rp) == target)
				return true;
			//case 2
			else if (list.get(rp) + list.get(lp) < target)
				lp++;
			//case 3
			else
				rp--;
		}
		return false;
	}
	public static void main(String[] args) {
		ArrayList <Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		int target = 6;
		System.out.println(pairsum(list, target));
	}
}
