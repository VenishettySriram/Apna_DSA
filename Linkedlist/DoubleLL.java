package Linkedlist;

public class DoubleLL {
	public class Node {
		int data;
		Node prev;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}
	public static Node head;
	public static Node tail;
	public int size;
	
	//add
	public void addFirst(int data) {
		Node newNode = new Node(data);
		size++;
		if (head == null) {
			head = tail = newNode;
			return;
		}
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}
	
	public void addLast(int data) {
		size++;
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
		}
		newNode.prev = tail;
		tail.next = newNode;
		tail = newNode;
	}
	
	public int removeFirst() {
		if (head == null) {
			System.out.println("DLL is empty");
			return Integer.MIN_VALUE;
		}
		if (size == 1) {
			int val = head.data;
			head = tail = null;
			size--;
			return val;
		}
		int val = head.data;
		head = head.next;
		size--;
		return val;
	}
	
	public  int removeLast() {
		if (head == null) {
			System.out.println("DLL is empty");
			return Integer.MIN_VALUE;
		}
		if (size == 1) {
			int val = head.data;
			head = tail = null;
			size--;
			return val;
		}
		int val = tail.data;
		tail.prev.next = null;
		size--;
		return val;
	}
	
	public void reverse() {
		Node curr = head;
		Node prev = null;
		Node next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			curr.prev = next;
			prev = curr;
			curr = next;
		}
		head = prev;
	}	
	
	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "<->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	public static void main(String[] args) {
		DoubleLL dll = new DoubleLL();
		dll.addFirst(0);
		dll.addFirst(1);
		dll.addFirst(2);
		dll.addLast(3);
		dll.addLast(5);
		System.out.println(dll.removeFirst());
		System.out.println(dll.removeLast());
		dll.print();
		dll.reverse();
		dll.print();
//		System.out.println(dll.size);
	}
}