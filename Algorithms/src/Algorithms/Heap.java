/*
 * This class will go over heap algorithms, a heap is an specialized binary tree-based structure
 * that satisfies the heap invariant, which for a maxHeap, requires that a parent node is greater 
 * than its two child nodes. 
 * 
 * We will go over Heap Sort, which is a way of transferring elements of an array into a maxHeap and 
 * then removing the elements correspondingly to sort the array. 
 * 
 * We will also go over heapify, which is a simple and easy way of transferring elements of a random array 
 * into a max Heap. 
 * 
 */




package Algorithms;

public class Heap {
	
	
	public static void main(String[] args) {
		//Creating a random unsorted array 
		int[] arr = new int[] {5, 3, 2, 4, 1, 10, 19, 67, 89, 45, 23, 21};
		
		heapify(arr);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		heapSort(arr, arr.length - 1);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void heapify(int[] arr) {
		for(int i = arr.length - 1; i >= 0; i--) {
			sink(arr, i, arr.length - 1);
		}
	}
	
	//helper method of heapify and heapSort
	//if the parent node is smaller than any of its two children 
	//swap the larger of the two children with the parent.
	public static void sink(int[] arr, int index, int furthestChild) {
		int leftIndex = index * 2 + 1;
		int rightIndex = index * 2 + 2;
		
		if(leftIndex > furthestChild) return;
		
		int greaterChildIndex = leftIndex;
		
		int leftValue = arr[leftIndex];
		int rightValue = Integer.MIN_VALUE;
		
		if(rightIndex <= furthestChild) {
			rightValue = arr[rightIndex];
		}
		
		if(arr[index] < leftValue || arr[index] < rightValue) {
			
			if(rightValue > leftValue) {
				greaterChildIndex = rightIndex;
			} 
			
			swap(arr, index, greaterChildIndex);
			sink(arr, greaterChildIndex, furthestChild);
		}
		
		return;
	}
	
	public static void swap(int[] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
	
	//Heap Sort recursive method
	public static void heapSort(int[] arr, int lastInd) {
		if(lastInd == 0) return;
		
		swap(arr, 0, lastInd);
		sink(arr, 0, lastInd - 1);
		
		heapSort(arr, lastInd - 1);
	}
	
}
