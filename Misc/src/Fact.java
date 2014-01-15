
public class Fact {
	public static int noOfZeros(int num) {
		int numberOfZeros = 0;
		
		for(int i=1;i<=num;i++) {
			if(i % 5 == 0) {
				int noPowerFive= 1;
				while(num>Math.pow(5,noPowerFive) && (num % Math.pow(5,noPowerFive)) == 0) {
					noPowerFive++;
				}
				System.out.println(noPowerFive);
				numberOfZeros+=noPowerFive;
			}
		}
		
		return numberOfZeros;
	}
	
	public static void main(String[] args) {
		System.out.println(noOfZeros(26));
	}
}
