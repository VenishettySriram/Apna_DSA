package greedyAlgo;
import java.util.*;
public class ActivitySelection {
	public static void main(String[] args) {
		int start[] = {1,3, 0, 5, 8, 5};
		int end[] = {2, 4, 6, 7, 9, 9};
		//sorting
		int activites[][] = new int [start.length][3];
		for (int i = 0; i < end.length; i++) {
			activites[i][0] = i;
			activites[i][1] = start[i];
			activites[i][2] = end[i];
		}
		//lambda function -> shortform
		Arrays.sort(activites, Comparator.comparingDouble(o -> o[2]));
		
		//end time sorted array
		int maxAct = 0;
		ArrayList <Integer> ans = new ArrayList <Integer>();
		ans.add(activites[0][0]);
		maxAct = 1;
		int lastEnd = activites[0][2];
		for (int i = 1; i < end.length; i++) {
			if (activites[i][1] >= lastEnd) {
				//activity select
				maxAct++;
				ans.add(activites[i][0]);
				lastEnd = activites[i][2];
			}
		}
		System.out.println("Maximum activites : " + maxAct);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print("A" + ans.get(i) + " ");
		}
		System.out.println();
	}
}