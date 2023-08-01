package queue;
import java.util.Deque;
import java.util.*;
public class DoubleEndedQueue {
	public static void main(String[] args) {
		Deque<Integer> deque = new LinkedList<>();
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addLast(3);
		System.out.println(deque);
		System.out.println(deque.getFirst());
		System.out.println(deque.getLast());
		deque.removeFirst();
		deque.removeLast();
		System.out.println(deque);
	}
}
