/*
 * The greedy algorithm for the Knapsack Problem goes as follows:
 * We have a bag that can hold a certain capacity of objects
 * We have objects with a certain amount of weight and profit.
 * We have to meet the capacity requirement and maximize profit. 
 * 
 * Notice: This only works for fractional knapsack problems. 
 * 
 * The strategy here is to take the objects with the highest profit per weight and put them in the bag first. 
 */

package Algorithms;

import java.io.*;
import java.util.*;

public class KnapsackGreedy {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//process the weights and profits into arrays using a scanner
		//process capacity of the bag into 
		File weightList = new File("C:\\Users\\tonbo\\Documents\\weights.txt");
		File profitList = new File("C:\\Users\\tonbo\\Documents\\profits.txt");
		File capacityFile = new File("C:\\Users\\tonbo\\Documents\\capacity.txt");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(weightList);

		ArrayList<Integer> weights = new ArrayList<Integer>();
		ArrayList<Integer> profits = new ArrayList<Integer>();
		
		while(sc.hasNext()) {
			int weight = sc.nextInt();
			weights.add(weight);
		}
		
		sc = new Scanner(profitList);
		
		while(sc.hasNext()) {
			int profit = sc.nextInt();
			profits.add(profit);
		}
		
		sc = new Scanner(capacityFile);
		int cap = sc.nextInt();
		
		//Array of Indexes from greatest to least profit per weight rate (lesser weight is the tiebreaker)
		ArrayList<Integer> order = new ArrayList<Integer>();
		
		ArrayList<Integer> profitClone = new ArrayList<Integer>();
		for(int i : profits) {
			profitClone.add(i);
		}
		
		for(int i = 0; i < profitClone.size(); i++) {
			int greatestRateInd = greatestRate(weights, profitClone);
			order.add(greatestRateInd);
			profitClone.set(greatestRateInd, -1);
		}
		
		int counter = 0;
		double[] knapSack = new double[weights.size()];
		
		while(counter < weights.size()){
			int nextWeight = weights.get(order.get(counter));
			if(cap - nextWeight < 0 ) {
				knapSack[order.get(counter)] = (double)cap/(double)nextWeight;
				break;
			}
			
			knapSack[order.get(counter)] = 1;
			cap -= weights.get(order.get(counter));
			counter++;
		}
		
		printArray(knapSack);
	}
	
	//return the index of the greatest rate
	public static int greatestRate(ArrayList<Integer> weights, ArrayList<Integer> profits) {
		
		double maxRate = Double.MIN_VALUE;
		int index = 0;
		
		
		for(int i = 0; i < weights.size(); i++) {
			double rate = (double) profits.get(i) / (double) weights.get(i);
			
			if(rate > maxRate || (rate == maxRate && weights.get(i) <= weights.get(index))) {
				index = i;
				maxRate = rate;
			}
		}
		
		return index;
	}
	
	public static void printArray(double[] arr) {
		for(double i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
