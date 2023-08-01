package stack;
import java.util.Stack;
public class NextGreaterEle {
	public static void main(String[] args) {
		int arr[] = {6, 8, 0, 1, 3};
		Stack <Integer> s = new Stack <Integer>();
		int nxtGret[] = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			//Step 1
			while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
				s.pop();
			}
			//Step 2
			if (s.isEmpty())
				nxtGret[i] = -1;
			else
				nxtGret[i] = arr[s.peek()];
			//Step 3
			s.push(i);
		}
		for (int i = 0; i < nxtGret.length; i++) {
			System.out.print(nxtGret[i] + " ");
		}
		System.out.println();
	}
}
