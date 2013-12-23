
public class Rotate90 {

	public static int[][] rotate(int[][] image, int n) {
		
		for(int i=0;i<n/2;i++) {
			//save top
			
			int[] top = image[0];
			
			for(int j=i;j<n-i;j++) {
			
				//left -> top
				
				//top -> right
			
				//right -> down
			
				// down -> left
			
			}
			
			
			
			
		}
		
		
		return image;
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
			image[(int)Math.floor(i/4)][i%4] = i;
		
		printImage(image, 4);
	}
}
