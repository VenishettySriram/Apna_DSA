package Sorting;

public class DividenConquer {
	
	public static void printArr(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	//Merge Sort
	public static void mergeSort(int arr[], int si, int ei) {
		if (si >= ei) {
			return;
		}
		int mid = si + (ei - si) / 2; //(si + ei) / 2
		mergeSort(arr, si, mid); // left part
		mergeSort(arr, mid + 1, ei); // right part
		merge(arr, si, mid, ei);
	}
	
	public static void merge(int arr[], int si, int mid, int ei) {
	// left(0, 3) = 4 right(4, 6) = 3 ||| size of array => 6 - 0 + 1 = 7 ie.; ei - si + 1
		int temp[] = new int[ei - si + 1];
		int i = si; //Iterator for left part
		int j = mid + 1; //Iterator for right part
		int k = 0; // Iterator for temp array
		
		while ( i <= mid && j <= ei) {
			if (arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
			}
			else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		//left part
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		//right part
		while (j <= ei) {
			temp[k++] = arr[j++];
		}
		
		//copy temp to original array
		for (k = 0, i = si; k < temp.length; k++, i++) {
			arr[i] = temp[k];
		}
	}
	
	//Quick Sort
	public static void quickSort(int arr[], int si, int ei) {
		if (si >= ei)
			return;
		//last element
		int pIdx = partition(arr, si, ei);
		quickSort(arr, si, pIdx - 1); //left
		quickSort(arr, pIdx + 1, ei); //right
	}
	
	public static int partition(int arr[], int si, int ei) {
		int pivot= arr[ei];
		int i = si - 1; //to make place for elements smaller than pivot
		
		for (int j = si; j < ei; j++) {
			if (arr[j] <= pivot) {
				i++;
				//swap
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		i++;
		//swapping pivot to its correct index
		int temp = pivot;
		arr[ei] = arr[i];
		arr[i] = temp;
		return i;
	}
	//Search in Sorted and Rotated Array
	public static int search(int arr[], int tar, int si, int ei) {
		if (si > ei)
			return -1;
		int mid = si + (ei - si) / 2;
		if (arr[mid] == tar)
			return mid;
		
		//mid on L1
		if (arr[si]<= arr[mid]) {
			//case a : left
			if (arr[si] <= tar && tar <= arr[mid]) {
				return search(arr, tar, si, mid);
			}
			else {
				//case b : right
				return search (arr, tar, mid + 1, ei);
			}
		}
		//mid on L2
		else {
			//case c : right
			if (arr[mid] <= tar && tar <= arr[ei]) {
				return search(arr, tar, mid + 1, ei);
			}
			else {
				//case d : left
				return search(arr, tar, si, mid - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 0, 1, 2};
		int target = 0; // output should be 4
		int tarIdx = search(arr, target, 0, arr.length - 1);
		System.out.println(tarIdx);
	}
}