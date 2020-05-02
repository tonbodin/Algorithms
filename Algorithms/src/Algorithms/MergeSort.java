/*
 * Merge Sort is an ingenious method to sort an array
 * It continuously splits an array in half until it
 * becomes a group of singular array elements. 
 * 
 * Then, using the merge sort algorithm, where you
 * combine two sorted arrays into one sorted array, 
 * you merge all of the components together into one sorted array. 
 */


package Algorithms;

public class MergeSort {

	public static void main(String[] args) {
		
		//set up a random array
		int[] arr = new int[] {3, 2, 6, 7, 1, 4, 5, 8, 9, 23, 76, 89, 23, 45, 23, 45, 90, 100, 32, 890, 345, 234, 543, 23241};
		
		printArray(arr);
		mergeSort(arr, 0, arr.length - 1);
		printArray(arr);

	}
	
	//Recursive method where we split the array into its individual components
	public static void mergeSort(int[] arr, int low, int high) {
		
		
		//if the array is larger than 
		//a single element in size
		if(low < high) {
			//split the array in half
			int mid = (low + high)/2;
			
			//perform mergeSort on each half of the array
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			
			//merge the two halves together
			merge(arr, low, high);
		}
		
	}
	
	//Iteratively merge the array from index low to high
	public static void merge(int[] arr, int low, int high) {
		
		//Split the range in half, and create two arrays
		//We have to merge these two arrays
		int mid = (low + high) / 2;
		
		//find size of first and second half array
		int size1 = mid - low + 1;
		int size2 = high - mid;
		
		//create the two arrays
		int[] firstH = new int[size1];
		int[] secondH = new int[size2];
		
		//create a temporary array to store the sorted values
		int[] sortedArray = new int[size1 + size2];
		
		//input elements into each array
		for(int i = 0; i < size1; i++) {
			firstH[i] = arr[low + i];
		}
		
		for(int i = 0; i < size2; i++) {
			secondH[i] = arr[mid + 1 + i];
		}
		
		//trackers to keep track of the index for each array
		//set tracker1 for firstH array
		//set tracker2 for secondH array
		//set trackerS for sorted array
		int tracker1 = 0;
		int tracker2 = 0;
		int trackerS = 0; 
		
		//iteratively compare corresponding elements in the two arrays
		//fill up the created sorted array
		while(tracker1 < size1 && tracker2 < size2) {
			if(firstH[tracker1] <= secondH[tracker2]) {
				sortedArray[trackerS] = firstH[tracker1];
				tracker1++;
			} else {
				sortedArray[trackerS] = secondH[tracker2];
				tracker2++;
			}
			
			trackerS++;
		}
		
		//fill up the remaining slots
		for(; tracker1 < size1; tracker1++, trackerS++) {
			sortedArray[trackerS] = firstH[tracker1];
		}
		
		for(; tracker2 < size2; tracker2++, trackerS++) {
			sortedArray[trackerS] = secondH[tracker2];
		}
		
		//input the sorted array into the segment of the merge. 
		for(int i = 0; i < sortedArray.length; i++) {
			arr[low + i] = sortedArray[i];
		}
		
	}
	
	public static void printArray(int[] arr) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
