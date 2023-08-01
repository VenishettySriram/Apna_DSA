package Linkedlist;

public class LinkedList {
	public static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	public static Node head;
	public static Node tail;
	public static int size;
	public void addFirst(int data) {
		//step1 = create new node
		size++;
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
			return;
		}
		//step2 = newNode next = head
		newNode.next = head;
		
		//step3 = head = newNode
		head = newNode;
	}
	public void addLast(int data) {
		size++;
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
			return;
		}
		tail.next = newNode;
		tail = newNode;
	}
	public void add(int index, int data) {
		if (index == 0) {
			addFirst(data);
			return;
		}
		Node newNode = new Node(data);
		Node temp = head;
		int i = 0;
		while(i < index - 1) {
			temp = temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		size++;
	}
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;		
			}
		System.out.println("null");
	}
	public int removeFirst() {
		if (size == 0) {
			System.out.println("Linked List is empty");
			return Integer.MIN_VALUE;
		}
		else if (size == 1) {
			int val = head.data;
			head = tail = head.next;
			size = 0;
			return val;
		}
		int val = head.data;
		head = head.next;
		size--;
		return val;
	}
	
	public int removeLast() {
		if (size == 0) {
			System.out.println("Linked List is empty");
			return Integer.MIN_VALUE;
		}
		else if (size == 1) {
			int val = head.data;
			head = tail = head.next;
			return val;
		}
		//prev : i = size - 2
		Node prev = head;
		for (int i = 0; i < size - 2; i++) {
			prev = prev.next;
		}
		int val = prev.next.data; //tail.data
		prev.next = null;
		tail = prev;
		size--;
		return val;
	}
	
	public int itrSearch(int key) {
		Node temp = head;
		int i = 0;
		while(temp != null) {
			if (temp.data == key)
				return i; //key found
			temp = temp.next;
			i++;
		}
		return -1; //key not found
	}
	public int helper(Node head, int key) {
		if (head == null) {
			return -1;
		}
		if (head.data == key)
			return 0;
		int index = helper(head.next, key);
		if (index == -1)
			return -1;
		return index + 1;
	}
	public int recSearch(int key) {
		return helper(head, key);
	}
	
	public void reverse() {
		Node prev = null;
		Node curr = tail = head;
		Node next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	public void deleteNthfromEnd(int n) {
		//calculate size
		int size = 0;
		Node temp = head;
		while(temp != null) {
			temp = temp.next;
			size++;
		}
		if (n == size) {
			head = head.next; //remove First
			return;
		}
		//size - n
		int i = 1;
		int iToFind = size - n;
		Node prev = head;
		while(i < iToFind) {
			prev = prev.next;
			i++;
		}
		prev.next = prev.next.next;
		return;
	}
	//Slow Fast Approach
	public Node findMid(Node head) {
		Node slow = head; //turtle
		Node fast = head; //hare
		
		while (fast != null && fast.next != null) {
			slow = slow.next; //+1
			fast = fast.next.next; //+2
		}
		return slow;
	}
	
	public boolean checkPalindrome() {
		if (head == null || head.next == null)
			return true;
		//step1 - find mid
		Node midNode = findMid(head);
		
		//step2 - reverse 2nd half
		Node prev = null;
		Node curr = midNode;
		Node next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		Node right = prev; // right half head
		Node left = head;
		
		//step3 - check left half and right half
		while(right != null) {
			if (left.data != right.data)
				return false;
			left = left.next;
			right = right.next;
		}
		return true;
	}
	public static boolean isCycle() {
		Node slow = head;
		Node fast  = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next; // +1
			fast = fast.next.next;  // +2
			if (slow == fast)
				return true; // cycle exists
		}
		return false; //cycle doesn't exists
	}
	
	public static void removeCycle() {
		//detect cycle
		Node slow = head;
		Node fast = head;
		boolean cycle = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				cycle =  true;
				break;
			}
		}
		if (cycle == false)
			return;
		
		//find meeting point
		slow = head;
		Node prev = null;
		while (slow != fast) {
			prev = fast;
			slow = slow.next;
			fast = fast.next;
		}
		//remove cycle -> last.next = null
		prev.next = null;
	}
	
	private Node getMid(Node head) {
		Node slow = head;
		Node fast = head.next;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow; //mid
	}
	
	private Node merge(Node head1, Node head2) {
		Node mergedLL = new Node(-1);
		Node temp = mergedLL;
		while(head1 != null && head2 != null) {
			if (head1.data <= head2.data) {
				temp.next = head1;
				head1 = head1.next;
				temp = temp.next;
			}
			else {
				temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
			}
		}
		while (head1 != null) {
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		while (head2 != null) {
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		return mergedLL.next;
	}
	
	public Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		//find mid
		Node mid = getMid(head);
		//left & right MS
		Node rightHead = mid.next;
		mid.next = null;
		Node newLeft = mergeSort(head);
		Node newRight = mergeSort(rightHead);
		
		//merge
		return merge(newLeft, newRight);
	}
	
	
	public void zigZag() {
		//find mid
		 Node slow = head;
		 Node fast = head.next;
		 while (fast != null && fast.next != null) {
			 slow = slow.next;
			 fast = fast.next.next;
		 }
		 Node mid = slow;
		 //reverse 2nd half
		 Node curr = mid.next;
		 mid.next = null;
		 Node prev = null;
		 Node next;
		 while (curr != null) {
			 next = curr.next;
			 curr.next = prev;
			 prev = curr;
			 curr = next;
		 }
		 Node left = head;
		 Node right = prev;
		 Node nextL, nextR;
		 //alternate merge zig-zag merge
		 while (left != null && right != null) {
			 nextL = left.next;
			 left.next = right;
			 nextR = right.next;
			 right.next = nextL;
			 left = nextL;
			 right = nextR;
		 }
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(0);
		ll.addFirst(5);
		ll.print();
//		ll.removeFirst();
//		ll.removeLast();
//		ll.print();
//		ll.add(1, 5);
//		ll.add(0, 4);
//		ll.print();
//		System.out.println(ll.size);
//		System.out.println(ll.itrSearch(5));
//		System.out.println(ll.itrSearch(11));
//		System.out.println(ll.recSearch(5));
//		ll.reverse();
//		ll.print();
//		ll.deleteNthfromEnd(2);
//		ll.print();
//		System.out.println(ll.checkPalindrome());
//		head = new Node(1);
//		Node temp = new Node(2);
//		head.next = temp;
//		head.next.next = new Node(3);
//		head.next.next.next = temp;
//		System.out.println(isCycle());
//		removeCycle();
//		System.out.println(isCycle());
//		ll.head = ll.mergeSort(ll.head);
//		ll.print();
		ll.zigZag();
		ll.print();
	}
}