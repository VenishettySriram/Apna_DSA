package Sorting;
import java.util.Arrays;
import java.util.Collections;

public class BasicSorting{
	
	//Selcetion Sort
	public static void selectionSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int minPos = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minPos] > arr[j]) {
					minPos = j;
				}
			}
			int temp = arr[minPos];
			arr[minPos] = arr[i];
			arr[i] = temp;
		}
	}
	
	//Bubble Sort
	public static void bubbleSort(int arr[]) {
		for (int turn = 0; turn < arr.length - 1; turn++) {
			for (int j = 0; j < arr.length - 1 - turn; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	//Insertion Sort
	public static void insertionSort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int curr = arr[i];
			int prev = i - 1;
			//finding the correct postion to insert
			while(prev >= 0 && arr[prev] > curr) {
				arr[prev + 1] = arr[prev];
				prev--;
			}
			//insertion
			arr[prev + 1] = curr;
		}
	}
	//Counting Sort
	public static void countingSort(int arr[]) {
		int largest = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			largest = Math.max(largest, arr[i]);
		}
		int count[] = new int[largest + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		//sorting
		int j = 0;
		for (int i = 0; i < count.length; i++) {
			while(count[i] > 0) {
				arr[j] = i;
				j++;
				count[i]--;
			}
		}
	}
	
	public static void printArr(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
		
	public static void main(String[] args) {
		int[] arr = {5, 4, 1, 3, 2};
		selectionSort(arr);
		printArr(arr);
	}
}
