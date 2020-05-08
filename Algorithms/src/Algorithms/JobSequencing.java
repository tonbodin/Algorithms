
/* Job Sequencing using Greedy Algorithm
 * Given a list of jobs to be done with profits and deadline for each job,
 * assume each job takes 1 hour to complete.
 * 
 * Arrange a time slot such that profit is maximized. 
 */

package Algorithms;

import java.io.*;
import java.util.*;

public class JobSequencing {

	public static void main(String[] args) throws FileNotFoundException {

		File profitList= new File("C:\\Users\\tonbo\\Documents\\job_profit.txt");
		File deadlineList = new File("C:\\Users\\tonbo\\Documents\\deadline.txt");
		
		ArrayList<Integer> profits = new ArrayList<Integer>();
		ArrayList<Integer> deadlines = new ArrayList<Integer>();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(profitList);
		
		while(sc.hasNext()) {
			int tempP = sc.nextInt();
			profits.add(tempP);
		}
		
		sc = new Scanner(deadlineList);
		
		int maxDeadline = -1;
		
		while(sc.hasNext()) {
			int tempD = sc.nextInt();
			if(tempD > maxDeadline) {
				maxDeadline = tempD;
			}
			deadlines.add(tempD);
		}
		
		int[] timeSlots = new int[maxDeadline];
		
		//index from greatest to least profit
		int[] order = new int[profits.size()];
		
		for(int i = 0; i < timeSlots.length; i++) {
			timeSlots[i] = -1;
		}
		
		ArrayList<Integer> profitsCopy = new ArrayList<Integer> ();
		
		for(int i : profits) {
			profitsCopy.add(i);
		}
		
		for(int i = 0; i < profitsCopy.size(); i++) {
			int temp = indexGreatestProfit(profitsCopy);
			order[i] = temp;
			profitsCopy.set(temp, -2);
		}
		
		int counter = 0;
		int tracker = 0;
		int sumProfit = 0;
		while(counter < timeSlots.length) {
			int profitT = profits.get(order[tracker]);
			int deadlineT = deadlines.get(order[tracker]);
			
			for(int i = deadlineT - 1; i >= 0; i--) {
				if(timeSlots[i] == -1) {
					timeSlots[i] = order[tracker];
					sumProfit += profitT;
					counter++;
					break;
				}
			}
			tracker++;
		}
		
		System.out.println(sumProfit);
		
		printArray(timeSlots);
		
		printArray(order);
		
		

	}
	
	public static int indexGreatestProfit(ArrayList<Integer> profitsCopy) {
		int max = -1;
		int index = 0;
		for(int i = 0; i < profitsCopy.size(); i++) {
			if(max < profitsCopy.get(i)) {
				max = profitsCopy.get(i);
				index = i;
			}
		}
		return index;
	}
	
	public static void printArray(int[] arr) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
