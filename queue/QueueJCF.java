package queue;
import java.util.*;
public class QueueJCF {
	public static void main(String[] args) {
		//Queue q = new Queue();
		Queue <Integer> q = new LinkedList<>(); //ArrayDequeue
		q.add(1);
		q.add(2);
		q.add(3);
		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}
	}
}
