
public class ReverseCStyle {
	
	public static String reverse(String word) {
		//Leave the delimitor in this place
		
		if(word == null || word.length() == 1)
			return word;
		
		StringBuilder newWord = new StringBuilder();
		char[] wordArray= word.toCharArray();
		for(int i = (word.length() - 2); i>=0; i--) {
			newWord.append(wordArray[i]);
		}
		
		newWord.append(wordArray[wordArray.length - 1]);
		
		return newWord.toString();
		
	}
	
	public static String reverseWithoutUsingDS(String word) {
		
		if(word == null || word.length() == 1) {
			return word;
		}
		char[] wordArray = word.toCharArray();

		char temp;
		int wordLength = wordArray.length - 2;
		for(int i=0; i<= wordLength/2;i++) {
			temp = wordArray[i];
			wordArray[i] = wordArray[wordLength -i];
			wordArray[wordLength - i] = temp;
		}
		
		return new String(wordArray);
	}
	
	public static void reversePrint(String word) {
		System.out.println("The reverse of "+word+ " is "+reverseWithoutUsingDS(word));
	}
	
	public static void main(String[] args) {
	
		reversePrint("abcd.");
		reversePrint("aabb.");
		reversePrint(".");
		reversePrint("thisisa random.");
		reversePrint("a.");
		
	}

}
