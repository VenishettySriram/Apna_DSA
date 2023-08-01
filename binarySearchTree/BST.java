package binarySearchTree;

import java.util.ArrayList;

public class BST {
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node (int data) {
			this.data = data;
		}
	}
	public static Node insert(Node root, int val) {
		if (root == null) {
			root = new Node(val);
			return root;
		}
		if (root.data > val) {
			//left subtree
			root.left = insert(root.left, val);
		}
		else {
			//right subtree
			root.right = insert(root.right, val);
		}
		return root;
	}
	
	public static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public static void preorder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static boolean search(Node root, int key) { //O(H) (H-Height of tree)
		if (root == null)
			return false;
		if (root.data == key)
			return true;
		if (root.data > key)
			return search (root.left, key);
		else
			return search (root.right, key);
	}
	
	public static Node delete (Node root, int val) {
		if (root.data < val) {
			root.right = delete(root.right, val);
	}
		else if (root.data > val) {
			root.left = delete(root.left, val);
		}
		else {//voila
			//case 1 - leaf node
			if (root.left == null && root.right == null)
				return null;
			//case 2 - single child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			//case 3 = both children
			Node IS = findInorderSuccessor(root.right);
			root.data = IS.data;
			root.right = delete(root.right, IS.data);
		}
		return root;
	}
		public static Node findInorderSuccessor (Node root) {
			while (root.left != null)
				root = root.left;
			return root;
		}
		
		public static void printInRange(Node root, int k1, int k2) {
		    if (root == null)
		        return;

		    if (root.data > k1) {
		        printInRange(root.left, k1, k2);
		    }

		    if (root.data >= k1 && root.data <= k2) {
		        System.out.print(root.data + " ");
		    }

		    if (root.data < k2) {
		        printInRange(root.right, k1, k2);
		    }
		}
		
		public static void printPath(ArrayList<Integer> path) {
			for (int i = 0; i < path.size(); i++)
				System.out.print(path.get(i) + "->");
			System.out.println("Null");
		}
		
		public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
			if (root == null)
				return;
			path.add(root.data);
			if (root.left == null && root.right == null)
				printPath(path);
			printRoot2Leaf(root.left, path);
			printRoot2Leaf(root.right, path);
			path.remove(path.size() - 1);
		}
		
		public static boolean isValidBST(Node root, Node min, Node max) {
			if (root == null)
				return true;
			if (min != null && root.data <= min.data)
				return false;
			else if (max != null && root.data >= max.data)
				return false;
			return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
		}
		
		public static Node createMirror(Node root) { // O(n)
			if (root == null)
				return null;
			Node leftMirror = createMirror(root.left);
			Node rightMirror = createMirror(root.right);
			root.left = rightMirror;
			root.right = leftMirror;
			return root;
		}
		
		public static Node createBST(int arr[], int st, int end) { //Sorted Array to Balanced BST
			if (st > end)
				return null;
			int mid = (st + end) / 2;
			Node root = new Node(arr[mid]);
			root.left = createBST(arr, st, mid - 1);
			root.right = createBST(arr, mid + 1, end);
			return root;
		}
		
		public static void getInorder(Node root, ArrayList<Integer> inorder) {
			if (root == null)
				return;
			getInorder(root.left, inorder);
			inorder.add(root.data);
			getInorder(root.right, inorder);
		}
		
		public static Node balanceBST(Node root) {
			// Inorder sequence
			ArrayList<Integer> inorder = new ArrayList<>();
			getInorder(root, inorder);
			//sorted Inorder -> Balanced BST
			root = createBST2(inorder, 0, inorder.size() - 1);
			return root;
		}
		
		public static Node createBST2(ArrayList<Integer> inorder, int st, int end) {
			if (st > end) 
				return null;
			int mid = (st + end) / 2;
			Node root = new Node(inorder.get(mid));
			root.left = createBST2(inorder, st, mid - 1);
			root.right = createBST2(inorder, mid + 1, end);
			return root;
		}
		
	public static void main(String[] args) {
		int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
		Node root = null;
		
		for (int i = 0; i < values.length; i++) {
			root = insert(root, values[i]);
		}
//		inorder(root);
//		System.out.println();
//		System.out.println(search(root, 7));
//		root = delete(root, 5);
//		inorder(root);
//		printInRange(root, 4, 11);
//		ArrayList <Integer> path = new ArrayList <Integer>();
//		printRoot2Leaf(root, path);
//		System.out.println(isValidBST(root, null, null));
//		createMirror(root);
//		inorder(root);
//		System.out.println();
		Node root1 = new Node(8);
		root1.left = new Node(6);
		root1.left.left = new Node(5);
		root1.left.left.left = new Node(3);
		root1.right = new Node(10);
		root1.right.right = new Node(11);
		root1.right.right.right = new Node(12);
		/*
		 		8
		 	   / \
		 	  6  10
		 	 /    \
		 	5	   11
		   /		\
		  3			 12
		  given BST
		 */
		
//		int arr[] = {3, 5, 6, 8, 10, 11, 12};
//		root1 = createBST(arr, 0, arr.length - 1);
		preorder(root1);
		System.out.println();
		root1 = balanceBST(root1);
		preorder(root1);
		System.out.println();
	}
}
