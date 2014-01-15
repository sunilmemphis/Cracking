
public class PrintSpiral {

	public static void printspiral(int[][] matrix, int size) {
		for(int layer=0;layer<=size/2;layer++) {
			int left = layer;
			int right = size - layer - 1;
			
			if(left == right) {
				System.out.print(matrix[left][left]);
				return;
			}
			
			for(int i=left;i<right;i++) {
				System.out.print(matrix[left][i]);
			}
			
			for(int i = left; i < right;i++) {
				System.out.print(matrix[i][right]);
			}
			
			for(int i= right; i > left;i--) {
				System.out.print(matrix[right][i]);
			}
			
			for(int i= right; i > left;i--) {
				System.out.print(matrix[i][left]);
			}
			
		}
	}
	
	public static void main(String[] args) {
		int matrix[][] = { {1,2,3},{4,5,6},{7,8,9}};
		printspiral(matrix, 3);
	}
}
