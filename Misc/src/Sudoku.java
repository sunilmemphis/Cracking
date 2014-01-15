import java.util.BitSet;


public class Sudoku {

	public static boolean sudokuSolver(int[][] matrix, int size) {
		if(size% 3 !=0)
			return false;
		
		BitSet[] rows = new BitSet[size];
		BitSet[] cols = new BitSet[size];
		
		for(int i=0;i<size;i++) {
			rows[i] = new BitSet();
			cols[i] = new BitSet();
		}
		
		for(int rowNo=0; rowNo < size; rowNo++) {
			for(int colNo = 0 ; colNo < size; colNo++) {
				int value = matrix[rowNo][colNo];
				if(value > size)
					return false;
				if(rows[rowNo].get(value) || cols[colNo].get(value)) 
					return false;
				else {
					rows[rowNo].set(value);
					cols[colNo].set(value);
				
				}
				
			}
			
		}
		
		for(int boxRow =0; boxRow < size /3; boxRow++) {
			for(int boxCol = 0; boxCol < size/3;boxCol++) {
				BitSet box = new BitSet();
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						if(box.get(matrix[boxRow*3 + i][boxCol*3 + j]))
							return false;
						else 
							box.set(matrix[boxRow*3 + i][boxCol*3 + j]);
					}
				}
				
				
			}
		}
		
		
		
		return true;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3}, {2,3,1},{3,1,2}};
		int[][] matrix2 = {{1,2,3,4,5,6,7,9,8},
				{4,5,6,7,8,9,1,2,3},
				{7,8,9,2,3,1,4,5,6},
				{2,1,4,5,6,8,9,3,7},
				{3,6,5,9,2,7,8,1,4},
				{8,9,7,1,4,3,2,6,5},
				{5,7,2,3,9,4,6,8,1},
				{9,4,8,6,1,5,3,7,2},
				{6,3,1,8,7,2,5,4,9}};
		
		int[][] invalidSoln = {{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9}};
		System.out.println(sudokuSolver(invalidSoln, 9));
	}
	
}
