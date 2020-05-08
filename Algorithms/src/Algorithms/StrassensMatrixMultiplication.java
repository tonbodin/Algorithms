
/*
 * Multiplying two matrices only works if the number of rows in the first matrix
 * is equivalent to the number of columns in the second matrix.
 * 
 * In Strassen's Matrix Multiplication, we must use square matrices that have
 * dimensions of a power of two, starting with 2 x 2. 
 * 
 * The simplest case is a 2 x 2 matrix multiplied by a 2 x 2 matrix.
 * 
 * For large matrices, we must split up the matrices into four quadrants, and perform
 * matrix multiplication with the four quadrants as a whole, recursively. 
 * 
 * So Far, I only have the code of iterative matrix multiplication.x
 */

package Algorithms;

public class StrassensMatrixMultiplication {
	
	public static void main(String[] args) {
		int[][] mat1 = new int[][] {{3, 4}, 
									{4, 5}};
		int[][] mat2 = new int[][] {{8, 3},
									{6, 2}};
									
		print2DArray(iterativeMM(mat1, mat2));
	}
	
	//iterative method to perform matrix multiplication
	//number of columns in mat1 must be equal to number of rows in mat2
	public static int[][] iterativeMM(int[][] mat1, int[][] mat2){
		
		int[][] result = new int[mat1.length][mat2[0].length];
		for(int i = 0; i < mat1.length; i++) {
			for(int j = 0; j < mat2[0].length; j++){
				result[i][j] = 0;
				for(int k = 0; k < mat1[0].length; k++) {
					result[i][j] += (mat1[i][k] * mat2[k][j]);
				}
			}
		}
		
		return result;
		
	}
	
	//Steps for Recursive Function
	public static int[][] mM(int[][] mat1, int[][] mat2, int[][] result, int n){
		
		return new int[12][2];
		
		
	}
	
	public static void print2DArray(int[][] mat) {
		for(int[] i: mat) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
}
