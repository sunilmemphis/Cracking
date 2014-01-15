
public class BaseMinus2 {
	public static String convertToBase2(int number) {
		StringBuilder base2 = new StringBuilder();	
		// 
		
		while(number !=0) {
			int reminder = (int) (Math.abs(number % (-2)));
			number = (number - reminder) / (-2);
			base2.insert(0, reminder);
			
			
		}
		
		
		
		return base2.toString();
		
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(convertToBase2(6));
	}
	
	
}
