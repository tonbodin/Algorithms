/*
 * Search a sorted array for the index of a value by continuously halving the search radius 
 * until the element is found. 
 * 
 * Both the Iterative and Recursive Methods will be utilized. 
 */


package Algorithms;

public class BinarySearch {

	public static void main(String[] args) {
		
		//Creating a random sorted array
		
		int[] arr = new int[] {1, 3, 6, 8, 12, 15, 18, 23, 26, 29, 34, 36, 39, 41, 42, 43, 46, 47, 50};
		
		System.out.println(recBinSearch(arr, 42, 0, arr.length - 1));

	}
	
	
	public static int iterBinSearch(int[] arr, int val) {
		
		int l = 0;
		int h = arr.length - 1;
		int mid;
		
		while (l <= h) {
			mid = (l + h) / 2;
			
			if(arr[mid] == val) {
				return mid;
			} else if(arr[mid] > val) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		return -1;
		
	}
	
	public static int recBinSearch(int[] arr, int val, int low, int high) {
		
		int mid = (low + high)/2;
		
		if(arr[mid] == val) {
			return mid;
		}
		
		if(arr[mid] > val) {
			return recBinSearch(arr, val, low, mid - 1);
		}
		
		return recBinSearch(arr, val, mid + 1, high);
		
	}

}
