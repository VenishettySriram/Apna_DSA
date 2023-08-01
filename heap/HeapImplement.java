package heap;
import java.util.*;
public class HeapImplement {
	static class Heap {
		ArrayList <Integer> arr = new ArrayList<>();
		public void add(int data) { //O(log n)
			//add at last index
			arr.add(data);
			int x = arr.size() - 1; //x is child index
			int par = (x - 1) / 2; //parent index
			while (arr.get(x) < arr.get(par)) { // O(log n)
				//swap
				int temp = arr.get(x);
				arr.set(x, arr.get(par));
				arr.set(par, temp);
				x = par;
				par = (x - 1) / 2;
			}
		}
		
		public int peek() {
			return arr.get(0);
		}
		
		public int remove() {
			//step 1: swap last and first
			int data = arr.get(arr.size() - 1);
			arr.set(arr.size() - 1, arr.get(0));
			arr.set(0, data);
			//step 2: delete last
			arr.remove(arr.size() - 1);
			//step 3: heapify
			heapify(0);
			return data;
		}
		
		private void heapify(int i) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			int minIdx = i;
			if (left < arr.size() && arr.get(minIdx) > arr.get(left))
				minIdx = left;
			if (right < arr.size() && arr.get(minIdx) > arr.get(right))
				minIdx = right;
			if (minIdx != i) {
				//Swap
				int temp = arr.get(i);
				arr.set(i, arr.get(minIdx));
				arr.set(minIdx, temp);
				heapify(minIdx);
			}
		}
		
		public boolean isEmpty() {
			return arr.size() == 0;
		}
		
	}
	
	public static void main(String[] args) {
		Heap h = new Heap();
		h.add(3);
		h.add(4);
		h.add(1);
		h.add(5);
		
		while (!h.isEmpty()) {
			System.out.println(h.peek());
			h.remove();
		}
	}
}