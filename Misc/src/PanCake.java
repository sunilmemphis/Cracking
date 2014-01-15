
public class PanCake {
	public static int findMax(int[] matrix, int n) {
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		
		for(int i=0;i<n;i++) 
			if(matrix[i] > max) {
				max = matrix[i];
				maxIndex = i;
			}
		
		return maxIndex;
	}
	
	public static int[]	 swap(int[] matrix, int n) {
		
		for(int i=0;i< (n+1)/2;i++) {
			int temp = matrix[i];
			matrix[i] = matrix[n -i];
			matrix[n-i] = temp;
		}
		
		return matrix;
	}
	
	public static int[] pancakeSort(int[] matrix, int n) {
		for(int i=1;i<n;i++) {
			int maxElement = findMax(matrix,n-i);
			matrix = swap(matrix,maxElement);
			matrix = swap(matrix,n-i);
		}
		return matrix;
	}
	
	public static void printArray(int[] array) {
		for(int i : array) 
			System.out.print(i+ " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] matrix = {10,4,2,9,1,4};
		printArray(matrix);
		printArray(pancakeSort(matrix, matrix.length));
		
	}
}
