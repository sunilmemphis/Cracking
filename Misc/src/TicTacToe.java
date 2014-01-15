public class TicTacToe {
	public static boolean wonBy(int matrix[][], int owner) {
		
		int row[] = new int[3];
		int col[] = new int[3];
		
		for(int i=0;i<3;i++) {
			row[i] = 0;
			col[i] = 0;
		}
		
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				row[i] += matrix[i][j];
				col[i] += matrix[j][i];
			}
		}

		int leftDiag = 0;
		int rightDiag = 0;
		
		for(int i=0;i<3;i++) {
			leftDiag += matrix[i][i];
			rightDiag += matrix [i][2-i];
		}
		
		for(int i=0;i<3;i++) {
			if(row[i] == 3 * owner || col[i] == 3*owner)
				return true;
		}
		
		if(leftDiag == 3 * owner || rightDiag == 3*owner)
			return true;
		
		return false;
	}
	
	
	public static void main(String[] args) {
		int matrix[][] = {{1,0,10},{1,1,1},{10,10,10}};
		
		System.out.println((wonBy(matrix, 10) ^ wonBy(matrix, 1)));
		
	}
}
