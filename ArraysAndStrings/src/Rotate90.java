import java.util.HashSet;
import java.util.Set;


public class Rotate90 {

	public static int[][] rotate(int[][] image, int n) {
		
		for(int i=0;i<n/2;i++) {
			//save top
			int offset = n -1 -i;
			int top[] = image[i];
			for(int j=i;j<offset;j++) {
				image[i][offset-j]= image[j][i];
				image[j][i] = image[offset-i][j];
				image[offset-i][j] = image[offset-j][offset-i];
				image[offset-j][offset -i] = top[offset-j];
			}
		}
		return image;
	}
	
	public static int[][] setZeros(int[][] matrix, int size) {
		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> cols = new HashSet<Integer>();
		
		
		for(int row =0 ; row < size; row++) {
			for(int col=0;col<size; col++) {
				if(matrix[row][col] == 0) {
					rows.add(row);
					cols.add(col);
				}
			}
		}
		
		for(Integer c: cols) {
			for(int i=0;i<size;i++) {
				matrix[i][c] = 0;
			}
		}
		
		for(Integer r: rows) {
			for(int i=0;i<size;i++) {
				matrix[r][i] = 0;
			}
		}
		
		return matrix;
	}
	
	public static void printImage(int image[][], int n) {
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				System.out.print(image[i][j]+"\t");
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		int image[][] = new int[4][4];
		for(int i=0;i<16;i++) 
			image[(int)Math.floor(i/4)][i%4] = i + 1;
		
		printImage(image, 4);
		//image[1][3] = 0;
		image[2][2] = 0;
		printImage(setZeros(image,4), 4);
	}
}
