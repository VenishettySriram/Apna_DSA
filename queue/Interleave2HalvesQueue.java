package queue;
import java.util.*;
public class Interleave2HalvesQueue {
	public static void interLeave(Queue<Integer> q) {
		Queue<Integer> firstHalf = new LinkedList<>();
		int size = q.size() / 2;
		for (int i = 0; i < size; i++) {
			firstHalf.add(q.remove());
		}
		for (int i = 0; i < size; i++) {
			q.add(firstHalf.remove());
			q.add(q.remove());
		}
	}
	public static void main(String[] args) {
		Queue <Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);
		q.add(8);
		q.add(9);
		q.add(10);
		interLeave(q);
		System.out.println(q);
	}
}
