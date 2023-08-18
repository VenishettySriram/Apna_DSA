package segmentTrees;

public class BuildST {
	static int tree[];
	public static void init(int n) {
		tree = new int[4 * n];
	}
	
	public static int buildST(int arr[], int i, int start, int end) { //O((n)	
		if (start == end) 
			return tree[i] = arr[start];

		int mid = (start + end) / 2;
		buildST(arr, 2 * i + 1, start, mid); //left subtree = 2 * i + 1
		buildST(arr, 2 * i + 2, mid + 1, end); //left subtree = 2 * i + 2
		return tree[i] = (tree[2 * i + 1] + tree[2 * i + 2]);
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5 ,6 ,7, 8};
		int n = arr.length;
		init(n);
		buildST(arr, 0, 0, n - 1);
		for (int i = 0; i < tree.length; i++)
			System.out.print(tree[i] + " ");
		System.out.println();
	}
}
