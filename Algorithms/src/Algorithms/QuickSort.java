/*
 * This is an algorithm for quick sort
 * The basic premise of quick sort is that: 
 * An element is in a sorted position if all elements to the right are greater
 * and all elements to the left are less
 * This is similar to merge sort in that we continuously split up the array into smaller chunks
 * 
 * For any array, quick sort takes the first element, and sets it as the pivot. 
 * tracker1 starts at an element next to the first element
 * The last element is the largest element in the list, and is used as tracker 2
 * tracker1 moves until it finds an element smaller than the pivot, while
 * tracker2 moves until it finds an element larger than the pivot. 
 * The two elements at tracker1 and tracker2 are swapped every time this happens. 
 * If tracker1 becomes greater than tracker2, that means that all necessary switches have been conducted
 * and we swap the pivot with tracker2. We also return tracker2. 
 */


package Algorithms;

public class QuickSort {

	public static void main(String[] args) {
		
		//create a random array
		int[] arr = new int[] {3, 2, 6, 7, 89, 1, 4, 5, 8, 9, 23, 76, 89, 23, 45, 23, 45, 90, 100, 32, 890, 345, 234, 543, 23241};
		printArray(arr);
		
		//for quick sort, we must make sure that the last element of the array
		//is greater than the rest.
		//we will make a temp array that is one size larger than the original,
		//with the last element being the largest integer.
		int[] temp = new int[arr.length + 1];
		
		//copy elements over
		for(int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		temp[temp.length - 1] = Integer.MAX_VALUE;
		
		//perform quicksort on temp array
		quickSort(temp, 0, temp.length - 1);
		
		//copy elements back into arr
		for(int i = 0; i < arr.length; i++) {
			arr[i] = temp[i];
		}
		
		printArray(arr);

	}
	
	//Recursive Function that splits the array up.
	public static void quickSort(int[] arr, int low, int high) {
		
		//we've reached a single element and can return
		if(low == high) return;
		
		//move the first element into the sorted position
		int pivotIndex = setPivot(arr, low, high);
		
		//perform quicksort again from low to pivot
		//pivot + 1 to high
		quickSort(arr, low, pivotIndex);
		quickSort(arr, pivotIndex + 1, high);
		
	}
	
	public static int setPivot(int[] arr, int low, int high) {
		
		int pivotValue = arr[low];
		int tracker1 = low;
		int tracker2 = high;
		
		//increment tracker1 until it reaches an index with a value less than pivot
		//decrement tracker2 until it reaches an index with a value greater than pivot
		//swap the elements and repeat until tracker1 fully surpasses tracker2. 
		while(tracker1 <= tracker2) {
			do { tracker1++;} while(arr[tracker1] <= pivotValue);
			do { tracker2--;} while(arr[tracker2] > pivotValue);
			if(tracker1 <= tracker2) swap(arr, tracker1, tracker2);

		}
		
		//swap the element at tracker2 with the pivotValue
		//return the index where the pivot value now is. 
		swap(arr, low, tracker2);
		return tracker2;
		
		
	}
	
	public static void swap(int[] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
	
	//print our array
	public static void printArray(int[] arr) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	

}
