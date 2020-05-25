
/*
 * In an undirected node graph, we will keep track of connections through a matrix, 
 * where the indices are the nodes and the values are the weight of the edges between nodes
 * Assume that a edge value of 0 indicates that the two nodes are not connected.
 * 
 * Using prim's algorithm, we will construct a minimum spanning tree that connects all n nodes 
 * with n-1 edges. We will start with a root node and continuously add the next adjacent edge
 * with the minimum weight, assuming that this connection does not form a cycle.
 * 
 *  Assume that all weights are positive. 
 */


package Algorithms;

public class Prims {

	public static void main(String[] args) {
		
		//Create a sample undirected graph
		int[][] graph = new int[][] {{0, 4, 0, 0, 0, 0, 0, 8, 0},
									 {4, 0, 8, 0, 0, 0, 0, 11, 0},
									 {0, 8, 0, 7, 0, 4, 0, 0, 2},
									 {0, 0, 7, 0, 9, 14, 0, 0, 0},
									 {0, 0, 0, 9, 0, 10, 0, 0, 0},
									 {0, 0, 4, 14, 10, 0, 2, 0, 0},
									 {0, 0, 0, 0, 0, 2, 0, 1, 6},
									 {8, 11, 0, 0, 0, 0, 1, 0, 7},
									 {0, 0, 2, 0, 0, 0, 6, 7, 0}};
										
		
									 
		int[][] result = prims(graph);
		
		
		print2DArray(result);
		
		System.out.println(sum2DArray(result));
		
		
		
		

	}
	
	
	//method that will perform prims and return a spanning tree. 
	public static int[][] prims(int[][] graph) {
		
		//Displays the minimum spanning tree
		int[][] minSpanTree = new int[graph.length][graph.length];
		
		//keeps track of the next edge with the lowest weight
		int[] minAdjEdge = new int[graph.length];
		
		//keeps track of which edge the node is connected to
		int[] connected = new int[graph.length];
		
		//so far, the shortest edge to each node is infinite
		//we will update these values with actual weights when we reach them. 
		for(int i = 0; i < minAdjEdge.length; i++) {
			minAdjEdge[i] = Integer.MAX_VALUE;
		}
		
		//indicate that the root node has already been chosen.
		minAdjEdge[0] = -1;
		
		
		
		//keeps track of the recent node
		int recentNode = 0;
		
		
		//traverse and update
		for(int i = 0; i < graph.length - 1; i++) {
			
			int index = -1;
			int minWeight = Integer.MAX_VALUE;
			
			
			for(int j = 0; j < graph.length; j++) {
				
				if(minAdjEdge[j] != -1) {
					int temp = graph[recentNode][j];
					
					if(temp != 0 && temp < minAdjEdge[j]) {
						minAdjEdge[j] = temp;
						connected[j] = recentNode;
					}
					
					if(minAdjEdge[j] < minWeight) {
						index = j;
						minWeight = minAdjEdge[j];
					}
				}
				
			}
			
			minSpanTree[connected[index]][index] = minWeight;
			
			minAdjEdge[index] = -1;
			
			
			recentNode = index;
			
		}
		
		return minSpanTree;
		
	}
	
	public static void print2DArray(int[][] arr) {
		for(int[] i: arr) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	public static int sum2DArray(int[][] arr) {
		
		int sum = 0;
		
		for(int[] i: arr) {
			for(int j : i) {
				sum += j;
			}
		}
		
		return sum;
	}

}
