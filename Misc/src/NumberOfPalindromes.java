
public class NumberOfPalindromes {

	public static int numberOfPal(String word) {
		int numberOfPal = 0;
		char[] wordArr = word.toCharArray();
		
		for(int i=1;i<wordArr.length - 1; i++) {
			int left = i-1;
			int right =i+1;
			while(left >=0 && right < wordArr.length && wordArr[left] == wordArr[right]) {
				left--;
				right++;
				numberOfPal++;
			}
			
		}
		
		for(int j=0;j<wordArr.length;j++) {
			int left = j-1;
			int right = j;
			
			while(left>=0 && right <wordArr.length && wordArr[left] == wordArr[right]) {
				left--; right++; numberOfPal++;
				System.out.println("->" + left+" "+right);
			}
			
			
		}
		
		return numberOfPal;
	}
	
	public static void main(String[] args) {
		System.out.println(numberOfPal("abbaata"));
	}
}
